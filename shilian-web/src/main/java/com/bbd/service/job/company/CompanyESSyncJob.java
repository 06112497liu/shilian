/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.service.job.company;

import com.bbd.service.job.service.IJobService;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import javax.annotation.Resource;

/**
 * 同步企业信息到ES
 *
 * @author tjwang
 * @version $Id: CompanyESSyncJob.java, v 0.1 2017/6/15 0015 14:27 tjwang Exp $
 */
@DisallowConcurrentExecution
public class CompanyESSyncJob extends QuartzJobBean {

    @Resource
    private IJobService jobService;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        jobService.syncCompanyToES();
    }
}
