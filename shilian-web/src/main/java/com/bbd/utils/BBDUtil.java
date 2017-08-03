/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.utils;

import com.bbd.bean.LatLng;
import com.bbd.service.reddata.vo.BBDCompanyAddrVO;
import com.bbd.service.reddata.vo.BBDResultInfoVO;
import com.bbd.util.HttpUtil;
import com.bbd.util.MapUtil;
import com.bbd.util.RemoteConfigUtil;
import com.bbd.util.StringUtils;
import com.google.common.collect.Maps;
import com.utils.ObjectMapperUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * BBD工具类
 * @author tjwang
 * @version $Id: BBDUtil.java, v 0.1 2017/6/16 0016 14:59 tjwang Exp $
 */
public class BBDUtil {

    public static final String  REG_PHONE = "^((0\\d{2,3}-\\d{7,8})|(1[3584]\\d{9})|(\\d{7,8}))$";
    private static final Logger logger    = LoggerFactory.getLogger(BBDUtil.class);

    /**
     * 通过企业名称获取企业信息
     * @param companyName 企业名称
     * @return
     */
    public static Map<String, BBDCompanyAddrVO> getBBDCompanyAddrInfo(String companyName) {
        Map<String, BBDCompanyAddrVO> mapResult = null;
        if (StringUtils.isBlank(companyName)) {
            return mapResult;
        }

        // 调用数据接口 解析地址
        String url = RemoteConfigUtil.getProperty(RemoteConfigUtil.EMAIL_ADDRESS, "");
        String ak = RemoteConfigUtil.getAK(RemoteConfigUtil.EMAIL_ADDRESS);
        Map<String, String> params = new HashMap<>();
        try {
            params.put("company", URLEncoder.encode(companyName, "UTF-8"));
        } catch (UnsupportedEncodingException e) {

        }
        params.put("appkey", ak);
        String result = HttpUtil.getHttp(url, params);
        if (StringUtils.isBlank(result)) {
            return mapResult;
        }
        mapResult = parseCompanyAddr(result);

        return mapResult;
    }

    private static Map<String, BBDCompanyAddrVO> parseCompanyAddr(String result) {
        Map<String, BBDCompanyAddrVO> mapResult = Maps.newHashMap();

        BBDResultInfoVO resultInfoVO = ObjectMapperUtil.read(result, BBDResultInfoVO.class);
        List<HashMap<String, Object>> results = resultInfoVO.getResults();
        if (results == null)
            return null;
        for (HashMap<String, Object> r : results) {

            Set<String> keys = r.keySet();
            for (String key : keys) {
                List<Map> l = (List<Map>) r.get(key);
                if (l != null && !l.isEmpty()) {
                    BBDCompanyAddrVO vo = new BBDCompanyAddrVO();
                    Map map = l.get(0);
                    // 地址
                    if (map.get("address") != null) {
                        vo.setAddress(map.get("address").toString());
                    }
                    if (map.get("invest_address") != null) {
                        vo.setAddress(map.get("invest_address").toString());
                    }
                    if (map.get("location") != null) {
                        vo.setAddress(map.get("location").toString());
                    }
                    //　电话
                    if (map.get("contact_information") != null && map.get("contact_information").toString().matches(REG_PHONE)) {
                        vo.setPhone(map.get("contact_information").toString());
                    }
                    if (map.get("phone") != null) {
                        vo.setPhone(map.get("phone").toString());
                    }
                    if (map.get("telephone") != null) {
                        vo.setPhone(map.get("telephone").toString());
                    }
                    // 邮箱
                    if (map.get("email") != null) {
                        vo.setEmail(map.get("email").toString());
                    }
                    if (map.get("e_mail") != null) {
                        vo.setEmail(map.get("e_mail").toString());
                    }
                    vo = setCityStr(vo);
                    try {
                        if (StringUtils.isBlank(vo.getAddress())) {
                            LatLng ll = MapUtil.getBaiduLatLng(vo.getAddress());
                            if (ll != null) {
                                vo.setLat(ll.lat);
                                vo.setLng(ll.lng);
                            }
                        }
                    } catch (Exception e) {
                        logger.error("使用百度地图解析经纬度报错： " + e.getMessage(), e);
                    }
                    mapResult.put(key, vo);
                }
            }

        }

        return mapResult;
    }

    /**
     * 处理字符串
     * @param addressVo 地址对象
     * @return 返回“市”
     */
    public static BBDCompanyAddrVO setCityStr(BBDCompanyAddrVO addressVo) {
        String substring = null;
        if (addressVo == null) {
            return null;
        }
        String address = addressVo.getAddress();
        if (org.apache.commons.lang3.StringUtils.isNotBlank(address)) {
            if (address.contains("省")) {
                substring = org.apache.commons.lang3.StringUtils.substringAfter(address, "省");
                substring = org.apache.commons.lang3.StringUtils.substringBefore(substring, "市");
            } else if (address.contains("市")) {
                substring = org.apache.commons.lang3.StringUtils.substringBefore(address, "市");
            } else {
                substring = "";
            }
            addressVo.setCity(substring);
        }
        return addressVo;
    }

}
