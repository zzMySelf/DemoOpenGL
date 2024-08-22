package com.alipay.sdk.m.u;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.m.s.b;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class a {
    public static final String a = "ap_req";
    public static final String b = "ap_args";
    public static final String c = "ap_resp";

    /* JADX WARNING: Can't wrap try/catch for region: R(3:4|5|6) */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x002f, code lost:
        return com.alipay.sdk.m.h.a.c();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0030, code lost:
        return null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x002b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.alipay.sdk.m.g.a a() {
        /*
            java.lang.String r0 = "NP"
            long r1 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x002b }
            com.alipay.sdk.m.h.c r3 = new com.alipay.sdk.m.h.c     // Catch:{ Exception -> 0x002b }
            com.alipay.sdk.m.s.b r4 = com.alipay.sdk.m.s.b.d()     // Catch:{ Exception -> 0x002b }
            java.lang.String r4 = r4.c()     // Catch:{ Exception -> 0x002b }
            r3.<init>(r4)     // Catch:{ Exception -> 0x002b }
            com.alipay.sdk.m.s.b r4 = com.alipay.sdk.m.s.b.d()     // Catch:{ Exception -> 0x002b }
            android.content.Context r4 = r4.b()     // Catch:{ Exception -> 0x002b }
            long r4 = com.alipay.sdk.m.k.a.c.a(r4)     // Catch:{ Exception -> 0x002b }
            int r5 = (int) r4     // Catch:{ Exception -> 0x002b }
            short r4 = (short) r5     // Catch:{ Exception -> 0x002b }
            com.alipay.sdk.m.h.f r5 = new com.alipay.sdk.m.h.f     // Catch:{ Exception -> 0x002b }
            r5.<init>()     // Catch:{ Exception -> 0x002b }
            com.alipay.sdk.m.h.a r0 = com.alipay.sdk.m.h.a.a(r0, r1, r3, r4, r5)     // Catch:{ Exception -> 0x002b }
            return r0
        L_0x002b:
            com.alipay.sdk.m.h.a r0 = com.alipay.sdk.m.h.a.c()     // Catch:{ Exception -> 0x0030 }
            return r0
        L_0x0030:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.m.u.a.a():com.alipay.sdk.m.g.a");
    }

    public static HashMap<String, String> a(com.alipay.sdk.m.s.a aVar) {
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            com.alipay.sdk.m.g.a a2 = a();
            JSONObject jSONObject = new JSONObject();
            Context a3 = aVar != null ? aVar.a() : null;
            if (a3 == null) {
                a3 = b.d().b().getApplicationContext();
            }
            String a4 = n.a(aVar, a3);
            String b2 = com.alipay.sdk.m.w.b.b(aVar, a3);
            String str = "";
            jSONObject.put("ap_q", a2 != null ? a2.a() : str);
            jSONObject.put(com.alipay.sdk.m.s.a.z, aVar != null ? aVar.d : str);
            jSONObject.put("u_pd", String.valueOf(n.g()));
            jSONObject.put("u_lk", String.valueOf(n.e(n.b())));
            jSONObject.put("u_pi", String.valueOf(aVar != null ? aVar.g : "_"));
            jSONObject.put("u_fu", a4);
            jSONObject.put("u_oi", b2);
            hashMap.put(a, jSONObject.toString());
            StringBuilder sb = new StringBuilder();
            if (a2 != null) {
                str = a2.a();
            }
            sb.append(str);
            sb.append("|");
            sb.append(a4);
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, "ap_q", sb.toString());
        } catch (Exception e) {
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, "APMEx1", (Throwable) e);
        }
        return hashMap;
    }

    public static JSONObject a(com.alipay.sdk.m.s.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString(c);
        try {
            if (!TextUtils.isEmpty(optString)) {
                return new JSONObject(optString);
            }
            return null;
        } catch (JSONException e) {
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, "APMEx2", (Throwable) e);
            return null;
        }
    }

    public static void a(com.alipay.sdk.m.s.a aVar, JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject != null && jSONObject2 != null) {
            try {
                jSONObject.putOpt(b, jSONObject2);
            } catch (JSONException e) {
                com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, "APMEx2", (Throwable) e);
            }
        }
    }

    public static void a(com.alipay.sdk.m.s.a aVar, HashMap<String, String> hashMap) {
        JSONObject a2 = com.alipay.sdk.m.m.a.z().a();
        if (hashMap != null && a2 != null) {
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, "ap_r", a2.optString("ap_r"));
            hashMap.putAll(n.a(a2));
        }
    }
}
