package com.ckx.checkcar.base.edutils;

/**
 * Created by lihui on 16/6/21.
 */
public class EncryptDecryptNull implements BaseEncryptDecrypt
{
    @Override
    public String encrypt(String aSrc)
    {
        return aSrc;
    }

    @Override
    public String decrypt(String aSrc)
    {
        return aSrc;
    }
}
