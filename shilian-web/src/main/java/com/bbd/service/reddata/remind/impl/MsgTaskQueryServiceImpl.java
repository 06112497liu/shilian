/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.service.reddata.remind.impl;

import com.bbd.bean.query.BaseQuery;
import com.bbd.common.CacheConstants;
import com.bbd.dao.CompanyRemindDetailInfoDao;
import com.bbd.dao.MsgTaskInfoDao;
import com.bbd.domain.CompanyRemindDetailInfo;
import com.bbd.domain.CompanyRemindDetailInfoExample;
import com.bbd.domain.MsgTaskInfo;
import com.bbd.domain.MsgTaskInfoExample;
import com.bbd.service.reddata.remind.IMsgTaskQueryService;
import com.bbd.service.reddata.remind.param.MsgTaskQueryParam;
import com.bbd.service.reddata.remind.param.MsgTaskQueryVO;
import com.bbd.service.reddata.remind.param.RemindDetailQueryVo;
import com.bbd.utils.PageListHelper;
import com.bbd.utils.UserContext;
import com.mybatis.domain.PageBounds;
import com.mybatis.domain.PageList;
import com.mybatis.domain.Paginator;
import com.utils.BeanMapperUtil;
import org.joda.time.DateTime;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 消息任务查询服务实现
 *
 * @author tjwang
 * @version $Id: MsgTaskQueryServiceImpl.java, v 0.1 2017/6/8 0008 14:49 tjwang Exp $
 */
@Service
public class MsgTaskQueryServiceImpl implements IMsgTaskQueryService {

    /**
     * 提示进度数据服务接口
     */
    @Resource
    MsgTaskInfoDao             msgTaskInfoDao;

    /**
     * 企业提示详情服务接口
     */
    @Resource
    CompanyRemindDetailInfoDao remindDetailInfoDao;

    /**
     * 查询提示进度列表
     *
     * @param query 查询条件
     * @return
     */
    @Override
    public PageList<MsgTaskQueryVO> getMsgTaskList(MsgTaskQueryParam query, PageBounds pageBounds) {

        // 构建查询条件
        MsgTaskInfoExample example = new MsgTaskInfoExample();

        // 提示时间排序条件
        if (query.getOrder() != null && query.getOrder() == 2)
            example.setOrderByClause("send_time ASC");
        else
            example.setOrderByClause("send_time DESC");

        // 用户权限条件
        BaseQuery userQuery = UserContext.getQuery() == null ? new BaseQuery(2, 5201) : UserContext.getQuery();

        DateTime dateTime = new DateTime();
        int sendYear = dateTime.getYear();

        // 条件查询
        MsgTaskInfoExample.Criteria criteria = example.createCriteria();
        criteria.andTypeEqualTo(query.getTaskType());
        criteria.andSendYearEqualTo(sendYear);
        String areaCode = String.valueOf(userQuery.getAddr());
        criteria.andDistrictEqualTo(areaCode);
        if (query.getOperationType() != null)
            criteria.andOperationTypeEqualTo(query.getOperationType());
        if (query.getMethod() != null)
            criteria.andMethodEqualTo(query.getMethod());

        // 执行查询
        List<MsgTaskInfo> list = msgTaskInfoDao.selectByExampleWithPageBounds(example, pageBounds);

        // 处理结果
        List<MsgTaskQueryVO> voList = BeanMapperUtil.mapList(list, MsgTaskQueryVO.class);
        Paginator paginator = PageListHelper.getPaginator(list);
        PageList<MsgTaskQueryVO> result = PageListHelper.create(voList, paginator);

        return result;
    }

    /**
     * 查询企业提示详情
     *
     * @param nbxh 企业nbxh
     * @return
     */
    @Override
    @Cacheable(value = CacheConstants.MSG_TASK_INFO, keyGenerator = "simpleKeyGenerator")
    public List<RemindDetailQueryVo> getRemindDetailList(String nbxh) {
        // 构建查询条件
        CompanyRemindDetailInfoExample example = new CompanyRemindDetailInfoExample();
        //   默认以send_time降序
        example.setOrderByClause("send_time DESC");

        // 条件查询
        CompanyRemindDetailInfoExample.Criteria criteria = example.createCriteria();
        criteria.andNbxhEqualTo(nbxh);
        criteria.andSendYearEqualTo(new DateTime().getYear());

        // 执行查询
        List<CompanyRemindDetailInfo> dbList = remindDetailInfoDao.selectByExample(example);

        // 结果处理
        List<RemindDetailQueryVo> resultList = BeanMapperUtil.mapList(dbList, RemindDetailQueryVo.class);
        for (int i = 0; i < resultList.size(); i++) {
            String outNbxh = resultList.get(i).getNbxh();
            int outTaskId = resultList.get(i).getTaskId();
            for (int j = i + 1; j < resultList.size(); j++) {
                String inNbxh = resultList.get(j).getNbxh();
                int inTaskId = resultList.get(j).getTaskId();
                if (inNbxh.equals(outNbxh) && inTaskId == outTaskId) {
                    if (resultList.get(j).getStatus() == 3) {
                        resultList.remove(i);
                    } else if (resultList.get(j).getSendTime().getTime() >= resultList.get(i).getSendTime().getTime()) {
                        resultList.remove(i);
                    }
                }
            }
        }
        return resultList;
    }

}
