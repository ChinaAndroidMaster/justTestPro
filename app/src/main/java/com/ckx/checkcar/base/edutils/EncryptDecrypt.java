package com.ckx.checkcar.base.edutils;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by lihui on 16/6/21.
 */
public class EncryptDecrypt
{
    private static EncryptDecrypt ourInstance = new EncryptDecrypt();

    public static EncryptDecrypt getInstance()
    {
        return ourInstance;
    }

    private BaseEncryptDecrypt mBaseEncryptDecrypt = new EncryptDecryptNull();

    private EncryptDecrypt()
    {
    }

    public void init(BaseEncryptDecrypt aBaseEncryptDecrypt)
    {
        mBaseEncryptDecrypt = aBaseEncryptDecrypt;
    }

    /**
     * 加密算法
     * @param aSrc
     * @return
     */
    public @Nullable String encrypt(@NonNull String aSrc)
    {
        if (null != mBaseEncryptDecrypt)
        {
            return mBaseEncryptDecrypt.encrypt(aSrc);
        }

        return null;
    }

    /**
     * 解密算法
     * @param aSrc
     * @return
     */
    public @Nullable String decrypt(@NonNull String aSrc)
    {
        if (null != mBaseEncryptDecrypt)
        {
            return mBaseEncryptDecrypt.decrypt(aSrc);
        }

        return null;
    }
}
