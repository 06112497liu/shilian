/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.message.email;

import com.bbd.common.ResultConst;
import org.joda.time.DateTime;
import org.joda.time.Seconds;

/**
 * @author tjwang
 * @version $Id: AbstractEmailSender.java, v 0.1 2017/6/7 0007 10:05 tjwang Exp $
 */
public abstract class AbstractEmailSender {

    protected String   host;

    /**
     * 超限时间
     */
    protected DateTime outTime;

    public AbstractEmailSender(String host) {
        this.host = host;
    }

    public boolean isOutOfLimit() {
        DateTime dateTime = new DateTime();
        if (outTime == null) {
            return false;
        }
        int secs = Seconds.secondsBetween(outTime, dateTime).getSeconds();
        // 超限15分钟后，重试。
        if (secs >= 900) {
            outTime = null;
            return false;
        }

        return true;
    }

    public EmailResult send(String target, String content, String subject) {
        if (isOutOfLimit()) {
            return new EmailResult(ResultConst.EMAIL_EXCEPTION_OUT_OF_LIMIT, host);
        }

        EmailResult result = doSend(target, content, subject);
        if (result.isLimitReached()) {
            DateTime dateTime = new DateTime();
            outTime = dateTime;
        }

        return result;
    }

    protected abstract EmailResult doSend(String target, String content, String subject);

}
