/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.utils;

import com.exception.ApplicationException;
import com.exception.CommonErrorCode;
import com.mybatis.domain.PageList;
import com.mybatis.domain.Paginator;

import java.util.List;

/**
 *
 * @author tjwang
 * @version $Id: PageListHelper.java, v 0.1 2017/5/4 0004 11:53 tjwang Exp $
 */
public class PageListHelper {

    public static <T> PageList<T> create(List<T> datas, Paginator paginator) {
        PageList<T> pb = new PageList<>(datas, paginator);
        return pb;
    }

    public static Paginator getPaginator(List list) {
        if (list instanceof PageList) {
            PageList pb = (PageList) list;
            return pb.getPaginator();
        }
        throw new ApplicationException(CommonErrorCode.INNER_ERROR);
    }

}
