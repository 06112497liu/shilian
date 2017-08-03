/**
 * BBD Service Inc
 * AllRight Reserved @2017
 */
package com.bbd.service.reddata.system.impl;

import com.bbd.bean.query.BaseQuery;
import com.bbd.bean.system.LoginUserInfo;
import com.bbd.bean.system.Module;
import com.bbd.bean.system.User;
import com.bbd.bean.system.UserInfo;
import com.bbd.dao.system.UserDao;
import com.bbd.exception.BizErrorCode;
import com.bbd.service.reddata.system.IUserService;
import com.bbd.utils.UserContext;
import com.exception.ApplicationException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author xc
 * @version $Id: UserServiceImpl.java, v 0.1 2016年12月2日 下午6:20:55 xc Exp $
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserDao       userDao;

    @Resource
    private LoginUserInfo adminUser;

    @Transactional
    @Override
    public void updateUser(User user) {
        checkUserExist(user);
        initUserType(user);
        userDao.updateUser(user);
    }

    /**
     * 根据用户传入的信息 设置用户的级别
     * @param user 用户
     */
    private void initUserType(User user) {

        if (StringUtils.isNotBlank(user.getDistrict())) {
            user.setType(UserContext.DISTRICT);
            return;
        }

        if (StringUtils.isNotBlank(user.getCity())) {
            user.setType(UserContext.CITY);
            return;
        }

        if (StringUtils.isNotBlank(user.getProvince())) {
            user.setType(UserContext.PROVINCE);
            return;
        }
        // 没有传入省市区
        // not reach
    }

    /** 
     * 使用 地址信息来缓存首页的用户信息.
     * @see IUserService#getUserInfos()
     */
    @Override
    public List<UserInfo> getUserInfos() {
        // 没有国家的权限 为了扩展 超级管理员的type设置为4
        BaseQuery query = UserContext.getQuery();
        if (StringUtils.equals(UserContext.getUser().getUsername(), adminUser.getUsername())) {
            query.setType(4);
        }
        return userDao.selectUserInfos(query);
    }

    /** 
     * @see IUserService#createUser(User)
     */
    @Transactional
    @Override
    public void createUser(User user) {
        checkUserExist(user);
        //2.设置用户的级别
        initUserType(user);
        //3.添加用户
        userDao.insertUser(user);
        //4. 配置用户的默认权限 首页权限
        // user.getModules().add(new Module(Module.HOME_MODULE_ID));
        user.setModules(
        // 首页所有模块ID
        Arrays.asList(new Module(1), new Module(2), new Module(3), new Module(4), new Module(5)));
        userDao.insertUserModuleShip(user);
    }

    /**
     * 
     * @param user
     */
    private void checkUserExist(User user) {
        //1. 检查用户名、手机号是否重复
        User u = userDao.selectRepeatUser(user);
        if (u != null) {
            if (StringUtils.isNoneBlank(user.getUsername()) && StringUtils.equals(u.getUsername(), user.getUsername())) {
                throw new ApplicationException(BizErrorCode.USER_NAME_EXIST);
            }

            if (StringUtils.isNoneBlank(user.getMobile()) && StringUtils.equals(u.getMobile(), user.getMobile())) {
                throw new ApplicationException(BizErrorCode.USER_MOBILE_EXIST);
            }
        }
    }

    /** 
     * @see IUserService#deleteUser(Integer)
     */
    @Transactional
    @Override
    public void deleteUser(Integer id) {
        userDao.deleteUserById(id);
    }

    /**
     * @see IUserService#disableUser(Integer)
     */
    @Transactional
    @Override
    public void disableUser(Integer id) {
        userDao.updateUserStatus(id, -1);
    }

    /**
     * @see IUserService#enableUser(Integer)
     */
    @Transactional
    @Override
    public void enableUser(Integer id) {
        userDao.updateUserStatus(id, 0);
    }

    /** 
     * @see IUserService#updateUserRoleModules(User)
     */
    @Transactional
    @Override
    public void updateUserRoleModules(User user) {
        // 修改用户的角色名称
        User u = new User();
        u.setId(user.getId());
        u.setRole(user.getRole());
        // 删除用户的原来模块关联
        userDao.deleteUserModuleShip(user.getId());
        // 添加用户和模块的新关联
        userDao.insertUserModuleShip(user);
    }

    /** 
     * @see IUserService#getUserInfos(int, int)
     */
    @Override
    @Transactional
    public Map<String, Object> getUserInfos(int currentPage, int pageSize) {
        int limit = Math.max((currentPage - 1) * pageSize, 0);
        int offset = pageSize > 0 ? pageSize : 10;
        Map<String, Object> result = new HashMap<>();
        BaseQuery query = UserContext.getQuery();
        if (StringUtils.equals(UserContext.getUser().getUsername(), adminUser.getUsername())) {
            query.setType(4);
        }
        List<UserInfo> userinfos = null;
        long count = userDao.selectUserCount(query);
        if (count > 0) {
            userinfos = userDao.selectUserInfoPage(query, limit, offset);
        }
        result.put("total", count);
        result.put("currentPage", currentPage);
        result.put("pageSize", offset);
        result.put("data", userinfos);
        return result;
    }
}
