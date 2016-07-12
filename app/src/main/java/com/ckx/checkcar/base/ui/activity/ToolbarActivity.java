package com.ckx.checkcar.base.ui.activity;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.widget.TextView;

import com.ckx.checkcar.R;
import com.ckx.checkcar.base.utils.UmengHelper;
import com.hannesdorfmann.mosby.mvp.MvpActivity;
import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.hannesdorfmann.mosby.mvp.MvpView;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lihui on 16/6/17.
 */
public abstract class ToolbarActivity<V extends MvpView, P extends MvpPresenter<V>> extends BaseActivity<V,P>
{
    @BindView(R.id.tool_bar)
    Toolbar mToolbar;
    @BindView(R.id.toolbar_title)
    TextView mTvToolbarTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setToolbar();
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

    public abstract String getToolbarTitle();

    private void setToolbar()
    {
        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);

        String toolbarTitle = getToolbarTitle();
        if (!TextUtils.isEmpty(toolbarTitle))
        {
            mTvToolbarTitle.setText(toolbarTitle);
        }
    }
}
