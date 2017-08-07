/**  
 * BBD Service Inc
 * All Rights Reserved @2016
 *
 */
package com.bbd.service.reddata.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

/**
 * BBD远程调用返回结果
 * 
 * @author tjwang
 * @version $Id: ResultInfo.java, v 0.1 2017年6月14日 上午9:58:53 tjwang Exp $
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BBDResultInfoVO implements Serializable {

    /** 错误码 */
    private String                        err_code;

    /** 消息 */
    private String                        msg;

    /** 数据结果 */
    private transient List<HashMap<String, Object>> results;

    /** 当前返回的数据条数 */
    private String                        rsize;

    /** 总的数据的条数 */
    private String                        total;

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

}
