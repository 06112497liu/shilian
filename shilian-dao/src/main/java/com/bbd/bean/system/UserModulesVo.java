/**  
 * BBD Service Inc
 * All Rights Reserved @2016
 *
 */
package com.bbd.bean.system;

import java.util.List;

/**
 * 用户 模块vo
 * @author zhanghui
 * @version $Id: UserModulesVo.java, v 0.1 2017年1月9日 下午5:38:22 zhanghui Exp $
 */
public class UserModulesVo {

    /** 修改用户id */
    private Long         userId;

    /** 用户区域 */
    private String       area;

    /** 登录用户名 */
    private String       userName;

    /** 用户权限id */
    private List<String> moduleIds;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<String> getModuleIds() {
        return moduleIds;
    }

    public void setModuleIds(List<String> moduleIds) {
        this.moduleIds = moduleIds;
    }
}
