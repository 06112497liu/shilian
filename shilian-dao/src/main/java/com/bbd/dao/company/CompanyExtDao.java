/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.dao.company;

import com.bbd.bean.biz.AddrPointInfo;
import com.bbd.bean.company.CompanyBusinessInfoVO;
import com.bbd.bean.company.LostCompanyInfoVO;
import com.bbd.bean.statistics.NameValueInfo;
import com.bbd.domain.CompanyInfo;
import com.mybatis.domain.PageBounds;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author tjwang
 * @version $Id: CompanyExtDao.java, v 0.1 2017/6/13 0013 14:38 tjwang Exp $
 */
public interface CompanyExtDao {

    List<CompanyInfo> selectAbnormalCompanyInfo(Map<String, Object> map, PageBounds pb);

    /**
     * 查询失联企业，多维查询
     *
     * @param map
     * @return
     */
    List<LostCompanyInfoVO> queryLostCompany(Map<String, Object> map, PageBounds pb);

    /**
     * 查询企业经营活动指数列表
     *
     * @param map
     * @param pb
     * @return
     */
    List<CompanyBusinessInfoVO> queryBusinessCompanyList(Map<String, Object> map, PageBounds pb);

    /**
     * 根据地区查询地图散点
     *
     * @param params
     * @return
     */
    List<AddrPointInfo> selectAddressPointInfo(Map<String, Object> params);

    /**
     * 更新指定年月的指数分数到企业表
     *
     * @param year
     * @param month
     */
    void updateCompanyIndexScore(@Param("year") int year, @Param("month") int month);

    /**
     * 查询贵阳市各区域企业数量
     *
     * @return
     */
    List<NameValueInfo> selectCompanyGroupByDistrict();

    /**
     * 查询贵阳市各区域当前应年报企业数量
     *
     * @return
     */
    List<NameValueInfo> selectShouldAnnualCoutByDistrict();
    
    
    /**
     * 更新企业经营活动记录
     *
     * @param year
     * @param month
     */
    void updateCompanyBusinessRecord(@Param("year") int year, @Param("month") int month);
}













