/**  
 * BBD Service Inc
 * All Rights Reserved @2016
 *
 */
package com.bbd.bean.system;

import com.bbd.bean.statistics.NameValueInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 登录用户的信息.
 * 
 * @author zhanghui
 * @version $Id: LoginUserInfo.java, v 0.1 2016年12月16日 下午3:48:25 zhanghui Exp $
 */
public class LoginUserInfo {

    /** 用户id */
    private Integer          id;

    /** 用户手机号码 */
    private String           mobile;

    /** 用户名 */
    private String           username;

    /** 姓名 */
    private String           name;

    /** 密码 */
    @JsonIgnore
    private String           password;

    /** 用户状态 0.正常 -1禁用 */
    private Integer          status;

    /** 用户的角色 */
    private String           role;

    /** 用户的类型 3 省级用户 2 市级用户 1区 */
    private Integer          type;

    /** 用户所在的省 code */
    private NameValueInfo    province;

    /** 用户所属的市  code */
    private NameValueInfo    city;

    /** 用户所在的区  code */
    private NameValueInfo    district;

    @JsonIgnore
    /** 用户模块 */
    private List<ModuleInfo> modules;

    /** 用户的系统权限级别 3 省 2 市 1 区 */
    private transient int    permissionType;

    /** 用户的权限地址code */
    private transient int    addrCode;

    /** 当前用户权限的地址名称 */
    private transient String addrName;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ModuleInfo> getModules() {
        return modules;
    }

    public void setModules(List<ModuleInfo> modules) {
        this.modules = modules;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getPermissionType() {
        return permissionType;
    }

    public void setPermissionType(int permissionType) {
        this.permissionType = permissionType;
    }

    public int getAddrCode() {
        return addrCode;
    }

    public void setAddrCode(int addrCode) {
        this.addrCode = addrCode;
    }

    public String getAddrName() {
        return addrName;
    }

    public void setAddrName(String addrName) {
        this.addrName = addrName;
    }

    public NameValueInfo getProvince() {
        return province;
    }

    public void setProvince(NameValueInfo province) {
        this.province = province;
    }

    public NameValueInfo getCity() {
        return city;
    }

    public void setCity(NameValueInfo city) {
        this.city = city;
    }

    public NameValueInfo getDistrict() {
        return district;
    }

    public void setDistrict(NameValueInfo district) {
        this.district = district;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<String> getPaths() {
        if (modules != null && !modules.isEmpty()) {
            List<String> result = new ArrayList<>();
            for (ModuleInfo moduleInfo : modules) {
                String resource = moduleInfo.getResource();
                if (StringUtils.isNotBlank(resource)) {
                    result.add(resource);
                }
            }
            return result;
        }
        return Collections.emptyList();
    }
}
