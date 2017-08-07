/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.service.reddata.statistics.impl;

import com.bbd.Constants;
import com.bbd.bean.company.LostCompanyInfoVO;
import com.bbd.bean.query.BaseQuery;
import com.bbd.bean.statistics.CompanyAddrStaticInfo;
import com.bbd.bean.statistics.MonthLostCompanyStatisticsInfo;
import com.bbd.bean.statistics.NameValueInfo;
import com.bbd.bean.statistics.NameValueNodeInfo;
import com.bbd.controller.job.excel.LostCompanyListVo;
import com.bbd.controller.param.LostCompanyQueryParam;
import com.bbd.dao.address.AddressDao;
import com.bbd.dao.company.CompanyExtDao;
import com.bbd.dao.statistics.CompanyStatisticsDao;
import com.bbd.dao.statistics.LostCompanyStatisticsDao;
import com.bbd.service.reddata.addr.IAddressService;
import com.bbd.service.reddata.company.CompanyUtil;
import com.bbd.service.reddata.company.impl.CompanyEsSearchServiceImpl;
import com.bbd.service.reddata.statistics.ICompanyStatisticsService;
import com.bbd.service.reddata.statistics.ILostCompanyStatisticsService;
import com.bbd.util.DateUtil;
import com.bbd.util.StringUtils;
import com.bbd.utils.*;
import com.exception.ApplicationException;
import com.exception.CommonErrorCode;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.mybatis.domain.PageBounds;
import com.mybatis.domain.PageList;
import com.mybatis.domain.Paginator;
import org.apache.commons.io.IOUtils;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.*;

/**
 * 失联企业统计服务实现类
 *
 * @author zhanghui
 * @version $Id: LostCompanyStatisticsServiceImpl.java, v 0.1 2016年12月5日
 *          上午10:04:43 zhanghui Exp $
 */
@Service
public class LostCompanyStatisticsServiceImpl implements ILostCompanyStatisticsService {

    @Resource
    CompanyEsSearchServiceImpl            companyEsSercherService;
    @Resource
    ICompanyStatisticsService             companyStatisticsService;
    @Resource
    private RedisTemplate<String, String> redisTemplate;
    @Resource
    private CompanyExtDao                 companyExtDao;
    @Resource
    private LostCompanyStatisticsDao      lostCompanyStatisticsDao;
    @Resource
    private CompanyStatisticsDao          companyStatisticsDao;
    @Resource
    private AddressDao                    addressDao;
    private Logger                        logger = LoggerFactory.getLogger(getClass());

    @Resource
    private IAddressService               addressService;
    @Resource
    private CompanyUtil                   companyUtil;

