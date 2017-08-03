/**
 * BBD Service Inc
 * All Rights Reserved @2017
 */
package com.bbd.service.reddata.statistics.impl;

import com.bbd.Constants;
import com.bbd.bean.biz.CompanyDataCountInfo;
import com.bbd.bean.statistics.CompanyAddrStaticInfo;
import com.bbd.bean.statistics.NameValueInfo;
import com.bbd.bean.statistics.NameValueNodeInfo;
import com.bbd.common.CacheConstants;
import com.bbd.dao.CompanyMonthInfoDao;
import com.bbd.dao.statistics.AbnormalStatisticsDao;
import com.bbd.dao.statistics.AnnualStatisticsDao;
import com.bbd.dao.statistics.CompanyStatisticsDao;
import com.bbd.service.reddata.addr.IAddressService;
import com.bbd.service.reddata.company.CompanyUtil;
import com.bbd.service.reddata.statistics.ICompanyStatisticsService;
import com.bbd.service.utils.RedisCacheUtil;
import com.bbd.util.DateUtil;
import com.bbd.utils.CompanyType;
import com.bbd.utils.CompanyTypeNew;
import com.bbd.utils.PercentUtil;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author liuweibo
 * @version $Id: CompanyStatisticsService.java, v 0.1 2017年5月4日 上午9:19:25 liuweibo Exp $
 */
@Service
public class CompanyStatisticsServiceImpl implements ICompanyStatisticsService {

    @Resource
    RedisCacheUtil                redisCacheUtil;
    @Resource
    private CompanyStatisticsDao  companyStatisticsDao;
    @Resource
    private AnnualStatisticsDao   annualStatisticsDao;
    @Resource
    private AbnormalStatisticsDao abnormalStatisticsDao;

    @Resource
    private IAddressService       addressService;

    @Resource
    private CompanyUtil           companyUtil;

    @Resource
    private CompanyMonthInfoDao   companyMonthInfoDao;

    /**
     * 获取系统当前挖掘的信息总量数据
     */
    @Override
    @Cacheable(value = CacheConstants.STATISTIC_COMPANY, keyGenerator = "simpleKeyGenerator")
    public CompanyDataCountInfo getCompanyDataCountInfo() {

        CompanyDataCountInfo info = new CompanyDataCountInfo();
        Long dataCount = null;

        // 挖掘的数据总数首先从redis中取
        Integer dataCountRedis = redisCacheUtil.getCacheObject("company_data_total");
        if (dataCountRedis != null)
            dataCount = (long) dataCountRedis;

        // redis没有，就从数据库中取数据
        if (dataCount == null) {
            dataCount = companyStatisticsDao.getDataCount();
            if (dataCount != null && dataCount != 0)
                redisCacheUtil.setCacheObject("company_data_total", dataCount);
        }

        info.setDataCount(dataCount);
        info.setUpdateTime(DateUtil.formatDateByPatten(new Date(), "yyyy年MM月dd日"));
        return info;
    }

    /**
     * 获取贵阳市的企业总量
     */
    @Override
    @Cacheable(value = CacheConstants.STATISTIC_COMPANY, keyGenerator = "simpleKeyGenerator")
    public Integer getCompanyTotalCount(String district) {
        return companyStatisticsDao.selectCompanyTotalCount(district);
    }

    /**
     * 获取贵阳市已年报企业数量
     */
    @Override
    @Cacheable(value = CacheConstants.STATISTIC_COMPANY, keyGenerator = "simpleKeyGenerator")
    public Integer getAnnualedCount(String district) {
        return annualStatisticsDao.selectHaveAnnualCount(district);
    }

    @Override
    @Cacheable(value = CacheConstants.STATISTIC_COMPANY, keyGenerator = "simpleKeyGenerator")
    public Integer getUnannualedCompanyCount(String district) {
        return annualStatisticsDao.selectUnannualedCount(district);
    }

