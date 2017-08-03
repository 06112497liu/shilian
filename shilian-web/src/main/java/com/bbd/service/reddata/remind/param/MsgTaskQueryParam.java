/** 

 * BBD Service Inc 
 * All Rights Reserved @2017 
 */
 package com.bbd.service.reddata.remind.param;

/** 
 * 查询提示进度列表封装类
 * 
 * @author liuweibo 
 * @version $Id: MsgTaskQueryParam.java, v 0.1 2017年6月8日 下午3:31:16 liuweibo Exp $ 
 */
public class MsgTaskQueryParam {
    
    /** 企业的nbxh */
    private String nbxh;
    
    /** 提示类型（ 1.企业年报提示, 2.失联企业提示, 3.未年报企业提示, 4.未公示企业提示, 5.虚假信息企业提示  ） */
    private Integer taskType;
    
    /** 操作类型（  0.自动, 1.手动  ） */
    private Integer operationType;
    
    /** 提示方式（ 1.邮件, 2.短信, 3.语音  ） */
    private Integer method;
    
    /** 提示时间排序方式（ 1.降序, 2.升序 ） */
    private Integer order;
    
    /** 提示状态（ 1.未提示, 2.提示中, 3.提示成功, 4.提示失败 ） */
    private Integer status;
    
    public String getNbxh() {
        return nbxh;
    }

    public void setNbxh( String nbxh ) {
        this.nbxh = nbxh;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus( Integer status ) {
        this.status = status;
    }

    public Integer getTaskType() {
        return taskType;
    }

    public void setTaskType( Integer taskType ) {
        this.taskType = taskType;
    }

    public Integer getOperationType() {
        return operationType;
    }

    public void setOperationType( Integer operationType ) {
        this.operationType = operationType;
    }

    public Integer getMethod() {
        return method;
    }

    public void setMethod( Integer method ) {
        this.method = method;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder( Integer order ) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "MsgTaskQueryParam [taskType=" + taskType + ", operationType=" + operationType + ", method=" + method + ", order=" + order + "]";
    }
    
    
}

