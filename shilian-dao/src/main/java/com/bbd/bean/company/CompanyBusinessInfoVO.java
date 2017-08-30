/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.bean.company;

import com.bbd.excel.ExcelRow;

/**
 * 带经营活动的企业信息
 * @author tjwang
 * @version $Id: CompanyBusinessInfoVO.java, v 0.1 2017/6/16 0016 10:45 tjwang Exp $
 */
public class CompanyBusinessInfoVO {

    private Integer id;

    /**
     * 公司nbxh
     */
    private String  nbxh;

    /**
     * 企业名
     */
    @ExcelRow("企业名称")
    private String  companyName;

    /**
     * 地区
     */
    private String  district;

    /**
     * 地区描述
     */
    @ExcelRow("区域")
    private String  districtDesc;

    /**
     * 第一行业
     */
    private String  primaryIndustryInitial;

    /**
     * 第一行业描述
     */
    @ExcelRow("一级行业")
    private String  primaryIndustryInitialDesc;

    /**
     * 经营指数
     */
    @ExcelRow("经营活动指数")
    private Double  indexScore;

    private String  businessType;

    @ExcelRow("经营活动记录")
    private String businessTypeDesc;
    
    @ExcelRow("锁入原因")
    private String lockReason;

    public String getBusinessTypeDesc() {
        return businessTypeDesc;
    }

    public void setBusinessTypeDesc(String businessTypeDesc) {
        this.businessTypeDesc = businessTypeDesc;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getNbxh() {
        return nbxh;
    }

    public void setNbxh(String nbxh) {
        this.nbxh = nbxh;
    }
    
    public String getLockReason() {
        return lockReason;
    }

    public void setLockReason(String lockReason) {
        this.lockReason = lockReason;
    }

    public String getPrimaryIndustryInitial() {
        return primaryIndustryInitial;
    }

    public void setPrimaryIndustryInitial(String primaryIndustryInitial) {
        this.primaryIndustryInitial = primaryIndustryInitial;
    }

    public Double getIndexScore() {
        return indexScore;
    }

    public void setIndexScore(Double indexScore) {
        this.indexScore = indexScore;
    }

    public String getDistrictDesc() {
        return districtDesc;
    }

    public void setDistrictDesc(String districtDesc) {
        this.districtDesc = districtDesc;
    }

    public String getPrimaryIndustryInitialDesc() {
        return primaryIndustryInitialDesc;
    }

    public void setPrimaryIndustryInitialDesc(String primaryIndustryInitialDesc) {
        this.primaryIndustryInitialDesc = primaryIndustryInitialDesc;
    }

}
