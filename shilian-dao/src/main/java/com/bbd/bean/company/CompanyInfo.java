package com.bbd.bean.company;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 企业信息实体
 * @author manailin
 * @version $Id: CompanyInfoVo.java, v 0.1 2016年12月5日 上午9:56:22 manailin Exp $
 */
@ApiModel(value = "企业信息实体")
public class CompanyInfo implements Serializable {

    /**序列号ID */
    private static final long serialVersionUID = -9119717597092023382L;

    /**主键*/
    @ApiModelProperty(value = "企业nbxh")
    private String            nbxh;

    /**企业名称*/
    @ApiModelProperty(value = "企业名称")
    private String            companyName;

    /**省*/
    @ApiModelProperty(value = "省")
    private String            province;

    /**市*/
    @ApiModelProperty(value = "市")
    private String            city;

    /**区*/
    @ApiModelProperty(value = "区")
    private String            district;

    /**联系电话*/
    @ApiModelProperty(value = "联系电话")
    private String            phones;

    /**联系邮箱*/
    @ApiModelProperty(value = "联系邮箱")
    private String            emails;

    /**企业信用代码*/
    @ApiModelProperty(value = "企业信用代码")
    private String            companyCreditCode;

    /**企业注册时间*/
    @ApiModelProperty(value = "企业注册时间")
    private String            gmtCompanyRegister;

    /**所属第一行业*/
    @ApiModelProperty(value = "所属第一行业")
    private String            primaryIndustry;

    /**工商局失联登记时间*/
    @ApiModelProperty(value = "工商局失联登记时间")
    private String            gmtCheckIn;

    /**企业类别*/
    @ApiModelProperty(value = "企业类别")
    private Integer           companyType;

    /**是否经过大数据分析过(0:没分析过：1;分析过)*/
    @ApiModelProperty(value = "是否经过大数据分析过(0:没分析过：1;分析过)")
    private Integer           analysisFlag;

    /**公示地址异常类型(0：正常；1：地址不存在；2：地址无法识别；3：地址错误)*/
    @ApiModelProperty(value = "公示地址异常类型(0：正常；1：地址不存在；2：地址无法识别；3：地址错误)")
    private String            addrExceptionType;

    /**企业注册号*/
    @ApiModelProperty(value = "企业注册号")
    private String            registerNumber;

    /**注册资金*/
    @ApiModelProperty(value = "注册资金")
    private Float             registerCapital;

    /**法人代表*/
    @ApiModelProperty(value = "法人代表")
    private String            legalPerson;

    /**登记机关*/
    @ApiModelProperty(value = "登记机关")
    private String            registerAuthority;

    /**登记状态*/
    @ApiModelProperty(value = "登记状态")
    private String            registerStatus;

    /**自动提示状态(0:没提示 1:待提示 2：提示成功 3：提示失败)*/
    @ApiModelProperty(value = "自动提示状态(0:没提示 1:待提示 2：提示成功 3：提示失败)")
    private Integer           autoRemindFlag;

    /**自动提示类型(0:无 1：邮件 2：短信 3：电话)*/
    @ApiModelProperty(value = "自动提示类型(0:无 1：邮件 2：短信 3：电话)")
    private Integer           autoRemindType;

    /** 手动提示标示(-1:提示失败 0 没提示  1:待提示  2:提示中 3:提示成功  )电话 */
    @ApiModelProperty(value = "手动提示标示(-1:提示失败 0 没提示  1:待提示  2:提示中 3:提示成功  )电话")
    private Integer           manualRemindTel;

    /** 手动提示标示(-1:提示失败 0 没提示  1:待提示  2:提示中 3:提示成功  )短信 */
    @ApiModelProperty(value = "手动提示标示(-1:提示失败 0 没提示  1:待提示  2:提示中 3:提示成功  )短信")
    private Integer           manualRemindSms;

    /** 手动提示标示(-1:提示失败 0 没提示  1:待提示  2:提示中 3:提示成功  )邮件 */
    @ApiModelProperty(value = "手动提示标示(-1:提示失败 0 没提示  1:待提示  2:提示中 3:提示成功  )邮件")
    private Integer           manualRemindEmail;

