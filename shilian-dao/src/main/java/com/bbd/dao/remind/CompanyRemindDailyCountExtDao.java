/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.dao.remind;

import org.apache.ibatis.annotations.Param;

/**
 *
 * @author tjwang
 * @version $Id: CompanyRemindDailyCountExtDao.java, v 0.1 2017/6/12 0012 17:28 tjwang Exp $
 */
public interface CompanyRemindDailyCountExtDao {

    /**
     * 查询当前年提示数量
     * @param year
     * @param type
     * @return
     */
    int queryYearRemindCount(@Param("year") int year, @Param("type") int type, @Param("district") String district);

    /**
     * 查询指定时间范围提示数量
     * @param year
     * @param month
     * @param type
     * @return
     */
    int queryMonthRemindCount(@Param("year") int year, @Param("month") int month, @Param("type") int type, @Param("district") String district);

}
