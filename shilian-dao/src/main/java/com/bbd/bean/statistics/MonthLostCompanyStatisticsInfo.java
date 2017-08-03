/**  
 * BBD Service Inc
 * All Rights Reserved @2016
 *
 */
package com.bbd.bean.statistics;

import io.swagger.annotations.ApiModelProperty;

/**
 * 本月失联企业的统计信息类
 * 
 * @author zhanghui
 * @version $Id: MonthLostCompanyStatisticsInfo.java, v 0.1 2016年12月2日 下午6:23:54 zhanghui Exp $
 */
public class MonthLostCompanyStatisticsInfo {

    /** 当前统计的地址名称 */
    @ApiModelProperty("当前统计的地址名称 ")
    public String  addrName;

    @ApiModelProperty("企业总数目")
    /** 企业总数目 */
    public int     companyCount;

    @ApiModelProperty("失联企业总数目")
    /** 失联企业总数目 */
    private int    lostCompanyCount;

    @ApiModelProperty("本月新增失联企业总数目")
    /** 本月新增失联企业总数目 */
    private int    monthLostCompanyCount;

    @ApiModelProperty("本月移除失联企业的总数目")
    /** 本月移除失联企业的总数目 */
    private int    monthRemoveLostCompanyCount;

    @ApiModelProperty("最后更新时间")
    /** 最后更新时间  */
    private String lastUpdateTime;

    /** 失联企业百分比 */
    @ApiModelProperty("失联企业百分比")
    private String lostPercent;

    public int getLostCompanyCount() {
        return lostCompanyCount;
    }

    public void setLostCompanyCount(int lostCompanyCount) {
        this.lostCompanyCount = lostCompanyCount;
    }

    public int getMonthLostCompanyCount() {
        return monthLostCompanyCount;
    }

    public void setMonthLostCompanyCount(int monthLostCompanyCount) {
        this.monthLostCompanyCount = monthLostCompanyCount;
    }

    public String getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(String lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public int getMonthRemoveLostCompanyCount() {
        return monthRemoveLostCompanyCount;
    }

    public void setMonthRemoveLostCompanyCount(int monthRemoveLostCompanyCount) {
        this.monthRemoveLostCompanyCount = monthRemoveLostCompanyCount;
    }

    public int getCompanyCount() {
        return companyCount;
    }

    public void setCompanyCount(int companyCount) {
        this.companyCount = companyCount;
    }

    public String getLostPercent() {
        return lostPercent;
    }

    public void setLostPercent(String lostPercent) {
        this.lostPercent = lostPercent;
    }

    public String getAddrName() {
        return addrName;
    }

    public void setAddrName(String addrName) {
        this.addrName = addrName;
    }

    @Override
    public String toString() {
        return "MonthLostCompanyStatisticsInfo [addrName=" + addrName + ", companyCount=" + companyCount + ", lostCompanyCount=" + lostCompanyCount + ", monthLostCompanyCount="
               + monthLostCompanyCount + ", monthRemoveLostCompanyCount=" + monthRemoveLostCompanyCount + ", lastUpdateTime=" + lastUpdateTime + ", lostPercent=" + lostPercent + "]";
    }
}
