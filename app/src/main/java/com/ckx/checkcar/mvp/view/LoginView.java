package com.ckx.checkcar.mvp.view;

import com.ckx.checkcar.base.ui.BaseView;

/**
 * Created by lihui on 16/7/6.
 */
public interface LoginView extends BaseView
{
    public void result(boolean aSucess, String aMsg);
    public String getPhoneNum();
    public String getPasswd();

    public void showActionProgress();
    public void hideActionProgress();
}
