/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.message.email;

import com.bbd.Constants;

/**
 *
 * @author tjwang
 * @version $Id: EmailResult.java, v 0.1 2017/6/6 0006 15:34 tjwang Exp $
 */
public class EmailResult {

    private String host;

    private String message;

    public EmailResult(String message, String host) {
        this.message = message;
        this.host = host;
    }

    public boolean isSuccess() {
        return Constants.SUCCESS.equals(message);
    }

    /**
     * 是否达到日配额
     */
    public boolean isLimitReached() {
        return message.contains("554");
    }

    public String getMessage() {
        return message;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }
}
