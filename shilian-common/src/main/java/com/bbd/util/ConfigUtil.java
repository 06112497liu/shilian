/**
 * BBD Service Inc
 * AllRight Reserved @2017
 */
package com.bbd.util;

import com.bbd.spring.SpringContextHolder;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.MessageFormat;
import java.util.List;
import java.util.Properties;

/**
 * 配置文件
 *
 * @author xc
 * @version $Id: ConfigUtil.java, v 0.1 2016年12月5日 下午1:22:52 xc Exp $
 */
public class ConfigUtil {

    private static final Logger logger    = LoggerFactory.getLogger(ConfigUtil.class);

    private static final String BEAN_NAME = "propertiesConfig";
    /**
     * 百度地图ak列表
     */
    private static List<String> BD_AKS;
    /**
     * 百度地图ak
     */
    private static String       BD_AK;
    /**
     * 　百度地图地址解析url
     */
    private static String       BD_ADDRESS_PARSE_URL;
    /**
     * BBD ak
     */
    private static String       BBD_AK;
    /**
     * 　BBD地址解析url
     */
    private static String       BBD_ADDR_PARSE_URL;
    /**
     * 服务其地址
     */
    private static String       REDDATA_LOCAL_DOMAIN;
    /**
     * 邮箱年报提醒 主题
     */
    private static String       MAIL_ANNUL_SUBJECT;
    /**
     * 邮箱年失联醒 主题
     */
    private static String       MAIL_LOSTCOMPANYL_SUBJECT;
    /**
     * 邮件内容
     */
    private static String       MAIL_ANNUAL_CONTENT;
    /**
     * 年报提示短信模板
     */
    private static String       SMS_TEMPLATE_CODE_ANNUAL_PROMPT;
    /**
     * 年报提示语音模板
     */
    private static String       VMS_TEMPLATE_CODE_ANNUAL_PROMPT;
    /**
     * 年报语音提示内容
     */
    private static String       VMS_ANNUAL_CONTENT;
    /**
     * 年报语音自动提示回调地址
     */
    private static String       AUTO_VMS_ANNUAL_RESP_URL;
    /**
     * 年报语音手动提示回调地址
     */
    private static String       MANUAL_VMS_ANNUAL_RESP_URL;
    /**
     * 失联邮件内容
     */
    private static String       MAIL_LOST_CONTENT;
    /**
     * 失联企业短信模板
     */
    private static String       SMS_TEMPLATE_CODE_LOST_PROMPT;
    /**
     * 失联企业语音模板
     */
    private static String       VMS_TEMPLATE_CODE_LOST_PROMPT;
    /**
     * 失联语音提示内容
     */
    private static String       VMS_LOST_CONTENT;
    /**
     * 失联语音自动提示回调
     */
    private static String       AUTO_VMS_LOST_RESP_URL;
    /**
     * 失联语音手动提示回调
     */
    private static String       MANUAL_VMS_LOST_RESP_URL;
    /**
     * 邮箱
     */
    private static String       MAIL_SERVER_HOST;
    /**
     * 邮箱端口
     */
    private static String       MAIL_SERVER_PORT;
    /**
     * 邮箱用户和密码
     */
    private static String       SERVER_USER_NAME_AND_PASS_WORD;
    /**
     * 系统的类型 省市区
     */
    private static int          SYSTEM_TYPE;
    /**
     * 系统的地址
     */
    private static String       SYSTEM_ADDR;
    private static String       ES_CLUSTER_NAME;
    /**
     * es地址
     */
    private static String       ES_HOST;
    private static int          ES_PORT;
    /**
     * alidayu
     */

    private static String       ALIDAYU_URL;
    private static String       ALIDAYU_APPKEY;
    // 地图
    private static String       ALIDAYU_SECRET;
    /*
     * sms
     */
    private static String       SMS_SIGN;
    private static String       SMS_TYPE;
    private static String       VMS_CALLED_SHOW_NUMBER;

