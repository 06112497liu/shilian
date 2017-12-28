/** 
 * BBD Service Inc 
 * All Rights Reserved @2017 
 */
package com.bbd.controller.reddata.statistic;

import com.bbd.bean.statistics.CompanyAddrStaticInfo;
import com.bbd.bean.statistics.NameValueNodeInfo;
import com.bbd.controller.AbstractController;
import com.bbd.service.reddata.statistics.ICompanyStatisticsService;
import com.bbd.util.StringUtils;
import com.bbd.util.ValidateUtil;
import com.bbd.utils.PercentUtil;
import com.bbd.utils.PermissionUtil;
import com.bbd.utils.UserContext;
import com.bean.RestResult;
import com.exception.CommonErrorCode;
import com.google.common.collect.Maps;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.joda.time.DateTime;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/** 
 * 异常企业统计信息控制层
 *  
 * @author liuweibo 
 * @version $Id: AbnormalRemindStatisticsController.java, v 0.1 2017年6月13日 下午5:48:22 liuweibo Exp $ 
 */
@RestController
@RequestMapping("/company/abnormal/statistic")
@Api(description = "异常企业统计信息")
public class AbnormalRemindStatisticsController extends AbstractController {

    @Resource
    private ICompanyStatisticsService companyStatisticsService;

    /**
     * 异常企业数量统计 
     * @return               统一JSON数据
     */
    @ApiOperation(value = "异常企业数量统计信息", httpMethod = "GET")
    @ApiImplicitParams({ 
        @ApiImplicitParam(value = "区域编码", name = "district", dataType = "String", paramType = "query", required = false),
        @ApiImplicitParam(value = "异常类型（1-未年报 2-未公示 4-虚假信息 8-失联）", name = "abnormalState", dataType = "Integer", paramType = "query", required = true) })
    @RequestMapping(value = "/total/info.do", method = RequestMethod.GET)
    public RestResult getTotalInfo(String district, Integer abnormalState) {
        
        ValidateUtil.checkNull(abnormalState, CommonErrorCode.PARAM_NULL);
        Map<String, Object> map = Maps.newHashMap();
        
        if (StringUtils.isBlank(district)) {
            district = "5201";
        }
        // 异常企业数量
        Integer abnormalCount = companyStatisticsService.queryPartialAbnormalCount(abnormalState, district);
        // 企业总量
        Integer total = companyStatisticsService.getCompanyTotalCountWithOutOthers(district);
        Integer shouldAnnual = 0;
        // 如果查询的是有关年报的，要查询应年报企业总量
        if(abnormalState == 1) {
            shouldAnnual = companyStatisticsService.getAnnualCompanyCount(district);
            map.put("percent", PercentUtil.calcIntPercent(shouldAnnual, abnormalCount));
        } else {
            map.put("percent", PercentUtil.calcIntPercent(total, abnormalCount));
        }
        map.put("total", total);
        map.put("abnormal", abnormalCount);
        return RestResult.ok(map);
    }

    /**
     * 异常企业数量
     * @return               统一JSON数据
     */
    @ApiOperation(value = "异常企业数量", httpMethod = "GET")
    @ApiImplicitParams({ 
        @ApiImplicitParam(value = "区域编码", name = "district", dataType = "String", paramType = "query", required = true),
        @ApiImplicitParam(value = "异常类型（1-未年报 2-未公示 4-虚假信息 8-失联）", name = "abnormalState", dataType = "Integer", paramType = "query", required = true) 
    })
    @RequestMapping(value = "/total.do", method = RequestMethod.GET)
    public RestResult getTotal(Integer abnormalState, String district) {
        ValidateUtil.checkNull(abnormalState, CommonErrorCode.PARAM_NULL);
        // 异常企业数量
        String region = String.valueOf(UserContext.getQuery().getAddr());
        Integer abnormalCount = companyStatisticsService.queryPartialAbnormalCount(abnormalState, region);
        return RestResult.ok(abnormalCount);
    }

    /**
     * 异常企业区域分布
     * @return               统一JSON数据
     */
    @ApiOperation(value = "异常企业区域分布", httpMethod = "GET")
    @ApiImplicitParams({ 
        @ApiImplicitParam(value = "异常类型（1-未年报 2-未公示 4-虚假信息 8-失联）", name = "abnormalState", dataType = "Integer", paramType = "query", required = true) 
    })
    @RequestMapping(value = "/area/distribute.do", method = RequestMethod.GET)
    public RestResult getAreaDistribute(Integer abnormalState) {
        ValidateUtil.checkNull(abnormalState, CommonErrorCode.PARAM_NULL);
        List<CompanyAddrStaticInfo> result = companyStatisticsService.queryAbnormalCompanyDistribute(abnormalState);
        Collections.sort(result, (o1, o2) -> {
            String value1 = o1.getPercent().replace("%", "");
            String value2 = o2.getPercent().replace("%", "");
            Double d1 = Double.parseDouble(value1);
            Double d2 = Double.parseDouble(value2);
            return d2.compareTo(d1);
        });
        return RestResult.ok(result);
    }

