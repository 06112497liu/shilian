/**
 * BBD Service Inc
 * All Rights Reserved @2017
 */
package com.bbd.controller.reddata.activity;

import com.bbd.bean.company.CompanyBusinessInfoVO;
import com.bbd.bean.statistics.CompanyActiveIndexStatisticsInfo;
import com.bbd.controller.AbstractController;
import com.bbd.controller.param.CompanyBusinessInfoQueryParam;
import com.bbd.controller.reddata.activity.param.ActiveIndexQuery;
import com.bbd.service.reddata.activity.IActivityIndexService;
import com.bbd.util.ValidateUtil;
import com.bbd.utils.ExportExcelUtil;
import com.bbd.utils.PermissionUtil;
import com.bbd.utils.SessionContext;
import com.bean.RestResult;
import com.exception.CommonErrorCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * ***企业经营活动指数页面接口**
 *
 * @author liuweibo
 * @version $Id CompanyInfoController.java, v 0.1 2017/5/2 11:16 liuweibo Exp $
 */
@RestController
@RequestMapping("/activeIndex")
@Api(description = "企业经营活动指数分析统计")
public class ActivityIndexController extends AbstractController {

    @Resource
    private IActivityIndexService activeIndexService;

    /**
     * 企业经营活动指数趋势折线图
     *
     * @return
     */
    @ApiOperation(value = "企业经营活动指数趋势折线图", httpMethod = "GET")
    @ApiImplicitParams({ @ApiImplicitParam(name = "areaCode", value = "地区编码(例如：5201代表贵阳)", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "companyState", value = "异常类型(0-正常企业，1-失联企业，2-已吊销未注销企业，4-严重违法企业)", required = true, dataType = "true", paramType = "query"),
            @ApiImplicitParam(name = "companyProperties", value = "企业类型(1-民营企业 2-国有企业 3-外资企业)", required = false, dataType = "true", paramType = "query"),
            @ApiImplicitParam(name = "primaryIndustry", value = "所属一级行业(A-农、林、牧、渔业 B-采矿业....)", required = false, dataType = "true", paramType = "query"),
            @ApiImplicitParam(name = "companyRegisterFrom", value = "企业注册开始时间", required = false, dataType = "true", paramType = "query"),
            @ApiImplicitParam(name = "companyRegisterTo", value = "企业注册结束时间", required = false, dataType = "true", paramType = "query") })
    @RequestMapping(value = "/getIndexTrend.do", method = RequestMethod.GET)
    public RestResult getIndexTrend(@Valid ActiveIndexQuery indexQuery) {
        String district = indexQuery.getAreaCode();
        PermissionUtil.checkPermission(district);
        Map<Integer, CompanyActiveIndexStatisticsInfo> rs = activeIndexService.getActivityIndexTrend(indexQuery);
        return RestResult.ok(rs);
    }

    /**
     * 休眠企业率折线图
     *
     * @return
     */
    @ApiOperation(value = "休眠企业率折线图", httpMethod = "GET")
    @ApiImplicitParams({ @ApiImplicitParam(name = "areaCode", value = "地区编码(例如：5201代表贵阳)", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "companyState", value = "异常类型(0-正常企业，1-失联企业，2-已吊销未注销企业，4-严重违法企业)", required = true, dataType = "true", paramType = "query"),
            @ApiImplicitParam(name = "companyProperties", value = "企业类型(1-民营企业 2-国有企业 3-外资企业)", required = false, dataType = "true", paramType = "query"),
            @ApiImplicitParam(name = "primaryIndustry", value = "所属一级行业(A-农、林、牧、渔业 B-采矿业....)", required = false, dataType = "true", paramType = "query"),
            @ApiImplicitParam(name = "companyRegisterFrom", value = "企业注册开始时间", required = false, dataType = "true", paramType = "query"),
            @ApiImplicitParam(name = "companyRegisterTo", value = "企业注册结束时间", required = false, dataType = "true", paramType = "query") })
    @RequestMapping(value = "/getDormancyTrend.do", method = RequestMethod.GET)
    public RestResult getDormancyTrend(@Valid ActiveIndexQuery indexQuery) {
        String district = indexQuery.getAreaCode();
        PermissionUtil.checkPermission(district);
        return RestResult.ok(activeIndexService.getDormancyTrend(indexQuery));
    }

