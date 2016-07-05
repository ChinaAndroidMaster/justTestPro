package com.ckx.checkcar.mvp.activity.splash;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.ckx.checkcar.R;
import com.ckx.checkcar.base.UIManager;
import com.ckx.checkcar.base.ui.activity.BaseActivity;
import com.ckx.checkcar.mvp.activity.welcome.WelcomeActivity;
import com.ckx.checkcar.mvp.presenter.SplashPresenter;
import com.ckx.checkcar.mvp.view.SplashView;

public class SplashActivity extends BaseActivity<SplashView, SplashPresenter> implements SplashView
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        this.startCountDown();
    }

    @Override
    public int layoutResID()
    {
        return R.layout.activity_splash;
    }

    @Override
    public void initViews()
    {
    }

    @Override
    public void initEvents()
    {
    }

    @NonNull
    @Override
    public SplashPresenter createPresenter()
    {
        return new SplashPresenter();
    }

    @Override
    public void acitivytClose()
    {
        this.finish();

        UIManager.startActivity(this, WelcomeActivity.class);
    }

    private void startCountDown()
    {
        getPresenter().startCountdown();
    }

    @Override
    protected void onStart()
    {
        super.onStart();
    }
}
