/**
 * BBD Service Inc
 * All Rights Reserved @2017
 */
package com.bbd.bean.remind;

import java.util.Date;

/**
 *
 * @author wangwei
 * @version $Id RemindCompanyInfo.java, v 0.1 2017/5/5 16:12 wangwei Exp $
 */
public class RemindCompany {

    private Integer queueId;

    /**
     * 任务号
     */
    private Integer taskId;

    /**
     * 企业内部序号
     */
    private String  nbxh;
    /**
     * 提示   1 企业年报提示    2  失联企业提示   3  未年报企业提示   4未公示企业提示  5  虚假信息企业提示
     */
    private int     type;
    /**
     * 提示方式  1  邮件  2  短信  3   语音
     */
    private int     method;

    /**
     * 操作类型 0:系统、1:人工
     */
    private int     operateType;
    /**
     * 计划提示日期
     */
    private Date    planDate;

    /**
     * 电子邮箱  可以有多个中间有英文半角逗号分割
     */
    private String  emails;
    /**
     *通讯电话  有多个中间有英文半角逗号分割
     */
    private String  phones;

    /**
     *公司名称
     */
    private String  companyName;

    /**
     * 操作者
     */
    private String  district;

    public Integer getQueueId() {
        return queueId;
    }

    public void setQueueId(Integer queueId) {
        this.queueId = queueId;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public String getNbxh() {
        return nbxh;
    }

    public void setNbxh(String nbxh) {
        this.nbxh = nbxh;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getMethod() {
        return method;
    }

    public void setMethod(int method) {
        this.method = method;
    }

    public int getOperateType() {
        return operateType;
    }

    public void setOperateType(int operateType) {
        this.operateType = operateType;
    }

    public Date getPlanDate() {
        return planDate;
    }

    public void setPlanDate(Date planDate) {
        this.planDate = planDate;
    }

    public String getEmails() {
        return emails;
    }

    public void setEmails(String emails) {
        this.emails = emails;
    }

    public String getPhones() {
        return phones;
    }

    public void setPhones(String phones) {
        this.phones = phones;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }
}
