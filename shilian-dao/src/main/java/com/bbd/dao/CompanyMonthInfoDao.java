package com.bbd.dao;

import com.bbd.domain.CompanyMonthInfo;
import com.bbd.domain.CompanyMonthInfoExample;
import com.mybatis.domain.PageBounds;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CompanyMonthInfoDao {
    int deleteByPrimaryKey(Integer id);

    int insert(CompanyMonthInfo record);

    int insertSelective(CompanyMonthInfo record);

    List<CompanyMonthInfo> selectByExampleWithPageBounds(CompanyMonthInfoExample example, PageBounds pageBounds);

    List<CompanyMonthInfo> selectByExample(CompanyMonthInfoExample example);

    CompanyMonthInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CompanyMonthInfo record, @Param("example") CompanyMonthInfoExample example);

    int updateByExample(@Param("record") CompanyMonthInfo record, @Param("example") CompanyMonthInfoExample example);

    int updateByPrimaryKeySelective(CompanyMonthInfo record);

    int updateByPrimaryKey(CompanyMonthInfo record);
}