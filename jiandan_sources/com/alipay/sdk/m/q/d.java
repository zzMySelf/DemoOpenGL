package com.alipay.sdk.m.q;

import android.content.Context;
import com.alipay.sdk.m.p.b;
import com.alipay.sdk.m.p.e;
import com.alipay.sdk.m.s.a;
import com.baidubce.util.Mimetypes;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class d extends e {
    public static final String t = "log_v";

    public String a(a aVar, String str, JSONObject jSONObject) {
        return str;
    }

    public Map<String, String> a(boolean z, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(e.c, String.valueOf(z));
        hashMap.put(e.f, Mimetypes.MIMETYPE_OCTET_STREAM);
        hashMap.put(e.f673i, "CBC");
        return hashMap;
    }

    public JSONObject a() throws JSONException {
        return null;
    }

    public boolean c() {
        return false;
    }

    public String a(a aVar) throws JSONException {
        HashMap hashMap = new HashMap();
        hashMap.put(e.k, "/sdk/log");
        hashMap.put(e.l, "1.0.0");
        HashMap hashMap2 = new HashMap();
        hashMap2.put(t, "1.0");
        return a(aVar, (HashMap<String, String>) hashMap, (HashMap<String, String>) hashMap2);
    }

    public b a(a aVar, Context context, String str) throws Throwable {
        return a(aVar, context, str, com.alipay.sdk.m.l.a.d, true);
    }
}
