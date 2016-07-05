package com.ckx.checkcar.base.net;

import android.content.Context;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.request.BaseRequest;

import com.loopj.android.http.RequestParams;

import java.util.Map;

/**
 * Created by lihui on 16/7/4.
 */
public abstract class LHBaseRequest
{
    private BaseRequest mBaseRequest = null;

    protected IRequestCallback mRequestCallback = null;

    public RequestParams mRequestParams = new RequestParams();

    private AsyncHttpResponseHandler mAsyncHttpResponseHandler = null;

    private Context mContext;
    /**
     * 获取头部参数
     * @return
     */
    public abstract Map<String, String> getHeaders();

    /**
     * host 获取
     * @return
     */
    public abstract String getBaseUrl();

    /**
     * api 获取
     * @return
     */
    public abstract String getApi();

    /**
     * 端口号获取
     * @return
     */
    public abstract String getPort();

    public abstract HttpMethod getHttpMethod();

    public abstract String getUrl();

    public LHBaseRequest(IRequestCallback aRequestCallback)
    {
        super();
        mRequestCallback = aRequestCallback;
    }

    public void cancel()
    {
        if (null != mBaseRequest)
        {
            OkHttpUtils.getInstance().cancelTag(mBaseRequest);
            mBaseRequest = null;
        }
    }

    public RequestParams getRequestParams()
    {
        return mRequestParams;
    }

    public void execute(AsyncHttpResponseHandler aAsyncHttpResponseHandler)
    {
        HttpClient.request(getHttpMethod(), getUrl(), getHeaders(), mRequestParams, aAsyncHttpResponseHandler);
    }
}
