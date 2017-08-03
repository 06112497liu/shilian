
/** 
 * BBD Service Inc 
 * All Rights Reserved @2017 
 */
 package com.bbd.service.reddata.remind.param;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/** 
 * 查询企业提示详情返回对象
 * @author liuweibo 
 * @version $Id: RemindDetailQueryVo.java, v 0.1 2017年6月9日 上午9:42:06 liuweibo Exp $ 
 */
@ApiModel( "企业提示详情返回对象" )
public class RemindDetailQueryVo {
    
    @JsonIgnore
    private Integer id;

    @ApiModelProperty( "企业内部序号" )
    private String nbxh;
    
    @ApiModelProperty( "任务ID" )
    private Integer taskId;
    
    /** 提示方式  */
    @ApiModelProperty( "提示方式" )
    private Integer method;
    
    /** 提示方式中文描述  */
    @ApiModelProperty( "提示方式中文描述" )
    private String methodDesc;

    @JsonIgnore
    private String source;

    @JsonIgnore
    private String target;

    @JsonIgnore
    private String content;

    /** 提示状态  */
    @ApiModelProperty( "提示状态" )
    private Integer status;
    
    /** 提示状态中文描述  */
    @ApiModelProperty( "提示状态中文描述" )
    private String statusDesc;

    /** 提示时间 */
    @JsonFormat(pattern = "yyyy年MM月dd日", timezone = "GMT+8")
    @ApiModelProperty( "提示时间" )
    private Date sendTime;

    @JsonIgnore
    private String reason;

    @JsonIgnore
    private Integer sendYear;

    @JsonIgnore
    private Integer sendMonth;

    @JsonIgnore
    private Integer operator;

    @JsonIgnore
    private Date gmtModified;
    
    @JsonIgnore
    private Date gmtCreate;    

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

    public String getStatusDesc() {
        String str = "-";
        if(status != null) {
            switch(status) {
                case 1:
                    str = "未提示";
                    break;
                case 2:
                    str = "提示中";
                    break;
                case 3:
                    str = "提示成功";
                    break;
                case 4:
                    str = "提示失败";
                    break;
            }
        }
        return str;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNbxh() {
        return nbxh;
    }

    public void setNbxh(String nbxh) {
        this.nbxh = nbxh;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public Integer getMethod() {
        return method;
    }

    public void setMethod(Integer method) {
        this.method = method;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getSendYear() {
        return sendYear;
    }

    public void setSendYear(Integer sendYear) {
        this.sendYear = sendYear;
    }

    public Integer getSendMonth() {
        return sendMonth;
    }

    public void setSendMonth(Integer sendMonth) {
        this.sendMonth = sendMonth;
    }

    public Integer getOperator() {
        return operator;
    }

    public void setOperator(Integer operator) {
        this.operator = operator;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }


}

