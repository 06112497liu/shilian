/** 
 * BBD Service Inc 
 * All Rights Reserved @2017 
 */
package com.bbd.service.reddata.activity;

import java.util.List;
import java.util.Map;

import com.bbd.bean.company.CompanyBusinessInfoVO;
import com.bbd.bean.statistics.CompanyActiveIndexStatisticsInfo;
import com.bbd.bean.statistics.NameValueInfoExplore;
import com.bbd.bean.statistics.NameValueNodeInfo;
import com.bbd.controller.param.CompanyBusinessInfoQueryParam;
import com.bbd.controller.reddata.activity.param.ActiveIndexQuery;
import com.mybatis.domain.PageBounds;
import com.mybatis.domain.PageList;

/** 
 * 企业经营活动指数接口
 * @author liuweibo 
 * @version $Id: ActiveIndexService.java, v 0.1 2017年5月8日 下午1:36:10 liuweibo Exp $ 
 */
public interface IActivityIndexService {

    /**
     * 获取企业经营活动指数趋势
     */
    Map<Integer, CompanyActiveIndexStatisticsInfo> getActivityIndexTrend(ActiveIndexQuery indexQuery);
    
    /**
     * 获取休眠企业率走势
     */
    Map<Integer, CompanyActiveIndexStatisticsInfo> getDormancyTrend(ActiveIndexQuery indexQuery);
    
    /**
     * 获取企业经营活动指数分布
     */
    List<NameValueInfoExplore> getBusinessActivityIndexGroup(ActiveIndexQuery indexQuery);

    /**
     * 获取疑似休眠企业一级行业分布
     */
    List<NameValueNodeInfo> getDormancyIndustry(ActiveIndexQuery indexQuery);
    
    /**
     * 获取各个行业疑似休眠企业数量
     */
    Map<Object, Object> getCompanyCountForIndustry(String areaCode, int companyState);

    /**
     * 获取休眠企业区域分布
     */
    List<NameValueNodeInfo> getDormancyArea(ActiveIndexQuery indexQuery);

    /**
     * 获取企业信息列表（走数据库）
     */
    PageList<CompanyBusinessInfoVO> getCompanyBusinessInfoList(CompanyBusinessInfoQueryParam params, PageBounds pb);

    List<CompanyBusinessInfoVO> getCompanyBusinessInfoList(CompanyBusinessInfoQueryParam params);

    /**
     * 获取经营活动指数根据月份来查询
     * @param nbxh  企业的nbxh
     * @param year 年份
     * @param month 月份实际
     */
    double getCompanyMonthActivityExp(String nbxh, int year, int month);
    
    /**
     * 经营异常企业总数
     * @param district
     * @param companyState
     * @return
     */
    Integer getCompanyCount(String district, Integer companyState);

}
