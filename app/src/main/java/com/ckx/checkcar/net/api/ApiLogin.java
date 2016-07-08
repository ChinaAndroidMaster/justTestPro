package com.ckx.checkcar.net.api;

import com.ckx.checkcar.base.net.IRequestCallback;
import com.ckx.checkcar.model.LoginBean;
import com.ckx.checkcar.model.ResultLogin;
import com.ckx.checkcar.net.APPBaseRequest;
import com.ckx.checkcar.net.NetConstants;

/**
 * Created by lihui on 16/6/20.
 */
public class ApiLogin extends APPBaseRequest<ResultLogin>
{
    public ApiLogin(IRequestCallback aRequestCallback)
    {
        super(aRequestCallback);
    }

    @Override
    public String getApi()
    {
        return NetConstants.API_LOGIN;
    }

    public void setParams(String aPhoneNum, String aPasswd)
    {
        setParams(new LoginBean(aPhoneNum, aPasswd));
    }
}
