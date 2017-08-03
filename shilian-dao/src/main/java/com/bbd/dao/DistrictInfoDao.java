package com.bbd.dao;

import com.bbd.domain.DistrictInfo;
import com.bbd.domain.DistrictInfoExample;
import com.mybatis.domain.PageBounds;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DistrictInfoDao {
    int insert(DistrictInfo record);

    int insertSelective(DistrictInfo record);

    List<DistrictInfo> selectByExampleWithPageBounds(DistrictInfoExample example, PageBounds pageBounds);

    List<DistrictInfo> selectByExample(DistrictInfoExample example);

    int updateByExampleSelective(@Param("record") DistrictInfo record, @Param("example") DistrictInfoExample example);

    int updateByExample(@Param("record") DistrictInfo record, @Param("example") DistrictInfoExample example);
}