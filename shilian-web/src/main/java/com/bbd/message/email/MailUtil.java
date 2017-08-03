/*
 * Copyright (c) BrandBigData.com Inc.
 * All Rights Reserved 2017.
 */

/**
 * BBD Service Inc
 * AllRight Reserved @2017
 */
package com.bbd.message.email;

import com.bbd.Constants;
import com.bbd.util.ConfigUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

/**
 * 邮件工具
 * 
 * @author xc
 * @version $Id: MailUtil.java, v 0.1 2016年12月5日 下午1:31:04 xc Exp $
 */
public class MailUtil {
    private static Logger log = LoggerFactory.getLogger(MailUtil.class);

    /**
     * 参数处理
     * 
     * @return
     */
    private static Properties getProperties() {
        Properties p = new Properties();
        p.put("mail.smtp.host", ConfigUtil.getMailServerHost());
        p.put("mail.smtp.port", ConfigUtil.getMailServerPort());
        p.put("mail.smtp.auth", true);
        return p;
    }

    /**
     * session获取
     * 
     * @return
     */
    public static Session getSession(String username, String password, String host, String port) {
        // 判断是否需要身份认证
        EmailAuthenticator authenticator = null;
        Properties pro = new Properties();
        pro.put("mail.smtp.auth", true);
        pro.put("mail.smtp.host", host);
        pro.put("mail.smtp.port", port);
        authenticator = new EmailAuthenticator(username, password);
        // 根据邮件会话属性和密码验证器构造一个发送邮件的session
        Session sendMailSession = Session.getDefaultInstance(pro, authenticator);
        return sendMailSession;
    }

    /**
     * messsage获取
     * 
     * @param
     * @param mailSession
     * @return
     * @throws Exception
     */
    public static Message getMessage(String mailFromAddress, String mailToAddresse, Session mailSession, String content, String subject) throws Exception {

        // 根据session创建一个邮件消息
        Message mailMessage = new MimeMessage(mailSession);
        // 创建邮件发送者地址
        Address from = new InternetAddress(mailFromAddress);
        // 设置邮件消息的发送者
        mailMessage.setFrom(from);
        // 创建邮件的接收者地址，并设置到邮件消息中
        //        InternetAddress[] addresses = new InternetAddress[mailAddresses.size()];
        //        for (int i = 0; i < mailAddresses.size(); i++) {
        //            addresses[i] = new InternetAddress(mailAddresses.get(i));
        //        }
        //        mailMessage.addRecipients(Message.RecipientType.TO, addresses);
        mailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(mailToAddresse));
        // 设置邮件消息的主题
        mailMessage.setSubject(subject);
        // 设置邮件消息发送的时间
        mailMessage.setSentDate(new Date());
        // 设置邮件消息的主要内容
        mailMessage.setText(content);
        // 发送邮件
        return mailMessage;
    }

    /**
     * 发送邮件
     * 
     * @param
     * @return
     */
    public static String sendMail(String mailFromAddress, Session seesion, String mailToAddress, String content, String subject) {

        try {
            Message message = MailUtil.getMessage(mailFromAddress, mailToAddress, seesion, content, subject);
            Transport.send(message);
            return Constants.SUCCESS;
        } catch (Exception e) {
            log.error(e.getMessage());
            return e.getMessage();
        }
    }

    /**
     * 获取用户
     * 
     * @param userNameAndPassWord
     * @return
     */
    public static String getUserName(String userNameAndPassWord) {
        if (userNameAndPassWord.indexOf("/") > 0) {
            return userNameAndPassWord.split("/")[0];
        }
        return null;

    }

    /**
     * 获取密码
     * 
     * @param userNameAndPassWord
     * @return
     */
    public static String getPassWord(String userNameAndPassWord) {
        if (userNameAndPassWord.indexOf("/") > 0) {
            return userNameAndPassWord.split("/")[1];
        }
        return null;
    }

    /**
     * 获取用户密码
     */
    public static String getUserNameAndPassWord() {
        String userNameAndPassWordStr = ConfigUtil.getServerUserNameAndPassWord();
        if (userNameAndPassWordStr.indexOf(",") > 0) {
            String[] userNameAndPassWords = userNameAndPassWordStr.split(",");
            Random rand = new Random();
            int num = rand.nextInt(userNameAndPassWords.length);
            return userNameAndPassWords[num];
        }
        return userNameAndPassWordStr;
    }
}
