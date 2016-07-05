package com.ckx.checkcar.base.utils;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;

/**
 * Created by lihui on 16/6/30.
 */
public class ActivityMetaDataTool
{
    /**
     * 获取 application 中 meta data 中 对应名称的 值
     * @param aActivity NonNull
     * @param aKey NonNull
     * @return a String value or null
     */
    public static String getMetaData(@NonNull Activity aActivity, @NonNull String aKey)
    {
        ActivityInfo tInfo;

        try
        {
            tInfo = aActivity.getPackageManager().getActivityInfo(aActivity.getComponentName(), PackageManager.GET_META_DATA);
            return tInfo.metaData.getString(aKey);
        }
        catch (Exception e)
        {

        }
        return null;
    }
}
