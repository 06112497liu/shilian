/**
 * BBD Service Inc
 * All Rights Reserved @2017
 */
package com.bbd.service.reddata.company.impl;

import com.bbd.Constants;
import com.bbd.bean.LatLng;
import com.bbd.bean.biz.AddrPointInfo;
import com.bbd.bean.company.CompanyInfoEsVO;
import com.bbd.bean.company.CompanyInfoVo;
import com.bbd.bean.statistics.NameValueInfo;
import com.bbd.common.AbnormalType;
import com.bbd.common.CacheConstants;
import com.bbd.controller.param.CompanyAddrInfoVO;
import com.bbd.controller.param.MannualRemindConditionParam;
import com.bbd.dao.*;
import com.bbd.dao.company.CompanyExtDao;
import com.bbd.domain.*;
import com.bbd.exception.BizErrorCode;
import com.bbd.service.reddata.addr.IAddressService;
import com.bbd.service.reddata.company.CompanyUtil;
import com.bbd.service.reddata.company.ICompanyService;
import com.bbd.service.reddata.message.BBDMessageService;
import com.bbd.service.reddata.remind.ICompanyRemindService;
import com.bbd.service.reddata.remind.param.AbnormalRemindCompanyVO;
import com.bbd.service.reddata.remind.param.AnnualRemindCompanyVO;
import com.bbd.service.reddata.remind.param.CompanyRemindCount;
import com.bbd.service.reddata.remind.param.RemindCompanyVO;
import com.bbd.service.reddata.statistics.ICompanyStatisticsService;
import com.bbd.service.reddata.vo.BBDCompanyAddrVO;
import com.bbd.util.ValidateUtil;
import com.bbd.utils.BBDUtil;
import com.bbd.utils.CompanyHelper;
import com.bbd.utils.PageListHelper;
import com.exception.ApplicationException;
import com.exception.CommonErrorCode;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.mybatis.domain.PageBounds;
import com.mybatis.domain.PageList;
import com.mybatis.domain.Paginator;
import com.utils.BeanMapperUtil;
import org.apache.commons.lang.StringUtils;
import org.joda.time.DateTime;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

/**
 * 企业接口
 *
 * @author liuweibo
 * @version $Id: CompanyServiceImpl.java, v 0.1 2017年5月4日 下午2:29:37 liuweibo Exp $
 */
@Service
public class CompanyServiceImpl implements ICompanyService {

    @Resource
    CompanyEsSearchServiceImpl             companyEsSercherService;
    @Resource
    ICompanyRemindService                  companyRemindService;
    @Resource
    AbnormalCompanyInfoDao                 abnormalCompanyInfoDao;
    @Resource
    ICompanyStatisticsService              companyStatisticsService;
    @Resource
    IndexRecruitInfoDao                    indexRecruitInfoDao;
    @Resource
    IndexPurchaseInfoDao                   indexPurchaseInfoDao;
    @Resource
    private CompanyExtDao                  companyExtDao;
    @Resource
    private AnnualReportInfoDao            annualReportInfoDao;
    @Resource
    private CompanyUtil                    companyUtil;
    @Resource
    private IAddressService                addressService;
    @Resource
    private BusinessRecordsInfoDao         businessRecordsInfoDao;

    @Resource
    private EnterpriseInfoDao              enterpriseInfoDao;

    @Resource
    private BBDMessageService              bbdMessageService;

    @Resource
    private BusinessMonthStatisticsInfoDao monthStatisticsInfoDao;

    /**
     * 根据失联企业名称属性分页查询
     *
     * @param companyName 失联企业名称
     * @return List<CompanyInfoVo> list对象企业
     */
    @Override
    @Transactional
    public PageList<CompanyInfoEsVO> findPage(String companyName, PageBounds pb) {

        // 构建ES查询条件
        Map<String, Object> matchMap = Maps.newHashMap();
        Map<String, Object> keyMap = Maps.newHashMap();

        // 公司名称模糊查询条件
        matchMap.put("companyName", companyName);

        // 过滤个体户和农专社
        keyMap.put("companyPropoerty", Arrays.asList(1, 2, 3));

        PageList<CompanyInfoEsVO> pageList = companyEsSercherService.search(matchMap, keyMap, null, pb, CompanyInfoEsVO.class);

        return pageList;

    }

