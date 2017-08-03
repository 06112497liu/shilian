package com.bbd.dao.address;

/**
 * BBD Service Inc
 * All Rights Reserved @2016
 *
 */

import com.bbd.bean.query.BaseQuery;
import com.bbd.bean.statistics.NameValueInfo;

import java.util.List;

/**
 * 地址dao.
 * @author zhanghui
 * @version $Id: AddressDao.java, v 0.1 2016年12月13日 上午10:53:35 zhanghui Exp $
 */
public interface AddressDao {

    /**
     * 查询所有的省.
     */
    List<NameValueInfo> selectAllProvinces();

    /**
     * 查询省下的市.
     * @param code 省的编码.
     */
    List<NameValueInfo> selectCitysByProvince(int code);

    /**
     * 查询市下面的区.
     * 
     * @param code 市的编码
     */
    List<NameValueInfo> selectDistrictsByCity(int code);

    /**
     * 根据市的code查询市.
     * @param code
     * @return
     */
    NameValueInfo selectCityByCode(int code);

    /**
     * 根据区的code查询区.
     * @param addr
     * @return
     */
    NameValueInfo selectDistrictByCode(int code);

    /**
     * 
     * @param code
     * @return
     */
    NameValueInfo selectProvinceByCode(int code);

    /**
     * 查询地区的全名和全部区域代码
     * 
     * @param code 区域代码
     * @return
     */
    List<NameValueInfo> selectFullDistrictByCode(BaseQuery query);
}
