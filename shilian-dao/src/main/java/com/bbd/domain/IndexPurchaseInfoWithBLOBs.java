package com.bbd.domain;

public class IndexPurchaseInfoWithBLOBs extends IndexPurchaseInfo {
    private String tenderCompanyName;

    private String obtainCompanyName;

    public String getTenderCompanyName() {
        return tenderCompanyName;
    }

    public void setTenderCompanyName(String tenderCompanyName) {
        this.tenderCompanyName = tenderCompanyName;
    }

    public String getObtainCompanyName() {
        return obtainCompanyName;
    }

    public void setObtainCompanyName(String obtainCompanyName) {
        this.obtainCompanyName = obtainCompanyName;
    }
}