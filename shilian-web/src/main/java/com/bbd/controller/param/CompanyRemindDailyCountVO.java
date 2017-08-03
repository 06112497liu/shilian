
/** 
 * BBD Service Inc 
 * All Rights Reserved @2017 
 */
 package com.bbd.controller.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/** 
 *  
 * @author liuweibo 
 * @version $Id: CompanyRemindDailyCountVO.java, v 0.1 2017年6月12日 下午5:15:46 liuweibo Exp $ 
 */
 @ApiModel( "时间轴（日）统计返回对象" )
public class CompanyRemindDailyCountVO {
    
    @ApiModelProperty("类型（1.年报， 2.失联， 3.未年报， 4.未公示， 5.虚假信息）")
    private Integer type;
    
    @ApiModelProperty("日")
    private Integer day;
    
    @ApiModelProperty("月份")
    private Integer month;

    @ApiModelProperty("年份")
    private Integer year;

    @ApiModelProperty("数量")
    private Integer count;

    public Integer getType() {
        return type;
    }

    public void setType( Integer type ) {
        this.type = type;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay( Integer day ) {
        this.day = day;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth( Integer month ) {
        this.month = month;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear( Integer year ) {
        this.year = year;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount( Integer count ) {
        this.count = count;
    }
    
    
}

