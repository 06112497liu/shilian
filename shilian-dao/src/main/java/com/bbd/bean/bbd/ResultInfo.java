/**  
 * BBD Service Inc
 * All Rights Reserved @2016
 *
 */
package com.bbd.bean.bbd;

import java.util.HashMap;
import java.util.List;

/**
 * 调用失联企业经营活动接口的返回信息.
 * 
 * @author zhanghui
 * @version $Id: ResultInfo.java, v 0.1 2016年12月14日 上午9:58:53 zhanghui Exp $
 */
public class ResultInfo {

    /** 错误码 */
    private String                        err_code;

    /** 消息 */
    private String                        msg;

    /** 数据结果 */
    private List<HashMap<String, Object>> results;

    /** 当前返回的数据条数 */
    private String                        rsize;

    /** 总的数据的条数 */
    private String                        total;

    /**
     * 查询的月份
     */
    private String                        queryMonth;

    public String getErr_code() {
        return err_code;
    }

    public void setErr_code(String err_code) {
        this.err_code = err_code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<HashMap<String, Object>> getResults() {
        return results;
    }

    public void setResults(List<HashMap<String, Object>> results) {
        this.results = results;
    }

    public String getRsize() {
        return rsize;
    }

    public void setRsize(String rsize) {
        this.rsize = rsize;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "ResultInfo [err_code=" + err_code + ", msg=" + msg + ", results=" + results + ", rsize=" + rsize + ", total=" + total + "]";
    }

    /**
     * Getter method for property <tt>queryMonth</tt>.
     * 
     * @return property value of queryMonth
     */
    public String getQueryMonth() {
        return queryMonth;
    }

    /**
     * Setter method for property <tt>queryMonth</tt>.
     * 
     * @param queryMonth value to be assigned to property queryMonth
     */
    public void setQueryMonth(String queryMonth) {
        this.queryMonth = queryMonth;
    }
}
