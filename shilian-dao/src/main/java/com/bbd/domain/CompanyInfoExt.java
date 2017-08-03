package com.bbd.domain;

public class CompanyInfoExt {
    private Integer id;

    private Integer flowFlag;

    private Integer lllegalFlag;

    private Integer cancelFlag;

    private Integer suspendFlag;

    private Integer abnormalFlag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFlowFlag() {
        return flowFlag;
    }

    public void setFlowFlag(Integer flowFlag) {
        this.flowFlag = flowFlag;
    }

    public Integer getLllegalFlag() {
        return lllegalFlag;
    }

    public void setLllegalFlag(Integer lllegalFlag) {
        this.lllegalFlag = lllegalFlag;
    }

    public Integer getCancelFlag() {
        return cancelFlag;
    }

    public void setCancelFlag(Integer cancelFlag) {
        this.cancelFlag = cancelFlag;
    }

    public Integer getSuspendFlag() {
        return suspendFlag;
    }

    public void setSuspendFlag(Integer suspendFlag) {
        this.suspendFlag = suspendFlag;
    }

    public Integer getAbnormalFlag() {
        return abnormalFlag;
    }

    public void setAbnormalFlag(Integer abnormalFlag) {
        this.abnormalFlag = abnormalFlag;
    }
}