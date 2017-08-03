/**  
 * BBD Service Inc
 * All Rights Reserved @2016
 *
 */
package com.bbd.bean.system;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 系统模块信息
 * @author yujiahao
 * @version $Id: ModuleInfo.java, v 0.1 2016年12月8日 下午1:56:08 yujiahao Exp $
 */
@ApiModel(value = "系统模块信息")
public class ModuleInfo {

    /** 模块id*/
    @ApiModelProperty(value = "模块id")
    private int              id;

    /** 模块名称 */
    @ApiModelProperty(value = "模块名称")
    private String           name;

    @ApiModelProperty(value = "控制的资源地址")
    private String           resource;

    private List<ModuleInfo> children;

    public List<ModuleInfo> getChildren() {
        return children;
    }

    public void setChildren(List<ModuleInfo> children) {
        this.children = children;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }
}
