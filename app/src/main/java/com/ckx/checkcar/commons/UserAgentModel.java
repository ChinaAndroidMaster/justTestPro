package com.ckx.checkcar.commons;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by lihui on 16/6/21.
 */
public class UserAgentModel
{
    private static final String UA_KEY_DI = "device_id";
    private static final String UA_KEY_UR = "user";
    private static final String UA_KEY_OT = "os_type";
    private static final String UA_KEY_OV = "os_version";
    private static final String UA_KEY_PN = "package_name";
    private static final String UA_KEY_AV = "app_version";
    private static final String UA_KEY_IS = "imsi";
    private static final String UA_KEY_CN = "channel";
    private static final String UA_KEY_DN = "device_name";
    private static final String UA_KEY_NT = "net";
    private static final String UA_KEY_LG = "language";

    private static UserAgentModel ourInstance = new UserAgentModel();

    public static UserAgentModel getInstance()
    {
        return ourInstance;
    }

    private HashMap<String, String> mUserAgent = new HashMap<>();

    private UserAgentModel()
    {
        mUserAgent.put(UA_KEY_AV, "");
        mUserAgent.put(UA_KEY_DI, "");
        mUserAgent.put(UA_KEY_NT, "");
        mUserAgent.put(UA_KEY_OV, "");
        mUserAgent.put(UA_KEY_OT, "");
        mUserAgent.put(UA_KEY_DN, "");
        mUserAgent.put(UA_KEY_PN, "");
        mUserAgent.put(UA_KEY_LG, "");
        mUserAgent.put(UA_KEY_IS, "");
        mUserAgent.put(UA_KEY_CN, "");
        mUserAgent.put(UA_KEY_UR, "");
    }

    public void setApp_version(String aApp_version)
    {
        mUserAgent.put(UA_KEY_AV, aApp_version);
    }

    public void setDevice_id(String aDevice_id)
    {
        mUserAgent.put(UA_KEY_DI, aDevice_id);
    }

    public void setNet(String aNet)
    {
        mUserAgent.put(UA_KEY_NT, aNet);
    }

    public void setOs_version(String aOs_version)
    {
        mUserAgent.put(UA_KEY_OV, aOs_version);
    }

    public void setOs_type(String aOs_type)
    {
        mUserAgent.put(UA_KEY_OT, aOs_type);
    }

    public void setDevice_name(String aDevice_name)
    {
        mUserAgent.put(UA_KEY_DN, aDevice_name);
    }

    public void setPackage_name(String aPackage_name)
    {
        mUserAgent.put(UA_KEY_PN, aPackage_name);
    }

    public void setLanguage(String aLanguage)
    {
        mUserAgent.put(UA_KEY_LG, aLanguage);
    }

    public void setImsi(String aImsi)
    {
        mUserAgent.put(UA_KEY_IS, aImsi);
    }

    public void setChannel(String aChannel)
    {
        mUserAgent.put(UA_KEY_CN, aChannel);
    }

    public void setUser(String aUser)
    {
        mUserAgent.put(UA_KEY_UR, aUser);
    }

    @Override
    public String toString()
    {
        String params="";
        Set<String> key = mUserAgent.keySet();
        String beginLetter="";

        for (Iterator<String> it = key.iterator(); it.hasNext();)
        {
            String s = (String) it.next();
            String value = mUserAgent.get(s);

            if (params.equals(""))
            {
                params += beginLetter + s + "=" + value;
            }
            else
            {
                params += "&" + s + "=" + value;
            }
        }
        return params;
    }
}