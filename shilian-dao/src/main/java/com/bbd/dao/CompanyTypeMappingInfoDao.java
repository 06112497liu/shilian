package com.bbd.dao;

import com.bbd.domain.CompanyTypeMappingInfo;
import com.bbd.domain.CompanyTypeMappingInfoExample;
import com.mybatis.domain.PageBounds;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CompanyTypeMappingInfoDao {
    int deleteByPrimaryKey(Integer id);

    int insert(CompanyTypeMappingInfo record);

    int insertSelective(CompanyTypeMappingInfo record);

    List<CompanyTypeMappingInfo> selectByExampleWithPageBounds(CompanyTypeMappingInfoExample example, PageBounds pageBounds);

    List<CompanyTypeMappingInfo> selectByExample(CompanyTypeMappingInfoExample example);

    CompanyTypeMappingInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CompanyTypeMappingInfo record, @Param("example") CompanyTypeMappingInfoExample example);

    int updateByExample(@Param("record") CompanyTypeMappingInfo record, @Param("example") CompanyTypeMappingInfoExample example);

    int updateByPrimaryKeySelective(CompanyTypeMappingInfo record);

    int updateByPrimaryKey(CompanyTypeMappingInfo record);
}