    /**
     * 企业经营活动指数饼状图
     *
     * @return
     */
    @ApiOperation(value = "企业经营活动指数饼状图", httpMethod = "GET")
    @ApiImplicitParams({ @ApiImplicitParam(name = "areaCode", value = "地区编码(例如：5201代表贵阳)", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "companyState", value = "异常类型(0-正常企业，1-失联企业，2-已吊销未注销企业，4-严重违法企业)", required = true, dataType = "true", paramType = "query"),
            @ApiImplicitParam(name = "companyProperties", value = "企业类型(1-民营企业 2-国有企业 3-外资企业)", required = false, dataType = "true", paramType = "query"),
            @ApiImplicitParam(name = "primaryIndustry", value = "所属一级行业(A-农、林、牧、渔业 B-采矿业....)", required = false, dataType = "true", paramType = "query"),
            @ApiImplicitParam(name = "companyRegisterFrom", value = "企业注册开始时间", required = false, dataType = "true", paramType = "query"),
            @ApiImplicitParam(name = "companyRegisterTo", value = "企业注册结束时间", required = false, dataType = "true", paramType = "query") })
    @RequestMapping(value = "/getActivityIndexGroup.do", method = RequestMethod.GET)
    public RestResult getBusinessActivityIndexGroup(@Valid ActiveIndexQuery indexQuery) {
        String district = indexQuery.getAreaCode();
        PermissionUtil.checkPermission(district);
        return RestResult.ok(activeIndexService.getBusinessActivityIndexGroup(indexQuery));
    }

    /**
     * 疑似休眠企业一级行业分布
     *
     * @return
     */
    @ApiOperation(value = "疑似休眠企业一级行业分布", httpMethod = "GET")
    @ApiImplicitParams({ @ApiImplicitParam(name = "areaCode", value = "地区编码(例如：5201代表贵阳)", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "companyState", value = "异常类型(0-正常企业，1-失联企业，2-已吊销未注销企业，4-严重违法企业)", required = true, dataType = "true", paramType = "query"),
            @ApiImplicitParam(name = "companyProperties", value = "企业类型(1-民营企业 2-国有企业 3-外资企业)", required = false, dataType = "true", paramType = "query"),
            @ApiImplicitParam(name = "primaryIndustry", value = "所属一级行业(A-农、林、牧、渔业 B-采矿业....)", required = false, dataType = "true", paramType = "query"),
            @ApiImplicitParam(name = "companyRegisterFrom", value = "企业注册开始时间", required = false, dataType = "true", paramType = "query"),
            @ApiImplicitParam(name = "companyRegisterTo", value = "企业注册结束时间", required = false, dataType = "true", paramType = "query") })
    @RequestMapping(value = "/getDormancyIndustry.do", method = RequestMethod.GET)
    public RestResult getDormancyIndustry(@Valid ActiveIndexQuery indexQuery) {
        String district = indexQuery.getAreaCode();
        PermissionUtil.checkPermission(district);
        return RestResult.ok(activeIndexService.getDormancyIndustry(indexQuery));
    }

    /**
     * 疑似休眠企业区域分布
     *
     * @return
     */
    @ApiOperation(value = "疑似休眠企业区域分布", httpMethod = "GET")
    @ApiImplicitParams({ @ApiImplicitParam(name = "areaCode", value = "地区编码(例如：5201代表贵阳)", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "companyState", value = "异常类型(0-正常企业，1-失联企业，2-已吊销未注销企业，4-严重违法企业)", required = true, dataType = "true", paramType = "query"),
            @ApiImplicitParam(name = "companyProperties", value = "企业类型(1-民营企业 2-国有企业 3-外资企业)", required = false, dataType = "true", paramType = "query"),
            @ApiImplicitParam(name = "primaryIndustry", value = "所属一级行业(A-农、林、牧、渔业 B-采矿业....)", required = false, dataType = "true", paramType = "query"),
            @ApiImplicitParam(name = "companyRegisterFrom", value = "企业注册开始时间", required = false, dataType = "true", paramType = "query"),
            @ApiImplicitParam(name = "companyRegisterTo", value = "企业注册结束时间", required = false, dataType = "true", paramType = "query") })
    @RequestMapping(value = "/getDormancyArea.do", method = RequestMethod.GET)
    public RestResult getDormancyArea(@Valid ActiveIndexQuery indexQuery) {
        String district = indexQuery.getAreaCode();
        PermissionUtil.checkPermission(district);
        return RestResult.ok(activeIndexService.getDormancyArea(indexQuery));
    }

