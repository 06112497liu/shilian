/**
 * BBD Service Inc
 * AllRight Reserved @2017
 */
package com.bbd.service.reddata.system;

import com.bbd.bean.system.User;
import com.bbd.bean.system.UserInfo;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author xc
 * @version $Id: UserService.java, v 0.1 2016年12月2日 下午6:21:14 xc Exp $
 */
public interface IUserService {

    /**
     * 修改用户
     * 
     * @param user 用户信息
     */
    void updateUser(User user);

    /**
     * 查询用户的信息.
     * 
     * @return 用户的信息列表.
     */
    List<UserInfo> getUserInfos();

    /**
     * 新建一个用户
     * @param user 新用户信息
     */
    void createUser(User user);

    /**
     * 删除用户  
     * @param id 要删除的用户的id
     */
    void deleteUser(Integer id);

    /**
     * 禁用一个用户.
     * @param id 被禁用的该用户的id.
     */
    void disableUser(Integer id);

    /**
     * 启用用户
     * 
     * @param id 用户id
     */
    void enableUser(Integer id);

    /**
     * 设置用户的角色和模块权限.
     * 
     * @param user 用户
     */
    void updateUserRoleModules(User user);

    /**
     * 分页 查询用户信息.
     * @param limit 起始位置数据
     * @param offset 页数
     * @return
     */
    Map<String, Object> getUserInfos(int limit, int offset);
}
