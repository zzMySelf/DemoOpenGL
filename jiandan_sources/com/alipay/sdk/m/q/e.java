package com.alipay.sdk.m.q;

import android.content.Context;
import com.alipay.sdk.m.o.a;
import com.alipay.sdk.m.p.b;
import com.alipay.sdk.m.s.a;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class e extends com.alipay.sdk.m.p.e {
    public String a(a aVar, String str, JSONObject jSONObject) {
        return str;
    }

    public Map<String, String> a(boolean z, String str) {
        return new HashMap();
    }

    public JSONObject a() {
        return null;
    }

    public boolean c() {
        return false;
    }

    public b a(a aVar, Context context, String str) throws Throwable {
        com.alipay.sdk.m.u.e.d(com.alipay.sdk.m.l.a.A, "mdap post");
        byte[] a = com.alipay.sdk.m.n.b.a(str.getBytes(Charset.forName("UTF-8")));
        HashMap hashMap = new HashMap();
        hashMap.put("utdId", com.alipay.sdk.m.s.b.d().c());
        hashMap.put("logHeader", "RAW");
        hashMap.put("bizCode", com.alipay.sdk.m.u.e.b);
        hashMap.put("productId", "alipaysdk_android");
        hashMap.put("Content-Encoding", "Gzip");
        hashMap.put("productVersion", "15.8.16");
        a.b a2 = com.alipay.sdk.m.o.a.a(context, new a.C0012a(com.alipay.sdk.m.l.a.e, hashMap, a));
        com.alipay.sdk.m.u.e.d(com.alipay.sdk.m.l.a.A, "mdap got " + a2);
        if (a2 != null) {
            boolean a3 = com.alipay.sdk.m.p.e.a(a2);
            try {
                byte[] bArr = a2.c;
                if (a3) {
                    bArr = com.alipay.sdk.m.n.b.b(bArr);
                }
                return new b("", new String(bArr, Charset.forName("UTF-8")));
            } catch (Exception e) {
                com.alipay.sdk.m.u.e.a((Throwable) e);
                return null;
            }
        } else {
            throw new RuntimeException("Response is null");
        }
    }
}
