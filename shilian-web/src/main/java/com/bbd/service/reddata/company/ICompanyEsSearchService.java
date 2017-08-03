/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.service.reddata.company;

import com.bbd.bean.RangeQueryBean;
import com.mybatis.domain.PageBounds;
import com.mybatis.domain.PageList;

import java.util.List;
import java.util.Map;

/**
 * 企业ES查询服务
 * @author tjwang
 * @version $Id: ICompanyEsSearchService.java, v 0.1 2017/5/14 0014 14:18 tjwang Exp $
 */
public interface ICompanyEsSearchService {

    <T> PageList<T> search(Map<String, Object> matchMap, Map<String, Object> keyMap, List<RangeQueryBean> list, PageBounds pb, Class<T> clazz);

    <T> PageList<T> searchByRegisterTime(Map<String, Object> matchMap, Map<String, Object> keyMap, List<RangeQueryBean> list, PageBounds pb, Class<T> clazz);
}
