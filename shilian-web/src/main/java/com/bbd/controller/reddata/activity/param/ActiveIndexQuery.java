/** 
 * BBD Service Inc 
 * All Rights Reserved @2017 
 */
package com.bbd.controller.reddata.activity.param;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 企业经营活动指数页面查询条件类
 * @author liuweibo 
 * @version $Id: QueryActiveIndex.java, v 0.1 2017年5月8日 上午11:03:54 liuweibo Exp $ 
 */
public class ActiveIndexQuery {

    /** 企业名称筛选  */
    private String        companyName;

    /** 地区编号筛选 */
    @NotBlank(message = "地区不能为空")
    private String        areaCode;

    /** 企业异常类型筛选("0-正常企业，1-已吊销未注销企业，2-严重违法企业，4-失联企业") */
    @NotNull(message = "异常类型不能为空")
    private Integer       companyState;

    /** 一级行业筛选 */
    private String        primaryIndustry;

    /** 企业性质：1 民营企业 2 国有企业 3 外资企业 */
    private List<Integer> companyProperties;

    /** 企业注册时间开始时间筛选 */
    private String        companyRegisterFrom;

    /** 企业注册时间结束时间筛选 */
    private String        companyRegisterTo;

    /** 企业经营活动指数下限筛选 */
    private Double        activityExponentFrom;

    /** 企业经营活动指数下限筛选 */
    private Double        activityExponentTo;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
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

    public List<Integer> getCompanyProperties() {
        return companyProperties;
    }

    public void setCompanyProperties(List<Integer> companyProperties) {
        this.companyProperties = companyProperties;
    }

    public String getCompanyRegisterFrom() {
        return companyRegisterFrom;
    }

    public void setCompanyRegisterFrom(String companyRegisterFrom) {
        this.companyRegisterFrom = companyRegisterFrom;
    }

    public String getCompanyRegisterTo() {
        return companyRegisterTo;
    }

    public void setCompanyRegisterTo(String companyRegisterTo) {
        this.companyRegisterTo = companyRegisterTo;
    }

    public Double getActivityExponentFrom() {
        return activityExponentFrom;
    }

    public void setActivityExponentFrom(Double activityExponentFrom) {
        this.activityExponentFrom = activityExponentFrom;
    }

    public Double getActivityExponentTo() {
        return activityExponentTo;
    }

    public void setActivityExponentTo(Double activityExponentTo) {
        this.activityExponentTo = activityExponentTo;
    }

    @Override
    public String toString() {
        return "ActiveIndexQuery{" + "companyName='" + companyName + '\'' + ", areaCode='" + areaCode + '\'' + ", companyState=" + companyState + ", primaryIndustry='" + primaryIndustry + '\''
               + ", companyProperties=" + companyProperties + ", companyRegisterFrom='" + companyRegisterFrom + '\'' + ", companyRegisterTo='" + companyRegisterTo + '\'' + ", activityExponentFrom="
               + activityExponentFrom + ", activityExponentTo=" + activityExponentTo + '}';
    }
}
