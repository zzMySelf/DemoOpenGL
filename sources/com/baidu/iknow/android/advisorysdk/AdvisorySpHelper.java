package com.baidu.iknow.android.advisorysdk;

import android.content.Context;
import android.content.SharedPreferences;

public class AdvisorySpHelper {
    private static SharedPreferences sharedPreferences;

    public static String getString(Context ctx, String key) {
        return getSp(ctx).getString(key, "");
    }

    public static void putString(Context ctx, String key, String value) {
        getSp(ctx).edit().putString(key, value).apply();
    }

    private static SharedPreferences getSp(Context ctx) {
        if (sharedPreferences == null) {
            sharedPreferences = ctx.getSharedPreferences("box_advisory_sp", 0);
        }
        return sharedPreferences;
    }
}
