/**
 * BBD Service Inc
 * AllRight Reserved @2017
 */
package com.bbd.util;

import com.google.gson.Gson;

import java.lang.reflect.Type;

/**
 * gson
 * 
 * @author xc
 * @version $Id: GsonUtil.java, v 0.1 2016年12月5日 下午1:23:14 xc Exp $
 */
public class GsonUtil {

    private static Gson gson = new Gson();

    /**
     * json转string
     * 
     * @param obj
     * @param type
     * @return
     */
    public static String toJson(Object obj, Type type) {
        return gson.toJson(obj, type);
    }

    public static String toJson(Object obj) {
        return gson.toJson(obj);
    }

    /**
     * String转json
     * 
     * @param str
     * @param type
     * @return
     */
    public static Object fromJson(String str, Type type) {
        return gson.fromJson(str, type);
    }
}
