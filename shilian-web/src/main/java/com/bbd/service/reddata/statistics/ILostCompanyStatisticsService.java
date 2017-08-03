/**  
 * BBD Service Inc
 * All Rights Reserved @2016
 *
 */
package com.bbd.service.reddata.statistics;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.bbd.controller.job.excel.LostCompanyListVo;
import com.bbd.controller.param.LostCompanyQueryParam;
import com.mybatis.domain.PageBounds;
import com.mybatis.domain.PageList;

/**
 * 失联企业统计服务接口
 * 
 * @author 刘维柏
 * @version $Id: ILostCompanyStatisticsService.java, v 0.1 2016年12月5日 上午10:03:47 刘维柏  Exp $
 */
public interface ILostCompanyStatisticsService {


    /**
     * 导出统计的word
     * @return 
     */
    String exportStatisticsWord(Integer addrCode, String hotImg, String companyTypeImg, String industryImg);

    /**
     * @param uid uid字符串
     */
    void downLoadReport(HttpServletResponse response, String uid);

    List<LostCompanyListVo> queryLostCompany(LostCompanyQueryParam param);

    PageList<LostCompanyListVo> queryLostCompany(LostCompanyQueryParam param, PageBounds pb);

}
