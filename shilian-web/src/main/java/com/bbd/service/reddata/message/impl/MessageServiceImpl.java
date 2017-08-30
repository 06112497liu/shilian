/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.service.reddata.message.impl;

import com.bbd.bean.remind.RemindCompany;
import com.bbd.common.MessageTaskConstants;
import com.bbd.common.ResultConst;
import com.bbd.dao.CompanyRemindDetailInfoDao;
import com.bbd.dao.CompanyRemindQueueInfoDao;
import com.bbd.domain.CompanyRemindDetailInfo;
import com.bbd.message.email.EmailResult;
import com.bbd.message.sms.SmsResult;
import com.bbd.service.reddata.message.BBDMessageService;
import com.bbd.service.reddata.message.IMessageService;
import com.bbd.service.reddata.message.vo.EmailContentVO;
import com.bbd.service.reddata.message.vo.SmsContentVO;
import com.bbd.service.reddata.remind.ICompanyRemindService;
import com.bbd.service.reddata.remind.IMsgTaskService;
import com.bbd.service.utils.EmailSenders;
import com.bbd.service.utils.SmsSenders;
import com.bbd.util.ConfigUtil;
import com.bbd.util.StringUtils;
import com.google.common.collect.Lists;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.MessageFormat;
import java.util.Date;
import java.util.List;

/**
 * 消息发送服务实现 - 邮件，短信，语音
 *
 * @author tjwang
 * @version $Id: MessageServiceImpl.java, v 0.1 2017/6/8 0008 9:44 tjwang Exp $
 */
@Service
public class MessageServiceImpl implements IMessageService {

    private Logger                     logger = LoggerFactory.getLogger(getClass());

    @Resource
    private CompanyRemindDetailInfoDao companyRemindDetailInfoDao;

    @Resource
    private CompanyRemindQueueInfoDao  companyRemindQueueInfoDao;

    @Resource
    private IMsgTaskService            msgTaskService;

    @Resource
    private ICompanyRemindService      companyRemindStatisticService;

    @Resource
    private EmailSenders               emailSenders;

    @Resource
    private SmsSenders                 smsSenders;

    @Resource
    private BBDMessageService          bbdMessageService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void sendRemindEmail(RemindCompany info) {
        int status = doSendRemindEmail(info);
        if (status == 0) {
            return;
        }

        int taskId = info.getTaskId();
        if (status == 1) {
            msgTaskService.increaseSuccess(taskId);
        } else {
            msgTaskService.increaseFail(taskId);
        }
        deleteQueuedRemindMsg(info.getQueueId());
    }

