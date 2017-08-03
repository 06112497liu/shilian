/**  
 * BBD Service Inc
 * All Rights Reserved @2016
 *
 */
package com.bbd.bean.system;

import com.bbd.bean.statistics.NameValueInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建用户的id.
 * 
 * @author zhanghui
 * @version $Id: CreateUserAddressVo.java, v 0.1 2016年12月29日 下午4:08:27 zhanghui Exp $
 */
public class CreateUserAddressVo {

    /** 省 */
    private List<NameValueInfo> provinces = new ArrayList<>();

    /** 市 */
    private List<NameValueInfo> citys     = new ArrayList<>();

    /** 区 */
    private List<NameValueInfo> districts = new ArrayList<>();

    public List<NameValueInfo> getProvinces() {
        return provinces;
    }

    public void setProvinces(List<NameValueInfo> provinces) {
        this.provinces = provinces;
    }

    public List<NameValueInfo> getCitys() {
        return citys;
    }

    public void setCitys(List<NameValueInfo> citys) {
        this.citys = citys;
    }

    public List<NameValueInfo> getDistricts() {
        return districts;
    }

    public void setDistricts(List<NameValueInfo> districts) {
        this.districts = districts;
    }
}
