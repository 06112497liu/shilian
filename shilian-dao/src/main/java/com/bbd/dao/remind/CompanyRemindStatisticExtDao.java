/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.dao.remind;

import org.apache.ibatis.annotations.Param;

/**
 *
 * @author tjwang
 * @version $Id: CompanyRemindStatisticExtDao.java, v 0.1 2017/6/8 0008 15:21 tjwang Exp $
 */
public interface CompanyRemindStatisticExtDao {

    int updateSuccessNum(@Param("nbxh") String nbxh, @Param("sendYear") int sendYear, @Param("method") int method, @Param("num") int num);

    int updateFailNum(@Param("nbxh") String nbxh, @Param("sendYear") int sendYear, @Param("method") int method, @Param("num") int num);

}
