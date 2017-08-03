/**  
 * All Rights Reserved @2016
 *
 */
package com.bbd.controller.reddata.addr;

import com.bbd.controller.AbstractController;
import com.bbd.service.reddata.addr.IAddressService;
import com.bbd.util.ValidateUtil;
import com.bean.RestResult;
import com.exception.CommonErrorCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 地址控制器.
 * 
 * @author zhanghui
 * @version $Id: AddressController.java, v 0.1 2016年12月13日 上午10:06:26 zhanghui Exp $
 */
@RestController
@RequestMapping("/addr")
@Api(description = "地址服务类接口")
public class AddressController extends AbstractController {

    @Resource
    /** 地址服务类 */
    private IAddressService addressService;

    /**
     * 获取省.
     */
    @ApiOperation(value = "获取一个省,根据code", httpMethod = "GET")
    @ApiImplicitParam(value = "省编码", name = "code", paramType = "query", defaultValue = "52")
    @RequestMapping(value = "/getProvinceByCode.do", method = RequestMethod.GET)
    public RestResult getProvinceByCode(int code) {
        ValidateUtil.checkNull(code, CommonErrorCode.PARAM_NULL);
        return RestResult.ok(addressService.getProvinceByCode(code));
    }

    /**
     * 获取市.
     */
    @ApiOperation(value = "获取一个市,根据code", httpMethod = "GET")
    @ApiImplicitParam(value = "市编码", name = "code", paramType = "query", defaultValue = "5201")
    @RequestMapping(value = "/getCityByCode.do", method = RequestMethod.GET)
    public RestResult getCityByCode(int code) {
        ValidateUtil.checkNull(code, CommonErrorCode.PARAM_NULL);
        return RestResult.ok(addressService.getCityByCode(code));
    }

    /**
     * 获取区.
     */
    @ApiOperation(value = "获取一个区,根据code", httpMethod = "GET")
    @ApiImplicitParam(value = "区编码", name = "code", paramType = "query", defaultValue = "520101")
    @RequestMapping(value = "/getDistrictByCode.do", method = RequestMethod.GET)
    public RestResult getDistrictByCode(int code) {
        ValidateUtil.checkNull(code, CommonErrorCode.PARAM_NULL);
        return RestResult.ok(addressService.getDistrictByCode(code));
    }

    /**
     * 获取所有的省.
     */
    @ApiOperation(value = "获取所有的省", httpMethod = "GET")
    @RequestMapping(value = "/getAllProvinces.do", method = RequestMethod.GET)
    public RestResult getAllProvinces() {
        return RestResult.ok(addressService.getAllProvinces());
    }

    /**
     * 获取省下面的市.
     */
    @ApiOperation(value = "获取所有省下面的市", httpMethod = "GET")
    @RequestMapping(value = "/getCitysByProvince.do", method = RequestMethod.GET)
    @ApiImplicitParam(value = "省code", paramType = "query", name = "code", example = "52")
    public RestResult getCitysByProvince(int code) {
        ValidateUtil.checkNull(code, CommonErrorCode.PARAM_NULL);
        return RestResult.ok(addressService.getCitysByProvince(code));
    }

    /**
     * 获取省下面的市.
     */
    @ApiOperation(value = "获取所有市下面的区", httpMethod = "GET")
    @RequestMapping(value = "/getDistrictsByCity.do", method = RequestMethod.GET)
    @ApiImplicitParam(value = "市code", paramType = "query", name = "code", example = "5201")
    public RestResult getDistrictsByCity(int code) {
        ValidateUtil.checkNull(code, CommonErrorCode.PARAM_NULL);
        return RestResult.ok(addressService.getDistrictsByCity(code));
    }

    /***
     * 创建用户时,用户可以选择的省市区列表
     */
    @ApiOperation(value = "获取添加用户的地址选择器", httpMethod = "GET")
    @RequestMapping(value = "/getCreateUserAddress.do", method = RequestMethod.GET)
    public RestResult getCreateUserAddress() {
        return RestResult.ok(addressService.getCreateUserAddress());
    }
}
