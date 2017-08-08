/*
 * Copyright (c) BrandBigData.com Inc.
 * All Rights Reserved 2017.
 */

/**
 * BBD Service Inc
 * AllRight Reserved @2017
 */
package com.bbd.utils;

import com.bbd.excel.ExcelRowDateFormat;
import com.bbd.util.RelectUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 导出excel
 * 
 * @author xc
 * @version $Id: ExportExcelUtil.java, v 0.1 2016年12月5日 下午1:26:48 xc Exp $
 */
public class ExportExcelUtil {

    private static Logger logger = LoggerFactory.getLogger("excel");

    private static <T> HSSFWorkbook getHSSFWorkbook(List<T> list, Class modelClass, String fileName) throws Exception {
        Map<Integer, List<T>> sheetMap = resolveData(list);
        HSSFWorkbook wb = new HSSFWorkbook();
        Set<Integer> keys = sheetMap.keySet();
        List<String> rowNames = RelectUtil.getRowNames(modelClass);

        String format = "yyyy-MM-dd HH:mm:ss";

        ExcelRowDateFormat a = (ExcelRowDateFormat) modelClass.getAnnotation(ExcelRowDateFormat.class);
        if (a != null) {
            format = a.value();
        }

        for (Iterator<Integer> iterator = keys.iterator(); iterator.hasNext();) {
            Integer sheetKey = iterator.next();
            //HSSFSheet sheet = wb.createSheet((fileName + SheetKey).toString());
            HSSFSheet sheet = wb.createSheet(String.valueOf(sheetKey));
            HSSFRow rowName = sheet.createRow(0); // 第0行
            for (int i = 0; i < rowNames.size(); i++) {
                rowName.createCell((short) i).setCellValue(rowNames.get(i));
            }
            List<T> sheetRows = sheetMap.get(sheetKey);
            for (int i = 0; i < sheetRows.size(); i++) {
                T model = sheetRows.get(i);
                List<Object> dataList = RelectUtil.getValues(model);
                HSSFRow row = sheet.createRow(i + 1);
                for (int m = 0; m < dataList.size(); m++) {
                    Object obj = dataList.get(m);
                    String value;
                    if (obj instanceof Date) {
                        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
                        SimpleDateFormat sdf = new SimpleDateFormat(format);
                        value = sdf.format(obj);
                    } else {
                        value = obj.toString();
                    }
                    row.createCell(m).setCellValue(value);
                }
            }
        }
        return wb;
    }

    /**
     * 导出多张excel表,解决xls格式行数65535的限制
     * 
     * @param response
     * @param list
     * @param modelClass
     * @throws Exception
     */
    @SuppressWarnings({ "unchecked", "unused", "rawtypes" })
    public static <T> void doExcel(HttpServletResponse response, List<T> list, Class modelClass) throws Exception {
        logger.info("doExcel导出数量：" + list.size());
        logger.info("modelClass:" + modelClass.getName());
        OutputStream os = response.getOutputStream();//获取输出流 
        response.reset();
        String fileName = RelectUtil.getTitle(modelClass);
        // 设置下载头部信息。Content-disposition为属性名。attachment表示以附件方式下载，如果要在页面中打开，则改为inline。filename为文件名
        response.setHeader("Content-disposition", "attachment; filename=" + fileName + ".xls");
        response.setContentType(MediaType.APPLICATION_OCTET_STREAM.toString());

        Map<Integer, List<T>> sheetMap = resolveData(list);
        HSSFWorkbook wb = getHSSFWorkbook(list, modelClass, fileName);
        wb.write(os);
    }

    public static <T> void doExcel(List<T> list, Class modelClass, File file) {
        logger.info("doExcel导出数量：" + list.size());
        logger.info("modelClass:" + modelClass.getName());

        String fileName = file.getName();
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file, true);
            HSSFWorkbook wb = getHSSFWorkbook(list, modelClass, fileName);

            wb.write(fos);
            fos.close();
        } catch (Exception e) {
            logger.warn(e.getMessage(), e);
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
            }
        }
    }

    /**
     * 此方法将数据集合按65000个进行分割成多个子集合
     * 
     * @param list
     * @return
     */
    public static <T> Map<Integer, List<T>> resolveData(List<T> list) {
        int count = list.size() / 65000;
        int yu = list.size() % 65000;
        Map<Integer, List<T>> map = new HashMap<Integer, List<T>>();
        for (int i = 0; i <= count; i++) {
            List<T> subList = new ArrayList<T>();
            if (i == count) {
                subList = list.subList(i * 65000, 65000 * i + yu);
            } else {
                subList = list.subList(i * 65000, 65000 * (i + 1));
            }
            map.put(i, subList);
        }
        return map;
    }
}
