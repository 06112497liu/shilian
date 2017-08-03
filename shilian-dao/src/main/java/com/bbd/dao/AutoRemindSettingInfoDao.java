package com.bbd.dao;

import com.bbd.domain.AutoRemindSettingInfo;
import com.bbd.domain.AutoRemindSettingInfoExample;
import com.mybatis.domain.PageBounds;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AutoRemindSettingInfoDao {
    int deleteByPrimaryKey(Integer id);

    int insert(AutoRemindSettingInfo record);

    int insertSelective(AutoRemindSettingInfo record);

    List<AutoRemindSettingInfo> selectByExampleWithPageBounds(AutoRemindSettingInfoExample example, PageBounds pageBounds);

    List<AutoRemindSettingInfo> selectByExample(AutoRemindSettingInfoExample example);

    AutoRemindSettingInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AutoRemindSettingInfo record, @Param("example") AutoRemindSettingInfoExample example);

    int updateByExample(@Param("record") AutoRemindSettingInfo record, @Param("example") AutoRemindSettingInfoExample example);

    int updateByPrimaryKeySelective(AutoRemindSettingInfo record);

    int updateByPrimaryKey(AutoRemindSettingInfo record);
}