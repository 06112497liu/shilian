/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.service.reddata.company;

import com.bbd.bean.statistics.NameValueInfo;
import com.bbd.dao.BusinessTypeInfoDao;
import com.bbd.dao.CompanyIndustryInfoDao;
import com.bbd.dao.CompanyTypeMappingInfoDao;
import com.bbd.dao.company.CompanyExtDao;
import com.bbd.domain.*;
import com.google.common.collect.Maps;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 企业工具类
 * @author tjwang
 * @version $Id: CompanyUtil.java, v 0.1 2017/6/5 0005 16:37 tjwang Exp $
 */
@Service
public class CompanyUtil {
    @Resource
    private CompanyIndustryInfoDao    companyIndustryInfoDao;

    @Resource
    private CompanyTypeMappingInfoDao companyTypeMappingInfoDao;

    @Resource
    private BusinessTypeInfoDao       businessTypeInfoDao;
    
    @Resource
    private CompanyExtDao             companyExtDao;

    /**
     * 获取所有一级行业
     * @return
     */
    @Cacheable(value = "company_util_info", keyGenerator = "simpleKeyGenerator")
    public Map<String, String> getPrimaryIndustryMap() {
        CompanyIndustryInfoExample exam = new CompanyIndustryInfoExample();
        List<CompanyIndustryInfo> ds = companyIndustryInfoDao.selectByExample(exam);
        Map<String, String> map = Maps.newHashMap();
        for (CompanyIndustryInfo d : ds) {
            map.put(d.getCode(), d.getName());
        }
        return map;
    }

    /**
     * 获取所有企业性质
     * @return
     */
    @Cacheable(value = "company_util_info", keyGenerator = "simpleKeyGenerator")
    public Map<String, String> getCompanyPropertyMap() {
        CompanyTypeMappingInfoExample exam = new CompanyTypeMappingInfoExample();
        List<CompanyTypeMappingInfo> ds = companyTypeMappingInfoDao.selectByExample(exam);

        Map<String, String> map = Maps.newHashMap();
        for (CompanyTypeMappingInfo d : ds) {
            map.put(d.getCompanyType().toString(), d.getDescription());
        }

        return map;
    }

    /**
     * 获取所有经营活动类型
     * @return
     */
    @Cacheable(value = "company_util_info", keyGenerator = "simpleKeyGenerator")
    public Map<String, String> getBusinessTypeMap() {
        BusinessTypeInfoExample exam = new BusinessTypeInfoExample();
        List<BusinessTypeInfo> ds = businessTypeInfoDao.selectByExample(exam);

        Map<String, String> map = Maps.newHashMap();
        for (BusinessTypeInfo d : ds) {
            map.put(d.getType().toString(), d.getName());
        }
        
        map.remove("6");
        map.put("7", "招中标");

        return map;
    }
    
    /**
     * 获取各区域企业数量
     * @return
     */
    @Cacheable(value = "company_util_info", keyGenerator = "simpleKeyGenerator")
    public Map<String, Long> getCompanyCoutByDistrict() {
        List<NameValueInfo> dbList = companyExtDao.selectCompanyGroupByDistrict();
        
        HashMap<String, Long> map = Maps.newHashMap();
        for (NameValueInfo info : dbList) {
            map.put( info.getName().toString(), Long.parseLong(info.getValue().toString()) );
        }
        return map;
    }
    
    /**
     * 获取各区域应年报企业数量
     */
    public Map<String, Long> getShouldAnnualCoutByDistrict() {
        List<NameValueInfo> dbList = companyExtDao.selectShouldAnnualCoutByDistrict();
        
        HashMap<String, Long> map = Maps.newHashMap();
        for (NameValueInfo info : dbList) {
            map.put( info.getName().toString(), Long.parseLong(info.getValue().toString()) );
        }
        return map;
    }
    
}