    /**
     * 企业经营活动指数列表
     *
     * @return
     */
    @ApiOperation(value = "企业经营活动指数列表", httpMethod = "GET")
    @ApiImplicitParams({ @ApiImplicitParam(name = "district", value = "地区编码", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "companyState", value = "异常类型(0-正常企业，1-失联企业，2-已吊销未注销企业，4-严重违法企业)", required = true, dataType = "true", paramType = "query"),
            @ApiImplicitParam(name = "page", value = "第几页", required = false, dataType = "true", paramType = "query"),
            @ApiImplicitParam(name = "limit", value = "每页数量", required = false, dataType = "true", paramType = "query"),
            @ApiImplicitParam(name = "companyName", value = "公司名称", required = false, dataType = "true", paramType = "query"),
            @ApiImplicitParam(name = "primaryIndustry", value = "所属一级行业(A-农、林、牧、渔业 B-采矿业....)", required = false, dataType = "true", paramType = "query"),
            @ApiImplicitParam(name = "indexScoreFrom", value = "经营活动最小值", required = false, dataType = "true", paramType = "query"),
            @ApiImplicitParam(name = "indexScoreTo", value = "经营活动最大值", required = false, dataType = "true", paramType = "query"),
            @ApiImplicitParam(name = "order", value = "经营活动指数排序（1.降序，2.升序）", required = false, dataType = "true", paramType = "query") })
    @RequestMapping(value = "/getBusiness.do", method = RequestMethod.GET)
    public RestResult getBusinessMuItDim(@Valid CompanyBusinessInfoQueryParam params) {
        String district = params.getDistrict();
        PermissionUtil.checkPermission(district);
        return RestResult.ok(activeIndexService.getCompanyBusinessInfoList(params, getPageBounds()));
    }

    /**
     * 导出企业经营活动指数列表
     *
     * @return
     * @throws Exception 
     */
    @ApiOperation(value = "导出企业经营活动指数列表", httpMethod = "GET")
    @ApiImplicitParams({ @ApiImplicitParam(name = "district", value = "地区编码", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "companyState", value = "异常类型(0-正常企业，1-失联企业，2-已吊销未注销企业，4-严重违法企业)", required = true, dataType = "true", paramType = "query"),
            @ApiImplicitParam(name = "companyName", value = "公司名称", required = false, dataType = "true", paramType = "query"),
            @ApiImplicitParam(name = "primaryIndustry", value = "所属一级行业(A-农、林、牧、渔业 B-采矿业....)", required = false, dataType = "true", paramType = "query"),
            @ApiImplicitParam(name = "indexScoreFrom", value = "经营活动最小值", required = false, dataType = "true", paramType = "query"),
            @ApiImplicitParam(name = "indexScoreTo", value = "经营活动最大值", required = false, dataType = "true", paramType = "query") })
    @RequestMapping(value = "/download.do", method = RequestMethod.GET)
    public RestResult download(@Valid CompanyBusinessInfoQueryParam params) throws Exception {
        List<CompanyBusinessInfoVO> ds = activeIndexService.getCompanyBusinessInfoList(params);
        ExportExcelUtil.doExcel(SessionContext.getResponse(), ds, CompanyBusinessInfoVO.class);
        return RestResult.ok();
    }

    /**
     * 经营异常企业总数
     *
     * @return
     * @throws Exception 
     */
    @ApiOperation(value = "经营异常企业总数", httpMethod = "GET")
    @ApiImplicitParams({ @ApiImplicitParam(name = "district", value = "地区编码", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "companyState", value = "异常类型(0-正常企业，1-失联企业，2-已吊销未注销企业，4-严重违法企业)", required = true, dataType = "true", paramType = "query") })
    @RequestMapping(value = "/companyState/total.do", method = RequestMethod.GET)
    public RestResult getTotal(String district, Integer companyState) throws Exception {
        ValidateUtil.checkAllNull(CommonErrorCode.PARAM_NULL, district, companyState);
        PermissionUtil.checkPermission(district);
        Integer rs = activeIndexService.getCompanyCount(district, companyState);
        return RestResult.ok(rs);
    }

}
