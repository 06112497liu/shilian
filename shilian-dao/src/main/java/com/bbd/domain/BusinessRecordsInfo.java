package com.bbd.domain;

import java.util.Date;

public class BusinessRecordsInfo {
    private String nbxh;

    private Integer contentType;

    private String content;

    private Double recordScore;

    private Date gmtCreate;

    private Date gmtModified;

    private Date gmtActivity;

    private Date gmtRecord;

    private Integer activityYear;

    private Integer activityMonth;

    public String getNbxh() {
        return nbxh;
    }

    public void setNbxh(String nbxh) {
        this.nbxh = nbxh;
    }

    public Integer getContentType() {
        return contentType;
    }

    public void setContentType(Integer contentType) {
        this.contentType = contentType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Double getRecordScore() {
        return recordScore;
    }

    public void setRecordScore(Double recordScore) {
        this.recordScore = recordScore;
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

    public Date getGmtActivity() {
        return gmtActivity;
    }

    public void setGmtActivity(Date gmtActivity) {
        this.gmtActivity = gmtActivity;
    }

    public Date getGmtRecord() {
        return gmtRecord;
    }

    public void setGmtRecord(Date gmtRecord) {
        this.gmtRecord = gmtRecord;
    }

    public Integer getActivityYear() {
        return activityYear;
    }

    public void setActivityYear(Integer activityYear) {
        this.activityYear = activityYear;
    }

    public Integer getActivityMonth() {
        return activityMonth;
    }

    public void setActivityMonth(Integer activityMonth) {
        this.activityMonth = activityMonth;
    }
}