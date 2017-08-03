/** 
 * BBD Service Inc 
 * All Rights Reserved @2017 
 */
package com.bbd.controller.job.excel;

import com.bbd.excel.ExcelRow;
import com.bbd.excel.ExcelRowDateFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/** 
 *  
 * @author liuweibo 
 * @version $Id: LostCompanyListVo.java, v 0.1 2017年5月16日 下午1:33:04 liuweibo Exp $ 
 */
@ExcelRowDateFormat("yyyy年MM月dd日")
public class LostCompanyListVo {
    /**序列号ID */
    private static final long serialVersionUID = 2820211503509528512L;

    /** 失联企业的id */
    @ApiModelProperty(value = "失联企业的nbxh")
    private String            nbxh;

    /** 社会统一信用代码/企业注册号(优先显示社会统一信用代码) */
    @ExcelRow("社会统一信用代码/注册号")
    private String            registerNumber;

    /**企业名称*/
    @ExcelRow("企业名称")
    @ApiModelProperty(value = "企业名称")
    private String            companyName;

    /**地址*/
    @ApiModelProperty(value = "地址")
    private String            addr;

    /**区域编码*/
    @ApiModelProperty(value = "区域编码")
    private String            district;

    /**区域中文描述*/
    @ExcelRow("区域中文描述")
    @ApiModelProperty(value = "区域中文描述")
    private String            districtDesc;

    /**所属第一行业*/
    @ExcelRow("所属第一行业")
    @ApiModelProperty(value = "所属第一行业")
    private String            industryDesc;

    @ApiModelProperty(value = "所属第一行业编码")
    private String            primaryIndustry;

    /**企业类型编码*/
    @ApiModelProperty(value = "企业类型编码")
    private Integer           companyProperty;

    /** 行业类型中文 */
    @ExcelRow("企业类型中文")
    private String            companyPropertyDesc;

    /**企业注册时间*/
    @ExcelRow("企业注册时间")
    @ApiModelProperty(value = "注册时间")
    @JsonFormat(pattern = "yyyy年MM月dd日", timezone = "GMT+8")
    private Date              gmtCompanyRegister;

    /**失联企业更新时间*/
    @ExcelRow("失联入库时间")
    @ApiModelProperty(value = "失联入库时间")
    @JsonFormat(pattern = "yyyy年MM月dd日", timezone = "GMT+8")
    private Date              lostTime;

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getRegisterNumber() {
        return registerNumber;
    }

    public void setRegisterNumber(String registerNumber) {
        this.registerNumber = registerNumber;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPrimaryIndustry() {
        return primaryIndustry;
    }

    public void setPrimaryIndustry(String primaryIndustry) {
        this.primaryIndustry = primaryIndustry;
    }

    public Date getGmtCompanyRegister() {
        return gmtCompanyRegister;
    }

    public void setGmtCompanyRegister(Date gmtCompanyRegister) {
        this.gmtCompanyRegister = gmtCompanyRegister;
    }

    public String getNbxh() {
        return nbxh;
    }

    public void setNbxh(String nbxh) {
        this.nbxh = nbxh;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getIndustryDesc() {
        return industryDesc;
    }

    public void setIndustryDesc(String industryDesc) {
        this.industryDesc = industryDesc;
    }

    public String getDistrictDesc() {
        return districtDesc;
    }

    public void setDistrictDesc(String districtDesc) {
        this.districtDesc = districtDesc;
    }

    public String getCompanyPropertyDesc() {
        if (this.companyProperty == null) {
            return "";
        }
        switch (companyProperty) {
            case 1:
                this.companyPropertyDesc = "民营企业";
                break;
            case 2:
                this.companyPropertyDesc = "国有企业";
                break;
            case 3:
                this.companyPropertyDesc = "外资企业";
                break;
            case 4:
                this.companyPropertyDesc = "集体企业及其他";
                break;
            case 5:
                this.companyPropertyDesc = "集体企业及其他";
                break;
            default:
                this.companyPropertyDesc = "";
                break;
        }
        return this.companyPropertyDesc;
    }

    public void setCompanyPropertyDesc(String companyPropertyDesc) {
        this.companyPropertyDesc = companyPropertyDesc;
    }

    public Integer getCompanyProperty() {
        return companyProperty;
    }

    public void setCompanyProperty(Integer companyProperty) {
        this.companyProperty = companyProperty;
    }

    public Date getLostTime() {
        return lostTime;
    }

    public void setLostTime(Date lostTime) {
        this.lostTime = lostTime;
    }

}
