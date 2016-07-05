package com.ckx.checkcar.net;

import com.ckx.checkcar.base.edutils.EncryptDecrypt;
import com.ckx.checkcar.base.net.HttpMethod;
import com.ckx.checkcar.base.net.IAccessoryCallback;
import com.ckx.checkcar.base.net.IRequestCallback;
import com.ckx.checkcar.base.net.LHBaseRequest;
import com.ckx.checkcar.base.utils.JsonUtils;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONObject;

import java.util.Map;

import cz.msebera.android.httpclient.Header;

/**
 * Created by lihui on 16/6/20.
 */
public class APPBaseRequest<T> extends LHBaseRequest
{
    private static final String KEY_RET_CODE  = "retCode";
    private static final String KEY_ERR_MSG   = "errorMsg";
    private static final String KEY_RET_VALUE = "value";
    private static final String CODE_SUCCESS  = "200";

    public APPBaseRequest(IRequestCallback aRequestCallback)
    {
        super(aRequestCallback);
    }

    private String decrypt(String aSrc)
    {
        return EncryptDecrypt.getInstance().decrypt(aSrc);
    }

    @Override
    public Map<String, String> getHeaders()
    {
        return null;
    }

    @Override
    public String getBaseUrl()
    {
        return NetConstants.getHost();
    }

    @Override
    public String getApi()
    {
        return null;
    }

    @Override
    public String getPort()
    {
        return NetConstants.getPort();
    }

    @Override
    public HttpMethod getHttpMethod()
    {
        //默认为post
        return HttpMethod.POST;
    }

    @Override
    public String getUrl()
    {
        return NetConstants.getUrl(getBaseUrl(), getPort(), getApi());
    }

    public void execute()
    {
        super.execute(new JsonHttpResponseHandler(){
            @Override
            public void onStart()
            {
                super.onStart();
                if (null != mRequestCallback && mRequestCallback instanceof IAccessoryCallback)
                {
                    ((IAccessoryCallback)mRequestCallback).accessoriesStart();
                }
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response)
            {
                super.onSuccess(statusCode, headers, response);
                if(null != mRequestCallback)
                {

                    if (200 == statusCode && null != response)
                    {
                        OperResponse res = JsonUtils.parserJsonStr2Obj(response, OperResponse.class);

                        if (null != res)
                        {
                            if (res.retCode.equals(CODE_SUCCESS))
                            {
                                if (null != res.value && res.value.length() > 0)
                                {
                                    //解密
                                    String decrypted = decrypt(res.value);
                                    mRequestCallback.onSuccess(decrypted);
                                }
                            }
                            else
                            {
                                //TODO,其他错误
                            }
                        }
                        else
                        {
                            //TODO,其他错误
                        }
                    }
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable)
            {
                super.onFailure(statusCode, headers, responseString, throwable);
                if(null != mRequestCallback)
                {
                    mRequestCallback.onError(throwable, responseString);
                }
            }

            @Override
            public void onFinish()
            {
                super.onFinish();
                if (null != mRequestCallback )
                {
                    mRequestCallback.onFinished();
                    if ( mRequestCallback instanceof IAccessoryCallback)
                    {
                        ((IAccessoryCallback)mRequestCallback).accessoriesStop();
                    }
                }
            }
        });
    }
}