/**  
 * BBD Service Inc
 * All Rights Reserved @2016
 *
 */
package com.bbd.controller.reddata.system;

import com.bbd.exception.BizErrorCode;
import com.bbd.service.reddata.system.IModuleService;
import com.bbd.util.ValidateUtil;
import com.bean.RestResult;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 模块控制器.
 * 
 * @author zhanghui
 * @version $Id: ModuleController.java, v 0.1 2016年12月13日 上午10:14:09 zhanghui Exp $
 */
@RestController
@RequestMapping("/module")
public class ModuleController {

    /** 模块服务 */
    @Resource
    private IModuleService moduleService;

    /**
     * 获取所有的模块和子模块
     */
    @ApiOperation(value = "获取所有的模块和子模块", httpMethod = "GET")
    @RequestMapping(value = "/getModules.do", method = RequestMethod.GET)
    public RestResult getModules() {
        return RestResult.ok(moduleService.getModules());
    }

    /**
     * 获取一个用户的模块
     */
    @ApiOperation(value = "获取一个用户的区域和模块", httpMethod = "GET")
    @RequestMapping(value = "/getUserModuleInfos.do", method = RequestMethod.GET)
    @ApiImplicitParam(value = "用户id", name = "id", paramType = "query", defaultValue = "96")
    public RestResult getUserModuleInfos(Integer id) {
        ValidateUtil.checkNull(id, BizErrorCode.ID_NOT_NULL);
        return RestResult.ok(moduleService.getUserModuleInfos(id));
    }
}
