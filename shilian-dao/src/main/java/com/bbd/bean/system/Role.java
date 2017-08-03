/**
 * BBD Service Inc
 * AllRight Reserved @2017
 */
package com.bbd.bean.system;

import com.bbd.bean.Base;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * 角色
 * 
 * @author xc
 * @version $Id: Role.java, v 0.1 2016年12月5日 下午1:10:52 xc Exp $
 */
@SuppressWarnings("serial")
@ApiModel()
public class Role extends Base {

    /** 角色名称 中文 */
    @ApiModelProperty(value = "名称")
    private String       name;

    /** 角色的删除标记 */
    @ApiModelProperty(value = "删除标志位")
    private Integer      deleteFlag;

    /** 状态*/
    @ApiModelProperty(value = "状态(0:正常 ,-1:禁用)")
    private Integer      status;

    /** 角色的模块集合  */
    private List<Module> modules = new ArrayList<>(0);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<Module> getModules() {
        return modules;
    }

    public void setModules(List<Module> modules) {
        this.modules = modules;
    }

    @Override
    public String toString() {
        return "Role [name=" + name + ", deleteFlag=" + deleteFlag + ", status=" + status + ", modules=" + modules + "]";
    }

}
