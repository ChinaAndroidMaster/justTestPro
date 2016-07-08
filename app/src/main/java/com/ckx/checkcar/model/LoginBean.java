package com.ckx.checkcar.model;

/**
 * Created by lihui on 16/7/6.
 */
public class LoginBean extends BaseBean
{
    private String phone_number;
    private String password;

    public LoginBean(String aPhone_number, String aPassword)
    {
        super();
        phone_number = aPhone_number;
        password = aPassword;
    }
}
