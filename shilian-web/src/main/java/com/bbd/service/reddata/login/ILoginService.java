/**
 * BBD Service Inc
 * AllRight Reserved @2017
 */
package com.bbd.service.reddata.login;

/**
 * 登录业务接口
 * 
 * @author xc
 * @version $Id: LoginService.java, v 0.1 2016年12月2日 下午6:21:39 xc Exp $
 */
public interface ILoginService {

    /**
     * 用户登录.
     * 
     * @param account 用户名/phone number
     * @param password 密码
     */
    void login(String account, String password);

    /**
     * 用户退出登录
     */
    void logout();

}
