package com.ckx.checkcar.net.api;

import com.ckx.checkcar.net.APPBaseRequest;
import com.ckx.checkcar.net.NetConstants;

/**
 * Created by lihui on 16/6/20.
 */
public class ApiLogin extends APPBaseRequest
{
    @Override
    public String getRequestApi()
    {
        return NetConstants.API_LOGIN;
    }
}
