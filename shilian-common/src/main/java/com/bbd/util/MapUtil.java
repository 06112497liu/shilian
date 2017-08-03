package com.bbd.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bbd.bean.LatLng;
import org.apache.commons.lang3.CharEncoding;
import org.apache.commons.lang3.StringUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 通过地理位置信息转换成精度维度信息工具类
 *
 * @author manailin
 * @version $Id: MapUtil.java, v 0.1 2016年12月20日 下午3:50:33 manailin Exp $
 */
public class MapUtil {

    /**
     * @param args
     */
    public static final String KeyOfGaoDe           = "8e93e34ae5c5e9267b0e1851ce3ae26e";
    public static final String BD_AK                = "bd_ak";
    public static final String BD_ADDRESS_PARSE_URL = "bd_addr_parse_url";
    public static final String BBD_AK               = "bbd_ak";
    public static final String BBD_ADDR_PARSE_URL   = "bbd_addr_parse_url";

    /**
     * 火星坐标系 (GCJ-02) 与百度坐标系 (BD-09) 的转换算法 将 GCJ-02 坐标转换成 BD-09 坐标
     *
     * @param latLng
     */
    public static LatLng gcj02_To_Bd09(LatLng latLng) {
        String url = "http://api.map.baidu.com/geoconv/v1/?coords=" + latLng.lng + "," + latLng.lat + "&from=3&to=5&ak=" + ConfigUtil.getBdAK();
        String str = HttpUtil.getHttp(url, null);
        JSONObject json = JSON.parseObject(str);
        Object addressObject = json.get("result");
        String str1 = JSON.toJSONString(addressObject);
        JSONArray jsonGeo = JSON.parseArray(str1);
        JSONObject json1 = jsonGeo.getJSONObject(0);
        String x = json1.get("x").toString();
        String y = json1.get("y").toString();
        LatLng bdLatLng = new LatLng();
        bdLatLng.lng = Double.parseDouble(x);
        bdLatLng.lat = Double.parseDouble(y);
        return bdLatLng;
    }

    /**
     * 通过高德地址api获取一个地址对应的经纬度
     *
     * @param address:如成都天华路361号
     * @throws UnsupportedEncodingException
     */
    public static LatLng getGaoDeLatLng(String address) throws UnsupportedEncodingException {
        String test = "http://restapi.amap.com/v3/geocode/geo?key=8e93e34ae5c5e9267b0e1851ce3ae26e&address=";
        String urlEncoderStr = address;
        String test2 = URLEncoder.encode(urlEncoderStr, "utf-8");
        String str = HttpUtil.getHttp(test + test2, null);
        JSONObject json = JSON.parseObject(str);
        Object addressObject = json.get("geocodes");
        if (addressObject.toString().equals("[]")) {
            return null;
        } else {
            String str1 = JSON.toJSONString(addressObject);
            JSONArray jsonGeo = JSON.parseArray(str1);
            JSONObject json1 = jsonGeo.getJSONObject(0);
            String coords = (String) json1.get("location");
            String[] strArray = coords.split(",");
            LatLng latLng = new LatLng();
            latLng.lng = Double.parseDouble(strArray[0]);
            latLng.lat = Double.parseDouble(strArray[1]);
            return latLng;
        }
    }

    // 随机获取百度AK
    private static String getBdAk() {
        List<String> bdAks = ConfigUtil.getBdAks();
        int size = bdAks.size();
        int num = RandomUtil.getRandom(size);
        return bdAks.get(num);
    }

    /**
     * 通过百度地图来获取经纬度 null 没有获取到经纬度
     */
    public static LatLng getBaiduLatLng(String address) {
        LatLng ll = null;
        // 1、封装地址参数
        Map<String, String> params = new HashMap<String, String>();
        params.put("output", "json");
        try {
            params.put("address", URLEncoder.encode(address, CharEncoding.UTF_8));
        } catch (Exception e) {
            // not...
        }
        String ak = getBdAk();
        params.put("ak", ak);
        // 2、发送获取请求
        String result = HttpUtil.getHttp("http://api.map.baidu.com/geocoder/v2/", params);
        // 3、根据请求结果解析经纬度
        JSONObject jsonObject = JSON.parseObject(result);
        // 如果请求结果正确
        int status = jsonObject.getIntValue("status");
        if (status == 0) {
            ll = new LatLng();
            JSONObject location = jsonObject.getJSONObject("result").getJSONObject("location");
            ll.lat = location.getDoubleValue("lat");
            ll.lng = location.getDoubleValue("lng");
        } else if (status == 302) {
            // 天配额超限，限制访问
            ll = new LatLng();
        } else {
            // 地址异常
            ll = new LatLng(-1, -1);
        }
        return ll;
    }

    private static LatLng getBbdLatLng(String address) {
        LatLng ll = null;
        // 1、封装地址参数
        Map<String, String> params = new HashMap<String, String>();
        try {
            params.put("keys", URLEncoder.encode(address, CharEncoding.UTF_8));
        } catch (Exception e) {
            // not...
        }
        //params.put("ak", props.getProperty(BBD_AK));
        params.put("ak", ConfigUtil.getBbdAK());
        params.put("ktype", "0");
        // 2、发送获取请求
        String result = HttpUtil.getHttp(ConfigUtil.getBbdAddrParseUrl(), params);
        //String result = com.http.HttpUtil.getHttp(props.getProperty(BBD_ADDR_PARSE_URL), params);
        // 3、根据请求结果解析经纬度
        JSONObject jsonObject = JSON.parseObject(result);
        // 如果请求结果正确
        if (jsonObject.getString("msg").equalsIgnoreCase("ok") && jsonObject.getIntValue("total") > 0) {
            ll = new LatLng();
            //            JSONObject location = jsonObject.getJSONArray("results").getJSONObject(0);
            JSONArray arr = jsonObject.getJSONArray("results");
            if (arr.size() > 0) {
                JSONObject location = arr.getJSONObject(0);
                ll.lat = location.getDoubleValue("company_gis_lat");
                ll.lng = location.getDoubleValue("company_gis_lon");
            }
        }
        return ll;
    }

    public static LatLng getLatLng(String address) {
        LatLng ll = new LatLng();
        if (StringUtils.isBlank(address)) {
            return ll;
        }

        try {
            ll = getBbdLatLng(address);
        } catch (Exception e) {
        }

        try {
            if (ll == null) {
                ll = getBaiduLatLng(address);
            }
        } catch (Exception e) {

        }

        if (ll == null) {
            ll = new LatLng();
        }

        return ll;
    }

    public static void main(String[] args) {
        //        String ak = "DP19qvZAELHlqYLmKULrscyOVKYFULNG";
        //        LatLng latLng = getBaiduLatLng("安龙县市场监督管理局", ak);
        //        System.out.println(latLng.lat);
        //        System.out.println(latLng.lng);

    }

}
