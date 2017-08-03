package com.bbd.excel;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 
 * <p>Title:EModel</p>
 * @author xc
 * @version	v1.0
 * <p>Date:2016年11月25日下午5:38:35</p>
 * <p>Description:TODO</p>
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface ExcelRow {
    String value();
}
