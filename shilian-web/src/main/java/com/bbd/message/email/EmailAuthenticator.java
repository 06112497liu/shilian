/*
 * Copyright (c) BrandBigData.com Inc.
 * All Rights Reserved 2017.
 */

/**
 * BBD Service Inc
 * AllRight Reserved @2017
 */
package com.bbd.message.email;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * 邮件权限
 * 
 * @author xc
 * @version $Id: EmailAuthenticator.java, v 0.1 2016年12月5日 下午1:30:14 xc Exp $
 */
public class EmailAuthenticator extends Authenticator {
    /**
     * 账号
     */
    String userName = null;
    /**
     * 密码
     */
    String password = null;

    public EmailAuthenticator() {
    }

    public EmailAuthenticator(String username, String password) {
        this.userName = username;
        this.password = password;
    }

    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(userName, password);
    }
}
