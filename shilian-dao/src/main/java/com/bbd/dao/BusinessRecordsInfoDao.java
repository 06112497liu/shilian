package com.bbd.dao;

import com.bbd.domain.BusinessRecordsInfo;
import com.bbd.domain.BusinessRecordsInfoExample;
import com.mybatis.domain.PageBounds;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BusinessRecordsInfoDao {
    int insert(BusinessRecordsInfo record);

    int insertSelective(BusinessRecordsInfo record);

    List<BusinessRecordsInfo> selectByExampleWithPageBounds(BusinessRecordsInfoExample example, PageBounds pageBounds);

    List<BusinessRecordsInfo> selectByExample(BusinessRecordsInfoExample example);

    int updateByExampleSelective(@Param("record") BusinessRecordsInfo record, @Param("example") BusinessRecordsInfoExample example);

    int updateByExample(@Param("record") BusinessRecordsInfo record, @Param("example") BusinessRecordsInfoExample example);
}