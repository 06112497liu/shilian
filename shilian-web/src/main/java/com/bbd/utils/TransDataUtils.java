/** 
 * BBD Service Inc 
 * All Rights Reserved @2017 
 */
package com.bbd.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.joda.time.DateTime;
import org.joda.time.Days;

import com.bbd.bean.statistics.NameValueInfo;
import com.bbd.bean.statistics.TimelineStatisticInfo;
import com.bbd.controller.param.CompanyRemindDailyCountVO;
import com.bbd.controller.param.CompanyRemindMonthlyCountVO;
import com.bbd.domain.CompanyRemindDailyCountInfo;
import com.bbd.domain.CompanyRemindMonthlyCountInfo;
import com.google.common.collect.Lists;

/** 
 * 数据转化工具类
 * @author liuweibo 
 * @version $Id: TransDataUtils.java, v 0.1 2017年6月15日 下午4:42:09 liuweibo Exp $ 
 */
public class TransDataUtils {

    public static TimelineStatisticInfo transDailyCountInfo(List<CompanyRemindDailyCountVO> list) {
        List<NameValueInfo> trans = Lists.newLinkedList();
        CompanyRemindDailyCountVO vo = null;
        for (int i = 0; i < list.size(); i++) {
            NameValueInfo info = new NameValueInfo();
            vo = list.get(i);
            String name = vo.getMonth() + "月" + vo.getDay() + "日";
            String value = String.valueOf(vo.getCount());
            info.setName(name);
            info.setValue(value);
            trans.add(info);
        }
        return new TimelineStatisticInfo(trans);
    }

    public static TimelineStatisticInfo transMonthlyCountInfo(List<CompanyRemindMonthlyCountVO> list) {
        List<NameValueInfo> trans = Lists.newLinkedList();
        CompanyRemindMonthlyCountVO vo = null;
        for (int i = 0; i < list.size(); i++) {
            NameValueInfo info = new NameValueInfo();
            vo = list.get(i);
            String name = vo.getYear() + "年" + vo.getMonth() + "月";
            String value = String.valueOf(vo.getCount());
            info.setName(name);
            info.setValue(value);
            trans.add(info);
        }
        return new TimelineStatisticInfo(trans);
    }
    
    public static List<CompanyRemindDailyCountInfo> fillDayData(List<CompanyRemindDailyCountInfo> list) {
        DateTime dateTime = new DateTime();
        dateTime = dateTime.plus(-1);

        int year = dateTime.getYear();
        DateTime start = new DateTime(year, 1, 1, 0, 0, 0);

        Days days = Days.daysBetween(start, dateTime);
        int num = days.getDays();

        Map<Integer, CompanyRemindDailyCountInfo> map = list.stream().collect(Collectors.toMap(CompanyRemindDailyCountInfo::getDay, p -> p));
        Set<Integer> keys = map.keySet();

        List<CompanyRemindDailyCountInfo> rs = new ArrayList<>(num);
        for (int i = 1; i <= num; i++) {
            if (keys.contains(i)) {
                CompanyRemindDailyCountInfo info = map.get(i);
                rs.add(info);
            } else {
                CompanyRemindDailyCountInfo vo = new CompanyRemindDailyCountInfo();
                vo.setDay(i);
                vo.setYear(year);
                vo.setCount(0);
                rs.add(vo);
            }
        }
        return rs;
    }
    
    public static List<CompanyRemindMonthlyCountInfo> fillMonthData(List<CompanyRemindMonthlyCountInfo> list) {
        DateTime dateTime = new DateTime();
        int year = dateTime.getYear();

        Map<Integer, CompanyRemindMonthlyCountInfo> map = list.stream().collect(Collectors.toMap(CompanyRemindMonthlyCountInfo::getMonth, p -> p));
        Set<Integer> keys = map.keySet();

        List<CompanyRemindMonthlyCountInfo> rs = new ArrayList<>(12);
        for (int i = 1; i <= 12; i++) {
            if (keys.contains(i)) {
                CompanyRemindMonthlyCountInfo info = map.get(i);
                rs.add(info);
            } else {
                CompanyRemindMonthlyCountInfo vo = new CompanyRemindMonthlyCountInfo();
                vo.setMonth(i);
                vo.setYear(year);
                vo.setCount(0);
                rs.add(vo);
            }
        }
        return rs;
    }

}
