/** 
 * BBD Service Inc 
 * All Rights Reserved @2017 
 */
package com.bbd.controller.reddata.remind;

import com.bbd.controller.AbstractController;
import com.bbd.exception.BizErrorCode;
import com.bbd.service.reddata.remind.IAutoRemindSettingService;
import com.bbd.service.reddata.remind.param.AutoRemindSettingParam;
import com.bbd.service.reddata.remind.param.AutoRemindSettingQueryVo;
import com.bbd.util.ValidateUtil;
import com.bbd.utils.PermissionUtil;
import com.bean.RestResult;
import com.exception.CommonErrorCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/** 
 * 自动提示周期设置控制层
 * 
 * @author liuweibo 
 * @version $Id: MsgTaskController.java, v 0.1 2017年6月8日 下午2:53:36 liuweibo Exp $ 
 */
@Api(description = "自动提示周期设置")
@RestController
@RequestMapping("/remind/auto/cycle")
public class AutoRemindSettingController extends AbstractController {

    @Resource
    private IAutoRemindSettingService autoRemindSettingService;

    /**
     * 查询提示周期列表
     * @return               统一JSON数据
     */
    @ApiOperation(value = "查询提示周期列表", httpMethod = "GET")
    @ApiImplicitParams({ @ApiImplicitParam(value = "提示类型( 1:企业年报提示, 2:失联企业提示, 3:未年报企业提示, 4:未公示企业提示, 5:虚假信息企业提示 )", name = "taskType", dataType = "Integer", paramType = "query", required = true),
            @ApiImplicitParam(value = "区域代码", name = "district", dataType = "Integer", paramType = "query", required = false) })
    @RequestMapping(value = "/list.do", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public RestResult taskList(Integer taskType, String district) {
        ValidateUtil.checkNull(taskType, CommonErrorCode.PARAM_NULL);
        PermissionUtil.checkPermission(district);
        List<AutoRemindSettingQueryVo> results = autoRemindSettingService.findSettings(taskType, district);
        return RestResult.ok(results);
    }

    /**
     * 新增提示周期
     * @return               统一JSON数据
     */
    @ApiOperation(value = "新增提示周期", httpMethod = "GET")
    @ApiImplicitParams({ 
        @ApiImplicitParam(value = "提示类型( 1:企业年报提示, 2:失联企业提示, 3:未年报企业提示, 4:未公示企业提示, 5:虚假信息企业提示 )", name = "taskType", dataType = "Integer", paramType = "query", required = true),
        @ApiImplicitParam(value = "任务运行日期（yyyy-MM-dd）", name = "runDate", dataType = "Integer", paramType = "query", required = true),
        @ApiImplicitParam(value = "区域代码", name = "district", dataType = "Integer", paramType = "query", required = false) })
    @RequestMapping(value = "/add.do", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public RestResult taskAdd(AutoRemindSettingParam params) {
        // 校验提示类型和任务运行日期是否为null
        ValidateUtil.checkAllNull(CommonErrorCode.PARAM_NULL, params.getTaskType(), params.getRunDate());
        return RestResult.ok(autoRemindSettingService.add(params));
    }

    /**
     * 修改提示周期
     * @return               统一JSON数据
     */
    @ApiOperation(value = "修改提示周期", httpMethod = "GET")
    @ApiImplicitParams({ @ApiImplicitParam(value = "id", name = "id", dataType = "Integer", paramType = "query", required = true),
            @ApiImplicitParam(value = "任务运行日期（yyyy-MM-dd HH:mm:ss）", name = "runDate", dataType = "Integer", paramType = "query", required = true) })
    @RequestMapping(value = "/modify.do", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public RestResult taskModify(AutoRemindSettingParam params) {
        // 校验任务运行日期和id是否为null
        ValidateUtil.checkAllNull(CommonErrorCode.PARAM_NULL, params.getRunDate(), params.getId());
        return RestResult.ok(autoRemindSettingService.update(params));
    }

    /**
     * 删除提示周期
     * @return               统一JSON数据
     */
    @ApiOperation(value = "删除提示周期", httpMethod = "GET")
    @ApiImplicitParams({ @ApiImplicitParam(value = "id", name = "id", dataType = "Integer", paramType = "query", required = true) })
    @RequestMapping(value = "/delete.do", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public RestResult taskDel(Integer id) {
        // 校验任务id是否为null
        ValidateUtil.checkNull(id, BizErrorCode.ID_NOT_NULL);
        return RestResult.ok(autoRemindSettingService.remove(id));
    }

    /**
     * 启用提示周期
     * @return               统一JSON数据
     */
    @ApiOperation(value = "启用提示周期", httpMethod = "GET")
    @ApiImplicitParams({ @ApiImplicitParam(value = "id", name = "id", dataType = "Integer", paramType = "query", required = true) })
    @RequestMapping(value = "/enable.do", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public RestResult taskEnable(Integer id) {
        // 校验任务id是否为null
        ValidateUtil.checkNull(id, BizErrorCode.ID_NOT_NULL);
        return RestResult.ok(autoRemindSettingService.enable(id));
    }

    /**
     * 禁用提示周期
     * @return               统一JSON数据
     */
    @ApiOperation(value = "禁用提示周期", httpMethod = "GET")
    @ApiImplicitParams({ @ApiImplicitParam(value = "id", name = "id", dataType = "Integer", paramType = "query", required = true) })
    @RequestMapping(value = "/disable.do", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public RestResult taskDisable(Integer id) {
        // 校验任务id是否为null
        ValidateUtil.checkNull(id, CommonErrorCode.PARAM_NULL);
        return RestResult.ok(autoRemindSettingService.disable(id));
    }

    /**
     * 启用提示周期（全部）
     * @return               统一JSON数据
     */
    @ApiOperation(value = "启用提示周期（全部）", httpMethod = "GET")
    @ApiImplicitParams({ @ApiImplicitParam(value = "提示类型( 1:企业年报提示, 2:失联企业提示, 3:未年报企业提示, 4:未公示企业提示, 5:虚假信息企业提示 )", name = "taskType", dataType = "Integer", paramType = "query", required = true),
            @ApiImplicitParam(value = "区域编码", name = "district", dataType = "Integer", paramType = "query", required = false) })
    @RequestMapping(value = "/enableAll.do", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public RestResult taskEnableAll(Integer taskType, String district) {
        // 校验提示类型是否为null
        ValidateUtil.checkNull(taskType, CommonErrorCode.PARAM_NULL);
        PermissionUtil.checkPermission(district);
        return RestResult.ok(autoRemindSettingService.enableAll(taskType, district));
    }

    /**
     * 禁用提示周期（全部）
     * @return               统一JSON数据
     */
    @ApiOperation(value = "禁用提示周期（全部）", httpMethod = "GET")
    @ApiImplicitParams({ @ApiImplicitParam(value = "提示类型( 1:企业年报提示, 2:失联企业提示, 3:未年报企业提示, 4:未公示企业提示, 5:虚假信息企业提示 )", name = "taskType", dataType = "Integer", paramType = "query", required = true),
            @ApiImplicitParam(value = "区域编码", name = "district", dataType = "Integer", paramType = "query", required = false) })
    @RequestMapping(value = "/disableAll.do", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public RestResult taskDisableAll(Integer taskType, String district) {
        // 校验提示类型是否为null
        ValidateUtil.checkNull(taskType, CommonErrorCode.PARAM_NULL);
        PermissionUtil.checkPermission(district);
        return RestResult.ok(autoRemindSettingService.disableAll(taskType, district));
    }
}
