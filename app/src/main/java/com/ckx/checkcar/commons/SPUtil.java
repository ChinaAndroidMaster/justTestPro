package com.ckx.checkcar.commons;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by lihui on 16/6/18.
 */
public final class SPUtil
{
    private static SharedPreferences gSP;
    private static SharedPreferences.Editor gEditor;

    private static final String preferencesName = "config";
    private static final String LENGTH = "_length";

    private static final String DEFAULT_STRING_VALUE = "";
    private static final int DEFAULT_INT_VALUE = -1;
    private static final double DEFAULT_DOUBLE_VALUE = -1d;
    private static final float DEFAULT_FLOAT_VALUE = -1f;
    private static final long DEFAULT_LONG_VALUE = -1L;
    private static final boolean DEFAULT_BOOLEAN_VALUE = false;

    public static void init(@NonNull Context aContext)
    {
        gSP     = aContext.getSharedPreferences(preferencesName, Context.MODE_PRIVATE);
        gEditor = gSP.edit();
    }

    /**
     * @param aKey
     * @return Returns the stored value of aKey
     */
    public static String read(String aKey)
    {
        return gSP.getString(aKey, DEFAULT_STRING_VALUE);
    }

    /**
     * @param aKey
     * @param aDefaultString
     * @return Returns the stored value of 'what'
     */
    public String read(@NonNull String aKey, @Nullable String aDefaultString)
    {
        return gSP.getString(aKey, aDefaultString);
    }

    /**
     * @param aKey
     * @param aValue
     */
    public static void write(@NonNull String aKey, @Nullable String aValue)
    {
        gSP.edit().putString(aKey, aValue).apply();
    }

    // int related methods

    /**
     * @param aKey
     * @return Returns the stored value of 'aKey'
     */
    public static int readInt(@NonNull String aKey)
    {
        return gSP.getInt(aKey, DEFAULT_INT_VALUE);
    }

    /**
     * @param aKey
     * @param aDefaultInt
     * @return Returns the stored value of 'what'
     */
    public static int readInt(String aKey, int aDefaultInt)
    {
        return gSP.getInt(aKey, aDefaultInt);
    }

    /**
     * @param aKey
     * @param aValue
     */
    public static void writeInt(@NonNull String aKey, int aValue)
    {
        gSP.edit().putInt(aKey, aValue).apply();
    }

    /**
     * @param aKey
     * @return Returns the stored value of 'aKey'
     */
    public static double readDouble(String aKey)
    {
        if (!contains(aKey))
            return DEFAULT_DOUBLE_VALUE;
        return Double.longBitsToDouble(readLong(aKey));
    }

    /**
     * @param aKey
     * @param defaultDouble
     * @return Returns the stored value of 'aKey'
     */
    public static double readDouble(String aKey, double defaultDouble)
    {
        if (!contains(aKey))
            return defaultDouble;
        return Double.longBitsToDouble(readLong(aKey));
    }

    /**
     * @param aKey
     * @param aValue
     */
    public static void writeDouble(String aKey, double aValue)
    {
        writeLong(aKey, Double.doubleToRawLongBits(aValue));
    }

    // float related methods

    /**
     * @param aKey
     * @return Returns the stored value of 'aKey'
     */
    public static float readFloat(String aKey)
    {
        return gSP.getFloat(aKey, DEFAULT_FLOAT_VALUE);
    }

    /**
     * @param aKey
     * @param aDefaultFloat
     * @return Returns the stored value of 'what'
     */
    public static float readFloat(String aKey, float aDefaultFloat)
    {
        return gSP.getFloat(aKey, aDefaultFloat);
    }

    /**
     * @param aKey
     * @param aValue
     */
    public static void writeFloat(String aKey, float aValue)
    {
        gSP.edit().putFloat(aKey, aValue).apply();
    }

    // long related methods

    /**
     * @param aKey
     * @return Returns the stored value of 'what'
     */
    public static long readLong(String aKey)
    {
        return gSP.getLong(aKey, DEFAULT_LONG_VALUE);
    }

