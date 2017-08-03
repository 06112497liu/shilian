/** 
 * BBD Service Inc 
 * All Rights Reserved @2017 
 */
package com.bbd.controller.reddata.lost;

import com.bbd.controller.AbstractController;
import com.bbd.controller.job.excel.LostCompanyListVo;
import com.bbd.controller.param.LostCompanyQueryParam;
import com.bbd.service.reddata.statistics.ILostCompanyStatisticsService;
import com.bbd.util.ValidateUtil;
import com.bbd.utils.ExportExcelUtil;
import com.bbd.utils.SessionContext;
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
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/** 
 * 失联企业分析页面
 * @author liuweibo 
 * @version $Id: LostCompanyInfoController.java, v 0.1 2017年5月5日 下午2:21:04 liuweibo Exp $ 
 */
@RestController
@RequestMapping("/lostCompany")
@Api(description = "失联企业分析")
public class LostCompanyStatisticsController extends AbstractController {

    @Resource
    private ILostCompanyStatisticsService lostCompanyStatisticsService;

    /**
     * 多维度查询失联企业信息
     * @return
     */
    @ApiOperation(value = "多维度查询失联企业信息", httpMethod = "GET")
    @ApiImplicitParams({ @ApiImplicitParam(name = "page", value = "第几页", required = false, dataType = "true", paramType = "query"),
            @ApiImplicitParam(name = "companyName", value = "企业名称", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "limit", value = "每页数量", required = false, dataType = "true", paramType = "query"),
            @ApiImplicitParam(name = "district", value = "区域编码", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "primaryIndustry", value = "一级行业", required = false, dataType = "true", paramType = "query"),
            @ApiImplicitParam(name = "companyProperty", value = "失联企业类型", required = false, dataType = "true", paramType = "query"),
            @ApiImplicitParam(name = "gmtCheckInFrom", value = "失联登记开始时间", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "gmtCheckInTo", value = "失联登记结束时间", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "gmtCompanyRegisterFrom", value = "企业注册开始时间", required = false, dataType = "true", paramType = "query"),
            @ApiImplicitParam(name = "gmtCompanyRegisterTo", value = "企业注册结束时间", required = false, dataType = "true", paramType = "query") })
    @RequestMapping(value = "/query.do", method = RequestMethod.GET)
    public RestResult queryLostCompany(LostCompanyQueryParam query) {
        PageList<LostCompanyListVo> result = lostCompanyStatisticsService.queryLostCompany(query, getPageBounds());
        return RestResult.ok(result);
    }

    /**
     * 一键导出失联企业信息列表
     * @return
     * @throws Exception 
     */
    @ApiOperation(value = "一键导出失联企业信息列表", httpMethod = "GET")
    @ApiImplicitParams({ @ApiImplicitParam(name = "companyName", value = "企业名称", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "district", value = "区域编码", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "primaryIndustry", value = "一级行业", required = false, dataType = "true", paramType = "query"),
            @ApiImplicitParam(name = "companyProperty", value = "失联企业类型", required = false, dataType = "true", paramType = "query"),
            @ApiImplicitParam(name = "gmtCheckInFrom", value = "失联登记开始时间", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "gmtCheckInTo", value = "失联登记结束时间", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "gmtCompanyRegisterFrom", value = "企业注册开始时间", required = false, dataType = "true", paramType = "query"),
            @ApiImplicitParam(name = "gmtCompanyRegisterTo", value = "企业注册结束时间", required = false, dataType = "true", paramType = "query") })
    @RequestMapping(value = "/download.do", method = RequestMethod.GET)
    public RestResult downloadLostCompany(LostCompanyQueryParam query) throws Exception {
        List<LostCompanyListVo> rs = lostCompanyStatisticsService.queryLostCompany(query);
        ExportExcelUtil.doExcel(SessionContext.getResponse(), rs, LostCompanyListVo.class);
        return RestResult.ok();
    }

    /***
     * 生成word随机字下载符串.
     */
    @ApiOperation(value = "生成word随机下载字符串", httpMethod = "POST")
    @ApiImplicitParams({ @ApiImplicitParam(value = "区域编码", name = "areaCode", required = true, defaultValue = "5201", paramType = "query"),
            @ApiImplicitParam(value = "热力图", name = "hotImg", required = true, paramType = "query"), @ApiImplicitParam(value = "环形图", name = "companyTypeImg", required = true, paramType = "query"),
            @ApiImplicitParam(value = "柱状图", name = "industryImg", required = true, paramType = "query") })
    @RequestMapping(value = "/getReportUrl.do", method = RequestMethod.POST)
    public RestResult exportStatisticsWord(Integer areaCode, String hotImg, String companyTypeImg, String industryImg) {
        ValidateUtil.checkAllNull(CommonErrorCode.PARAM_NULL, areaCode, hotImg, companyTypeImg, industryImg);
        String result = lostCompanyStatisticsService.exportStatisticsWord(areaCode, hotImg, companyTypeImg, industryImg);
        return RestResult.ok(result);
    }

    /***
     * 下载报告.
     */
    @ApiOperation(value = "下载报告", httpMethod = "GET")
    @ApiImplicitParams({ @ApiImplicitParam(value = "下载文件字符串", name = "uid", paramType = "query") })
    @RequestMapping(value = "/downLoadReport.do", method = RequestMethod.GET)
    public void exportStatisticsWord(HttpServletResponse response, String uid) {
        lostCompanyStatisticsService.downLoadReport(response, uid);
    }

}
