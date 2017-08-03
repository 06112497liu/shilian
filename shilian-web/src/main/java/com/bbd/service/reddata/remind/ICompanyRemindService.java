/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.service.reddata.remind;

import com.bbd.domain.CompanyRemindDailyCountInfo;
import com.bbd.domain.CompanyRemindDetailInfo;
import com.bbd.domain.CompanyRemindMonthlyCountInfo;
import com.bbd.domain.CompanyRemindStatisticsInfo;

import java.util.List;

/**
 * 企业提醒统计服务
 * @author tjwang
 * @version $Id: ICompanyRemindService.java, v 0.1 2017/6/8 0008 15:11 tjwang Exp $
 */
public interface ICompanyRemindService {

    /**
     * 更新或新增
     * @param nbxh
     * @param sendYear
     * @param method
     */
    void updateOrCreate(boolean success, String nbxh, int sendYear, int method);

    /**
     * 更新或新增
     * @param nbxh
     * @param sendYear
     * @param method
     * @param num
     */
    void updateOrCreate(boolean success, String nbxh, int sendYear, int method, int num);

    /**
     * 插入日发送数量信息。确保每天可以执行多次，但只有一次成功。day是当前的前一天。
     */
    void insertDailyRemindCount(int year, int day);

    /**
     * 插入月发送数量信息。month是当月。每天统计一次。
     */
    void insertMonthlyRemindCount(int year, int month);

    /**
     * 获取指定年中每天统计数量
     * @param year
     * @param type
     * @return
     */
    List<CompanyRemindDailyCountInfo> queryDailyCountInfos(int year, int type, String district);

    /**
     * 获取指定年中每月统计数量
     * @param year
     * @return
     */
    List<CompanyRemindMonthlyCountInfo> queryMonthlyCountInfos(int year, int type, String district);

    /**
     * 获取指定年指定类型提示户数
     * @param year
     * @param type
     * @return
     */
    int getYearRemindCount(int year, int type, String district);

    /**
     * 获取指定月指定类型提示户数
     * @param year
     * @param month
     * @return
     */
    int getMonthReindCount(int year, int month, int type, String district);

    /**
     * 获取企业提示统计信息。
     * @param nbxh
     * @return
     */
    List<CompanyRemindStatisticsInfo> getCompanyRemindStatisticsInfos(String nbxh);

    /**
     * 获取企业最后一次发送的信息
     * @param nbxh
     * @return
     */
    List<CompanyRemindDetailInfo> getCompanyRemindDetailInfos(String nbxh);
}
