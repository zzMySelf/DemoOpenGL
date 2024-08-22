package com.baidu.apollon.heartbeat;

import android.content.Context;
import android.content.SharedPreferences;

public final class c {
    public static final String a = c.class.getClass().getSimpleName();
    public static final String b = "last_cfg_request_time";
    public static final String c = "heartbeat_cfg_fingerprint";
    public static final int d = 300;
    public static final String e = "HeartBeatSP";
    public static SharedPreferences f;
    public static SharedPreferences.Editor g;

    public static void a(Context context) {
        if (f == null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences(e, 0);
            f = sharedPreferences;
            g = sharedPreferences.edit();
        }
    }

    public static long b(Context context, String str, long j) {
        a(context);
        return f.getLong(str, j);
    }

    public static String b(Context context, String str, String str2) {
        a(context);
        return f.getString(str, str2);
    }

    public static void a(Context context, String str, long j) {
        a(context);
        g.putLong(str, j);
        g.commit();
    }

    public static void a(Context context, String str, String str2) {
        a(context);
        g.putString(str, str2);
        g.commit();
    }

    public static void a(Context context, String str) {
        a(context);
        g.remove(str);
        g.commit();
    }
}
