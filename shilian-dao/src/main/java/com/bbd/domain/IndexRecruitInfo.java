package com.bbd.domain;

import java.util.Date;

public class IndexRecruitInfo {
    private Integer id;

    private String companyId;

    private Integer indexTypeId;

    private String companyName;

    private Date recruitDate;

    private String recruitNum;

    private String graduate;

    private String recruitPlace;

    private String dataSoruce;

    private Date gmtCreate;

    private String eMail;

    private String contactInformation;

    private String recruitPost;

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

    public Integer getIndexTypeId() {
        return indexTypeId;
    }

    public void setIndexTypeId(Integer indexTypeId) {
        this.indexTypeId = indexTypeId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Date getRecruitDate() {
        return recruitDate;
    }

    public void setRecruitDate(Date recruitDate) {
        this.recruitDate = recruitDate;
    }

    public String getRecruitNum() {
        return recruitNum;
    }

    public void setRecruitNum(String recruitNum) {
        this.recruitNum = recruitNum;
    }

    public String getGraduate() {
        return graduate;
    }

    public void setGraduate(String graduate) {
        this.graduate = graduate;
    }

    public String getRecruitPlace() {
        return recruitPlace;
    }

    public void setRecruitPlace(String recruitPlace) {
        this.recruitPlace = recruitPlace;
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

    public String getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(String contactInformation) {
        this.contactInformation = contactInformation;
    }

    public String getRecruitPost() {
        return recruitPost;
    }

    public void setRecruitPost(String recruitPost) {
        this.recruitPost = recruitPost;
    }
}