/** 
 * BBD Service Inc 
 * All Rights Reserved @2017 
 */
package com.bbd.dao.statistics;

import org.apache.ibatis.annotations.Param;

/**
 *  企业统计信息
 * @author liuweibo 
 * @version $Id: CompanyStatisticsDao.java, v 0.1 2017年5月4日 上午9:59:31 liuweibo Exp $ 
 */
public interface CompanyStatisticsDao {

    /**
     * 获取挖掘数据总数
     */
    long getDataCount();

    /**
     * 查询企业的总数目 带权限
     */
    Integer selectCompanyTotalCount(@Param("district") String district);

}
