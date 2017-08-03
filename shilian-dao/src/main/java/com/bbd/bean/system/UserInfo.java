/**
 * BBD Service Inc
 * AllRight Reserved @2017
 */
package com.bbd.bean.system;

import com.bbd.util.AddressUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "账户信息")
public class UserInfo {

    /** 主键 */
    @ApiModelProperty(value = "主键")
    private long   id;

    /** 用户名 */
    @ApiModelProperty(value = "用户名")
    private String username;

    /** 性名 */
    @ApiModelProperty(value = "姓名")
    private String name;

    /** 手机号码 */
    @ApiModelProperty(value = "手机号码")
    private String mobile;

    /** 角色id */
    @ApiModelProperty(value = "角色")
    private String role;

    /** 状态 0 启用 1禁用 */
    @ApiModelProperty(value = "状态 0 启用  -1禁用")
    private int    status;

    /** 省的名字 */
    @ApiModelProperty("省的名字")
    private String provinceName;

    /** 市的名字 */
    @ApiModelProperty("市的名字")
    private String cityName;

    /** 区的名字 */
    @ApiModelProperty("区的名字")
    private String districtName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getArea() {
        return AddressUtil.concatAddress(provinceName, cityName, districtName);
    }
}