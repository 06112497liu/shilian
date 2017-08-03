package com.bbd.service.reddata.activity;

/**
 * 企业活动服务
 *
 * @author wangtianjing
 * @version $Id ICompanyInfoService.java, v 0.1 2017/5/4 14:53 wangtianjing Exp $
 */
public interface ICompanyActivityService {

    /**
     * 生成月活动记录，并计算活动指数
     *
     * @param year
     * @param month
     */
    void generateMonthStatistic(int year, int month);

    /**
     * 冗余经营活动信息到bbd_enterprise_info中
     *
     * @param year
     * @param month
     */
    void updateCompanyBusinessInfo(int year, int month);

}
