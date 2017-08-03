/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.dao.remind;

import com.bbd.bean.remind.RemindCompany;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 *
 * @author tjwang
 * @version $Id: CompanyRemindQueueExtDao.java, v 0.1 2017/6/6 0006 17:21 tjwang Exp $
 */
public interface CompanyRemindQueueExtDao {

    /**
     * 生成年报企业提示消息
     * @param map
     */
    void generateAnnualCompanyRemindQueue(Map<String, Object> map);

    /**
     * 生成异常企业提示消息
     * @param map
     */
    void generateAbnormalCompanyRemindQueue(Map<String, Object> map);

    /**
     * 通过内部序号列表声场企业
     * @param map
     */
    void generateCompanyRemindQueueByNbxhs(Map<String, Object> map);

    /**
     * 查询指定任务待发送消息信息及公司信息
     * @param taskId
     * @return
     */
    List<RemindCompany> getQueuedTaskRemindCompanyInfos(@Param("taskId") Integer taskId);

    //    void generateAbnormalCompanyRemindQueue(Map<String, Object> map);

    int getCountByTaskId(@Param("taskId") Integer taskId);

}
