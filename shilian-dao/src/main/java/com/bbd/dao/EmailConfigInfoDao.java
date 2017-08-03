package com.bbd.dao;

import com.bbd.domain.EmailConfigInfo;
import com.bbd.domain.EmailConfigInfoExample;
import com.mybatis.domain.PageBounds;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmailConfigInfoDao {
    int deleteByPrimaryKey(Integer id);

    int insert(EmailConfigInfo record);

    int insertSelective(EmailConfigInfo record);

    List<EmailConfigInfo> selectByExampleWithPageBounds(EmailConfigInfoExample example, PageBounds pageBounds);

    List<EmailConfigInfo> selectByExample(EmailConfigInfoExample example);

    EmailConfigInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EmailConfigInfo record, @Param("example") EmailConfigInfoExample example);

    int updateByExample(@Param("record") EmailConfigInfo record, @Param("example") EmailConfigInfoExample example);

    int updateByPrimaryKeySelective(EmailConfigInfo record);

    int updateByPrimaryKey(EmailConfigInfo record);
}