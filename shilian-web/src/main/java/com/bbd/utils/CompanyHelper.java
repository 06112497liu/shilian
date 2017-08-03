/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.utils;

import com.bbd.common.CompanyConstants;

/**
 * 企业工具类
 * @author tjwang
 * @version $Id: CompanyHelper.java, v 0.1 2017/6/19 0019 14:30 tjwang Exp $
 */
public class CompanyHelper {

    /**
     * 是否已年报
     * @param abnormalStatus
     * @return
     */
    public static boolean isUnannualed(Integer abnormalStatus) {
        return abnormalStatus / CompanyConstants.UNANNUALED % 2 == 1;
    }

    /**
     * 是否已公示
     * @param abnormalStatus
     * @return
     */
    public static boolean isUnpublish(Integer abnormalStatus) {
        return abnormalStatus / CompanyConstants.UNPUBLISHED % 2 == 1;
    }

    /**
     * 是否是虚假信息
     * @param abnormalStatus
     * @return
     */
    public static boolean isFake(Integer abnormalStatus) {
        return abnormalStatus / CompanyConstants.FAKE % 2 == 1;
    }

    /**
     * 是否失联
     * @param abnormalStatus
     * @return
     */
    public static boolean isLost(Integer abnormalStatus) {
        return abnormalStatus / CompanyConstants.LOST % 2 == 1;
    }
}
