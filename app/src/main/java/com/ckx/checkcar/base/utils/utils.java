package com.ckx.checkcar.base.utils;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.ckx.checkcar.commons.SPUtil;

/**
 * Created by lihui on 16/6/22.
 */
public class utils
{
    private static final String TOKEN  = "TokenAuthentication";
    private static final String USERID = "UserId";

    /**
     * 设置服务器返回的token
     * @param aToken
     */
    public static void setToken(@NonNull String aToken)
    {
        SPUtil.write(TOKEN, aToken);
    }

    /**
     * 获取保存在本地的Token
     * @return
     */
    public static String getToken()
    {
        return SPUtil.read(TOKEN);
    }

    /**
     * 删除token
     */
    public static void removeToken()
    {
        SPUtil.remove(TOKEN);
    }

    /**
     * 设置用户ID
     * @param aUserId
     */
    public static  void setUserId(@NonNull String aUserId)
    {
        SPUtil.write(USERID, aUserId);
    }

    /**
     * 获取用户ID
     * @return
     */
    public static String getUserid()
    {
        return SPUtil.read(USERID);
    }

    /**
     * 删除用户ID
     */
    public static void removeUserId()
    {
        SPUtil.remove(USERID);
    }

    public static void quit()
    {
        removeToken();
        removeUserId();
    }

    /**
     * 判断登录是否在有效时长内
     * @return
     */
    public static boolean outofDate()
    {
        return true;
    }

    /**
     * 判断此时是否需要登录
     * @return
     */
    public static boolean isLogin()
    {
        if (TextUtils.isEmpty(getToken()) || TextUtils.isEmpty(getUserid()) || outofDate())
        {
            return true;
        }

        return false;
    }
}
