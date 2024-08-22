package com.cmic.sso.sdk.c.c;

import android.net.Network;
import com.cmic.sso.sdk.auth.AuthnHelper;
import com.cmic.sso.sdk.c.b.g;
import java.util.HashMap;
import java.util.Map;
import okhttp3.internal.http2.Http2ExchangeCodec;

public class c {
    public String a;
    public final String b;
    public final Map<String, String> c;
    public final String d;
    public boolean e;
    public final String f;
    public Network g;
    public long h;

    /* renamed from: i  reason: collision with root package name */
    public final String f3776i;
    public int j;
    public final g k;

    public c(String str, Map<String, String> map, g gVar, String str2, String str3) {
        String str4;
        this.e = false;
        this.b = str;
        this.k = gVar;
        this.c = map == null ? new HashMap<>() : map;
        String str5 = "";
        if (gVar == null) {
            str4 = str5;
        } else {
            str4 = gVar.b().toString();
        }
        this.a = str4;
        this.d = str2;
        this.f = str3;
        this.f3776i = gVar != null ? gVar.a() : str5;
        k();
    }

    private void k() {
        this.c.put("sdkVersion", AuthnHelper.SDK_VERSION);
        this.c.put("Content-Type", "application/json");
        this.c.put("CMCC-EncryptType", "STD");
        this.c.put("traceId", this.f);
        this.c.put("appid", this.f3776i);
        this.c.put(Http2ExchangeCodec.CONNECTION, "Keep-Alive");
    }

    public void a(String str, String str2) {
        this.c.put(str, str2);
    }

    public boolean b() {
        return this.e;
    }

    public Map<String, String> c() {
        return this.c;
    }

    public String d() {
        return this.a;
    }

    public String e() {
        return this.d;
    }

    public String f() {
        return this.f;
    }

    public Network g() {
        return this.g;
    }

    public long h() {
        return this.h;
    }

    public boolean i() {
        int i2 = this.j;
        this.j = i2 + 1;
        return i2 < 2;
    }

    public g j() {
        return this.k;
    }

    public String a() {
        return this.b;
    }

    public void a(boolean z) {
        this.e = z;
    }

    public void a(Network network) {
        this.g = network;
    }

    public void a(long j2) {
        this.h = j2;
    }

    public c(String str, g gVar, String str2, String str3) {
        this(str, (Map<String, String>) null, gVar, str2, str3);
    }
}
