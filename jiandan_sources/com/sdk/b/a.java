package com.sdk.b;

import android.content.Context;
import com.baidu.sapi2.activity.social.YYInnerSSOLoginActivity;
import com.baidu.sapi2.result.OneKeyLoginOptResult;
import com.sdk.base.module.manager.SDKManager;
import com.sdk.f.f;
import org.json.JSONObject;

public class a {
    public static final String a = "a";
    public static Boolean b = Boolean.valueOf(f.a);

    public static String a(int i2, String str) {
        String a2 = com.sdk.m.a.a();
        if (!com.sdk.o.a.b(a2).booleanValue()) {
            return null;
        }
        return YYInnerSSOLoginActivity.s + i2 + str + a2;
    }

    public static String a(Context context, int i2, String str) {
        try {
            if (!SDKManager.useCache) {
                return null;
            }
            String a2 = a(i2, str);
            if (com.sdk.o.a.b(a2).booleanValue()) {
                String c = com.sdk.k.a.c(context, a2);
                if (com.sdk.o.a.b(c).booleanValue()) {
                    String b2 = b(c);
                    String a3 = com.sdk.u.a.a(c.split("-")[0]);
                    if (!com.sdk.u.a.b(a3)) {
                        com.sdk.o.a.b(a, "can use cache", b);
                        JSONObject jSONObject = new JSONObject(a3);
                        if (i2 == 1) {
                            jSONObject.remove(OneKeyLoginOptResult.OptResultFields.SECURITY_PHONE);
                        }
                        return jSONObject.toString() + "-" + b2;
                    }
                    com.sdk.o.a.b(a, "OutDate cache invalid", b);
                }
            }
            return null;
        } catch (Exception unused) {
        }
    }

    public static <T> String a(T t, String str) {
        return t + "-" + str;
    }

    public static String a(String str) {
        return str.split("-")[0];
    }

    public static void a(Context context) {
        com.sdk.o.a.b(a, "cache clear", b);
        com.sdk.k.a.a(context, YYInnerSSOLoginActivity.s);
    }

    public static String b(String str) {
        return str.split("-")[1];
    }

    public static void a(Context context, int i2, String str, String str2) {
        if (SDKManager.useCache && com.sdk.o.a.b(str).booleanValue()) {
            String a2 = a(i2, str2);
            if (com.sdk.o.a.b(a2).booleanValue()) {
                com.sdk.k.a.a(context, a2, str);
            }
        }
    }
}
