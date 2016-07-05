package com.ckx.checkcar.commons;

/**
 * Created by lihui on 16/6/17.
 */
public final class utils
{
    private static final String FIRST_LAUNCH_KEY = "firstLaunch";

    /**
     * 是否首次启动
     * @return
     */
    public static boolean isFirstLaunch()
    {
        return SPUtil.readBoolean(FIRST_LAUNCH_KEY, true);
    }

    /**
     * 已经首次启动
     */
    public static void firstLaunched()
    {
        SPUtil.writeBoolean(FIRST_LAUNCH_KEY, false);
    }
}
