/**  
 * BBD Service Inc
 * All Rights Reserved @2016
 *
 */
package com.bbd.bean.biz;

/**
 * 实时挖掘到的数据的数量和更新时间 应当从缓存中获取.
 *  
 * @author wangwei
 * @version $Id: CompanyDataCountInfo.java, v 0.1 2017年12月5日 下午1:51:57 wangwei Exp $
 */
public class CompanyDataCountInfo {

    /** 当前已经挖掘的数据的总量  */
    private Long   dataCount;

    /** 该数据的更新时间  */
    private String updateTime;

    public Long getDataCount() {
        return dataCount;
    }

    public void setDataCount(Long dataCount) {
        this.dataCount = dataCount;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

}
