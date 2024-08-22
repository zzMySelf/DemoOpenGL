package com.baidu.platform.comapi.walknavi.d.a.d;

import android.content.Context;
import android.content.SharedPreferences;

/* compiled from: SoLoadPrefs */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private final Context f16344a;

    public g(Context context) {
        this.f16344a = context;
    }

    private SharedPreferences c() {
        return this.f16344a.getSharedPreferences("ar_so_info", 0);
    }

    public void a(String str) {
        c().edit().putString("ar_sdk_version", str).commit();
    }

    public String b() {
        return c().getString("so_version", "");
    }

    public String a() {
        return c().getString("ar_sdk_version", "");
    }

    public void b(String str) {
        c().edit().putString("so_version", str).commit();
    }
}
