package com.ckx.checkcar.base.net;

/**
 * Created by lihui on 16/6/20.
 */
public interface IRequestCallback
{
    void onSuccess(String result);

    void onError(Throwable ex, String aErrMsg);

    void onFinished();
}
