/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd;

/**
 *
 * @author tjwang
 * @version $Id: Constants.java, v 0.1 2017/6/1 0001 15:27 tjwang Exp $
 */
public class Constants {

    public static final String GUIYANG_CODE     = "5201";
    public static final int    GUIYANG_CODE_NUM = 5201;

    //kettle-获取kettle文件配置参数名
    /** 批量提交数*/
    public static final String BATCH_COMMIT_NUM = "commitPerBatch";
    /** 导入mysql连接数*/
    public static final String IMPORT_CON_NUM   = "importConnections";
    /** 贵阳工商导出oracle连接数*/
    public static final String EXPORT_CON_NUM   = "exportConnections";
    /** 文件目录*/
    public static final String FILE_NAME        = "filePath";
    /** 配置记录ID*/
    public static final String KETTLE_CONF_ID   = "kettleConfId";
    /** 数据平台请求URL*/
    public static final String SEND_URL         = "dataPlatFormCompanySendUrl";

    public static final String SUCCESS          = "1";
    public static final String FAIL             = "0";

}
