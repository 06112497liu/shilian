package com.bbd.dao;

import com.bbd.domain.CompanyStockHolderInfo;
import com.bbd.domain.CompanyStockHolderInfoExample;
import com.mybatis.domain.PageBounds;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CompanyStockHolderInfoDao {
    int deleteByPrimaryKey(Integer id);

    int insert(CompanyStockHolderInfo record);

    int insertSelective(CompanyStockHolderInfo record);

    List<CompanyStockHolderInfo> selectByExampleWithPageBounds(CompanyStockHolderInfoExample example, PageBounds pageBounds);

    List<CompanyStockHolderInfo> selectByExample(CompanyStockHolderInfoExample example);

    CompanyStockHolderInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CompanyStockHolderInfo record, @Param("example") CompanyStockHolderInfoExample example);

    int updateByExample(@Param("record") CompanyStockHolderInfo record, @Param("example") CompanyStockHolderInfoExample example);

    int updateByPrimaryKeySelective(CompanyStockHolderInfo record);

    int updateByPrimaryKey(CompanyStockHolderInfo record);
}