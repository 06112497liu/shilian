/** 
 * BBD Service Inc 
 * All Rights Reserved @2017 
 */
package com.bbd.controller.reddata.company;

import com.bbd.bean.company.AffiliatedCompanyVo;
import com.bbd.bean.company.LineVo;
import com.bbd.controller.AbstractController;
import com.bbd.service.reddata.company.ICompanyAffiliatedService;
import com.bbd.util.ValidateUtil;
import com.bbd.utils.ExportExcelUtil;
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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/** 
 * 企业关联方信息接口
 * @author liuweibo 
 * @version $Id: CompanyAffiliatedController.java, v 0.1 2017年5月5日 下午1:10:25 liuweibo Exp $ 
 */
@Api(description = "关联方信息")
@RestController
@RequestMapping("/company/Affiliated/")
public class CompanyAffiliatedController extends AbstractController {

    /**关联方信息接口*/
    @Resource
    private ICompanyAffiliatedService companyAffiliatedService;

    /**
     * 获取企业关联方信息
     * @return
     */
    @ApiOperation(value = "获取企业关联方信息", httpMethod = "GET")
    @ApiImplicitParams({ @ApiImplicitParam(name = "level", value = "关联等级 一度  二度", required = true, dataType = "true", paramType = "query", defaultValue = "2"),
            @ApiImplicitParam(name = "companyName", value = "主企业名称", required = true, dataType = "true", paramType = "query") })
    @RequestMapping(value = "/getAffiliatedCompany.do", method = RequestMethod.GET)
    public RestResult getAffiliatedCompany(Long level, String companyName) {

        ValidateUtil.checkNull(companyName, CommonErrorCode.PARAM_NULL);
        ValidateUtil.checkNull(level, CommonErrorCode.PARAM_NULL);
        AffiliatedCompanyVo affiliatedCompany = new AffiliatedCompanyVo();
        affiliatedCompany = companyAffiliatedService.getCompanyAffiliated(level, companyName);

        return RestResult.ok(affiliatedCompany);

    }

    /**
     * 获取企业关联方联系信息
     * @return
     */
    @ApiOperation(value = "获取关联方联系信息", httpMethod = "GET")
    @ApiImplicitParams({ @ApiImplicitParam(name = "companyName", value = "企业名称", required = true, dataType = "true", paramType = "query") })
    @RequestMapping(value = "/getContactMessage.do", method = RequestMethod.GET)
    public RestResult getContactMessage(String companyName) {
        ValidateUtil.checkNull(companyName, CommonErrorCode.PARAM_NULL);
        Map<String, String> map = companyAffiliatedService.getContactMessage(companyName);
        return RestResult.ok(map);

    }

    /**
     * 一键下载获取企业关联方信息
     * @return
     * @throws Exception 
     */
    @ApiOperation(value = "一键下载获取企业关联方信息", httpMethod = "GET")
    @ApiImplicitParams({ @ApiImplicitParam(name = "level", value = "关联等级 一度  二度", required = true, dataType = "true", paramType = "query", defaultValue = "2"),
            @ApiImplicitParam(name = "companyName", value = "主企业名称", required = true, dataType = "true", paramType = "query") })
    @RequestMapping(value = "/download.do", method = RequestMethod.GET)
    public void download(Long level, String companyName, HttpServletRequest request, HttpServletResponse response) throws Exception {

        ValidateUtil.checkNull(companyName, CommonErrorCode.PARAM_NULL);
        ValidateUtil.checkNull(level, CommonErrorCode.PARAM_NULL);

        List<LineVo> linevos = companyAffiliatedService.findLineVo(level, companyName);
        ExportExcelUtil.doExcel(response, linevos, LineVo.class);

    }
}
