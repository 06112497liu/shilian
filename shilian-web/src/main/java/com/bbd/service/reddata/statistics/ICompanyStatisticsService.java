/**
 * BBD Service Inc
 * All Rights Reserved @2017
 */
package com.bbd.service.reddata.statistics;

import com.bbd.bean.biz.CompanyDataCountInfo;
import com.bbd.bean.statistics.CompanyAddrStaticInfo;
import com.bbd.bean.statistics.NameValueNodeInfo;

import java.util.List;

/**
 * @author liuweibo
 * @version $Id: ICompanyStatisticsService.java, v 0.1 2017年5月4日 上午9:15:30 liuweibo Exp $
 */
public interface ICompanyStatisticsService {

    /**
     * 获取当前挖掘的数据总量信息.
     *
     * @return
     */
    CompanyDataCountInfo getCompanyDataCountInfo();

    /**
     * 获取企业总数
     *
     * @return
     */
    Integer getCompanyTotalCount(String district);

    /**
     * 获取已年报企业数量
     *
     * @return
     */
    Integer getAnnualedCount(String district);

    /**
     * 获取当月累计年报
     *
     * @param year
     * @param month
     * @param district
     * @return
     */
    Integer getAnnualedCurrentMonthCount(Integer year, Integer month, String district);

    /**
     * 获取应年报企业总数
     *
     * @return
     */
    Integer getAnnualCompanyCount(String district);

    /**
     * 获取未年报企业数量
     */
    Integer getUnannualedCompanyCount(String district);

    /**
     * 获取被列入异常名录企业数量
     *
     * @return
     */
    Integer getAbnormalCount(String district);

    /**
     * 获取已年报企业区域分布
     *
     * @return
     */
    List<CompanyAddrStaticInfo> getAnnualedCompanyDistribute(String district);

    /**
     * 获取未年报企业一级行业分布
     *
     * @return
     */
    List<NameValueNodeInfo> getUnannualIndustryDistribute(String district);

    /**
     * 获取未年报企业企业性质分布
     *
     * @param district
     * @return
     */
    List<NameValueNodeInfo> getUnannualPropertyDistribute(String district);

    /**
     * 获取指定区域指定异常企业数量
     *
     * @param abnormalState
     * @param district
     * @return
     */
    Integer queryPartialAbnormalCount(int abnormalState, String district);

    /**
     * 获取指定异常企业区域数量分布
     *
     * @param abnormalState
     * @return
     */
    List<CompanyAddrStaticInfo> queryAbnormalCompanyDistribute(int abnormalState);

    /**
     * 获取指定区域指定异常类型企业的行业分布
     *
     * @param abnormalState
     * @param district
     * @return
     */
    List<NameValueNodeInfo> queryAbnormalIndustryDistribute(int abnormalState, String district);

    /**
     * 获取指定区域指定异常类型企业的性质分布
     *
     * @param abnormalState
     * @param district
     * @return
     */
    List<NameValueNodeInfo> queryAbnormalPropertyDistribute(int abnormalState, String district);

    /**
     * 获取指定区域一年的移除量
     *
     * @param abnormalState
     * @param district
     * @return
     */
    int queryAbnormalYearRemoveCount(Integer abnormalState, int year, String district);

    /**
     * 获取指定区域指定月的移除量
     *
     * @param abnormalState
     * @param district
     * @return
     */
    int queryAbnormalMonthRemoveCount(Integer abnormalState, int year, int month, String district);

    /**
     * 获取指定区域指定月的新增量
     *
     * @param abnormalState
     * @param year
     * @param month
     * @param district
     * @return
     */
    int queryAbnormalMonthAddCount(Integer abnormalState, int year, int month, String district);

}
