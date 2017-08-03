/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.message.sms;

/**
 * 短信发送者
 * @author tjwang
 * @version $Id: ISmsSender.java, v 0.1 2017/6/8 0008 16:59 tjwang Exp $
 */
public interface ISmsSender {

    SmsResult send(String target, String params, String smsTemplateCode);

}
