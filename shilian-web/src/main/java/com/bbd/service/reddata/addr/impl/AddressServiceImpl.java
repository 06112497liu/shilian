/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.service.reddata.addr.impl;

import com.bbd.bean.LatLng;
import com.bbd.bean.query.BaseQuery;
import com.bbd.bean.statistics.NameValueInfo;
import com.bbd.bean.system.CreateUserAddressVo;
import com.bbd.bean.system.LoginUserInfo;
import com.bbd.common.CacheConstants;
import com.bbd.dao.address.AddressDao;
import com.bbd.service.reddata.addr.IAddressService;
import com.bbd.util.MapUtil;
import com.bbd.utils.UserContext;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 地址服务实现类.
 *
 * @author zhanghui
 * @version $Id: AddressServiceImpl.java, v 0.1 2016年12月13日 上午10:39:15 zhanghui Exp $
 */
@Service
public class AddressServiceImpl implements IAddressService {

    /**
     * 地址dao
     */
    @Resource
    private AddressDao    addressDao;

    @Resource
    private LoginUserInfo adminUser;

    /**
     * @see IAddressService#getAllProvinces()
     */
    @Override
    public List<NameValueInfo> getAllProvinces() {
        return addressDao.selectAllProvinces();
    }

    /**
     */
    @Override
    public List<NameValueInfo> getCitysByProvince(int code) {
        return addressDao.selectCitysByProvince(code);
    }

    /**
     * @see IAddressService#(Integer)
     */
    @Override
    public List<NameValueInfo> getDistrictsByCity(int code) {
        return addressDao.selectDistrictsByCity(code);
    }

    /**
     * @see IAddressService#getProvinceByCode(int)
     */
    @Override
    public NameValueInfo getProvinceByCode(int code) {
        return addressDao.selectProvinceByCode(code);
    }

    /**
     * @see IAddressService#getCityByCode(int)
     */
    @Override
    public NameValueInfo getCityByCode(int code) {
        return addressDao.selectCityByCode(code);
    }

    /**
     * @see IAddressService#getDistrictByCode(int)
     */
    @Override
    public NameValueInfo getDistrictByCode(int code) {
        return addressDao.selectDistrictByCode(code);
    }

    /**
     * @see IAddressService#getCreateUserAddress()
     */
    @Override
    public CreateUserAddressVo getCreateUserAddress() {
        CreateUserAddressVo vo = new CreateUserAddressVo();
        // 判断用户是否是超级管理员 直接返回所有省
        LoginUserInfo user = UserContext.getUser();
        if (StringUtils.equals(adminUser.getUsername(), user.getUsername())) {
            vo.setProvinces(getAllProvinces());
            return vo;
        }

        BaseQuery query = UserContext.getQuery();
        int code = query.getAddr();
        switch (query.getType()) {
            case UserContext.PROVINCE:
                vo.getProvinces().add(getProvinceByCode(code));
                vo.setCitys(getCitysByProvince(code));
                break;

            case UserContext.CITY:
                int pCode = Integer.valueOf((code + "").substring(0, 2));
                vo.getProvinces().add(getProvinceByCode(pCode));
                vo.getCitys().add(getCityByCode(code));
                vo.setDistricts(getDistrictsByCity(code));
                break;

            case UserContext.DISTRICT:
                int p = Integer.valueOf((code + "").substring(0, 2));
                int c = Integer.valueOf((code + "").substring(0, 4));
                vo.getProvinces().add(getProvinceByCode(p));
                vo.getCitys().add(getCityByCode(c));
                vo.getDistricts().add(getDistrictByCode(code));
                break;
            default:
                break;
        }
        return vo;
    }

    @Override
    public List<NameValueInfo> selectFullDistrictByCode(BaseQuery query) {
        return addressDao.selectFullDistrictByCode(query);
    }

    @Override
    @Cacheable(value = CacheConstants.ADDRESS_INFO, keyGenerator = "simpleKeyGenerator")
    public Map<String, String> getDistrictCodeMap(String district) {
        List<NameValueInfo> list = addressDao.selectDistrictsByCity(Integer.valueOf(district));
        Map<String, String> map = Maps.newHashMap();
        for (NameValueInfo item : list) {
            map.put(String.valueOf(item.getName()), (String) item.getValue());
        }
        return map;
    }

    @Override
    @Cacheable(value = CacheConstants.ADDRESS_INFO, keyGenerator = "simpleKeyGenerator")
    public LatLng getAddressLatLng(String addr) {
        LatLng ll = new LatLng();
        if (StringUtils.isBlank(addr)) {
            return ll;
        }
        if (!addr.startsWith("贵州") || !addr.startsWith("贵阳")) {
            addr += "贵州省贵阳市" + addr;
        }
        ll = MapUtil.getBaiduLatLng(addr);
        return ll;
    }
}
