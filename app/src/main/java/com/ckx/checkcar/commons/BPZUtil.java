package com.ckx.checkcar.commons;

import android.content.Context;
import android.content.res.Resources;

import com.ckx.checkcar.R;
import com.ckx.checkcar.model.BPZItemBean;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by lihui on 16/7/11.
 */
public class BPZUtil
{
    private static BPZUtil ourInstance = new BPZUtil();

    public static BPZUtil getInstance()
    {
        return ourInstance;
    }

    private List<BPZItemBean> mBPZItemBeanList = new LinkedList<BPZItemBean>();
    private BPZUtil()
    {
    }

    public void init(Context aContext)
    {
        if (mBPZItemBeanList.size() == 0)
        {
            Resources res = aContext.getResources();
            String[] btzstr = res.getStringArray(R.array.bpzstr);

            int count = btzstr.length;
            for (int i = 0; i < count; i++)
            {
                String itemStr = btzstr[i];
                String [] items = itemStr.split(",");

                mBPZItemBeanList.add(new BPZItemBean(items[1].trim(), items[2].trim(), Boolean.valueOf(items[0].trim())));
            }
        }
    }

    public List<BPZItemBean> getBPZItems()
    {
        return mBPZItemBeanList;
    }
}
