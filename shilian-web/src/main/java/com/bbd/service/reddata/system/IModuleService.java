/**  
 * BBD Service Inc
 * All Rights Reserved @2016
 *
 */
package com.bbd.service.reddata.system;

import com.bbd.bean.system.ModuleInfo;
import com.bbd.bean.system.UserModulesVo;

import java.util.List;

/**
 * 模块服务接口.
 * @author zhanghui
 * @version $Id: IModuleService.java, v 0.1 2016年12月13日 上午10:18:09 zhanghui Exp $
 */
public interface IModuleService {

    /**
     * 查询所有的模块.
     * @return
     */
    List<ModuleInfo> getModules();

    /**
     * 获取当前用户的模块
     */
    UserModulesVo getUserModuleInfos(Integer id);

}
