/**  
 * BBD Service Inc
 * All Rights Reserved @2016
 *
 */
package com.bbd.dao.system;

import com.bbd.bean.system.ModuleInfo;
import com.bbd.bean.system.UserModulesVo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 系统模块数据层
 * @author yujiahao
 * @version $Id: ModuleDao.java, v 0.1 2016年12月8日 上午10:51:05 yujiahao Exp $
 */
@Repository
public interface ModuleDao {

    /**
     * 查询所有系统模块
     * @return
     */
    List<ModuleInfo> selectModuleInfos();

    /**
     * 根据用户id查询用户的模块
     * @return
     */
    UserModulesVo selectUserModuleInfos(Integer id);

    /**
     * 查询所有的模块
     * @return
     */
    List<ModuleInfo> selectAllModuleInfos();

}
