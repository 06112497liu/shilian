package com.bbd.domain;

import java.util.Date;

public class CompanyRemindStatisticsInfo {
    private Integer id;

    private String nbxh;

    private Integer mailSuccess;

    private Integer mailFail;

    private Integer msgSuccess;

    private Integer msgFail;

    private Integer voiceSuccess;

    private Integer voiceFail;

    private Integer sendYear;

    private Date gmtModified;

    private Date gmtCreate;

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

    public Integer getMailSuccess() {
        return mailSuccess;
    }

    public void setMailSuccess(Integer mailSuccess) {
        this.mailSuccess = mailSuccess;
    }

    public Integer getMailFail() {
        return mailFail;
    }

    public void setMailFail(Integer mailFail) {
        this.mailFail = mailFail;
    }

    public Integer getMsgSuccess() {
        return msgSuccess;
    }

    public void setMsgSuccess(Integer msgSuccess) {
        this.msgSuccess = msgSuccess;
    }

    public Integer getMsgFail() {
        return msgFail;
    }

    public void setMsgFail(Integer msgFail) {
        this.msgFail = msgFail;
    }

    public Integer getVoiceSuccess() {
        return voiceSuccess;
    }

    public void setVoiceSuccess(Integer voiceSuccess) {
        this.voiceSuccess = voiceSuccess;
    }

    public Integer getVoiceFail() {
        return voiceFail;
    }

    public void setVoiceFail(Integer voiceFail) {
        this.voiceFail = voiceFail;
    }

    public Integer getSendYear() {
        return sendYear;
    }

    public void setSendYear(Integer sendYear) {
        this.sendYear = sendYear;
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