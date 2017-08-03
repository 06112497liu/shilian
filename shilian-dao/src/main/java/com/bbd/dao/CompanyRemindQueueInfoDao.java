package com.bbd.dao;

import com.bbd.domain.CompanyRemindQueueInfo;
import com.bbd.domain.CompanyRemindQueueInfoExample;
import com.mybatis.domain.PageBounds;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CompanyRemindQueueInfoDao {
    int deleteByPrimaryKey(Integer id);

    int insert(CompanyRemindQueueInfo record);

    int insertSelective(CompanyRemindQueueInfo record);

    List<CompanyRemindQueueInfo> selectByExampleWithPageBounds(CompanyRemindQueueInfoExample example, PageBounds pageBounds);

    List<CompanyRemindQueueInfo> selectByExample(CompanyRemindQueueInfoExample example);

    CompanyRemindQueueInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CompanyRemindQueueInfo record, @Param("example") CompanyRemindQueueInfoExample example);

    int updateByExample(@Param("record") CompanyRemindQueueInfo record, @Param("example") CompanyRemindQueueInfoExample example);

    int updateByPrimaryKeySelective(CompanyRemindQueueInfo record);

    int updateByPrimaryKey(CompanyRemindQueueInfo record);
}