    /**手动提醒类型(0:无 1:邮件 2:短信 3:电话)只记录最后一次的提醒记录类型*/
    @ApiModelProperty(value = "手动提醒类型(0:无 1：邮件 2：短信 3：电话)")
    private Integer           manualRemindType;

    /**手动提醒时间*/
    @ApiModelProperty(value = "手动提醒时间")
    private Date              manualRemindTime;

    /**经营范围*/
    @ApiModelProperty(value = "经营范围")
    private Integer           operateScope;

    /**是否失眠标示(0:没有失眠  1:已经失眠)*/
    @ApiModelProperty(value = "是否失眠标示(0:没有失眠  1:已经失眠)")
    private Integer           insomniaFlag;
    /** 核准日期 */
    @ApiModelProperty(value = "核准日期")
    private Date              gmtApproval;

    /**失联企业导入时间*/
    @ApiModelProperty(value = "失联企业导入时间")
    private Date              gmtCreate;

    /**失联企业更新时间*/
    @ApiModelProperty(value = "失联企业更新时间")
    private Date              gmtModified;

    /**移除时间*/
    @ApiModelProperty(value = "移除时间")
    private Date              gmtDelete;

    /**是否移除标识(0：没移除；1：移除)*/
    @ApiModelProperty(value = "是否移除标识(0：没移除；1：移除)")
    private Integer           deleteFlag;

    /**备注*/
    @ApiModelProperty(value = "备注")
    private String            remarks;

    /**自动提示次数*/
    @ApiModelProperty(value = "自动提示次数")
    private Integer           autoRemindCount;

    /**手动提示次数*/
    @ApiModelProperty(value = "手动提示次数")
    private Integer           manualRemindCount;

    /**自动提醒时间*/
    @ApiModelProperty(value = "自动提醒时间")
    private Date              autoRemindTime;

    /**企业详细地址*/
    @ApiModelProperty(value = "企业详细地址")
    private String            addr;

    /** 指数最大值 */
    @JsonIgnore
    private Double            activityExponentTo;

    /** 指数最小值 */
    @JsonIgnore
    private Double            activityExponentFrom;

    public Double getActivityExponentTo() {
        return activityExponentTo;
    }

    public void setActivityExponentTo(Double activityExponentTo) {
        this.activityExponentTo = activityExponentTo;
    }

    public Double getActivityExponentFrom() {
        return activityExponentFrom;
    }

