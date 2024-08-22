package com.sdk.v;

import android.content.Context;
import com.sdk.f.f;

public class a {
    public static a a;
    public static String b;
    public static String c;
    public static int d;
    public static String e;

    static {
        boolean z = f.a;
    }

    public a(Context context) {
    }

    public static a a(Context context) {
        if (a == null) {
            synchronized (a.class) {
                a = new a(context);
            }
        }
        return a;
    }

    public void a(String str, String str2) {
        b = str2;
        c = str;
        d = 0;
        e = "B";
    }
}
