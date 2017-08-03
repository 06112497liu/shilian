/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.common;

/**
 * 结果状态常量
 *
 * @author yujiahao
 * @version $Id: ResultConst.java, v 0.1 2016年12月30日 下午2:07:03 yujiahao Exp $
 */
public class ResultConst {

    public static final int    ZERO_STATUS                  = 0;
    /**
     * 待提示  原代码暂保留
     */
    public static final int    WAIT_STATUS                  = 1;

    /**
     * 提示中   原代码暂保留
     */
    public static final int    REMINDING_STATUS             = 2;

    /**
     * 未提示
     */
    public static final int    NOT_REMIND                   = 1;

    /**
     * 已提示
     */
    public static final int    HAS_REMIND                   = 2;

    /**
     * 提示成功
     */
    public static final int    SUCCESS_STATUS               = 3;

    /**
     * 提示失败
     */
    public static final int    FAIL_STATUS                  = 4;

    /**
     * 没有邮件
     */
    public static final String EMAIL_MESSAGE                = "没有邮箱";

    /**
     * 没有邮箱
     */
    public static final String NO_EMAILADDRESS              = "没有邮箱或无有效邮箱";

    /**
     * 邮箱格式无效
     */
    public static final String NOT_VALIDEMAIL               = "邮箱格式不正确";

    /**
     * 没有电话
     */
    public static final String PHONE_MESSAGE                = "没有电话号码";
    /**
     * 没有电话
     */
    public static final String NO_PHONENUM                  = "没有电话号码或无有效电话号码";
    /**
     * 电话号码无效
     */
    public static final String NOT_VALID_PHONENUM           = "电话号码格式不对";

    /**
     * 000000
     */
    public static final String RESULT_STATUS                = "000000";

    /**
     * 邮箱日配额超限
     */
    public static final String EMAIL_EXCEPTION_OUT_OF_LIMIT = "554";

    public static final String NO_EMAIL_CONTENT_MATCH       = "无法找到对应的邮箱主题或内容";

    public static final String NO_SMS_CONTENT_MATCH         = "无法找到对应的短信模板ID";

}
