package com.bbd.domain;

import java.util.Date;

public class IndexPurchaseInfo {
    private Integer id;

    private String companyId;

    private String companyName;

    private Integer indexTypeId;

    private Date releaseDate;

    private String industry;

    private String region;

    private String projectName;

    private Boolean isTender;

    private String dataSoruce;

    private Date gmtCreate;

    private String eMail;

    private String telephone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Integer getIndexTypeId() {
        return indexTypeId;
    }

    public void setIndexTypeId(Integer indexTypeId) {
        this.indexTypeId = indexTypeId;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Boolean getIsTender() {
        return isTender;
    }

    public void setIsTender(Boolean isTender) {
        this.isTender = isTender;
    }

    public String getDataSoruce() {
        return dataSoruce;
    }

    public void setDataSoruce(String dataSoruce) {
        this.dataSoruce = dataSoruce;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}