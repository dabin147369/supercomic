package com.iis.supercomic.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by joyworks on 2015/12/27.
 */
public class SharedPrefUtil {
    private static SharedPreferences sp;

    public static void putBoolean(Context context, String key, boolean defaultValue) {
        getSharedPreferences(context).edit().putBoolean(key, defaultValue).commit();
    }

    public static boolean getBoolean(Context context, String key, boolean defaultValue) {
        return getSharedPreferences(context).getBoolean(key, defaultValue);
    }

    public static void putString(Context context, String key, String defaultValue) {
        getSharedPreferences(context).edit().putString(key, defaultValue).commit();
    }

    public static String getString(Context context, String key, String defaultValue) {
        return getSharedPreferences(context).getString(key, defaultValue);
    }

    public static void putLong(Context context, String key, Long defaultValue) {
        getSharedPreferences(context).edit().putLong(key, defaultValue).commit();
    }

    public static Long getLong(Context context, String key, Long defaultValue) {
        return getSharedPreferences(context).getLong(key, defaultValue);
    }

    public static void putInt(Context context, String key, int defaultValue) {
        getSharedPreferences(context).edit().putInt(key, defaultValue).commit();
    }

    public static int getInt(Context context, String key, int defaultValue) {
        return getSharedPreferences(context).getInt(key, defaultValue);
    }



    private static SharedPreferences getSharedPreferences(Context context) {
        if (sp == null) {
            sp = context.getSharedPreferences("config", Context.MODE_PRIVATE);
        }
        return sp;
    }

}
