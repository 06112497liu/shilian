/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.service.reddata.remind;

import com.bbd.domain.MsgTaskInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *
 * @author tjwang
 * @version $Id: TaskHelper.java, v 0.1 2017/6/7 0007 16:52 tjwang Exp $
 */
@Service
public class MsgTaskHelper {

    @Resource
    private IMsgTaskService msgTaskService;

    public boolean isStarted(int taskId) {
        MsgTaskInfo task = msgTaskService.getTask(taskId);
        if (task.getStartTime() != null) {
            return true;
        }
        return false;
    }

    public boolean isFinished(int taskId) {
        MsgTaskInfo task = msgTaskService.getTask(taskId);
        if (task.getEndTime() != null) {
            return true;
        }
        return false;
    }

}
