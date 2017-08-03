/**
 * BBD Service Inc
 * All Rights Reserved @2017
 */
package com.bbd.controller.reddata.company;

import com.bbd.bean.company.CompanyInfoEsVO;
import com.bbd.bean.company.CompanyInfoVo;
import com.bbd.controller.AbstractController;
import com.bbd.pagin.Pagination;
import com.bbd.service.reddata.activity.IActivityIndexService;
import com.bbd.service.reddata.company.ICompanyService;
import com.bbd.util.DateUtil;
import com.bbd.util.ValidateUtil;
import com.bean.RestResult;
import com.exception.ApplicationException;
import com.exception.CommonErrorCode;
import com.mybatis.domain.PageList;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.joda.time.DateTime;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

@RestController
@RequestMapping("/companyInfo")
@Api(description = "企业信息挖掘搜索页")
public class CompanyInfoController extends AbstractController {

    /**企业service层服务接口*/
    @Resource
    private ICompanyService       companyService;

    @Resource
    private IActivityIndexService activeIndexService;

    /**
     * 按企业名称全模糊查询企业列表 
     * 
     */
    @ApiOperation(value = "根据企业名称模糊查询企业信息", httpMethod = "GET")
    @ApiImplicitParams({ @ApiImplicitParam(name = "page", value = "第几页", required = false, dataType = "true", paramType = "query"),
            @ApiImplicitParam(name = "limit", value = "每页数量", required = false, dataType = "true", paramType = "query"),
            @ApiImplicitParam(name = "companyName", value = "企业名称", required = true, dataType = "String", paramType = "query") })
    @RequestMapping(value = "/getPage.do", method = RequestMethod.GET)
    public RestResult getPage(String companyName, Pagination pageable) {
        ValidateUtil.checkNull(companyName, CommonErrorCode.PARAM_NULL);
        PageList<CompanyInfoEsVO> result = companyService.findPage(companyName, getPageBounds());
        return RestResult.ok(result);
    }

    /**
     * 根据企业nbxh获取企业的异常类型
     */
    @ApiOperation(value = "根据企业的nbxh获取企业的异常类型", httpMethod = "GET")
    @ApiImplicitParam(value = "根据企业的nbxh查询企业的异常类型(1-未年报 2-未公示 3-虚假信息 4-失联)", name = "nbxh", required = true, paramType = "query")
    @RequestMapping(value = "/getAbnormalTypeBynbxh.do", method = RequestMethod.GET)
    public RestResult getAbnormalTypeBynbxh(String nbxh) {
        ValidateUtil.checkNull(nbxh, CommonErrorCode.PARAM_NULL);
        return RestResult.ok(companyService.getAbnormalTypeBynbxh(nbxh));
    }

    /**
     * 根据企业nbxh查询企业经营活动项目
     * @return
     */
    @ApiOperation(value = "根据企业nbxh查询企业经营活动项目", httpMethod = "GET")
    @ApiImplicitParams({ @ApiImplicitParam(value = "企业nbxh", name = "nbxh", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(value = "日期,注意限制日期最大为上个月", name = "date", required = true, paramType = "query", dataType = "true") })
    @RequestMapping(value = "/getBusinessRecordValue.do", method = RequestMethod.GET)
    public RestResult getBusinessRecordValue(String nbxh, String date) {
        ValidateUtil.checkAllNull(CommonErrorCode.PARAM_NULL, nbxh, date);
        Date d = DateUtil.parseDate(date, "yyyy-MM");
        if (d == null || DateUtil.monthCompare(d, new Date()) >= 0) { //日期为本月的话，抛出异常
            throw new ApplicationException(CommonErrorCode.PARAM_ERROR);
        }
        String businessRecord = companyService.getBusinessRecordValue(nbxh, date);
        return RestResult.ok(businessRecord);

    }

    /**
     * 根据企业nbxh和日期查询企业经营活动指数
     * @param nbxh
     * @param date
     * @return
     */
    @ApiOperation(value = "获取企业某月的经营活动指数", httpMethod = "GET")
    @ApiImplicitParams({ @ApiImplicitParam(value = "企业nbxh", name = "nbxh", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(value = "日期,注意限制日期最大为上个月", name = "date", required = true, paramType = "query", dataType = "true") })
    @RequestMapping(value = "/getCompanyActivityExp.do", method = RequestMethod.GET)
    public RestResult getCompanyActivityExp(String nbxh, String date) {
        ValidateUtil.checkNull(nbxh, CommonErrorCode.PARAM_NULL);
        Date d = DateUtil.parseDate(date, "yyyy-MM");
        if (d == null || DateUtil.monthCompare(d, new Date()) >= 0) { //日期为本月的话，抛出异常
            throw new ApplicationException(CommonErrorCode.PARAM_ERROR);
        }
        DateTime dateTime = new DateTime(d);
        int year = dateTime.getYear();
        int month = dateTime.getMonthOfYear();

        Double exp = activeIndexService.getCompanyMonthActivityExp(nbxh, year, month);
        return RestResult.ok(exp);
    }

    /**
     * 
     * 根据企业nbxh查询企业工商基本信息
     * @param nbxh 企业nbxh
     * @return Result<CompanyInfoVo> 企业工商信息
     */
    @ApiOperation(value = "根据企业nbxh查询企业工商基本信息", httpMethod = "GET")
    @ApiImplicitParams({ @ApiImplicitParam(name = "nbxh", value = "企业nbxh", required = true, dataType = "true", paramType = "query") })
    @RequestMapping(value = "/getCompanyInfo.do", method = RequestMethod.GET)
    public RestResult get(String nbxh) {
        ValidateUtil.checkNull(nbxh, CommonErrorCode.PARAM_NULL);
        CompanyInfoVo companyInfoVo = companyService.getByNbxh(nbxh);
        return RestResult.ok(companyInfoVo);
    }

    /**
     * 获取企业的类型（1 民营企业 2 国有企业 3 外资企业 ），供下拉列表使用
     */
    @ApiOperation(value = "获取企业的类型（1 民营企业 2 国有企业 3 外资企业 ）下拉列表", httpMethod = "GET")
    @RequestMapping(value = "/getCompanyTypes.do", method = RequestMethod.GET)
    public RestResult getCompanyTypes() {
        return RestResult.ok(companyService.getCompanyTypes());
    }

    /**
     * 获取企业经营活动项目，供下拉列表使用
     */
    @ApiOperation(value = "获取企业经营活动下拉列表", httpMethod = "GET")
    @RequestMapping(value = "/getActivityType.do", method = RequestMethod.GET)
    public RestResult getBusinessTypes() {
        return RestResult.ok(companyService.getBusinessTypes());
    }

    /**
     * 获取第一产业下拉列表
     */
    @ApiOperation(value = "获取第一产业下拉列表", httpMethod = "GET")
    @RequestMapping(value = "/getPrimaryIndustry.do", method = RequestMethod.GET)
    public RestResult getPrimaryIndustry() {
        return RestResult.ok(companyService.getPrimaryIndustry());
    }

}
