package com.bbd.domain;

import java.util.Date;

public class CompanyMoveInfo {
    private Integer id;

    private String nbxh;

    private String registerNumber;

    private String companyName;

    private String companyType;

    private String registerAuthority;

    private Date moveOutTime;

    private String moveOutRegisterAuthority;

    private String moveOutNature;

    private Double registerCapital;

    private Date createTime;

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

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    public String getRegisterAuthority() {
        return registerAuthority;
    }

    public void setRegisterAuthority(String registerAuthority) {
        this.registerAuthority = registerAuthority;
    }

    public Date getMoveOutTime() {
        return moveOutTime;
    }

    public void setMoveOutTime(Date moveOutTime) {
        this.moveOutTime = moveOutTime;
    }

    public String getMoveOutRegisterAuthority() {
        return moveOutRegisterAuthority;
    }

    public void setMoveOutRegisterAuthority(String moveOutRegisterAuthority) {
        this.moveOutRegisterAuthority = moveOutRegisterAuthority;
    }

    public String getMoveOutNature() {
        return moveOutNature;
    }

    public void setMoveOutNature(String moveOutNature) {
        this.moveOutNature = moveOutNature;
    }

    public Double getRegisterCapital() {
        return registerCapital;
    }

    public void setRegisterCapital(Double registerCapital) {
        this.registerCapital = registerCapital;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}