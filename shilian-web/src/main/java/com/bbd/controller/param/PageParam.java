
/** 
 * BBD Service Inc 
 * All Rights Reserved @2017 
 */
package com.bbd.controller.param;

import com.mybatis.domain.PageBounds;

/** 
 *  
 * @author liuweibo 
 * @version $Id: PageParam.java, v 0.1 2017年6月8日 下午5:28:47 liuweibo Exp $ 
 */
public class PageParam {

    private int limit;

    private int page;

    public int getLimit() {
        return limit;
    }

    public void setLimit( int limit ) {
        this.limit = limit;
    }

    public int getPage() {
        return page;
    }

    public void setPage( int page ) {
        this.page = page;
    }

    public PageBounds getPageBounds() {
        int p = 1;
        if (page >= 1) {
            p = page;
        }
        
        int l = 10;
        if (limit >= 1) {
            l = limit;
        }
        
        return new PageBounds(p, l);
    }

}
