package com.bbd.dao;

import com.bbd.domain.CompanyAdInfo;
import com.bbd.domain.CompanyAdInfoExample;
import com.mybatis.domain.PageBounds;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CompanyAdInfoDao {
    int deleteByPrimaryKey(Integer id);

    int insert(CompanyAdInfo record);

    int insertSelective(CompanyAdInfo record);

    List<CompanyAdInfo> selectByExampleWithPageBounds(CompanyAdInfoExample example, PageBounds pageBounds);

    List<CompanyAdInfo> selectByExample(CompanyAdInfoExample example);

    CompanyAdInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CompanyAdInfo record, @Param("example") CompanyAdInfoExample example);

    int updateByExample(@Param("record") CompanyAdInfo record, @Param("example") CompanyAdInfoExample example);

    int updateByPrimaryKeySelective(CompanyAdInfo record);

    int updateByPrimaryKey(CompanyAdInfo record);
}