/** * BBD Service Inc * All Rights Reserved @2017 * */
package com.bbd.dao;

import org.apache.ibatis.annotations.Param;

import java.util.Date;

/** * * @author xiongyun * @version $Id: DataShareDealDao.java, v 0.1 2017年7月28日 上午9:41:16 xiongyun Exp $ */
public interface DataShareDealDao {

    String selectCompanyId(@Param("companyName") String companyName);

    void insertRelationData(@Param("companyName") String companyName, @Param("companyId") String companyId, @Param("hasCentralEnterprise") int hasCentralEnterprise,
                            @Param("hasListedCompany") int hasListedCompany, @Param("gmtCreate") Date gmtCreate);
}
