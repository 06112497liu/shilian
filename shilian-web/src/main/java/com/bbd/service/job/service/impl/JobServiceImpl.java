/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.service.job.service.impl;

import com.bbd.bean.remind.RemindType;
import com.bbd.common.annotation.ScheduleTask;
import com.bbd.service.job.service.IJobService;
import com.bbd.service.reddata.activity.ICompanyActivityService;
import com.bbd.service.reddata.company.ICompanyService;
import com.bbd.service.reddata.es.IEsService;
import com.bbd.service.reddata.remind.ICompanyRemindService;
import com.bbd.service.reddata.remind.IMsgRemindService;
import com.bbd.service.reddata.remind.IMsgTaskService;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author tjwang
 * @version $Id: JobServiceImpl.java, v 0.1 2017/6/27 0027 16:03 tjwang Exp $
 */
@Service
public class JobServiceImpl implements IJobService {

    private Logger                  logger = LoggerFactory.getLogger(getClass());

    @Resource
    private IMsgRemindService       msgRemindService;

    @Resource
    private ICompanyRemindService   companyRemindStatisticService;

    @Resource
    private IMsgTaskService         msgTaskService;
    @Resource
    private IEsService              esService;
    @Resource
    private ICompanyActivityService companyActivityService;

    @Resource
    private ICompanyService         companyService;

    @Override
    @ScheduleTask(name = "AnnualRemindManualEmailSendJob", recordFrequence = 10)
    public void sendAnnualRemindEmail() {
        msgRemindService.sendEmailByRecentTask(RemindType.ANNUAL_REMIND);
    }

    @Override
    @ScheduleTask(name = "AnnualRemindManualSmsSendJob", recordFrequence = 10)
    public void sendAnnualRemindSms() {
        msgRemindService.sendSmsByRecentTask(RemindType.ANNUAL_REMIND);
    }

    @Override
    @ScheduleTask(name = "LostRemindManualEmailSendJob", recordFrequence = 10)
    public void sendLostRemindEmail() {
        msgRemindService.sendEmailByRecentTask(RemindType.LOST_REMIND);
    }

    @Override
    @ScheduleTask(name = "LostRemindManualSmsSendJob", recordFrequence = 10)
    public void sendLostRemindSms() {
        msgRemindService.sendSmsByRecentTask(RemindType.LOST_REMIND);
    }

    @Override
    @ScheduleTask(name = "UnpublicityRemindManualEmailSendJob", recordFrequence = 10)
    public void sendUnpublishRemindEmail() {
        msgRemindService.sendEmailByRecentTask(RemindType.UNPUBLISHED);
    }

    @Override
    @ScheduleTask(name = "UnpublicityRemindManualSmsSendJob", recordFrequence = 10)
    public void sendUnpublishRemindSms() {
        msgRemindService.sendSmsByRecentTask(RemindType.UNPUBLISHED);
    }

    @Override
    @ScheduleTask(name = "UnannualRemindManualEmailSendJob", recordFrequence = 10)
    public void sendUnannualRemindEmail() {
        msgRemindService.sendEmailByRecentTask(RemindType.UNANNUAL_REMIND);
    }

    @Override
    @ScheduleTask(name = "UnannualRemindManualSmsSendJob", recordFrequence = 10)
    public void sendUnannualRemindSms() {
        msgRemindService.sendSmsByRecentTask(RemindType.UNANNUAL_REMIND);
    }

    @Override
    @ScheduleTask(name = "FakeInfoRemindManualEmailSendJob", recordFrequence = 10)
    public void sendFakeInfoRemindEmail() {
        msgRemindService.sendEmailByRecentTask(RemindType.FAKE_INFO);
    }

    @Override
    @ScheduleTask(name = "FakeInfoRemindManualSmsSendJob", recordFrequence = 10)
    public void sendFakeInfoRemindSms() {
        msgRemindService.sendSmsByRecentTask(RemindType.FAKE_INFO);
    }

    @Override
    @ScheduleTask(name = "CompanyRemindSendDailyCountJob", unique = true, point = ScheduleTask.TimePoint.DAY)
    public void executeCompanyRemindSendDailyCountJob() {
        DateTime dateTime = new DateTime();
        dateTime = dateTime.plusDays(-1);
        int year = dateTime.getYear();
        int day = dateTime.getDayOfYear();
        companyRemindStatisticService.insertDailyRemindCount(year, day);
    }

    @Override
    @ScheduleTask(name = "CompanyRemindSendMonthlyCountJob", point = ScheduleTask.TimePoint.MONTH, unique = true)
    public void executeCompanyRemindSendMonthlyCountJob() {
        DateTime dateTime = new DateTime();
        dateTime.plusMonths(-1);
        int year = dateTime.getYear();
        int month = dateTime.getMonthOfYear();
        companyRemindStatisticService.insertMonthlyRemindCount(year, month);
    }

    @Override
    @ScheduleTask(name = "AutoRemindGenerateJob", recordFrequence = 10)
    public void executeAutoRemindGenerate() {
        msgTaskService.generateAutoRemindTask();
    }

    //    @Override
    //    @ScheduleTask(name = "AutoRemindMessageSendJob", recordFrequence = 10)
    //    public void executeAutoRemindMessageSend() {
    //        msgRemindService.sendByRecentAutoTask();
    //    }

    @Override
    @ScheduleTask(name = "TaskMessageDetailGenerateJob", recordFrequence = 10)
    public void executeGenerateTaskMessageDetail() {
        msgTaskService.generateTaskRemindQueue();
    }

    @Override
    @ScheduleTask(name = "CompanyESSyncJob", unique = true, point = ScheduleTask.TimePoint.DAY)
    public void syncCompanyToES() {
        esService.syncFullCompanyToEs();
    }

    @Override
    @ScheduleTask(name = "CompanyActivityCalculateJob", unique = true, point = ScheduleTask.TimePoint.DAY)
    public void calculateCompanyActivity() {
        DateTime dateTime = new DateTime();
        dateTime = dateTime.plusMonths(-1);
        int year = dateTime.getYear();
        int month = dateTime.getMonthOfYear();
        companyActivityService.generateMonthStatistic(year, month);
    }

    @Override
    @ScheduleTask(name = "CompanyBusinessRecordSyncJob", unique = true, point = ScheduleTask.TimePoint.DAY)
    public void syncCompanyBusinessRecord() {
        DateTime dateTime = new DateTime();
        dateTime = dateTime.plusMonths(-1);
        int year = dateTime.getYear();
        int month = dateTime.getMonthOfYear();

        companyActivityService.updateCompanyBusinessInfo(year, month);
    }
}
