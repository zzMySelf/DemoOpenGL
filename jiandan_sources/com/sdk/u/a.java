package com.sdk.u;

import android.content.Context;
import android.net.ConnectivityManager;
import com.sdk.f.f;
import com.sdk.q.b;
import java.util.TreeMap;
import org.json.JSONObject;

public class a {
    public static final String a = a.class.getSimpleName();
    public static Boolean b = Boolean.valueOf(f.a);

    static {
        new TreeMap();
    }

    public static String a(String str) {
        String str2;
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("aesKey");
            String optString2 = jSONObject.optString("data");
            String optString3 = jSONObject.optString("sign");
            if (com.sdk.v.a.d == 0) {
                str2 = b.a(optString, com.sdk.v.a.b);
            } else {
                str2 = jSONObject.optString("key");
                com.sdk.r.f a2 = com.sdk.r.f.a();
                String a3 = a2.b.a(a2.c, str2, str2, optString3);
                if (com.sdk.o.a.a(a3).booleanValue() && !Boolean.parseBoolean(a3)) {
                    return null;
                }
            }
            return com.sdk.r.f.a().b.b(str2, optString2);
        } catch (Throwable th2) {
            com.sdk.o.b.b(th2.toString());
            String str3 = a;
            com.sdk.o.a.a(str3, "SDK解密异常：" + th2.toString(), b);
            return null;
        }
    }

    public static void a() {
    }

    public static boolean b(String str) {
        try {
            return new JSONObject(str).optLong("exp") < System.currentTimeMillis();
        } catch (Exception e) {
            String str2 = a;
            com.sdk.o.a.c(str2, "out data error" + e, b);
            return true;
        }
    }

    public static void a(Context context) {
        ConnectivityManager.NetworkCallback networkCallback;
        com.sdk.a.b bVar = new com.sdk.a.b();
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getApplicationContext().getSystemService("connectivity");
        bVar.g = connectivityManager;
        if (connectivityManager != null && (networkCallback = com.sdk.a.b.e) != null) {
            connectivityManager.unregisterNetworkCallback(networkCallback);
            com.sdk.a.b.d = true;
            com.sdk.a.b.e = null;
        }
    }
}
