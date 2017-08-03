/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.message.sms;

import com.bbd.util.RandomUtil;

/**
 * 模拟短信发送
 * @author tjwang
 * @version $Id: MockSmsSender.java, v 0.1 2017/6/8 0008 16:59 tjwang Exp $
 */
public class MockSmsSender implements ISmsSender {

    private static final MockSmsSender instance = new MockSmsSender();

    private MockSmsSender() {

    }

    public static MockSmsSender getInstance() {
        return instance;
    }

    @Override
    public SmsResult send(String target, String params, String smsTemplateCode) {
        SmsResult result = new SmsResult();
        int r = RandomUtil.getRandom(100);
        if (r < 30) {
            result.setState("Send Sms Error");
        }
        return result;
    }

}
