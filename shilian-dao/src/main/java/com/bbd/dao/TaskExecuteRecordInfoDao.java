package com.bbd.dao;

import com.bbd.domain.TaskExecuteRecordInfo;
import com.bbd.domain.TaskExecuteRecordInfoExample;
import com.mybatis.domain.PageBounds;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TaskExecuteRecordInfoDao {
    int deleteByPrimaryKey(Integer id);

    int insert(TaskExecuteRecordInfo record);

    int insertSelective(TaskExecuteRecordInfo record);

    List<TaskExecuteRecordInfo> selectByExampleWithPageBounds(TaskExecuteRecordInfoExample example, PageBounds pageBounds);

    List<TaskExecuteRecordInfo> selectByExample(TaskExecuteRecordInfoExample example);

    TaskExecuteRecordInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TaskExecuteRecordInfo record, @Param("example") TaskExecuteRecordInfoExample example);

    int updateByExample(@Param("record") TaskExecuteRecordInfo record, @Param("example") TaskExecuteRecordInfoExample example);

    int updateByPrimaryKeySelective(TaskExecuteRecordInfo record);

    int updateByPrimaryKey(TaskExecuteRecordInfo record);
}