/** 
 * BBD Service Inc 
 * All Rights Reserved @2017 
 */
package com.bbd.service.reddata.company;

import com.bbd.bean.company.AffiliatedCompanyVo;
import com.bbd.bean.company.LineVo;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

/** 
 * 企业关联方信息接口
 * @author liuweibo 
 * @version $Id: CompanyAffiliatedService.java, v 0.1 2017年5月4日 下午3:02:10 liuweibo Exp $ 
 */
@Service
public interface ICompanyAffiliatedService {
    /**
     * 搜索企业关联方信息
     * @param level  关联等级 一度  二度
     * @param companyName 模糊查询企业公司名称
     * @return AffiliatedCompanyVo  关联公司信息
     * @throws InvocationTargetException 
     * @throws IllegalAccessException 
     */

    AffiliatedCompanyVo getCompanyAffiliated(Long level, String companyName);

    /**
     * 获取关联方联系信息
     * 
     * @param companyName
     * @return
     */
    Map<String, String> getContactMessage(String companyName);

    /**
     * 一键下载获取企业关联方信息
     * @param level
     * @param companyName
     * @return
     */
    List<LineVo> findLineVo(Long level, String companyName);
}