    @Override
    public String exportStatisticsWord(Integer areaCode, String hotImg, String companyTypeImg, String industryImg) {
        Preconditions.checkArgument(areaCode != null, "地址编码不能为空");
        String uid = UUID.randomUUID().toString();
        try {
            // 1.图片解析 
            // 1.1 base64解码
            // 1.2   是否需要获取原始的宽高或者缩放图片 如有需要则需缩放图片（对图片进行处理） 在工具类里面统一处理
            // 1.3  封装参数
            // 2.解析地址查询对象
            // 3.查询地址名称 封装参数
            // 4.使用解析后的查询对象查询区域的统计信息
            // 4.1  查询系统的最新更新时间   lostCompanyStatisticsDao.selectLostInfoLastUpdateTime(query)
            // 4.2  获取失联区域分布的排名   lostCompanyStatisticsDao.selectLostCompanyGroupCountByAddr(query)  该查询对象要使用父区域的地址
            // 4.3 查询该区域失联企业的类型构成  lostCompanyStatisticsDao.selectLostCompanyGroupCountByType(query)  
            // 4.4 获取失联企业的行业分布 lostCompanyStatisticsDao.selectLostCompanyGroupCountByIndustry(query)
            // 以上所有的统计信息都可以直接调用服务的方法来获取   能使用缓存则使用缓存
            // 5.替换模板
            // 6.缓存模板
            // 7.返回下载url

            WordParamUtil paramsUtil = WordParamUtil.init();
            ByteArrayOutputStream out = new ByteArrayOutputStream();

            paramsUtil.putImg("hotImg", "png", Base64Utils.decodeFromString(hotImg)).putImg("companyTypeImg", "png", Base64Utils.decodeFromString(companyTypeImg))
                .putImg("industryImg", "png", Base64Utils.decodeFromString(industryImg));

            BaseQuery query = parseAddrCodeToBaseQuery(areaCode);
            String areaName = getAddrNameByQuery(query);
            String areaType = (query.getType() == 1 ? "市" : "省");
            paramsUtil.put("areaName", areaName);
            paramsUtil.put("areaType", areaType);
            paramsUtil.put("updatetime", DateUtil.formatDateByPatten(new Date(), "yyyy年MM月dd日"));

            List<CompanyAddrStaticInfo> addrList = companyStatisticsService.queryAbnormalCompanyDistribute(8);
            Integer rank = 1;
            for (int i = 0; i < addrList.size(); i++) {
                if (areaCode.equals(addrList.get(i).getCode())) {
                    rank = i + 1;
                    break;
                }
            }
            paramsUtil.put("rank", rank + "");

            //统计
            MonthLostCompanyStatisticsInfo totalData = getMonthLostCompanyStatisticsInfo(query);
            List<String> totalList = new ArrayList<>();
            totalList.add("区域企业数量：" + totalData.getCompanyCount() + "户；");
            totalList.add("失联企业数量：" + totalData.getLostCompanyCount() + "户；");
            totalList.add("失联企业占比：" + totalData.getLostPercent() + "；");
            totalList.add("本月新增失联企业数量：" + totalData.getMonthLostCompanyCount() + "户；");
            totalList.add("本月移除失联企业数量：" + totalData.getMonthRemoveLostCompanyCount() + "户；");
            paramsUtil.put("totalList", totalList);

            // 企业类型分布
            List<NameValueNodeInfo> typeList = companyStatisticsService.queryAbnormalPropertyDistribute(8, String.valueOf(areaCode));
            List<String> companyTypeList = new ArrayList<>();
            for (NameValueNodeInfo typeInfo : typeList) {
                companyTypeList.add(typeInfo.getName() + "：" + typeInfo.getValue() + "户，" + typeInfo.getPercent());
            }
            paramsUtil.put("companyTypeList", companyTypeList);

            // 行业分布
            List<NameValueNodeInfo> industryInfoList = companyStatisticsService.queryAbnormalIndustryDistribute(8, String.valueOf(areaCode));
            List<String> industryList = new ArrayList<>();
            for (NameValueNodeInfo industryInfo : industryInfoList) {
                industryList.add(industryInfo.getName() + "：" + industryInfo.getValue() + "户，" + industryInfo.getPercent());
            }
            paramsUtil.put("industryList", industryList);

            XWPFDocument word = WordUtil.generateWord(paramsUtil.get(), "report.doc");
            word.write(out);
            RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
            connection.setEx(("doc-" + uid).getBytes(), 2000, out.toByteArray());
            // 关闭word会刷新源文件 
            word.getPackage().revert();
            connection.close();
        } catch (IOException e) {
            logger.error("生成url异常：", e);
        }
        return "/lostCompany/downLoadReport.do?uid=" + uid;
    }

    /**
     * @param uid uid字符串
     */
    @SuppressWarnings("deprecation")
    public void downLoadReport(HttpServletResponse response, String uid) {
        try {
            String fileName = DateUtil.formatDateByPatten(new Date(), "yyyyMMddHHmmss");
            response.setHeader("Content-disposition", "attachment;filename=\"" + fileName + ".doc" + "\"");
            response.setContentType("application/msword");
            RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
            byte[] keyBytes = ("doc-" + uid).getBytes();
            byte[] bytes = connection.get(keyBytes);
            if (bytes != null && bytes.length > 0) {
                IOUtils.write(bytes, response.getOutputStream());
            }
            connection.del(keyBytes);
            connection.close();
        } catch (IOException e) {
            logger.error("文件导出异常：", e);
        }
    }

