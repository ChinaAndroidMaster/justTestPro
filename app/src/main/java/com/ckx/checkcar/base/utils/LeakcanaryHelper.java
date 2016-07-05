package com.ckx.checkcar.base.utils;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/**
 * Created by lihui on 16/6/17.
 */
public class LeakcanaryHelper
{
    private static LeakcanaryHelper ourInstance = null;

    private RefWatcher mRefWatcher = null;

    public static LeakcanaryHelper getInstance()
    {
        if (null == ourInstance)
        {
            ourInstance = new LeakcanaryHelper();
        }
        return ourInstance;
    }

    private LeakcanaryHelper()
    {
    }

    public void install(Application aApp)
    {
        if (null == mRefWatcher)
        {
            mRefWatcher = LeakCanary.install(aApp);
        }
    }

    public RefWatcher getRefWatcher()
    {
        return  mRefWatcher;
    }
}
