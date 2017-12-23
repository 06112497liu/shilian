/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.service.reddata.es.impl;

import com.bbd.bean.LatLng;
import com.bbd.bean.vo.CompanyEsVO;
import com.bbd.dao.*;
import com.bbd.domain.*;
import com.bbd.enums.IndustryEnum;
import com.bbd.service.reddata.es.IEsService;
import com.bbd.util.EsUtil;
import com.bbd.util.StringUtils;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.mybatis.domain.PageBounds;
import org.joda.time.DateTime;
import org.joda.time.Years;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * ElasticSearch服务实现
 *
 * @author tjwang
 * @version $Id: EsServiceImpl.java, v 0.1 2017/5/24 0024 12:39 tjwang Exp $
 */
@Service
public class EsServiceImpl implements IEsService {

    @Resource
    private EnterpriseInfoDao              enterpriseInfoDao;

    @Resource
    private CompanyTypeMappingInfoDao      companyTypeMappingInfoDao;

    @Resource
    private AbnormalCompanyInfoDao         abnormalCompanyInfoDao;

    @Resource
    private BusinessMonthStatisticsInfoDao businessMonthStatisticsInfoDao;

    @Resource
    private BusinessRecordsInfoDao         businessRecordsInfoDao;

    @Override
    public void syncFullCompanyToEs() {
        Map<String, CompanyTypeMappingInfo> typeMap = getAllCompanyTypeMappingInfos();


        EsUtil.deleteAll(EsUtil.INDEX);
        // 同步计数
        int count = 0;

        while (true) {
            EnterpriseInfoExample exam = new EnterpriseInfoExample();
            exam.createCriteria().andIdGreaterThan(count);
            exam.setOrderByClause("id asc");
            PageBounds pb = new PageBounds(1, 1000, false);

            List<EnterpriseInfo> ds = enterpriseInfoDao.selectByExampleWithPageBounds(exam, pb);
            if (ds.size() == 0) {
                break;
            }
            count = ds.get(ds.size() - 1).getId();

            List<CompanyEsVO> vos = Lists.newArrayList();
            for (EnterpriseInfo d : ds) {
                CompanyEsVO vo = build(d, typeMap);
                vos.add(vo);
            }

            EsUtil.create(EsUtil.COMPANY, vos);
        }
    }

    @Override
    public void syncIncreaseCompanyToEs() {
        Map<String, CompanyTypeMappingInfo> typeMap = getAllCompanyTypeMappingInfos();

        while (true) {
            Integer id = EsUtil.getLastId(EsUtil.COMPANY).intValue();

            EnterpriseInfoExample exam = new EnterpriseInfoExample();
            exam.createCriteria().andIdGreaterThan(id);
            PageBounds pb = new PageBounds(1, 1000, false);

            List<EnterpriseInfo> ds = enterpriseInfoDao.selectByExampleWithPageBounds(exam, pb);
            if (ds.size() == 0) {
                break;
            }

            List<CompanyEsVO> vos = Lists.newArrayList();
            for (EnterpriseInfo d : ds) {
                CompanyEsVO vo = build(d, typeMap);
                vos.add(vo);
            }

            EsUtil.create(EsUtil.COMPANY, vos);
        }
    }

    private Map<String, CompanyTypeMappingInfo> getAllCompanyTypeMappingInfos() {
        CompanyTypeMappingInfoExample exam = new CompanyTypeMappingInfoExample();
        List<CompanyTypeMappingInfo> ds = companyTypeMappingInfoDao.selectByExample(exam);

        return ds.stream().collect(Collectors.toMap(CompanyTypeMappingInfo::getCompanyCode, (p) -> p));
    }

    private CompanyEsVO build(EnterpriseInfo info, Map<String, CompanyTypeMappingInfo> typeMap) {
        CompanyEsVO vo = CompanyEsVO.empty();
        BeanUtils.copyProperties(info, vo);
        vo.setId(info.getId().longValue());

        String nbxh = info.getNbxh();

        // 登记机关
        String ra = info.getRegisterAuthority();
        if (StringUtils.isBlank(ra) || ra.length() <= 6) {
            vo.setRegisterAuthority("未知");
        }

        // 行业
        String pi = vo.getPrimaryIndustry();
        pi = getPrimaryIndustry(pi);
        String piDesc = getPrimaryIndustryDesc(pi);
        vo.setPrimaryIndustry(pi);
        vo.setIndustryDesc(piDesc);

        // 企业性质
        CompanyTypeMappingInfo ct = typeMap.get(vo.getCompanyType());
        if (ct != null) {
            vo.setCompanyPropoerty(ct.getCompanyType());
            vo.setCompanyPropoertyDesc(ct.getDescription());
        }

        double lng = info.getLongitude() == null ? -1 : info.getLongitude();
        double lat = info.getLatitude() == null ? -1 : info.getLatitude();
        // 经纬度
        LatLng ll = new LatLng(lng, lat);
        vo.setLatLng(ll);

        // 异常情况
        List<AbnormalCompanyInfo> acs = getAbnormalDatas(nbxh);
        List<Integer> abs = getAbnormals(acs);
        vo.setAbnormal(abs);
        Date lostTime = getLostTime(acs);
        vo.setLostTime(lostTime);

        // 企业经营活动状态
        List<Integer> businessStatus = Lists.newArrayList();
        if (isLost(abs)) {
            businessStatus.add(2);
        }
        if (isSuspendButNotCanceled(info)) {
            businessStatus.add(3);
        }
        if (isSeriousViolate(acs)) {
            businessStatus.add(4);
        }
        if (businessStatus.isEmpty()) {
            businessStatus.add(1);
        }
        vo.setBusinessStatus(businessStatus);

        // 经营活动
        List<Integer> as = getActivities(nbxh);
        vo.setActivity(as);

        // 经营活动指数
        Double exponent = getExponent(nbxh);
        vo.setScore(exponent);

        return vo;
    }

