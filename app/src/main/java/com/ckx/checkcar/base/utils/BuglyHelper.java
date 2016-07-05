package com.ckx.checkcar.base.utils;

import android.content.Context;

import com.tencent.bugly.crashreport.CrashReport;

/**
 * Created by lihui on 16/6/17.
 */
public class BuglyHelper
{
    /**
     * 使用此方法 需要在 androidmanifest.xml中 配置
     * @param aContext
     */
    public static void initCrashReport(Context aContext)
    {
        CrashReport.initCrashReport(aContext);
    }

    /**
     * appKey 需要去 bugly官网去申请
     * @param aContext
     * @param aAppKey
     */
    public static void initCrashReport(Context aContext, String aAppKey)
    {
        CrashReport.initCrashReport(aContext, aAppKey,false);
    }
}
