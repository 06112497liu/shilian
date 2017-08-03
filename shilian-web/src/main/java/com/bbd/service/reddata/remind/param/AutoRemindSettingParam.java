
/**
 * BBD Service Inc
 * All Rights Reserved @2017
 */
package com.bbd.service.reddata.remind.param;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 查询提示进度列表封装类
 *
 * @author liuweibo
 * @version $Id: MsgTaskQueryParam.java, v 0.1 2017年6月8日 下午3:31:16 liuweibo Exp $
 */
public class AutoRemindSettingParam {

    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 提示类型（1.企业年报提示,2.失联企业提示,3.未年报企业提示,4.未公示企业提示,5.虚假信息企业提示）
     */
    private Integer taskType;

    /**
     * 任务时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date runDate;

    /**
     * 区域编码
     */
    private String district;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTaskType() {
        return taskType;
    }

    public void setTaskType(Integer taskType) {
        this.taskType = taskType;
    }

    public Date getRunDate() {
        return runDate;
    }

    public void setRunDate(Date runDate) {
        this.runDate = runDate;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }


}

