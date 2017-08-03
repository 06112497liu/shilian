/** 
 * BBD Service Inc 
 * All Rights Reserved @2017 
 */
package com.bbd.bean.statistics;

import io.swagger.annotations.ApiModelProperty;

/** 
 *  
 * @author liuweibo 
 * @version $Id: NameValueInfoExplore.java, v 0.1 2017年5月24日 下午1:47:18 liuweibo Exp $ 
 */
public class NameValueInfoExplore extends NameValueNodeInfo {

    /** 公司类型  */
    @ApiModelProperty("企业状态")
    private Integer companyState;

    public Integer getCompanyState() {
        return companyState;
    }

    public void setCompanyState(Integer companyState) {
        this.companyState = companyState;
    }
}