    @Override
    @Cacheable(value = CacheConstants.STATISTIC_COMPANY, keyGenerator = "simpleKeyGenerator")
    public Integer getAnnualedCurrentMonthCount(Integer year, Integer month, String district) {
        return annualStatisticsDao.selectAnnualedCurrentMonthCount(year, month, district);
    }

    /**
     * 获取贵阳市当年应年报企业数量
     */
    @Override
    @Cacheable(value = CacheConstants.STATISTIC_COMPANY, keyGenerator = "simpleKeyGenerator")
    public Integer getAnnualCompanyCount(String district) {
        return annualStatisticsDao.selectShouldAnnualCount(district);
    }

    /**
     * 获取贵阳市被列入经营异常名录企业数量
     */
    @Override
    @Cacheable(value = CacheConstants.STATISTIC_COMPANY, keyGenerator = "simpleKeyGenerator")
    public Integer getAbnormalCount(String district) {
        return abnormalStatisticsDao.selectAbnormalCount(district);
    }

    /**
     * 获取已年报企业区域分布
     *
     * @return
     */
    @Override
    @Cacheable(value = CacheConstants.STATISTIC_COMPANY, keyGenerator = "simpleKeyGenerator")
    public List<CompanyAddrStaticInfo> getAnnualedCompanyDistribute(String district) {

        List<CompanyAddrStaticInfo> infos = annualStatisticsDao.selectAnnualedCompanyDistribute();
        Map<String, Long> disCount = companyUtil.getShouldAnnualCoutByDistrict();
        List<CompanyAddrStaticInfo> result = transferCompanyAddr(infos, disCount);

        // 转区域编码为中文
        addDistrictDescForCompanyAddr(result);

        // 补全数据
        fillDestrictData(result);

        return result;
    }

    /**
     * 补全没有数据的区域
     *
     * @param list
     */
    private void fillDestrictData(List<CompanyAddrStaticInfo> list) {
        Map<String, String> dsMap = addressService.getDistrictCodeMap(Constants.GUIYANG_CODE);
        Set<String> districts = dsMap.keySet();
        Set<String> listDis = Sets.newHashSet();

        for (int i = 0; i < list.size(); i++) {
            CompanyAddrStaticInfo tempInfo = list.get(i);
            String tempCode = String.valueOf(tempInfo.getCode());
            listDis.add(tempCode);
        }
        districts.removeAll(listDis);
        for (String str : districts) {
            CompanyAddrStaticInfo info = new CompanyAddrStaticInfo();
            info.setName(dsMap.get(str));
            info.setCode(Integer.parseInt(str));
            info.setPercent("0%");
            info.setValue(0L);
            list.add(info);
        }

    }

    private List<NameValueInfo> processCompanyPropertyInfo(List<NameValueInfo> infos) {
        List<NameValueInfo> result = Lists.newArrayList();
        for (NameValueInfo info : infos) {
            Object name = info.getName();
            if (name == null) {
                info.setName(4);
            }
            result.add(info);
        }
        return result;
    }

    // 计算百分比
    private List<NameValueNodeInfo> transfer(List<NameValueInfo> infos, int total) {
        List<NameValueNodeInfo> result = Lists.newArrayList();
        for (NameValueInfo info : infos) {
            long val = (long) info.getValue();
            NameValueNodeInfo n = new NameValueNodeInfo();
            n.setName(info.getName());
            n.setValue(val);
            String perc = PercentUtil.calcLongPercents((long) total, val);
            n.setPercent(perc);
            result.add(n);
        }
        return result;
    }

    // 计算百分比（CompanyAddrStaticInfo）
    private List<CompanyAddrStaticInfo> transferCompanyAddr(List<CompanyAddrStaticInfo> infos, Map<String, Long> map) {
        List<CompanyAddrStaticInfo> result = Lists.newArrayList();
        for (CompanyAddrStaticInfo info : infos) {
            long val = (long) info.getValue();
            CompanyAddrStaticInfo n = new CompanyAddrStaticInfo();
            n.setName(info.getName());
            n.setValue(val);
            n.setCode(info.getCode());
            Long disCount = map.get(String.valueOf(info.getCode()));
            String perc = PercentUtil.calcLongPercents(disCount, val);
            n.setPercent(perc);
            result.add(n);
        }
        return result;
    }

