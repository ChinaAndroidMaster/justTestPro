/**
 * Copyright © 2013 CreditEase. All rights reserved.
 */
package com.ckx.checkcar.base.edutils;

import android.annotation.SuppressLint;
import android.util.Base64;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;

/**
 * @author noah.zheng
 */
public class Des3Util
{
    // 加解密统一使用的编码方式
    private final static String encoding = "utf-8";

    // 向量
    private static String IV = "01234567";

    //des key
    private static String DESKEY = "";

    public static void setIV(String aIV)
    {
        IV = aIV;
    }

    public static void setDESKEY(String aDESKEY)
    {
       DESKEY = aDESKEY;
    }

    /**
     * 3DES解密
     *
     * @param encryptText 加密文本
     * @return
     * @throws Exception
     */
    public static String decode(String encryptText) throws Exception
    {
        // encryptText = encryptText.replaceAll( "%2B","+");
        Key deskey = null;
        DESedeKeySpec spec = new DESedeKeySpec(DESKEY.getBytes());
        SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("desede");
        deskey = keyfactory.generateSecret(spec);
        Cipher cipher = Cipher.getInstance("desede/CBC/PKCS5Padding");
        IvParameterSpec ips = new IvParameterSpec(IV.getBytes());
        cipher.init(Cipher.DECRYPT_MODE, deskey, ips);

        byte[] decryptData = cipher.doFinal(Base64Util.decode(encryptText, Base64.DEFAULT));

        String string = new String(decryptData, encoding);
        return string;
    }

    /**
     * 3DES加密
     *
     * @param plainText 普通文本
     * @return
     * @throws Exception
     */
    @SuppressLint( "TrulyRandom" )
    public static String encode(String plainText) throws Exception
    {
        Key deskey = null;
        DESedeKeySpec spec = new DESedeKeySpec(DESKEY.getBytes());
        SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("desede");
        deskey = keyfactory.generateSecret(spec);

        Cipher cipher = Cipher.getInstance("desede/CBC/PKCS5Padding");
        IvParameterSpec ips = new IvParameterSpec(IV.getBytes());
        cipher.init(Cipher.ENCRYPT_MODE, deskey, ips);
        byte[] encryptData = cipher.doFinal(plainText.getBytes(encoding));
        String encode = Base64Util.encodeToString(encryptData, Base64.DEFAULT);
        // encode = encode.replaceAll("+", "%2B");
        return encode;
    }

    public static void main(String[] args)
    {
        String text = "对不起您的输入有误，请修正后重新尝试。哇咔咔9498427472**……%&……%……￥%";
        try
        {
            String result1 = Des3Util.encode(text);
            String result2 = Des3Util.decode(result1);
            System.out.println("DES encrypt text is " + result1);
            System.out.println("DES decrypt text is " + result2);
        } catch ( Exception e )
        {
            e.printStackTrace();
        }
    }
}
