/**
 * BBD Service Inc
 * AllRight Reserved @2017
 */
package com.bbd.controller.reddata.system;

import com.bbd.bean.system.User;
import com.bbd.exception.BizErrorCode;
import com.bbd.service.reddata.system.IUserService;
import com.bbd.util.MD5Util;
import com.bbd.util.ValidateUtil;
import com.bbd.utils.UserContext;
import com.bean.RestResult;
import com.exception.CommonErrorCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 用户管理控制器
 * 
 * @author 张慧
 * @version $Id: UserController.java, v 0.1 2016年12月5日 下午1:12:48 xc Exp $
 */
@RestController
@RequestMapping(value = "/user")
@Api(value = "用户管理")
public class UserController {

    @Resource
    private IUserService userService;

    /**
     * 查询当前用户能够管理的所有用户.
     * 
     * @return 用户信息列表
     */
    @ApiOperation(value = "查询当前用户能够管理的所有用户", httpMethod = "GET")
    @RequestMapping(value = "/getUserInfos.do", method = RequestMethod.GET)
    public RestResult getUserInfos() {
        return RestResult.ok(userService.getUserInfos());
    }

    /**
     * 查询当前用户能够管理的所有用户.
     * 
     * @return 用户信息列表
     */
    @ApiOperation(value = "查询当前用户能够管理的所有用户,分页查询", httpMethod = "POST", consumes = "application/x-www-form-urlencoded")
    @ApiImplicitParams(value = { @ApiImplicitParam(value = "页码", name = "currentPage", paramType = "form", defaultValue = "1"),
            @ApiImplicitParam(value = "每页多少条数据", name = "pageSize", paramType = "form", defaultValue = "1") })
    @RequestMapping(value = "/getUserPageInfos.do", method = RequestMethod.POST)
    public RestResult getUserPageInfos(int currentPage, int pageSize) {
        return RestResult.ok(userService.getUserInfos(currentPage, pageSize));
    }

    /**
     * 创建一个用户 根据当前登录用户的权限，省的用户只能添加该省 的用户，市的用户只能添加市的用户.
     * 
     * @return 创建用户的结果
     */
    @ApiOperation(value = "创建用户", httpMethod = "POST", consumes = "application/x-www-form-urlencoded")
    @ApiImplicitParams({ @ApiImplicitParam(value = "用户名", name = "username", paramType = "query", dataType = "java.lang.String", required = true, example = "小白"),
            @ApiImplicitParam(value = "密码,6到10位数字和字母", paramType = "query", name = "password", dataType = "java.lang.String", required = true, example = "123abc"),
            @ApiImplicitParam(value = "姓名", name = "name", paramType = "query", dataType = "java.lang.String", required = false, example = "张小白"),
            @ApiImplicitParam(value = "手机号", name = "mobile", paramType = "query", dataType = "java.lang.String", required = false, example = "15708886666"),
            @ApiImplicitParam(value = "省编码", name = "province", paramType = "query", dataType = "java.lang.String", required = true, example = "15708886666"),
            @ApiImplicitParam(value = "市编码", name = "city", paramType = "query", dataType = "java.lang.String", required = false, example = "15708886666"),
            @ApiImplicitParam(value = "区编码", name = "district", paramType = "query", dataType = "java.lang.String", required = false, example = "15708886666"), })
    @RequestMapping(value = "/createUser.do", method = RequestMethod.POST)
    public RestResult createUser(User user) {
        // 判断用户名和密码是否为null
        ValidateUtil.checkAllNull(CommonErrorCode.PARAM_NULL, user.getUsername(), user.getPassword());

        // 正则校验用户名和密码
        ValidateUtil.checkPassword(user.getPassword(), BizErrorCode.PASSWORD_ERROR);
        ValidateUtil.checkUsername(user.getUsername(), BizErrorCode.USERNAME_ERROR);

        // 如果手机号不为空检查手机号码
        if (StringUtils.isNotBlank(user.getMobile()))
            ValidateUtil.checkMobile(user.getMobile(), BizErrorCode.MOBILE_ERROR);

        // 判断省份是否为null
        ValidateUtil.checkBlank(user.getProvince(), BizErrorCode.PROVINCE_NOT_BLANK);

        // 加密密码
        user.setPassword(MD5Util.MD5(user.getPassword()));
        userService.createUser(user);
        return RestResult.ok();
    }

