/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.service;

import com.bbd.BaseBizTest;
import com.bbd.service.reddata.activity.ICompanyActivityService;
import org.joda.time.DateTime;
import org.joda.time.Months;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 企业活动指数服务测试
 *
 * @author tjwang
 * @version $Id: CompanyActivityServiceTest.java, v 0.1 2017/6/5 0005 11:07 tjwang Exp $
 */
public class CompanyActivityServiceTest extends BaseBizTest {

    @Resource
    private ICompanyActivityService companyActivityService;

    @Test
    @Rollback(false)
    @Transactional(propagation = Propagation.NEVER)
    //@Ignore
    public void testGenerateMonthStatistic() {
        // 当前月往前推到上年1月，不包含当月
        DateTime dateTime = new DateTime();
        int curYear = dateTime.getYear();
        int curMonth = dateTime.getMonthOfYear();

        DateTime lastYear = new DateTime(curYear - 1, 1, 1, 0, 0, 0);
        int num = Months.monthsBetween(lastYear, dateTime).getMonths();

        dateTime = dateTime.plusMonths(0 - num); // 当月不计算

        for (int i = 1; i <= num; i++) {
            long start = System.currentTimeMillis();
            int year = dateTime.getYear();
            int month = dateTime.getMonthOfYear();
            System.out.println("year : " + year + ", month : " + month);

            //            if (curYear != year) {
            //                dateTime = dateTime.plusMonths(1);
            //                continue;
            //            }
            //
            //            if (month == (curMonth - 1)) {
            //                dateTime = dateTime.plusMonths(1);
            //                continue;
            //            }

            companyActivityService.generateMonthStatistic(year, month);

            dateTime = dateTime.plusMonths(1);
            long end = System.currentTimeMillis();
            System.out.println("time used : " + (end - start));
        }
    }

    @Test
    @Rollback(false)
    //@Ignore
    public void testGenerateSpecificMonthStatistic() {
        int year = 2017;
        int month = 8;
        System.out.println("year : " + year + ", month : " + month);
        companyActivityService.generateMonthStatistic(year, month);
        System.out.println("结束");
    }

    @Test
    @Rollback(false)
    //@Ignore
    public void testUpdateCompanyBusinessInfo() {
        int year = 2017;
        int month = 6;
        companyActivityService.updateCompanyBusinessInfo(year, month);
    }
}
