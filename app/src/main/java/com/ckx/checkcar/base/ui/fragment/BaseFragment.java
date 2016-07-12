package com.ckx.checkcar.base.ui.fragment;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ckx.checkcar.base.utils.UmengHelper;
import com.github.johnpersano.supertoasts.SuperActivityToast;
import com.github.johnpersano.supertoasts.SuperToast;
import com.hannesdorfmann.mosby.mvp.MvpFragment;
import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.hannesdorfmann.mosby.mvp.MvpView;

import butterknife.ButterKnife;

/**
 * Created by lihui on 16/6/17.
 */
public abstract class BaseFragment<V extends MvpView, P extends MvpPresenter<V>> extends MvpFragment<V, P>
{
    protected View mRootView;

    private boolean mIsXmlLayout = true;

    public abstract @LayoutRes int layoutResID();

    public abstract void initViews();
    public abstract void initEvents();

    public boolean isXmlLayout()
    {
        return mIsXmlLayout;
    }

    @Override
    public void onResume()
    {
        super.onResume();
        UmengHelper.onResume(this.getContext());
        UmengHelper.onPageStart(this.getClass().getSimpleName());
    }

    @Override
    public void onPause()
    {
        super.onPause();
        UmengHelper.onPause(this.getContext());
        UmengHelper.onPageEnd(this.getClass().getSimpleName());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {

        if (isXmlLayout())
        {
            if (null == mRootView)
            {
                mRootView = inflater.inflate(layoutResID(), container, false);
                ButterKnife.bind(this,mRootView);//绑定framgent
            }
        }

        initViews();
        initEvents();

        return mRootView;
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
        final SuperToast superToast = new SuperToast(getActivity());
        superToast.setDuration(aDurationInteger);
        superToast.show();
    }
}
