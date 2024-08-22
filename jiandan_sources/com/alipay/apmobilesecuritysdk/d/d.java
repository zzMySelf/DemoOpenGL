package com.alipay.apmobilesecuritysdk.d;

import android.content.Context;
import com.alipay.apmobilesecuritysdk.c.b;
import com.alipay.apmobilesecuritysdk.face.APSecuritySdk;
import com.alipay.sdk.m.a0.e;
import com.alipay.sdk.m.a0.f;
import java.util.HashMap;
import java.util.Map;

public final class d {
    public static synchronized Map<String, String> a() {
        HashMap hashMap;
        synchronized (d.class) {
            hashMap = new HashMap();
            try {
                new b();
                hashMap.put("AE16", "");
            } catch (Throwable unused) {
            }
        }
        return hashMap;
    }

    public static synchronized Map<String, String> a(Context context) {
        HashMap hashMap;
        synchronized (d.class) {
            e.a();
            com.alipay.sdk.m.a0.b.a((f) APSecuritySdk.getInstance(context));
            hashMap = new HashMap();
            hashMap.put("AE1", e.b());
            StringBuilder sb = new StringBuilder();
            sb.append(e.c() ? "1" : "0");
            hashMap.put("AE2", sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(e.d() ? "1" : "0");
            hashMap.put("AE3", sb2.toString());
            hashMap.put("AE4", e.e());
            hashMap.put("AE5", e.f());
            hashMap.put("AE6", e.g());
            hashMap.put("AE7", e.h());
            hashMap.put("AE8", e.i());
            hashMap.put("AE9", e.j());
            hashMap.put("AE10", e.k());
            hashMap.put("AE11", e.l());
            hashMap.put("AE12", e.m());
            hashMap.put("AE13", e.n());
            hashMap.put("AE14", e.o());
            hashMap.put("AE15", e.p());
            hashMap.put("AE21", com.alipay.sdk.m.a0.b.f());
        }
        return hashMap;
    }
}