    /**
     * @param aKey
     * @param aDefaultLong
     * @return Returns the stored value of 'aKey'
     */
    public static long readLong(String aKey, long aDefaultLong)
    {
        return gSP.getLong(aKey, aDefaultLong);
    }

    /**
     * @param aKey
     * @param aValue
     */
    public static void writeLong(String aKey, long aValue)
    {
        gSP.edit().putLong(aKey, aValue).apply();
    }

    // boolean related methods

    /**
     * @param aKey
     * @return Returns the stored value of 'aKey'
     */
    public static boolean readBoolean(String aKey)
    {
        return gSP.getBoolean(aKey, DEFAULT_BOOLEAN_VALUE);
    }

    /**
     * @param aKey
     * @param aDefaultBoolean
     * @return Returns the stored value of 'what'
     */
    public static boolean readBoolean(String aKey, boolean aDefaultBoolean)
    {
        return gSP.getBoolean(aKey, aDefaultBoolean);
    }

    /**
     * @param aKey
     * @param aValue
     */
    public static void writeBoolean(String aKey, boolean aValue)
    {
        gSP.edit().putBoolean(aKey, aValue).apply();
    }

    // String set methods

    /**
     * @param aKey
     * @param aValue
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static void putStringSet(final String aKey, final Set<String> aValue)
    {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB)
        {
            gSP.edit().putStringSet(aKey, aValue).apply();
        }
        else
        {
            // Workaround for pre-HC's lack of StringSets
            putOrderedStringSet(aKey, aValue);
        }
    }

    /**
     * @param aKey
     * @param aValue
     */
    public static void putOrderedStringSet(String aKey, Set<String> aValue)
    {
        int stringSetLength = 0;
        if (gSP.contains(aKey + LENGTH))
        {
            // First read what the value was
            stringSetLength = readInt(aKey + LENGTH);
        }
        writeInt(aKey + LENGTH, aValue.size());
        int i = 0;
        for (String value : aValue)
        {
            write(aKey + "[" + i + "]", value);
            i++;
        }
        for (; i < stringSetLength; i++)
        {
            // Remove any remaining values
            remove(aKey + "[" + i + "]");
        }
    }

    /**
     * @param aKey
     * @param aDefValue
     * @return Returns the String Set with HoneyComb compatibility
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static Set<String> getStringSet(final String aKey, final Set<String> aDefValue)
    {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB)
        {
            return gSP.getStringSet(aKey, aDefValue);
        }
        else
        {
            // Workaround for pre-HC's missing getStringSet
            return getOrderedStringSet(aKey, aDefValue);
        }
    }

    /**
     * @param aKey
     * @param aDefValue
     * @return Returns the ordered String Set
     */
    public static Set<String> getOrderedStringSet(String aKey, final Set<String> aDefValue)
    {
        if (contains(aKey + LENGTH))
        {
            LinkedHashSet<String> set = new LinkedHashSet<>();
            int stringSetLength = readInt(aKey + LENGTH);
            if (stringSetLength >= 0)
            {
                for (int i = 0; i < stringSetLength; i++)
                {
                    set.add(read(aKey + "[" + i + "]"));
                }
            }
            return set;
        }
        return aDefValue;
    }

    // end related methods

    /**
     * @param aKey
     */
    public static void remove(final String aKey)
    {
        if (contains(aKey + LENGTH))
        {
            // Workaround for pre-HC's lack of StringSets
            int stringSetLength = readInt(aKey + LENGTH);
            if (stringSetLength >= 0)
            {
                gSP.edit().remove(aKey + LENGTH).apply();
                for (int i = 0; i < stringSetLength; i++)
                {
                    gSP.edit().remove(aKey + "[" + i + "]").apply();
                }
            }
        }
        gSP.edit().remove(aKey);
    }

    /**
     * @param aKey
     * @return Returns if that key exists
     */
    public static boolean contains(final String aKey)
    {
        return gSP.contains(aKey);
    }

    /**
     * Clear all the preferences
     */
    public static void clear()
    {
        gSP.edit().clear().apply();
    }
}
