package com.ckx.checkcar.base.net;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestHandle;
import com.loopj.android.http.RequestParams;
import java.util.Map;

/**
 * Created by lihui on 16/7/4.
 */
public class HttpClient
{
    private static AsyncHttpClient client = new AsyncHttpClient();

    public static RequestHandle get(String aUrl, RequestParams aParams, AsyncHttpResponseHandler aResponseHandler)
    {
        return client.get(aUrl, aParams, aResponseHandler);
    }

    public static RequestHandle get(String aUrl, AsyncHttpResponseHandler aResponseHandler)
    {
        return client.get(aUrl, aResponseHandler);
    }

    public static RequestHandle get(String aUrl, Map<String, String> aHeader, RequestParams aParams, AsyncHttpResponseHandler aResponseHandler)
    {
        if (null != aHeader && aHeader.size() > 0)
        {
            for (Map.Entry<String, String> entry : aHeader.entrySet())
            {
                client.addHeader(entry.getKey(), entry.getValue());
            }
        }

        return client.get(aUrl, aParams, aResponseHandler);
    }

    public static RequestHandle get(String aUrl, Map<String, String> aHeader, AsyncHttpResponseHandler aResponseHandler)
    {
        if (null != aHeader && aHeader.size() > 0)
        {
            for (Map.Entry<String, String> entry : aHeader.entrySet())
            {
                client.addHeader(entry.getKey(), entry.getValue());
            }
        }

        return client.get(aUrl, aResponseHandler);
    }

    public static RequestHandle post(String aUrl, RequestParams aParams, AsyncHttpResponseHandler aResponseHandler)
    {
        return client.post(aUrl, aParams, aResponseHandler);
    }

    public static RequestHandle post(String aUrl, Map<String, String> aHeader, RequestParams aParams, AsyncHttpResponseHandler aResponseHandler)
    {
        if (null != aHeader && aHeader.size() > 0)
        {
            for (Map.Entry<String, String> entry : aHeader.entrySet())
            {
                client.addHeader(entry.getKey(), entry.getValue());
            }
        }

        return client.post(aUrl, aParams, aResponseHandler);
    }

    public static RequestHandle request(HttpMethod aMethod, String aUrl, Map<String, String> aHeader, RequestParams aParams, AsyncHttpResponseHandler aResponseHandler)
    {
        switch (aMethod)
        {
            case GET:
                if (null != aHeader && aHeader.size() > 0)
                {
                    return get(aUrl, aHeader, aParams, aResponseHandler);
                }
                else
                {
                    return get(aUrl, aParams, aResponseHandler);
                }
            case POST:
                if (null != aHeader && aHeader.size() > 0)
                {
                    return post(aUrl, aHeader, aParams, aResponseHandler);
                }
                else
                {
                    return post(aUrl, aParams, aResponseHandler);
                }
            default:
                if (null != aHeader && aHeader.size() > 0)
                {
                    return post(aUrl, aHeader, aParams, aResponseHandler);
                }
                else
                {
                    return post(aUrl, aParams, aResponseHandler);
                }
        }
    }
}
