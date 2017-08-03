package com.bbd.dao;

import com.bbd.domain.BusinessMonthStatisticsInfo;
import com.bbd.domain.BusinessMonthStatisticsInfoExample;
import com.mybatis.domain.PageBounds;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BusinessMonthStatisticsInfoDao {
    int deleteByPrimaryKey(Integer id);

    int insert(BusinessMonthStatisticsInfo record);

    int insertSelective(BusinessMonthStatisticsInfo record);

    List<BusinessMonthStatisticsInfo> selectByExampleWithPageBounds(BusinessMonthStatisticsInfoExample example, PageBounds pageBounds);

    List<BusinessMonthStatisticsInfo> selectByExample(BusinessMonthStatisticsInfoExample example);

    BusinessMonthStatisticsInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BusinessMonthStatisticsInfo record, @Param("example") BusinessMonthStatisticsInfoExample example);

    int updateByExample(@Param("record") BusinessMonthStatisticsInfo record, @Param("example") BusinessMonthStatisticsInfoExample example);

    int updateByPrimaryKeySelective(BusinessMonthStatisticsInfo record);

    int updateByPrimaryKey(BusinessMonthStatisticsInfo record);
}