package com.ckx.checkcar.base.ui.activity;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.ckx.checkcar.base.utils.UmengHelper;
import com.github.johnpersano.supertoasts.SuperActivityToast;
import com.github.johnpersano.supertoasts.SuperToast;
import com.hannesdorfmann.mosby.mvp.MvpActivity;
import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.hannesdorfmann.mosby.mvp.MvpView;

import butterknife.ButterKnife;

/**
 * Created by lihui on 16/6/17.
 */
public abstract class BaseActivity<V extends MvpView, P extends MvpPresenter<V>> extends MvpActivity<V,P>
{
    private boolean mIsXmlLayout = true;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        if (isXmlLayout())
        {
            setContentView(layoutResID());

            //注解注册
            ButterKnife.bind(this);

            initViews();
            initEvents();
        }
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        UmengHelper.onResume(this);
        UmengHelper.onPageStart(this.getLocalClassName());
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        UmengHelper.onPause(this);
        UmengHelper.onPageEnd(this.getLocalClassName());
    }

    public abstract @LayoutRes int layoutResID();

    public abstract void initViews();
    public abstract void initEvents();

    public boolean isXmlLayout()
    {
        return mIsXmlLayout;
    }

    public void toast(String aMsg)
    {
        toast(aMsg, SuperToast.Duration.LONG);
    }

    public void toastLong(String aMsg)
    {
        toast(aMsg);
    }

    public void toastShort(String aMsg)
    {
        toast(aMsg, SuperToast.Duration.SHORT);
    }

    public void toast(String aMsg, int aDurationInteger)
    {
        SuperActivityToast.create(this, aMsg, aDurationInteger);
    }
}
