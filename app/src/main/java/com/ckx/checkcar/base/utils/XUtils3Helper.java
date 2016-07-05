package com.ckx.checkcar.base.utils;

import android.app.Application;

import org.xutils.x;

/**
 * Created by lihui on 16/6/18.
 */
public class XUtils3Helper
{
    public static void init(Application aApp, boolean aIsDebug)
    {
        x.Ext.init(aApp);
        x.Ext.setDebug(aIsDebug); // 是否输出debug日志, 开启debug会影响性能.
    }
}
