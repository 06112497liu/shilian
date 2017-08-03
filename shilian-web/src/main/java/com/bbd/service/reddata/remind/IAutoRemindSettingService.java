/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.service.reddata.remind;

import com.bbd.domain.AutoRemindSettingInfo;
import com.bbd.service.reddata.remind.param.AutoRemindSettingParam;
import com.bbd.service.reddata.remind.param.AutoRemindSettingQueryVo;

import java.util.List;

/**
 *
 * @author tjwang
 * @version $Id: IAutoRemindSettingService.java, v 0.1 2017/6/9 0009 13:47 tjwang Exp $
 */
public interface IAutoRemindSettingService {

    /**
     * 新增
     * @param info
     */
    Integer add(AutoRemindSettingParam info);

    /**
     * 更新
     * @param info
     * @return
     */
    Integer update(AutoRemindSettingParam info);

    /**
     * 删除
     * @param id
     * @return
     */
    Integer remove(Integer id);

    /**
     * 启用
     * @param id
     */
    Integer enable(Integer id);

    /**
     * 禁用
     * @param id
     */
    Integer disable(Integer id);

    /**
     * 全部启用
     * @param taskType
     */
    Integer enableAll(Integer taskType, String district);

    /**
     * 全部禁用
     * @param taskType
     */
    Integer disableAll(Integer taskType, String district);

    /**
     * 完成设置
     * @param id
     */
    void complete(int id);

    /**
     * 查询提示周期列表
     *
     * @param taskType
     * @param district
     * @return
     */
    List<AutoRemindSettingQueryVo> findSettings(int taskType, String district);

    AutoRemindSettingInfo getById(int id);

    /**
     * 获取到时间生成任务的配置
     * @return
     */
    List<AutoRemindSettingInfo> getTimeReachedSettings();
}
