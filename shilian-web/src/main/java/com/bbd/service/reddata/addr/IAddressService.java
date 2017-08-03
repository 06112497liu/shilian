/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.service.reddata.addr;

import com.bbd.bean.LatLng;
import com.bbd.bean.query.BaseQuery;
import com.bbd.bean.statistics.NameValueInfo;
import com.bbd.bean.system.CreateUserAddressVo;

import java.util.List;
import java.util.Map;

/**
 * 地址服务接口.
 *
 * @author zhanghui
 * @version $Id: IAddressService.java, v 0.1 2016年12月13日 上午10:38:36 zhanghui Exp $
 */
public interface IAddressService {

    /**
     * 获取所有的省.
     *
     * @return 省份code和name列表
     */
    List<NameValueInfo> getAllProvinces();

    /**
     * 获取省下面的所有市.
     *
     * @param code 省编码
     * @return 市code和name列表
     */
    List<NameValueInfo> getCitysByProvince(int code);

    /**
     * 获取市下面的所有区.
     *
     * @param code 市code
     * @return 区code和name列表
     */
    List<NameValueInfo> getDistrictsByCity(int code);

    /**
     * 查询省
     */
    NameValueInfo getProvinceByCode(int code);

    /**
     * 查询市
     */
    NameValueInfo getCityByCode(int code);

    /**
     * 查询区.
     */
    NameValueInfo getDistrictByCode(int code);

    /**
     * 添加用户时的地址获取
     */
    CreateUserAddressVo getCreateUserAddress();

    /**
     * 查询地区的全名和全部区域代码
     *
     * @return
     */
    List<NameValueInfo> selectFullDistrictByCode(BaseQuery query);

    /**
     * 获取指定区域的所有下级地址的code，desc映射
     *
     * @param district
     * @return
     */
    Map<String, String> getDistrictCodeMap(String district);

    /**
     * 获取地址经纬度
     *
     * @param addr
     * @return
     */
    LatLng getAddressLatLng(String addr);
}
