package com.bbd.domain;

import java.util.Date;

public class BusinessMonthStatisticsInfo {
    private Integer id;

    private String nbxh;

    private Integer activityYear;

    private Integer activityMonth;

    private Double activityExponent;

    private Integer activityScoreType;

    private String district;

    private Integer companyState;

    private String primaryIndustry;

    private String companyProperty;

    private Date gmtCompanyRegister;

    private String businessRecords;

    private Date gmtCreate;

    private Date gmtModified;

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

    public Double getActivityExponent() {
        return activityExponent;
    }

    public void setActivityExponent(Double activityExponent) {
        this.activityExponent = activityExponent;
    }

    public Integer getActivityScoreType() {
        return activityScoreType;
    }

    public void setActivityScoreType(Integer activityScoreType) {
        this.activityScoreType = activityScoreType;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Integer getCompanyState() {
        return companyState;
    }

    public void setCompanyState(Integer companyState) {
        this.companyState = companyState;
    }

    public String getPrimaryIndustry() {
        return primaryIndustry;
    }

    public void setPrimaryIndustry(String primaryIndustry) {
        this.primaryIndustry = primaryIndustry;
    }

    public String getCompanyProperty() {
        return companyProperty;
    }

    public void setCompanyProperty(String companyProperty) {
        this.companyProperty = companyProperty;
    }

    public Date getGmtCompanyRegister() {
        return gmtCompanyRegister;
    }

    public void setGmtCompanyRegister(Date gmtCompanyRegister) {
        this.gmtCompanyRegister = gmtCompanyRegister;
    }

    public String getBusinessRecords() {
        return businessRecords;
    }

    public void setBusinessRecords(String businessRecords) {
        this.businessRecords = businessRecords;
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