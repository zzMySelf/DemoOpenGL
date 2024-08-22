package com.baidu.spswitch.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SoftInputSharedPreferences {
    private static final String FILE_NAME = "baidu.softinput.common";
    private static final String KEY_SOFITNPUT_HEIGHT = "sp.key.softinput.height";
    private static volatile SharedPreferences sSp;

    public static boolean save(Context context, int softinputHeight) {
        return with(context).edit().putInt(KEY_SOFITNPUT_HEIGHT, softinputHeight).commit();
    }

    public static int get(Context context, int defaultHeight) {
        return with(context).getInt(KEY_SOFITNPUT_HEIGHT, defaultHeight);
    }

    private static SharedPreferences with(Context context) {
        if (sSp == null) {
            synchronized (SoftInputSharedPreferences.class) {
                if (sSp == null) {
                    sSp = context.getSharedPreferences(FILE_NAME, 0);
                }
            }
        }
        return sSp;
    }
}
