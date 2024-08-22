package com.baidu.vr.b;

import android.util.Log;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static int f3857a = Integer.MAX_VALUE;

    public static void a(String str, String str2) {
        String str3 = "BDVRLOG-VRPLAYER-" + str;
        if (f3857a <= 1) {
            Log.d(str3, str2);
        }
    }

    public static void b(String str, String str2) {
        String str3 = "BDVRLOG-VRPLAYER-" + str;
        if (f3857a <= 2) {
            Log.i(str3, str2);
        }
    }

    public static void c(String str, String str2) {
        String str3 = "BDVRLOG-VRPLAYER-" + str;
        if (f3857a <= 4) {
            Log.e(str3, str2);
        }
    }
}
