/*
 * Copyright (c) BrandBigData.com Inc.
 * All Rights Reserved 2017.
 */

package com.bbd.utils;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.*;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.util.ResourceUtils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/** 
 * 适用于docx
 * poi 版本 3.15 
 */
public class WordUtil {
    private static final Logger logger = LoggerFactory.getLogger(WordUtil.class);

    /** 
     * 根据指定的参数值、模板，生成 word 文档 
     * @param param 需要替换的变量 
     * @param template 模板 
     */
    public static XWPFDocument generateWord(Map<String, Object> param, String template) {
        XWPFDocument doc = null;
        try {
            OPCPackage pack = OPCPackage.open(ResourceUtils.getFile("classpath:" + template));
            doc = new XWPFDocument(pack);
            if (param != null && param.size() > 0) {

                //处理段落  
                List<XWPFParagraph> paragraphList = doc.getParagraphs();
                processParagraphs(paragraphList, param, doc);

                //处理表格  
                Iterator<XWPFTable> it = doc.getTablesIterator();
                while (it.hasNext()) {
                    XWPFTable table = it.next();
                    List<XWPFTableRow> rows = table.getRows();
                    for (XWPFTableRow row : rows) {
                        List<XWPFTableCell> cells = row.getTableCells();
                        for (XWPFTableCell cell : cells) {
                            List<XWPFParagraph> paragraphListTable = cell.getParagraphs();
                            processParagraphs(paragraphListTable, param, doc);
                        }
                    }
                }
            }
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
        }
        return doc;
    }

    /** 
     * 处理段落 
     * @param paragraphList 
     */
    public static void processParagraphs(List<XWPFParagraph> paragraphList, Map<String, Object> param, XWPFDocument doc) {
        if (paragraphList != null && paragraphList.size() > 0) {

            for (XWPFParagraph paragraph : paragraphList) {

                String pText = paragraph.getText();

                for (Entry<String, Object> entry : param.entrySet()) {
                    String key = entry.getKey();
                    // 段落只有一行 一个run
                    if (pText.indexOf(key) != -1 && entry.getValue() instanceof List && paragraph.getRuns().size() == 1) {
                        XWPFRun xwpfRun = paragraph.getRuns().get(0);
                        List list = (List) entry.getValue();
                        for (int i = 0; i < list.size(); i++) {
                            xwpfRun.getCTR().addNewBr();
                            xwpfRun.getCTR().addNewT().setStringValue(list.get(i).toString());
                            ;
                        }
                        xwpfRun.getCTR().removeT(0);
                        continue;
                    }
                }

                List<XWPFRun> runs = paragraph.getRuns();
                Iterator<XWPFRun> iterator = runs.iterator();
                while (iterator.hasNext()) {
                    XWPFRun run = iterator.next();
                    String text = run.getText(0);
                    if (text != null) {
                        boolean isSetText = false;
                        for (Entry<String, Object> entry : param.entrySet()) {
                            String key = entry.getKey();
                            if (text.indexOf(key) != -1) {
                                isSetText = true;
                                Object value = entry.getValue();
                                if (value instanceof String) {//文本替换  
                                    text = text.replace(key, value.toString());
                                } else if (value instanceof Map) {//图片替换  
                                    text = text.replace(key, "");
                                    Map pic = (Map) value;
                                    int width = Integer.parseInt(pic.get("width").toString());
                                    int height = Integer.parseInt(pic.get("height").toString());
                                    int picType = getPictureType(pic.get("type").toString());
                                    byte[] byteArray = (byte[]) pic.get("content");
                                    ByteArrayInputStream byteInputStream = new ByteArrayInputStream(byteArray);
                                    try {
                                        run.addPicture(byteInputStream, picType, "", Units.toEMU(width), Units.toEMU(height));
                                    } catch (InvalidFormatException e) {
                                        logger.error(e.getMessage(),e);
                                    } catch (IOException e) {
                                        logger.error(e.getMessage(),e);
                                    }
                                }
                            }
                            if (isSetText) {
                                run.setText(text, 0);
                            }
                        }
                    }
                }
            }
        }
    }

    /** 
     * 根据图片类型，取得对应的图片类型代码 
     * @return int
     */
    private static int getPictureType(String imgFile) {
        int format = XWPFDocument.PICTURE_TYPE_PNG;

        if (imgFile.equals("emf"))
            format = XWPFDocument.PICTURE_TYPE_EMF;
        else if (imgFile.equals("wmf"))
            format = XWPFDocument.PICTURE_TYPE_WMF;
        else if (imgFile.equals("pict"))
            format = XWPFDocument.PICTURE_TYPE_PICT;
        else if (imgFile.equals("jpeg") || imgFile.equals("jpg"))
            format = XWPFDocument.PICTURE_TYPE_JPEG;
        else if (imgFile.equals("png"))
            format = XWPFDocument.PICTURE_TYPE_PNG;
        else if (imgFile.equals("dib"))
            format = XWPFDocument.PICTURE_TYPE_DIB;
        else if (imgFile.equals("gif"))
            format = XWPFDocument.PICTURE_TYPE_GIF;
        else if (imgFile.equals("tiff"))
            format = XWPFDocument.PICTURE_TYPE_TIFF;
        else if (imgFile.equals("eps"))
            format = XWPFDocument.PICTURE_TYPE_EPS;
        else if (imgFile.equals("bmp"))
            format = XWPFDocument.PICTURE_TYPE_BMP;
        else if (imgFile.equals("wpg"))
            format = XWPFDocument.PICTURE_TYPE_WPG;
        else {
            throw new RuntimeException("Unsupported picture: " + imgFile + ". Expected emf|wmf|pict|jpeg|png|dib|gif|tiff|eps|bmp|wpg");
        }
        return format;
    }
    
}
