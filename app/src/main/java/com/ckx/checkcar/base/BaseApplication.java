package com.ckx.checkcar.base;

import android.app.Application;

import com.ckx.checkcar.base.utils.XUtils3Helper;
import com.ckx.checkcar.commons.SPUtil;
import com.socks.library.KLog;

import com.ckx.checkcar.BuildConfig;
import com.ckx.checkcar.base.utils.LeakcanaryHelper;

/**
 * Created by lihui on 16/6/17.
 */
public class BaseApplication extends Application
{
    @Override
    public void onCreate()
    {
        super.onCreate();
        init();
    }

    private void init()
    {
        //内存泄漏检测
        LeakcanaryHelper.getInstance().install(this);

        //log
        KLog.init(BuildConfig.DEBUG);

        //bugly
//        BuglyHelper.initCrashReport(this);


        //SP
        SPUtil.init(this);

        //
        XUtils3Helper.init(this, true);
    }
}
