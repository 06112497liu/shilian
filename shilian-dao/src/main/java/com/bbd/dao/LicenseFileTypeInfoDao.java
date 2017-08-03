package com.bbd.dao;

import com.bbd.domain.LicenseFileTypeInfo;
import com.bbd.domain.LicenseFileTypeInfoExample;
import com.mybatis.domain.PageBounds;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LicenseFileTypeInfoDao {
    int insert(LicenseFileTypeInfo record);

    int insertSelective(LicenseFileTypeInfo record);

    List<LicenseFileTypeInfo> selectByExampleWithPageBounds(LicenseFileTypeInfoExample example, PageBounds pageBounds);

    List<LicenseFileTypeInfo> selectByExample(LicenseFileTypeInfoExample example);

    int updateByExampleSelective(@Param("record") LicenseFileTypeInfo record, @Param("example") LicenseFileTypeInfoExample example);

    int updateByExample(@Param("record") LicenseFileTypeInfo record, @Param("example") LicenseFileTypeInfoExample example);
}