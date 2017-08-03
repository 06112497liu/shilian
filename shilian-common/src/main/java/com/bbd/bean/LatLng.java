package com.bbd.bean;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * 精度维度实体类
 *
 * @author manailin
 * @version $Id: LatLng.java, v 0.1 2016年12月20日 下午3:52:05 manailin Exp $
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LatLng implements Serializable {

    private static final long serialVersionUID = -1206129678058145848L;

    // lng 经度Longitude 
    public double             lng;

    // lat 纬度Latitude
    public double             lat;

    public LatLng() {
        this(-1, -1);
    }

    public LatLng(LatLng p) {
        this(p.lng, p.lat);
    }

    public LatLng(double lng, double lat) {
        this.lng = lng;
        this.lat = lat;
    }

    @JSONField(serialize = false, deserialize = false)
    public boolean isBlank() {
        if (Math.abs(this.lng) < 0.00d && Math.abs(this.lat) < 0.00d) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "LatLng [lng=" + lng + ", lat=" + lat + "]";
    }
}