    /**
     * 获取未年报企业一级行业分布
     *
     * @return
     */
    @Override
    @Cacheable(value = CacheConstants.STATISTIC_COMPANY, keyGenerator = "simpleKeyGenerator")
    public List<NameValueNodeInfo> getUnannualIndustryDistribute(String district) {
        Integer total = annualStatisticsDao.selectUnannualedCount(district);
        List<NameValueInfo> infos = annualStatisticsDao.selectUnannualIndustryDistribute(district);
        List<NameValueNodeInfo> result = transfer(infos, total);

        // 转行业编码为中文名称
        addIndustryDesc(result);

        return result;
    }

    /**
     * 获取未年报企业企业性质分布
     *
     * @param district
     * @return
     */
    @Override
    @Cacheable(value = CacheConstants.STATISTIC_COMPANY, keyGenerator = "simpleKeyGenerator")
    public List<NameValueNodeInfo> getUnannualPropertyDistribute(String district) {
        Integer total = annualStatisticsDao.selectUnannualedCount(district);
        List<NameValueInfo> infos = annualStatisticsDao.selectUnannualPropertyDistribute(district);
        infos = processCompanyPropertyInfo(infos);
        List<NameValueNodeInfo> temp = transfer(infos, total);

        // 补全数据
        List<NameValueNodeInfo> result = fillCompanyCountByProperty(temp);
        return result;
    }

    // 补全数据
    private List<NameValueNodeInfo> fillCompanyCountByProperty(List<NameValueNodeInfo> infos) {
        // 初始化
        NameValueNodeInfo[] result = { new NameValueNodeInfo(CompanyTypeNew.PRIVATE_CN, 0, "0%"), new NameValueNodeInfo(CompanyTypeNew.STATE_OWNED_CN, 0, "0%"),
                new NameValueNodeInfo(CompanyTypeNew.FOREIGN_CN, 0, "0%") };

        // 补全查询数据库没有的值
        for (NameValueNodeInfo info : infos) {
            Integer type = (Integer) info.getName();
            switch (type) {
                case CompanyTypeNew.PRIVATE:
                    info.setName(CompanyType.getTypeCN(type));
                    result[0] = info;
                    break;
                case CompanyTypeNew.STATE_OWNED:
                    info.setName(CompanyType.getTypeCN(type));
                    result[1] = info;
                    break;
                case CompanyTypeNew.FOREIGN:
                    info.setName(CompanyType.getTypeCN(type));
                    result[2] = info;
                    break;
                default:
                    break;
            }
        }
        return Arrays.asList(result);
    }

    private void addDistrictDescForCompanyAddr(List<CompanyAddrStaticInfo> infos) {
        Map<String, String> dsMap = addressService.getDistrictCodeMap(Constants.GUIYANG_CODE);
        for (NameValueNodeInfo info : infos) {
            info.setName(dsMap.get(info.getName()));
        }
    }

    /**
     * 利用行业编码，转为中文名称
     *
     * @param infos
     */
    private void addIndustryDesc(List<NameValueNodeInfo> infos) {
        Map<String, String> inMap = companyUtil.getPrimaryIndustryMap();
        for (NameValueNodeInfo info : infos) {
            info.setName(inMap.get(info.getName()));
        }
    }

    /**
     * 获取指定区域指定异常企业数量
     *
     * @param abnormalState
     * @param district
     * @return
     */
    @Override
    @Cacheable(value = CacheConstants.STATISTIC_COMPANY, keyGenerator = "simpleKeyGenerator")
    public Integer queryPartialAbnormalCount(int abnormalState, String district) {
        return doQueryPartialAbnormalCount(abnormalState, district);
    }

