/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.service.reddata.remind;

import java.util.List;

import com.bbd.domain.MsgTaskInfo;
import com.bbd.service.reddata.remind.param.MsgTaskQueryVO;
import com.mybatis.domain.PageList;

/**
 * 消息发送任务服务
 *
 * @author tjwang
 * @version $Id: IMsgTaskService.java, v 0.1 2017/6/6 0006 11:37 tjwang Exp $
 */
public interface IMsgTaskService {

    /**
     * 获取任务
     *
     * @param taskId
     */
    MsgTaskInfo getTask(Integer taskId);

    /**
     * 添加任务
     *
     * @param info
     */
    void addTask(MsgTaskInfo info);

    /**
     * 指定内部序号，创建发送任务。并开始任务。
     *
     * @param info
     * @param nbxhs
     */
    void addTaskWithNbxhs(MsgTaskInfo info, List<String> nbxhs);

    /**
     * 更新任务
     *
     * @param info
     */
    void updateTask(MsgTaskInfo info);

    /**
     * 开始任务
     *
     * @param taskId
     */
    void startTask(Integer taskId);

    /**
     * 结束任务
     *
     * @param taskId
     */
    void finishTask(Integer taskId);

    /**
     * 增加成功数
     *
     * @param taskId
     */
    void increaseSuccess(int taskId);

    void increaseSuccess(int taskId, int n);

    /**
     * 增加失败数
     *
     * @param taskId
     */
    void increaseFail(int taskId);

    void increaseFail(int taskId, int n);

    /**
     * 查找任务
     *
     * @param info
     * @return
     */
    List<MsgTaskInfo> search(MsgTaskInfo info);

    /**
     * 获取最早开始的邮件发送任务 - 手动提示\
     *
     * @param type 1.企业年报提示,2.失联企业提示,3.未年报企业提示,4.未公示企业提示,5.虚假信息企业提示
     * @return
     */
    MsgTaskInfo getFirstSendingEmailTask(int type);

    /**
     * 获取最早开始的短信发送任务 - 手动提示
     *
     * @param type 1.企业年报提示,2.失联企业提示,3.未年报企业提示,4.未公示企业提示,5.虚假信息企业提示
     * @return
     */
    MsgTaskInfo getFirstSendingSmsTask(int type);

    /**
     * 获取最早开始的自动提示发送任务
     *
     * @return
     */
    MsgTaskInfo getFirstAutoSendingTask();

    /**
     * 获取未执行的任务
     *
     * @return
     */
    List<MsgTaskInfo> getUnfiredTasks();

    /**
     * 生成自动提示任务
     */
    void generateAutoRemindTask();

    /**
     * 生成到达发送时间的任务的发送队列
     */
    void generateTaskRemindQueue();

    /**
     * 获取指定地区指定类型最新的任务信息
     */
    PageList<MsgTaskQueryVO> getLastRemindTask(String district, Integer type, int page);

}
