package com.ckx.checkcar.base.utils;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by lihui on 16/7/7.
 */
public class WidgetUtil
{
    /**
     * 获取单行编辑框 内容
     * @param aEditText
     * @return null or real content
     */
    public static @Nullable  String getEditTextContent(@NonNull EditText aEditText)
    {
        if (null == aEditText)
        {
            return null;
        }

        return aEditText.getText().toString();
    }

    /**
     * 获取 textView 内容
     * @param aTextView
     * @return null or real content
     */
    public static @NonNull String getTextViewContent(@NonNull TextView aTextView)
    {
        if (null == aTextView)
        {
            return null;
        }

        return aTextView.getText().toString();
    }
}
