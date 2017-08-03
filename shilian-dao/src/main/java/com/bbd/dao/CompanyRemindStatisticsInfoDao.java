package com.bbd.dao;

import com.bbd.domain.CompanyRemindStatisticsInfo;
import com.bbd.domain.CompanyRemindStatisticsInfoExample;
import com.mybatis.domain.PageBounds;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CompanyRemindStatisticsInfoDao {
    int deleteByPrimaryKey(Integer id);

    int insert(CompanyRemindStatisticsInfo record);

    int insertSelective(CompanyRemindStatisticsInfo record);

    List<CompanyRemindStatisticsInfo> selectByExampleWithPageBounds(CompanyRemindStatisticsInfoExample example, PageBounds pageBounds);

    List<CompanyRemindStatisticsInfo> selectByExample(CompanyRemindStatisticsInfoExample example);

    CompanyRemindStatisticsInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CompanyRemindStatisticsInfo record, @Param("example") CompanyRemindStatisticsInfoExample example);

    int updateByExample(@Param("record") CompanyRemindStatisticsInfo record, @Param("example") CompanyRemindStatisticsInfoExample example);

    int updateByPrimaryKeySelective(CompanyRemindStatisticsInfo record);

    int updateByPrimaryKey(CompanyRemindStatisticsInfo record);
}