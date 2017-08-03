/*
 * Copyright (c) BrandBigData.com Inc.
 * All Rights Reserved 2017.
 */

package com.bbd.enums;

/**
 * @author fisher
 * @version $Id: EnumInterface.java, v 0.1 2017/5/2 17:02 fisher Exp $
 */
public interface EnumInterface {

    /**
     * 获取枚举中定义的值
     *
     * @return 枚举代码
     */
    public String getCode();

    /**
     * 获取枚举中定义的备注信息
     *
     * @return 枚举代码描述
     */
    public String getDesc();
}
