package com.ckx.checkcar.commons;

import android.support.annotation.NonNull;
import android.text.TextUtils;

/**
 * Created by lihui on 16/6/17.
 */
public final class utils
{
    private static final String KEY_FIRST_LAUNCH = "firstLaunch";
    private static final String KEY_TOKEN        = "token";
    private static final String KEY_USERID       = "userid";

    /**
     * 是否首次启动
     * @return
     */
    public static boolean isFirstLaunch()
    {
        return SPUtil.readBoolean(KEY_FIRST_LAUNCH, true);
    }

    /**
     * 已经首次启动
     */
    public static void firstLaunched()
    {
        SPUtil.writeBoolean(KEY_FIRST_LAUNCH, false);
    }

    /**
     * 获取token
     * @return
     */
    public static String token()
    {
        return SPUtil.read(KEY_TOKEN);
    }

    public static void setToken(@NonNull String aToken)
    {
        SPUtil.write(KEY_TOKEN, aToken);
    }

    public static String userId()
    {
        return SPUtil.read(KEY_USERID);
    }

    public static void setUserId(@NonNull String aUserId)
    {
        SPUtil.write(KEY_USERID, aUserId);
    }

    public static boolean isLogin()
    {
        return ( !TextUtils.isEmpty(token()) && ! TextUtils.isEmpty(userId())) ? false : true;
    }
}
