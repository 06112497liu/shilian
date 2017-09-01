/**
 * BBD Service Inc
 * All Rights Reserved @2017
 */
package com.bbd.service.reddata.activity.impl;

import com.bbd.dao.BusinessMonthStatisticsInfoDao;
import com.bbd.dao.activity.CompanyActivityDao;
import com.bbd.dao.company.CompanyExtDao;
import com.bbd.domain.BusinessMonthStatisticsInfo;
import com.bbd.domain.BusinessMonthStatisticsInfoExample;
import com.bbd.service.reddata.activity.ICompanyActivityService;
import com.bbd.service.reddata.company.ICompanyService;
import com.mybatis.domain.PageBounds;
import org.joda.time.DateTime;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 企业活动服务实现
 *
 * @author wangtianjing
 * @version $Id CompanyActivityServiceImpl.java, v 0.1 2017/5/4 17:23 wangtianjing
 *          Exp $
 */
@Component
@Transactional(rollbackFor = Exception.class)
public class CompanyActivityServiceImpl implements ICompanyActivityService {

    @Resource
    private CompanyExtDao                  companyExtDao;

    @Resource
    private CompanyActivityDao             companyActivityDao;

    @Resource
    private BusinessMonthStatisticsInfoDao businessMonthStatisticsInfoDao;

    @Resource
    private ICompanyService                companyService;

    @Override
    public void generateMonthStatistic(int year, int month) {
        if (isStatisticsExists(year, month)) {
            return;
        }
        companyActivityDao.insertCompanyMonthStatistics(year, month);
        companyActivityDao.updateLostState(year, month);
        companyActivityDao.updateSuspendNotCancelState(year, month);
        companyActivityDao.updateSeriousIllegal(year, month);
        companyActivityDao.updateActivityExponentWithoutAnnual(year, month);
        companyActivityDao.updateActivityExponentByAnnual(year, month);
        companyActivityDao.updateCompanyActivityType(year, month);

        DateTime dateTime = new DateTime();
        dateTime = dateTime.plusMonths(-1);
        if (year == dateTime.getYear() && month == dateTime.getMonthOfYear()) {
            companyService.syncBusinessRecord(year, month);
        }

        doUpdateCompanyBusinessInfo(year, month);
    }

    @Override
    public void updateCompanyBusinessInfo(int year, int month) {
        doUpdateCompanyBusinessInfo(year, month);
    }

    /**
     * 冗余经营活动信息到bbd_enterprise_info中
     *
     * @param year
     * @param month
     */
    private void doUpdateCompanyBusinessInfo(int year, int month) {
        DateTime dateTime = new DateTime();
        dateTime = dateTime.plusMonths(-1);

        if (year == dateTime.getYear() && month == dateTime.getMonthOfYear()) {
            // companyService.syncBusinessRecord(year, month);
            // 更新bbd_enterprise_info的指数
            companyExtDao.updateCompanyIndexScore(year, month);
            // 更新bbd_enterprise_info的经营活动
            companyExtDao.updateCompanyBusinessRecord(year, month);
        }

    }

    /**
     * 判断数据是否已经生成
     *
     * @param year
     * @param month
     * @return
     */
    private boolean isStatisticsExists(int year, int month) {
        BusinessMonthStatisticsInfoExample exam = new BusinessMonthStatisticsInfoExample();
        exam.createCriteria().andActivityYearEqualTo(year).andActivityMonthEqualTo(month);
        PageBounds pb = new PageBounds(1, 1, false);
        List<BusinessMonthStatisticsInfo> ds = businessMonthStatisticsInfoDao.selectByExampleWithPageBounds(exam, pb);
        if (ds.size() > 0) {
            return true;
        }
        return false;
    }
}
