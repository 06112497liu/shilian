/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.dao.remind;

import org.apache.ibatis.annotations.Param;

/**
 * 企业提示详情扩展表
 * @author tjwang
 * @version $Id: CompanyRemindDetailExtDao.java, v 0.1 2017/6/12 0012 15:27 tjwang Exp $
 */
public interface CompanyRemindDetailExtDao {

    /**
     * 插入日发送数量信息
     */
    void insertDailyRemindCount(@Param("year") Integer year, @Param("day") Integer day);

    /**
     * 删除指定日期数据
     * @param year
     * @param day
     */
    void deleteDailyRemindByDay(@Param("year") Integer year, @Param("day") Integer day);

    /**
     * 插入月发送数量信息
     */
    void insertMonthlyRemindCount(@Param("year") Integer year, @Param("month") Integer month);

    /**
     * 删除指定月数据
     * @param year
     * @param month
     */
    void deleteMonthlyRemindByMonth(@Param("year") Integer year, @Param("month") Integer month);
}
