/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.service.utils;

import com.bbd.Constants;
import com.bbd.common.ResultConst;
import com.bbd.dao.EmailConfigInfoDao;
import com.bbd.domain.EmailConfigInfo;
import com.bbd.domain.EmailConfigInfoExample;
import com.bbd.message.email.AbstractEmailSender;
import com.bbd.message.email.EmailResult;
import com.bbd.message.email.EmailSender;
import com.bbd.message.email.MockEmailSender;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;

/**
 * 包含多个EmailSender，以一定算法将待发送消息分配给各个EmailSender
 *
 * @author tjwang
 * @version $Id: EmailSenders.java, v 0.1 2017/6/7 0007 9:52 tjwang Exp $
 */
@Service
public class EmailSenders {

    @Resource
    private EmailConfigInfoDao        emailConfigInfoDao;

    @Value("${email.mock.enable:false}")
    private boolean                   emailMockEnable = false;

    private List<AbstractEmailSender> senders         = Lists.newArrayList();

    @PostConstruct
    public void init() {
        if (emailMockEnable) {
            MockEmailSender sender = new MockEmailSender("mock");
            senders.add(sender);
        } else {
            EmailConfigInfoExample exam = new EmailConfigInfoExample();
            exam.setOrderByClause("priority desc");
            exam.createCriteria().andEnabledEqualTo(true);
            List<EmailConfigInfo> ds = emailConfigInfoDao.selectByExample(exam);
            for (EmailConfigInfo d : ds) {
                String username = d.getEmail();
                String pwd = d.getPwd();
                String host = d.getServer();
                int port = d.getPort();

                EmailSender sender = new EmailSender(username, pwd, host, port);
                senders.add(sender);
            }
        }
    }

    public EmailResult send(String target, String content, String subject) {
        EmailResult result = new EmailResult(Constants.SUCCESS, "");

        boolean outOfLimit = true;
        for (AbstractEmailSender sender : senders) {
            EmailResult r = sender.send(target, content, subject);
            if (r.isLimitReached()) {
                continue;
            }
            outOfLimit = false;
            result = r;
            break;
        }
        if (outOfLimit) {
            result = new EmailResult(ResultConst.EMAIL_EXCEPTION_OUT_OF_LIMIT, "");
        }
        return result;
    }

    /**
     * 所有sender都超限
     *
     * @return
     */
    public boolean isAllOutOfLimit() {
        boolean all = true;
        for (AbstractEmailSender sender : senders) {
            if (!sender.isOutOfLimit()) {
                all = false;
                break;
            }
        }
        return all;
    }

}
