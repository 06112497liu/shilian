/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.service.reddata.remind.impl;

import com.bbd.bean.remind.RemindCompany;
import com.bbd.dao.remind.CompanyRemindQueueExtDao;
import com.bbd.domain.MsgTaskInfo;
import com.bbd.service.reddata.message.IMessageService;
import com.bbd.service.reddata.remind.IMsgRemindService;
import com.bbd.service.reddata.remind.IMsgTaskService;
import com.bbd.service.reddata.remind.MsgTaskHelper;
import com.bbd.service.reddata.remind.param.MannualRemindCondition;
import com.bbd.service.utils.EmailSenders;
import com.bbd.util.StringUtils;
import com.google.common.collect.Maps;
import com.utils.ObjectMapperUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 信息提示服务实现
 *
 * @author tjwang
 * @version $Id: MsgRemindServiceImpl.java, v 0.1 2017/6/6 0006 17:39 tjwang Exp $
 */
@Service
public class MsgRemindServiceImpl implements IMsgRemindService {

    @Autowired
    protected RedisTemplate<String, String> redisTemplate;
    private Logger                          logger = LoggerFactory.getLogger(getClass());
    @Resource
    private CompanyRemindQueueExtDao        companyRemindQueueExtDao;

    @Resource
    private IMsgTaskService                 msgTaskService;

    @Resource
    private MsgTaskHelper                   msgTaskHelper;

    @Resource
    private IMessageService                 messageService;

    @Resource
    private EmailSenders                    emailSenders;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void generateAnnualCompanyRemindQueue(int taskId) {
        if (msgTaskHelper.isStarted(taskId)) {
            logger.info("Task {0} had started.", taskId);
            return;
        }
        Map<String, Object> map = getParamMap(taskId);
        companyRemindQueueExtDao.generateAnnualCompanyRemindQueue(map);

        updateAndStartTask(taskId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void generatAbnormalCompanyRemindQueue(int taskId, int abnormalState) {
        if (msgTaskHelper.isStarted(taskId)) {
            logger.info("Task {0} had started.", taskId);
            return;
        }

        Map<String, Object> map = getParamMap(taskId);
        map.put("abnormalState", abnormalState);
        companyRemindQueueExtDao.generateAbnormalCompanyRemindQueue(map);

        updateAndStartTask(taskId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void generateCompanyRemindQueueByNbxhs(int taskId, List<String> nbxhs) {
        if (msgTaskHelper.isStarted(taskId)) {
            logger.info("Task {0} had started.", taskId);
            return;
        }
        Map<String, Object> map = getParamMap(taskId);
        map.put("nbxhs", nbxhs);
        companyRemindQueueExtDao.generateCompanyRemindQueueByNbxhs(map);

        updateAndStartTask(taskId);
    }

    private Map<String, Object> getParamMap(int taskId) {
        MsgTaskInfo task = msgTaskService.getTask(taskId);

        Map<String, Object> map = Maps.newHashMap();
        MannualRemindCondition condition = ObjectMapperUtil.read(task.getConditions(), MannualRemindCondition.class);

        String district = task.getDistrict();

        String companyName = condition.getCompanyName();
        String districtParam = condition.getDistrict();
        String primaryIndustry = condition.getPrimaryIndustry();
        Double indexScoreFrom = condition.getIndexScoreFrom();
        Double indexScoreTo = condition.getIndexScoreTo();

        if (StringUtils.isNotBlank(companyName)) {
            map.put("companyName", "%" + companyName + "%");
        }

        if (StringUtils.isNotBlank(districtParam)) {
            map.put("districtParam", districtParam);
        }

        if (StringUtils.isNotBlank(primaryIndustry)) {
            map.put("primaryIndustry", primaryIndustry);
        }

        if (indexScoreFrom != null || indexScoreTo != null) {
            indexScoreFrom = indexScoreFrom == null ? 0 : indexScoreFrom;
            indexScoreTo = indexScoreTo == null ? 100 : indexScoreTo;
            map.put("indexScoreFrom", indexScoreFrom);
            map.put("indexScoreTo", indexScoreTo);
        }

        Integer type = task.getType();
        Integer method = task.getMethod();
        Integer operateType = task.getOperationType();
        Date date = task.getSendTime();

        map.put("taskId", taskId);
        map.put("type", type);
        map.put("method", method);
        map.put("operateType", operateType);
        map.put("planDate", date);
        map.put("district", district);

        return map;
    }

    private void updateAndStartTask(int taskId) {
        int count = companyRemindQueueExtDao.getCountByTaskId(taskId);
        MsgTaskInfo m = new MsgTaskInfo();
        m.setId(taskId);
        m.setTotal(count);
        msgTaskService.updateTask(m);

        msgTaskService.startTask(taskId);
        logger.info("Task {0} started and queue generated.", taskId);
    }

    @Override
    public void sendEmailByRecentTask(int type) {
        if (emailSenders.isAllOutOfLimit()) {
            return;
        }

        MsgTaskInfo task = msgTaskService.getFirstSendingEmailTask(type);
        if (task == null) {
            return;
        }

        Integer taskId = task.getId();
        while (true) {
            List<RemindCompany> list = companyRemindQueueExtDao.getQueuedTaskRemindCompanyInfos(taskId);
            if (list.size() == 0) {
                msgTaskService.finishTask(taskId);
                return;
            }

            for (RemindCompany rc : list) {
                messageService.sendRemindEmail(rc);
                if (emailSenders.isAllOutOfLimit()) {
                    return;
                }
            }
        }
    }

    @Override
    public void sendSmsByRecentTask(int type) {
        MsgTaskInfo task = msgTaskService.getFirstSendingSmsTask(type);
        if (task == null) {
            return;
        }
        Integer taskId = task.getId();
        while (true) {
            List<RemindCompany> list = companyRemindQueueExtDao.getQueuedTaskRemindCompanyInfos(taskId);
            if (list.size() == 0) {
                msgTaskService.finishTask(taskId);
                return;
            }

            for (RemindCompany rc : list) {
                messageService.sendRemindSms(rc);
            }
        }
    }

    @Override
    public void sendByRecentAutoTask() {
        MsgTaskInfo task = msgTaskService.getFirstAutoSendingTask();
        if (task == null) {
            return;
        }
        Integer taskId = task.getId();
        while (true) {
            List<RemindCompany> list = companyRemindQueueExtDao.getQueuedTaskRemindCompanyInfos(taskId);
            if (list.size() == 0) {
                msgTaskService.finishTask(taskId);
                return;
            }

            for (RemindCompany rc : list) {
                messageService.sendRemindMessage(rc);
            }
        }
    }
}
