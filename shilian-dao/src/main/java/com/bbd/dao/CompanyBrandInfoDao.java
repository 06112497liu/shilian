package com.bbd.dao;

import com.bbd.domain.CompanyBrandInfo;
import com.bbd.domain.CompanyBrandInfoExample;
import com.mybatis.domain.PageBounds;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CompanyBrandInfoDao {
    int deleteByPrimaryKey(Integer id);

    int insert(CompanyBrandInfo record);

    int insertSelective(CompanyBrandInfo record);

    List<CompanyBrandInfo> selectByExampleWithPageBounds(CompanyBrandInfoExample example, PageBounds pageBounds);

    List<CompanyBrandInfo> selectByExample(CompanyBrandInfoExample example);

    CompanyBrandInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CompanyBrandInfo record, @Param("example") CompanyBrandInfoExample example);

    int updateByExample(@Param("record") CompanyBrandInfo record, @Param("example") CompanyBrandInfoExample example);

    int updateByPrimaryKeySelective(CompanyBrandInfo record);

    int updateByPrimaryKey(CompanyBrandInfo record);
}