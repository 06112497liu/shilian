/**
 * BBD Service Inc
 * AllRight Reserved @2017
 */
package com.bbd.dao.system;

import com.bbd.bean.query.BaseQuery;
import com.bbd.bean.system.LoginUserInfo;
import com.bbd.bean.system.ModuleInfo;
import com.bbd.bean.system.User;
import com.bbd.bean.system.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户服务接口.
 * 
 * @author zhanghui
 */
@Repository
public interface UserDao {

    /**
     * 查询用户名和手机号码是否重复，在添加和修改时用.
     * 
     * @param user 用户信息
     * @return 数量
     */
    long selectRepeatCount(User user);

    /**
     * 修改用户.
     * @param user 用户信息.
     */
    void updateUser(User user);

    /**
     * 根据当前用户的权限信息查询用户信息.
     *  
     * @param baseQuery 查询对象
     * @return 用户信息.
     */
    List<UserInfo> selectUserInfos(BaseQuery baseQuery);

    /**
     * 添加一个用户 会将用户的id回填对象中. 
     * 
     * @param user 用户信息.
     */
    void insertUser(User user);

    /**
     * 删除一个用户.
     * 
     * @param id用户id
     */
    void deleteUserById(int id);

    /**
     * 改变一个用户的状态.
     * 
     * @param id 用户的id
     * @param status 用户的状态.0启用 -1禁用
     */
    void updateUserStatus(@Param("id") int id, @Param("status") int status);

    /**
     * 通过账号查询用户.
     * 
     * @param account 用户的用户名或者手机号码
     * @return 用户对象
     */
    LoginUserInfo selectLoginUserInfoByAccount(String account);

    /**
     * 根据用户id查询用户角色和模块.
     * 
     * @return 角色对象
     */
    List<ModuleInfo> selectUserModuleInfos(int id);

    /**
     * 删除用户模块的关联关系.
     * 
     * @param id 用户的id
     */
    void deleteUserModuleShip(Integer id);

    /**
     * 添加用户和模块的关联关系.
     * 
     * @param user 用户信息
     */
    void insertUserModuleShip(User user);

    /**
     * 查询用户的数量 分页用
     * @param query
     * @return
     */
    long selectUserCount(BaseQuery query);

    /**
     * 查询一页用户数据
     * @param query 权限查询对象
     * @param limit 起始位置
     * @param offset 结束位置
     * @return
     */
    List<UserInfo> selectUserInfoPage(@Param("query") BaseQuery query, @Param("limit") int limit, @Param("offset") int offset);

    /**
     * 查询该用户是否重复 返回重复的用户信息
     * @param user
     * @return
     */
    User selectRepeatUser(User user);
}
