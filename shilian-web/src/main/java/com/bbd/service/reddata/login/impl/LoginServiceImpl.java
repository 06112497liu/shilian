/**
 * BBD Service Inc
 * AllRight Reserved @2017
 */
package com.bbd.service.reddata.login.impl;

import com.bbd.bean.system.LoginUserInfo;
import com.bbd.bean.system.ModuleInfo;
import com.bbd.dao.system.ModuleDao;
import com.bbd.dao.system.UserDao;
import com.bbd.exception.BizErrorCode;
import com.bbd.service.reddata.login.ILoginService;
import com.bbd.util.ValidateUtil;
import com.bbd.utils.UserContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户登录.
 * 
 * @author zhanghui
 * @version $Id: LoginServiceImpl.java, v 0.1 2016年12月2日 下午6:21:26 xc Exp $
 */
@Service
public class LoginServiceImpl implements ILoginService {

    @Resource
    private UserDao       userDao;

    @Resource
    private ModuleDao     moduleDao;

    @Resource
    private LoginUserInfo adminUser;

    /** 
     * @see ILoginService#login(String, String)
     */
    @Override
    public void login(String account, String password) {
        // 是超级管理员
        LoginUserInfo user = null;
        if (account.equals(adminUser.getUsername())) {
            user = new LoginUserInfo();
            user.setUsername(adminUser.getUsername());
            user.setPassword(adminUser.getPassword());
            user.setProvince(adminUser.getProvince());
            user.setRole(adminUser.getRole());
            user.setType(adminUser.getType());
            user.setStatus(0);
            user.setModules(moduleDao.selectAllModuleInfos());
        } else {
            user = userDao.selectLoginUserInfoByAccount(account);
        }
        // 检查用户是否存在
        ValidateUtil.checkNull(user, BizErrorCode.ACCOUNT_OR_PASSWORD_ERROR);

        // 检查用户密码是否正确
        ValidateUtil.checkEquals(password, user.getPassword(), BizErrorCode.ACCOUNT_OR_PASSWORD_ERROR);

        // 检查 用户的状态能否登录
        ValidateUtil.checkEquals(user.getStatus(), 0, BizErrorCode.DISABLED_USER);

        if (user.getModules() == null) {
            List<ModuleInfo> modules = userDao.selectUserModuleInfos(user.getId());
            user.setModules(modules);
        }

        // 验证模块是否为空.
        ValidateUtil.checkListEmpty(user.getModules(), BizErrorCode.PERMISSION_NOT_ENOUGH);

        // 保存用户信息到session
        user.setPassword(null);
        UserContext.setUser(user);
    }

    /** 
     * @see ILoginService#logout()
     */
    @Override
    public void logout() {
        UserContext.removeUser();
        UserContext.removeQuery();
    }
}
