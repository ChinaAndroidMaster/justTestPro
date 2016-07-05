package com.ckx.checkcar.mvp.presenter;

import com.badoo.mobile.util.WeakHandler;
import com.ckx.checkcar.base.presenter.BaseBPresenter;
import com.ckx.checkcar.mvp.view.SplashView;

import org.xutils.common.Callback;

/**
 * Created by lihui on 16/6/17.
 */
public class SplashPresenter extends BaseBPresenter<SplashView>
{
    private static final int AUTO_HIDE_DELAY_MILLIS = 3000;

    private WeakHandler mHandler = null;

    private Callback.Cancelable mCancelable = null;

    private final Runnable mRunnable = new Runnable()
    {
        @Override
        public void run()
        {
            getView().acitivytClose();

            mHandler = null;
        }
    };

    public void startCountdown()
    {
        if (null == mHandler)
        {
            mHandler = new WeakHandler();
            mHandler.postDelayed(mRunnable, AUTO_HIDE_DELAY_MILLIS);
        }
    }

    @Override
    public void detachView(boolean retainInstance)
    {
        super.detachView(retainInstance);

        if (null != mHandler)
        {
            mHandler.removeCallbacks(mRunnable);
        }

        if (null != mCancelable)
        {
            mCancelable.cancel();
        }
    }
}
