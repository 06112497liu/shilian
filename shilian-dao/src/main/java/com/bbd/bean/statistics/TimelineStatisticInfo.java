/** 
 * BBD Service Inc 
 * All Rights Reserved @2017 
 */
package com.bbd.bean.statistics;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/** 
 *  
 * @author liuweibo 
 * @version $Id: TimelineStatisticInfo.java, v 0.1 2017年6月15日 下午3:35:30 liuweibo Exp $ 
 */
public class TimelineStatisticInfo implements Serializable {

    private static final long serialVersionUID = -3865256192538237545L;

    /** 时间轴X轴 */
    @ApiModelProperty("时间轴X轴")
    private String[]          names;

    /** 时间轴Y轴 */
    @ApiModelProperty("时间轴Y轴")
    private String[]          values;

    public TimelineStatisticInfo() {
    }

    /**
     * 数据列表转数组
     * @param 
     */
    public TimelineStatisticInfo(List<NameValueInfo> infos) {
        names = new String[infos.size()];
        values = new String[infos.size()];
        int i = 0;
        for (NameValueInfo info : infos) {
            names[i] = info.getName() == null ? null : (String) info.getName();
            values[i] = info.getValue().toString();
            i++;
        }
    }

    public String[] getNames() {
        return names;
    }

    public void setNames(String[] names) {
        this.names = names;
    }

    public String[] getValues() {
        return values;
    }

    public void setValues(String[] values) {
        this.values = values;
    }

}
