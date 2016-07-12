package com.ckx.checkcar.mvp.presenter;

import android.text.TextUtils;

import com.ckx.checkcar.base.net.IAccessoryCallback;
import com.ckx.checkcar.base.presenter.BaseBPresenter;
import com.ckx.checkcar.commons.utils;
import com.ckx.checkcar.model.ResultLogin;
import com.ckx.checkcar.mvp.view.LoginView;
import com.ckx.checkcar.net.api.ApiBPZUploadImg;
import com.ckx.checkcar.net.api.ApiLogin;

import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Created by lihui on 16/7/6.
 */
public class LoginPresenter extends BaseBPresenter<LoginView>
{
    public void login()
    {
        ApiLogin tApiLogin = new ApiLogin(new IAccessoryCallback<ResultLogin>()
        {
            @Override
            public void accessoriesStart()
            {
                getView().showActionProgress();
            }

            @Override
            public void accessoriesStop()
            {
                getView().hideActionProgress();
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
                        getView().result(true, "");
                    }
                    else
                    {
                        getView().result(false, "");
                    }
                }
            }

            @Override
            public void onError(Throwable ex, String aErrMsg)
            {
                getView().result(false, aErrMsg);
            }

            @Override
            public void onFinished()
            {

            }
        });

        tApiLogin.setParams(getView().getPhoneNum(), getView().getPasswd());

        tApiLogin.execute();
    }
}
