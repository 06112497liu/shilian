/**  
 * BBD Service Inc
 * All Rights Reserved @2016
 *
 */
package com.bbd.bean.system;

import com.bbd.bean.Base;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 系统模块
 * @author yujiahao
 * @version $Id: Module.java, v 0.1 2016年12月7日 下午4:44:19 yujiahao Exp $
 */
@SuppressWarnings("serial")
@ApiModel(value = "系统模块")
public class Module extends Base {

    /** 首页模块的id 创建用户时的默认权限 */
    public static final int HOME_MODULE_ID = 1;

    /** 模块名称 */
    @ApiModelProperty(value = "模块名称")
    private String          name;

    /** 模块资源 */
    @ApiModelProperty(value = "模块资源")
    private String          resource;

    /** 父模块id */
    @ApiModelProperty(value = "父模块id")
    private Integer         parentId;

    /** 子模块集合 */
    @ApiModelProperty(value = "子模块集合")
    private List<Module>    children;

    public Module() {
    }

    public Module(Integer id) {
        this.setId(id);
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

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public List<Module> getChildren() {
        return children;
    }

    public void setChildren(List<Module> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Module [name=" + name + ", resource=" + resource + ", parentId=" + parentId + ", children=" + children + "]";
    }
}
