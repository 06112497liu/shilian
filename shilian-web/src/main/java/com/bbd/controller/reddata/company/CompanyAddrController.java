/**
 * BBD Service Inc
 * All Rights Reserved @2017
 */
package com.bbd.controller.reddata.company;

import com.bbd.bean.LatLng;
import com.bbd.controller.AbstractController;
import com.bbd.controller.param.CompanyAddrInfoVO;
import com.bbd.domain.AnnualReportInfo;
import com.bbd.domain.EnterpriseInfo;
import com.bbd.service.reddata.addr.IAddressService;
import com.bbd.service.reddata.company.ICompanyService;
import com.bbd.util.ValidateUtil;
import com.bean.RestResult;
import com.exception.CommonErrorCode;
import com.google.common.collect.Maps;
import com.utils.BeanMapperUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 企业联系信息、地址信息接口
 *
 * @author liuweibo
 * @version $Id: CompanyAddrController.java, v 0.1 2017年5月5日 下午12:51:20 liuweibo Exp $
 */

@Api(description = "企业地址信息")
@RestController("CompanyAddrController")
@RequestMapping("/companyInfo/addr/")
public class CompanyAddrController extends AbstractController {

    /**
     * 企业联系方式服务接口
     */
    @Resource
    private ICompanyService companyService;

    @Resource
    private IAddressService addressService;

    /**
     * 根据企业nbxh查询企业登记、年报联系方式
     *
     * @return
     */
    @ApiOperation(value = "根据企业nbxh查询企业登记、年报联系方式", httpMethod = "GET")
    @ApiImplicitParam(name = "nbxh", value = "企业nbxh（内部序号）", required = true, dataType = "true", paramType = "query")
    @RequestMapping(value = "/djnb/contact.do", method = RequestMethod.GET)
    public RestResult getAddrForZPZB(String nbxh) {

        ValidateUtil.checkNull(nbxh, CommonErrorCode.PARAM_NULL);

        Map<String, CompanyAddrInfoVO> result = Maps.newHashMap();

        // 登记、年报地址
        EnterpriseInfo register = companyService.getCompanyInfoByNbxh(nbxh);
        AnnualReportInfo annul = companyService.getAnnualReportInfoByNbxh(nbxh);
        CompanyAddrInfoVO registerInfo = BeanMapperUtil.map(register, CompanyAddrInfoVO.class);
        CompanyAddrInfoVO annualInfo = BeanMapperUtil.map(annul, CompanyAddrInfoVO.class);

        buildAnnualInfo(annualInfo);

        result.put("base", registerInfo);
        result.put("annual", annualInfo);

        return RestResult.ok(result);
    }

    /**
     * 根据企业nbxh查询企业招聘、招标联系方式
     *
     * @return
     */
    @ApiOperation(value = "根据企业nbxh查询企业招聘、招标联系方式", httpMethod = "GET")
    @ApiImplicitParam(name = "nbxh", value = "企业nbxh（内部序号）", required = true, dataType = "true", paramType = "query")
    @RequestMapping(value = "/zpzb/contact.do", method = RequestMethod.GET)
    public RestResult getRegisterAndAnnual(String nbxh) {

        ValidateUtil.checkNull(nbxh, CommonErrorCode.PARAM_NULL);

        Map<String, CompanyAddrInfoVO> result = Maps.newHashMap();

        // 招聘、招标地址
        Map<String, CompanyAddrInfoVO> addrMap = companyService.getCompanyBBDAddrInfo(nbxh);
        result.putAll(addrMap);
        return RestResult.ok(result);
    }

    private void buildAnnualInfo(CompanyAddrInfoVO info) {
        String addr = info.getAddr();
        if (StringUtils.isBlank(addr)) {
            return;
        }
        LatLng ll = addressService.getAddressLatLng(addr);
        info.setLongitude(ll.lng);
        info.setLatitude(ll.lat);
    }

    /**
     * 获取贵阳市企业地址经纬度散点图
     *
     * @return
     */
    @ApiOperation(value = "获取贵阳市企业地址经纬度散点图", httpMethod = "GET")
    @ApiImplicitParams(value = { @ApiImplicitParam(value = "企业nbxh", name = "nbxh", required = false, paramType = "query", dataType = "String") })
    @RequestMapping(value = "/getAddressPointInfo.do", method = RequestMethod.GET)
    public RestResult getAddressPointInfo(String nbxh) {
        return RestResult.ok(companyService.getAddressPointInfo(nbxh));
    }

}
