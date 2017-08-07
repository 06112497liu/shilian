/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.controller.reddata.remind;

import com.bbd.controller.AbstractController;
import com.bbd.controller.param.MannualRemindConditionParam;
import com.bbd.controller.param.MsgTaskCreateVO;
import com.bbd.domain.MsgTaskInfo;
import com.bbd.service.reddata.company.ICompanyService;
import com.bbd.service.reddata.remind.IMsgTaskService;
import com.bbd.service.reddata.remind.param.AbnormalRemindCompanyVO;
import com.bbd.service.reddata.remind.param.AnnualRemindCompanyVO;
import com.bbd.service.reddata.remind.param.MannualRemindCondition;
import com.bbd.service.reddata.statistics.ICompanyStatisticsService;
import com.bbd.util.ValidateUtil;
import com.bbd.utils.PermissionUtil;
import com.bbd.utils.UserContext;
import com.bean.RestResult;
import com.exception.CommonErrorCode;
import com.utils.BeanMapperUtil;
import com.utils.ObjectMapperUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * 企业提醒
 * @author tjwang
 * @version $Id: CompanyRemindController.java, v 0.1 2017/6/13 0013 9:36 tjwang Exp $
 */
@RestController
@RequestMapping("/company/remind")
@Api(description = "企业一键提示")
public class CompanyRemindController extends AbstractController {

    @Resource
    private ICompanyService           companyService;

    @Resource
    private ICompanyStatisticsService companyStatisticsService;

    @Resource
    private IMsgTaskService           msgTaskService;

    /**
     * 查询年报提示企业信息详情列表
     * @return               统一JSON数据
     */
    @ApiOperation(value = "查询年报提示企业信息详情列表", httpMethod = "GET")
    @ApiImplicitParams({ @ApiImplicitParam(value = "页号", name = "page", dataType = "Integer", paramType = "query", required = false),
            @ApiImplicitParam(value = "分页大小", name = "limit", dataType = "Integer", paramType = "query", required = false),
            @ApiImplicitParam(value = "企业名称", name = "companyName", dataType = "Integer", paramType = "query", required = false),
            @ApiImplicitParam(value = "区域", name = "district", dataType = "Integer", paramType = "query", required = true),
            @ApiImplicitParam(value = "一级行业", name = "primaryIndustry", dataType = "Integer", paramType = "query", required = false),
            @ApiImplicitParam(value = "经营活动指数开始", name = "indexScoreFrom", dataType = "Integer", paramType = "query", required = false),
            @ApiImplicitParam(value = "经营活动指数结束", name = "indexScoreTo", dataType = "Integer", paramType = "query", required = false) })
    @RequestMapping(value = "/annual/list.do", method = RequestMethod.GET)
    public RestResult searchAnnual(MannualRemindConditionParam param) {
        // 验证区域是否为null
        ValidateUtil.checkNull(param.getDistrict(), CommonErrorCode.PARAM_NULL);
        PermissionUtil.checkPermission(param.getDistrict());

        List<AnnualRemindCompanyVO> result = companyService.getAnnualList(param, getPageBounds());
        return RestResult.ok(result);
    }

    /**
     * 查询未年报企业数量
     * @return               统一JSON数据
     */
    @ApiOperation(value = "查询未年报企业数量", httpMethod = "GET")
    @ApiImplicitParams({ @ApiImplicitParam(value = "区域编码", name = "district", dataType = "Integer", paramType = "query", required = true), })
    @RequestMapping(value = "/unannual/count.do", method = RequestMethod.GET)
    public RestResult getUnannualCount(String district) {
        ValidateUtil.checkNull(district, CommonErrorCode.PARAM_NULL);
        PermissionUtil.checkPermission(district);
        Integer result = companyStatisticsService.getUnannualedCompanyCount(district);
        return RestResult.ok(result);
    }

