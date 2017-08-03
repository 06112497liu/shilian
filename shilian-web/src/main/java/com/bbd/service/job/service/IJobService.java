/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.service.job.service;

/**
 * @author tjwang
 * @version $Id: JobService.java, v 0.1 2017/6/27 0027 16:01 tjwang Exp $
 */
public interface IJobService {

    /**
     * 发送年报提醒邮件
     */
    void sendAnnualRemindEmail();

    /**
     * 发送年报提醒短信
     */
    void sendAnnualRemindSms();

    /**
     * 发送失联提醒邮件
     */
    void sendLostRemindEmail();

    /**
     * 发送失联提醒短信
     */
    void sendLostRemindSms();

    /**
     * 发送未公示提醒邮件
     */
    void sendUnpublishRemindEmail();

    /**
     * 发送未公示提醒短信
     */
    void sendUnpublishRemindSms();

    /**
     * 发送未年报提醒邮件
     */
    void sendUnannualRemindEmail();

    /**
     * 发送未年报提醒短信
     */
    void sendUnannualRemindSms();

    /**
     * 发送年报提醒邮件
     */
    void sendFakeInfoRemindEmail();

    /**
     * 发送年报提醒短信
     */
    void sendFakeInfoRemindSms();

    /**
     * 月发送消息熟统计
     */
    void executeCompanyRemindSendDailyCountJob();

    /**
     * 月发送消息熟统计
     */
    void executeCompanyRemindSendMonthlyCountJob();

    /**
     * 根据自动提示设置，生成自动提示任务
     */
    void executeAutoRemindGenerate();

    /**
     * 发送queue中的短信
     */
    void executeAutoRemindMessageSend();

    /**
     * 通过任务，生成待发送的信息
     */
    void executeGenerateTaskMessageDetail();

    /**
     * 将企业信息同步到ES
     */
    void syncCompanyToES();

    /**
     * 计算企业活跃度信息
     */
    void calculateCompanyActivity();

    /**
     * 同步企业经营活动信息到bbd_company_info表
     */
    void syncCompanyBusinessRecord();
}
