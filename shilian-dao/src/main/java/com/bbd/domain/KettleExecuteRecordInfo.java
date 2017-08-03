

/** * BBD Service Inc * All Rights Reserved @2017 * */
 package com.bbd.domain; 

import java.util.Date;

/** * * @author xiongyun * @version $Id: KettleExecuteRecordInfo.java, v 0.1 2017年6月6日 下午5:05:52 xiongyun Exp $ */
public class KettleExecuteRecordInfo {

    private int id;
    
    private String objectName;
    
    private int objectType;
    
    private Date executeBeginTime;
    
    private Date executeEndTime;
    
    private String executeStatus;
    
    private int resultSetCount;
    
    private String mark;
    
    private int dataFlag;
    
    private int objectId;
    
    
    /** * Getter method for property . * * @return property value of id */
    
    public int getId() {
        return id;
    }

    /** * Setter method for property . * * @param id value to be assigned to property id */
    
    public void setId(int id) {
        this.id = id;
    }

    /** * Getter method for property . * * @return property value of objectName */
    
    public String getObjectName() {
        return objectName;
    }

    /** * Setter method for property . * * @param objectName value to be assigned to property objectName */
    
    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    /** * Getter method for property . * * @return property value of objectType */
    
    public int getObjectType() {
        return objectType;
    }

    /** * Setter method for property . * * @param objectType value to be assigned to property objectType */
    
    public void setObjectType(int objectType) {
        this.objectType = objectType;
    }

    /** * Getter method for property . * * @return property value of executeBeginTime */
    
    public Date getExecuteBeginTime() {
        return executeBeginTime;
    }

    /** * Setter method for property . * * @param executeBeginTime value to be assigned to property executeBeginTime */
    
    public void setExecuteBeginTime(Date executeBeginTime) {
        this.executeBeginTime = executeBeginTime;
    }

    /** * Getter method for property . * * @return property value of executeEndTime */
    
    public Date getExecuteEndTime() {
        return executeEndTime;
    }

    /** * Setter method for property . * * @param executeEndTime value to be assigned to property executeEndTime */
    
    public void setExecuteEndTime(Date executeEndTime) {
        this.executeEndTime = executeEndTime;
    }

    /** * Getter method for property . * * @return property value of executeStatus */
    
    public String getExecuteStatus() {
        return executeStatus;
    }

    /** * Setter method for property . * * @param executeStatus value to be assigned to property executeStatus */
    
    public void setExecuteStatus(String executeStatus) {
        this.executeStatus = executeStatus;
    }

    /** * Getter method for property . * * @return property value of resultSetCount */
    
    public int getResultSetCount() {
        return resultSetCount;
    }

    /** * Setter method for property . * * @param resultSetCount value to be assigned to property resultSetCount */
    
    public void setResultSetCount(int resultSetCount) {
        this.resultSetCount = resultSetCount;
    }

    /** * Getter method for property . * * @return property value of mark */
    
    public String getMark() {
        return mark;
    }

    /** * Setter method for property . * * @param mark value to be assigned to property mark */
    
    public void setMark(String mark) {
        this.mark = mark;
    }

    /** * Getter method for property . * * @return property value of dataFlag */
    
    public int getDataFlag() {
        return dataFlag;
    }

    /** * Setter method for property . * * @param dataFlag value to be assigned to property dataFlag */
    
    public void setDataFlag(int dataFlag) {
        this.dataFlag = dataFlag;
    }

    /** * Getter method for property . * * @return property value of objectId */
    
    public int getObjectId() {
        return objectId;
    }

    /** * Setter method for property . * * @param objectId value to be assigned to property objectId */
    
    public void setObjectId(int objectId) {
        this.objectId = objectId;
    }

   
    
}

