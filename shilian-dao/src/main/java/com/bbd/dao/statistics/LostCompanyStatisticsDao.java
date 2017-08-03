/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.dao.statistics;

import com.bbd.bean.query.BaseQuery;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * 失联企业统计 数据访问接口
 *
 * @author zhanghui
 * @version $Id: LostCompanyStatisticsDao.java, v 0.1 2016年12月5日 下午2:10:25 zhanghui Exp $
 */
@Repository
public interface LostCompanyStatisticsDao {

    /**
     * 查询失联企业表的最后更新时间
     *
     * @return
     */
    Date selectLostInfoLastUpdateTime(BaseQuery query);


}
