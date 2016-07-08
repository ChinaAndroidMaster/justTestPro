package com.ckx.checkcar.model;

import com.ckx.checkcar.base.utils.JsonUtils;

/**
 * Created by lihui on 16/7/6.
 */
public class SysData
{
    private static SysData ourInstance = new SysData();

    private String device_id;
    private String os_type;
    private String os_version;
    private String app_version;
    private String imsi;
    private String device_name;
    private String net;
    private String timestmp;

    public static SysData getInstance()
    {
        return ourInstance;
    }

    private SysData()
    {

    }

    public String sysDataJson()
    {
        //首先设置当前时间戳

        return JsonUtils.requestObjectBean(this);
    }

    public String getDevice_id()
    {
        return device_id;
    }

    public void setDevice_id(String aDevice_id)
    {
        device_id = aDevice_id;
    }

    public String getOs_type()
    {
        return os_type;
    }

    public void setOs_type(String aOs_type)
    {
        os_type = aOs_type;
    }

    public String getOs_version()
    {
        return os_version;
    }

    public void setOs_version(String aOs_version)
    {
        os_version = aOs_version;
    }

    public String getApp_version()
    {
        return app_version;
    }

    public void setApp_version(String aApp_version)
    {
        app_version = aApp_version;
    }

    public String getImsi()
    {
        return imsi;
    }

    public void setImsi(String aImsi)
    {
        imsi = aImsi;
    }

    public String getDevice_name()
    {
        return device_name;
    }

    public void setDevice_name(String aDevice_name)
    {
        device_name = aDevice_name;
    }

    public String getNet()
    {
        return net;
    }

    public void setNet(String aNet)
    {
        net = aNet;
    }

    public String getTimestmp()
    {
        return timestmp;
    }

    public void setTimestmp(String aTimestmp)
    {
        timestmp = aTimestmp;
    }
}