    private Integer doQueryPartialAbnormalCount(int abnormalState, String district) {
        return abnormalStatisticsDao.queryPartialAbnormalCount(abnormalState, district);
    }

    /**
     * 获取指定异常企业区域数量分布
     *
     * @param abnormalState
     * @return
     */
    @Override
    @Cacheable(value = CacheConstants.STATISTIC_COMPANY, keyGenerator = "simpleKeyGenerator")
    public List<CompanyAddrStaticInfo> queryAbnormalCompanyDistribute(int abnormalState) {
        List<CompanyAddrStaticInfo> infos = abnormalStatisticsDao.queryAbnormalCompanyDistribute(abnormalState);
        Map<String, Long> disCount = companyUtil.getCompanyCoutByDistrict();
        List<CompanyAddrStaticInfo> result = transferCompanyAddr(infos, disCount);
        addDistrictDescForCompanyAddr(result);
        fillDestrictData(result);
        return result;
    }

    /**
     * 获取指定区域指定异常类型企业的行业分布
     *
     * @param abnormalState
     * @param district
     * @return
     */
    @Override
    @Cacheable(value = CacheConstants.STATISTIC_COMPANY, keyGenerator = "simpleKeyGenerator")
    public List<NameValueNodeInfo> queryAbnormalIndustryDistribute(int abnormalState, String district) {
        Integer total = doQueryPartialAbnormalCount(abnormalState, district);
        List<NameValueInfo> infos = abnormalStatisticsDao.queryAbnormalIndustryDistribute(abnormalState, district);
        List<NameValueNodeInfo> result = transfer(infos, total);
        addIndustryDesc(result);
        return result;
    }

    /**
     * 获取指定区域指定异常类型企业的性质分布
     *
     * @param abnormalState
     * @param district
     * @return
     */
    @Override
    @Cacheable(value = CacheConstants.STATISTIC_COMPANY, keyGenerator = "simpleKeyGenerator")
    public List<NameValueNodeInfo> queryAbnormalPropertyDistribute(int abnormalState, String district) {
        Integer total = doQueryPartialAbnormalCount(abnormalState, district);
        List<NameValueInfo> infos = abnormalStatisticsDao.queryAbnormalPropertyDistribute(abnormalState, district);
        List<NameValueNodeInfo> temp = transfer(infos, total);
        List<NameValueNodeInfo> result = fillCompanyCountByProperty(temp);
        return result;
    }

    /**
     * 获取指定区域一年的移除量
     *
     * @param abnormalState
     * @param district
     * @return
     */
    @Override
    @Cacheable(value = CacheConstants.STATISTIC_COMPANY, keyGenerator = "simpleKeyGenerator")
    public int queryAbnormalYearRemoveCount(Integer abnormalState, int year, String district) {
        return abnormalStatisticsDao.queryAbnormalYearRemoveCount(abnormalState, year, district);
    }

    /**
     * 获取指定区域指定月的移除量
     *
     * @param abnormalState
     * @param district
     * @return
     */
    @Override
    @Cacheable(value = CacheConstants.STATISTIC_COMPANY, keyGenerator = "simpleKeyGenerator")
    public int queryAbnormalMonthRemoveCount(Integer abnormalState, int year, int month, String district) {
        return abnormalStatisticsDao.queryAbnormalMonthRemoveCount(abnormalState, year, month, district);
    }

    /**
     * 获取指定区域指定月的新增量
     *
     * @param abnormalState
     * @param year
     * @param month
     * @param district
     * @return
     */
    @Override
    @Cacheable(value = CacheConstants.STATISTIC_COMPANY, keyGenerator = "simpleKeyGenerator")
    public int queryAbnormalMonthAddCount(Integer abnormalState, int year, int month, String district) {
        return abnormalStatisticsDao.queryAbnormalMonthAddCount(abnormalState, year, month, district);
    }

}
