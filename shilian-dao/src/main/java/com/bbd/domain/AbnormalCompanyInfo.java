package com.bbd.domain;

import java.util.Date;

public class AbnormalCompanyInfo {
    private Integer id;

    private Integer companyId;

    private Date gmtCheckin;

    private Date gmtCreate;

    private Date gmtModified;

    private Date gmtDelete;

    private Integer deleteFlag;

    private Integer addrExceptionType;

    private String nbxh;

    private Integer type;

    private String companyType;

    private String district;

    private Integer remoteId;

    private String auth;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Date getGmtCheckin() {
        return gmtCheckin;
    }

    public void setGmtCheckin(Date gmtCheckin) {
        this.gmtCheckin = gmtCheckin;
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

    public Date getGmtDelete() {
        return gmtDelete;
    }

    public void setGmtDelete(Date gmtDelete) {
        this.gmtDelete = gmtDelete;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Integer getAddrExceptionType() {
        return addrExceptionType;
    }

    public void setAddrExceptionType(Integer addrExceptionType) {
        this.addrExceptionType = addrExceptionType;
    }

    public String getNbxh() {
        return nbxh;
    }

    public void setNbxh(String nbxh) {
        this.nbxh = nbxh;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Integer getRemoteId() {
        return remoteId;
    }

    public void setRemoteId(Integer remoteId) {
        this.remoteId = remoteId;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }
}