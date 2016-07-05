package com.ckx.checkcar.base.edutils;

/**
 * Created by lihui on 16/6/21.
 */
public class EncryptDecryptDes3 implements BaseEncryptDecrypt
{
    @Override
    public String encrypt(String aSrc)
    {
        try
        {
            return Des3Util.encode(aSrc);
        } catch (Exception aE)
        {
            aE.printStackTrace();
        }
        return null;
    }

    @Override
    public String decrypt(String aSrc)
    {
        try
        {
            return Des3Util.encode(aSrc);
        } catch (Exception aE)
        {
            aE.printStackTrace();
        }
        return null;
    }
}
