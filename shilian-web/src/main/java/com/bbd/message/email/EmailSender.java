/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.message.email;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.util.Properties;

/**
 *
 * @author tjwang
 * @version $Id: EmailSender.java, v 0.1 2017/6/6 0006 14:38 tjwang Exp $
 */
public class EmailSender extends AbstractEmailSender {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private String username;

    private String password;

    private int    port;

    public EmailSender(String username, String password, String host, int port) {
        super(host);
        this.username = username;
        this.password = password;
        this.port = port;
    }

    @Override
    protected EmailResult doSend(String target, String content, String subject) {
        String status = "";
        try {
            Properties pro = new Properties();
            pro.put("mail.smtp.auth", true);
            pro.put("mail.smtp.host", host);
            pro.put("mail.smtp.port", port);
            // 根据邮件会话属性和密码验证器构造一个发送邮件的session
            Session session = Session.getDefaultInstance(pro, new Authenticator() {
                // 在session中设置账户信息，Transport发送邮件时会使用
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });

            status = MailUtil.sendMail(username, session, target, content, subject);
        } catch (Exception e) {
            logger.warn(e.getMessage(), e);
            status = e.getMessage();
        }

        return new EmailResult(status, host);
    }
}
