package com.bbd.bean.biz;

/***
 * 散点图的vo
 */
public class AddrPointInfo {

    /** 企业名称 */
    private String companyName;

    /** 企业地址 */
    private String address;

    /** 纬度 */
    private Double lat;

    /** 经度 */
    private Double lng;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getLat() {
        if(lat == null) return -1d;
        return lat > 0.0d ? lat : -1d;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        if(lng == null) return -1d;
        return lng > 0.0d ? lng : -1d;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }
}