    /**
     * 根据企业内部序号获取企业异常类型
     */
    @Override
    public Set<Integer> getAbnormalTypeBynbxh(String nbxh) {
        AbnormalCompanyInfoExample example = new AbnormalCompanyInfoExample();
        AbnormalCompanyInfoExample.Criteria criteria = example.createCriteria();
        criteria.andNbxhEqualTo(nbxh).andDeleteFlagEqualTo(0);
        Set<Integer> result = Sets.newHashSet();
        List<AbnormalCompanyInfo> infos = abnormalCompanyInfoDao.selectByExample(example);
        for (AbnormalCompanyInfo info : infos) {
            result.add(info.getType());
        }
        return result;
    }

    /**
     * 根据企业nbxh查找企业具体信息
     *
     * @param nbxh 企业nbxh
     * @return CompanyInfoVo 企业信息
     */
    @Override
    @Cacheable(value = CacheConstants.COMPANY_INFO, keyGenerator = "simpleKeyGenerator")
    public CompanyInfoVo getByNbxh(String nbxh) {
        Preconditions.checkArgument(StringUtils.isNotBlank(nbxh), "内部序号不能为空");
        EnterpriseInfo info = doGetByNbxh(nbxh);

        //企业工商信息
        CompanyInfoVo companyInfoVo = BeanMapperUtil.map(info, CompanyInfoVo.class);

        //从经营异常表查询该企业的异常类型
        if (companyInfoVo != null) {
            // 企业异常类型
            Integer abnormalStatus = info.getAbnormalState();
            Set<Integer> types = getAbnoramlTypes(abnormalStatus);
            companyInfoVo.setAbnormalType(types);
            if (types.size() > 0) {
                Date at = getAbnormalTime(nbxh);
                companyInfoVo.setGmtAbnormalTime(at);
            }
            // 企业性质
            Integer cp = info.getCompanyProperty();
            String cpDesc = companyUtil.getCompanyPropertyMap().get(cp.toString());
            companyInfoVo.setCompanyPropertyDesc(cpDesc);
        }
        return companyInfoVo;
    }

    private Date getAbnormalTime(String nbxh) {
        AbnormalCompanyInfoExample exam = new AbnormalCompanyInfoExample();
        exam.createCriteria().andNbxhEqualTo(nbxh).andDeleteFlagEqualTo(0);
        List<AbnormalCompanyInfo> ds = abnormalCompanyInfoDao.selectByExample(exam);
        AbnormalCompanyInfo item = Collections.min(ds, new Comparator<AbnormalCompanyInfo>() {
            @Override
            public int compare(AbnormalCompanyInfo o1, AbnormalCompanyInfo o2) {
                return o1.getGmtCheckin().compareTo(o2.getGmtCheckin());
            }
        });
        return item.getGmtCheckin();
    }

    /**
     * 获取异常类型列表
     *
     * @param abnormalStatus
     * @return
     */
    private Set<Integer> getAbnoramlTypes(Integer abnormalStatus) {
        Set<Integer> types = Sets.newHashSet();
        if (abnormalStatus == null) {
            return types;
        }
        if (CompanyHelper.isUnannualed(abnormalStatus)) {
            types.add(AbnormalType.UNANNUALED);
        }
        if (CompanyHelper.isUnpublish(abnormalStatus)) {
            types.add(AbnormalType.UNPUBLISHED);
        }
        if (CompanyHelper.isFake(abnormalStatus)) {
            types.add(AbnormalType.FAKE);
        }
        if (CompanyHelper.isLost(abnormalStatus)) {
            types.add(AbnormalType.LOST);
        }
        return types;
    }

    private EnterpriseInfo doGetByNbxh(String nbxh) {
        EnterpriseInfoExample exam = new EnterpriseInfoExample();
        exam.createCriteria().andNbxhEqualTo(nbxh);
        List<EnterpriseInfo> ds = enterpriseInfoDao.selectByExample(exam);
        if (ds.size() == 0) {
            throw new ApplicationException(CommonErrorCode.PARAM_ERROR);
        }
        return ds.get(0);
    }

