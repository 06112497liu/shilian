/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.service.reddata.remind;

import java.util.List;

import com.bbd.service.reddata.remind.param.MsgTaskQueryParam;
import com.bbd.service.reddata.remind.param.MsgTaskQueryVO;
import com.bbd.service.reddata.remind.param.RemindDetailQueryVo;
import com.mybatis.domain.PageBounds;
import com.mybatis.domain.PageList;

/**
 * 消息任务查询服务
 * 
 * @author tjwang
 * @version $Id: IMsgTaskQueryService.java, v 0.1 2017/6/8 0008 14:48 tjwang Exp $
 */
public interface IMsgTaskQueryService {
    
    /**
     * 查询提示进度列表
     *
     * @param query
     * @return
     */
    PageList<MsgTaskQueryVO> getMsgTaskList(MsgTaskQueryParam query, PageBounds pageBounds);
    
    /**
     * 查询企业提示详情
     *
     * @param  nbxh          企业nbxh
     * @return
     */
    List<RemindDetailQueryVo> getRemindDetailList(String nbxh);
}
