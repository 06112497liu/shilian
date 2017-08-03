/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.service.job.activity;

import com.bbd.service.job.service.IJobService;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import javax.annotation.Resource;

/**
 * 经营指数算分。算当前月的上一月得分。
 *
 * @author tjwang
 * @version $Id: CompanyActivityCalculateJob.java, v 0.1 2017/6/15 0015 11:19 tjwang Exp $
 */
@DisallowConcurrentExecution
public class CompanyActivityCalculateJob extends QuartzJobBean {

    @Resource
    private IJobService jobService;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        jobService.calculateCompanyActivity();
    }

}