    /**
     * 查询企业经营活动编号的集合
     */
    @Override
    public Set<Integer> getBusinessRecord(String nbxh, int year, int month) {
        BusinessRecordsInfoExample exam = new BusinessRecordsInfoExample();
        exam.createCriteria().andNbxhEqualTo(nbxh).andActivityYearEqualTo(year).andActivityMonthEqualTo(month);

        Set<Integer> result = Sets.newHashSet();
        List<BusinessRecordsInfo> ds = businessRecordsInfoDao.selectByExample(exam);
        if (ds.size() == 0) {
            return result;
        }

        for (BusinessRecordsInfo d : ds) {
            result.add(d.getContentType());
        }

        return result;
    }

    /**
     * 查询第一产业维度
     */
    @Override
    public List<NameValueInfo> getPrimaryIndustry() {
        Map<String, String> map = companyUtil.getPrimaryIndustryMap();
        return transfer(map);
    }

    private List<NameValueInfo> transfer(Map<String, String> map) {
        List<NameValueInfo> infos = new ArrayList<>();
        for (Map.Entry<String, String> e : map.entrySet()) {
            NameValueInfo info = new NameValueInfo();
            info.setName(e.getKey());
            info.setValue(e.getValue());
            infos.add(info);
        }

        return infos;
    }

    /**
     * 查询企业类型（1 民营企业 2 国有企业 3 外资企业 ）
     */
    @Override
    public List<NameValueInfo> getCompanyTypes() {
        Map<String, String> map = companyUtil.getCompanyPropertyMap();
        Map<String, String> m = Maps.newHashMap();

        List<String> enterpriseList = Lists.newArrayList("1", "2", "3");
        for (Map.Entry<String, String> e : map.entrySet()) {
            if (enterpriseList.contains(e.getKey())) {
                m.put(e.getKey(), e.getValue());
            }
        }

        List<NameValueInfo> infos = transfer(m);
        return infos;
    }

    /**
     * 查询企业经营活动项目，共下拉列表使用
     */
    @Override
    public List<NameValueInfo> getBusinessTypes() {
        Map<String, String> btMap = companyUtil.getBusinessTypeMap();
        List<NameValueInfo> infos = transfer(btMap);

        Collections.sort(infos, new Comparator<NameValueInfo>() {
            @Override
            public int compare(NameValueInfo o1, NameValueInfo o2) {
                return (Integer.valueOf(o1.getName().toString())).compareTo(Integer.valueOf(o2.getName().toString()));
            }
        });

        return infos;
    }

    /**
     * 查询年报提示企业列表信息
     */
    @Override
    public List<AnnualRemindCompanyVO> getAnnualList(MannualRemindConditionParam param, PageBounds page) {
        // 构建查询条件
        EnterpriseInfoExample example = new EnterpriseInfoExample();
        EnterpriseInfoExample.Criteria criteria = example.createCriteria();
        if (param.getCompanyName() != null) {
            criteria.andCompanyNameLike("%" + param.getCompanyName() + "%");
        }
        if (!param.getDistrict().equals("5201")) {
            criteria.andDistrictEqualTo(param.getDistrict());
        }
        if (param.getPrimaryIndustry() != null) {
            criteria.andPrimaryIndustryInitialEqualTo(param.getPrimaryIndustry());
        }
        Double from = param.getIndexScoreFrom();
        Double to = param.getIndexScoreTo();
        if (from != null || to != null) {
            from = from == null ? 0d : from;
            to = to == null ? 100d : to;
            criteria.andIndexScoreBetween(from, to);
        }
        criteria.andAnnualStateEqualTo(2).andStatusEqualTo(0);

        // 执行查询
        List<EnterpriseInfo> dbList = enterpriseInfoDao.selectByExampleWithPageBounds(example, page);

        // 处理结果
        List<AnnualRemindCompanyVO> resultList = BeanMapperUtil.mapList(dbList, AnnualRemindCompanyVO.class);

        buildAnnualEmsAndPhones(dbList, resultList);
        buildDescription(resultList);
        buildRemindState(resultList);
        buildLastAnnualInfo(resultList);
        buildLastSendTime(resultList);

        //    处理分页信息
        Paginator paginator = PageListHelper.getPaginator(dbList);
        PageList<AnnualRemindCompanyVO> results = PageListHelper.create(resultList, paginator);

        return results;
    }

