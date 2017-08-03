package com.bbd.dao;

import com.bbd.domain.AbnormalCompanyInfo;
import com.bbd.domain.AbnormalCompanyInfoExample;
import com.mybatis.domain.PageBounds;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AbnormalCompanyInfoDao {
    int deleteByPrimaryKey(Integer id);

    int insert(AbnormalCompanyInfo record);

    int insertSelective(AbnormalCompanyInfo record);

    List<AbnormalCompanyInfo> selectByExampleWithPageBounds(AbnormalCompanyInfoExample example, PageBounds pageBounds);

    List<AbnormalCompanyInfo> selectByExample(AbnormalCompanyInfoExample example);

    AbnormalCompanyInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AbnormalCompanyInfo record, @Param("example") AbnormalCompanyInfoExample example);

    int updateByExample(@Param("record") AbnormalCompanyInfo record, @Param("example") AbnormalCompanyInfoExample example);

    int updateByPrimaryKeySelective(AbnormalCompanyInfo record);

    int updateByPrimaryKey(AbnormalCompanyInfo record);
}