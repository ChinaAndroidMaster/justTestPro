package com.ckx.checkcar.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ckx.checkcar.R;
import com.ckx.checkcar.bean.HomeBean;

import java.util.ArrayList;

/**
 * Created by 201607040319 on 2016/7/7.
 */
public class HomeAdapter extends BaseAdapter
{
    private final Context mContext;
    ArrayList<HomeBean> list = new ArrayList<>();
    boolean isCheck = false;

    public HomeAdapter(Context aContext){
        mContext = aContext;
        for (int i = 0; i < 4; i++)
        {
            HomeBean tHomeBean = new HomeBean(R.mipmap.default_carimg,"雪铁龙-世嘉" + i,"2016/05/31","2013版" + i,"待审核" + i,"车商名称：" + i,"119" + i,"??" + i,R.mipmap.check_icon,!isCheck);
            list.add(tHomeBean);
        }
    }

    @Override
    public int getCount()
    {
        return list.size();
    }

    @Override
    public HomeBean getItem(int position)
    {
        return list.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        ViewHolder viewHolder;
        if(convertView == null){
            convertView = View.inflate(mContext, R.layout.home_list_item, null);
            viewHolder = new ViewHolder();
            viewHolder.ivCar = (ImageView) convertView.findViewById(R.id.home_iv_car);
            viewHolder.tvCarName = (TextView) convertView.findViewById(R.id.home_tv_carName);
            viewHolder.tvDate = (TextView) convertView.findViewById(R.id.home_tv_date);
            viewHolder.tvVersion = (TextView) convertView.findViewById(R.id.home_tv_version);
            viewHolder.tvState = (TextView) convertView.findViewById(R.id.home_tv_state);
            viewHolder.tvCarSaleName = (TextView) convertView.findViewById(R.id.home_tv_carSaleName);
            viewHolder.tvTel = (TextView) convertView.findViewById(R.id.home_tv_tel);
            viewHolder.ivState = (ImageView) convertView.findViewById(R.id.home_iv_state);
            viewHolder.tvIvState = (TextView) convertView.findViewById(R.id.home_tv_ivState);
            convertView.setTag(viewHolder);
        }else
            viewHolder = (ViewHolder) convertView.getTag();
        HomeBean item = getItem(position);
       /* 给View设置TAG
        viewHolder.tvTitle.setTag(item.id+"");

        //String readIds = SharedPrefUtil.getString(mActivity, Constants.KEY_READ_ID, "");

        if(readIds.contains(String.valueOf(item.id))){
            viewHolder.tvTitle.setTextColor(Color.GRAY);
        }else {
            viewHolder.tvTitle.setTextColor(Color.BLACK);
        }*/
        viewHolder.tvCarName.setText(item.getCarName());
        viewHolder.tvDate.setText(item.getDate());
        viewHolder.tvVersion.setText(item.getVersion());
        viewHolder.tvState.setText(item.getState());
        viewHolder.tvCarSaleName.setText(item.getCarSaleName());
        viewHolder.tvTel.setText(item.getTel());
        viewHolder.tvIvState.setText(item.getIvState());
        viewHolder.ivCar.setImageResource(item.getCarIconId());
        viewHolder.ivState.setImageResource(item.getStateIconId());
        return convertView;
    }

    static class ViewHolder {
        ImageView ivCar;
        TextView tvCarName;
        TextView tvDate;
        TextView tvVersion;
        TextView tvState;
        TextView tvCarSaleName;
        TextView tvTel;
        ImageView ivState;
        TextView tvIvState;
    }
}