    /**
     * 构建页面显示电话和邮箱（年报）
     *
     * @param dbList
     * @param resultList
     */
    private void buildAnnualEmsAndPhones(List<EnterpriseInfo> dbList, List<AnnualRemindCompanyVO> resultList) {

        Map<String, List<String>> emails = Maps.newHashMap();
        Map<String, List<String>> phones = Maps.newHashMap();

        for (EnterpriseInfo info : dbList) {
            String nb = info.getNbxh();
            String em = info.getAnnualEmails();
            String ph = info.getAnnualPhones();
            List<String> ems = Lists.newArrayList();
            List<String> phs = Lists.newArrayList();
            if (em != null)
                ems.add(em);
            if (ph != null)
                phs.add(ph);

            List<String> bbdEms = bbdMessageService.getBBDEmails(nb);
            List<String> bbdPhs = bbdMessageService.getBBDSms(nb);

            ems.addAll(bbdEms);
            phs.addAll(bbdPhs);

            emails.put(nb, ems);
            phones.put(nb, phs);
        }

        for (AnnualRemindCompanyVO vo : resultList) {
            String nb = vo.getNbxh();
            List<String> ems = emails.get(nb);
            List<String> phs = phones.get(nb);
            if (ems != null && !ems.isEmpty())
                vo.setEmails(ems.get(0));
            if (phs != null && !phs.isEmpty())
                vo.setPhones(phs.get(0));

        }
    }

    /**
     * 构建页面显示电话和邮箱（异常）
     *
     * @param dbList
     * @param resultList
     */
    private void buildAbnormalEmsAndPhones(List<CompanyInfo> dbList, List<AbnormalRemindCompanyVO> resultList) {
        Map<String, List<String>> emails = Maps.newHashMap();
        Map<String, List<String>> phones = Maps.newHashMap();

        for (CompanyInfo info : dbList) {
            String nb = info.getNbxh();
            String em = info.getAnnualEmails();
            String ph = info.getAnnualPhones();
            List<String> ems = Lists.newArrayList();
            List<String> phs = Lists.newArrayList();
            if (em != null)
                ems.add(em);
            if (ph != null)
                phs.add(ph);

            List<String> bbdEms = bbdMessageService.getBBDEmails(nb);
            List<String> bbdPhs = bbdMessageService.getBBDSms(nb);

            ems.addAll(bbdEms);
            phs.addAll(bbdPhs);

            emails.put(nb, ems);
            phones.put(nb, phs);
        }

        for (AbnormalRemindCompanyVO vo : resultList) {
            String nb = vo.getNbxh();
            List<String> ems = emails.get(nb);
            List<String> phs = phones.get(nb);
            if (ems != null && !ems.isEmpty())
                vo.setEmails(ems.get(0));
            if (phs != null && !phs.isEmpty())
                vo.setPhones(phs.get(0));
        }
    }

    /**
     * 查询异常企业列表信息
     */
    @Override
    public List<AbnormalRemindCompanyVO> getAbnormalList(MannualRemindConditionParam param, int abnormalState, PageBounds page) {
        // 构建查询条件
        Map<String, Object> map = Maps.newHashMap();
        if (param.getCompanyName() != null) {
            map.put("companyName", "%" + param.getCompanyName() + "%");
        }
        if (!param.getDistrict().equals("5201")) {
            map.put("district", param.getDistrict());
        }
        if (param.getPrimaryIndustry() != null) {
            map.put("primaryIndustry", param.getPrimaryIndustry());
        }
        Double from = param.getIndexScoreFrom();
        Double to = param.getIndexScoreTo();
        if (from != null || to != null) {
            from = from == null ? 0d : from;
            to = to == null ? 100d : to;
            map.put("indexScoreFrom", from);
            map.put("indexScoreTo", to);
        }
        map.put("abnormalState", abnormalState);

        List<CompanyInfo> dbList = companyExtDao.selectAbnormalCompanyInfo(map, page);

        // 处理结果
        List<AbnormalRemindCompanyVO> resultList = BeanMapperUtil.mapList(dbList, AbnormalRemindCompanyVO.class);

        buildAbnormalEmsAndPhones(dbList, resultList);
        buildDescription(resultList);
        buildRemindState(resultList);
        buildLastAbnormalInfo(resultList, abnormalState);
        buildLastSendTime(resultList);

        // 处理分页信息
        Paginator paginator = PageListHelper.getPaginator(dbList);
        PageList<AbnormalRemindCompanyVO> results = PageListHelper.create(resultList, paginator);

        return results;
    }

