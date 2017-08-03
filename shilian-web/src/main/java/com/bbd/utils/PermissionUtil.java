/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.utils;

import com.bbd.Constants;
import com.bbd.bean.query.BaseQuery;
import com.bbd.exception.BizErrorCode;
import com.bbd.util.StringUtils;
import com.exception.ApplicationException;

/**
 *
 * @author tjwang
 * @version $Id: PermissionUtil.java, v 0.1 2017/6/21 0021 15:04 tjwang Exp $
 */
public class PermissionUtil {

    public static void checkPermission(String district) {
        BaseQuery query = UserContext.getQuery();
        String addr = String.valueOf(query.getAddr());

        if (StringUtils.isBlank(district)) {
            if (addr.equals(Constants.GUIYANG_CODE)) {
                return;
            }
            throw new ApplicationException(BizErrorCode.PERMISSION_NOT_ENOUGH);
        }

        if (district.contains(addr)) {
            return;
        }
        throw new ApplicationException(BizErrorCode.PERMISSION_NOT_ENOUGH);
    }
}
