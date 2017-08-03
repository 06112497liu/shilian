/** 
 * BBD Service Inc 
 * All Rights Reserved @2017 
 */
package com.bbd.dao.statistics;

import com.bbd.bean.statistics.CompanyAddrStaticInfo;
import com.bbd.bean.statistics.NameValueInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/** 
 *  异常企业 数据访问接口
 *  
 * @author liuweibo 
 * @version $Id: AbnormalStatisticsDao.java, v 0.1 2017年5月3日 上午10:53:24 wangwei Exp $ 
 */
public interface AbnormalStatisticsDao {

    /**
     * @param district
     * @return 异常企业数量
     */
    Integer selectAbnormalCount(@Param("district") String district);

    /**
     * 获取指定区域指定异常企业数量
     * @param abnormalState
     * @param district
     * @return
     */
    Integer queryPartialAbnormalCount(@Param("abnormalState") Integer abnormalState, @Param("district") String district);

    /**
     * 获取指定异常企业区域数量分布
     * @param abnormalState
     * @return
     */
    List<CompanyAddrStaticInfo> queryAbnormalCompanyDistribute(@Param("abnormalState") Integer abnormalState);

    /**
     * 获取指定区域指定异常类型企业的行业分布
     * @param abnormalState
     * @param district
     * @return
     */
    List<NameValueInfo> queryAbnormalIndustryDistribute(@Param("abnormalState") Integer abnormalState, @Param("district") String district);

    /**
     * 获取指定区域指定异常类型企业的性质分布
     * @param abnormalState
     * @param district
     * @return
     */
    List<NameValueInfo> queryAbnormalPropertyDistribute(@Param("abnormalState") Integer abnormalState, @Param("district") String district);

    /**
     * 获取指定区域一年的移除量
     * @param abnormalState
     * @param district
     * @return
     */
    int queryAbnormalYearRemoveCount(@Param("abnormalState") Integer abnormalState, @Param("year") int year, @Param("district") String district);

    /**
     * 获取指定区域指定月的移除量
     * @param abnormalState
     * @param district
     * @return
     */
    int queryAbnormalMonthRemoveCount(@Param("abnormalState") Integer abnormalState, @Param("year") int year, @Param("month") int month, @Param("district") String district);
    
    /**
     * 获取指定区域指定月的新增量
     * @param abnormalState
     * @param district
     * @return
     */
    int queryAbnormalMonthAddCount(@Param("abnormalState") Integer abnormalState, @Param("year") int year, @Param("month") int month, @Param("district") String district);

}
