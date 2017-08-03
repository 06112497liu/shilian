package com.bbd.dao;

import com.bbd.domain.CompanyRemindMonthlyCountInfo;
import com.bbd.domain.CompanyRemindMonthlyCountInfoExample;
import com.mybatis.domain.PageBounds;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CompanyRemindMonthlyCountInfoDao {
    int deleteByPrimaryKey(Integer id);

    int insert(CompanyRemindMonthlyCountInfo record);

    int insertSelective(CompanyRemindMonthlyCountInfo record);

    List<CompanyRemindMonthlyCountInfo> selectByExampleWithPageBounds(CompanyRemindMonthlyCountInfoExample example, PageBounds pageBounds);

    List<CompanyRemindMonthlyCountInfo> selectByExample(CompanyRemindMonthlyCountInfoExample example);

    CompanyRemindMonthlyCountInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CompanyRemindMonthlyCountInfo record, @Param("example") CompanyRemindMonthlyCountInfoExample example);

    int updateByExample(@Param("record") CompanyRemindMonthlyCountInfo record, @Param("example") CompanyRemindMonthlyCountInfoExample example);

    int updateByPrimaryKeySelective(CompanyRemindMonthlyCountInfo record);

    int updateByPrimaryKey(CompanyRemindMonthlyCountInfo record);
}