    /**
     * 将行业和地址转化为中文
     */
    private <T extends RemindCompanyVO> void buildDescription(List<T> resultList) {
        Map<String, String> piMap = companyUtil.getPrimaryIndustryMap();
        Map<String, String> dsMap = addressService.getDistrictCodeMap(Constants.GUIYANG_CODE);
        for (RemindCompanyVO vo : resultList) {
            String industry = vo.getPrimaryIndustryInitial();
            if (StringUtils.isNotBlank(industry)) {
                vo.setPrimaryIndustryDesc(piMap.get(industry));
            }
            String district = vo.getDistrict();
            vo.setDistrictDesc("贵州省贵阳市" + dsMap.get(district));
        }
    }

    /**
     * 根据企业内部序号查询企业提示数量统计
     */
    private <T extends RemindCompanyVO> void buildRemindState(List<T> list) {
        for (RemindCompanyVO vo : list) {
            List<CompanyRemindStatisticsInfo> dbList = companyRemindService.getCompanyRemindStatisticsInfos(vo.getNbxh());
            CompanyRemindCount remindCount = new CompanyRemindCount();
            if (dbList.size() > 0) {
                CompanyRemindStatisticsInfo dbResult = dbList.get(0);
                Integer emailCount = dbResult.getMailFail() + dbResult.getMailSuccess();
                Integer smsCount = dbResult.getMsgFail() + dbResult.getMsgSuccess();
                remindCount.setEmailCount(emailCount);
                remindCount.setSmsCount(smsCount);
                remindCount.setEmailStatus(dbResult.getMailSuccess() > 0 ? 1 : 2);
                remindCount.setSmsStatus((dbResult.getMsgSuccess() > 0 ? 1 : 2));
            }
            vo.setRemindCount(remindCount);
        }
    }

    /**
     * 根据企业nbxh查询企业上次提示时间
     */
    private <T extends RemindCompanyVO> void buildLastSendTime(List<T> list) {
        for (RemindCompanyVO vo : list) {
            String nbxh = vo.getNbxh();
            // 查询提示时间
            List<CompanyRemindDetailInfo> dbList = companyRemindService.getCompanyRemindDetailInfos(nbxh);
            if (dbList.size() > 0) {
                vo.setRemindTime(dbList.get(0).getSendTime());
            }
        }
    }

    /**
     * 根据企业nbxh查询企业上次年报时间
     */
    private void buildLastAnnualInfo(List<AnnualRemindCompanyVO> list) {

        for (AnnualRemindCompanyVO vo : list) {
            String nbxh = vo.getNbxh();
            // 查询企业上次年报时间
            AnnualReportInfoExample exam = new AnnualReportInfoExample();
            exam.setOrderByClause("gmt_annual DESC");
            AnnualReportInfoExample.Criteria c = exam.createCriteria();
            c.andNbxhEqualTo(nbxh);
            List<AnnualReportInfo> dbList1 = annualReportInfoDao.selectByExample(exam);
            if (dbList1.size() > 0) {
                vo.setLastAnnualTime(dbList1.get(0).getGmtAnnual());
            }
        }
    }

