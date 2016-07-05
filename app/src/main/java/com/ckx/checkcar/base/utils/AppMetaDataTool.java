package com.ckx.checkcar.base.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;

/**
 * Created by lihui on 16/6/30.
 */
public class AppMetaDataTool
{
    /**
     * 获取 application 中 meta data 中 对应名称的 值
     * @param aContext NonNull
     * @param aKey NonNull
     * @return a String value or null
     */
    public static String getMetaData(@NonNull Context aContext, @NonNull String aKey)
    {
        ApplicationInfo tInfo;

        try
        {
            tInfo = aContext.getPackageManager().getApplicationInfo(aContext.getPackageName(), PackageManager.GET_META_DATA);
            return tInfo.metaData.getString(aKey);
        }
        catch (Exception e)
        {

        }
        return null;
    }
}
