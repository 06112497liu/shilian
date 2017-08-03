/**
 * BBD Service Inc
 * All Rights Reserved @2017
 */
package com.bbd.service.reddata.company;

import com.bbd.bean.biz.AddrPointInfo;
import com.bbd.bean.company.CompanyInfoEsVO;
import com.bbd.bean.company.CompanyInfoVo;
import com.bbd.bean.statistics.NameValueInfo;
import com.bbd.controller.param.CompanyAddrInfoVO;
import com.bbd.controller.param.MannualRemindConditionParam;
import com.bbd.domain.AnnualReportInfo;
import com.bbd.domain.EnterpriseInfo;
import com.bbd.service.reddata.remind.param.AbnormalRemindCompanyVO;
import com.bbd.service.reddata.remind.param.AnnualRemindCompanyVO;
import com.mybatis.domain.PageBounds;
import com.mybatis.domain.PageList;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 企业接口
 *
 * @author liuweibo
 * @version $Id: CompanyService.java, v 0.1 2017年5月4日 下午2:26:42 liuweibo Exp $
 */
public interface ICompanyService {
    /**
     * 根据企业名称属性分页查询
     *
     * @param companyName 企业名称
     * @return List<CompanyInfoVo> list对象企业
     */
    PageList<CompanyInfoEsVO> findPage(String companyName, PageBounds pb);

    /**
     * 根据企业nbxh来查询企业的异常类型
     */
    Set<Integer> getAbnormalTypeBynbxh(String nbxh);

    /**
     * 查询企业类型（1 民营企业 2 国有企业 3 外资企业 ）
     */
    List<NameValueInfo> getCompanyTypes();

    /**
     * 查询企业经营活动项目（1-年报 2-招聘。。。）
     */
    List<NameValueInfo> getBusinessTypes();

    /**
     * 统一查询第一产业维度
     */
    List<NameValueInfo> getPrimaryIndustry();

    /**
     * 根据失联企业nbxh查询器经营活动记录编号
     *
     * @param nbxh  企业nbxh
     * @param month 月份
     * @return Set<Integer> 经营活动编号集合
     * @parma year 年
     */
    Set<Integer> getBusinessRecord(String nbxh, int year, int month);

    /**
     * 根据企业nbxh查找企业具体信息
     *
     * @param nbxh 企业nbxh
     * @return CompanyInfoVo 企业信息
     */
    CompanyInfoVo getByNbxh(String nbxh);

    /**
     * 查询年报提示企业列表信息
     */
    List<AnnualRemindCompanyVO> getAnnualList(MannualRemindConditionParam param, PageBounds page);

    /**
     * 查询异常企业列表信息
     */
    List<AbnormalRemindCompanyVO> getAbnormalList(MannualRemindConditionParam param, int abnormalState, PageBounds page);

    /**
     * 通过内部序号查找企业
     *
     * @param nbxh
     * @return
     */
    EnterpriseInfo getCompanyInfoByNbxh(String nbxh);

    /**
     * 获取企业最近年报信息
     *
     * @param nbxh
     * @return
     */
    AnnualReportInfo getAnnualReportInfoByNbxh(String nbxh);

    /**
     * 从BBD数据平台获取企业地址信息
     *
     * @param nbxh
     * @return
     */
    Map<String, CompanyAddrInfoVO> getCompanyBBDAddrInfo(String nbxh);

    /**
     * 获取企业地址散点
     */
    List<AddrPointInfo> getAddressPointInfo(String nbxh);

    /**
     * 同步经营活动
     */
    void syncBusinessRecord(int year, int month);

    /**
     * 查询企业经营活动项目
     *
     * @param nbxh
     * @return
     */
    String getBusinessRecordValue(String nbxh, String date);

    /**
     * 查询企业招聘联系方式
     */
    CompanyAddrInfoVO getRecruitAdressInfo(String nbxh);

    /**
     * 查询企业招标联系方式
     */
    CompanyAddrInfoVO getPurchaseAdressInfo(String nbxh);

}