    /**
     * 根据企业nbxh查询企业列入异常时间
     */
    private void buildLastAbnormalInfo(List<AbnormalRemindCompanyVO> list, int state) {

        int type = 0;
        switch (state) {
            case 1:
                type = 1;
                break;
            case 2:
                type = 2;
                break;
            case 4:
                type = 3;
                break;
            case 8:
                type = 4;
                break;
        }

        for (AbnormalRemindCompanyVO vo : list) {

            String nbxh = vo.getNbxh();
            AbnormalCompanyInfoExample example = new AbnormalCompanyInfoExample();
            example.setOrderByClause("gmt_checkin DESC");
            AbnormalCompanyInfoExample.Criteria criteria = example.createCriteria();
            criteria.andNbxhEqualTo(nbxh).andDeleteFlagEqualTo(0).andTypeEqualTo(type);

            List<AbnormalCompanyInfo> dbList = abnormalCompanyInfoDao.selectByExample(example);
            if (dbList.size() > 0) {
                vo.setAbnormalTime(dbList.get(0).getGmtCheckin());
            }
        }
    }

    @Override
    @Cacheable(value = CacheConstants.COMPANY_INFO, keyGenerator = "simpleKeyGenerator")
    public EnterpriseInfo getCompanyInfoByNbxh(String nbxh) {
        ValidateUtil.checkNull(nbxh, CommonErrorCode.PARAM_NULL);
        return doGetCompanyInfoByNbxh(nbxh);
    }

    private EnterpriseInfo doGetCompanyInfoByNbxh(String nbxh) {
        EnterpriseInfoExample exam = new EnterpriseInfoExample();
        exam.createCriteria().andNbxhEqualTo(nbxh);

        List<EnterpriseInfo> ds = enterpriseInfoDao.selectByExample(exam);
        ValidateUtil.checkListEmpty(ds, BizErrorCode.RESULT_NOT_EMPTY);
        return ds.get(0);
    }

    @Override
    @Cacheable(value = CacheConstants.COMPANY_INFO, keyGenerator = "simpleKeyGenerator")
    public AnnualReportInfo getAnnualReportInfoByNbxh(String nbxh) {
        AnnualReportInfo result = new AnnualReportInfo();
        ValidateUtil.checkNull(nbxh, CommonErrorCode.PARAM_NULL);

        AnnualReportInfoExample exam = new AnnualReportInfoExample();
        exam.createCriteria().andNbxhEqualTo(nbxh);
        exam.setOrderByClause("gmt_annual_year desc");

        List<AnnualReportInfo> ds = annualReportInfoDao.selectByExample(exam);
        //ValidateUtil.checkListEmpty(ds, CommonErrorCode.RESULT_NOT_EMPTY);
        if (ds.size() > 0) {
            result = ds.get(0);
        }

        return result;
    }

    @Override
    @Cacheable(value = CacheConstants.ADDRESS_INFO, keyGenerator = "simpleKeyGenerator")
    public Map<String, CompanyAddrInfoVO> getCompanyBBDAddrInfo(String nbxh) {
        EnterpriseInfo info = doGetCompanyInfoByNbxh(nbxh);
        String companyName = info.getCompanyName();
        Map<String, BBDCompanyAddrVO> addrMap = BBDUtil.getBBDCompanyAddrInfo(companyName);

        CompanyAddrInfoVO recruit = new CompanyAddrInfoVO();
        CompanyAddrInfoVO zhaobiao = new CompanyAddrInfoVO();

        if (addrMap != null) {
            for (String key : addrMap.keySet()) {
                BBDCompanyAddrVO vo = addrMap.get(key);
                if ("recruit".equals(key)) {
                    recruit.setAddr(vo.getAddress());
                    recruit.setEmails(vo.getEmail());
                    double lat = vo.getLat();
                    double lng = vo.getLng();
                    recruit.setLatitude(lat > 0.00d ? lat : -1d);
                    recruit.setLongitude(lng > 0.00d ? lng : -1d);
                    recruit.setPhones(vo.getPhone());
                } else if ("qyxx_data_zhongbig".equals(key)) {
                    zhaobiao.setAddr(vo.getAddress());
                    zhaobiao.setEmails(vo.getEmail());
                    double lat = vo.getLat();
                    double lng = vo.getLng();
                    zhaobiao.setLatitude(lat > 0.00d ? lat : -1d);
                    zhaobiao.setLongitude(lng > 0.00d ? lng : -1d);
                    zhaobiao.setPhones(vo.getPhone());
                }
            }
        }
        buildIngLatInfo(recruit);
        buildIngLatInfo(zhaobiao);
        Map<String, CompanyAddrInfoVO> result = Maps.newHashMap();
        result.put("recruit", recruit);
        result.put("qyxx_data_zhaobig", zhaobiao);
        return result;
    }

