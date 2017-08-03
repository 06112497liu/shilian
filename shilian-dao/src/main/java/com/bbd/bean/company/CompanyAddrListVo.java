/** 
 * BBD Service Inc 
 * All Rights Reserved @2017 
 */
package com.bbd.bean.company;

import com.excel.annotation.ExcelRow;
import com.excel.annotation.ExcelTitle;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/** 
 *  
 * @author liuweibo 
 * @version $Id: CompanyAddrListVo.java, v 0.1 2017年5月4日 上午10:54:14 liuweibo Exp $ 
 */
@ExcelTitle(value = "企业联系地址")
@ApiModel(value = "企业联系地址")
public class CompanyAddrListVo implements Serializable {

    /** 序列号ID */
    private static final long serialVersionUID = -3193817946850561694L;
    /**lng 经度Longitude */
    private double            lng;
    /**lat 纬度Latitude*/
    private double            lat;
    /** 市 */
    @ApiModelProperty(value = "市")
    private String            city;
    /** 企业名称 */
    private String            companyName;
    /**数据来源(1-年报，2-招聘，3-招标，4-中标)*/
    @ExcelRow(value = "数据来源(0-企业登记联系方式， 1-年报，2-招聘，3-招标，4-中标)")
    @ApiModelProperty(value = "数据来源")
    private String            resource;
    /**联系地址*/
    @ExcelRow(value = "联系地址")
    @ApiModelProperty(value = "联系地址")
    private String            address;
    @ExcelRow(value = "邮箱")
    @ApiModelProperty(value = "邮箱")
    private String            email;
    /**联系电话*/
    @ExcelRow(value = "联系电话")
    @ApiModelProperty(value = "联系电话")
    private String            phone;

    public CompanyAddrListVo() {
        super();
    }

    public CompanyAddrListVo(String resource) {
        super();
        this.resource = resource;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public double getLat() {
        return lat;
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
