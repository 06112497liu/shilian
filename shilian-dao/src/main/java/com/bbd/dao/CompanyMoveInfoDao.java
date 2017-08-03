package com.bbd.dao;

import com.bbd.domain.CompanyMoveInfo;
import com.bbd.domain.CompanyMoveInfoExample;
import com.mybatis.domain.PageBounds;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CompanyMoveInfoDao {
    int deleteByPrimaryKey(Integer id);

    int insert(CompanyMoveInfo record);

    int insertSelective(CompanyMoveInfo record);

    List<CompanyMoveInfo> selectByExampleWithPageBounds(CompanyMoveInfoExample example, PageBounds pageBounds);

    List<CompanyMoveInfo> selectByExample(CompanyMoveInfoExample example);

    CompanyMoveInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CompanyMoveInfo record, @Param("example") CompanyMoveInfoExample example);

    int updateByExample(@Param("record") CompanyMoveInfo record, @Param("example") CompanyMoveInfoExample example);

    int updateByPrimaryKeySelective(CompanyMoveInfo record);

    int updateByPrimaryKey(CompanyMoveInfo record);
}