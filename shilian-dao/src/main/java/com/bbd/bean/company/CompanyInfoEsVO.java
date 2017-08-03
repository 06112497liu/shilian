/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.bean.company;

import com.bbd.bean.EsBase;
import com.bbd.bean.LatLng;
import com.bbd.bean.vo.CompanyEsVO;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.common.collect.Lists;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 商品信息，同步到ES
 * @author tjwang
 * @version $Id: CompanyEsVO.java, v 0.1 2017/5/13 0013 9:50 tjwang Exp $
 */
public class CompanyInfoEsVO extends EsBase implements Serializable {

    private static final long serialVersionUID = -3202309618861653386L;

    private String            companyName;

    private String            province;

    private String            city;

    private String            district;

    private String            phones;

    private String            emails;

    private String            companyCreditCode;

    @JsonFormat(pattern = "yyyy年MM月dd日", timezone = "GMT+8")
    private Date              gmtCompanyRegister;

    private String            primaryIndustry;
    @JsonFormat(pattern = "yyyy年MM月dd日", timezone = "GMT+8")
    private Date              gmtApproval;
    @JsonFormat(pattern = "yyyy年MM月dd日", timezone = "GMT+8")
    private Date              gmtCancel;
    @JsonFormat(pattern = "yyyy年MM月dd日", timezone = "GMT+8")
    private Date              gmtSuspend;

    private String            companyType;

    private String            registerNumber;

    private Float             registerCapital;

    private String            legalPerson;

    private String            registerAuthority;

    private String            operateScope;

    private String            addr;

    private LatLng            latLng;

    private String            nbxh;
    @JsonFormat(pattern = "yyyy年MM月dd日", timezone = "GMT+8")
    private Date              createTime;
    @JsonFormat(pattern = "yyyy年MM月dd日", timezone = "GMT+8")
    private Date              updateTime;

    /**
     * 区域描述
     */
    private String            districtDesc;

    /**
     * 1 民营企业 2 国有企业 3 外资企业 4 农专社 5 个体户
     */
    private int               companyPropoerty;

    /**
     * 1 民营企业 2 国有企业 3 外资企业 4 农专社 5 个体户
     */
    private String            companyPropoertyDesc;

    /**
     * 异常情况。1-未年报 2-未公示 3-虚假信息 4-失联
     */
    private List<Integer>     abnormal;

    /**
     * 经营活动
     */
    private List<Integer>     activity;

    /**
     * 活动指数
     */
    private double            score;

    /**
     * 失联入库时间
     */
    @JsonFormat(pattern = "yyyy年MM月dd日", timezone = "GMT+8")
    private Date              lostTime;

    /**
     * 企业经营活动状态。1.正常企业；2.失联企业；3.已吊销未注销企业；4.严重违法企业
     */
    private List<Integer>     businessStatus;

    /**
     * 产业描述
     */
    private String            industryDesc;

    public static CompanyEsVO empty() {
        CompanyEsVO vo = new CompanyEsVO();

        LatLng ll = new LatLng(0, 0);
        vo.setLatLng(ll);

        List<Integer> abs = Lists.newArrayList(-1, -1, -1, -1);
        vo.setAbnormal(abs);

        List<Integer> acs = Lists.newArrayList(-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1);
        vo.setActivity(acs);

        vo.setCompanyPropoertyDesc(getDefaultStr(10));

        List<Integer> bs = Lists.newArrayList(-1, -1, -1, -1);
        vo.setBusinessStatus(bs);

        return vo;
    }

    private static Date getDefaultTime() {
        Calendar c = Calendar.getInstance();
        c.set(1900, 0, 1, 0, 0, 0);
        return c.getTime();
    }

    public static String getDefaultStr(int len) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append("-");
        }
        return sb.toString();
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

    public Date getGmtCompanyRegister() {
        return gmtCompanyRegister;
    }

    public void setGmtCompanyRegister(Date gmtCompanyRegister) {
        this.gmtCompanyRegister = gmtCompanyRegister;
    }

    public String getPrimaryIndustry() {
        return primaryIndustry;
    }

    public void setPrimaryIndustry(String primaryIndustry) {
        this.primaryIndustry = primaryIndustry;
    }

    public Date getGmtApproval() {
        return gmtApproval;
    }

    public void setGmtApproval(Date gmtApproval) {
        this.gmtApproval = gmtApproval;
    }

    public Date getGmtCancel() {
        return gmtCancel;
    }

    public void setGmtCancel(Date gmtCancel) {
        this.gmtCancel = gmtCancel;
    }

    public Date getGmtSuspend() {
        return gmtSuspend;
    }

    public void setGmtSuspend(Date gmtSuspend) {
        this.gmtSuspend = gmtSuspend;
    }

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
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

    public String getOperateScope() {
        return operateScope;
    }

    public void setOperateScope(String operateScope) {
        this.operateScope = operateScope;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public LatLng getLatLng() {
        return latLng;
    }

    public void setLatLng(LatLng latLng) {
        this.latLng = latLng;
    }

    public String getNbxh() {
        return nbxh;
    }

    public void setNbxh(String nbxh) {
        this.nbxh = nbxh;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getDistrictDesc() {
        return districtDesc;
    }

    public void setDistrictDesc(String districtDesc) {
        this.districtDesc = districtDesc;
    }

    public int getCompanyPropoerty() {
        return companyPropoerty;
    }

    public void setCompanyPropoerty(int companyPropoerty) {
        this.companyPropoerty = companyPropoerty;
    }

    public String getCompanyPropoertyDesc() {
        return companyPropoertyDesc;
    }

    public void setCompanyPropoertyDesc(String companyPropoertyDesc) {
        this.companyPropoertyDesc = companyPropoertyDesc;
    }

    public List<Integer> getAbnormal() {
        return abnormal;
    }

    public void setAbnormal(List<Integer> abnormal) {
        this.abnormal = abnormal;
    }

    public List<Integer> getActivity() {
        return activity;
    }

    public void setActivity(List<Integer> activity) {
        this.activity = activity;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public Date getLostTime() {
        return lostTime;
    }

    public void setLostTime(Date lostTime) {
        this.lostTime = lostTime;
    }

    public List<Integer> getBusinessStatus() {
        return businessStatus;
    }

    public void setBusinessStatus(List<Integer> businessStatus) {
        this.businessStatus = businessStatus;
    }

    public String getIndustryDesc() {
        return industryDesc;
    }

    public void setIndustryDesc(String industryDesc) {
        this.industryDesc = industryDesc;
    }

}