    /**
     * 异常企业一级行业分布
     * @return               统一JSON数据
     */
    @ApiOperation(value = "异常企业一级行业分布", httpMethod = "GET")
    @ApiImplicitParams({ 
        @ApiImplicitParam(value = "异常类型（1-未年报 2-未公示 4-虚假信息 8-失联）", name = "abnormalState", dataType = "Integer", paramType = "query", required = true),
        @ApiImplicitParam(value = "区域编码", name = "district", dataType = "String", paramType = "query", required = true) 
    })
    @RequestMapping(value = "/industry/distribute.do", method = RequestMethod.GET)
    public RestResult getIndustryDistribute(Integer abnormalState, String district) {
        ValidateUtil.checkAllNull(CommonErrorCode.PARAM_NULL, abnormalState, district);
        PermissionUtil.checkPermission(district);
        List<NameValueNodeInfo> result = companyStatisticsService.queryAbnormalIndustryDistribute(abnormalState, district);
        return RestResult.ok(result);
    }

    /**
     * 异常企业性质分布
     * @return               统一JSON数据
     */
    @ApiOperation(value = "异常企业性质分布", httpMethod = "GET")
    @ApiImplicitParams({ @ApiImplicitParam(value = "异常类型（1-未年报 2-未公示 4-虚假信息 8-失联）", name = "abnormalState", dataType = "Integer", paramType = "query", required = true),
            @ApiImplicitParam(value = "区域编码", name = "district", dataType = "String", paramType = "query", required = true) })
    @RequestMapping(value = "/property/distribute.do", method = RequestMethod.GET)
    public RestResult getPropertyDistribute(Integer abnormalState, String district) {
        ValidateUtil.checkAllNull(CommonErrorCode.PARAM_NULL, abnormalState, district);
        PermissionUtil.checkPermission(district);
        List<NameValueNodeInfo> result = companyStatisticsService.queryAbnormalPropertyDistribute(abnormalState, district);
        return RestResult.ok(result);
    }

    /**
     * 当前累计移除异常企业的数量
     * @return               统一JSON数据
     */
    @ApiOperation(value = "当前累计移除异常企业的数量", httpMethod = "GET")
    @ApiImplicitParams({ @ApiImplicitParam(value = "异常类型（1-未年报 2-未公示 4-虚假信息 8-失联）", name = "abnormalState", dataType = "Integer", paramType = "query", required = true),
            @ApiImplicitParam(value = "区域编码", name = "district", dataType = "Integer", paramType = "query", required = true) })
    @RequestMapping(value = "/delete/year.do", method = RequestMethod.GET)
    public RestResult getDeleteCount(Integer abnormalState, String district) {
        ValidateUtil.checkAllNull(CommonErrorCode.PARAM_NULL, abnormalState, district);
        PermissionUtil.checkPermission(district);
        DateTime dateTime = new DateTime();
        Integer result = companyStatisticsService.queryAbnormalYearRemoveCount(abnormalState, dateTime.getYear(), district);
        return RestResult.ok(result);
    }

    /**
     * 本月移除异常企业数量
     * @return               统一JSON数据
     */
    @ApiOperation(value = "本月移除异常企业数量", httpMethod = "GET")
    @ApiImplicitParams({ @ApiImplicitParam(value = "异常类型（1-未年报 2-未公示 4-虚假信息 8-失联）", name = "abnormalState", dataType = "Integer", paramType = "query", required = true),
            @ApiImplicitParam(value = "区域编码", name = "district", dataType = "Integer", paramType = "query", required = true) })
    @RequestMapping(value = "/delete/month.do", method = RequestMethod.GET)
    public RestResult getMothDeleteCount(Integer abnormalState, String district) {
        ValidateUtil.checkAllNull(CommonErrorCode.PARAM_NULL, abnormalState, district);
        PermissionUtil.checkPermission(district);
        DateTime dateTime = new DateTime();
        Integer result = companyStatisticsService.queryAbnormalMonthRemoveCount(abnormalState, dateTime.getYear(), dateTime.getMonthOfYear(), district);
        return RestResult.ok(result);
    }

    /**
     * 本月新增异常企业数量
     * @return               统一JSON数据
     */
    @ApiOperation(value = "本月新增异常企业数量", httpMethod = "GET")
    @ApiImplicitParams({ @ApiImplicitParam(value = "异常类型（1-未年报 2-未公示 4-虚假信息 8-失联）", name = "abnormalState", dataType = "Integer", paramType = "query", required = true),
            @ApiImplicitParam(value = "区域编码", name = "district", dataType = "Integer", paramType = "query", required = true) })
    @RequestMapping(value = "/add/month.do", method = RequestMethod.GET)
    public RestResult getMothAddCount(Integer abnormalState, String district) {
        ValidateUtil.checkAllNull(CommonErrorCode.PARAM_NULL, abnormalState, district);
        PermissionUtil.checkPermission(district);
        DateTime dateTime = new DateTime();
        Integer result = companyStatisticsService.queryAbnormalMonthAddCount(abnormalState, dateTime.getYear(), dateTime.getMonthOfYear(), district);
        return RestResult.ok(result);
    }

}