    public void setActivityExponentFrom(Double activityExponentFrom) {
        this.activityExponentFrom = activityExponentFrom;
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

    public String getCompanyCreditCode() {
        return companyCreditCode;
    }

    public void setCompanyCreditCode(String companyCreditCode) {
        this.companyCreditCode = companyCreditCode;
    }

    public String getGmtCompanyRegister() {
        return gmtCompanyRegister;
    }

    public void setGmtCompanyRegister(String gmtCompanyRegister) {
        this.gmtCompanyRegister = gmtCompanyRegister;
    }

    public String getPrimaryIndustry() {
        return primaryIndustry;
    }

    public void setPrimaryIndustry(String primaryIndustry) {
        this.primaryIndustry = primaryIndustry;
    }

    public String getGmtCheckIn() {
        return gmtCheckIn;
    }

    public void setGmtCheckIn(String gmtCheckIn) {
        this.gmtCheckIn = gmtCheckIn;
    }

    public Integer getCompanyType() {
        return companyType;
    }

    public void setCompanyType(Integer companyType) {
        this.companyType = companyType;
    }

    public Integer getAnalysisFlag() {
        return analysisFlag;
    }

    public void setAnalysisFlag(Integer analysisFlag) {
        this.analysisFlag = analysisFlag;
    }

    public String getAddrExceptionType() {
        return addrExceptionType;
    }

    public void setAddrExceptionType(String addrExceptionType) {
        this.addrExceptionType = addrExceptionType;
    }

    public void setAutoRemindCount(Integer autoRemindCount) {
        this.autoRemindCount = autoRemindCount;
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

    public String getLegalPerson() {
        return legalPerson;
    }

    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson;
    }

    public String getRegisterAuthority() {
        return registerAuthority;
    }

    public void setRegisterAuthority(String registerAuthority) {
        this.registerAuthority = registerAuthority;
    }

    public Integer getAutoRemindFlag() {
        return autoRemindFlag;
    }

    public void setAutoRemindFlag(Integer autoRemindFlag) {
        this.autoRemindFlag = autoRemindFlag;
    }

    public Integer getAutoRemindType() {
        return autoRemindType;
    }

    public void setAutoRemindType(Integer autoRemindType) {
        this.autoRemindType = autoRemindType;
    }

    public Integer getManualRemindTel() {
        return manualRemindTel;
    }

    public void setManualRemindTel(Integer manualRemindTel) {
        this.manualRemindTel = manualRemindTel;
    }

    public Integer getManualRemindSms() {
        return manualRemindSms;
    }

    public void setManualRemindSms(Integer manualRemindSms) {
        this.manualRemindSms = manualRemindSms;
    }

    public Integer getManualRemindEmail() {
        return manualRemindEmail;
    }

    public void setManualRemindEmail(Integer manualRemindEmail) {
        this.manualRemindEmail = manualRemindEmail;
    }

    public Integer getManualRemindType() {
        return manualRemindType;
    }

    public void setManualRemindType(Integer manualRemindType) {
        this.manualRemindType = manualRemindType;
    }

    public Date getManualRemindTime() {
        return manualRemindTime;
    }

    public void setManualRemindTime(Date manualRemindTime) {
        this.manualRemindTime = manualRemindTime;
    }

    public Integer getOperateScope() {
        return operateScope;
    }

    public void setOperateScope(Integer operateScope) {
        this.operateScope = operateScope;
    }

    public Integer getInsomniaFlag() {
        return insomniaFlag;
    }

    public void setInsomniaFlag(Integer insomniaFlag) {
        this.insomniaFlag = insomniaFlag;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Date getGmtDelete() {
        return gmtDelete;
    }

    public void setGmtDelete(Date gmtDelete) {
        this.gmtDelete = gmtDelete;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getAutoRemindCount() {
        return autoRemindCount;
    }

    public void setAutoRemindCount(int autoRemindCount) {
        this.autoRemindCount = autoRemindCount;
    }

    public Integer getManualRemindCount() {
        return manualRemindCount;
    }

    public void setManualRemindCount(Integer manualRemindCount) {
        this.manualRemindCount = manualRemindCount;
    }

    public Date getAutoRemindTime() {
        return autoRemindTime;
    }

    public void setAutoRemindTime(Date autoRemindTime) {
        this.autoRemindTime = autoRemindTime;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
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

    @Override
    public String toString() {
        return "CompanyInfo [nbxh=" + nbxh + ", companyName=" + companyName + ", province=" + province + ", city=" + city + ", district=" + district + ", phones=" + phones + ", emails=" + emails
               + ", companyCreditCode=" + companyCreditCode + ", gmtCompanyRegister=" + gmtCompanyRegister + ", primaryIndustry=" + primaryIndustry + ", gmtCheckIn=" + gmtCheckIn + ", companyType="
               + companyType + ", analysisFlag=" + analysisFlag + ", addrExceptionType=" + addrExceptionType + ", registerNumber=" + registerNumber + ", registerCapital=" + registerCapital
               + ", legalPerson=" + legalPerson + ", registerAuthority=" + registerAuthority + ", registerStatus=" + registerStatus + ", autoRemindFlag=" + autoRemindFlag + ", autoRemindType="
               + autoRemindType + ", manualRemindTel=" + manualRemindTel + ", manualRemindSms=" + manualRemindSms + ", manualRemindEmail=" + manualRemindEmail + ", manualRemindType="
               + manualRemindType + ", manualRemindTime=" + manualRemindTime + ", operateScope=" + operateScope + ", insomniaFlag=" + insomniaFlag + ", gmtApproval=" + gmtApproval + ", gmtCreate="
               + gmtCreate + ", gmtModified=" + gmtModified + ", gmtDelete=" + gmtDelete + ", deleteFlag=" + deleteFlag + ", remarks=" + remarks + ", autoRemindCount=" + autoRemindCount
               + ", manualRemindCount=" + manualRemindCount + ", autoRemindTime=" + autoRemindTime + ", addr=" + addr + ", activityExponentTo=" + activityExponentTo + ", activityExponentFrom="
               + activityExponentFrom + "]";
    }

}
