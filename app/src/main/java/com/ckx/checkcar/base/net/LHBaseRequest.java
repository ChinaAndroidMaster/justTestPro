package com.ckx.checkcar.base.net;

import com.ckx.checkcar.base.edutils.EncryptDecrypt;
import com.ckx.checkcar.base.utils.JsonUtils;
import com.ckx.checkcar.model.SysData;
import com.loopj.android.http.AsyncHttpResponseHandler;

import com.loopj.android.http.RequestHandle;
import com.loopj.android.http.RequestParams;
import com.orhanobut.logger.Logger;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;

/**
 * Created by lihui on 16/7/4.
 */
public abstract class LHBaseRequest
{
    private static final String KEY_DATA    = "data";
    private static final String KEY_SYSDATA = "sysData";

//    private BaseRequest mBaseRequest = null;

    protected IRequestCallback mRequestCallback = null;

    public RequestParams mRequestParams = new RequestParams();

//    private AsyncHttpResponseHandler mAsyncHttpResponseHandler = null;
//
//    private Context mContext;

    private RequestHandle mRequestHandle = null;

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
        if (null != mRequestHandle)
        {
            if (!mRequestHandle.isCancelled())
            {
                mRequestHandle.cancel(true);
            }
            mRequestHandle = null;
        }
    }

    public RequestParams getRequestParams()
    {
        return mRequestParams;
    }

    public RequestHandle execute(AsyncHttpResponseHandler aAsyncHttpResponseHandler)
    {
        Logger.d("url: %s", getUrl());

        mRequestHandle = HttpClient.request(getHttpMethod(), getUrl(), getHeaders(), mRequestParams, aAsyncHttpResponseHandler);
        return mRequestHandle;
    }

    public RequestHandle uploadImg(String aImgPath, String aName, AsyncHttpResponseHandler aAsyncHttpResponseHandler) throws FileNotFoundException
    {
        Logger.d("url: %s", getUrl());
        Logger.d("imgpath: %s", aImgPath);

        mRequestHandle = HttpClient.uploadFile(aImgPath, aName, getUrl(), mRequestParams, aAsyncHttpResponseHandler);
        return mRequestHandle;
    }

    public RequestHandle uploadImg(InputStream aInputStream, String aName, AsyncHttpResponseHandler aAsyncHttpResponseHandler) throws FileNotFoundException
    {
        Logger.d("url: %s", getUrl());

        mRequestHandle = HttpClient.uploadFile(aInputStream, aName, getUrl(), mRequestParams, aAsyncHttpResponseHandler);
        return mRequestHandle;
    }

    public void setParams(Object aObject)
    {
        String json       = JsonUtils.requestObjectBean(aObject);

        Logger.d("Login: %s", json);

        String encryptStr = EncryptDecrypt.getInstance().encrypt(json);

        mRequestParams.put(KEY_DATA, encryptStr);

        Logger.d("SysData: %s", SysData.getInstance().sysDataJson());
        mRequestParams.put(KEY_SYSDATA, SysData.getInstance().sysDataJson());
    }
}
