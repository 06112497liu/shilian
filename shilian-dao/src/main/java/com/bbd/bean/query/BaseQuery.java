/**  
 * BBD Service Inc
 * All Rights Reserved @2016
 *
 */
package com.bbd.bean.query;

import com.bbd.pagin.Pagination;

/**
 * 查询基础类
 * 
 * @author zhanghui
 * @version $Id: BaseQuery.java, v 0.1 2016年12月7日 上午10:28:09 zhanghui Exp $
 */
public class BaseQuery extends Pagination {

    /** 系统的类型 3.省  2.市 1.区 */
    private int type;

    /** 系统的地址 省、市、区的地址 */
    private int addr;

    public BaseQuery() {
        super();
    }

    /**
     * 权限查询基本构造.
     * 
     * @param type 权限类型.
     * @param addr 地址 省、市、区地址编码.
     */
    public BaseQuery(int type, int addr) {
        this();
        this.type = type;
        this.addr = addr;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getAddr() {
        return addr;
    }

    public void setAddr(int addr) {
        this.addr = addr;
    }
}
