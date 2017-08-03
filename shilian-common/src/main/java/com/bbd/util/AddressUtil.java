/**  
 * BBD Service Inc
 * All Rights Reserved @2016
 *
 */
package com.bbd.util;

import com.alibaba.fastjson.JSON;
import com.bbd.bean.LatLng;
import com.google.common.collect.Lists;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 获取地址工具类
 * @author yujiahao
 * @version $Id: AddressUtil.java, v 0.1 2016年12月21日 下午3:15:30 yujiahao Exp $
 */
public class AddressUtil {
    public static final int     ADDRESS_TYPE_NBXX          = 1;
    public static final int     ADDRESS_TYPE_RECRUIT       = 2;
    public static final int     ADDRESS_TYPE_SHGY_ZHAOBJG  = 3;
    public static final int     ADDRESS_TYPE_SHGY_ZHONGBJG = 4;
    /** */
    private static final String ADDRESS_EXCEPTION          = "地址异常";
    private static final String GUIZHOUSHENG               = "贵州省";
    private static final String GUIYANGSHI                 = "贵阳市";
    private static Logger       logger                     = LoggerFactory.getLogger(AddressUtil.class);

    /**
     * 根据公司名称与请求内容类型 获取地址信息
     *
     **/
    public static JSONArray getEmailJSONArray(String company) {
        JSONArray jsonArray = new JSONArray();
        try {
            String url = RemoteConfigUtil.getProperty(RemoteConfigUtil.EMAIL_ADDRESS, "");
            String ak = RemoteConfigUtil.getAK(RemoteConfigUtil.EMAIL_ADDRESS);
            Map<String, String> params = new HashMap<>();
            params.put("company", URLEncoder.encode(company, "UTF-8"));
            params.put("appkey", ak);
            String result = HttpUtil.getHttp(url, params);
            JSONObject jsonObject = JSONObject.fromObject(result);
            jsonArray = jsonObject.getJSONArray("results");
            logger.debug("jsonArray-----------" + jsonArray);
        } catch (Exception e) {
            logger.error("提示获取地址信息异常");
            logger.error(e.getMessage(), e);
        }
        return jsonArray;
    }

