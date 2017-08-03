package com.bbd.dao;

import com.bbd.domain.CompanyRemindDailyCountInfo;
import com.bbd.domain.CompanyRemindDailyCountInfoExample;
import com.mybatis.domain.PageBounds;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CompanyRemindDailyCountInfoDao {
    int deleteByPrimaryKey(Integer id);

    int insert(CompanyRemindDailyCountInfo record);

    int insertSelective(CompanyRemindDailyCountInfo record);

    List<CompanyRemindDailyCountInfo> selectByExampleWithPageBounds(CompanyRemindDailyCountInfoExample example, PageBounds pageBounds);

    List<CompanyRemindDailyCountInfo> selectByExample(CompanyRemindDailyCountInfoExample example);

    CompanyRemindDailyCountInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CompanyRemindDailyCountInfo record, @Param("example") CompanyRemindDailyCountInfoExample example);

    int updateByExample(@Param("record") CompanyRemindDailyCountInfo record, @Param("example") CompanyRemindDailyCountInfoExample example);

    int updateByPrimaryKeySelective(CompanyRemindDailyCountInfo record);

    int updateByPrimaryKey(CompanyRemindDailyCountInfo record);
}