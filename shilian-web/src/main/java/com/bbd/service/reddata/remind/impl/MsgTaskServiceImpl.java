/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.service.reddata.remind.impl;

import com.bbd.common.MessageTaskConstants;
import com.bbd.dao.MsgTaskInfoDao;
import com.bbd.dao.remind.MsgTaskExtDao;
import com.bbd.domain.AutoRemindSettingInfo;
import com.bbd.domain.MsgTaskInfo;
import com.bbd.domain.MsgTaskInfoExample;
import com.bbd.service.reddata.remind.IAutoRemindSettingService;
import com.bbd.service.reddata.remind.IMsgRemindService;
import com.bbd.service.reddata.remind.IMsgTaskService;
import com.bbd.service.reddata.remind.MsgTaskHelper;
import com.bbd.service.reddata.remind.param.MannualRemindCondition;
import com.bbd.service.reddata.remind.param.MsgTaskQueryVO;
import com.bbd.util.StringUtils;
import com.bbd.utils.PageListHelper;
import com.exception.ApplicationException;
import com.exception.CommonErrorCode;
import com.google.common.base.Preconditions;
import com.mybatis.domain.PageBounds;
import com.mybatis.domain.PageList;
import com.mybatis.domain.Paginator;
import com.utils.BeanMapperUtil;
import com.utils.ObjectMapperUtil;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 消息发送任务服务实现
 *
 * @author tjwang
 * @version $Id: MsgTaskService.java, v 0.1 2017/6/6 0006 11:40 tjwang Exp $
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class MsgTaskServiceImpl implements IMsgTaskService {

    private Logger                    logger = LoggerFactory.getLogger(getClass());

    @Resource
    private MsgTaskInfoDao            msgTaskInfoDao;

    @Resource
    private MsgTaskExtDao             msgTaskExtDao;

    @Resource
    private IAutoRemindSettingService autoRemindSettingService;

    @Resource
    private IMsgRemindService         msgRemindService;

    @Resource
    private MsgTaskHelper             msgTaskHelper;

    @Override
    public MsgTaskInfo getTask(Integer taskId) {
        Preconditions.checkNotNull(taskId, "任务号不能为空");
        MsgTaskInfo task = msgTaskInfoDao.selectByPrimaryKey(taskId);
        if (task == null) {
            logger.warn("taskId {0} not exits", taskId);
            throw new ApplicationException(CommonErrorCode.BIZ_ERROR);
        }
        return task;
    }

    @Override
    public void addTask(MsgTaskInfo info) {
        DateTime dateTime = new DateTime();
        int year = dateTime.getYear();

        info.setEnabled(true);
        info.setSendTime(dateTime.toDate());
        info.setSendYear(year);
        info.setOperationType(MessageTaskConstants.MANUAL);

        String cond = info.getConditions();
        if (StringUtils.isBlank(cond)) {
            info.setConditions("{}");
        }

        msgTaskInfoDao.insertSelective(info);
    }

    @Override
    public void addTaskWithNbxhs(MsgTaskInfo info, List<String> nbxhs) {
        DateTime dateTime = new DateTime();
        int year = dateTime.getYear();

        info.setEnabled(true);
        info.setSendTime(dateTime.toDate());
        info.setSendYear(year);
        info.setOperationType(MessageTaskConstants.MANUAL);

        String cond = info.getConditions();
        if (StringUtils.isBlank(cond)) {
            info.setConditions("{}");
        }
        msgTaskInfoDao.insertSelective(info);
        msgRemindService.generateCompanyRemindQueueByNbxhs(info.getId(), nbxhs);
    }

    @Override
    public void updateTask(MsgTaskInfo info) {
        msgTaskInfoDao.updateByPrimaryKeySelective(info);
    }

    @Override
    public void startTask(Integer taskId) {
        Preconditions.checkNotNull(taskId, "任务号不能为空");
        MsgTaskInfo task = msgTaskInfoDao.selectByPrimaryKey(taskId);
        if (task == null) {
            logger.warn("taskId {0} not exits", taskId);
            throw new ApplicationException(CommonErrorCode.BIZ_ERROR);
        }
        Date now = new Date();
        MsgTaskInfo update = new MsgTaskInfo();
        update.setId(taskId);
        update.setStartTime(now);
        msgTaskInfoDao.updateByPrimaryKeySelective(update);
    }

    @Override
    public void finishTask(Integer taskId) {
        Preconditions.checkNotNull(taskId, "任务号不能为空");
        MsgTaskInfo task = msgTaskInfoDao.selectByPrimaryKey(taskId);
        if (task == null) {
            logger.warn("taskId {0} not exits", taskId);
            throw new ApplicationException(CommonErrorCode.BIZ_ERROR);
        }

        if (!msgTaskHelper.isStarted(taskId)) {
            logger.warn("taskId {0} not started", taskId);
            throw new ApplicationException(CommonErrorCode.BIZ_ERROR);
        }

        if (msgTaskHelper.isFinished(taskId)) {
            logger.warn("taskId {0} is already finished", taskId);
            return;
        }

        Date now = new Date();

        MsgTaskInfo update = new MsgTaskInfo();
        update.setId(taskId);
        update.setEndTime(now);
        msgTaskInfoDao.updateByPrimaryKeySelective(update);
    }

    @Override
    public void increaseSuccess(int taskId) {
        doIncreaseSuccess(taskId, 1);
    }

    @Override
    public void increaseSuccess(int taskId, int n) {
        doIncreaseSuccess(taskId, n);
    }

    private void doIncreaseSuccess(int taskId, int n) {
        msgTaskExtDao.increaseSuccess(taskId, n);
    }

    @Override
    public void increaseFail(int taskId) {
        doIncreaseFail(taskId, 1);
    }

    @Override
    public void increaseFail(int taskId, int n) {
        doIncreaseFail(taskId, n);
    }

    private void doIncreaseFail(int taskId, int n) {
        msgTaskExtDao.increaseFail(taskId, n);
    }

    @Override
    public List<MsgTaskInfo> search(MsgTaskInfo info) {
        MsgTaskInfoExample exam = new MsgTaskInfoExample();
        return msgTaskInfoDao.selectByExample(exam);
    }

    @Override
    public MsgTaskInfo getFirstSendingEmailTask(int type) {
        MsgTaskInfo result = null;

        MsgTaskInfoExample exam = new MsgTaskInfoExample();
        MsgTaskInfoExample.Criteria c = exam.createCriteria();
        c.andMethodEqualTo(MessageTaskConstants.EMAIL_METHOD).andTypeEqualTo(type).andStartTimeIsNotNull().andEndTimeIsNull();
        exam.setOrderByClause("gmt_create asc");

        PageBounds pb = new PageBounds(1, 1, false);

        List<MsgTaskInfo> ds = msgTaskInfoDao.selectByExampleWithPageBounds(exam, pb);
        if (ds.size() > 0) {
            result = ds.get(0);
        }

        return result;
    }

    @Override
    public MsgTaskInfo getFirstSendingSmsTask(int type) {
        MsgTaskInfo result = null;

        MsgTaskInfoExample exam = new MsgTaskInfoExample();
        MsgTaskInfoExample.Criteria c = exam.createCriteria();
        c.andMethodEqualTo(MessageTaskConstants.SMS_METHOD).andTypeEqualTo(type).andStartTimeIsNotNull().andEndTimeIsNull();
        exam.setOrderByClause("gmt_create asc");

        PageBounds pb = new PageBounds(1, 1, false);

        List<MsgTaskInfo> ds = msgTaskInfoDao.selectByExampleWithPageBounds(exam, pb);
        if (ds.size() > 0) {
            result = ds.get(0);
        }

        return result;
    }

    @Override
    public MsgTaskInfo getFirstAutoSendingTask() {
        MsgTaskInfo result = null;

        MsgTaskInfoExample exam = new MsgTaskInfoExample();
        MsgTaskInfoExample.Criteria c = exam.createCriteria();
        c.andOperationTypeEqualTo(MessageTaskConstants.AUTO).andStartTimeIsNotNull().andEndTimeIsNull();
        exam.setOrderByClause("gmt_create asc");

        PageBounds pb = new PageBounds(1, 1, false);

        List<MsgTaskInfo> ds = msgTaskInfoDao.selectByExampleWithPageBounds(exam, pb);
        if (ds.size() > 0) {
            result = ds.get(0);
        }

        return result;
    }

    @Override
    public List<MsgTaskInfo> getUnfiredTasks() {
        DateTime time = new DateTime();
        Date now = time.toDate();
        int year = time.getYear();

        MsgTaskInfoExample exam = new MsgTaskInfoExample();
        MsgTaskInfoExample.Criteria c = exam.createCriteria();
        c.andSendTimeLessThan(now).andStartTimeIsNull().andSendYearEqualTo(year);

        return msgTaskInfoDao.selectByExample(exam);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void generateAutoRemindTask() {
        List<AutoRemindSettingInfo> ss = autoRemindSettingService.getTimeReachedSettings();
        if (ss.size() == 0) {
            return;
        }
        for (AutoRemindSettingInfo s : ss) {
            int sId = s.getId();
            createTaskByAutoReminSetting(sId);
            autoRemindSettingService.complete(sId);
        }
    }

    /**
     * 通过自动提醒配置创建任务
     *
     * @param settingId
     */
    private void createTaskByAutoReminSetting(int settingId) {
        AutoRemindSettingInfo s = autoRemindSettingService.getById(settingId);

        Date runDate = s.getRunDate();
        DateTime d = new DateTime(runDate);
        int year = d.getYear();

        MsgTaskInfo info = new MsgTaskInfo();
        info.setEnabled(true);
        info.setType(s.getTaskType());
        info.setOperationType(MessageTaskConstants.AUTO);
        info.setSendTime(s.getRunDate());
        info.setDistrict(s.getOperator());
        info.setSendYear(year);
        MannualRemindCondition condition = new MannualRemindCondition();
        condition.setDistrict(s.getDistrict());
        info.setConditions(ObjectMapperUtil.write(condition));

        msgTaskInfoDao.insertSelective(info);
    }

    @Override
    public void generateTaskRemindQueue() {
        List<MsgTaskInfo> tasks = getUnfiredTasks();
        if (tasks.size() == 0) {
            return;
        }
        generateCompanyRemindDetail(tasks);
    }

    private void generateCompanyRemindDetail(List<MsgTaskInfo> tasks) {
        for (MsgTaskInfo task : tasks) {
            if (isAnnual(task)) {
                msgRemindService.generateAnnualCompanyRemindQueue(task.getId());
            } else {
                int state = getAbnormalState(task);
                msgRemindService.generatAbnormalCompanyRemindQueue(task.getId(), state);
            }
        }
    }

    private boolean isAnnual(MsgTaskInfo info) {
        return info.getType() == 1;
    }

    private int getAbnormalState(MsgTaskInfo info) {
        int result = 0;
        Integer type = info.getType();
        switch (type) {
            case 2:
                result = 8;
                break;
            case 3:
                result = 1;
                break;
            case 4:
                result = 2;
                break;
            case 5:
                result = 4;
                break;
        }
        return result;
    }

    @Override
    public PageList<MsgTaskQueryVO> getLastRemindTask(String district, Integer type, int page) {
        DateTime dateTime = new DateTime();
        int sendYear = dateTime.getYear();

        MsgTaskInfoExample exam = new MsgTaskInfoExample();
        exam.createCriteria().andDistrictEqualTo(district).andTypeEqualTo(type).andSendYearEqualTo(sendYear);
        exam.setOrderByClause("send_time DESC");
        PageBounds pb = new PageBounds(page, 1);

        List<MsgTaskInfo> ds = msgTaskInfoDao.selectByExampleWithPageBounds(exam, pb);
        List<MsgTaskQueryVO> temp = BeanMapperUtil.mapList(ds, MsgTaskQueryVO.class);

        Paginator paginator = PageListHelper.getPaginator(ds);
        PageList<MsgTaskQueryVO> result = PageListHelper.create(temp, paginator);

        return result;
    }
}
