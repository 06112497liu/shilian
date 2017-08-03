/**  
 * BBD Service Inc
 * All Rights Reserved @2016
 *
 */
package com.bbd.util;

import com.exception.ApplicationException;
import com.exception.CommonErrorCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 远程请求配置文件工具.
 * 
 * @author zhanghui
 * @version $Id: BusinessActivityConfigUtil.java, v 0.1 2016年12月13日 下午4:25:34
 *          zhanghui Exp $
 */
public class RemoteConfigUtil {

    /** 新闻 */
    public static final String  ACTIVITY_NEWS        = "activity_news";
    /** 诉讼 */
    public static final String  ACTIVITY_ZGCPWSW     = "activity_zgcpwsw";

    // ------------- swagger key names -------------------------
    /** 专利 */
    public static final String  ACTIVITY_PATENT      = "activity_patent";
    /** 招标 */
    public static final String  ACTIVITY_BIDINVITING = "activity_bidinviting";
    /** 中标 */
    public static final String  ACTIVITY_BIDWINNER   = "activity_bidwinner";
    /** 软件著作权 */
    public static final String  ACTIVITY_SC          = "activity_sc";
    /** 行政处罚 */
    public static final String  ACTIVITY_PENA        = "activity_pena";
    /** 招聘 */
    public static final String  ACTIVITY_RECRUIT     = "activity_recruit";
    /** 年报 */
    public static final String  ACTIVITY_NB          = "activity_nb";
    /** 投融资 */
    public static final String  ACTIVITY_PEDATA      = "activity_pedata";
    /** 关联方 */
    public static final String  AFFILIACTED          = "affiliacted_url";
    /** 资质 */
    public static final String  ACTIVITY_APTITUDE    = "activity_aptitude";
    /** 社保 */
    public static final String  ACTIVITY_SI          = "activity_si";
    /** 纳税 */
    public static final String  ACTIVITY_PAYTAX      = "activity_paytax";
    /** 投诉 */
    public static final String  ACTIVITY_COMPLAIN    = "activity_complain";
    /**企业邮箱联系信息*/
    public static final String  EMAIL_ADDRESS        = "company_address_url";
    /** 经营活动 */
    public static final String  ACTIVITY_PREFIX      = "activity_";
    private static final String FILE_PATH            = "remote.properties";
    /** access token 后缀 */
    private static final String AK_SUFFIX            = "_ak";
    /** 满分后缀 */
    private static final String SCORE_SUFFIX         = "_score";
    /** 指标级别后缀 3 重点指标 2 中等指标 1 普通指标 */
    private static final String LEVEL_SUFFIX         = "_level";
    private static Logger       logger               = LoggerFactory.getLogger(RemoteConfigUtil.class);
    private static Properties   ps                   = null;

    static {
        ps = new Properties();
        InputStream in = null;
        try {
            in = Thread.currentThread().getContextClassLoader().getResourceAsStream(FILE_PATH);
            ps.load(in);
        } catch (Exception e) {
            throw new ApplicationException(CommonErrorCode.INNER_ERROR, e);
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                logger.error(e.getMessage(), e);
            }
        }
    }

    /** 获取配置属性 */
    public static String getProperty(String name, String defaultValue) {
        return ps.getProperty(name, defaultValue);
    }

    /** 获取配置url */
    public static String getUrl(String name) {
        return ps.getProperty(name, "");
    }

    /** 获取配置access token */
    public static String getAK(String name) {
        return ps.getProperty(name + AK_SUFFIX, "");
    }

    /** 获取配置 full score */
    public static double getScore(String name) {
        String p = ps.getProperty(name + SCORE_SUFFIX, "");
        if (null == p || "".equals(p)) {
            p = "0";
        }
        double result = 0;
        try {
            result = Double.valueOf(p.trim());
        } catch (Exception e) {
            logger.error("获取分数异常：", e);
        }
        return result;
    }

    /** 获取指标配置 指标级别 */
    public static int getLevel(String name) {
        String p = ps.getProperty(name + LEVEL_SUFFIX, "");
        int result = 1;
        try {
            result = Integer.valueOf(p.trim());
        } catch (Exception e) {
            logger.error("获取指标异常异常：", e);
        }
        return result;
    }
}