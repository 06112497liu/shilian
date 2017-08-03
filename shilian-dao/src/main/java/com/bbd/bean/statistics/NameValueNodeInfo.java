/**  
 * BBD Service Inc
 * All Rights Reserved @2016
 *
 */
package com.bbd.bean.statistics;

import io.swagger.annotations.ApiModelProperty;

/**
 * 数据节点.
 * <p>{name:'name',value:'value'}<p/>
 * 
 * @author zhanghui
 * @version $Id: NameValueNodeInfo.java, v 0.1 2016年12月5日 上午10:37:01 zhanghui Exp $
 */
public class NameValueNodeInfo {

    /** echarts data name，this type is possible {String, int, double or other} in dao definition xml */
    @ApiModelProperty("数据名称")
    private Object name;

    /** echarts data value type {String, integer, double or other in dao xml definition} */
    @ApiModelProperty("数数据值")
    private Object value;

    /** value在数据中的百分占比  */
    @ApiModelProperty("数据所占百分比")
    private String percent;

    public NameValueNodeInfo() {
        super();
    }

    /**
     * @param name
     * @param value
     */
    public NameValueNodeInfo(Object name, Object value) {
        this.name = name;
        this.value = value;
    }

    /**
     * @param name
     * @param value
     * @param 百分比
     */
    public NameValueNodeInfo(Object name, Object value, String percent) {
        this.name = name;
        this.value = value;
        this.percent = percent;
    }

    public Object getName() {
        return name;
    }

    public void setName(Object name) {
        this.name = name;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String getPercent() {
        return percent;
    }

    public void setPercent(String percent) {
        this.percent = percent;
    }

    @Override
    public String toString() {
        return "NameValueNodeInfo [name=" + name + ", value=" + value + ", percent=" + percent + "]";
    }
}
