/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.message.sms;

import com.bbd.utils.SmsUtil;

/**
 *
 * @author tjwang
 * @version $Id: SmsSender.java, v 0.1 2017/6/8 0008 16:55 tjwang Exp $
 */
public class SmsSender implements ISmsSender {

    private static SmsSender instance = new SmsSender();

    private SmsSender() {

    }

    public static SmsSender getInstance() {
        return instance;
    }

    public SmsResult send(String target, String params, String smsTemplateCode) {
        String state = SmsUtil.doSend(target, params, smsTemplateCode);
        return new SmsResult(state);
    }

}
