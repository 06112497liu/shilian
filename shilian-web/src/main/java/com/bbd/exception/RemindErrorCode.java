/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.exception;

import com.exception.ErrorCode;

/**
 *
 * @author tjwang
 * @version $Id: RemindErrorCode.java, v 0.1 2017/6/21 0021 16:33 tjwang Exp $
 */
public enum RemindErrorCode implements ErrorCode {

    AUTO_REMIND_SETTING_RUNDATE_ERROR(5001, "运行时间不能小于当前时间"),

    AUTO_REMIND_SETTING_ENABLE_RUNDATE_ERROR(5002, "运行时间小于当前时间不能启用"),

    AUTO_REMIND_SETTING_DELETE_ENABLE_ERROR(5003, "启用任务不能删除"),

    AUTO_REMIND_SETTING_DELEET_COMPLETE_ERROR(5004, "已完成任务不能删除"),

    AUTO_REMIND_SETTING_OP_COMPLETE_ERROR(5005, "已完成任务不能操作"),

    AUTO_REMIND_SETTING_DISABLE_RUNDATE_ERROR(5006, "运行时间小于当前时间不能禁用"),

    AUTO_REMIND_SETTING_OPERATION_RUNDATE_ERROR(5007, "操作对象不存在"),

    ;

    private int    status;
    private String message;

    RemindErrorCode(int status, String message) {
        this.status = status;
        this.message = message;
    }

    @Override
    public int getStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
