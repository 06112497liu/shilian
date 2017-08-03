/**
 * BBD Service Inc
 * All Rights Reserved @2017
 */
package com.bbd.controller.reddata.remind;

import com.bbd.controller.AbstractController;
import com.bbd.service.reddata.remind.IMsgTaskQueryService;
import com.bbd.service.reddata.remind.IMsgTaskService;
import com.bbd.service.reddata.remind.param.MsgTaskQueryParam;
import com.bbd.service.reddata.remind.param.MsgTaskQueryVO;
import com.bbd.service.reddata.remind.param.RemindDetailQueryVo;
import com.bbd.util.StringUtils;
import com.bbd.util.ValidateUtil;
import com.bbd.utils.PermissionUtil;
import com.bbd.utils.UserContext;
import com.bean.RestResult;
import com.exception.CommonErrorCode;
import com.mybatis.domain.PageList;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 消息任务查询控制层
 *
 * @author liuweibo
 * @version $Id: MsgTaskController.java, v 0.1 2017年6月8日 下午2:53:36 liuweibo Exp $
 */
@Api(description = "提示列表查询")
@RestController
@RequestMapping("/msg/task")
public class MsgTaskController extends AbstractController {

    @Resource
    private IMsgTaskQueryService msgTaskQueryService;

    @Resource
    private IMsgTaskService      msgTaskService;

    /**
     * 查询提示进度列表
     *
     * @return 统一JSON数据
     */
    @ApiOperation(value = "查询提示进度列表", httpMethod = "GET")
    @ApiImplicitParams({ @ApiImplicitParam(value = "页号", name = "page", dataType = "Integer", paramType = "query", required = false),
            @ApiImplicitParam(value = "分页大小", name = "limit", dataType = "Integer", paramType = "query", required = false),
            @ApiImplicitParam(value = "提示类型（ 1.企业年报提示, 2.失联企业提示, 3.未年报企业提示, 4.未公示企业提示, 5.虚假信息企业提示  ）", name = "taskType", dataType = "Integer", paramType = "query", required = true),
            @ApiImplicitParam(value = "操作类型（  0.自动, 1.手动  ）", name = "operationType", dataType = "Integer", paramType = "query", required = false),
            @ApiImplicitParam(value = "提示方式（ 1.邮件, 2.短信, 3.语音  ）", name = "method", dataType = "Integer", paramType = "query", required = false),
            @ApiImplicitParam(value = "提示时间排序方式（ 1.降序, 2.升序 ）", name = "order", dataType = "Integer", paramType = "query", required = false) })
    @RequestMapping(value = "/schedule.do", method = RequestMethod.GET)
    public RestResult getMsgTaskList(MsgTaskQueryParam query) {
        // 验证是提示类型是否为null
        ValidateUtil.checkNull(query.getTaskType(), CommonErrorCode.PARAM_NULL);
        PageList<MsgTaskQueryVO> pageList = msgTaskQueryService.getMsgTaskList(query, getPageBounds());
        return RestResult.ok(pageList);
    }

    /**
     * 查询企业提示详情列表
     *
     * @return 统一JSON数据
     */
    @ApiOperation(value = "查询企业提示详情列表", httpMethod = "GET")
    @ApiImplicitParams({ @ApiImplicitParam(value = "企业nbxh", name = "nbxh", dataType = "Integer", paramType = "query", required = true) })
    @RequestMapping(value = "/detail.do", method = RequestMethod.GET)
    public RestResult getRemindDetailList(String nbxh) {
        // 验证是企业nbxh是否为null
        ValidateUtil.checkNull(nbxh, CommonErrorCode.PARAM_NULL);
        List<RemindDetailQueryVo> pageList = msgTaskQueryService.getRemindDetailList(nbxh);
        return RestResult.ok(pageList);
    }

    /**
     * 查询提醒任务列表
     *
     * @return 统一JSON数据
     */
    @ApiOperation(value = "查询提醒任务列表", httpMethod = "GET")
    @ApiImplicitParams({ @ApiImplicitParam(value = "区域编码", name = "district", dataType = "String", paramType = "query", required = false),
            @ApiImplicitParam(value = "类型（1.年报， 2.失联， 3.未年报， 4.未公示， 5.虚假信息）", name = "type", dataType = "Integer", paramType = "query", required = true),
            @ApiImplicitParam(value = "总条数-第几次-1", name = "page", dataType = "Integer", paramType = "query", required = false) })
    @RequestMapping(value = "/last/list.do", method = RequestMethod.GET)
    public RestResult getMsgTaskList(String district, Integer type, Integer page) {
        ValidateUtil.checkNull(type, CommonErrorCode.PARAM_NULL);
        if (StringUtils.isBlank(district)) {
            district = String.valueOf(UserContext.getQuery().getAddr());
        } else {
            PermissionUtil.checkPermission(district);
        }
        if (page == null)
            page = 1;
        List<MsgTaskQueryVO> result = msgTaskService.getLastRemindTask(district, type, page);
        return RestResult.ok(result);
    }

}
