/**
 * BBD Service Inc
 * All Rights Reserved @2017
 */
package com.bbd.service.reddata.activity.impl;

import com.bbd.Constants;
import com.bbd.bean.company.CompanyBusinessInfoVO;
import com.bbd.bean.statistics.CompanyActiveIndexStatisticsInfo;
import com.bbd.bean.statistics.NameValueInfo;
import com.bbd.bean.statistics.NameValueInfoExplore;
import com.bbd.bean.statistics.NameValueNodeInfo;
import com.bbd.common.CacheConstants;
import com.bbd.controller.param.CompanyBusinessInfoQueryParam;
import com.bbd.controller.reddata.activity.param.ActiveIndexQuery;
import com.bbd.dao.AnnualReportInfoDao;
import com.bbd.dao.BusinessMonthStatisticsInfoDao;
import com.bbd.dao.BusinessRecordsInfoDao;
import com.bbd.dao.activity.ActiveIndexStatisticsDao;
import com.bbd.dao.company.CompanyExtDao;
import com.bbd.dao.statistics.CompanyStatisticsDao;
import com.bbd.domain.BusinessMonthStatisticsInfo;
import com.bbd.domain.BusinessMonthStatisticsInfoExample;
import com.bbd.service.reddata.activity.IActivityIndexService;
import com.bbd.service.reddata.addr.IAddressService;
import com.bbd.service.reddata.company.CompanyUtil;
import com.bbd.service.reddata.company.impl.CompanyEsSearchServiceImpl;
import com.bbd.service.reddata.statistics.ICompanyStatisticsService;
import com.bbd.service.reddata.statistics.ILostCompanyStatisticsService;
import com.bbd.util.StringUtils;
import com.bbd.utils.PercentUtil;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.mybatis.domain.PageBounds;
import com.mybatis.domain.PageList;
import com.mybatis.domain.SortBy;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 企业经营活动指数接口
 *
 * @author liuweibo
 * @version $Id: ActiveIndexServiceImpl.java, v 0.1 2017年5月8日 下午1:45:40 liuweibo Exp $
 */
@Service
public class ActivityIndexServiceImpl implements IActivityIndexService {

    @Resource
    RedisTemplate<String, String>          redisTemplate;
    @Resource
    ActiveIndexStatisticsDao               activeIndexStatisticsDao;
    @Resource
    ILostCompanyStatisticsService          lostCompanyStatisticsService;
    @Resource
    BusinessRecordsInfoDao                 businessRecordsInfoDao;
    @Resource
    CompanyEsSearchServiceImpl             companyEsSercherService;
    @Resource
    CompanyStatisticsDao                   companyStatisticsDao;
    @Resource
    CompanyExtDao                          companyExtDao;
    @Value("${download_folder}")
    private String                         donwloadFolder;
    @Resource
    private IAddressService                addressService;
    @Resource
    private CompanyUtil                    companyUtil;
    @Resource
    private AnnualReportInfoDao            annualReportInfoDao;
    @Resource
    private BusinessMonthStatisticsInfoDao businessMonthStatisticsInfoDao;
    @Resource
    private ICompanyStatisticsService      companyStatisticsService;

    /**
     * 设置查询条件的基础参数
     *
     * @param indexQuery
     * @return
     */
    private Map<String, Object> setParams(ActiveIndexQuery indexQuery) {

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("areaCode", indexQuery.getAreaCode());
        params.put("company_state", indexQuery.getCompanyState());
        params.put("companyProperties", indexQuery.getCompanyProperties());
        params.put("primaryIndustry", indexQuery.getPrimaryIndustry());
        params.put("companyRegisterFrom", indexQuery.getCompanyRegisterFrom() == null ? null : indexQuery.getCompanyRegisterFrom() + " 00:00:00");
        params.put("companyRegisterTo", indexQuery.getCompanyRegisterTo() == null ? null : indexQuery.getCompanyRegisterTo() + " 00:00:00");

        return params;
    }

    /**
     * 设置查询参数的额外时间条件
     *
     * @param params
     */
    private void setDateParam(Map<String, Object> params) {
        DateTime dateTime = new DateTime();
        dateTime = dateTime.plusMonths(-1);
        int year = dateTime.getYear();
        int month = dateTime.getMonthOfYear();
        params.put("year", year);
        params.put("month", month);
    }

