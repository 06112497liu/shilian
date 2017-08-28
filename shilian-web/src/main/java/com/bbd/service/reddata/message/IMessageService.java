/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.service.reddata.message;

import com.bbd.bean.remind.RemindCompany;

/**
 * 消息发送服务 - 邮件，短信，语音
 * @author tjwang
 * @version $Id: IMessageService.java, v 0.1 2017/6/8 0008 9:43 tjwang Exp $
 */
public interface IMessageService {

    /**
     * 发送提醒邮件
     * @param info
     */
    void sendRemindEmail(RemindCompany info);

    /**
     * 发送提醒短信
     * @param info
     */
    void sendRemindSms(RemindCompany info);

    /**
     * 发送消息提醒，用于自动提示。先发邮件，然后发短信，然后发语音
     * @param info
     */
    //void sendRemindMessage(RemindCompany info);
}
