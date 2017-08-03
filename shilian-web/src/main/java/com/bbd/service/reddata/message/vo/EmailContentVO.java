/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.service.reddata.message.vo;

import com.bbd.util.StringUtils;

/**
 * 通过发送类型，获取对应的邮件主题和内容
 * @author tjwang
 * @version $Id: EmailContentVO.java, v 0.1 2017/6/20 0020 10:34 tjwang Exp $
 */
public class EmailContentVO {

    /**
     * 主题
     */
    private String subject;

    /**
     * 内容
     */
    private String content;

    public boolean isBlank() {
        return (StringUtils.isBlank(subject) || StringUtils.isBlank(content));
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
