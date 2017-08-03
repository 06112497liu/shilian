package com.bbd.dao;

import com.bbd.domain.CompanyPunishInfo;
import com.bbd.domain.CompanyPunishInfoExample;
import com.mybatis.domain.PageBounds;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CompanyPunishInfoDao {
    int deleteByPrimaryKey(Integer id);

    int insert(CompanyPunishInfo record);

    int insertSelective(CompanyPunishInfo record);

    List<CompanyPunishInfo> selectByExampleWithPageBounds(CompanyPunishInfoExample example, PageBounds pageBounds);

    List<CompanyPunishInfo> selectByExample(CompanyPunishInfoExample example);

    CompanyPunishInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CompanyPunishInfo record, @Param("example") CompanyPunishInfoExample example);

    int updateByExample(@Param("record") CompanyPunishInfo record, @Param("example") CompanyPunishInfoExample example);

    int updateByPrimaryKeySelective(CompanyPunishInfo record);

    int updateByPrimaryKey(CompanyPunishInfo record);
}