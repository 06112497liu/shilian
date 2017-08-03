/** 
 * BBD Service Inc 
 * All Rights Reserved @2017 
 */
package com.bbd.controller.param;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 *  
 * @author liuweibo 
 * @version $Id: CompanyBusinessInfoQueryParam.java, v 0.1 2017年6月16日 下午2:17:41 liuweibo Exp $ 
 */
public class CompanyBusinessInfoQueryParam {

    /**
     * 企业经营状态
     */
    @NotNull(message = "异常类型不能为空")
    private Integer companyState;

    /**
     * 企业名
     */
    private String  companyName;

    /**
     * 地区
     */
    @NotBlank(message = "地区不能为空")
    private String  district;

    /**
     * 第一行业
     */
    private String  primaryIndustry;

    /**
     * 经营指数from
     */
    private Double  indexScoreFrom;

    /**
     * 经营指数to
     */
    private Double  indexScoreTo;
    
    /**
     * 经营活动指数排序（1.降序，2.升序）
     */
    private Integer order;      

    public Integer getOrder() {
        return order;
    }

    public void setOrder( Integer order ) {
        this.order = order;
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

    public String getPrimaryIndustry() {
        return primaryIndustry;
    }

    public void setPrimaryIndustry(String primaryIndustry) {
        this.primaryIndustry = primaryIndustry;
    }

    public Integer getCompanyState() {
        return companyState;
    }

    public void setCompanyState(Integer companyState) {
        this.companyState = companyState;
    }

    public Double getIndexScoreFrom() {
        return indexScoreFrom;
    }

    public void setIndexScoreFrom(Double indexScoreFrom) {
        this.indexScoreFrom = indexScoreFrom;
    }

    public Double getIndexScoreTo() {
        return indexScoreTo;
    }

    public void setIndexScoreTo(Double indexScoreTo) {
        this.indexScoreTo = indexScoreTo;
    }

}
