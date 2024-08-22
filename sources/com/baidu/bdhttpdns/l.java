package com.baidu.bdhttpdns;

import android.util.Log;

final class l {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f10708a = false;

    static void a(String str, Object... objArr) {
        if (f10708a) {
            Log.v("BDHttpDns", String.format(str, objArr));
        }
    }

    static void a(boolean z) {
        f10708a = z;
    }
}
