package com.ckx.checkcar;

import android.app.Application;
import android.test.ApplicationTestCase;
import android.text.TextUtils;

import com.ckx.checkcar.base.net.IAccessoryCallback;
import com.ckx.checkcar.commons.utils;
import com.ckx.checkcar.model.ResultLogin;
import com.ckx.checkcar.net.api.ApiBPZUploadImg;
import com.ckx.checkcar.net.api.ApiLogin;

import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application>
{
    public ApplicationTest()
    {
        super(Application.class);

        login();

        uploadImg();
    }

    public void login()
    {
        ApiLogin tApiLogin = new ApiLogin(new IAccessoryCallback<ResultLogin>()
        {
            @Override
            public void accessoriesStart()
            {
            }

            @Override
            public void accessoriesStop()
            {
            }

            @Override
            public void onSuccess(ResultLogin result)
            {
                if (null != result)
                {
                    if (!TextUtils.isEmpty(result.getAppraiserId()) && !TextUtils.isEmpty(result.getToken()))
                    {
                        //存储
                        utils.setToken(result.getToken());
                        utils.setUserId(result.getAppraiserId());
                    }
                    else
                    {
                    }
                }
            }

            @Override
            public void onError(Throwable ex, String aErrMsg)
            {
            }

            @Override
            public void onFinished()
            {

            }
        });

        tApiLogin.setParams("18518378315", "123456");

        tApiLogin.execute();
    }

    public void uploadImg()
    {
        InputStream in = this.getApplication().getResources().openRawResource(R.raw.icon_portrait);
        ApiBPZUploadImg tApiBPZUploadImg = new ApiBPZUploadImg(new IAccessoryCallback<String>()
        {
            @Override
            public void accessoriesStart()
            {
            }

            @Override
            public void accessoriesStop()
            {
            }

            @Override
            public void onSuccess(String result)
            {

            }

            @Override
            public void onError(Throwable ex, String aErrMsg)
            {
            }

            @Override
            public void onFinished()
            {

            }
        });

        tApiBPZUploadImg.setParams("1000000001", "1");

        try
        {
            tApiBPZUploadImg.uploadImg(in, "aaaa.png");
        } catch (FileNotFoundException aE)
        {
            aE.printStackTrace();
        }
    }
}