/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.service.reddata.message.impl;

import com.bbd.common.CacheConstants;
import com.bbd.dao.IndexPurchaseInfoDao;
import com.bbd.dao.IndexRecruitInfoDao;
import com.bbd.domain.IndexPurchaseInfo;
import com.bbd.domain.IndexPurchaseInfoExample;
import com.bbd.domain.IndexRecruitInfo;
import com.bbd.domain.IndexRecruitInfoExample;
import com.bbd.service.reddata.message.BBDMessageService;
import com.bbd.util.StringUtils;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * BBD针对消息发送消息服务实现
 *
 * @author tjwang
 * @version $Id: BBDMessageServiceImpl.java, v 0.1 2017/6/20 0020 10:54 tjwang Exp $
 */
@Service
public class BBDMessageServiceImpl implements BBDMessageService {

    @Resource
    private IndexPurchaseInfoDao indexPurchaseInfoDao;

    @Resource
    private IndexRecruitInfoDao  indexRecruitInfoDao;

    @Override
    @Cacheable(value = CacheConstants.COMPANY_INFO_EXT, keyGenerator = "simpleKeyGenerator")
    public List<String> getBBDEmails(String nbxh) {
        Preconditions.checkArgument(StringUtils.isNotBlank(nbxh), "NBXH不能为空");

        List<String> emails = Lists.newArrayList();

        List<IndexPurchaseInfo> ps = getPurchaseInfos(nbxh);
        for (IndexPurchaseInfo p : ps) {
            String es = p.geteMail();
            emails.addAll(StringUtils.getValidEmails(es));
        }

        List<IndexRecruitInfo> rs = getRecruitInfos(nbxh);
        for (IndexRecruitInfo r : rs) {
            String es = r.geteMail();
            emails.addAll(StringUtils.getValidEmails(es));
        }

        return emails;
    }

    private List<IndexPurchaseInfo> getPurchaseInfos(String nbxh) {
        IndexPurchaseInfoExample exam = new IndexPurchaseInfoExample();
        exam.createCriteria().andCompanyIdEqualTo(nbxh);

        List<IndexPurchaseInfo> ds = indexPurchaseInfoDao.selectByExample(exam);
        return ds;
    }

    private List<IndexRecruitInfo> getRecruitInfos(String nbxh) {
        IndexRecruitInfoExample exam = new IndexRecruitInfoExample();
        exam.createCriteria().andCompanyIdEqualTo(nbxh);

        List<IndexRecruitInfo> ds = indexRecruitInfoDao.selectByExample(exam);
        return ds;
    }

    @Override
    @Cacheable(value = CacheConstants.COMPANY_INFO_EXT, keyGenerator = "simpleKeyGenerator")
    public List<String> getBBDSms(String nbxh) {
        Preconditions.checkArgument(StringUtils.isNotBlank(nbxh), "NBXH不能为空");

        List<String> phones = Lists.newArrayList();

        List<IndexPurchaseInfo> ds = getPurchaseInfos(nbxh);
        for (IndexPurchaseInfo d : ds) {
            String phone = d.getTelephone();
            phones.addAll(StringUtils.getValidPhones(phone));
        }

        List<IndexRecruitInfo> rs = getRecruitInfos(nbxh);
        for (IndexRecruitInfo r : rs) {
            String phone = r.getContactInformation();
            phones.addAll(StringUtils.getValidPhones(phone));
        }

        return phones;
    }

}
