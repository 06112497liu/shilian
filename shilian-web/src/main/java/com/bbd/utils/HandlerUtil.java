package com.bbd.utils;

import com.bbd.bean.biz.PointVo;
import com.bbd.bean.company.LineVo;
import com.bbd.util.HttpUtil;
import com.bbd.util.RemoteConfigUtil;
import com.bbd.util.StringUtils;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class HandlerUtil {

    private static Logger log = LoggerFactory.getLogger(HandlerUtil.class);

    public static HashSet findLineVo(String json) {
        HashSet set = new HashSet<>();
        JSONObject jsons = JSONObject.fromObject(json);
        List<JSONArray> list = (List) jsons.get("body");
        for (JSONArray value : list) {
            LineVo line = new LineVo();
            line.setOrig(value.getString(0));
            line.setTarget(value.getString(1));
            line.setRelationShip(value.getString(2));
            line.setOrigLevel(value.getString(3));
            line.setTarLevel(value.getString(4));
            line.setType(value.getString(5));
            // 子公司判断
            if ("1".equals(value.getString(4)) && "0".equals(value.getString(6))) {
                line.setIsFullLine("1");
            } else {
                line.setIsFullLine(value.getString(5));
            }

            set.add(line);
        }
        return set;

    }

    public static HashSet findPointVo(String json) {
        HashSet set = new HashSet<>();
        if (StringUtils.isBlank(json)) {
            return set;
        }
        JSONObject jsons = JSONObject.fromObject(json);
        List<JSONArray> list = (List) jsons.get("body");
        HashSet names = new HashSet<>();
        for (JSONArray value : list) {
            String name1 = value.getString(0);
            // 投资方
            if (!names.contains(name1)) {
                PointVo point = new PointVo();
                point.setName(value.getString(0));
                point.setLevel(value.getString(3));
                point.setIsPerson(value.getString(6));
                set.add(point);
                names.add(name1);
            }
            String name2 = value.getString(1);
            // 被投资方
            if (!names.contains(name2)) {
                PointVo point = new PointVo();
                point.setName(value.getString(1));
                point.setLevel(value.getString(4));
                point.setIsPerson("0");
                // 子公司判断
                if ("1".equals(value.getString(4)) && "0".equals(value.getString(6))) {
                    point.setIsSonCom("1");
                }
                set.add(point);
                names.add(name2);
            }

        }
        return set;

    }

    public static String getJson(Long level, String companyName) {
        String affiliacted_url = RemoteConfigUtil.getProperty(RemoteConfigUtil.AFFILIACTED, "");
        String ak = RemoteConfigUtil.getAK(RemoteConfigUtil.AFFILIACTED);
        Map<String, String> map = new HashMap<>();
        map.put("appkey", ak);
        // map.put("ak", ak);
        try {
            map.put("name", URLEncoder.encode(companyName, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            log.error(e.getMessage(), e);
        }
        map.put("degree", level.toString());
        String json = HttpUtil.getHttp(affiliacted_url, map);
        log.info("json:" + json);
        return json;
    }

    public static void main(String[] args) {
        //System.err.println(getJson(2L, "贵州华峰诚信实业有限公司"));
    }

}
