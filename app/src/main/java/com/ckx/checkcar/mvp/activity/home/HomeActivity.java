package com.ckx.checkcar.mvp.activity.home;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.ckx.checkcar.R;
import com.ckx.checkcar.adapter.HomeAdapter;
import com.ckx.checkcar.base.ui.activity.BaseActivity;
import com.ckx.checkcar.commons.ToastUtil;
import com.ckx.checkcar.mvp.presenter.HomePresenter;
import com.ckx.checkcar.mvp.view.HomeView;
import com.ckx.checkcar.wigdet.ClearEditText;

public class HomeActivity extends BaseActivity<HomeView, HomePresenter> implements View.OnClickListener, AdapterView.OnItemClickListener
{


    private ClearEditText mClearEditText;
    private ListView mListView;
    private LinearLayout mLlPendingAudit;
    private LinearLayout mLlOnSale;
    private LinearLayout mLlSort;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int layoutResID()
    {
        return R.layout.activity_home;
    }

    @Override
    public void initViews()
    {
        mClearEditText = (ClearEditText) findViewById(R.id.home_clearEditText);
        mListView = (ListView) findViewById(R.id.home_listView);
        mLlPendingAudit = (LinearLayout) findViewById(R.id.home_ll_pendingAudit);
        mLlOnSale = (LinearLayout) findViewById(R.id.home_ll_onSale);
        mLlSort = (LinearLayout) findViewById(R.id.home_ll_sort);
        mListView.setAdapter(new HomeAdapter(getApplicationContext()));
    }

    @Override

    public void initEvents()
    {
        mLlPendingAudit.setOnClickListener(this);
        mLlOnSale.setOnClickListener(this);
        mLlSort.setOnClickListener(this);
        mListView.setOnItemClickListener(this);
    }

    @NonNull
    @Override
    public HomePresenter createPresenter()
    {
        return new HomePresenter();
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId()){
            case R.id.home_ll_pendingAudit:
                ToastUtil.showShort(getApplicationContext(),"待审核");break;
            case R.id.home_ll_onSale:
                ToastUtil.showShort(getApplicationContext(),"在售");break;
            case R.id.home_ll_sort:
                ToastUtil.showShort(getApplicationContext(),"排序");break;
        }
    }



    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
    {
        ToastUtil.showShort(getApplicationContext(),"点击的是" + position);
    }
}
