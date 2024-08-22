package com.baidu.sofire.xclient.privacycontrol.a;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class a {
    public static final HashMap<String, b> a = new HashMap<>();

    public static synchronized void a(String str) {
        synchronized (a.class) {
            try {
                if (TextUtils.isEmpty(str)) {
                    for (Map.Entry next : a.entrySet()) {
                        String str2 = (String) next.getKey();
                        b bVar = (b) next.getValue();
                        if (bVar != null) {
                            bVar.onConfigUpdate(str2, "");
                        }
                    }
                } else {
                    JSONObject jSONObject = new JSONObject(str);
                    for (Map.Entry next2 : a.entrySet()) {
                        String str3 = (String) next2.getKey();
                        b bVar2 = (b) next2.getValue();
                        String optString = jSONObject.optString(str3);
                        if (bVar2 != null) {
                            bVar2.onConfigUpdate(str3, optString);
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static synchronized void a(String str, b bVar) {
        synchronized (a.class) {
            try {
                a.put(str, bVar);
            } catch (Throwable unused) {
            }
        }
    }
}
