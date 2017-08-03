/**
 * BBD Service Inc
 * All Rights Reserved @2017
 */
package com.bbd.bean.company;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * 企业工商基本信息
 *
 * @author liuweibo
 * @version $Id: CompanyInfoVo.java, v 0.1 2017年5月4日 下午2:21:08 liuweibo Exp $
 */
@ApiModel(value = "企业工商基本信息")
public class CompanyInfoVo implements Serializable {

    /**
     * 序列号ID
     */
    private static final long serialVersionUID = -5389913397961459833L;

    /**
     * 主键
     */
    @ApiModelProperty(value = "企业id")
    private Integer id;

    /**
     * 内部序号
     */
    @ApiModelProperty(value = "内部序号")
    private String nbxh;

    /**
     * 企业名称
     */
    @ApiModelProperty(value = "企业名称")
    private String companyName;

    /**
     * 企业注册号
     */
    @ApiModelProperty(value = "企业注册号")
    private String registerNumber;

    /**
     * 注册资金
     */
    @ApiModelProperty(value = "注册资金")
    private Float registerCapital;

    /**
     * 成立（注册）日期
     */
    @ApiModelProperty(value = "成立（注册）日期")
    @JsonFormat(pattern = "yyyy年MM月dd日", timezone = "GMT+8")
    private Date gmtCompanyRegister;

    /**
     * 法人代表
     */
    @ApiModelProperty(value = "法人代表")
    private String legalPerson;

    /**
     * 企业信用代码
     */
    @ApiModelProperty(value = "企业信用代码")
    private String companyCreditCode;

    /**
     * 企业类别
     */
    @ApiModelProperty(value = "企业类别")
    private int companyType;

    /**
     * 企业类别中文
     */
    @ApiModelProperty(value = "企业类别中文")
    private String companyTypeDesc;

    /**
     * 登记状态
     */
    @ApiModelProperty(value = "登记状态")
    private String registerStatus;

    /**
     * 核准日期
     */
    @ApiModelProperty(value = "核准日期")
    @JsonFormat(pattern = "yyyy年MM月dd日", timezone = "GMT+8")
    private Date gmtApproval;

    /**
     * 联系电话
     */
    @ApiModelProperty(value = "联系电话")
    private String phones;

    /**
     * 省
     */
    @ApiModelProperty(value = "省")
    private String province;

    /**
     * 市
     */
    @ApiModelProperty(value = "市")
    private String city;

    /**
     * 区
     */
    @ApiModelProperty(value = "区")
    private String district;

    /**
     * 企业详细地址
     */
    @ApiModelProperty(value = "企业详细地址")
    private String addr;

    /**
     * 经营异常目录列入时间
     */
    @ApiModelProperty(value = "经营异常目录列入时间")
    @JsonFormat(pattern = "yyyy年MM月dd日", timezone = "GMT+8")
    private Date gmtAbnormalTime;

    /**
     * 等级机关
     */
    @ApiModelProperty(value = "登记机关")
    private String registerAuthority;

    /**
     * 经营范围
     */
    @ApiModelProperty(value = "经营范围")
    private String operateScope;

    /**
     * 企业异常类型
     */
    @ApiModelProperty(value = "异常类型:1-未年报 2-未公示 4-虚假信息 8-失联")
    private Set<Integer> abnormalType;

    /**
     * 企业性质
     */
    @ApiModelProperty(value = "企业性质")
    private Integer companyProperty;

    /**
     * 企业性质中文描述
     */
    @ApiModelProperty(value = "企业性质中文描述")
    private String companyPropertyDesc;

    /**
     * 企业纬度
     */
    @ApiModelProperty(value = "纬度")
    private Double latitude;

    /**
     * 企业的经度
     */
    @ApiModelProperty(value = "经度")
    private Double longitude;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getRegisterNumber() {
        return registerNumber;
    }

    public void setRegisterNumber(String registerNumber) {
        this.registerNumber = registerNumber;
    }

    public Float getRegisterCapital() {
        return registerCapital;
    }

    public void setRegisterCapital(Float registerCapital) {
        this.registerCapital = registerCapital;
    }

    public Date getGmtCompanyRegister() {
        return gmtCompanyRegister;
    }

    public void setGmtCompanyRegister(Date gmtCompanyRegister) {
        this.gmtCompanyRegister = gmtCompanyRegister;
    }

    public String getLegalPerson() {
        return legalPerson;
    }

    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson;
    }

    public String getCompanyCreditCode() {
        return companyCreditCode;
    }

    public void setCompanyCreditCode(String companyCreditCode) {
        this.companyCreditCode = companyCreditCode;
    }

    public int getCompanyType() {
        return companyType;
    }

    public void setCompanyType(int companyType) {
        this.companyType = companyType;
    }

    public String getCompanyTypeDesc() {
        return companyTypeDesc;
    }

    public void setCompanyTypeDesc(String companyTypeDesc) {
        this.companyTypeDesc = companyTypeDesc;
    }

    public String getRegisterStatus() {
        return registerStatus;
    }

    public void setRegisterStatus(String registerStatus) {
        this.registerStatus = registerStatus;
    }

    public Date getGmtApproval() {
        return gmtApproval;
    }

    public void setGmtApproval(Date gmtApproval) {
        this.gmtApproval = gmtApproval;
    }

    public String getPhones() {
        return phones;
    }

    public void setPhones(String phones) {
        this.phones = phones;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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

    public Date getGmtAbnormalTime() {
        return gmtAbnormalTime;
    }

    public void setGmtAbnormalTime(Date gmtAbnormalTime) {
        this.gmtAbnormalTime = gmtAbnormalTime;
    }

    public String getRegisterAuthority() {
        return registerAuthority;
    }

    public void setRegisterAuthority(String registerAuthority) {
        this.registerAuthority = registerAuthority;
    }

    public String getOperateScope() {
        return operateScope;
    }

    public void setOperateScope(String operateScope) {
        this.operateScope = operateScope;
    }

    public Set<Integer> getAbnormalType() {
        return abnormalType;
    }

    public void setAbnormalType(Set<Integer> abnormalType) {
        this.abnormalType = abnormalType;
    }

    public Integer getCompanyProperty() {
        return companyProperty;
    }

    public void setCompanyProperty(Integer companyProperty) {
        this.companyProperty = companyProperty;
    }

    public String getCompanyPropertyDesc() {
        return companyPropertyDesc;
    }

    public void setCompanyPropertyDesc(String companyPropertyDesc) {
        this.companyPropertyDesc = companyPropertyDesc;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "CompanyInfoVo [id=" + id + ", nbxh=" + nbxh + ", companyName=" + companyName + ", registerNumber=" + registerNumber + ", registerCapital=" + registerCapital + ", gmtCompanyRegister="
                + gmtCompanyRegister + ", legalPerson=" + legalPerson + ", companyCreditCode=" + companyCreditCode + ", companyType=" + companyType + ", companyTypeDesc=" + companyTypeDesc
                + ", registerStatus=" + registerStatus + ", gmtApproval=" + gmtApproval + ", phones=" + phones + ", province=" + province + ", city=" + city + ", district=" + district + ", addr="
                + addr + ", gmtAbnormalTime=" + gmtAbnormalTime + ", registerAuthority=" + registerAuthority + ", operateScope=" + operateScope + ", abnormalType=" + abnormalType + ", companyProperty="
                + companyProperty + ", companyPropertyDesc=" + companyPropertyDesc + ", latitude=" + latitude + ", longitude=" + longitude + "]";
    }


}
