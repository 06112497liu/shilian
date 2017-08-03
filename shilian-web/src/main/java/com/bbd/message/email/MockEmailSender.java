/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.message.email;

import com.bbd.Constants;
import com.bbd.common.ResultConst;
import com.bbd.util.RandomUtil;

/**
 *
 * @author tjwang
 * @version $Id: MockEmailSender.java, v 0.1 2017/6/7 0007 11:10 tjwang Exp $
 */
public class MockEmailSender extends AbstractEmailSender {

    public MockEmailSender(String host) {
        super(host);
    }

    @Override
    protected EmailResult doSend(String target, String content, String subject) {
        EmailResult result = new EmailResult(Constants.SUCCESS, host);
        int r = RandomUtil.getRandom(100);
        if (r < 0) {
            result = new EmailResult(ResultConst.EMAIL_EXCEPTION_OUT_OF_LIMIT, host);
        } else if (r < 30) {
            result = new EmailResult("Send Error", host);
        }
        return result;
    }

}
