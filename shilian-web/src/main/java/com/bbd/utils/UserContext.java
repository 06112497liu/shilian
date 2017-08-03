/**
 * BBD Service Inc
 * AllRight Reserved @2017
 */

package com.bbd.utils;

import com.bbd.bean.query.BaseQuery;
import com.bbd.bean.system.LoginUserInfo;
import com.bbd.util.ConfigUtil;
import com.exception.ApplicationException;
import com.exception.CommonErrorCode;

import java.util.HashMap;
import java.util.Map;

/**
 * 用户的session
 * 
 * @author xc
 * @version $Id: UserContext.java, v 0.1 2016年12月5日 下午1:26:22 xc Exp $
 */
public class UserContext {

    /** 国的数据库标识 备用 */
    public static final int     COUNTRY            = 4;

    /** 省用户数据库判断标识  */
    public static final int     PROVINCE           = 3;

    /** 市用户数据库判断标识  */
    public static final int     CITY               = 2;

    /** 区级权限 */
    public static final int     DISTRICT           = 1;

    /**
     * 用户存在session中的key
     */
    private static final String ADMIN_INFO_SESSION = "user";

    private static final String QUERY_SESSION      = "query";

    private static final String MAP_SESSION        = "map";

    public static LoginUserInfo getUser() {
        return (LoginUserInfo) SessionContext.getSession(ADMIN_INFO_SESSION);
    }

    public static void setUser(LoginUserInfo user) {
        // 计算用户的权限
        setUserPermission(user);
        SessionContext.setSession(ADMIN_INFO_SESSION, user);
    }

    /**
     *  <p>Author:zh;</p>
     *  <p>Date:2016年10月17日上午11:51:16;</p>
     *	<p>Description: 删除session中的用户;</p>
     */
    public static void removeUser() {
        SessionContext.removeSession(ADMIN_INFO_SESSION);
    }

    private static void setUserPermission(LoginUserInfo user) {
        int userType = user.getType();
        int systemType = ConfigUtil.getSystemType();
        int type = 0;
        int addr = 0;
        Map<String, Object> map = new HashMap<String, Object>();
        type = (userType > systemType ? userType : systemType);
        String addrName = null;
        switch (type) {
            case PROVINCE:
                addr = Integer.valueOf(user.getProvince().getValue().toString());
                addrName = user.getProvince().getName().toString();
                map.put("province", addr);
                break;
            case CITY:
                addr = Integer.valueOf(user.getCity().getValue().toString());
                addrName = user.getCity().getName().toString();
                map.put("city", addr);
                break;
            case DISTRICT:
                addr = Integer.valueOf(user.getDistrict().getValue().toString());
                addrName = user.getDistrict().getName().toString();
                map.put("district", addr);
                break;
            default:
                break;
        }
        user.setPermissionType(type);
        user.setAddrCode(addr);
        user.setAddrName(addrName);
        BaseQuery query = new BaseQuery(type, addr);
        SessionContext.setSession(QUERY_SESSION, query);
        SessionContext.setSession(MAP_SESSION, map);
    }

    /**
     * 获取用户权限查询对象.
     * 
     * @return 查询对象
     */
    public static BaseQuery getQuery() {
        return (BaseQuery) SessionContext.getSession(QUERY_SESSION);
    }

    /**
     * 区域代码转查询对象
     * 
     * @param code 区域代码
     * @author hongQiang tang
     * @date 2017/05/09 14:32
     * @return 查询对象
     */
    public static BaseQuery codeToQuery(Integer code) {

        // 如果传入的区域代码为空，默认使用当前登录用户所在的区域
        if (code == null) {
            return getQuery();
        }

        BaseQuery query = new BaseQuery();
        query.setAddr(code);
        switch ((String.valueOf(code)).length()) {
        // 省
            case 2:
                query.setType(UserContext.PROVINCE);
                break;
            // 市
            case 4:
                query.setType(UserContext.CITY);
                break;
            // 区
            case 6:
                query.setType(UserContext.DISTRICT);
                break;
            // 异常
            default:
                throw new ApplicationException(CommonErrorCode.PARAM_ERROR);
        }
        return query;
    }

    /**
     * 
     * 
     * @return
     */
    public static Map getMap() {
        return (Map) SessionContext.getSession(MAP_SESSION);
    }

    /**
     * 获取用户权限查询对象.
     * 
     * @return 查询对象
     */
    public static BaseQuery fillQuery(BaseQuery query) {
        BaseQuery q = getQuery();
        query.setType(q == null ? 2 : q.getType());
        query.setAddr(q == null ? 5201 : q.getAddr());
        return query;
    }

    /**
     *  <p>Author:zh;</p>
     *  <p>Date:2016年10月17日上午11:51:16;</p>
     *	<p>Description: 删除session中的权限查询对象;</p>
     */
    public static void removeQuery() {
        SessionContext.removeSession(ADMIN_INFO_SESSION);
        SessionContext.removeSession(QUERY_SESSION);
        SessionContext.removeSession(MAP_SESSION);
    }
}
