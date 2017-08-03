/** 
 * BBD Service Inc 
 * All Rights Reserved @2017 
 */
package com.bbd.service.reddata.company.impl;

import com.bbd.bean.company.AffiliatedCompanyVo;
import com.bbd.bean.company.LineVo;
import com.bbd.service.reddata.company.ICompanyAffiliatedService;
import com.bbd.util.AddressUtil;
import com.bbd.util.SortUtil;
import com.bbd.utils.HandlerUtil;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/** 
 *  
 * @author liuweibo 
 * @version $Id: CompanyAffiliatedServiceImpl.java, v 0.1 2017年5月4日 下午3:05:06 liuweibo Exp $ 
 */
@Service("companyAffiliatedService")
public class CompanyAffiliatedServiceImpl implements ICompanyAffiliatedService {

    @Resource
    private RedisTemplate redisTemplate;

    /**
     * 获取企业关联方信息 
     */
    @SuppressWarnings("unchecked")
    @Override
    @Transactional
    public AffiliatedCompanyVo getCompanyAffiliated(Long level, String companyName) {
        String json = HandlerUtil.getJson(level, companyName);
        AffiliatedCompanyVo affiliatedCompany = new AffiliatedCompanyVo();
        affiliatedCompany.setPointList(HandlerUtil.findPointVo(json));
        affiliatedCompany.setLineList(HandlerUtil.findLineVo(json));
        return affiliatedCompany;
    }

    /**
     * 获取关联方联系信息
     */
    @Override
    public Map<String, String> getContactMessage(String companyName) {
        return AddressUtil.getAffiliatedCompanyContact(companyName, redisTemplate);
    }

    /**
     * 一键下载获取企业关联方信息
     */
    @Override
    public List<LineVo> findLineVo(Long level, String companyName) {
        String json = HandlerUtil.getJson(level, companyName);
        Set set = HandlerUtil.findLineVo(json);
        List<LineVo> lineVoList = new ArrayList<>(set);
        SortUtil.sort(lineVoList, "orig", "asc");
        return lineVoList;
    }

}
