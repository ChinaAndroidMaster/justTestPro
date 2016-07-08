package com.ckx.checkcar.base.net;

/**
 * Created by lihui on 16/6/20.
 */
public interface IAccessoryCallback<T> extends IRequestCallback<T>
{
    public void accessoriesStart();
    public void accessoriesStop();
}