    @Override
    public List<LostCompanyListVo> queryLostCompany(LostCompanyQueryParam param) {
        PageBounds pb = new PageBounds();
        Map<String, Object> map = buildLostCompanyQueryMap(param);

        List<LostCompanyInfoVO> ds = companyExtDao.queryLostCompany(map, pb);
        Map<String, String> districtMap = addressService.getDistrictCodeMap(Constants.GUIYANG_CODE);
        Map<String, String> industryMap = companyUtil.getPrimaryIndustryMap();
        Map<String, String> propertyMap = companyUtil.getCompanyPropertyMap();

        List<LostCompanyListVo> list = Lists.newArrayList();
        for (LostCompanyInfoVO d : ds) {
            LostCompanyListVo vo = buildLostCompanyListVo(d, districtMap, industryMap, propertyMap);
            list.add(vo);
        }
        return list;
    }

    @Override
    public PageList<LostCompanyListVo> queryLostCompany(LostCompanyQueryParam param, PageBounds pb) {
        Map<String, Object> map = buildLostCompanyQueryMap(param);
        List<LostCompanyInfoVO> ds = companyExtDao.queryLostCompany(map, pb);

        List<LostCompanyListVo> list = Lists.newArrayList();
        Paginator p = PageListHelper.getPaginator(ds);
        if (ds.size() == 0) {
            return PageListHelper.create(list, p);
        }

        Map<String, String> districtMap = addressService.getDistrictCodeMap(Constants.GUIYANG_CODE);
        Map<String, String> industryMap = companyUtil.getPrimaryIndustryMap();
        Map<String, String> propertyMap = companyUtil.getCompanyPropertyMap();

        for (LostCompanyInfoVO d : ds) {
            LostCompanyListVo vo = buildLostCompanyListVo(d, districtMap, industryMap, propertyMap);
            list.add(vo);
        }

        return PageListHelper.create(list, p);
    }

    private LostCompanyListVo buildLostCompanyListVo(LostCompanyInfoVO d, Map<String, String> districtMap, Map<String, String> industryMap, Map<String, String> propertyMap) {

        LostCompanyListVo vo = new LostCompanyListVo();
        vo.setNbxh(d.getNbxh());
        vo.setCompanyName(d.getCompanyName());
        vo.setRegisterNumber(d.getCompanyCreditCode());
        vo.setAddr(d.getAddr());
        vo.setDistrict(d.getDistrict());
        vo.setDistrictDesc("贵州省贵阳市" + districtMap.get(d.getDistrict()));

        String pi = d.getPrimaryIndustry();
        vo.setPrimaryIndustry(pi);
        if (StringUtils.isNotBlank(pi)) {
            vo.setIndustryDesc(industryMap.get(pi));
        }

        Integer cp = d.getCompanyProperty();
        if (cp != null) {
            vo.setCompanyProperty(cp);
            vo.setCompanyPropertyDesc(propertyMap.get(cp.toString()));
        }

        vo.setGmtCompanyRegister(d.getGmtCompanyRegister());
        vo.setLostTime(d.getLostCheckInTime());

        return vo;
    }

    /**
     * 多维度查询
     */
    public Map<String, Object> buildLostCompanyQueryMap(LostCompanyQueryParam param) {

        // 添加模糊匹配查询部分
        Map<String, Object> map = new HashMap<String, Object>();
        if (param.getCompanyName() != null)
            map.put("companyName", "%" + param.getCompanyName() + "%");
        map.put("district", param.getDistrict());

        String primaryIndustry = param.getPrimaryIndustry();
        if (StringUtils.isNotBlank(primaryIndustry)) {
            map.put("primaryIndustry", primaryIndustry);
        }

        Integer companyType = param.getCompanyProperty();
        if (companyType != null) { //企业类型过滤（1 民营企业 2 国有企业 3 外资企业 ）
            map.put("companyProperty", companyType);
        }

        // 添加范围过滤部分
        Date minTime = new DateTime(1900, 1, 1, 0, 0, 0).toDate();
        Date maxTime = new Date();
        Date gmtCompanyRegisterFrom = param.getGmtCompanyRegisterFrom();
        Date gmtCompanyRegisterTo = param.getGmtCompanyRegisterTo();
        if (gmtCompanyRegisterFrom != null || gmtCompanyRegisterTo != null) {
            gmtCompanyRegisterFrom = gmtCompanyRegisterFrom != null ? gmtCompanyRegisterFrom : minTime;
            gmtCompanyRegisterTo = gmtCompanyRegisterTo != null ? gmtCompanyRegisterTo : maxTime;
            map.put("gmtCompanyRegisterFrom", gmtCompanyRegisterFrom);
            map.put("gmtCompanyRegisterTo", gmtCompanyRegisterTo);
        }

        Date checkInFrom = param.getGmtCheckInFrom();
        Date checkInTo = param.getGmtCheckInTo();
        if (checkInFrom != null || checkInTo != null) {
            checkInFrom = checkInFrom != null ? checkInFrom : minTime;
            checkInTo = checkInTo != null ? checkInTo : maxTime;
            map.put("checkInFrom", checkInFrom);
            map.put("checkInTo", checkInTo);
        }

        return map;
    }

