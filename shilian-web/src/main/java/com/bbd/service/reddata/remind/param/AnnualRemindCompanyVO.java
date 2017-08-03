/** 
 * BBD Service Inc 
 * All Rights Reserved @2017 
 */
package com.bbd.service.reddata.remind.param;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/** 
 *  
 * @author liuweibo 
 * @version $Id: RemindCompanyVO.java, v 0.1 2017年6月13日 上午10:31:18 liuweibo Exp $
 */
@ApiModel("企业年报提示返回对象")
public class AnnualRemindCompanyVO extends RemindCompanyVO {

    @ApiModelProperty("上次年报时间")
    @JsonFormat(pattern = "yyyy年MM月dd日HH时mm分", timezone = "GMT+8")
    private Date lastAnnualTime;

    public Date getLastAnnualTime() {
        return lastAnnualTime;
    }

    public void setLastAnnualTime(Date lastAnnualTime) {
        this.lastAnnualTime = lastAnnualTime;
    }
}
