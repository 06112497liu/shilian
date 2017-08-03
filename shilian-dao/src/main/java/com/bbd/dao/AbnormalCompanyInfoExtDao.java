package com.bbd.dao;

/**
 * 异常企业扩展操作
 * @author tjwang
 * @version $Id: AbnormalCompanyInfoExtDao.java, v 0.1 2017/5/22 0022 15:18 tjwang Exp $
 */
public interface AbnormalCompanyInfoExtDao {

    /**
     * 同步企业类型信息
     */
    void syncCompanyType();

    /**
     * 同步企业地址信息
     */
    void syncDistrcit();

}