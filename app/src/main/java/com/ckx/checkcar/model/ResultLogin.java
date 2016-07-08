package com.ckx.checkcar.model;

/**
 * Created by lihui on 16/7/8.
 */
public class ResultLogin extends Object
{
    private String token;
    private String appraiserId;

    public String getToken()
    {
        return token;
    }

    public void setToken(String aToken)
    {
        token = aToken;
    }

    public String getAppraiserId()
    {
        return appraiserId;
    }

    public void setAppraiserId(String aAppraiserId)
    {
        appraiserId = aAppraiserId;
    }
}