    /**
     * 获取企业异常信息
     *
     * @param ds 未移除的异常信息
     * @return
     */
    private List<Integer> getAbnormals(List<AbnormalCompanyInfo> ds) {
        Set<Integer> set = Sets.newHashSet();
        for (AbnormalCompanyInfo d : ds) {
            Integer type = d.getType();
            if (type != null) {
                set.add(type);
            }
        }
        return Lists.newArrayList(set);
    }

    List<AbnormalCompanyInfo> getAbnormalDatas(String nbxh) {
        AbnormalCompanyInfoExample exam = new AbnormalCompanyInfoExample();
        exam.createCriteria().andNbxhEqualTo(nbxh).andDeleteFlagEqualTo(0);

        List<AbnormalCompanyInfo> ds = abnormalCompanyInfoDao.selectByExample(exam);
        return ds;
    }

    /**
     * 是否是已吊销未注销
     *
     * @param info
     * @return
     */
    private boolean isSuspendButNotCanceled(EnterpriseInfo info) {
        return "8".equals(info.getNameType()) ? true : false;
    }

    /**
     * 是否严重违法
     *
     * @param ds 未移除的异常信息
     * @return
     */
    private boolean isSeriousViolate(List<AbnormalCompanyInfo> ds) {
        if (ds == null || ds.size() == 0) {
            return false;
        }
        for (AbnormalCompanyInfo d : ds) {
            Date checkin = d.getGmtCheckin();
            if (checkin != null) {
                DateTime begin = new DateTime(checkin);
                DateTime now = new DateTime();
                int years = Years.yearsBetween(begin, now).getYears();
                if (years >= 3) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 是否失联
     *
     * @param abs 异常类型
     * @return
     */
    private boolean isLost(List<Integer> abs) {
        if (abs == null || abs.size() == 0) {
            return false;
        }
        for (Integer ab : abs) {
            if (ab == 4) {
                return true;
            }
        }
        return false;
    }

    /**
     * 获取行业首字母
     *
     * @param pi
     * @return
     */
    private String getPrimaryIndustry(String pi) {
        String result = "";
        if (StringUtils.isBlank(pi)) {
            return result;
        }
        result = pi.substring(0, 1);
        return result;
    }

    /**
     * 获取行业描述
     *
     * @param pi
     * @return
     */
    private String getPrimaryIndustryDesc(String pi) {
        String desc = "";
        try {
            desc = IndustryEnum.valueOf(pi).getCode();
        } catch (IllegalArgumentException e) {
        }
        return desc;
    }

    private Double getExponent(String nbxh) {
        Double result = 0.0d;

        DateTime time = new DateTime();
        time = time.plusMonths(-1);
        int year = time.getYear();
        int month = time.getMonthOfYear();

        BusinessMonthStatisticsInfoExample exam = new BusinessMonthStatisticsInfoExample();
        exam.createCriteria().andNbxhEqualTo(nbxh).andActivityYearEqualTo(year).andActivityMonthEqualTo(month);
        List<BusinessMonthStatisticsInfo> ds = businessMonthStatisticsInfoDao.selectByExample(exam);
        if (ds.size() > 0) {
            result = ds.get(0).getActivityExponent();
        }

        return result;
    }

    private List<Integer> getActivities(String nbxh) {
        List<Integer> result = Lists.newArrayList();

        DateTime time = new DateTime();
        time = time.plusMonths(-1);
        int year = time.getYear();
        int month = time.getMonthOfYear();

        BusinessRecordsInfoExample exam = new BusinessRecordsInfoExample();
        exam.createCriteria().andNbxhEqualTo(nbxh).andActivityYearEqualTo(year).andActivityMonthEqualTo(month);

        List<BusinessRecordsInfo> ds = businessRecordsInfoDao.selectByExample(exam);

        if (ds.size() == 0) {
            return result;
        }

        Set<Integer> rs = Sets.newHashSet();
        for (BusinessRecordsInfo d : ds) {
            rs.add(d.getContentType());
        }
        result.addAll(rs);
        return result;
    }

    private Date getLostTime(List<AbnormalCompanyInfo> acs) {
        Date result = null;
        if (acs == null || acs.size() == 0) {
            return result;
        }
        for (AbnormalCompanyInfo ac : acs) {
            if (ac.getType() != null && ac.getType() == 4) {
                result = ac.getGmtCheckin();
                break;
            }
        }
        return result;
    }

}
