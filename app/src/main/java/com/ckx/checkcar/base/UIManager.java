package com.ckx.checkcar.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by lihui on 16/6/23.
 */
public class UIManager
{
    public static void startActivity(Context aPackageContext, Class<?> aCls)
    {
        Intent intent  = new Intent();
        intent.setClass(aPackageContext, aCls);
        aPackageContext.startActivity(intent);
    }

    public static void startActivity(Context aPackageContext, Class<?> aCls, @Nullable Bundle aBundle)
    {
        Intent intent  = new Intent();
        intent.setClass(aPackageContext, aCls);

        if (null != aBundle)
        {
            intent.putExtras(aBundle);
        }
        aPackageContext.startActivity(intent);
    }

    public static void startActivityForResult(Context aPackageContext, Class<?> aCls, int aRequestCode)
    {
        Intent intent  = new Intent();
        intent.setClass(aPackageContext, aCls);
        ((Activity)aPackageContext).startActivityForResult(intent, aRequestCode);
    }

    public static void startActivityForResult(Context aPackageContext, Class<?> aCls, int aRequestCode, @Nullable  Bundle aBundle)
    {
        Intent intent  = new Intent();
        intent.setClass(aPackageContext, aCls);

        if (null != aBundle)
        {
            intent.putExtras(aBundle);
        }

        ((Activity)aPackageContext).startActivityForResult(intent, aRequestCode);
    }
}
