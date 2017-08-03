
/** 
 * BBD Service Inc 
 * All Rights Reserved @2017 
 */
 package com.bbd.service.reddata.remind.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/** 
 *  
 * @author liuweibo 
 * @version $Id: CompanyReminCount.java, v 0.1 2017年6月13日 上午11:37:36 liuweibo Exp $ 
 */
@ApiModel("提示状态返回对象")
public class CompanyRemindCount {
    
    @ApiModelProperty("邮件提示状态（0-未提示，1-提示成功， 2-提示失败）")
    private Integer emailStatus = 0;
    
    @ApiModelProperty("邮件提示数量")
    private Integer emailCount = 0;
    
    @ApiModelProperty("短信提示状态（0-未提示，1-提示成功， 2-提示失败）")
    private Integer smsStatus = 0;
    
    @ApiModelProperty("短信提示数量")
    private Integer smsCount = 0;
    
    @ApiModelProperty("短信提示状态（0-未提示，1-提示成功， 2-提示失败）")
    private Integer vmsStatus = 0;
    
    @ApiModelProperty("语音提示数量")
    private Integer vmsCount = 0;

    public Integer getEmailStatus() {
        return emailStatus;
    }

    public void setEmailStatus( Integer emailStatus ) {
        this.emailStatus = emailStatus;
    }

    public Integer getEmailCount() {
        return emailCount;
    }

    public void setEmailCount( Integer emailCount ) {
        this.emailCount = emailCount;
    }

    public Integer getSmsStatus() {
        return smsStatus;
    }

    public void setSmsStatus( Integer smsStatus ) {
        this.smsStatus = smsStatus;
    }

    public Integer getSmsCount() {
        return smsCount;
    }

    public void setSmsCount( Integer smsCount ) {
        this.smsCount = smsCount;
    }

    public Integer getVmsStatus() {
        return vmsStatus;
    }

    public void setVmsStatus( Integer vmsStatus ) {
        this.vmsStatus = vmsStatus;
    }

    public Integer getVmsCount() {
        return vmsCount;
    }

    public void setVmsCount( Integer vmsCount ) {
        this.vmsCount = vmsCount;
    }
    

}

