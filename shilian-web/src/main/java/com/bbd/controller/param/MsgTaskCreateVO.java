/** 
 * BBD Service Inc 
 * All Rights Reserved @2017 
 */
package com.bbd.controller.param;

/**
 *  
 * @author liuweibo 
 * @version $Id: MsgTaskCreateVO.java, v 0.1 2017年6月13日 下午3:44:19 liuweibo Exp $ 
 */
public class MsgTaskCreateVO {

    /** 提示类型(1.企业年报提示,2.失联企业提示,3.未年报企业提示,4.未公示企业提示,5.虚假信息企业提示) */
    private Integer                     type;

    /** 提示方式(1.邮件,2.短信,3.语音) */
    private Integer                     method;

    /** 操作类型(0.系统,1.人工) */
    private Integer                     operationType;

    /**页面传入条件*/
    private MannualRemindConditionParam conditions;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getMethod() {
        return method;
    }

    public void setMethod(Integer method) {
        this.method = method;
    }

    public Integer getOperationType() {
        return operationType;
    }

    public void setOperationType(Integer operationType) {
        this.operationType = operationType;
    }

    public MannualRemindConditionParam getConditions() {
        return conditions;
    }

    public void setConditions(MannualRemindConditionParam conditions) {
        this.conditions = conditions;
    }

}
