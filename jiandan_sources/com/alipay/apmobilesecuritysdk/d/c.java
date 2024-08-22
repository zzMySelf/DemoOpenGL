package com.alipay.apmobilesecuritysdk.d;

import android.content.Context;
import com.alipay.apmobilesecuritysdk.e.e;
import com.alipay.apmobilesecuritysdk.face.APSecuritySdk;
import com.alipay.sdk.m.a0.b;
import com.alipay.sdk.m.a0.f;
import com.alipay.sdk.m.z.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class c {
    public static Map<String, String> a(Context context) {
        b a = b.a((f) APSecuritySdk.getInstance(context));
        HashMap hashMap = new HashMap();
        com.alipay.apmobilesecuritysdk.e.f a2 = e.a(context);
        String a3 = a.a(context);
        String d = a.d(context);
        if (a2 != null) {
            if (a.a(a3)) {
                a3 = a2.b();
            }
            if (a.a(d)) {
                d = a2.e();
            }
        }
        com.alipay.apmobilesecuritysdk.e.f fVar = new com.alipay.apmobilesecuritysdk.e.f("", a3, "", "", d);
        if (context != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("imei", fVar.a());
                jSONObject.put("imsi", fVar.b());
                jSONObject.put("mac", fVar.c());
                jSONObject.put("bluetoothmac", fVar.d());
                jSONObject.put("gsi", fVar.e());
                String jSONObject2 = jSONObject.toString();
                com.alipay.apmobilesecuritysdk.f.a.a("device_feature_file_name", "device_feature_file_key", jSONObject2);
                com.alipay.apmobilesecuritysdk.f.a.a(context, "device_feature_prefs_name", "device_feature_prefs_key", jSONObject2);
            } catch (Exception e) {
                com.alipay.apmobilesecuritysdk.c.a.a((Throwable) e);
            }
        }
        hashMap.put("AD1", "");
        hashMap.put("AD2", a3);
        hashMap.put("AD3", b.h(context));
        hashMap.put("AD5", b.j(context));
        hashMap.put("AD6", b.k(context));
        hashMap.put("AD7", b.l(context));
        hashMap.put("AD9", a.c(context));
        hashMap.put("AD10", d);
        hashMap.put("AD11", b.d());
        hashMap.put("AD12", a.a());
        hashMap.put("AD13", b.e());
        hashMap.put("AD14", b.g());
        hashMap.put("AD15", b.h());
        hashMap.put("AD16", b.i());
        hashMap.put("AD17", "");
        hashMap.put("AD19", b.m(context));
        hashMap.put("AD20", b.j());
        hashMap.put("AD22", "");
        hashMap.put("AD23", b.n(context));
        hashMap.put("AD24", a.g(b.i(context)));
        hashMap.put("AD26", a.b(context));
        hashMap.put("AD27", b.o());
        hashMap.put("AD28", b.q());
        hashMap.put("AD29", b.s());
        hashMap.put("AD30", b.p());
        hashMap.put("AD31", b.r());
        hashMap.put("AD32", b.m());
        hashMap.put("AD33", b.n());
        hashMap.put("AD34", b.o(context));
        hashMap.put("AD35", b.p(context));
        hashMap.put("AD36", a.e(context));
        hashMap.put("AD37", b.l());
        hashMap.put("AD38", b.k());
        hashMap.put("AD39", b.f(context));
        hashMap.put("AD40", b.g(context));
        hashMap.put("AD41", b.b());
        hashMap.put("AD42", b.c());
        return hashMap;
    }
}
