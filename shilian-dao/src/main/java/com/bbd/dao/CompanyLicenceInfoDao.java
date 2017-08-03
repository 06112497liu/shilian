package com.bbd.dao;

import com.bbd.domain.CompanyLicenceInfo;
import com.bbd.domain.CompanyLicenceInfoExample;
import com.mybatis.domain.PageBounds;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CompanyLicenceInfoDao {
    int deleteByPrimaryKey(Integer id);

    int insert(CompanyLicenceInfo record);

    int insertSelective(CompanyLicenceInfo record);

    List<CompanyLicenceInfo> selectByExampleWithPageBounds(CompanyLicenceInfoExample example, PageBounds pageBounds);

    List<CompanyLicenceInfo> selectByExample(CompanyLicenceInfoExample example);

    CompanyLicenceInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CompanyLicenceInfo record, @Param("example") CompanyLicenceInfoExample example);

    int updateByExample(@Param("record") CompanyLicenceInfo record, @Param("example") CompanyLicenceInfoExample example);

    int updateByPrimaryKeySelective(CompanyLicenceInfo record);

    int updateByPrimaryKey(CompanyLicenceInfo record);
}