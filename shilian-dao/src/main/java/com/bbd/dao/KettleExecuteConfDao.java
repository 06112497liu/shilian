/** * BBD Service Inc * All Rights Reserved @2017 * */
package com.bbd.dao;

import com.bbd.domain.KettleExecuteConfInfo;

import java.util.Date;
import java.util.List;

/** * * @author xiongyun * @version $Id: KettleExecuteRecordDao.java, v 0.1 2017年6月6日 下午5:04:20 xiongyun Exp $ */
public interface KettleExecuteConfDao {

    List<KettleExecuteConfInfo> selectConfByCondition(Date today);

}
