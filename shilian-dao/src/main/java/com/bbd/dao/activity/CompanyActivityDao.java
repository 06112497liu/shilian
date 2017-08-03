package com.bbd.dao.activity;

import org.apache.ibatis.annotations.Param;

/**
 * @author tjwang
 * @version $Id CompanyActivityDao.java, v 0.1 2017/5/4 17:19 tjwang Exp $
 */
public interface CompanyActivityDao {

    /**
     * 创建企业月度经营指数记录
     * com.bbd.service.companyinfo.activity.service.ICompanyActivityService#
     * insertCompanyMonthStatistics(java.utils.List, java.utils.Date)
     */
    void insertCompanyMonthStatistics(@Param("year") int year, @Param("month") int month);

    /**
     * 更新失联状态
     *
     * @param year
     * @param month
     */
    void updateLostState(@Param("year") int year, @Param("month") int month);

    /**
     * 更新已吊销未注销信息
     *
     * @param year
     * @param month
     */
    void updateSuspendNotCancelState(@Param("year") int year, @Param("month") int month);

    /**
     * 更新严重违法
     *
     * @param year
     * @param month
     */
    void updateSeriousIllegal(@Param("year") int year, @Param("month") int month);

    /**
     * 更新指数信息，排除年报、专利
     *
     * @param year
     * @param month
     */
    void updateActivityExponentWithoutAnnual(@Param("year") int year, @Param("month") int month);

    /**
     * 通过年报信息更新活动指数
     *
     * @param year
     * @param month
     */
    void updateActivityExponentByAnnual(@Param("year") int year, @Param("month") int month);

    /**
     * 按月更新企业经营活动类型
     */
    void updateCompanyActivityType(@Param("year") int year, @Param("month") int month);

}
