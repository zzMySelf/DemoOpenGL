package com.alipay.sdk.m.q;

import com.alipay.sdk.m.p.e;
import com.alipay.sdk.m.s.a;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class b extends e {
    public JSONObject a() throws JSONException {
        return e.a("sdkConfig", "obtain");
    }

    public String b() {
        return "5.0.0";
    }

    public boolean c() {
        return true;
    }

    public String a(a aVar, HashMap<String, String> hashMap, HashMap<String, String> hashMap2) throws JSONException {
        if (hashMap2 == null) {
            hashMap2 = new HashMap<>();
        }
        hashMap2.putAll(com.alipay.sdk.m.u.a.a(aVar));
        com.alipay.sdk.m.u.e.d(com.alipay.sdk.m.l.a.A, "cf " + hashMap2);
        return super.a(aVar, hashMap, hashMap2);
    }
}
