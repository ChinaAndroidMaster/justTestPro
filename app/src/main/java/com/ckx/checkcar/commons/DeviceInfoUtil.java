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

        UserAgentModel tUserAgentModel = UserAgentModel.getInstance();

        //app_version
        PackageManager pm = aContext.getPackageManager();//context为当前Activity上下文
        PackageInfo pi = null;
        try
        {
            pi = pm.getPackageInfo(aContext.getPackageName(), 0);
            String versionName = pi.versionName;
            int versionCode = pi.versionCode;

            tUserAgentModel.setApp_version(versionName + "." + versionCode);

        } catch (PackageManager.NameNotFoundException aE)
        {
            aE.printStackTrace();
        }

        //net
        if (ConnectionManager.isWifiConnected(aContext))
        {
            tUserAgentModel.setNet("WIFI");
        }
        else if (ConnectionManager.isMobileConnected(aContext))
        {
            tUserAgentModel.setNet("mobile");
        }

        //lanuguge
        Locale locale = aContext.getResources().getConfiguration().locale;
        String language = locale.getLanguage();
        tUserAgentModel.setLanguage(language);

        //os version
        tUserAgentModel.setOs_version(android.os.Build.VERSION.RELEASE);

        //os type
        tUserAgentModel.setOs_type(Build.MODEL);

        //device name
        tUserAgentModel.setDevice_name(Build.BRAND);

        //package name
        tUserAgentModel.setPackage_name(aContext.getPackageName());

        //imsi
        TelephonyManager mTelephonyMgr = (TelephonyManager) aContext.getSystemService(Context.TELEPHONY_SERVICE);
        String imsi = mTelephonyMgr.getSubscriberId();
        tUserAgentModel.setImsi(imsi);

        //device id
//        String android_id = Settings.Secure.getString(aContext.getContentResolver(), Settings.Secure.ANDROID_ID);
//        tUserAgentModel.setDevice_id(android_id);
        String imei = mTelephonyMgr.getDeviceId();
        tUserAgentModel.setDevice_id(imei);

        //channel

        //user
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
