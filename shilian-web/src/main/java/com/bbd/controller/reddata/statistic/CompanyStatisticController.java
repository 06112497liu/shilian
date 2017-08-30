/**
 * BBD Service Inc
 * All Rights Reserved @2016
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
 * 企业统计
 * @author tjwang
 * @version $Id: CompanyStatisticController.java, v 0.1 2017/6/1 0001 14:40 tjwang Exp $
 */
@RestController
@RequestMapping("/statistic/company")
@Api(description = "企业信息统计")
public class CompanyStatisticController extends AbstractController {

    @Resource
    private ICompanyStatisticsService companyStatisticsService;

    /**
     * 当前信息挖掘总数和数据更新时间.
     * @return
     */
    @ApiOperation(value = "当前信息挖掘总数和数据更新时间", httpMethod = "GET")
    @RequestMapping(value = "/datas/total.do", method = RequestMethod.GET)
    public RestResult getCompanyDataCountInfo() {
        return RestResult.ok((companyStatisticsService.getCompanyDataCountInfo()));
    }

    /**
     * 企业总量
     * @return
     */
    @ApiOperation(value = "根据区域查询企业总量", httpMethod = "GET")
    @ApiImplicitParams({ @ApiImplicitParam(value = "区域编码", name = "district", required = false, dataType = "true", paramType = "query") })
    @RequestMapping(value = "/total.do", method = RequestMethod.GET)
    public RestResult getCompanyTotalCount(String district) {
        if (StringUtils.isBlank(district)) {
            district = "5201";
        }
        // 企业总数量（包含吊销和52019999的企业）
        Integer companyCount = companyStatisticsService.getCompanyTotalCount(district);
        return RestResult.ok(companyCount);
    }

    /**
     * 累计年报和本月年报数量统计
     * @return
     */
    @ApiOperation(value = "累计年报和本月年报统计", httpMethod = "GET")
    @ApiImplicitParams({ @ApiImplicitParam(value = "区域编码", name = "district", required = true, dataType = "true", paramType = "query") })
    @RequestMapping(value = "/district/anual/total.do", method = RequestMethod.GET)
    public RestResult getAnnualedCurrentMonthCount(String district) {
        // 验证年份和区域是否为null
        ValidateUtil.checkAllNull(CommonErrorCode.PARAM_NULL, district);
        DateTime date = new DateTime();
        // 本月年报数量
        Integer monthAnnualed = companyStatisticsService.getAnnualedCurrentMonthCount(date.getYear(), date.getMonthOfYear(), district);
        // 累计年报数量
        Integer annualed = companyStatisticsService.getAnnualedCount(district);
        Map<String, Object> map = Maps.newHashMap();
        map.put("annualed", annualed);
        map.put("monthAnnualed", monthAnnualed);
        return RestResult.ok(map);
    }

    /**
     * 贵阳市异常企业数量统计
     * @return
     */
    @ApiOperation(value = "贵阳市异常企业数量统计", httpMethod = "GET")
    @RequestMapping(value = "/abnormal/total.do", method = RequestMethod.GET)
    public RestResult getAbnormalCompanyTotalCount() {
        String district = "5201";
        // 贵阳市经营异常企业数量
        Integer abnormalCount = companyStatisticsService.getAbnormalCount(district);
        // 贵阳市企业总数量
        Integer companyCount = companyStatisticsService.getCompanyTotalCount(district);

        Map<String, Object> map = Maps.newHashMap();
        map.put("abnormal", abnormalCount);
        map.put("total", companyCount);
        map.put("percent", PercentUtil.calcIntPercent(companyCount, abnormalCount));

        return RestResult.ok(map);
    }

    /**
     * 贵阳市年报企业数量统计
     * @return
     */
    @ApiOperation(value = "贵阳市年报企业数量统计", httpMethod = "GET")
    @RequestMapping(value = "/anual/total.do", method = RequestMethod.GET)
    public RestResult getAnnualedCompanyTotalCount() {
        String district = "5201";
        // 已年报企业数量
        Integer haveAnnualCount = companyStatisticsService.getAnnualedCount(district);
        // 应年报企业数量
        Integer shouldAnnualCount = companyStatisticsService.getAnnualCompanyCount(district);

        Map<String, Object> map = Maps.newHashMap();
        map.put("annualed", haveAnnualCount);
        map.put("total", shouldAnnualCount);
        map.put("percent", PercentUtil.calcIntPercent(shouldAnnualCount, haveAnnualCount));

        return RestResult.ok(map);
    }

    /**
     * 贵阳市已年报企业区域分布
     * @return
     */
    @ApiOperation(value = "贵阳市已年报企业区域分布", httpMethod = "GET")
    @ApiImplicitParam(name = "district", value = "区域编码", dataType = "Integer", paramType = "query", required = true)
    @RequestMapping(value = "/area/distribute.do", method = RequestMethod.GET)
    public RestResult getAnnualedCompanyDistribute(String district) {
        if (StringUtils.isBlank(district)) {
            district = "5201";
        }
        List<CompanyAddrStaticInfo> result = companyStatisticsService.getAnnualedCompanyDistribute(district);
        Collections.sort(result, new Comparator<CompanyAddrStaticInfo>() {
            @Override
            public int compare(CompanyAddrStaticInfo o1, CompanyAddrStaticInfo o2) {
                String value1 = o1.getPercent().replace("%", "");
                String value2 = o2.getPercent().replace("%", "");
                Double d1 = Double.parseDouble(value1);
                Double d2 = Double.parseDouble(value2);
                return d2.compareTo(d1);
            }
        });
        return RestResult.ok(result);
    }

    /**
     * 未年报企业一级行业分布
     * @return
     */
    @ApiOperation(value = "未年报企业一级行业分布", httpMethod = "GET")
    @ApiImplicitParam(name = "district", value = "区域编码", dataType = "Integer", paramType = "query", required = true)
    @RequestMapping(value = "/industry/distribute.do", method = RequestMethod.GET)
    public RestResult getUnannualIndustryDistribute(String district) {
        // 验证区域代码是否为null
        ValidateUtil.checkNull(district, CommonErrorCode.PARAM_NULL);
        PermissionUtil.checkPermission(district);

        List<NameValueNodeInfo> result = companyStatisticsService.getUnannualIndustryDistribute(district);
        return RestResult.ok(result);
    }

    /**
     * 未年报企业类型分布
     * @return
     */
    @ApiOperation(value = "未年报企业类型分布", httpMethod = "GET")
    @ApiImplicitParam(name = "district", value = "区域编码", dataType = "Integer", paramType = "query", required = true)
    @RequestMapping(value = "/property/distribute.do", method = RequestMethod.GET)
    public RestResult getUnannualPropertyDistribute(String district) {
        // 验证区域代码是否为null
        ValidateUtil.checkNull(district, CommonErrorCode.PARAM_NULL);
        PermissionUtil.checkPermission(district);

        List<NameValueNodeInfo> result = companyStatisticsService.getUnannualPropertyDistribute(district);
        return RestResult.ok(result);
    }

}
