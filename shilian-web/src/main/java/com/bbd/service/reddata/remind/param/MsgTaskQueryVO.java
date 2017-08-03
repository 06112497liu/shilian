
/** 
 * BBD Service Inc 
 * All Rights Reserved @2017 
 */
 package com.bbd.service.reddata.remind.param;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/** 
 *  
 * @author liuweibo 
 * @version $Id: MsgTaskQueryVO.java, v 0.1 2017年6月8日 下午5:09:18 liuweibo Exp $ 
 */
@ApiModel( "提示进度列表返回对象" )
public class MsgTaskQueryVO {
    
    private Integer id;

    private Boolean enabled;

    /** 提示类型（1.企业年报提示,2.失联企业提示,3.未年报企业提示,4.未公示企业提示,5.虚假信息企业提示）  */
    @ApiModelProperty( "提示类型" )
    private Integer taskType;
    
    /** 提示方式（1.邮件,2.短信,3.语音） */
    @ApiModelProperty( "提示方式" )
    private Integer method;
    
    /** 提示方式中文描述 */
    @ApiModelProperty( "提示方式中文描述" )
    private String methodDesc;

    /** 操作类型（0.自动,1.手动） */
    @ApiModelProperty( "操作类型" )
    private Integer operationType;
    
    /** 操作类型中文描述 */
    @ApiModelProperty( "操作类型中文描述" )
    private String operationTypeDesc;
    
    /** 提示时间 */
    @JsonFormat(pattern = "yyyy年MM月dd日", timezone = "GMT+8")
    @ApiModelProperty( "提示时间" )
    private Date sendTime;

    /** 提示总量  */
    @ApiModelProperty( "提示总量" )
    private Integer total;

    /** 提示成功数量  */
    @ApiModelProperty( "提示成功数量" )
    private Integer success;

    /** 提示失败数量  */
    @ApiModelProperty( "提示失败数量" )
    private Integer fail;
    
    /** 未提示数量 */
    @ApiModelProperty( "未提示数量" )
    private Integer noRemind;
    
    /** 提示成功率 */
    @ApiModelProperty( "提示成功率" )
    private String successPercent;
    
    /** 提示失败率 */
    @ApiModelProperty( "提示失败率" )
    private String failPercent;
    
    /** 未提示占比 */
    @ApiModelProperty( "未提示占比" )
    private String noRemindPercent;
    
    /** 提示进度 */
    @ApiModelProperty( "提示进度" )
    private String remindSchedule;

    @JsonIgnore
    private Date startTime;

    @JsonIgnore
    private Date endTime;

    @JsonIgnore
    private Integer sendYear;
    
    @JsonIgnore
    private String conditions;
    
    @JsonIgnore
    private Integer operator;

    @JsonIgnore
    private Date gmtCreate;

    @JsonIgnore
    private Date gmtModified;
    
    @JsonIgnore
    private String district;
    
    private static NumberFormat nf = NumberFormat.getPercentInstance();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
    
    public Integer getTaskType() {
        return taskType;
    }

    public void setTaskType( Integer taskType ) {
        this.taskType = taskType;
    }

    public Integer getMethod() {
        return method;
    }

    public void setMethod(Integer method) {
        this.method = method;
    }

    public Integer getOperationType() {
        return operationType;
    }

    public void setOperationType(Integer operationType) {
        this.operationType = operationType;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public Integer getTotal() {
        return total == null ? 0 : total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getSuccess() {
        return success == null ? 0 : success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }

    public Integer getFail() {
        return fail == null ? 0 : fail;
    }

    public void setFail(Integer fail) {
        this.fail = fail;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getSendYear() {
        return sendYear;
    }

    public void setSendYear(Integer sendYear) {
        this.sendYear = sendYear;
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    public Integer getOperator() {
        return operator;
    }

    public void setOperator(Integer operator) {
        this.operator = operator;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }  

    public String getMethodDesc() {
        String str = "-";
        if(method != null) {
            switch(method) {
                case 1:
                    str = "邮件";
                    break;
                case 2:
                    str = "短信";
                    break;
                case 3:
                    str = "语音";
                    break;
            }
        }
        return str;
    }

    public String getOperationTypeDesc() {
        String str = "-";
        if(operationType != null) {
            switch(operationType) {
                case 0:
                    str = "自动";
                    break;
                case 1:
                    str = "手动";
                    break;
            }
        }
        return str;
    }

    public String getRemindSchedule() {
        
        double t = (double)getTotal();
        double haveRemind = (double)(getSuccess() + getFail());
        double result = Math.abs(t) < 0.0001 ? 0.0 : haveRemind / t; 
        
        BigDecimal bg = BigDecimal.valueOf(result);
        double f1 = bg.setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue();
        
        nf.setMinimumFractionDigits(2);
        String rs = nf.format(f1);
        
        return rs;
    }

    public String getSuccessPercent() {
        
        double s = (double)getSuccess();
        double haveRemind = (double)(getSuccess() + getFail());
        double result = Math.abs(haveRemind) < 0.0001 ? 0.0 : s / haveRemind;
        
        BigDecimal bg = BigDecimal.valueOf(result);
        double f1 = bg.setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue();
        
        nf.setMinimumFractionDigits(2);
        String rs = nf.format(f1);
        
        return rs;
    }    

    public Integer getNoRemind() {
        Integer remindTotal = total == null ? 0 : total;
        Integer remindSuccess = success == null ? 0 : success;
        Integer remindFail = fail == null ? 0 : fail;
        return remindTotal - remindSuccess - remindFail;
    }

    public String getFailPercent() {
        
        double s = (double)getFail();
        double haveRemind = (double)(getSuccess() + getFail());
        double result = Math.abs(haveRemind) < 0.0001 ? 0.0 : s / haveRemind;
        
        BigDecimal bg = BigDecimal.valueOf(result);
        double f1 = bg.setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue();
        
        nf.setMinimumFractionDigits(2);
        String rs = nf.format(f1);
        
        return rs;
    }

    public String getNoRemindPercent() {
        
        double s = (double)getNoRemind();
        double total = (double)getTotal();
        double result = Math.abs(s) < 0.0001 ? 0.0 : s / total;
        
        BigDecimal bg = BigDecimal.valueOf(result);
        double f1 = bg.setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue();
        nf.setMinimumFractionDigits(2);
        String rs = nf.format(f1);
        return rs;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict( String district ) {
        this.district = district;
    }
    
}

