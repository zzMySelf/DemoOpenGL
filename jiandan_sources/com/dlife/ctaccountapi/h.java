package com.dlife.ctaccountapi;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

public final class h {
    public static int a(Context context, String str, int i2) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                return b(context).getInt(str, i2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return i2;
    }

    public static long a(Context context, String str, long j) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                return b(context).getLong(str, j);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return j;
    }

    public static String a(Context context) {
        return "ct_account_api_sdk";
    }

    public static String a(Context context, String str, String str2) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                return b(context).getString(str, str2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return str2;
    }

    public static SharedPreferences b(Context context) {
        return context.getSharedPreferences(a(context), 0);
    }

    public static void b(Context context, String str, int i2) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                b(context).edit().putInt(str, i2).commit();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void b(Context context, String str, String str2) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                b(context).edit().putString(str, str2).commit();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean b(Context context, String str, long j) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return b(context).edit().putLong(str, j).commit();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
