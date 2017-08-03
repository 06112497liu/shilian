/**  
 * BBD Service Inc
 * All Rights Reserved @2016
 *
 */
package com.bbd.service.reddata.system.impl;

import com.bbd.bean.system.ModuleInfo;
import com.bbd.bean.system.UserModulesVo;
import com.bbd.dao.system.ModuleDao;
import com.bbd.service.reddata.system.IModuleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 模块服务实现类.
 * @author zhanghui
 * @version $Id: ModuleServiceImpl.java, v 0.1 2016年12月13日 上午10:19:03 zhanghui Exp $
 */
@Service
public class ModuleServiceImpl implements IModuleService {

    @Resource
    private ModuleDao moduleDao;

    /** 
     * @see IModuleService#getModules()
     */
    @Override
    public List<ModuleInfo> getModules() {
        return moduleDao.selectModuleInfos();
    }

    /** 
     * @see IModuleService
     */
    @Override
    public UserModulesVo getUserModuleInfos(Integer id) {
        return moduleDao.selectUserModuleInfos(id);
    }

}
