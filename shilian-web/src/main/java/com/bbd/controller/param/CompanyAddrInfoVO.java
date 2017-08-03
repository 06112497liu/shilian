/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.controller.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author tjwang
 * @version $Id: CompanyAddrInfoVO.java, v 0.1 2017/6/16 0016 11:48 tjwang Exp $
 */
@ApiModel("企业联各种系方式返回对象")
public class CompanyAddrInfoVO {

    @ApiModelProperty("企业名称")
    private String companyName;

    @ApiModelProperty("企业nbxh")
    private String nbxh;

    @ApiModelProperty("地址")
    private String addr;

    @ApiModelProperty("电话")
    private String phones;

    @ApiModelProperty("邮箱")
    private String emails;

    @ApiModelProperty("纬度")
    private Double latitude;

    @ApiModelProperty("经度")
    private Double longitude;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
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

    public Double getLatitude() {
        if (latitude == null) return -1d;
        return latitude >= 0.0d ? latitude : -1d;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        if (longitude == null) return -1d;
        return longitude >= 0.0d ? longitude : -1d;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

}
