package com.ckx.checkcar.commons;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

import com.ckx.checkcar.base.utils.ConnectionManager;
import com.ckx.checkcar.model.SysData;

import java.util.Locale;

/**
 * Created by lihui on 16/6/22.
 */
public class DeviceInfoUtil
{
    public static void init(Context aContext)
    {
        WindowManager manager = (WindowManager) aContext
                .getSystemService(Context.WINDOW_SERVICE);
        Display display = manager.getDefaultDisplay();

        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);

//        UserAgentModel tUserAgentModel = UserAgentModel.getInstance();
        SysData tSysData = SysData.getInstance();

        //app_version
        PackageManager pm = aContext.getPackageManager();//context为当前Activity上下文
        PackageInfo pi = null;
        try
        {
            pi = pm.getPackageInfo(aContext.getPackageName(), 0);
            String versionName = pi.versionName;
            int versionCode = pi.versionCode;

            tSysData.setApp_version(versionName + "." + versionCode);

        } catch (PackageManager.NameNotFoundException aE)
        {
            aE.printStackTrace();
        }

        //net
        if (ConnectionManager.isWifiConnected(aContext))
        {
            tSysData.setNet("WIFI");
        }
        else if (ConnectionManager.isMobileConnected(aContext))
        {
            tSysData.setNet("mobile");
        }

        //os version
        tSysData.setOs_version(android.os.Build.VERSION.RELEASE);

        //os type
        tSysData.setOs_type(Build.MODEL);

        //device name
        tSysData.setDevice_name(Build.BRAND);

        //imsi
        TelephonyManager mTelephonyMgr = (TelephonyManager) aContext.getSystemService(Context.TELEPHONY_SERVICE);
        String imsi = mTelephonyMgr.getSubscriberId();
        tSysData.setImsi(imsi);

        //device id
//        String android_id = Settings.Secure.getString(aContext.getContentResolver(), Settings.Secure.ANDROID_ID);
//        tUserAgentModel.setDevice_id(android_id);
        String imei = mTelephonyMgr.getDeviceId();
        tSysData.setDevice_id(imei);
    }

    /**
     * 组装UserAgent 用于服务器提交信息
     * @return
     */
    public static String getUserAgent()
    {
        return UserAgentModel.getInstance().toString();
    }
}
