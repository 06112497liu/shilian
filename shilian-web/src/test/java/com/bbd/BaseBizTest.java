/**  
 * BBD Service Inc
 * All Rights Reserved @2016
 *
 */
package com.bbd;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * Spring  biz 测试环境 .
 * 
 * <p>继承该类，直接写junit4测试, 默认事务回滚, 不会产生垃圾数据.
 * 如果不需要数据回滚请加上该注解{@link org.springframework.test.annotation.Rollback} @Rollback(false)</p>
 * 
 * @author zhanghui
 * @version $Id: EnvironmentTest.java, v 0.1 2016年12月5日 下午3:20:21 zhanghui Exp $
 */
@ContextConfiguration({ "classpath:applicationContext.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public abstract class BaseBizTest extends Assert {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    protected Gson   gson   = new GsonBuilder().serializeNulls().setDateFormat("yyyy.MM.dd HH:mm:ss").setPrettyPrinting().create();

    private long     startTime;

    @Before
    public void before() {
        logger.debug("");
        logger.debug("----------test before {}-------------------", getClass().getSimpleName());
        startTime = System.currentTimeMillis();
    }

    @After
    public void after() {
        logger.debug("----------test after {} total time {}ms------", getClass().getSimpleName(), System.currentTimeMillis() - startTime);
        logger.debug("");
    }

    /**
     * 获取json字符串用于打印
     */
    public String toPrintJosnString(Object object) {
        return gson.toJson(object);
    }
}
