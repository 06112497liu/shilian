package com.bbd.domain;

import java.util.Date;

public class AnnualReportInfo {
    private Integer id;

    private Integer companyId;

    private String companyName;

    private String phones;

    private String emails;

    private Integer annualStatus;

    private Date createTime;

    private Date updateTime;

    private Date gmtAnnual;

    private String gmtAnnualYear;

    private String remarks;

    private String addr;

    private String province;

    private String city;

    private String district;

    private String nbxh;

    private String companyType;

    private Date gmtCreate;

    private Date gmtModified;

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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPhones() {
        return phones;
    }

    public void setPhones(String phones) {
        this.phones = phones;
    }

    public String getEmails() {
        return emails;
    }

    public void setEmails(String emails) {
        this.emails = emails;
    }

    public Integer getAnnualStatus() {
        return annualStatus;
    }

    public void setAnnualStatus(Integer annualStatus) {
        this.annualStatus = annualStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getGmtAnnual() {
        return gmtAnnual;
    }

    public void setGmtAnnual(Date gmtAnnual) {
        this.gmtAnnual = gmtAnnual;
    }

    public String getGmtAnnualYear() {
        return gmtAnnualYear;
    }

    public void setGmtAnnualYear(String gmtAnnualYear) {
        this.gmtAnnualYear = gmtAnnualYear;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getNbxh() {
        return nbxh;
    }

    public void setNbxh(String nbxh) {
        this.nbxh = nbxh;
    }

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
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
}