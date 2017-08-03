/** 
 * BBD Service Inc 
 * All Rights Reserved @2017 
 */
package com.bbd.service.reddata.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * BBD企业地址信息
 * @author tjwang
 * @version $Id: ompanyAddrListVo.java, v 0.1 2017年5月4日 上午10:54:14 tjwang Exp $
 */
public class BBDCompanyAddrVO implements Serializable {

    private static final long serialVersionUID = -5827971219071925121L;
    /** 市 */
    @ApiModelProperty(value = "市")
    public String             city;
    /**lng 经度Longitude */
    private double            lng;
    /**lat 纬度Latitude*/
    private double            lat;
    /** 企业名称 */
    private String            companyName;
    /**数据来源(1-年报，2-招聘，3-招标，4-中标)*/
    private String            resource;
    /**联系地址*/
    private String            address;
    private String            email;
    /**联系电话*/
    private String            phone;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getLng() {
        return lng > 0.0d ? lng : -1;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public double getLat() {
        return lat > 0.0d ? lat : -1;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "LostCompanyAddrListVo [resource=" + resource + ", address=" + address + ", phone=" + phone + ", lng=" + lng + ", lat=" + lat + "]";
    }
}
