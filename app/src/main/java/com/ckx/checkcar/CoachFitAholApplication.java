package com.ckx.checkcar;

import com.ckx.checkcar.base.BaseApplication;
import com.ckx.checkcar.base.edutils.Des3Util;
import com.ckx.checkcar.commons.Constants;
import com.ckx.checkcar.commons.DeviceInfoUtil;

/**
 * Created by lihui on 16/6/21.
 */
public class CoachFitAholApplication extends BaseApplication
{
    @Override
    public void onCreate()
    {
        super.onCreate();
        init();
    }

    @Override
    public void onLowMemory()
    {
        super.onLowMemory();
    }

    @Override
    public void onTrimMemory(int level)
    {
        super.onTrimMemory(level);
    }

    private void init()
    {
        //初始化 加密相关参数
        Des3Util.setIV(Constants.IV);
        Des3Util.setDESKEY(Constants.DES3KEY);

        //初始化 sysdata
        DeviceInfoUtil.init(this);
    }
}
