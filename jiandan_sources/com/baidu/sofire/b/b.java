package com.baidu.sofire.b;

import android.util.Base64;
import com.baidu.sofire.a.a;
import org.json.JSONObject;

public class b {
    public static String a = "";
    public static int b = -1;
    public static String c = "";

    public static void a(int i2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("0", i2);
            jSONObject.put("1", Base64.encodeToString(c.getBytes(), 0));
            a = jSONObject.toString();
        } catch (Throwable unused) {
            int i3 = a.a;
        }
    }
}
