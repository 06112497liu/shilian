/**
 * BBD Service Inc
 * AllRight Reserved @2017
 */
package com.bbd.bean;

import java.io.Serializable;

/**
 * 基本bean
 * 
 * @author xc
 * @version $Id: Base.java, v 0.1 2016年12月2日 下午6:23:04 xc Exp $
 */
public abstract class Base implements Serializable {

    /** 序列化ID */
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Integer           id;

    /** 记录的创建时间 */
    private String            gmtCreate;

    /** 记录的最近修改时间 */
    private String            gmtModitifed;

    /** 备注 */
    private String            remarks;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(String gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public String getGmtModitifed() {
        return gmtModitifed;
    }

    public void setGmtModitifed(String gmtModitifed) {
        this.gmtModitifed = gmtModitifed;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

}