    /**
     * 发送邮件。结果有三种状态：0.超限；1.成功；2.失败。
     *
     * @param info
     * @return
     */
    private int doSendRemindEmail(RemindCompany info) {
        if (emailSenders.isAllOutOfLimit()) {
            return 0;
        }
        int status = 2;

        String nbxh = info.getNbxh();
        int taskId = info.getTaskId();
        int type = info.getType();
        String district = info.getDistrict();
        Date planDate = info.getPlanDate();
        Date now = new Date();
        DateTime dateTime = new DateTime(planDate);
        int year = dateTime.getYear();
        int month = dateTime.getMonthOfYear();
        int day = dateTime.getDayOfYear();

        // 根据发送类型获取 邮件主题
        //其他类型待添加
        EmailContentVO contentVO = getEmailContent(info);
        // 找不到可用的主题和内容，或type错误。
        if (contentVO.isBlank()) {
            CompanyRemindDetailInfo detail = buildBaseCompanyRemindDetailInfo(nbxh, taskId, MessageTaskConstants.EMAIL_METHOD, type, "", year, month, day, district, now);
            detail.setReason(ResultConst.NO_EMAIL_CONTENT_MATCH);
            detail.setStatus(ResultConst.FAIL_STATUS);
            companyRemindDetailInfoDao.insertSelective(detail);
            companyRemindStatisticService.updateOrCreate(false, nbxh, year, MessageTaskConstants.EMAIL_METHOD);
            return status;
        }

        String subject = contentVO.getSubject();
        String content = contentVO.getContent();

        List<String> emails = Lists.newArrayList();
        String es = info.getEmails();
        if (StringUtils.isNotBlank(es)) {
            es = es.replaceAll(",", ";");
            emails = StringUtils.getValidEmails(es);
        }
        if (emails.size() == 0) {
            emails.addAll(bbdMessageService.getBBDEmails(nbxh));
        }

        if (emails.size() == 0) {
            CompanyRemindDetailInfo detail = buildBaseCompanyRemindDetailInfo(nbxh, taskId, MessageTaskConstants.EMAIL_METHOD, type, content, year, month, day, district, now);
            detail.setReason(ResultConst.NO_EMAILADDRESS);
            detail.setStatus(ResultConst.FAIL_STATUS);
            companyRemindDetailInfoDao.insertSelective(detail);
            companyRemindStatisticService.updateOrCreate(false, nbxh, year, MessageTaskConstants.EMAIL_METHOD);
            return status;
        }

        try {
            for (String email : emails) {
                email = email.trim();
                CompanyRemindDetailInfo detail = buildBaseCompanyRemindDetailInfo(nbxh, taskId, MessageTaskConstants.EMAIL_METHOD, type, content, year, month, day, district, now);
                detail.setTarget(email);
                //邮件发送
                EmailResult sendResult = emailSenders.send(email, content, subject);
                //发送成功
                if (sendResult.isSuccess()) {
                    detail.setSource(sendResult.getHost());
                    detail.setStatus(ResultConst.SUCCESS_STATUS);
                    companyRemindDetailInfoDao.insertSelective(detail);
                    companyRemindStatisticService.updateOrCreate(true, nbxh, year, MessageTaskConstants.EMAIL_METHOD);
                    status = 1;
                    break;
                } else {
                    //发送失败
                    detail.setSource(sendResult.getHost());
                    detail.setStatus(ResultConst.FAIL_STATUS);
                    detail.setReason(sendResult.getMessage());
                    companyRemindDetailInfoDao.insertSelective(detail);
                    companyRemindStatisticService.updateOrCreate(false, nbxh, year, MessageTaskConstants.EMAIL_METHOD);
                    // 发送超限
                    if (sendResult.isLimitReached()) {
                        break;
                    }
                    continue;
                }
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            CompanyRemindDetailInfo detail = buildBaseCompanyRemindDetailInfo(nbxh, taskId, MessageTaskConstants.EMAIL_METHOD, type, content, year, month, day, district, now);
            detail.setStatus(ResultConst.FAIL_STATUS);
            detail.setReason("程序执行异常");
            companyRemindDetailInfoDao.insertSelective(detail);
            companyRemindStatisticService.updateOrCreate(false, nbxh, year, MessageTaskConstants.EMAIL_METHOD);
            status = 2;
        }
        return status;
    }

    private EmailContentVO getEmailContent(RemindCompany info) {
        EmailContentVO vo = new EmailContentVO();
        int type = info.getType();
        String subject;
        String content;
        DateTime time = new DateTime();
        int curYear = time.getYear();
        time = time.plusYears(-1);
        int prevYear = time.getYear();
        switch (type) {
            case 1:
                subject = ConfigUtil.getMailAnnulSubject();
                content = ConfigUtil.getMailAnnualContent();
                content = MessageFormat.format(content, prevYear + "", curYear + "");
                vo.setContent(content);
                vo.setSubject(subject);
                break;
            case 2:
                subject = "失联企业提醒";
                content = ConfigUtil.getMailLostContent();
                content = MessageFormat.format(content, info.getCompanyName());
                vo.setContent(content);
                vo.setSubject(subject);
                break;
            case 3:
                subject = "未年报企业提醒";
                content = ConfigUtil.getMailLostContent();
                content = MessageFormat.format(content, info.getCompanyName());
                vo.setContent(content);
                vo.setSubject(subject);
                break;
            case 4:
                subject = "未公示企业提醒";
                content = ConfigUtil.getMailLostContent();
                content = MessageFormat.format(content, info.getCompanyName());
                vo.setContent(content);
                vo.setSubject(subject);
                break;
            case 5:
                subject = "虚假信息企业提醒";
                content = ConfigUtil.getMailLostContent();
                content = MessageFormat.format(content, info.getCompanyName());
                vo.setContent(content);
                vo.setSubject(subject);
                break;
            default:
                logger.error("Email send info with type {}, do not have matching subject or content", type);
                break;
        }
        return vo;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void sendRemindSms(RemindCompany info) {
        boolean success = doSendRemindSms(info);

        int taskId = info.getTaskId();
        if (success) {
            msgTaskService.increaseSuccess(taskId);
        } else {
            msgTaskService.increaseFail(taskId);
        }
        deleteQueuedRemindMsg(info.getQueueId());
    }

    private boolean doSendRemindSms(RemindCompany info) {
        String nbxh = info.getNbxh();
        int taskId = info.getTaskId();
        int type = info.getType();
        String district = info.getDistrict();
        Date planDate = info.getPlanDate();
        Date now = new Date();
        DateTime dateTime = new DateTime(planDate);
        int year = dateTime.getYear();
        int month = dateTime.getMonthOfYear();
        int day = dateTime.getDayOfYear();

        SmsContentVO contentVO = getSmsContent(info);
        if (contentVO.isBlank()) {
            CompanyRemindDetailInfo detail = buildBaseCompanyRemindDetailInfo(nbxh, taskId, MessageTaskConstants.SMS_METHOD, type, "", year, month, day, district, now);
            detail.setReason(ResultConst.NO_SMS_CONTENT_MATCH);
            detail.setStatus(ResultConst.FAIL_STATUS);
            companyRemindDetailInfoDao.insertSelective(detail);
            companyRemindStatisticService.updateOrCreate(false, nbxh, year, MessageTaskConstants.SMS_METHOD);
        }

        String smsTemplateCode = contentVO.getSmsTemplateCode();
        String params = contentVO.getParam();

        List<String> phoneNums = Lists.newArrayList();
        String ps = info.getPhones();
        if (StringUtils.isNotBlank(ps)) {
            ps = ps.replaceAll(",", ";");
            phoneNums = StringUtils.getValidPhones(ps);
        }
        if (phoneNums.size() == 0) {
            phoneNums.addAll(bbdMessageService.getBBDSms(nbxh));
        }

        if (phoneNums.size() == 0) {
            CompanyRemindDetailInfo detail = buildBaseCompanyRemindDetailInfo(nbxh, taskId, MessageTaskConstants.SMS_METHOD, type, smsTemplateCode, year, month, day, district, now);
            detail.setReason(ResultConst.NO_PHONENUM);
            detail.setStatus(ResultConst.FAIL_STATUS);
            companyRemindDetailInfoDao.insertSelective(detail);
            companyRemindStatisticService.updateOrCreate(false, nbxh, year, MessageTaskConstants.SMS_METHOD);
            return false;
        }

        try {
            for (String phone : phoneNums) {
                phone = phone.trim();
                CompanyRemindDetailInfo detail = buildBaseCompanyRemindDetailInfo(nbxh, taskId, MessageTaskConstants.SMS_METHOD, type, smsTemplateCode, year, month, day, district, now);
                detail.setTarget(phone);

                //短信发送
                SmsResult result = smsSenders.send(phone, params, smsTemplateCode);
                //发送成功
                if (result.isSuccess()) {
                    detail.setSource("");
                    detail.setStatus(ResultConst.SUCCESS_STATUS);
                    companyRemindDetailInfoDao.insertSelective(detail);
                    companyRemindStatisticService.updateOrCreate(true, nbxh, year, MessageTaskConstants.SMS_METHOD);
                    return true;
                } else {
                    //发送失败
                    detail.setSource("");
                    detail.setStatus(ResultConst.FAIL_STATUS);
                    detail.setReason(result.getState());
                    companyRemindDetailInfoDao.insertSelective(detail);
                    companyRemindStatisticService.updateOrCreate(false, nbxh, year, MessageTaskConstants.SMS_METHOD);
                    continue;
                }
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            CompanyRemindDetailInfo detail = buildBaseCompanyRemindDetailInfo(nbxh, taskId, MessageTaskConstants.SMS_METHOD, type, smsTemplateCode, year, month, day, district, now);
            detail.setStatus(ResultConst.FAIL_STATUS);
            detail.setReason("程序执行异常");
            companyRemindDetailInfoDao.insertSelective(detail);
            companyRemindStatisticService.updateOrCreate(false, nbxh, year, MessageTaskConstants.SMS_METHOD);
        }
        return false;
    }

    private SmsContentVO getSmsContent(RemindCompany info) {
        SmsContentVO vo = new SmsContentVO();
        int type = info.getType();
        String templateCode = "";
        String param = "";
        switch (type) {
            case 1:
                templateCode = ConfigUtil.getSmsTemplateCodeAnnualPrompt();
                break;
            case 2:
            case 3:
            case 4:
            case 5:
                templateCode = ConfigUtil.getSmsTemplateCodeLostPrompt();
                break;
            default:
                logger.error("Sms send info with type {}, do not have matching template code", type);
                break;
        }
        vo.setParam(param);
        vo.setSmsTemplateCode(templateCode);
        return vo;
    }

    //    @Override
    //    @Transactional(rollbackFor = Exception.class)
    //    public void sendRemindMessage(RemindCompany info) {
    //        int taskId = info.getTaskId();
    //        int status = doSendRemindEmail(info);
    //        if (status > 0) {
    //            boolean succes = doSendRemindSms(info);
    //            deleteQueuedRemindMsg(info.getQueueId());
    //            if (succes) {
    //                msgTaskService.increaseSuccess(taskId);
    //            } else {
    //                msgTaskService.increaseFail(taskId);
    //            }
    //        }
    //    }

    /**
     * 根据提示类型获取短信模板
     *
     * @param type
     * @return
     */
    private String getSmsTemplateParamStr(int type) {
        return "10000";
    }

    private CompanyRemindDetailInfo buildBaseCompanyRemindDetailInfo(String nbxh, int taskId, int method, int type, String content, int sendYear, int sendMonth, int sendDay, String district, Date now) {
        CompanyRemindDetailInfo detail = new CompanyRemindDetailInfo();
        detail.setNbxh(nbxh);
        detail.setTaskId(taskId);
        detail.setMethod(method);
        detail.setType(type);
        detail.setContent(content);
        detail.setSendYear(sendYear);
        detail.setSendMonth(sendMonth);
        detail.setSendDay(sendDay);
        detail.setDistrict(district);
        detail.setSendTime(now);
        detail.setGmtCreate(now);
        return detail;
    }

    /**
     * 删除发送队列中的数据
     *
     * @param queueId
     */
    private void deleteQueuedRemindMsg(Integer queueId) {
        companyRemindQueueInfoDao.deleteByPrimaryKey(queueId);
    }
}
