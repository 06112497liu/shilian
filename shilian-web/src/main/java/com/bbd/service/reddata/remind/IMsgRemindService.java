/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.service.reddata.remind;

import java.util.List;

/**
 * 信息提示服务
 * @author tjwang
 * @version $Id: IMsgRemindService.java, v 0.1 2017/6/6 0006 17:36 tjwang Exp $
 */
public interface IMsgRemindService {

    /**
     * 通过任务生成待发送消息队列
     * @param taskId
     */
    void generateAnnualCompanyRemindQueue(int taskId);

    /**
     * 通过任务生成待发送消息队列
     * @param taskId
     */
    void generatAbnormalCompanyRemindQueue(int taskId, int abnormalState);

    /**
     * 通过任务和指定消息内部序号生成待发送消息队列
     * @param taskId
     */
    void generateCompanyRemindQueueByNbxhs(int taskId, List<String> nbxhs);

    /**
     * 找到最近的邮件任务，并发送邮件
     * @param type 
     */
    void sendEmailByRecentTask(int type);

    /**
     * 找到最近的短信任务，并发送短信
     * @param type
     */
    void sendSmsByRecentTask(int type);

    /**
     * 找到最近的自动发送任务，并发送消息
     */
    void sendByRecentAutoTask();

}
