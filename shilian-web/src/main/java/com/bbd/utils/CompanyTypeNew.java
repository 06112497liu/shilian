/**  
 * BBD Service Inc
 * All Rights Reserved @2016
 *
 */
package com.bbd.utils;

/**
 * 失联企业的类型.
 * 
 * @author zhanghui
 * @version $Id: CompanyType.java, v 0.1 2016年12月26日 上午11:16:07 zhanghui Exp $
 */
public class CompanyTypeNew {
    /** 私营企业 */
    public static final int    PRIVATE        = 1;

    public static final String PRIVATE_CN     = "民营企业";

    /** 国有企业及其他 */
    public static final int    STATE_OWNED    = 2;

    public static final String STATE_OWNED_CN = "国有企业";

    /** 外商及外商投资 */
    public static final int    FOREIGN        = 3;

    public static final String FOREIGN_CN     = "外资企业";

    public static final int    OTHER          = 4;
    /** 其他 */
    public static final String OTHER_CN       = "集体企业及其他 ";

    public static final String getTypeCN(int type) {
        String str = OTHER_CN;
        switch (type) {
            case PRIVATE:
                str = PRIVATE_CN;
                break;
            case STATE_OWNED:
                str = STATE_OWNED_CN;
                break;
            case FOREIGN:
                str = FOREIGN_CN;
                break;
        }
        return str;
    }
}