    /**
     * 获取企业经营活动指数趋势
     */
    @Override
    @Cacheable(value = CacheConstants.STATISTIC_ACTIVITY_INDEX, keyGenerator = "simpleKeyGenerator")
    public Map<Integer, CompanyActiveIndexStatisticsInfo> getActivityIndexTrend(ActiveIndexQuery indexQuery) {
        Map<Integer, CompanyActiveIndexStatisticsInfo> rs = Maps.newHashMap();
        // 查询参数设置
        Map<String, Object> params = setParams(indexQuery);
        DateTime date = new DateTime();
        int year = date.getYear();
        int month = date.getMonthOfYear();
        // 查询当年经营活动指数趋势
        params.put("year", year);
        List<NameValueInfo> currentList = activeIndexStatisticsDao.selectActivityIndexTrend(params);
        fillMonthData(currentList, month - 1);
        // 查询上年经营活动趋势
        params.put("year", year - 1);
        List<NameValueInfo> lastList = activeIndexStatisticsDao.selectActivityIndexTrend(params);
        fillMonthData(lastList, 12);

        CompanyActiveIndexStatisticsInfo current = new CompanyActiveIndexStatisticsInfo(currentList);
        CompanyActiveIndexStatisticsInfo last = new CompanyActiveIndexStatisticsInfo(lastList);
        rs.put(year, current);
        rs.put(year - 1, last);
        // 补全数据
        return rs;
    }

    // 补全没有数据的月份
    private void fillMonthData(List<NameValueInfo> list, int month) {
        Map<Object, Object> map = list.stream().collect(Collectors.toMap(NameValueInfo::getName, NameValueInfo::getValue));
        for (int i = month; i > 0; i--) {
            if (!map.containsKey(i)) {
                NameValueInfo info = new NameValueInfo();
                info.setName(i);
                info.setValue(0.0);
                list.add(info);
            }
        }
        Collections.sort(list, (x, y) -> {
            Integer e1 = (Integer) x.getName();
            Integer e2 = (Integer) y.getName();
            return Integer.compare(e1, e2);
        });
    }

    /**
     * 获取休眠企业率走势
     */
    @Override
    @Cacheable(value = CacheConstants.STATISTIC_ACTIVITY_INDEX, keyGenerator = "simpleKeyGenerator")
    public Map<Integer, CompanyActiveIndexStatisticsInfo> getDormancyTrend(ActiveIndexQuery indexQuery) {
        Map<Integer, CompanyActiveIndexStatisticsInfo> rs = Maps.newHashMap();
        // 查询参数设置
        Map<String, Object> params = setParams(indexQuery);
        DateTime date = new DateTime();
        int year = date.getYear();
        int month = date.getMonthOfYear();
        // 查询当年休眠企业率走势
        params.put("year", year);
        List<NameValueInfo> currentList = activeIndexStatisticsDao.selectDormancyTrend(params);
        fillMonthData(currentList, month - 1);
        // 查询上年休眠企业率走势
        params.put("year", year - 1);
        List<NameValueInfo> lastList = activeIndexStatisticsDao.selectDormancyTrend(params);
        fillMonthData(lastList, 12);

        CompanyActiveIndexStatisticsInfo current = new CompanyActiveIndexStatisticsInfo(currentList);
        CompanyActiveIndexStatisticsInfo last = new CompanyActiveIndexStatisticsInfo(lastList);
        rs.put(year, current);
        rs.put(year - 1, last);

        return rs;
    }

    /**
     * 获取企业经营活动指数分布
     */
    @Override
    @Cacheable(value = CacheConstants.STATISTIC_ACTIVITY_INDEX, keyGenerator = "simpleKeyGenerator")
    public List<NameValueInfoExplore> getBusinessActivityIndexGroup(ActiveIndexQuery indexQuery) {

        // 设置基础查询条件
        Map<String, Object> params = setParams(indexQuery);

        // 设置额外的时间条件
        setDateParam(params);

        List<NameValueNodeInfo> list = activeIndexStatisticsDao.selectBusinessActivityIndexGroup(params);
        PercentUtil.calcLongPercents(list);
        List<NameValueNodeInfo> temp = fillData(list);

        // 往查询结果添加企业的异常类型
        List<NameValueInfoExplore> result = new ArrayList<>();
        for (NameValueNodeInfo nameValueNodeInfo : temp) {
            NameValueInfoExplore info = new NameValueInfoExplore();
            info.setName(nameValueNodeInfo.getName());
            info.setValue(nameValueNodeInfo.getValue());
            info.setPercent(nameValueNodeInfo.getPercent());
            info.setCompanyState(indexQuery.getCompanyState());
            result.add(info);
        }

        return result;
    }