    /**
     * 查询异常提示企业信息详情列表
     * @return               统一JSON数据
     */
    @ApiOperation(value = "查询异常提示企业信息详情列表", httpMethod = "GET")
    @ApiImplicitParams({ @ApiImplicitParam(value = "类型（1-未年报 2-未公示 4-虚假信息 8-失联）", name = "abnormalState", dataType = "Integer", paramType = "query", required = true),
            @ApiImplicitParam(value = "页号", name = "page", dataType = "Integer", paramType = "query", required = false),
            @ApiImplicitParam(value = "分页大小", name = "limit", dataType = "Integer", paramType = "query", required = false),
            @ApiImplicitParam(value = "企业名称", name = "companyName", dataType = "Integer", paramType = "query", required = false),
            @ApiImplicitParam(value = "区域", name = "district", dataType = "Integer", paramType = "query", required = true),
            @ApiImplicitParam(value = "一级行业", name = "primaryIndustry", dataType = "Integer", paramType = "query", required = false),
            @ApiImplicitParam(value = "经营活动指数开始", name = "indexScoreFrom", dataType = "Integer", paramType = "query", required = false),
            @ApiImplicitParam(value = "经营活动指数结束", name = "indexScoreTo", dataType = "Integer", paramType = "query", required = false) })
    @RequestMapping(value = "/abnormal/list.do", method = RequestMethod.GET)
    public RestResult searchAbnormal(MannualRemindConditionParam param, Integer abnormalState) {

        // 验证区域和异常装填是否为null
        ValidateUtil.checkAllNull(CommonErrorCode.PARAM_NULL, abnormalState, param.getDistrict());
        PermissionUtil.checkPermission(param.getDistrict());
        List<AbnormalRemindCompanyVO> result = companyService.getAbnormalList(param, abnormalState, getPageBounds());
        return RestResult.ok(result);
    }

    /**
     * 一键提示
     * @return               统一JSON数据
     */
    @ApiOperation(value = "一键提示", httpMethod = "GET")
    @ApiImplicitParams({ @ApiImplicitParam(value = "提示类型（1.企业年报提示,2.失联企业提示,3.未年报企业提示,4.未公示企业提示,5.虚假信息企业提示）", name = "type", dataType = "Integer", paramType = "query", required = true),
            @ApiImplicitParam(value = "提示方式(1.邮件,2.短信,3.语音)", name = "method", dataType = "Integer", paramType = "query", required = true),
            @ApiImplicitParam(value = "企业名称", name = "conditions.companyName", dataType = "Integer", paramType = "query", required = false),
            @ApiImplicitParam(value = "区域", name = "conditions.district", dataType = "Integer", paramType = "query", required = true),
            @ApiImplicitParam(value = "一级行业", name = "conditions.primaryIndustry", dataType = "Integer", paramType = "query", required = false),
            @ApiImplicitParam(value = "经营活动指数开始", name = "conditions.indexScoreFrom", dataType = "Integer", paramType = "query", required = false),
            @ApiImplicitParam(value = "经营活动指数结束", name = "conditions.indexScoreTo", dataType = "Integer", paramType = "query", required = false) })
    @RequestMapping(value = "/task/add.do", method = RequestMethod.GET)
    public RestResult addTask(MsgTaskCreateVO param) {
        MannualRemindConditionParam conditions = param.getConditions();
        // 验证区域、提示类型、提示方式是否为null
        ValidateUtil.checkAllNull(CommonErrorCode.PARAM_NULL, param.getType(), param.getMethod(), conditions.getDistrict());
        PermissionUtil.checkPermission(conditions.getDistrict());
        MsgTaskInfo info = BeanMapperUtil.map(param, MsgTaskInfo.class);
        MannualRemindCondition cond = BeanMapperUtil.map(conditions, MannualRemindCondition.class);
        String condStr = ObjectMapperUtil.write(cond);
        info.setConditions(condStr);
        info.setDistrict(String.valueOf(UserContext.getQuery().getAddr()));
        msgTaskService.addTask(info);

        return RestResult.ok(null);
    }

    /**
     * 根据企业nbxh一键提示
     * @return               统一JSON数据
     */
    @ApiOperation(value = "根据企业nbxh一键提示", httpMethod = "GET")
    @ApiImplicitParams({ @ApiImplicitParam(value = "提示类型（1.企业年报提示,2.失联企业提示,3.未年报企业提示,4.未公示企业提示,5.虚假信息企业提示）", name = "type", dataType = "Integer", paramType = "query", required = true),
            @ApiImplicitParam(value = "提示方式(1.邮件,2.短信,3.语音)", name = "method", dataType = "Integer", paramType = "query", required = true),
            @ApiImplicitParam(value = "企业nbxh（多选）", name = "nbxhs", dataType = "Integer", paramType = "query", required = true) })
    @RequestMapping(value = "/task/company/add.do", method = RequestMethod.GET)
    public RestResult addTask(MsgTaskCreateVO param, String[] nbxhs) {
        // 验证提示类型、提示方式、企业nbxh是否为null
        ValidateUtil.checkAllNull(CommonErrorCode.PARAM_NULL, param.getType(), param.getMethod(), nbxhs);
        MsgTaskInfo info = BeanMapperUtil.map(param, MsgTaskInfo.class);
        info.setConditions(param.getConditions().toString());
        info.setDistrict(String.valueOf(UserContext.getQuery().getAddr()));

        msgTaskService.addTaskWithNbxhs(info, Arrays.asList(nbxhs));

        return RestResult.ok(null);
    }

}
