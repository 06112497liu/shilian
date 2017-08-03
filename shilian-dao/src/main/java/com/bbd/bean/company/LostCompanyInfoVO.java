/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.bean.company;

import java.util.Date;

/**
 * 失联企业信息，用于失联多维度查询
 * @author tjwang
 * @version $Id: LostCompanyInfoVO.java, v 0.1 2017/6/15 0015 15:41 tjwang Exp $
 */
public class LostCompanyInfoVO {

    private Integer companyId;

    private String  nbxh;

    private String  companyCreditCode;

    private String  companyName;

    private String  district;

    private String  addr;

    private String  primaryIndustry;

    private Integer companyProperty;

    private Date    gmtCompanyRegister;

    private Date    lostCheckInTime;

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getNbxh() {
        return nbxh;
    }

    public void setNbxh(String nbxh) {
        this.nbxh = nbxh;
    }

    public String getCompanyCreditCode() {
        return companyCreditCode;
    }

    public void setCompanyCreditCode(String companyCreditCode) {
        this.companyCreditCode = companyCreditCode;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getPrimaryIndustry() {
        return primaryIndustry;
    }

    public void setPrimaryIndustry(String primaryIndustry) {
        this.primaryIndustry = primaryIndustry;
    }

    public Integer getCompanyProperty() {
        return companyProperty;
    }

    public void setCompanyProperty(Integer companyProperty) {
        this.companyProperty = companyProperty;
    }

    public Date getGmtCompanyRegister() {
        return gmtCompanyRegister;
    }

    public void setGmtCompanyRegister(Date gmtCompanyRegister) {
        this.gmtCompanyRegister = gmtCompanyRegister;
    }

    public Date getLostCheckInTime() {
        return lostCheckInTime;
    }

    public void setLostCheckInTime(Date lostCheckInTime) {
        this.lostCheckInTime = lostCheckInTime;
    }
}