    private void buildIngLatInfo(CompanyAddrInfoVO info) {

        String addr = info.getAddr();
        double lng = info.getLongitude();
        double lat = info.getLatitude();

        if (StringUtils.isBlank(addr)) {
            return;
        } else if (lng > 0d && lat > 0d) {
            return;
        }
        LatLng ll = addressService.getAddressLatLng(addr);
        info.setLongitude(ll.lng);
        info.setLatitude(ll.lat);
    }

    @Override
    @Cacheable(value = CacheConstants.COMPANY_INFO, keyGenerator = "simpleKeyGenerator")
    public List<AddrPointInfo> getAddressPointInfo(String nbxh) {

        Map<String, Object> params = new HashMap<>();
        List<AddrPointInfo> result = new ArrayList<>();

        Map<String, String> dsMap = addressService.getDistrictCodeMap(Constants.GUIYANG_CODE);
        Set<String> districts = dsMap.keySet();

        // 每个区域取100条数据
        for (String str : districts) {
            params.put("district", str);
            params.put("nbxh", nbxh);
            result.addAll(companyExtDao.selectAddressPointInfo(params));
        }
        return result;
    }

    @Override
    public void syncBusinessRecord(int year, int month) {
        int lastId = 0;
        PageBounds pb = new PageBounds(1, 100, false);
        DateTime dateTime = new DateTime();
        dateTime = dateTime.plusMonths(-1);
        while (true) {
            BusinessMonthStatisticsInfoExample exam = new BusinessMonthStatisticsInfoExample();
            exam.createCriteria().andIdGreaterThan(lastId).andActivityYearEqualTo(year).andActivityMonthEqualTo(month);
            exam.setOrderByClause("id asc");

            List<BusinessMonthStatisticsInfo> ds = monthStatisticsInfoDao.selectByExampleWithPageBounds(exam, pb);
            if (ds.size() == 0) {
                break;
            }
            for (BusinessMonthStatisticsInfo d : ds) {

                Set<Integer> rs = getBusinessRecord(d.getNbxh(), dateTime);
                if (rs.size() > 0) {
                    BusinessMonthStatisticsInfo u = new BusinessMonthStatisticsInfo();
                    u.setId(d.getId());
                    String rsStr = org.apache.commons.lang3.StringUtils.join(rs, ",");
                    u.setBusinessRecords(rsStr);
                    monthStatisticsInfoDao.updateByPrimaryKeySelective(u);
                }
            }
            lastId = ds.get(ds.size() - 1).getId();
        }
    }

    // 查询企业的经营活动记录
    private Set<Integer> getBusinessRecord(String nbxh, DateTime dateTime) {

        int businessYearTo = dateTime.getYear();
        int businessMonthTo = dateTime.getMonthOfYear();
        DateTime query1 = new DateTime(businessYearTo, businessMonthTo, 1, 0, 0, 0);
        query1 = query1.plusMonths(1).plusSeconds(-1);
        Date queryTimeTo = query1.toDate();

        dateTime = dateTime.plusMonths(-11);
        int businessYearFrom = dateTime.getYear();
        int businessMonthFrom = dateTime.getMonthOfYear();
        DateTime query2 = new DateTime(businessYearFrom, businessMonthFrom, 1, 0, 0, 0);
        Date queryTimeFrom = query2.toDate();

        // 查询经营活动记录表
        BusinessRecordsInfoExample example = new BusinessRecordsInfoExample();
        BusinessRecordsInfoExample.Criteria criteria = example.createCriteria();
        criteria.andNbxhEqualTo(nbxh).andGmtActivityBetween(queryTimeFrom, queryTimeTo);
        List<BusinessRecordsInfo> businessList = businessRecordsInfoDao.selectByExample(example);
        Set<Integer> ctSet = Sets.newHashSet();
        for (BusinessRecordsInfo vo : businessList) {
            Integer ct = vo.getContentType();
            if (ct == 6 || ct == 7)
                ctSet.add(7);
            else
                ctSet.add(ct);
        }

        // 查询年报表
        List<String> annualYears = Lists.newArrayList();
        annualYears.add(String.valueOf(businessYearTo - 1));
        annualYears.add(String.valueOf(businessYearTo - 2));
        AnnualReportInfoExample exam = new AnnualReportInfoExample();
        exam.createCriteria().andGmtAnnualYearIn(annualYears).andNbxhEqualTo(nbxh);
        List<AnnualReportInfo> annuals = annualReportInfoDao.selectByExample(exam);
        if (annuals.size() > 0 && annuals.get(0) != null) {
            ctSet.add(1);
        }
        return ctSet;
    }

