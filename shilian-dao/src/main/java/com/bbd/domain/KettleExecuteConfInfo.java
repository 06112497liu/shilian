

/** * BBD Service Inc * All Rights Reserved @2017 * */
 package com.bbd.domain; 
/** * * @author xiongyun * @version $Id: KettleExecuteConfInfo.java, v 0.1 2017年6月7日 上午11:29:01 xiongyun Exp $ */
public class KettleExecuteConfInfo {
    
    private int id;
    
    private String executeParam;
    
    private String dataSource;
    
    private String executeType;
    
    private int dataFlag;
    
    private int executeSeq;
    
    private String executeFile;

    /** * Getter method for property . * * @return property value of id */
    
    public int getId() {
        return id;
    }

    /** * Setter method for property . * * @param id value to be assigned to property id */
    
    public void setId(int id) {
        this.id = id;
    }

  

    /** * Getter method for property . * * @return property value of executeSeq */
    
    public int getExecuteSeq() {
        return executeSeq;
    }

    /** * Setter method for property . * * @param executeSeq value to be assigned to property executeSeq */
    
    public void setExecuteSeq(int executeSeq) {
        this.executeSeq = executeSeq;
    }

    /** * Getter method for property . * * @return property value of executeParam */
    
    public String getExecuteParam() {
        return executeParam;
    }

    /** * Setter method for property . * * @param executeParam value to be assigned to property executeParam */
    
    public void setExecuteParam(String executeParam) {
        this.executeParam = executeParam;
    }

    /** * Getter method for property . * * @return property value of dataSource */
    
    public String getDataSource() {
        return dataSource;
    }

    /** * Setter method for property . * * @param dataSource value to be assigned to property dataSource */
    
    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    /** * Getter method for property . * * @return property value of executeType */
    
    public String getExecuteType() {
        return executeType;
    }

    /** * Setter method for property . * * @param executeType value to be assigned to property executeType */
    
    public void setExecuteType(String executeType) {
        this.executeType = executeType;
    }

    /** * Getter method for property . * * @return property value of dataFlag */
    
    public int getDataFlag() {
        return dataFlag;
    }

    /** * Setter method for property . * * @param dataFlag value to be assigned to property dataFlag */
    
    public void setDataFlag(int dataFlag) {
        this.dataFlag = dataFlag;
    }

    /** * Getter method for property . * * @return property value of executeFile */
    
    public String getExecuteFile() {
        return executeFile;
    }

    /** * Setter method for property . * * @param executeFile value to be assigned to property executeFile */
    
    public void setExecuteFile(String executeFile) {
        this.executeFile = executeFile;
    }

    
}

