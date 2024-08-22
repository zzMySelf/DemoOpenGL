package com.dlife.ctaccountapi;

import cn.com.chinatelecom.gateway.lib.CtAuth;
import org.json.JSONObject;

public class q {
    public static final String a = "q";

    public static String a(int i2, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("result", i2);
            jSONObject.put("msg", str);
            return jSONObject.toString();
        } catch (Throwable th2) {
            CtAuth.warn(a, "Json parse error", th2);
            return "";
        }
    }
}
