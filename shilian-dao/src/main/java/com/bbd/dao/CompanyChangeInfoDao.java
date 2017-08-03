package com.bbd.dao;

import com.bbd.domain.CompanyChangeInfo;
import com.bbd.domain.CompanyChangeInfoExample;
import com.mybatis.domain.PageBounds;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CompanyChangeInfoDao {
    int deleteByPrimaryKey(Integer id);

    int insert(CompanyChangeInfo record);

    int insertSelective(CompanyChangeInfo record);

    List<CompanyChangeInfo> selectByExampleWithPageBounds(CompanyChangeInfoExample example, PageBounds pageBounds);

    List<CompanyChangeInfo> selectByExample(CompanyChangeInfoExample example);

    CompanyChangeInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CompanyChangeInfo record, @Param("example") CompanyChangeInfoExample example);

    int updateByExample(@Param("record") CompanyChangeInfo record, @Param("example") CompanyChangeInfoExample example);

    int updateByPrimaryKeySelective(CompanyChangeInfo record);

    int updateByPrimaryKey(CompanyChangeInfo record);
}