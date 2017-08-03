package com.bbd.dao;

import com.bbd.domain.MsgTaskInfo;
import com.bbd.domain.MsgTaskInfoExample;
import com.mybatis.domain.PageBounds;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MsgTaskInfoDao {
    int deleteByPrimaryKey(Integer id);

    int insert(MsgTaskInfo record);

    int insertSelective(MsgTaskInfo record);

    List<MsgTaskInfo> selectByExampleWithPageBounds(MsgTaskInfoExample example, PageBounds pageBounds);

    List<MsgTaskInfo> selectByExample(MsgTaskInfoExample example);

    MsgTaskInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MsgTaskInfo record, @Param("example") MsgTaskInfoExample example);

    int updateByExample(@Param("record") MsgTaskInfo record, @Param("example") MsgTaskInfoExample example);

    int updateByPrimaryKeySelective(MsgTaskInfo record);

    int updateByPrimaryKey(MsgTaskInfo record);
}