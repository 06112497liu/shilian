package com.bbd.dao;

import com.bbd.domain.CompanyIndustryInfo;
import com.bbd.domain.CompanyIndustryInfoExample;
import com.mybatis.domain.PageBounds;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CompanyIndustryInfoDao {
    int deleteByPrimaryKey(String code);

    int insert(CompanyIndustryInfo record);

    int insertSelective(CompanyIndustryInfo record);

    List<CompanyIndustryInfo> selectByExampleWithPageBounds(CompanyIndustryInfoExample example, PageBounds pageBounds);

    List<CompanyIndustryInfo> selectByExample(CompanyIndustryInfoExample example);

    CompanyIndustryInfo selectByPrimaryKey(String code);

    int updateByExampleSelective(@Param("record") CompanyIndustryInfo record, @Param("example") CompanyIndustryInfoExample example);

    int updateByExample(@Param("record") CompanyIndustryInfo record, @Param("example") CompanyIndustryInfoExample example);

    int updateByPrimaryKeySelective(CompanyIndustryInfo record);

    int updateByPrimaryKey(CompanyIndustryInfo record);
}