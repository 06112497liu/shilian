/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.service.reddata.remind.impl;

import com.bbd.bean.query.BaseQuery;
import com.bbd.dao.AutoRemindSettingInfoDao;
import com.bbd.domain.AutoRemindSettingInfo;
import com.bbd.domain.AutoRemindSettingInfoExample;
import com.bbd.exception.BizErrorCode;
import com.bbd.exception.RemindErrorCode;
import com.bbd.service.reddata.remind.IAutoRemindSettingService;
import com.bbd.service.reddata.remind.param.AutoRemindSettingParam;
import com.bbd.service.reddata.remind.param.AutoRemindSettingQueryVo;
import com.bbd.utils.UserContext;
import com.exception.ApplicationException;
import com.exception.CommonErrorCode;
import com.utils.BeanMapperUtil;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author tjwang
 * @version $Id: AutoRemindSettingServiceImpl.java, v 0.1 2017/6/9 0009 13:47 tjwang Exp $
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class AutoRemindSettingServiceImpl implements IAutoRemindSettingService {

    private Logger                   logger = LoggerFactory.getLogger(getClass());

    @Resource
    private AutoRemindSettingInfoDao autoRemindSettingInfoDao;

    /**
     * 新增提示周期
     *
     * @param info
     */
    @Override
    public Integer add(AutoRemindSettingParam info) {
        BaseQuery query = UserContext.getQuery();
        String operator = (query == null ? "5201" : String.valueOf(query.getAddr()));

        // 判断运行时间是否小于系统当前时间
        if (!checkRundate(info.getRunDate())) {
            throw new ApplicationException(RemindErrorCode.AUTO_REMIND_SETTING_RUNDATE_ERROR);
        }

        // 设置区域编码到数据库
        if (info.getDistrict() == null)
            info.setDistrict(String.valueOf(UserContext.getQuery().getAddr()));

        // 判断数据库是否已有当前提示时间
        if (checkRunDateIsExist(info.getDistrict(), info.getTaskType(), info.getRunDate())) {
            AutoRemindSettingInfo addInfo = BeanMapperUtil.map(info, AutoRemindSettingInfo.class);
            addInfo.setOperator(operator);
            return autoRemindSettingInfoDao.insertSelective(addInfo);
        } else {
            throw new ApplicationException(BizErrorCode.COMPANY_TASK_DATE_ALREAY_EXIST);
        }

    }

    /**
     * 更新提示周期
     *
     * @param info
     * @return
     */
    @Override
    public Integer update(AutoRemindSettingParam info) {

        // 判断修改日期是否小于当前系统时间
        if (!checkRundate(info.getRunDate())) {
            throw new ApplicationException(RemindErrorCode.AUTO_REMIND_SETTING_RUNDATE_ERROR);
        }

        AutoRemindSettingInfo item = autoRemindSettingInfoDao.selectByPrimaryKey(info.getId());

        if (null == item) {
            throw new ApplicationException(RemindErrorCode.AUTO_REMIND_SETTING_OPERATION_RUNDATE_ERROR);
        }

        if (item.getEnabled()) {
            throw new ApplicationException(RemindErrorCode.AUTO_REMIND_SETTING_OP_COMPLETE_ERROR);
        }

        // 判断数据库是否已有当前运行日期
        if (checkRunDateIsExist(item.getDistrict(), item.getTaskType(), info.getRunDate())) {
            AutoRemindSettingInfo updateInfo = BeanMapperUtil.map(info, AutoRemindSettingInfo.class);
            return autoRemindSettingInfoDao.updateByPrimaryKeySelective(updateInfo);
        } else {
            throw new ApplicationException(BizErrorCode.COMPANY_TASK_DATE_ALREAY_EXIST);
        }
    }

    /**
     * 验证运行周期是否小于当前系统时间
     */
    private boolean checkRundate(Date runDate) {
        DateTime dateTime = new DateTime();
        if (dateTime.isAfter(runDate.getTime())) {
            return false;
        }
        return true;
    }

    /**
     * 验证数据库是否存在当前运行日期
     */
    private boolean checkRunDateIsExist(String district, Integer taskType, Date runDate) {
        AutoRemindSettingInfoExample example = new AutoRemindSettingInfoExample();
        example.createCriteria().andDistrictEqualTo(district).andTaskTypeEqualTo(taskType).andRunDateEqualTo(runDate);
        List<AutoRemindSettingInfo> temp = autoRemindSettingInfoDao.selectByExample(example);
        if (temp == null || temp.size() == 0) {
            return true;
        }
        return false;
    }

    /**
     * 删除提示周期
     *
     * @param id
     * @return
     */
    @Override
    public Integer remove(Integer id) {
        AutoRemindSettingInfo info = autoRemindSettingInfoDao.selectByPrimaryKey(id);

        if (info == null)
            throw new ApplicationException(RemindErrorCode.AUTO_REMIND_SETTING_OPERATION_RUNDATE_ERROR);

        if (info.getEnabled()) {
            throw new ApplicationException(RemindErrorCode.AUTO_REMIND_SETTING_DELETE_ENABLE_ERROR);
        }

        if (info.getCompleted()) {
            throw new ApplicationException(RemindErrorCode.AUTO_REMIND_SETTING_DELETE_ENABLE_ERROR);
        }

        return autoRemindSettingInfoDao.deleteByPrimaryKey(id);
    }

    /**
     * 启用提示周期
     *
     * @param id
     */
    @Override
    public Integer enable(Integer id) {
        AutoRemindSettingInfo info = autoRemindSettingInfoDao.selectByPrimaryKey(id);

        if (info == null)
            throw new ApplicationException(RemindErrorCode.AUTO_REMIND_SETTING_OPERATION_RUNDATE_ERROR);

        if (info.getEnabled()) {
            return 0;
        }

        if (info.getCompleted()) {
            throw new ApplicationException(RemindErrorCode.AUTO_REMIND_SETTING_OP_COMPLETE_ERROR);
        }

        if (!checkRundate(info.getRunDate())) {
            throw new ApplicationException(RemindErrorCode.AUTO_REMIND_SETTING_ENABLE_RUNDATE_ERROR);
        }

        info.setEnabled(true);
        return autoRemindSettingInfoDao.updateByPrimaryKeySelective(info);
    }

    /**
     * 禁用提示周期
     *
     * @param id
     */
    @Override
    public Integer disable(Integer id) {
        AutoRemindSettingInfo info = autoRemindSettingInfoDao.selectByPrimaryKey(id);

        if (info == null)
            throw new ApplicationException(RemindErrorCode.AUTO_REMIND_SETTING_OPERATION_RUNDATE_ERROR);

        if (!info.getEnabled()) {
            return 0;
        }

        if (info.getCompleted()) {
            throw new ApplicationException(RemindErrorCode.AUTO_REMIND_SETTING_OP_COMPLETE_ERROR);
        }

        if (!checkRundate(info.getRunDate())) {
            throw new ApplicationException(RemindErrorCode.AUTO_REMIND_SETTING_DISABLE_RUNDATE_ERROR);
        }

        info.setEnabled(false);
        return autoRemindSettingInfoDao.updateByPrimaryKeySelective(info);
    }

    /**
     * 启用提示周期（全部）
     *
     * @param taskType 提示类型
     * @param district 区域编码
     */
    @Override
    public Integer enableAll(Integer taskType, String district) {

        if (district == null)
            district = String.valueOf(UserContext.getQuery().getAddr());
        Date now = new Date();
        AutoRemindSettingInfoExample exam = new AutoRemindSettingInfoExample();
        AutoRemindSettingInfoExample.Criteria c = exam.createCriteria();
        c.andDistrictEqualTo(district).andTaskTypeEqualTo(taskType).andEnabledEqualTo(false).andCompletedEqualTo(false).andRunDateGreaterThan(now);

        AutoRemindSettingInfo info = new AutoRemindSettingInfo();
        info.setEnabled(true);

        return autoRemindSettingInfoDao.updateByExampleSelective(info, exam);
    }

    /**
     * 禁用提示周期（全部）
     *
     * @param taskType 提示类型
     * @param district 区域编码
     */
    @Override
    public Integer disableAll(Integer taskType, String district) {

        if (district == null)
            district = String.valueOf(UserContext.getQuery().getAddr());
        Date now = new Date();
        AutoRemindSettingInfoExample exam = new AutoRemindSettingInfoExample();
        AutoRemindSettingInfoExample.Criteria c = exam.createCriteria();
        c.andDistrictEqualTo(district).andTaskTypeEqualTo(taskType).andEnabledEqualTo(true).andCompletedEqualTo(false).andRunDateGreaterThan(now);

        AutoRemindSettingInfo info = new AutoRemindSettingInfo();
        info.setEnabled(false);

        return autoRemindSettingInfoDao.updateByExampleSelective(info, exam);
    }

    /**
     * 查询提示周期列表
     *
     * @param taskType 提示类型
     * @param district 区域编码
     * @return
     */
    @Override
    public List<AutoRemindSettingQueryVo> findSettings(int taskType, String district) {

        if (district == null)
            district = String.valueOf(UserContext.getQuery().getAddr());
        AutoRemindSettingInfoExample exam = new AutoRemindSettingInfoExample();
        exam.setOrderByClause("run_date ASC");
        exam.createCriteria().andTaskTypeEqualTo(taskType).andDistrictEqualTo(district);

        List<AutoRemindSettingInfo> dbList = autoRemindSettingInfoDao.selectByExample(exam);
        List<AutoRemindSettingQueryVo> resultList = BeanMapperUtil.mapList(dbList, AutoRemindSettingQueryVo.class);

        return resultList;
    }

    @Override
    public void complete(int id) {
        AutoRemindSettingInfo info = new AutoRemindSettingInfo();
        info.setId(id);
        info.setCompleted(true);
        autoRemindSettingInfoDao.updateByPrimaryKeySelective(info);
    }

    @Override
    public AutoRemindSettingInfo getById(int id) {
        AutoRemindSettingInfo s = autoRemindSettingInfoDao.selectByPrimaryKey(id);
        if (s == null) {
            logger.info("AutoRemindSettingInfo with id : {0} is not exists.", id);
            throw new ApplicationException(CommonErrorCode.BIZ_ERROR);
        }
        return s;
    }

    @Override
    public List<AutoRemindSettingInfo> getTimeReachedSettings() {
        Date now = new Date();

        AutoRemindSettingInfoExample exam = new AutoRemindSettingInfoExample();
        AutoRemindSettingInfoExample.Criteria c = exam.createCriteria();

        c.andRunDateLessThanOrEqualTo(now).andEnabledEqualTo(true).andCompletedEqualTo(false);

        List<AutoRemindSettingInfo> list = autoRemindSettingInfoDao.selectByExample(exam);
        return list;
    }
}