    /**
     * 修改用户.
     * 
     * @return 返回用户是否修改成功的标识.
     */
    @ApiOperation(value = "修改用户信息,修改密码时只能修改密码", httpMethod = "POST", consumes = "application/x-www-form-urlencoded")
    @ApiImplicitParams(value = { @ApiImplicitParam(value = "用户id", name = "id", paramType = "query", dataType = "java.lang.Integer", required = true, example = "1"),
            @ApiImplicitParam(value = "用户名", name = "username", paramType = "form", dataType = "java.lang.String", required = false, example = "小白"),
            @ApiImplicitParam(value = "姓名", name = "name", paramType = "form", dataType = "java.lang.String", required = false, example = "张小白"),
            @ApiImplicitParam(value = "手机号", name = "mobile", paramType = "form", dataType = "java.lang.String", required = false, example = "15708886666"),
            @ApiImplicitParam(value = "省编码", name = "province", paramType = "form", dataType = "java.lang.String", required = false, example = "2222"),
            @ApiImplicitParam(value = "市编码", name = "city", paramType = "form", dataType = "java.lang.String", required = false, example = "2222"),
            @ApiImplicitParam(value = "区编码", name = "district", paramType = "form", dataType = "java.lang.String", required = false, example = "1111"),
            @ApiImplicitParam(value = "密码", name = "password", paramType = "query", dataType = "java.lang.String", required = false, example = "123abc"), })
    @RequestMapping(value = "/updateUser.do", method = RequestMethod.POST)
    public RestResult updateUser(User user) {
        ValidateUtil.checkNull(user.getId(), BizErrorCode.ID_NOT_NULL);
        if (StringUtils.isNotBlank(user.getPassword())) {
            // 处理参数
            ValidateUtil.checkPassword(user.getPassword(), BizErrorCode.PASSWORD_ERROR);
            User u = new User();
            // 只能修改密码
            u.setId(user.getId());
            u.setPassword(MD5Util.MD5(user.getPassword()));
            userService.updateUser(u);
        } else {
            if ("-1".equals(user.getProvince())) {
                user.setProvince(null);
            }
            if ("-1".equals(user.getCity())) {
                user.setCity(null);
            }
            if ("-1".equals(user.getDistrict())) {
                user.setDistrict(null);
            }
            ValidateUtil.checkAllBlank(BizErrorCode.PARAM_NULL, user.getUsername(), user.getName(), user.getMobile(), user.getProvince());
            userService.updateUser(user);
        }
        return RestResult.ok();
    }

    /**
    * 删除一个用户
    * 
    * @param id 用户id
    * @return 删除用户的结果.
    */
    @ApiOperation(value = "删除用户信息", httpMethod = "GET")
    @ApiImplicitParam(value = "用户id", name = "id", dataType = "java.lang.Integer", paramType = "query", required = true, example = "1")
    @RequestMapping(value = "/deleteUser.do", method = { RequestMethod.POST, RequestMethod.GET })
    public RestResult deleteUser(Integer id) {
        ValidateUtil.checkNull(id, BizErrorCode.ID_NOT_NULL);
        userService.deleteUser(id);
        return RestResult.ok();
    }

    /**
    * 禁用一個用戶.
    * 
    * @param id 用户的id.
    * @return 禁用用户的结果
    */
    @ApiOperation(value = "禁用用户", httpMethod = "GET")
    @ApiImplicitParam(value = "用户id", name = "id", dataType = "java.lang.Integer", paramType = "query", required = true, example = "1")
    @RequestMapping(value = "/disableUser.do", method = { RequestMethod.POST, RequestMethod.GET })
    public RestResult disableUser(Integer id) {
        ValidateUtil.checkNull(id, BizErrorCode.ID_NOT_NULL);
        userService.disableUser(id);
        return RestResult.ok();
    }

    /**
     * 启用一個用戶.
     * 
     * @param id 用户的id.
     * @return 启用用户的结果
     */
    @ApiOperation(value = "启用用户", httpMethod = "GET")
    @ApiImplicitParam(value = "用户id", name = "id", paramType = "query", dataType = "java.lang.Integer", required = true, example = "1")
    @RequestMapping(value = "/enableUser.do", method = { RequestMethod.POST, RequestMethod.GET })
    public RestResult enableUser(Integer id) {
        ValidateUtil.checkNull(id, BizErrorCode.ID_NOT_NULL);
        userService.enableUser(id);
        return RestResult.ok();
    }

    /**
     * 修改用户的角色和模块.
     */
    @ApiOperation(value = "修改用户的角色和模块", httpMethod = "POST", consumes = "application/x-www-form-urlencoded")
    @ApiImplicitParams({ @ApiImplicitParam(value = "用户id", name = "id", paramType = "query", dataType = "java.lang.Integer", required = true, example = "1"),
            @ApiImplicitParam(value = "模块id列表", name = "modules[0].id", paramType = "query", dataType = "java.lang.Integer", required = true, example = "1"),
            @ApiImplicitParam(value = "模块id列表", name = "modules[1].id", paramType = "query", dataType = "java.lang.Integer", required = true, example = "1"),
            @ApiImplicitParam(value = "模块id列表", name = "modules[2].id", paramType = "query", dataType = "java.lang.Integer", required = true, example = "1"), })
    @RequestMapping(value = "/updateUserRoleModules.do", method = { RequestMethod.POST })
    public RestResult updateUserRoleModules(User user) {
        ValidateUtil.checkNull(user.getId(), BizErrorCode.ID_NOT_NULL);
        ValidateUtil.checkNull(user.getRole(), BizErrorCode.ROLE_NAME_NOT_BLANK);
        ValidateUtil.checkListEmpty(user.getModules(), BizErrorCode.MODULES_NOT_EMPTY);
        userService.updateUserRoleModules(user);
        return RestResult.ok();
    }

    /**
     * 修改用户的角色和模块.
     */
    @ApiOperation(value = "获取已经登录的用户", httpMethod = "GET")
    @RequestMapping(value = "/getLoggedUserInfo.do", method = RequestMethod.GET)
    public RestResult getLoggedUserInfo() {
        return RestResult.ok(UserContext.getUser());
    }
}