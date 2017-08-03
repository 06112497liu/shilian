/** * BBD Service Inc * All Rights Reserved @2017 * */
package com.bbd.dao;

import com.bbd.domain.ConsumeDataInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/** * * @author xiongyun * @version $Id: DataConnectDealDao.java, v 0.1 2017年6月14日 下午1:56:14 xiongyun Exp $ */
public interface DataPlatformDealDao {

    void insertConsumeNeedData(@Param("tableName") String tableName, @Param("fieldNames") List<String> fieldNames, @Param("values") List<Object> values);

    void insertConsumeAllData(@Param("tableName") String orignalTableName, @Param("value") String value, @Param("companyName") String companyName);

    String selectCompanyId(@Param("companyName") String companyName);

    List<ConsumeDataInfo> selectConsumeAllData(@Param("pageNo") int pageNo, @Param("pageLast") int pageLast);
}