    /**
     * 获取当前用户权限下，企业总数、失联企业数量和占比、新增失联企业数量、移除失联企业数量
     *
     * @param query
     * @return
     */
    public MonthLostCompanyStatisticsInfo getMonthLostCompanyStatisticsInfo(BaseQuery query) {
        MonthLostCompanyStatisticsInfo info = new MonthLostCompanyStatisticsInfo();
        String district = String.valueOf(query.getAddr());
        DateTime dateTime = new DateTime();
        int year = dateTime.getYear();
        int month = dateTime.getMonthOfYear();
        //企业总量
        Integer companyTotal = companyStatisticsDao.selectCompanyTotalCount(district);
        //失联企业总量
        Integer total = companyStatisticsService.queryPartialAbnormalCount(8, district);
        //新增失联企业数量
        Integer added = companyStatisticsService.queryAbnormalMonthAddCount(8, year, month, district);
        //移除失联企业数量        
        Integer removed = companyStatisticsService.queryAbnormalMonthRemoveCount(8, year, month, district);
        //最后更新时间
        String lastUpdateTime = DateUtil.formatDateByPatten(lostCompanyStatisticsDao.selectLostInfoLastUpdateTime(query), "yyyy年MM月dd日");
        info.setCompanyCount(companyTotal == null ? 0 : companyTotal);
        info.setLostCompanyCount(total == null ? 0 : total);
        if (info.getCompanyCount() < info.getLostCompanyCount()) {
            info.setCompanyCount(info.getLostCompanyCount());
        }
        String percent = PercentUtil.calcPercent(info.getCompanyCount(), info.getLostCompanyCount());
        info.setLostPercent(percent);
        info.setMonthLostCompanyCount(added == null ? 0 : added);
        info.setMonthRemoveLostCompanyCount(removed == null ? 0 : removed);
        info.setLastUpdateTime(lastUpdateTime);
        info.setAddrName(getAddrNameByQuery(query));
        return info;
    }

    /**
     * 通过 权限查询对象查询地址
     *
     * @param query 地址查询对象
     */
    private String getAddrNameByQuery(BaseQuery query) {
        NameValueInfo addrInfo = null;
        if (query.getType() == 3) {
            addrInfo = addressDao.selectProvinceByCode(query.getAddr());
        } else if (query.getType() == 2) {
            addrInfo = addressDao.selectCityByCode(query.getAddr());
        } else if (query.getType() == 1) {
            addrInfo = addressDao.selectDistrictByCode(query.getAddr());
        }

        if (addrInfo != null && addrInfo.getName() != null) {
            return addrInfo.getValue().toString();
        } else {
            return "";
        }
    }

    /**
     * 将地址编码转换为基础查询条件
     *
     * @param code
     * @return
     */
    private BaseQuery parseAddrCodeToBaseQuery(Integer code) {
        if (code == null)
            return UserContext.getQuery();
        int length = (code + "").length();
        BaseQuery query = new BaseQuery();
        query.setAddr(code);
        switch (length) {
        // 省
            case 2:
                query.setType(UserContext.PROVINCE);
                break;
            // 市
            case 4:
                query.setType(UserContext.CITY);
                break;
            // 区
            case 6:
                query.setType(UserContext.DISTRICT);
                break;
            // 异常
            case 8:
                query.setType(UserContext.DISTRICT);
                break;
            default:
                throw new ApplicationException(CommonErrorCode.PARAM_ERROR);
        }
        return query;
    }

}
