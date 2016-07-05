package com.ckx.checkcar.base.utils;

import android.content.Context;

import com.umeng.analytics.MobclickAgent;

/**
 * Created by lihui on 16/6/17.
 */
public class UmengHelper
{
    public static void onResume(Context aContext)
    {
        MobclickAgent.onResume(aContext);
    }

    public static void onPause(Context aContext)
    {
        MobclickAgent.onPause(aContext);
    }

    public static void onPageStart(String aPageName)
    {
        MobclickAgent.onPageStart(aPageName);
    }

    public static void onPageEnd(String aPageName)
    {
        MobclickAgent.onPageEnd(aPageName);
    }
}
