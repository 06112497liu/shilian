/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.service.reddata.company.impl;

import com.bbd.bean.RangeQueryBean;
import com.bbd.bean.vo.CompanyEsVO;
import com.bbd.service.reddata.company.ICompanyEsSearchService;
import com.bbd.util.EsUtil;
import com.bbd.utils.PageListHelper;
import com.mybatis.domain.PageBounds;
import com.mybatis.domain.PageList;
import com.mybatis.domain.Paginator;
import com.utils.BeanMapperUtil;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 *
 * @author tjwang
 * @version $Id: CompanyEsSearchServiceImpl.java, v 0.1 2017/5/14 0014 14:19 tjwang Exp $
 */
@Service
public class CompanyEsSearchServiceImpl implements ICompanyEsSearchService {

    @Override
    public <T> PageList<T> search(Map<String, Object> matchMap, Map<String, Object> keyMap, List<RangeQueryBean> list, PageBounds pb, Class<T> clazz) {
        PageList<CompanyEsVO> ds = EsUtil.search(EsUtil.COMPANY, matchMap, keyMap, list, pb, CompanyEsVO.class);
        Paginator p = PageListHelper.getPaginator(ds);
        List<T> rs = BeanMapperUtil.mapList(ds, clazz);
        return PageListHelper.create(rs, p);

    }

    @Override
    public <T> PageList<T> searchByRegisterTime(Map<String, Object> matchMap, Map<String, Object> keyMap, List<RangeQueryBean> list, PageBounds pb, Class<T> clazz) {
        PageList<CompanyEsVO> ds = EsUtil.search(EsUtil.COMPANY, matchMap, keyMap, list, pb, CompanyEsVO.class, new String[] { "gmtCompanyRegister" }, new SortOrder[] { SortOrder.DESC });
        Paginator p = PageListHelper.getPaginator(ds);
        List<T> rs = BeanMapperUtil.mapList(ds, clazz);
        return PageListHelper.create(rs, p);
    }
}
