/**
 * Project Name:ckl
 * File Name:SystemLogAdvice.java
 * Copyright (c) 成都友木科技 2016
 */
package com.bbd.service.reddata.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 日志
 * 
 * @author xc
 * @version $Id: LogAdvice.java, v 0.1 2016年12月2日 下午6:22:32 xc Exp $
 */
@Component
@Aspect
public class LogAdvice {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Pointcut("execution(* com.bbd.**.service.impl..*.*(..))")
    public void pointCut() {
    }

    @Around("pointCut()")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        Object obj = null;
        logStart(joinPoint);
        try {
            obj = joinPoint.proceed();
        } catch (Throwable e) {
            logger.debug("exception: ", e);
            throw e;
        } finally {
            logEnd(joinPoint);
        }
        return obj;
    }

    private void logStart(ProceedingJoinPoint joinPoint) {
        if (logger.isDebugEnabled()) {
            logger.debug("");
            logger.debug("--- starting {} --------------------------------------------------------", getOprName(joinPoint));
        }
    }

    private void logEnd(ProceedingJoinPoint joinPoint) {
        if (logger.isDebugEnabled()) {
            logger.debug("--- {} finished --------------------------------------------------------", getOprName(joinPoint));
            logger.debug("");
        }
    }

    public String getOprName(ProceedingJoinPoint joinPoint) {
        // 获取当前服务的class
        Class<?> serviceClass = joinPoint.getTarget().getClass();
        // 获取执行的方法  
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        // 创建日志对象
        String prefix = serviceClass.getSimpleName();
        String suffix = methodSignature.getMethod().getName();
        return prefix + ":" + suffix;
    }

}
