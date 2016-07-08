package com.ckx.checkcar.model;

import com.ckx.checkcar.base.utils.utils;

import java.io.Serializable;

/**
 * Created by lihui on 16/7/6.
 */
public class BaseBean implements Serializable
{
    protected String token = null;

    public BaseBean()
    {
        token = utils.getToken();
    }
}
