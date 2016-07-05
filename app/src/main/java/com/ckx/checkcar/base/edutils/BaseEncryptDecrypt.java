package com.ckx.checkcar.base.edutils;

import android.support.annotation.Nullable;

/**
 * Created by lihui on 16/6/21.
 */
public interface BaseEncryptDecrypt
{
    /**
     * 加密算法
     * @param aSrc
     * @return
     */
    public @Nullable String encrypt(String aSrc);

    /**
     * 解密算法
     * @param aSrc
     * @return
     */
    public @Nullable String decrypt(String aSrc);
}
