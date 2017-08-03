/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.controller.reddata.statistic;

import com.bbd.bean.statistics.TimelineStatisticInfo;
import com.bbd.controller.AbstractController;
import com.bbd.controller.param.CompanyRemindDailyCountVO;
import com.bbd.controller.param.CompanyRemindMonthlyCountVO;
import com.bbd.domain.CompanyRemindDailyCountInfo;
import com.bbd.domain.CompanyRemindMonthlyCountInfo;
import com.bbd.service.reddata.remind.ICompanyRemindService;
import com.bbd.util.ValidateUtil;
import com.bbd.utils.PermissionUtil;
import com.bbd.utils.TransDataUtils;
import com.bean.RestResult;
import com.exception.CommonErrorCode;
import com.google.common.collect.Lists;
import com.utils.BeanMapperUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.joda.time.DateTime;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 企业提示信息统计
 * @author tjwang
 * @version $Id: CompanyStatisticController.java, v 0.1 2017/6/1 0001 14:40 tjwang Exp $
 */
@RestController
@RequestMapping("/remind/statistic")
@Api(description = "企业提示信息统计")
public class CompanyRemindStatisticController extends AbstractController {

    @Resource
    private ICompanyRemindService remindStatisticService;

    /**
     * 当前累计提示
     * @return
     */
    @ApiOperation(value = "当前累计提示", httpMethod = "GET")
    @ApiImplicitParams({ @ApiImplicitParam(value = "类型（1.年报， 2.失联， 3.未年报， 4.未公示， 5.虚假信息）", name = "type", required = true, dataType = "true", paramType = "query"),
            @ApiImplicitParam(value = "区域编码", name = "district", required = true, dataType = "true", paramType = "query") })
    @RequestMapping(value = "/count.do", method = RequestMethod.GET)
    public RestResult getYearRemindCount(Integer type, String district) {
        // 验证参数是否为null
        ValidateUtil.checkAllNull(CommonErrorCode.PARAM_NULL, type, district);
        PermissionUtil.checkPermission(district);
        DateTime dateTime = new DateTime();
        Integer result = remindStatisticService.getYearRemindCount(dateTime.getYear(), type, district);
        return RestResult.ok(result);
    }

    /**
     * 本月提示
     * @return
     */
    @ApiOperation(value = "本月提示", httpMethod = "GET")
    @ApiImplicitParams({ @ApiImplicitParam(value = "区域编码", name = "district", required = true, dataType = "true", paramType = "query"),
            @ApiImplicitParam(value = "类型（1.年报， 2.失联， 3.未年报， 4.未公示， 5.虚假信息）", name = "type", required = true, dataType = "true", paramType = "query") })
    @RequestMapping(value = "/month/count.do", method = RequestMethod.GET)
    public RestResult getMonthReindCount(Integer type, String district) {
        // 验证参数是否为null
        ValidateUtil.checkAllNull(CommonErrorCode.PARAM_NULL, type, district);
        PermissionUtil.checkPermission(district);
        DateTime date = new DateTime();
        Integer result = remindStatisticService.getMonthReindCount(date.getYear(), date.getMonthOfYear(), type, district);
        return RestResult.ok(result);
    }

    /**
     * 提示时间轴统计（日）
     * @return
     */
    @ApiOperation(value = "提示时间轴统计（日）", httpMethod = "GET")
    @ApiImplicitParams({ @ApiImplicitParam(value = "区域编码", name = "district", required = true, dataType = "true", paramType = "query"),
            @ApiImplicitParam(value = "类型（1.年报， 2.失联， 3.未年报， 4.未公示， 5.虚假信息）", name = "type", required = true, dataType = "true", paramType = "query") })
    @RequestMapping(value = "/timeline/day.do", method = RequestMethod.GET)
    public RestResult getDailyCountInfos(Integer type, String district) {

        // 验证是否为null
        ValidateUtil.checkAllNull(CommonErrorCode.PARAM_NULL, type, district);
        PermissionUtil.checkPermission(district);
        DateTime dateTime = new DateTime();
        List<CompanyRemindDailyCountInfo> datas = remindStatisticService.queryDailyCountInfos(dateTime.getYear(), type, district);
        List<CompanyRemindDailyCountInfo> fillDays = TransDataUtils.fillDayData(datas);
        List<CompanyRemindDailyCountVO> temp = Lists.newArrayList();
        for (CompanyRemindDailyCountInfo data : fillDays) {
            CompanyRemindDailyCountVO vo = new CompanyRemindDailyCountVO();
            vo.setCount(data.getCount());
            int day = data.getDay();
            int y = data.getYear();
            DateTime time = new DateTime(y, 1, 1, 0, 0, 0);
            time = time.plusDays(day - 1);
            vo.setDay(time.getDayOfMonth());
            vo.setMonth(time.getMonthOfYear());
            vo.setYear(dateTime.getYear());
            vo.setType(data.getType());
            temp.add(vo);
        }

        TimelineStatisticInfo result = TransDataUtils.transDailyCountInfo(temp);
        return RestResult.ok(result);
    }

    /**
     * 提示时间轴统计（月）
     * @return
     */
    @ApiOperation(value = "提示时间轴统计（月）", httpMethod = "GET")
    @ApiImplicitParams({ @ApiImplicitParam(value = "区域编码", name = "district", required = true, dataType = "true", paramType = "query"),
            @ApiImplicitParam(value = "类型（1.年报， 2.失联， 3.未年报， 4.未公示， 5.虚假信息）", name = "type", required = true, dataType = "true", paramType = "query") })
    @RequestMapping(value = "/timeline/month.do", method = RequestMethod.GET)
    public RestResult getMonthlyCountInfos(Integer type, String district) {

        // 验证参数是否为null
        ValidateUtil.checkAllNull(CommonErrorCode.PARAM_NULL, type, district);
        PermissionUtil.checkPermission(district);
        DateTime dateTime = new DateTime();
        List<CompanyRemindMonthlyCountInfo> datas = remindStatisticService.queryMonthlyCountInfos(dateTime.getYear(), type, district);
        List<CompanyRemindMonthlyCountInfo> fillDats = TransDataUtils.fillMonthData(datas);
        List<CompanyRemindMonthlyCountVO> temp = BeanMapperUtil.mapList(fillDats, CompanyRemindMonthlyCountVO.class);

        TimelineStatisticInfo result = TransDataUtils.transMonthlyCountInfo(temp);

        return RestResult.ok(result);
    }
}
