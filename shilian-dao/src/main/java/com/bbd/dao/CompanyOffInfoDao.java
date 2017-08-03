package com.bbd.dao;

import com.bbd.domain.CompanyOffInfo;
import com.bbd.domain.CompanyOffInfoExample;
import com.mybatis.domain.PageBounds;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CompanyOffInfoDao {
    int deleteByPrimaryKey(Integer id);

    int insert(CompanyOffInfo record);

    int insertSelective(CompanyOffInfo record);

    List<CompanyOffInfo> selectByExampleWithPageBounds(CompanyOffInfoExample example, PageBounds pageBounds);

    List<CompanyOffInfo> selectByExample(CompanyOffInfoExample example);

    CompanyOffInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CompanyOffInfo record, @Param("example") CompanyOffInfoExample example);

    int updateByExample(@Param("record") CompanyOffInfo record, @Param("example") CompanyOffInfoExample example);

    int updateByPrimaryKeySelective(CompanyOffInfo record);

    int updateByPrimaryKey(CompanyOffInfo record);
}