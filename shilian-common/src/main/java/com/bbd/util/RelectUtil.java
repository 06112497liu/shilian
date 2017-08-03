/**
 * BBD Service Inc
 * AllRight Reserved @2017
 */
package com.bbd.util;

import com.bbd.excel.ExcelRow;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * excel属性处理
 * 
 * @author xc
 * @version $Id: RelectUtil.java, v 0.1 2016年12月5日 下午1:27:13 xc Exp $
 */
public class RelectUtil {
    /**
     * 获取行的名称
     * 
     * @param modelClass
     * @return
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     * @throws InvocationTargetException
     * @throws SecurityException
     * @throws NoSuchFieldException
     */
    public static <T> List<String> getRowNames(Class<T> modelClass) throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, SecurityException,
                                                                   NoSuchFieldException {
        List<String> list = new ArrayList<String>();
        Field[] field = modelClass.getDeclaredFields(); //获取实体类的所有属性，返回Field数组  
        for (int j = 0; j < field.length; j++) { //遍历所有属性
            ExcelRow excelRow = field[j].getAnnotation(ExcelRow.class);
            if (excelRow != null) {
                list.add(excelRow.value());
            }
        }
        return list;
    }

    /**
     * 获取文件名称
     * 
     * @param modelClass
     * @return
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     * @throws InvocationTargetException
     * @throws SecurityException
     * @throws NoSuchFieldException
     */
    public static <T> String getTitle(Class<T> modelClass) throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, SecurityException,
                                                          NoSuchFieldException {
        //        ExcelTitle excelTitle = modelClass.getAnnotation(ExcelTitle.class);
        //        return excelTitle.value();
        return DateUtil.formatDateByPatten(new Date(), "yyyyMMddHHmmss");
    }

    public static String getTitle(String prefix, String suffix) {
        String time = DateUtil.formatDateByPatten(new Date(), "yyyyMMddHHmmss");
        return prefix + "_" + time + "." + suffix;
    }

    /**
     * 值得获取
     * 
     * @param model
     * @return
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     * @throws InvocationTargetException
     * @throws SecurityException
     * @throws NoSuchFieldException
     */
    public static <T> List<Object> getValues(T model) throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, SecurityException,
                                                     NoSuchFieldException {
        List<Object> list = new ArrayList<Object>();
        Field[] field = model.getClass().getDeclaredFields(); //获取实体类的所有属性，返回Field数组  
        for (int j = 0; j < field.length; j++) { //遍历所有属性
            String nam = field[j].getName(); //获取属性的名字
            String name = nam;
            name = name.substring(0, 1).toUpperCase() + name.substring(1);
            String type = field[j].getGenericType().toString(); //获取属性的类型
            ExcelRow excelRow = field[j].getAnnotation(ExcelRow.class);
            if (excelRow != null) {
                if (type.equals("class java.lang.String")) { //如果type是类类型，则前面包含"class "，后面跟类名
                    Method m = model.getClass().getMethod("get" + name);
                    String value = (String) m.invoke(model); //调用getter方法获取属性值
                    if (value != null) {
                        list.add(value);
                    } else {
                        list.add("");
                    }
                }

                if (type.equals("class java.lang.Integer")) {
                    Method m = model.getClass().getMethod("get" + name);
                    Integer value = (Integer) m.invoke(model);
                    if (value != null) {
                        list.add(value);
                    } else {
                        list.add("");
                    }
                }

                if (type.equals("class java.lang.Short")) {
                    Method m = model.getClass().getMethod("get" + name);
                    Short value = (Short) m.invoke(model);
                    if (value != null) {
                        list.add(value);
                    } else {
                        list.add("");
                    }
                }

                if (type.equals("class java.lang.Double")) {
                    Method m = model.getClass().getMethod("get" + name);
                    Double value = (Double) m.invoke(model);
                    if (value != null) {
                        list.add(value);
                    } else {
                        list.add("");
                    }
                }

                if (type.equals("class java.lang.Boolean")) {
                    Method m = model.getClass().getMethod("get" + name);
                    Boolean value = (Boolean) m.invoke(model);
                    if (value != null) {
                        list.add(value);
                    } else {
                        list.add("");
                    }
                }

                if (type.equals("class java.util.Date")) {
                    Method m = model.getClass().getMethod("get" + name);
                    Date value = (Date) m.invoke(model);
                    if (value != null) {
                        list.add(value);
                    } else {
                        list.add("");
                    }
                }
            }
        }
        return list;
    }

}
