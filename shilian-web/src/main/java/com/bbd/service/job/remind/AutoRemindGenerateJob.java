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
 * 根据自动提示设置，生成自动提示任务
 *
 * @author tjwang
 * @version $Id: AutoRemindGenerateJob.java, v 0.1 2017/6/9 0009 17:12 tjwang Exp $
 */
@DisallowConcurrentExecution
public class AutoRemindGenerateJob extends QuartzJobBean {

    private Logger      logger = LoggerFactory.getLogger(getClass());

    @Resource
    private IJobService jobService;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        logger.info("AutoRemindGenerateJob execute.");
        jobService.executeAutoRemindGenerate();
    }

}
