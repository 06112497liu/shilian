/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.service.reddata.message;

import java.util.List;

/**
 * BBD针对消息发送消息服务
 *
 * @author tjwang
 * @version $Id: BBDMessageService.java, v 0.1 2017/6/20 0020 10:54 tjwang Exp $
 */
public interface BBDMessageService {

    /**
     * 从BBD数据平台获取企业邮箱，存在于招中标/招聘表中
     *
     * @param nbxh
     * @return
     */
    List<String> getBBDEmails(String nbxh);

    /**
     * 从BBD数据平台获取企业手机号，存在于招中标/招聘表中
     *
     * @param nbxh
     * @return
     */
    List<String> getBBDSms(String nbxh);

}
