/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 调度任务注解。用于为调度任务方法做切面。
 * 指定时间点（年|月|日|时|分）只能执行一次时使用。
 * 注意，不适用于一个时间段只能执行一次的任务
 *
 * @author tjwang
 * @version $Id: ScheduleTask.java, v 0.1 2017/6/27 0027 14:03 tjwang Exp $
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ScheduleTask {

    /**
     * 任务名称，唯一
     *
     * @return
     */
    String name() default "";

    /**
     * 任务频率
     *
     * @return
     */
    TimePoint point() default TimePoint.NONE;

    /**
     * 指定frequence时间段是否只能执行一次。
     * true：某些统计任务每月执行一次。为了每月至少执行一次，每天都会判断任务是否已执行。如果已执行则不处理。
     * false：有些任务到时候就执行，没有执行次数限制。比如消息发送。
     *
     * @return
     */
    boolean unique() default false;

    /**
     * 记录频率。对于一些执行很频繁的任务，无需每次都记录运行状态，可设置每执行多少次进行一次记录。
     * 1. 每条记录;
     * 10. 每执行10次记录一条
     *
     * @return
     */
    int recordFrequence() default 1;

    enum TimePoint {
        NONE(0),
        /**
         * 间隔时间单位为分钟
         */
        MINITE(1),
        /**
         * 间隔时间单位为小时
         */
        HOUR(2),
        /**
         * 间隔时间单位为天
         */
        DAY(3),
        /**
         * 间隔时间单位为月
         */
        MONTH(4);

        private int value;

        TimePoint(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

}
