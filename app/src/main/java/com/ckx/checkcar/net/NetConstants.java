package com.ckx.checkcar.net;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.ckx.checkcar.BuildConfig;

/**
 * Created by lihui on 16/6/20.
 */
public class NetConstants
{
    ///测试地址
    public static final String HOST_DEBUG = "182.92.167.162";
    public static final String PORT_DEBUG = "7799";

    ///发布地址
    public static final String HOST_REAL  = "182.92.167.162";
    public static final String PORT_REAL  = "7799";

    public static final String ROOT_URL_FORMAT  = "http://%s:%s%s";
    public static final String ROOT_URL_FORMAT1 = "http://%s%s";

    public static final String ROOT_URL_FORMATS  = "https://%s:%s%s";
    public static final String ROOT_URL_FORMATS1 = "https://%s%s";

    private static final boolean IS_DEBUG = BuildConfig.DEBUG;

    private static final boolean IS_HTTPS = false;

    public static String getHost()
    {
        String hostDebug = HOST_DEBUG;

        return IS_DEBUG ? hostDebug : HOST_REAL;
    }

    public static String getPort()
    {
        return IS_DEBUG ? PORT_DEBUG : PORT_REAL;
    }

    public static String getUrl(@NonNull String aHost, @Nullable String aPort, @NonNull String aApi)
    {
        if (null == aPort || aPort.length() < 1)
        {
            return String.format(IS_HTTPS ? ROOT_URL_FORMATS1:ROOT_URL_FORMAT1, aHost, aApi);
        }

        return String.format(IS_HTTPS ? ROOT_URL_FORMATS:ROOT_URL_FORMAT, aHost, aPort, aApi);

    }

    public static String getUrl(@NonNull String aHost, @NonNull String aApi)
    {
        return getUrl(aHost, null, aApi);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////
    //登录 我的模块相关接口
    /**登录**/
    public static final String API_LOGIN     = "/yixinhaocheApp/app/appraiser/login";

    /**我的信息**/
    public static final String API_MYINFO    = "/yixinhaocheApp/app/appraiser/getAppraiserInfo";

    /**获取手机验证码**/
    public static final String API_SMS_CODE  = "/firmware/valid_code/";

    /**修改密码**/
    public static final String API_RESET_PWD = "/firmware/valid_code/";

    ///////////////////////////////////////////////////////////////////////////////////////////////
    //列表 相关接口

    ///////////////////////////////////////////////////////////////////////////////////////////////
    //预检 相关接口
}
