/**  
 * BBD Service Inc
 * All Rights Reserved @2016
 *
 */
package com.bbd.bean.statistics;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * 企业的经营活动指数信息.
 * 
 * @author liuweibo
 * @version $Id: LostCompanyIndustryStatisticsInfo.java, v 0.1 2016年12月5日 下午1:04:03 liuweibo Exp $
 */
public class CompanyActiveIndexStatisticsInfo implements Serializable {

    /** 经营活动指数日期 */
    @ApiModelProperty("经营活动指数日期")
    private String[] names;

    /** 经营活动指数值 */
    @ApiModelProperty("经营活动指数值")
    private String[] values;

    public CompanyActiveIndexStatisticsInfo() {
    }

    /**
     * 数据列表转数组
     * @param 
     */
    public CompanyActiveIndexStatisticsInfo(List<NameValueInfo> infos) {
        names = new String[infos.size()];
        values = new String[infos.size()];
        int i = 0;
        for (NameValueInfo info : infos) {
            names[i] = info.getName() == null ? null : String.valueOf(info.getName());

            double value = Double.parseDouble((info.getValue().toString()));
            BigDecimal rateDecimal = BigDecimal.valueOf(value);

            values[i] = rateDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).toString();
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
