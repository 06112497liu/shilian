/**  
 * BBD Service Inc
 * All Rights Reserved @2016
 *
 */
package com.bbd.bean.statistics;

import io.swagger.annotations.ApiParam;

/**
 * 失联企业的统计信息.
 * @author zhanghui
 * @version $Id: LostCompanyAddrStaticInfo.java, v 0.1 2016年12月16日 下午5:18:30 zhanghui Exp $
 */
public class LostCompanyAddrStaticInfo extends NameValueNodeInfo {

    /***
     * 地址代码
     */
    @ApiParam("地址代码")
    private Integer code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
