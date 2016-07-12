package com.ckx.checkcar.model;

/**
 * Created by lihui on 16/7/11.
 */
public class BPZItemBean
{
    private String     mImgType;     //必拍照类型
    private String  mImgTypeName; //对应名称
    private boolean mRequired;    //是否必须拍照

    public BPZItemBean(String aImgType, String aImgTypeName, boolean aRequired)
    {
        mImgType     = aImgType;
        mImgTypeName = aImgTypeName;
        mRequired    = aRequired;
    }
}
