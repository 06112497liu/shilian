package com.bbd.dao;

import com.bbd.domain.IndexPurchaseInfo;
import com.bbd.domain.IndexPurchaseInfoExample;
import com.bbd.domain.IndexPurchaseInfoWithBLOBs;
import com.mybatis.domain.PageBounds;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IndexPurchaseInfoDao {
    int deleteByPrimaryKey(Integer id);

    int insert(IndexPurchaseInfoWithBLOBs record);

    int insertSelective(IndexPurchaseInfoWithBLOBs record);

    List<IndexPurchaseInfoWithBLOBs> selectByExampleWithBLOBs(IndexPurchaseInfoExample example);

    List<IndexPurchaseInfo> selectByExampleWithPageBounds(IndexPurchaseInfoExample example, PageBounds pageBounds);

    List<IndexPurchaseInfo> selectByExample(IndexPurchaseInfoExample example);

    IndexPurchaseInfoWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") IndexPurchaseInfoWithBLOBs record, @Param("example") IndexPurchaseInfoExample example);

    int updateByExampleWithBLOBs(@Param("record") IndexPurchaseInfoWithBLOBs record, @Param("example") IndexPurchaseInfoExample example);

    int updateByExample(@Param("record") IndexPurchaseInfo record, @Param("example") IndexPurchaseInfoExample example);

    int updateByPrimaryKeySelective(IndexPurchaseInfoWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(IndexPurchaseInfoWithBLOBs record);

    int updateByPrimaryKey(IndexPurchaseInfo record);
}