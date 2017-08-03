/**
 * BBD Service Inc
 * All Rights Reserved @2017
 */
package com.bbd.service.reddata.remind.param;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @author liuweibo
 * @version $Id: RemindCompanyVO.java, v 0.1 2017年6月13日 上午10:31:18 liuweibo Exp $
 */
@ApiModel("企业年报提示返回对象")
public class RemindCompanyVO {

    @ApiModelProperty("公司名称")
    private String companyName;

    @ApiModelProperty("区域中文描述")
    private String district;

    @ApiModelProperty("区域中文描述")
    private String districtDesc;

    @ApiModelProperty("电话")
    private String phones;

    @ApiModelProperty("邮箱")
    private String emails;

    private String primaryIndustry;

    @ApiModelProperty("一级行业")
    private String primaryIndustryInitial;

    @ApiModelProperty("一级行业中文描述")
    private String primaryIndustryDesc;

    @ApiModelProperty("公司地址")
    private String addr;

    @ApiModelProperty("内部序号")
    private String nbxh;

    @ApiModelProperty("企业性质")
    private Integer companyProperty;

    @ApiModelProperty("年报状态")
    private Integer annualState;

    @ApiModelProperty("异常状态")
    private Integer abnormalState;

    @ApiModelProperty("经营活动指数分数")
    private Double indexScore;

    @ApiModelProperty("提示数量统计返回对象")
    private CompanyRemindCount remindCount;

    @ApiModelProperty("提示时间")
    @JsonFormat(pattern = "yyyy年MM月dd日HH时mm分", timezone = "GMT+8")
    private Date remindTime;

    public Date getRemindTime() {
        return remindTime;
    }

    public void setRemindTime(Date remindTime) {
        this.remindTime = remindTime;
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

    public String getDistrictDesc() {
        return districtDesc;
    }

    public void setDistrictDesc(String districtDesc) {
        this.districtDesc = districtDesc;
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

    public String getPrimaryIndustry() {
        return primaryIndustry;
    }

    public void setPrimaryIndustry(String primaryIndustry) {
        this.primaryIndustry = primaryIndustry;
    }

    public String getPrimaryIndustryInitial() {
        return primaryIndustryInitial;
    }

    public void setPrimaryIndustryInitial(String primaryIndustryInitial) {
        this.primaryIndustryInitial = primaryIndustryInitial;
    }

    public String getPrimaryIndustryDesc() {
        return primaryIndustryDesc;
    }

    public void setPrimaryIndustryDesc(String primaryIndustryDesc) {
        this.primaryIndustryDesc = primaryIndustryDesc;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getNbxh() {
        return nbxh;
    }

    public void setNbxh(String nbxh) {
        this.nbxh = nbxh;
    }

    public Integer getCompanyProperty() {
        return companyProperty;
    }

    public void setCompanyProperty(Integer companyProperty) {
        this.companyProperty = companyProperty;
    }

    public Integer getAnnualState() {
        return annualState;
    }

    public void setAnnualState(Integer annualState) {
        this.annualState = annualState;
    }

    public Integer getAbnormalState() {
        return abnormalState;
    }

    public void setAbnormalState(Integer abnormalState) {
        this.abnormalState = abnormalState;
    }

    public Double getIndexScore() {
        return indexScore;
    }

    public void setIndexScore(Double indexScore) {
        this.indexScore = indexScore;
    }

    public CompanyRemindCount getRemindCount() {
        return remindCount;
    }

    public void setRemindCount(CompanyRemindCount remindCount) {
        this.remindCount = remindCount;
    }

}
