package com.bbd.dao;

import com.bbd.domain.BusinessTypeInfo;
import com.bbd.domain.BusinessTypeInfoExample;
import com.bbd.domain.BusinessTypeInfoKey;
import com.mybatis.domain.PageBounds;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BusinessTypeInfoDao {
    int deleteByPrimaryKey(BusinessTypeInfoKey key);

    int insert(BusinessTypeInfo record);

    int insertSelective(BusinessTypeInfo record);

    List<BusinessTypeInfo> selectByExampleWithPageBounds(BusinessTypeInfoExample example, PageBounds pageBounds);

    List<BusinessTypeInfo> selectByExample(BusinessTypeInfoExample example);

    BusinessTypeInfo selectByPrimaryKey(BusinessTypeInfoKey key);

    int updateByExampleSelective(@Param("record") BusinessTypeInfo record, @Param("example") BusinessTypeInfoExample example);

    int updateByExample(@Param("record") BusinessTypeInfo record, @Param("example") BusinessTypeInfoExample example);

    int updateByPrimaryKeySelective(BusinessTypeInfo record);

    int updateByPrimaryKey(BusinessTypeInfo record);
}