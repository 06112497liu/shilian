/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.dao.remind;

import org.apache.ibatis.annotations.Param;

/**
 *
 * @author tjwang
 * @version $Id: MsgTaskExtDao.java, v 0.1 2017/6/7 0007 17:55 tjwang Exp $
 */
public interface MsgTaskExtDao {

    /**
     * 增加任务成功数
     * @param taskId
     * @param num
     */
    void increaseSuccess(@Param("taskId") int taskId, @Param("num") int num);

    /**
     * 增加任务失败数
     * @param taskId
     * @param num
     */
    void increaseFail(@Param("taskId") int taskId, @Param("num") int num);

}
