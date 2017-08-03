/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.controller;

import com.bbd.util.StringUtils;
import com.bbd.utils.SessionContext;
import com.mybatis.domain.PageBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author tjwang
 * @version $Id: AbstractController.java, v 0.1 2017/6/21 0021 17:59 tjwang Exp $
 */
public class AbstractController {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    protected PageBounds getPageBounds() {
        int page = 1;
        int limit = 10;
        String p = SessionContext.getRequest().getParameter("page");
        String l = SessionContext.getRequest().getParameter("limit");
        if (StringUtils.isNotBlank(p)) {
            try {
                page = Integer.parseInt(p);
            } catch (NumberFormatException e) {
            }
        }
        if (StringUtils.isNotBlank(l)) {
            try {
                limit = Integer.parseInt(l);
            } catch (NumberFormatException e) {
            }
        }
        PageBounds pb = new PageBounds(page, limit);
        return pb;
    }
}
