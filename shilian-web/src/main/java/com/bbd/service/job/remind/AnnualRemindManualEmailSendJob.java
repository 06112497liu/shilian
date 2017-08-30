/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.service.job.remind;

import com.bbd.service.job.service.IJobService;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

import javax.annotation.Resource;

/**
 * 邮件发送任务
 *
 * @author tjwang
 * @version $Id: AnnualRemindManualEmailSendJob.java, v 0.1 2017/6/6 0006 15:52 tjwang Exp $
 */
@DisallowConcurrentExecution
public class AnnualRemindManualEmailSendJob extends QuartzJobBean {

    private Logger      logger = LoggerFactory.getLogger(getClass());

    @Resource
    private IJobService jobService;

    @Override
    public void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        logger.debug("Executing AnnualRemindManualEmailSendJob");

        jobService.sendAnnualRemindEmail();
    }
}
