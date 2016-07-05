package com.ckx.checkcar.net.api;

import com.ckx.checkcar.net.APPBaseRequest;
import com.ckx.checkcar.net.NetConstants;

/**
 * Created by lihui on 16/6/20.
 */
public class ApiSmsCode extends APPBaseRequest
{
    ///验证码获取类型
    private final int  SMS_REG       = 1;
    private final int  SMS_RESET_PWD = 1;

    @Override
    public LHHttpMethod getHttpMethod()
    {
        return LHHttpMethod.GET;
    }

    @Override
    public String getRequestApi()
    {
        return NetConstants.API_SMS_CODE;
    }

    public void setParams(String aPhoneNum, int aType)
    {
        BaseParams tParams = getParams();
        tParams.setUrl(getRequestUrl());

        tParams.addHeader("Content-Type", "application/json");
        tParams.addQueryStringParameter("account", aPhoneNum);
        if (1 == aType)
        {
            tParams.addQueryStringParameter("v_type", "register");
        }
        else
        {
            tParams.addQueryStringParameter("v_type", "reset_pwd");
        }
    }
}
