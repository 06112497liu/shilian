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
 * @author tjwang
 * @version $Id: AutoRemindMessageSendJob.java, v 0.1 2017/6/12 0012 9:34 tjwang Exp $
 */
@DisallowConcurrentExecution
public class AutoRemindMessageSendJob extends QuartzJobBean {

    private Logger      logger = LoggerFactory.getLogger(getClass());

    @Resource
    private IJobService jobService;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        logger.info("Executing AutoRemindMessageSendJob");

        //jobService.executeAutoRemindMessageSend();
    }

}
