/**  
 * BBD Service Inc
 * All Rights Reserved @2016
 *
 */
package com.bbd.controller.param;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 失联企业多维查询对象
 *  
 * @author tjwang
 * @version $Id: LostCompanyMultDimQuery.java, v 0.1 2017年6月15日 上午9:27:20 zh Exp $
 */
public class LostCompanyQueryParam {

    /** 企业名称 */
    private String  companyName;

    /** 区筛选 */
    private String  district;

    /** 一级行业 */
    private String  primaryIndustry;

    /** 失联企业入库时间开始起始时间 */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date    gmtCheckInFrom;

    /** 失联企业入库时间开始时间 */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date    gmtCheckInTo;

    /** 失联企业注册时间开始时间 */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date    gmtCompanyRegisterFrom;

    /** 失联企业注册时间结束时间 */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date    gmtCompanyRegisterTo;

    /** 企业性质 */
    private Integer companyProperty;

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

    public String getPrimaryIndustry() {
        return primaryIndustry;
    }

    public void setPrimaryIndustry(String primaryIndustry) {
        this.primaryIndustry = primaryIndustry;
    }

    public Date getGmtCheckInFrom() {
        return gmtCheckInFrom;
    }

    public void setGmtCheckInFrom(Date gmtCheckInFrom) {
        this.gmtCheckInFrom = gmtCheckInFrom;
    }

    public Date getGmtCheckInTo() {
        return gmtCheckInTo;
    }

    public void setGmtCheckInTo(Date gmtCheckInTo) {
        this.gmtCheckInTo = gmtCheckInTo;
    }

    public Date getGmtCompanyRegisterFrom() {
        return gmtCompanyRegisterFrom;
    }

    public void setGmtCompanyRegisterFrom(Date gmtCompanyRegisterFrom) {
        this.gmtCompanyRegisterFrom = gmtCompanyRegisterFrom;
    }

    public Date getGmtCompanyRegisterTo() {
        return gmtCompanyRegisterTo;
    }

    public void setGmtCompanyRegisterTo(Date gmtCompanyRegisterTo) {
        this.gmtCompanyRegisterTo = gmtCompanyRegisterTo;
    }

    public Integer getCompanyProperty() {
        return companyProperty;
    }

    public void setCompanyProperty( Integer companyProperty ) {
        this.companyProperty = companyProperty;
    }


}
