package com.bbd.dao;

import com.bbd.domain.IndexRecruitInfo;
import com.bbd.domain.IndexRecruitInfoExample;
import com.mybatis.domain.PageBounds;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IndexRecruitInfoDao {
    int deleteByPrimaryKey(Integer id);

    int insert(IndexRecruitInfo record);

    int insertSelective(IndexRecruitInfo record);

    List<IndexRecruitInfo> selectByExampleWithBLOBs(IndexRecruitInfoExample example);

    List<IndexRecruitInfo> selectByExampleWithPageBounds(IndexRecruitInfoExample example, PageBounds pageBounds);

    List<IndexRecruitInfo> selectByExample(IndexRecruitInfoExample example);

    IndexRecruitInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") IndexRecruitInfo record, @Param("example") IndexRecruitInfoExample example);

    int updateByExampleWithBLOBs(@Param("record") IndexRecruitInfo record, @Param("example") IndexRecruitInfoExample example);

    int updateByExample(@Param("record") IndexRecruitInfo record, @Param("example") IndexRecruitInfoExample example);

    int updateByPrimaryKeySelective(IndexRecruitInfo record);

    int updateByPrimaryKeyWithBLOBs(IndexRecruitInfo record);

    int updateByPrimaryKey(IndexRecruitInfo record);
}