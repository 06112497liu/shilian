package com.bbd.dao;


import com.bbd.domain.ReportRecord;
import com.bbd.domain.ReportRecordExample;
import com.mybatis.domain.PageBounds;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReportRecordDao {
    int deleteByPrimaryKey(Integer id);

    int insert(ReportRecord record);

    int insertSelective(ReportRecord record);

    List<ReportRecord> selectByExampleWithPageBounds(ReportRecordExample example, PageBounds pageBounds);

    List<ReportRecord> selectByExample(ReportRecordExample example);

    ReportRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ReportRecord record, @Param("example") ReportRecordExample example);

    int updateByExample(@Param("record") ReportRecord record, @Param("example") ReportRecordExample example);

    int updateByPrimaryKeySelective(ReportRecord record);

    int updateByPrimaryKey(ReportRecord record);
}