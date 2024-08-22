package com.baidu.sofire.l;

import org.json.JSONArray;

/* compiled from: SubModuleManager */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static JSONArray f3319a;

    public static synchronized JSONArray a() {
        JSONArray jSONArray;
        boolean z;
        synchronized (a.class) {
            try {
                if (f3319a == null) {
                    f3319a = new JSONArray();
                    try {
                        Class.forName("com.baidu.sofire.face.api.FaceApi");
                        z = true;
                    } catch (Throwable th2) {
                        z = false;
                    }
                    if (z) {
                        f3319a.put("1");
                    }
                }
                jSONArray = f3319a;
            } catch (Throwable th3) {
                int i2 = com.baidu.sofire.a.a.f3011a;
                return new JSONArray();
            }
        }
        return jSONArray;
    }
}