    /**
     * 查询企业经营活动项目
     */
    @Override
    public String getBusinessRecordValue(String nbxh, String date) {
        Map<String, String> btMap = companyUtil.getBusinessTypeMap();
        DateTime dateTime = new DateTime(date);
        Set<Integer> rs = getBusinessRecord(nbxh, dateTime);
        String rsStr = "";
        String result = "";
        if (rs.size() > 0) {
            rsStr = org.apache.commons.lang3.StringUtils.join(rs, ",");
            List<String> businessType = Arrays.asList(rsStr.split(","));
            List<String> bts = Lists.newArrayList();
            businessType.forEach(p -> bts.add(btMap.get(p)));
            result = org.apache.commons.lang3.StringUtils.join(bts, ",");
        }
        return result;
    }

    /**
     * 获取企业招聘联系方式
     */
    @Override
    public CompanyAddrInfoVO getRecruitAdressInfo(String nbxh) {
        IndexRecruitInfoExample example = new IndexRecruitInfoExample();
        example.setOrderByClause("gmt_create DESC");
        IndexRecruitInfoExample.Criteria criteria = example.createCriteria();
        criteria.andCompanyIdEqualTo(nbxh).andRecruitPlaceIsNotNull().andEMailIsNotNull();
        List<IndexRecruitInfo> dbList = indexRecruitInfoDao.selectByExampleWithPageBounds(example, new PageBounds(1, 1));
        String addr = "";
        String phones = "";
        String emails = "";
        String nb = "";
        String name = "";
        if (dbList != null && !dbList.isEmpty()) {
            for (IndexRecruitInfo info : dbList) {
                addr = info.getRecruitPlace();
                phones = info.getContactInformation();
                emails = info.geteMail();
                nb = info.getCompanyId();
                emails = info.getCompanyName();
            }
        }
        CompanyAddrInfoVO rs = new CompanyAddrInfoVO();
        rs.setAddr(addr);
        rs.setPhones(phones);
        rs.setEmails(emails);
        rs.setCompanyName(name);
        rs.setNbxh(nb);
        return rs;
    }

    /**
     * 获取企业招标联系方式
     */
    @Override
    public CompanyAddrInfoVO getPurchaseAdressInfo(String nbxh) {
        IndexPurchaseInfoExample example = new IndexPurchaseInfoExample();
        example.setOrderByClause("gmt_create DESC");
        IndexPurchaseInfoExample.Criteria criteria = example.createCriteria();
        criteria.andCompanyIdEqualTo(nbxh).andIsTenderEqualTo(true).andRegionIsNotNull().andTelephoneIsNotNull();
        List<IndexPurchaseInfo> dbList = indexPurchaseInfoDao.selectByExampleWithPageBounds(example, new PageBounds(1, 1));
        String addr = "";
        String phones = "";
        String emails = "";
        String nb = "";
        String name = "";
        if (dbList != null && !dbList.isEmpty()) {
            for (IndexPurchaseInfo info : dbList) {
                addr = info.getRegion();
                phones = info.getTelephone();
                emails = info.geteMail();
                nb = info.getCompanyId();
                emails = info.getCompanyName();
            }
        }
        CompanyAddrInfoVO rs = new CompanyAddrInfoVO();
        rs.setAddr(addr);
        rs.setPhones(phones);
        rs.setEmails(emails);
        rs.setCompanyName(name);
        rs.setNbxh(nb);
        return rs;

    }
}
