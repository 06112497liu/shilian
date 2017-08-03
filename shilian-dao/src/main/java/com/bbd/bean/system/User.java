/**
 * BBD Service Inc
 * AllRight Reserved @2017
 */
package com.bbd.bean.system;

import com.bbd.bean.Base;
import io.swagger.annotations.ApiModel;

import java.util.List;

@ApiModel(value = "用户")
public class User extends Base {

    /** 序列化id*/
    private static final long serialVersionUID = 1L;

    /** 用户手机号码 */
    private String            mobile;

    /** 用户名 */
    private String            username;

    /** 姓名 */
    private String            name;

    /** 密码 */
    private String            password;

    /** 用户状态 0.正常 -1禁用 */
    private Integer           status;

    /** 用户的角色 */
    private String            role;

    /** 用户的类型 1 省级用户 2 市级用户 */
    private Integer           type;

    /** 用户所在的省 code */
    private String            province;

    /** 用户所属的市  code */
    private String            city;

    /** 用户所在的区  code */
    private String            district;

    private List<Module>      modules;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public List<Module> getModules() {
        return modules;
    }

    public void setModules(List<Module> modules) {
        this.modules = modules;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
