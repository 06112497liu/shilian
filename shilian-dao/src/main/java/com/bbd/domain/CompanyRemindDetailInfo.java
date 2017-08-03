package com.bbd.domain;

import java.util.Date;

public class CompanyRemindDetailInfo {
    private Integer id;

    private String nbxh;

    private Integer taskId;

    private Integer method;

    private String source;

    private String target;

    private String content;

    private Integer status;

    private Date sendTime;

    private String reason;

    private Integer sendYear;

    private Integer sendMonth;

    private Date gmtModified;

    private Date gmtCreate;

    private Integer type;

    private String district;

    private Integer sendDay;

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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Integer getSendDay() {
        return sendDay;
    }

    public void setSendDay(Integer sendDay) {
        this.sendDay = sendDay;
    }
}