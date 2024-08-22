package com.sdk.k;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import com.sdk.f.f;

@SuppressLint({"ApplySharedPref"})
public class a {
    public static final String a = "com.sdk.k.a";
    public static final Boolean b = Boolean.valueOf(f.a);

    public static void a(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("ZzxCache", 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        for (String next : sharedPreferences.getAll().keySet()) {
            if (next.startsWith(str)) {
                edit.remove(next);
            }
        }
        edit.commit();
    }

    public static void a(Context context, String str, Long l) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences("ZzxCache", 0).edit();
            edit.putLong(str, l.longValue());
            edit.commit();
        } catch (Exception e) {
            com.sdk.o.a.a(a, e.getMessage(), b);
        }
    }

    public static boolean a(Context context, String str, String str2) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences("ZzxCache", 0).edit();
            edit.putString(str, str2);
            return edit.commit();
        } catch (Exception e) {
            com.sdk.o.a.a(a, e.getMessage(), b);
            return false;
        }
    }

    public static Long b(Context context, String str) {
        long j = 0;
        try {
            j = context.getSharedPreferences("ZzxCache", 0).getLong(str, 0);
        } catch (Exception e) {
            com.sdk.o.a.a(a, e.getMessage(), b);
        }
        return Long.valueOf(j);
    }

    public static String c(Context context, String str) {
        try {
            return context.getSharedPreferences("ZzxCache", 0).getString(str, "");
        } catch (Exception e) {
            com.sdk.o.a.a(a, e.getMessage(), b);
            return "";
        }
    }
}
