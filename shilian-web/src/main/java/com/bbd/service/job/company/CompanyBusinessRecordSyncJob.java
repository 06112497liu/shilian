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
 * 将企业经营活动同步到company表
 *
 * @author tjwang
 * @version $Id: CompanyBusinessRecordSyncJob.java, v 0.1 2017/6/28 0028 12:36 tjwang Exp $
 */
@DisallowConcurrentExecution
public class CompanyBusinessRecordSyncJob extends QuartzJobBean {

    @Resource
    private IJobService jobService;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        jobService.syncCompanyBusinessRecord();
    }
}
