
/** 
 * BBD Service Inc 
 * All Rights Reserved @2017 
 */
 package com.bbd.service.reddata.remind.param;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/** 
 * 查询提示周期设置列表
 * 
 * @author liuweibo 
 * @version $Id: MsgTaskQueryParam.java, v 0.1 2017年6月8日 下午3:31:16 liuweibo Exp $ 
 */
@ApiModel( "提示周期设置列表返回对象" )
public class AutoRemindSettingQueryVo {

    @ApiModelProperty( "id" )
    private Integer id;
    
    /** 提示类型（1.企业年报提示,2.失联企业提示,3.未年报企业提示,4.未公示企业提示,5.虚假信息企业提示）  */
    @ApiModelProperty( "提示类型" )
    private Integer taskType;

    /** 区域编码  */
    @ApiModelProperty( "区域编码" )
    private String district;
    
    /** 运行时间 */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @ApiModelProperty( "运行时间" )
    private Date runDate;

    /** 是否启动 */
    @ApiModelProperty( "是否启动" )
    private Boolean enabled;

    /** 是否完成 */
    @ApiModelProperty( "是否完成" )
    private Boolean completed;

    @JsonIgnore
    private Date gmtCreate;

    @JsonIgnore
    private Date gmtModified;

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

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Date getRunDate() {
        return runDate;
    }

    public void setRunDate(Date runDate) {
        this.runDate = runDate;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

}