    /**
     * kettle参数
     * */
    private static String       KETTLE_JNDI_ROOT;
    private static String       KETTLE_LIB_HOME;

    /**
     * kafka 增量或者全量标识 增量true全量false
     * */
    private static String       KAFKA_DATA_TYPE;

    /**
     *DataShare获取三度关联方文件路径
     * */
    private static String       DATASHARE_PATH;

    public static String getJobLocalDomain() {

        if (StringUtils.isBlank(REDDATA_LOCAL_DOMAIN)) {
            Properties props = (Properties) SpringContextHolder.getApplicationContext().getBean(BEAN_NAME);
            REDDATA_LOCAL_DOMAIN = props.getProperty("reddata_local_domain").trim();
        }
        return REDDATA_LOCAL_DOMAIN;
    }

    public static String getMailServerHost() {
        if (StringUtils.isBlank(MAIL_SERVER_HOST)) {
            Properties props = (Properties) SpringContextHolder.getApplicationContext().getBean(BEAN_NAME);
            MAIL_SERVER_HOST = props.getProperty("mail_server_host").trim();
        }
        return MAIL_SERVER_HOST;
    }

    public static String getMailServerPort() {
        if (StringUtils.isBlank(MAIL_SERVER_PORT)) {
            Properties props = (Properties) SpringContextHolder.getApplicationContext().getBean(BEAN_NAME);
            MAIL_SERVER_PORT = props.getProperty("mail_server_port").trim();
        }
        return MAIL_SERVER_PORT;
    }

    public static String getAutoVmsAnnualRespUrl() {
        if (StringUtils.isBlank(AUTO_VMS_ANNUAL_RESP_URL)) {
            Properties props = (Properties) SpringContextHolder.getApplicationContext().getBean(BEAN_NAME);
            AUTO_VMS_ANNUAL_RESP_URL = props.getProperty("auto_vms_annual_resp_url").trim();
        }
        return getJobLocalDomain() + AUTO_VMS_ANNUAL_RESP_URL;
    }

    public static String getManualVmsAnnualRespUrl() {
        if (StringUtils.isBlank(MANUAL_VMS_ANNUAL_RESP_URL)) {
            Properties props = (Properties) SpringContextHolder.getApplicationContext().getBean(BEAN_NAME);
            MANUAL_VMS_ANNUAL_RESP_URL = props.getProperty("manual_vms_annual_resp_url").trim();
        }
        return getJobLocalDomain() + MANUAL_VMS_ANNUAL_RESP_URL;
    }

    public static String getVmsAnnualContent() {
        if (StringUtils.isBlank(VMS_ANNUAL_CONTENT)) {
            Properties props = (Properties) SpringContextHolder.getApplicationContext().getBean(BEAN_NAME);
            VMS_ANNUAL_CONTENT = props.getProperty("vms_annual_content");
        }
        return VMS_ANNUAL_CONTENT;
    }

    public static String getVmsAnnualContent(String companyName) {
        return MessageFormat.format(getVmsAnnualContent(), getSystemAddr(), companyName, DateUtil.getLastYearEndDayString(), DateUtil.getYearSixMonthEndDayString());
    }

    public static String getAutoVmsLostRespUrl() {
        if (StringUtils.isBlank(AUTO_VMS_LOST_RESP_URL)) {
            Properties props = (Properties) SpringContextHolder.getApplicationContext().getBean(BEAN_NAME);
            AUTO_VMS_LOST_RESP_URL = props.getProperty("auto_vms_lost_resp_url").trim();
        }
        return getJobLocalDomain() + AUTO_VMS_LOST_RESP_URL;
    }

    public static String getManualVmsLostRespUrl() {
        if (StringUtils.isBlank(MANUAL_VMS_LOST_RESP_URL)) {
            Properties props = (Properties) SpringContextHolder.getApplicationContext().getBean(BEAN_NAME);
            MANUAL_VMS_LOST_RESP_URL = props.getProperty("manual_vms_lost_resp_url").trim();
        }
        return getJobLocalDomain() + MANUAL_VMS_LOST_RESP_URL;
    }

