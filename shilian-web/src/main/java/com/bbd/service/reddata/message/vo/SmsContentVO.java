/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.service.reddata.message.vo;

import com.bbd.util.StringUtils;

/**
 * 通过发送类型，获取对应的模板ID和参数
 * @author tjwang
 * @version $Id: SmsContentVO.java, v 0.1 2017/6/20 0020 10:26 tjwang Exp $
 */
public class SmsContentVO {

    /**
     * 模板ID
     */
    private String smsTemplateCode;

    /**
     * 参数
     */
    private String param;

    /**
     * smsTemplateCode是否为空
     * @return
     */
    public boolean isBlank() {
        return StringUtils.isBlank(smsTemplateCode);
    }

    public String getSmsTemplateCode() {
        return smsTemplateCode;
    }

    public void setSmsTemplateCode(String smsTemplateCode) {
        this.smsTemplateCode = smsTemplateCode;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }
}
