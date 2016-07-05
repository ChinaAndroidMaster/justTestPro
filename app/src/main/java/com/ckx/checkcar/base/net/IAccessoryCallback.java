package com.ckx.checkcar.base.net;

/**
 * Created by lihui on 16/6/20.
 */
public interface IAccessoryCallback extends IRequestCallback
{
    public void accessoriesStart();
    public void accessoriesStop();
}