    public static String getMailAnnulSubject() {
        if (StringUtils.isBlank(MAIL_ANNUL_SUBJECT)) {
            Properties props = (Properties) SpringContextHolder.getApplicationContext().getBean(BEAN_NAME);
            try {
                MAIL_ANNUL_SUBJECT = props.getProperty("mail_annual_subject").trim();
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
            }
        }
        return MAIL_ANNUL_SUBJECT;
    }

    public static String getMailLostCompanySubject() {
        if (StringUtils.isBlank(MAIL_LOSTCOMPANYL_SUBJECT)) {
            Properties props = (Properties) SpringContextHolder.getApplicationContext().getBean(BEAN_NAME);
            try {
                MAIL_LOSTCOMPANYL_SUBJECT = props.getProperty("mail_lostcompany_subject");
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
            }
        }
        return MAIL_LOSTCOMPANYL_SUBJECT;
    }

    public static String getVmsLostContent() {
        if (StringUtils.isBlank(VMS_LOST_CONTENT)) {
            Properties props = (Properties) SpringContextHolder.getApplicationContext().getBean(BEAN_NAME);
            try {
                VMS_LOST_CONTENT = props.getProperty("vms_lost_content").trim();
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
            }
        }
        return VMS_LOST_CONTENT;
    }

    public static String getSmsTemplateCodeAnnualPrompt() {
        if (StringUtils.isBlank(SMS_TEMPLATE_CODE_ANNUAL_PROMPT)) {
            Properties props = (Properties) SpringContextHolder.getApplicationContext().getBean(BEAN_NAME);
            SMS_TEMPLATE_CODE_ANNUAL_PROMPT = props.getProperty("sms_template_code_annual_prompt").trim();
        }

        return SMS_TEMPLATE_CODE_ANNUAL_PROMPT;
    }

