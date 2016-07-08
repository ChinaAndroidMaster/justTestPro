package com.ckx.checkcar.base.utils;

/**
 * Created by lihui on 16/7/7.
 */
import com.github.yoojia.inputs.EmptyableVerifier;

import static com.github.yoojia.inputs.Texts.regexMatch;

/**
 * 中国11位手机号校验器
 * @author Yoojia Chen (yoojiachen@gmail.com)
 * @since 1.1
 */
public class MobileVerifier extends EmptyableVerifier
{
    @Override
    public boolean performTestNotEmpty(String notEmptyInput) throws Exception
    {
        return regexMatch(notEmptyInput, "(\\+\\d+)?1[3458]\\d{9}$");
    }
}