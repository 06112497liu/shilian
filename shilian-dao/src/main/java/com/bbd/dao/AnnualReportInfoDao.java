package com.bbd.dao;

import com.bbd.domain.AnnualReportInfo;
import com.bbd.domain.AnnualReportInfoExample;
import com.mybatis.domain.PageBounds;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AnnualReportInfoDao {
    int deleteByPrimaryKey(Integer id);

    int insert(AnnualReportInfo record);

    int insertSelective(AnnualReportInfo record);

    List<AnnualReportInfo> selectByExampleWithPageBounds(AnnualReportInfoExample example, PageBounds pageBounds);

    List<AnnualReportInfo> selectByExample(AnnualReportInfoExample example);

    AnnualReportInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AnnualReportInfo record, @Param("example") AnnualReportInfoExample example);

    int updateByExample(@Param("record") AnnualReportInfo record, @Param("example") AnnualReportInfoExample example);

    int updateByPrimaryKeySelective(AnnualReportInfo record);

    int updateByPrimaryKey(AnnualReportInfo record);
}