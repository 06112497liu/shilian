/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.service.utils;

import com.bbd.message.sms.ISmsSender;
import com.bbd.message.sms.MockSmsSender;
import com.bbd.message.sms.SmsResult;
import com.bbd.message.sms.SmsSender;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * 短信发送工具类。以委托的SmsSender发送短信
 *
 * @author tjwang
 * @version $Id: SmsSenders.java, v 0.1 2017/6/20 0020 9:37 tjwang Exp $
 */
@Service
public class SmsSenders {

    private ISmsSender smsSender;

    @Value("${sms.mock.enable:false}")
    private boolean    smsMockEnable = false;

    @PostConstruct
    public void init() {
        if (smsMockEnable) {
            smsSender = MockSmsSender.getInstance();
        } else {
            smsSender = SmsSender.getInstance();
        }
    }

    public SmsResult send(String target, String params, String smsTemplateCode) {
        return smsSender.send(target, params, smsTemplateCode);
    }

}
