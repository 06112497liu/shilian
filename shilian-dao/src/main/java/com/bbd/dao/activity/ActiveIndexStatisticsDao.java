/**
 * BBD Service Inc
 * All Rights Reserved @2017
 */
package com.bbd.dao.activity;

import com.bbd.bean.statistics.NameValueInfo;
import com.bbd.bean.statistics.NameValueNodeInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 企业经营活动指数页面   - 数访问接口
 *
 * @author liuweibo
 * @version $Id: ActiveIndexStatisticsDao.java, v 0.1 2017年5月8日 下午1:25:37 liuweibo Exp $
 */
public interface ActiveIndexStatisticsDao {
    
    /**
     * 查询企业经营活动指数趋势
     *
     * @return
     */
    List<NameValueInfo> selectActivityIndexTrend(Map<String, Object> params);

    /**
     * 查询休眠企业率走势
     *
     * @param params
     * @return
     */
    List<NameValueInfo> selectDormancyTrend(Map<String, Object> params);

    /**
     * 按年分组查询企业总数
     */
    List<NameValueInfo> selectCountGruopByYear();

    /**
     * 按年分组查询休眠企业总数
     */
    List<NameValueInfo> selectDormancyCountGruopByYear();

    /**
     * 查询企业活动经营指数分布
     *
     * @param params
     * @return
     */
    List<NameValueNodeInfo> selectBusinessActivityIndexGroup(Map<String, Object> params);

    /**
     * 查询疑似休眠企业一级行业分布
     *
     * @param params
     * @return
     */
    List<NameValueNodeInfo> selectDormancyIndustry(Map<String, Object> params);
    
    /**
     * 查询疑似休眠企业各个一级行业的数量
     *
     * @param params
     * @return
     */
    List<NameValueInfo> selectCompanyCountForIndustry(Map<String, Object> params);

    /**
     * 查询疑似休眠企业区域分布
     *
     * @param params
     * @return
     */
    List<NameValueNodeInfo> selectDormancyArea(Map<String, Object> params);

    /**
     * 获取不同经营状态的企业类型
     *
     * @param distrcit
     * @param companyState
     * @return
     */
    Integer selectCompanyTotal(@Param("district") String district, @Param("companyState") Integer companyState);

}