    /**
     * 根据公司名称与请求内容类型 获取地址信息
     *
     **/
    public static Map<String, String> getAffiliatedCompanyContact(String company, RedisTemplate<String, String> redisTemplate) {
        String companyContact = null;
        try {
            companyContact = /*redisTemplate.opsForValue().get("contact-addr-" + company)*/null;
            if (StringUtils.isBlank(companyContact)) {
                companyContact = "";
                String url = RemoteConfigUtil.getUrl(RemoteConfigUtil.ACTIVITY_NB);
                String ak = RemoteConfigUtil.getAK(RemoteConfigUtil.ACTIVITY_NB);
                Map<String, String> params = new HashMap<String, String>();
                params.put("company", URLEncoder.encode(company, "UTF-8"));
                params.put("appkey", ak);
                params.put("pageSize", String.valueOf(1));
                String json = HttpUtil.getHttp(url, params);
                if (StringUtils.isNotBlank(json)) {
                    com.alibaba.fastjson.JSONObject jsonObject = JSON.parseObject(json);
                    com.alibaba.fastjson.JSONArray results = jsonObject.getJSONArray("results");
                    String errCode = jsonObject.getString("err_code");
                    if ("0".equals(errCode) && results != null && !results.isEmpty()) {
                        com.alibaba.fastjson.JSONArray nbArray = results;
                        String address = "";
                        String phone = "";
                        for (int i = 0; i < nbArray.size(); i++) {
                            com.alibaba.fastjson.JSONObject obj = nbArray.getJSONObject(i);
                            if ("".equals(address) || null == address)
                                address = obj.getString("address");
                            if ("".equals(phone) || null == phone)
                                phone = obj.getString("phone");
                            if (StringUtils.isNotBlank(address) || StringUtils.isNotBlank(phone)) {
                                companyContact = address + "," + phone;
                                redisTemplate.opsForValue().set("contact-addr-" + company, companyContact, 45L, TimeUnit.DAYS);
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            logger.error("提示获取地址信息异常");
            logger.error(e.getMessage(), e);
        }
        Map<String, String> map = new HashMap<String, String>();
        String[] addrInfo = companyContact.split(",");
        if (addrInfo.length == 2) {
            map.put("address", addrInfo[0]);
            map.put("phone", addrInfo[1]);
        }
        return map;
    }

    public static String getPhone(JSONArray jsonArray) {
        if (jsonArray == null) {
            return null;
        }
        List<String> list = getValue(jsonArray, "phone");
        for (String phone : list) {
            if (ValidateUtil.checkMobile(phone)) {
                return phone;
            }
        }
        return null;
    }

    public static List<String> getPhones(JSONArray jsonArray) {
        List<String> phones = Lists.newArrayList();
        if (jsonArray == null) {
            return phones;
        }
        List<String> list = getValue(jsonArray, "phone");
        for (String phone : list) {
            if (ValidateUtil.checkMobile(phone)) {
                phones.add(phone);
            }
        }
        return phones;
    }

    private static List<String> getValue(JSONArray jsonArray, String name) {
        if (jsonArray == null) {
            return new ArrayList();
        }
        List<String> list = new ArrayList();
        for (Object json : jsonArray) {
            JSONObject jsonObject = (JSONObject) json;
            JSONArray array = (JSONArray) jsonObject.get("qyxx_data_nb");
            getInfoFromJsonArray(list, array, name);
            array = (JSONArray) jsonObject.get("qyxx_data_nb");
            getInfoFromJsonArray(list, array, name);
            array = (JSONArray) jsonObject.get("recruit");
            getInfoFromJsonArray(list, array, name);
            array = (JSONArray) jsonObject.get("shgy_zhaobjg");
            getInfoFromJsonArray(list, array, name);
        }
        return list;
    }

    public static String getMobile(JSONArray jsonArray) {
        if (jsonArray == null) {
            return null;
        }
        List<String> list = getValue(jsonArray, "phone");
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    public static String getEmail(JSONArray jsonArray) {
        if (jsonArray == null) {
            return null;
        }
        List<String> list = getValue(jsonArray, "email");
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    public static List<String> getEmails(JSONArray jsonArray) {
        if (jsonArray == null) {
            return null;
        }
        return getValue(jsonArray, "email");
    }

    /**
    *  省市区拼接
    */
    public static String concatAddress(String province, String city, String district) {
        StringBuilder builder = new StringBuilder();
        if (StringUtils.isNotBlank(city)) {
            builder.append(city);
            if (StringUtils.isNotBlank(district)) {
                builder.append(district);
            }
        } else if (StringUtils.isNotBlank(province)) {
            builder.append(province);
        } else {
            builder.append(ADDRESS_EXCEPTION);
        }
        return builder.toString();
    }

    public static boolean emailAddressValid(String email) {
        boolean flag = false;
        try {
            String check = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
            Pattern regex = Pattern.compile(check);
            Matcher matcher = regex.matcher(email);
            flag = matcher.matches();
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    public static boolean phoneNumValid(String phoneNum) {

        boolean flag = false;
        try {
            Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
            Matcher matcher = p.matcher(phoneNum);
            flag = matcher.matches();
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    public static LatLng getLatLng(String addr) {
        if (StringUtils.isBlank(addr)) {
            return new LatLng(-1, -1);
        }
        if (!addr.startsWith(GUIZHOUSHENG) && !addr.startsWith(GUIYANGSHI)) {
            addr = GUIYANGSHI + addr;
        }
        return MapUtil.getLatLng(addr);
    }

    private static void getInfoFromJsonArray(List<String> list, JSONArray array, String name) {
        if (array != null) {
            for (Object json1 : array) {
                JSONObject jsonObject1 = (JSONObject) json1;
                if (jsonObject1.containsKey(name)) {
                    String value = jsonObject1.getString(name);
                    if (StringUtils.isNoneBlank(value)) {
                        list.add(value);
                    }
                }
            }
        }
    }

}
