package com.bbd.dao;

import com.bbd.domain.CompanyBranchInfo;
import com.bbd.domain.CompanyBranchInfoExample;
import com.mybatis.domain.PageBounds;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CompanyBranchInfoDao {
    int deleteByPrimaryKey(Integer id);

    int insert(CompanyBranchInfo record);

    int insertSelective(CompanyBranchInfo record);

    List<CompanyBranchInfo> selectByExampleWithPageBounds(CompanyBranchInfoExample example, PageBounds pageBounds);

    List<CompanyBranchInfo> selectByExample(CompanyBranchInfoExample example);

    CompanyBranchInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CompanyBranchInfo record, @Param("example") CompanyBranchInfoExample example);

    int updateByExample(@Param("record") CompanyBranchInfo record, @Param("example") CompanyBranchInfoExample example);

    int updateByPrimaryKeySelective(CompanyBranchInfo record);

    int updateByPrimaryKey(CompanyBranchInfo record);
}