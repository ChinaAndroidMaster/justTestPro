package com.ckx.checkcar.base.edutils;

import android.support.annotation.NonNull;
import android.util.Base64;

/**
 * Created by lihui on 16/6/21.
 */
public class Base64Util
{
    /**
     *
     * @param aSrc
     * @param aFlag
     * @return
     */
    public static String encodeToString(@NonNull String aSrc, int aFlag)
    {
        return Base64.encodeToString(aSrc.getBytes(), aFlag);
    }

    /**
     *
     * @param aSrc
     * @param aFlag
     * @return
     */
    public static String encodeToString(byte[] aSrc, int aFlag)
    {
        return Base64.encodeToString(aSrc, aFlag);
    }

    /**
     *
     * @param aSrc
     * @param aFlag
     * @return
     */
    public static byte[] encode(byte[] aSrc, int aFlag)
    {
        return Base64.encode(aSrc, aFlag);
    }

    /**
     *
     * @param aSrc
     * @param aFlag
     * @return
     */
    public static byte[] encode(String aSrc, int aFlag)
    {
        return Base64.encode(aSrc.getBytes(), aFlag);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    //decode
    /**
     *
     * @param aSrc
     * @param aFlag
     * @return
     */
    public static String decodeToString(@NonNull String aSrc, int aFlag)
    {
        return new String(Base64.decode(aSrc, aFlag));
    }

    /**
     *
     * @param aSrc
     * @param aFlag
     * @return
     */
    public static String decodeToString(byte[] aSrc, int aFlag)
    {
        return new String(Base64.decode(aSrc, aFlag));
    }

    /**
     *
     * @param aSrc
     * @param aFlag
     * @return
     */
    public static byte[] decode(byte[] aSrc, int aFlag)
    {
        return Base64.decode(aSrc, aFlag);
    }

    /**
     *
     * @param aSrc
     * @param aFlag
     * @return
     */
    public static byte[] decode(String aSrc, int aFlag)
    {
        return Base64.decode(aSrc, aFlag);
    }
}
