/**
 * BBD Service Inc
 * AllRight Reserved @2017
 */
package com.bbd.controller.reddata.login.controller;

import com.bbd.controller.AbstractController;
import com.bbd.exception.BizErrorCode;
import com.bbd.service.reddata.login.ILoginService;
import com.bbd.util.MD5Util;
import com.bbd.util.ValidateUtil;
import com.bbd.utils.UserContext;
import com.bean.RestResult;
import com.exception.ApplicationException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 登录
 * 
 * @author zhanghui
 * @version $Id: LoginController.java, v 0.1 2016年12月2日 下午6:09:49 xc Exp $
 */
@RestController
@RequestMapping(value = "/login")
@Api(description = "登录退出")
public class LoginController extends AbstractController {

    @Resource
    private ILoginService loginService;

    /**
     * 用户登录.
     * 
     * @param password 密码
     * @return 登录结果
     */
    @ApiOperation(value = "用户登录", httpMethod = "POST")
    @ApiImplicitParams(value = { @ApiImplicitParam(value = "用户名/手机号码", name = "account", paramType = "form", dataType = "java.lang.String", required = true, example = "username1/15708437406"),
            @ApiImplicitParam(value = "密码,5-10必须包含且只能是字母和数字", name = "password", paramType = "form", dataType = "java.lang.String", required = true, example = "123abc") })
    @RequestMapping(value = "/login.do", method = RequestMethod.POST)
    public RestResult login(String account, String password) {
        ValidateUtil.checkBlank(account, BizErrorCode.ACCOUNT_NOT_BLANK);
        ValidateUtil.checkBlank(password, BizErrorCode.PASSWORD_NOT_BLANK);
        loginService.login(account, MD5Util.MD5(password));
        if (UserContext.getUser() == null) {
            throw new ApplicationException(BizErrorCode.ACCOUNT_OR_PASSWORD_ERROR);
        }
        return RestResult.ok(UserContext.getUser());
    }

    /**
     * 用户登录.
     * 
     * @return 登录结果
     */
    @ApiOperation(value = "用户退出登录", httpMethod = "GET")
    @RequestMapping(value = "/logout.do", method = RequestMethod.GET)
    public RestResult logout() {
        loginService.logout();
        return RestResult.ok();
    }

}