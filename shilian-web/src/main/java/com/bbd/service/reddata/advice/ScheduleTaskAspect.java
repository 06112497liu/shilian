/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.service.reddata.advice;

import com.bbd.common.annotation.ScheduleTask;
import com.bbd.dao.TaskExecuteRecordInfoDao;
import com.bbd.domain.TaskExecuteRecordInfo;
import com.bbd.domain.TaskExecuteRecordInfoExample;
import com.bbd.util.RandomUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 记录定时任务的执行状况（成功|失败），限制指定时间点执行次数，记录任务执行时间
 *
 * @author tjwang
 * @version $Id: ScheduleTaskAspect.java, v 0.1 2017/6/27 0027 14:30 tjwang Exp $
 */
@Aspect
@Component
public class ScheduleTaskAspect {

    private Logger                   logger = LoggerFactory.getLogger(getClass());

    @Resource
    private TaskExecuteRecordInfoDao taskExecuteRecordInfoDao;

    @Pointcut("execution(* com.bbd.service.job..*.*(..)) && @annotation(scheduleTask)")
    public void pointcut(ScheduleTask scheduleTask) {

    }

    @Around("pointcut(scheduleTask)")
    public void doCheckAndRecordSchedule(ProceedingJoinPoint point, ScheduleTask scheduleTask) {
        try {
            long start = System.currentTimeMillis();

            int state = 0;
            DateTime dateTime = new DateTime();
            int year = dateTime.getYear();
            int month = dateTime.getMonthOfYear();
            int day = dateTime.getDayOfMonth();
            int hour = dateTime.getHourOfDay();
            int minute = dateTime.getMinuteOfHour();

            if (scheduleTask.unique() && !checkUnique(scheduleTask)) {
                return;
            }

            boolean record = isNeedRecord(scheduleTask);

            TaskExecuteRecordInfo info = new TaskExecuteRecordInfo();
            info.setName(scheduleTask.name());
            info.setState(state);
            info.setYear(year);
            info.setMonth(month);
            info.setDay(day);
            info.setHour(hour);
            info.setMinute(minute);
            info.setPoint(scheduleTask.point().getValue());
            info.setGmtCreate(dateTime.toDate());
            if (record) {
                taskExecuteRecordInfoDao.insertSelective(info);
            }

            TaskExecuteRecordInfo u = new TaskExecuteRecordInfo();
            u.setId(info.getId());

            try {
                point.proceed();
                u.setState(1);
            } catch (Throwable throwable) {
                u.setState(2);
            } finally {
                dateTime = new DateTime();
                long end = System.currentTimeMillis();
                u.setTime(Long.valueOf(end - start).intValue());
                u.setGmtModified(dateTime.toDate());
            }

            if (record) {
                taskExecuteRecordInfoDao.updateByPrimaryKeySelective(u);
            }
        } catch (Exception e) {
            logger.warn(e.getMessage(), e);
        }
    }

    /**
     * 随机数与recordFrequence相等才记录
     *
     * @param scheduleTask
     * @return
     */
    private boolean isNeedRecord(ScheduleTask scheduleTask) {
        int rf = scheduleTask.recordFrequence();
        // 随机数与recordFrequence相等才记录
        if (rf != RandomUtil.getRandom(1, rf)) {
            return false;
        }
        return true;
    }

    /**
     * 检查在指定时间间隔内是否有重复
     *
     * @param task
     * @return
     */
    private boolean checkUnique(ScheduleTask task) {
        String name = task.name();

        DateTime dateTime = new DateTime();
        int year = dateTime.getYear();
        int month = dateTime.getMonthOfYear();
        int day = dateTime.getDayOfMonth();
        int hour = dateTime.getHourOfDay();
        int minute = dateTime.getMinuteOfHour();

        ScheduleTask.TimePoint point = task.point();
        if (point.equals(ScheduleTask.TimePoint.NONE)) {
            return true;
        }

        TaskExecuteRecordInfoExample exam = new TaskExecuteRecordInfoExample();
        TaskExecuteRecordInfoExample.Criteria c = exam.createCriteria();
        c.andNameEqualTo(name).andStateEqualTo(1);
        switch (point) {
            case MINITE:
                c.andYearEqualTo(year).andMonthEqualTo(month).andDayEqualTo(day).andHourEqualTo(hour).andMinuteEqualTo(minute);
                break;
            case HOUR:
                c.andYearEqualTo(year).andMonthEqualTo(month).andDayEqualTo(day).andHourEqualTo(hour);
                break;
            case DAY:
                c.andYearEqualTo(year).andMonthEqualTo(month).andDayEqualTo(day);
                break;
            case MONTH:
                c.andYearEqualTo(year).andMonthEqualTo(month);
                break;
        }
        List<TaskExecuteRecordInfo> ds = taskExecuteRecordInfoDao.selectByExample(exam);
        if (ds.size() > 0) {
            return false;
        }
        return true;
    }

}
