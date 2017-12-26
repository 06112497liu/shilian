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
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.mybatis.domain.PageBounds;
import org.joda.time.DateTime;
import org.joda.time.Years;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
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
        Map<Integer, String> typeMap = getAllCompanyTypeMappingInfos();


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
        Map<Integer, String> typeMap = getAllCompanyTypeMappingInfos();

        while (true) {
            Integer id = EsUtil.getLastId(EsUtil.COMPANY).intValue();

            EnterpriseInfoExample exam = new EnterpriseInfoExample();
            exam.createCriteria().andIdGreaterThan(id);
            PageBounds pb = new PageBounds(1, 500, false);

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

    private Map<Integer, String> getAllCompanyTypeMappingInfos() {
        Map<Integer, String> rs = Maps.newHashMap();
        rs.put(1, "民营企业"); rs.put(2, "国有企业"); rs.put(3, "外资企业"); rs.put(4, "农专社"); rs.put(5, "个体户");
        return rs;
    }

    private CompanyEsVO build(EnterpriseInfo info, Map<Integer, String> typeMap) {
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
        vo.setPrimaryIndustry(info.getPrimaryIndustryInitial());

        // 企业性质
        Integer property = info.getCompanyProperty();
        vo.setCompanyPropoerty(property);
        vo.setCompanyPropoertyDesc(typeMap.get(property));

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
        String records = info.getBusinessRecords();
        List<Integer> as = getActivities(records);
        vo.setActivity(as);

        // 经营活动指数
        vo.setScore(info.getIndexScore());

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

    private List<Integer> getActivities(String records) {
        List<Integer> result = Lists.newLinkedList();
        if (StringUtils.isEmpty(records)) return result;
        Splitter splitter = Splitter.on(",").omitEmptyStrings().trimResults();
        Iterable<String> it = splitter.splitToList(records);
        for (String s : it) {
            result.add(Integer.valueOf(s));
        }
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