    /**
     * 补齐指数分布为0的数据
     */
    private List<NameValueNodeInfo> fillData(List<NameValueNodeInfo> list) {

        List<NameValueNodeInfo> result = new LinkedList<>();
        for (int i = 0; i < 4; i++) {
            NameValueNodeInfo info = new NameValueNodeInfo();
            info.setName(i);
            info.setValue(0L);
            info.setPercent("0");
            result.add(info);
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < list.size(); j++) {
                if (result.get(i).getName().equals(list.get(j).getName())) {
                    result.get(i).setValue(list.get(j).getValue());
                    result.get(i).setPercent(list.get(j).getPercent());
                }
            }
        }
        return result;
    }

    /**
     * 获取疑似休眠企业一级行业分布
     */
    @Override
    @Cacheable(value = CacheConstants.STATISTIC_ACTIVITY_INDEX, keyGenerator = "simpleKeyGenerator")
    public List<NameValueNodeInfo> getDormancyIndustry(ActiveIndexQuery indexQuery) {

        String areaCode = indexQuery.getAreaCode();
        int companyState = indexQuery.getCompanyState();
        Map<Object, Object> industryCount = getCompanyCountForIndustry(areaCode, companyState);

        // 设置基础查询条件
        Map<String, Object> params = setParams(indexQuery);

        // 设置额外的时间条件
        setDateParam(params);

        List<NameValueNodeInfo> list = activeIndexStatisticsDao.selectDormancyIndustry(params);

        // 计算百分比
        List<NameValueNodeInfo> rs = calcLongPercent(industryCount, list);

        // 转一级行业类型编码为中文名称
        Map<String, String> dsMap = companyUtil.getPrimaryIndustryMap();
        for (NameValueNodeInfo info : rs) {
            info.setName(dsMap.get(info.getName()));
        }

        return rs;
    }

    /**
     * 获取各个行业疑似休眠企业数量
     */
    @Override
    @Cacheable(value = CacheConstants.STATISTIC_ACTIVITY_INDEX, keyGenerator = "simpleKeyGenerator")
    public Map<Object, Object> getCompanyCountForIndustry(String areaCode, int companyState) {

        Map<String, Object> params = Maps.newHashMap();
        params.put("district", areaCode);
        params.put("company_state", companyState);
        setDateParam(params);
        List<NameValueInfo> rs = activeIndexStatisticsDao.selectCompanyCountForIndustry(params);
        Map<Object, Object> map = rs.stream().collect(Collectors.toMap(NameValueInfo::getName, NameValueInfo::getValue));
        return map;
    }

    /**
     * 计算疑似休眠企业一级行业占比
     */
    private List<NameValueNodeInfo> calcLongPercent(Map<Object, Object> resource, List<NameValueNodeInfo> target) {
        List<NameValueNodeInfo> rs = Lists.newArrayList();
        for (NameValueNodeInfo info : target) {
            NameValueNodeInfo n = new NameValueNodeInfo();
            n.setName(info.getName());
            n.setValue(info.getValue());
            long val = (long) info.getValue();
            long total = (long) resource.get(info.getName());
            String per = PercentUtil.calcLongPercents(total, val);
            n.setPercent(per);
            rs.add(n);
        }
        Collections.sort(rs, new Comparator<NameValueNodeInfo>() {
            @Override
            public int compare(NameValueNodeInfo o1, NameValueNodeInfo o2) {
                String value1 = o1.getPercent().replace("%", "");
                String value2 = o2.getPercent().replace("%", "");
                Double d1 = Double.parseDouble(value1);
                Double d2 = Double.parseDouble(value2);
                return d2.compareTo(d1);
            }
        });
        return rs;
    }

    /**
     * 查询疑似休眠企业区域分布
     */
    @Override
    @Cacheable(value = CacheConstants.STATISTIC_ACTIVITY_INDEX, keyGenerator = "simpleKeyGenerator")
    public List<NameValueNodeInfo> getDormancyArea(ActiveIndexQuery indexQuery) {

        // 设置基础查询条件
        Map<String, Object> params = setParams(indexQuery);

        // 设置额外的时间条件
        setDateParam(params);

        List<NameValueNodeInfo> list = activeIndexStatisticsDao.selectDormancyArea(params);
        PercentUtil.calcLongPercents(list);

        // 转区域编码为中文
        Map<String, String> dsMap = addressService.getDistrictCodeMap(Constants.GUIYANG_CODE);
        for (NameValueNodeInfo info : list) {
            info.setName(dsMap.get(info.getName()));
        }

        return list;
    }

    /**
     * 查询经营活动指数企业列表信息
     */
    @Override
    public PageList<CompanyBusinessInfoVO> getCompanyBusinessInfoList(CompanyBusinessInfoQueryParam params, PageBounds pb) {

        SortBy sortBy = null;
        Integer order = params.getOrder();
        if (order == null || order == 1) {
            sortBy = SortBy.create("indexScore", SortBy.Direction.DESC.toString());
        } else {
            sortBy = SortBy.create("indexScore", SortBy.Direction.ASC.toString());
        }
        if (sortBy != null) {
            pb.setOrders(Lists.newArrayList(sortBy));
        }

        Map<String, Object> map = getBusinessInfoQueryMap(params);
        List<CompanyBusinessInfoVO> dbList = companyExtDao.queryBusinessCompanyList(map, pb);
        buildCompanyBusinessInfoVOS(dbList);

        return (PageList<CompanyBusinessInfoVO>) dbList;
    }

    @Override
    public List<CompanyBusinessInfoVO> getCompanyBusinessInfoList(CompanyBusinessInfoQueryParam params) {
        PageBounds pb = new PageBounds();
        Map<String, Object> map = getBusinessInfoQueryMap(params);
        List<CompanyBusinessInfoVO> dbList = companyExtDao.queryBusinessCompanyList(map, pb);
        buildCompanyBusinessInfoVOS(dbList);

        return dbList;
    }

    private Map<String, Object> getBusinessInfoQueryMap(CompanyBusinessInfoQueryParam params) {
        Map<String, Object> map = Maps.newHashMap();

        String district = params.getDistrict();
        Integer compantyState = params.getCompanyState();
        String companyName = params.getCompanyName();
        String primaryIndustry = params.getPrimaryIndustry();

        if (StringUtils.isNotBlank(district)) {
            map.put("district", params.getDistrict());
        }
        if (compantyState != null) {
            map.put("companyState", params.getCompanyState());
        }
        if (StringUtils.isNotBlank(companyName)) {
            map.put("companyName", "%" + params.getCompanyName() + "%");
        }
        if (StringUtils.isNotBlank(primaryIndustry)) {
            map.put("primaryIndustry", params.getPrimaryIndustry());
        }

        Double from = params.getIndexScoreFrom();
        Double to = params.getIndexScoreTo();
        if (from != null || to != null) {
            map.put("indexScoreFrom", from == null ? 0.0 : from);
            map.put("indexScoreTo", to == null ? 100.0 : to);
        }

        return map;
    }

    private void buildCompanyBusinessInfoVOS(List<CompanyBusinessInfoVO> dbList) {
        Map<String, String> dsMap = addressService.getDistrictCodeMap(Constants.GUIYANG_CODE);
        for (CompanyBusinessInfoVO vo : dbList) {
            vo.setDistrictDesc("贵州省贵阳市" + dsMap.get(vo.getDistrict()));
        }

        Map<String, String> industryMap = companyUtil.getPrimaryIndustryMap();
        for (CompanyBusinessInfoVO vo : dbList) {
            vo.setPrimaryIndustryInitialDesc(industryMap.get(vo.getPrimaryIndustryInitial()));
        }

        Map<String, String> btMap = companyUtil.getBusinessTypeMap();

        for (CompanyBusinessInfoVO vo : dbList) {
            StringBuffer sb = new StringBuffer("");
            String temp = vo.getBusinessType();
            if (StringUtils.isNotBlank(temp)) {
                List<String> businessType = Arrays.asList(temp.split(","));

                List<String> bts = Lists.newArrayList();
                businessType.forEach(p -> bts.add(btMap.get(p)));
                vo.setBusinessTypeDesc(org.apache.commons.lang3.StringUtils.join(bts, ","));
            } else {
                vo.setBusinessTypeDesc(sb.toString());
            }

        }
    }

    /**
     * 根据月份来查询企业经营活动指数
     */
    @Override
    @Cacheable(value = CacheConstants.STATISTIC_ACTIVITY_INDEX, keyGenerator = "simpleKeyGenerator")
    public double getCompanyMonthActivityExp(String nbxh, int year, int month) {
        double score = 0.0;

        BusinessMonthStatisticsInfoExample exam = new BusinessMonthStatisticsInfoExample();
        exam.createCriteria().andNbxhEqualTo(nbxh).andActivityYearEqualTo(year).andActivityMonthEqualTo(month);
        List<BusinessMonthStatisticsInfo> ds = businessMonthStatisticsInfoDao.selectByExample(exam);
        if (ds.size() > 0) {
            score = ds.get(0).getActivityExponent();
        }

        return score;
    }

    /**
     * 经营异常类型的企业总数
     */
    @Override
    @Cacheable(value = CacheConstants.STATISTIC_ACTIVITY_INDEX, keyGenerator = "simpleKeyGenerator")
    public Integer getCompanyCount(String district, Integer companyState) {

        Integer result = activeIndexStatisticsDao.selectCompanyTotal(district, companyState);

        return result;
    }

}
