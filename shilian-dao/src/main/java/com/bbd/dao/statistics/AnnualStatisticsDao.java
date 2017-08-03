/** 
 * BBD Service Inc 
 * All Rights Reserved @2017 
 */
package com.bbd.dao.statistics;

import com.bbd.bean.statistics.CompanyAddrStaticInfo;
import com.bbd.bean.statistics.NameValueInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/** 
 *  年报统计 数据访问接口
 *  
 * @author liuweibo 
 * @version $Id: AnnualStatisticsDao.java, v 0.1 2017年5月3日 上午10:23:44 liuweibo Exp $ 
 */
@Repository
public interface AnnualStatisticsDao {

    /**
     * 查询指定区域已年报企业总数
     * @return
     */
    Integer selectHaveAnnualCount(@Param("district") String district);

    /**
     * 查询贵阳市当前应年报企业总数
     * @return 应年报企业数量
     */
    Integer selectShouldAnnualCount(@Param("district") String district);

    /**
     * 查询未年报企业数量
     * @param district
     * @return
     */
    Integer selectUnannualedCount(@Param("district") String district);

    /**
     * 查询指定年月年报数
     * @param year
     * @param month
     * @param district
     * @return
     */
    Integer selectAnnualedCurrentMonthCount(@Param("year") Integer year, @Param("month") Integer month, @Param("district") String district);

    /**
     * 获取已年报企业区域分布
     * @return
     */
    List<CompanyAddrStaticInfo> selectAnnualedCompanyDistribute();

    /**
     * 获取未年报企业行业分布
     * @return
     */
    List<NameValueInfo> selectUnannualIndustryDistribute(@Param("district") String district);

    /**
     * 获取未年报企业企业性质分布
     * @param district
     * @return
     */
    List<NameValueInfo> selectUnannualPropertyDistribute(@Param("district") String district);
}
