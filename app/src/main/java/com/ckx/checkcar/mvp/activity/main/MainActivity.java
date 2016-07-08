package com.ckx.checkcar.mvp.activity.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Toast;

import com.ckx.checkcar.R;
import com.ckx.checkcar.base.ui.activity.BaseActivity;
import com.ckx.checkcar.mvp.fragment.HomeFragment;
import com.ckx.checkcar.mvp.fragment.PersonFragment;
import com.ckx.checkcar.mvp.presenter.MainPresenter;
import com.ckx.checkcar.mvp.view.MainView;
import com.startsmake.mainnavigatetabbar.widget.MainNavigateTabBar;

import butterknife.BindView;

/**
 * Created by lihui on 16/7/8.
 */
public class MainActivity extends BaseActivity<MainView, MainPresenter> implements MainView
{
    @BindView(R.id.mainTabBar)
    MainNavigateTabBar mMainTabBar;

    @Override
    public int layoutResID()
    {
        return R.layout.activity_main;
    }

    @Override
    public void initViews()
    {
        mMainTabBar.addTab(HomeFragment.class, new MainNavigateTabBar.TabParam(R.mipmap.comui_tab_home, R.mipmap.comui_tab_home_selected, getString(R.string.tabbar_home)));
        mMainTabBar.addTab(null, new MainNavigateTabBar.TabParam(0, 0, getString(R.string.tabbar_publish)));
        mMainTabBar.addTab(PersonFragment.class, new MainNavigateTabBar.TabParam(R.mipmap.comui_tab_person, R.mipmap.comui_tab_person_selected, getString(R.string.tabbar_my)));
    }

    @Override
    public void initEvents()
    {

    }

    @NonNull
    @Override
    public MainPresenter createPresenter()
    {
        return new MainPresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        mMainTabBar.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);
        mMainTabBar.onSaveInstanceState(outState);
    }

    public void onClickPublish(View v)
    {
        Toast.makeText(this, "预检", Toast.LENGTH_LONG).show();
    }
}