    public static String getMailAnnualContent() {
        Properties props = (Properties) SpringContextHolder.getApplicationContext().getBean(BEAN_NAME);
        try {
            MAIL_ANNUAL_CONTENT = props.getProperty("mail_annual_content");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return MAIL_ANNUAL_CONTENT;
    }

    public static String getMailAnnualContent(String companyName) {
        return MessageFormat.format(getMailAnnualContent(), getSystemAddr(), getSystemAddr(), companyName, DateUtil.getLastYearEndDayString(), DateUtil.getYearSixMonthEndDayString());
    }

    public static String getMailLostContent() {
        if (StringUtils.isBlank(MAIL_LOST_CONTENT)) {
            Properties props = (Properties) SpringContextHolder.getApplicationContext().getBean(BEAN_NAME);
            try {
                MAIL_LOST_CONTENT = props.getProperty("mail_lost_content").trim();
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
            }
        }
        return MAIL_LOST_CONTENT;
    }

    public static String getMailLostContent(String companyName) {
        return MessageFormat.format(getMailLostContent(), getSystemAddr(), getSystemAddr(), companyName);
        //return MessageFormat.format(MAIL_LOST_CONTENT, SYSTEM_ADDR, SYSTEM_ADDR, companyName);
    }

    /**
     * 获取当前系统的类型. 1省  2市  3区
     *
     * @return 省市区类型代码
     */
    public static int getSystemType() {
        Properties props = (Properties) SpringContextHolder.getApplicationContext().getBean(BEAN_NAME);
        SYSTEM_TYPE = Integer.valueOf(props.getProperty("system_type"));
        return SYSTEM_TYPE;
    }

    public static String getEsClusterName() {
        if (StringUtils.isBlank(ES_CLUSTER_NAME)) {
            Properties props = (Properties) SpringContextHolder.getApplicationContext().getBean(BEAN_NAME);
            ES_CLUSTER_NAME = props.getProperty("es_cluster").trim();
        }
        return ES_CLUSTER_NAME;
    }

    public static String getESHost() {
        if (StringUtils.isBlank(ES_HOST)) {
            Properties props = (Properties) SpringContextHolder.getApplicationContext().getBean(BEAN_NAME);
            ES_HOST = props.getProperty("es_host").trim();
        }
        return ES_HOST;
    }

    public static int getESPort() {
        if (ES_PORT == 0) {
            Properties props = (Properties) SpringContextHolder.getApplicationContext().getBean(BEAN_NAME);
            ES_PORT = Integer.valueOf(props.getProperty("es_port"));
        }
        return ES_PORT;
    }

    public static String getAlidayuUrl() {

        Properties props = (Properties) SpringContextHolder.getApplicationContext().getBean(BEAN_NAME);
        ALIDAYU_URL = props.getProperty("alidayu_url").trim();
        return ALIDAYU_URL;
    }

    public static String getAlidayuAppkey() {
        Properties props = (Properties) SpringContextHolder.getApplicationContext().getBean(BEAN_NAME);
        ALIDAYU_APPKEY = props.getProperty("alidayu_appkey").trim();
        return ALIDAYU_APPKEY;
    }

    public static String getAlidayuSecret() {
        Properties props = (Properties) SpringContextHolder.getApplicationContext().getBean(BEAN_NAME);
        ALIDAYU_SECRET = props.getProperty("alidayu_secret").trim();
        return ALIDAYU_SECRET;
    }

    public static String getSMSType() {
        Properties props = (Properties) SpringContextHolder.getApplicationContext().getBean(BEAN_NAME);
        SMS_TYPE = props.getProperty("sms_type").trim();
        return SMS_TYPE;
    }

    public static String getSMSSign() {
        Properties props = (Properties) SpringContextHolder.getApplicationContext().getBean(BEAN_NAME);
        SMS_SIGN = props.getProperty("sms_sign");
        return SMS_SIGN;
    }

    public static String getVmsCalledShowNumber() {
        if (StringUtils.isBlank(VMS_CALLED_SHOW_NUMBER)) {
            Properties props = (Properties) SpringContextHolder.getApplicationContext().getBean(BEAN_NAME);
            VMS_CALLED_SHOW_NUMBER = props.getProperty("vms_called_Show_number").trim();
        }
        return VMS_CALLED_SHOW_NUMBER;
    }

    public static String getVmsTemplateCodeAnnualPrompt() {
        if (StringUtils.isBlank(VMS_TEMPLATE_CODE_ANNUAL_PROMPT)) {
            Properties props = (Properties) SpringContextHolder.getApplicationContext().getBean(BEAN_NAME);
            VMS_TEMPLATE_CODE_ANNUAL_PROMPT = props.getProperty("vms_template_code_annual_prompt").trim();
        }
        return VMS_TEMPLATE_CODE_ANNUAL_PROMPT;
    }

    public static String getSmsTemplateCodeLostPrompt() {
        if (StringUtils.isBlank(SMS_TEMPLATE_CODE_LOST_PROMPT)) {
            Properties props = (Properties) SpringContextHolder.getApplicationContext().getBean(BEAN_NAME);
            SMS_TEMPLATE_CODE_LOST_PROMPT = props.getProperty("sms_template_code_lost_prompt").trim();
        }
        return SMS_TEMPLATE_CODE_LOST_PROMPT;
    }

    public static String getVmsTemplateCodeLostPrompt() {
        if (StringUtils.isBlank(VMS_TEMPLATE_CODE_LOST_PROMPT)) {
            Properties props = (Properties) SpringContextHolder.getApplicationContext().getBean(BEAN_NAME);
            VMS_TEMPLATE_CODE_LOST_PROMPT = props.getProperty("vms_template_code_lost_prompt").trim();
        }
        return VMS_TEMPLATE_CODE_LOST_PROMPT;
    }

    /**
     * @return
     */
    public static String getServerUserNameAndPassWord() {
        if (StringUtils.isBlank(SERVER_USER_NAME_AND_PASS_WORD)) {
            Properties props = (Properties) SpringContextHolder.getApplicationContext().getBean(BEAN_NAME);
            SERVER_USER_NAME_AND_PASS_WORD = props.getProperty("server_user_name_and_pass_word").trim();
        }
        return SERVER_USER_NAME_AND_PASS_WORD;
    }

    public static String getBdAK() {
        if (StringUtils.isBlank(BD_AK)) {
            Properties props = (Properties) SpringContextHolder.getApplicationContext().getBean(BEAN_NAME);
            BD_AK = props.getProperty("bd_ak").trim();
        }
        return BD_AK;
    }

    public static String getBdAddrParseUrl() {
        if (StringUtils.isBlank(BD_ADDRESS_PARSE_URL)) {
            Properties props = (Properties) SpringContextHolder.getApplicationContext().getBean(BEAN_NAME);
            BD_ADDRESS_PARSE_URL = props.getProperty("bd_addr_parse_url").trim();
        }
        return BD_ADDRESS_PARSE_URL;
    }

    public static String getSystemAddr() {
        Properties props = (Properties) SpringContextHolder.getApplicationContext().getBean(BEAN_NAME);
        try {
            SYSTEM_ADDR = props.getProperty("system_addr").trim();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return SYSTEM_ADDR;
    }

    public static List<String> getBdAks() {
        if (BD_AKS == null || BD_AKS.size() == 0) {
            Properties props = (Properties) SpringContextHolder.getApplicationContext().getBean(BEAN_NAME);
            String str = props.getProperty("bd_aks", "").trim();
            BD_AKS = Lists.newArrayList(str.split(","));
        }
        return BD_AKS;

    }

    public static String getBbdAK() {
        if (StringUtils.isBlank(BBD_AK)) {
            Properties props = (Properties) SpringContextHolder.getApplicationContext().getBean(BEAN_NAME);
            BBD_AK = props.getProperty("bbd_ak").trim();
        }
        return BBD_AK;
    }

    public static String getBbdAddrParseUrl() {
        if (StringUtils.isBlank(BBD_ADDR_PARSE_URL)) {
            Properties props = (Properties) SpringContextHolder.getApplicationContext().getBean(BEAN_NAME);
            BBD_ADDR_PARSE_URL = props.getProperty("bbd_addr_parse_url").trim();
        }
        return BBD_ADDR_PARSE_URL;
    }

    public static String getKettleJNDI() {
        if (StringUtils.isBlank(KETTLE_JNDI_ROOT)) {
            Properties props = (Properties) SpringContextHolder.getApplicationContext().getBean(BEAN_NAME);
            KETTLE_JNDI_ROOT = props.getProperty("kettle_jndi").trim();
        }
        return KETTLE_JNDI_ROOT;
    }

    public static String getKettleHome() {
        if (StringUtils.isBlank(KETTLE_LIB_HOME)) {
            Properties props = (Properties) SpringContextHolder.getApplicationContext().getBean(BEAN_NAME);
            KETTLE_LIB_HOME = props.getProperty("kettle_lib").trim();
        }
        return KETTLE_LIB_HOME;
    }

    public static boolean getDATAType() {
        if (StringUtils.isBlank(KAFKA_DATA_TYPE)) {
            Properties props = (Properties) SpringContextHolder.getApplicationContext().getBean(BEAN_NAME);
            KAFKA_DATA_TYPE = props.getProperty("kafka_data_type").trim();
        }
        return Boolean.valueOf(KAFKA_DATA_TYPE);
    }

    public static String getDataSharePath() {
        if (StringUtils.isBlank(DATASHARE_PATH)) {
            Properties props = (Properties) SpringContextHolder.getApplicationContext().getBean(BEAN_NAME);
            DATASHARE_PATH = props.getProperty("datashare_path").trim();
        }
        return DATASHARE_PATH;
    }
}
