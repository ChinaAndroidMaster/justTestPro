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
    public static final String HOST_DEBUG = "api.fitahol.com";
    public static final String PORT_DEBUG = "";//"";

    ///发布地址
    public static final String HOST_REAL  = "api.fitahol.com";
    public static final String PORT_REAL  = "";

    public static final String ROOT_URL_FORMAT  = "http://%s:%s";
    public static final String ROOT_URL_FORMAT1 = "http://%s";

    public static final String ROOT_URL_FORMATS  = "https://%s:%s";
    public static final String ROOT_URL_FORMATS1 = "https://%s";

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
        if (null == getPort() || getPort().length() < 1)
        {
            return String.format(IS_HTTPS ? ROOT_URL_FORMATS1:ROOT_URL_FORMAT1, getHost());
        }

        return String.format(IS_HTTPS ? ROOT_URL_FORMATS:ROOT_URL_FORMAT, getHost(), getPort());

    }

    public static String getUrl(@NonNull String aHost, @NonNull String aApi)
    {
        return getUrl(aHost, null, aApi);
    }

    ///获取手机验证码
    public static final String API_SMS_CODE  = "/firmware/valid_code/";

    ///登录
    public static final String API_LOGIN     = "/firmware/valid_code/";

    ///重置密码
    public static final String API_RESET_PWD = "/firmware/valid_code/";

    ///注册
//    public static final String API_LOGIN     = "/firmware/valid_code/";
}
