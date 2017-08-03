package com.bbd.dao;

import com.bbd.domain.CompanyRemindDetailInfo;
import com.bbd.domain.CompanyRemindDetailInfoExample;
import com.mybatis.domain.PageBounds;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CompanyRemindDetailInfoDao {
    int deleteByPrimaryKey(Integer id);

    int insert(CompanyRemindDetailInfo record);

    int insertSelective(CompanyRemindDetailInfo record);

    List<CompanyRemindDetailInfo> selectByExampleWithPageBounds(CompanyRemindDetailInfoExample example, PageBounds pageBounds);

    List<CompanyRemindDetailInfo> selectByExample(CompanyRemindDetailInfoExample example);

    CompanyRemindDetailInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CompanyRemindDetailInfo record, @Param("example") CompanyRemindDetailInfoExample example);

    int updateByExample(@Param("record") CompanyRemindDetailInfo record, @Param("example") CompanyRemindDetailInfoExample example);

    int updateByPrimaryKeySelective(CompanyRemindDetailInfo record);

    int updateByPrimaryKey(CompanyRemindDetailInfo record);
}