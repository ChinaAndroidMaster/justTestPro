package com.ckx.checkcar.mvp.activity.home;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.ckx.checkcar.R;
import com.ckx.checkcar.wigdet.ClearEditText;

/**
 * Created by 201607040319 on 2016/7/8.
 */
public class HomeFragment extends Fragment
{
    protected Activity mActivity = getActivity();
    private ClearEditText mClearEditText;
    private ListView mListView;
    private LinearLayout mLlPendingAudit;
    private LinearLayout mLlOnSale;
    private LinearLayout mLlSort;

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return initView();
    }

    private  View initView(){
        View view = View.inflate(mActivity, R.layout.activity_home, null);
        mClearEditText = (ClearEditText) view.findViewById(R.id.home_clearEditText);
        mListView = (ListView) view.findViewById(R.id.home_listView);
        mLlPendingAudit = (LinearLayout) view.findViewById(R.id.home_ll_pendingAudit);
        mLlOnSale = (LinearLayout) view.findViewById(R.id.home_ll_onSale);
        mLlSort = (LinearLayout) view.findViewById(R.id.home_ll_sort);
        return view;
    }

    @Override
    public void onActivityCreated( Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //Activity创建时填充数据
        initData();
    }

    //需要填充数据的子Fragment就重写此方法
    protected  void initData() {

    }
}
