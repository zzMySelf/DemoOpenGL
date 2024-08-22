package com.cmic.sso.sdk.auth;

import android.text.TextUtils;
import com.baidu.android.util.io.FileUtils;
import com.baidu.sapi2.activity.BaseActivity;
import com.cmic.sso.sdk.a;
import org.json.JSONException;
import org.json.JSONObject;

public class c {
    public static JSONObject a(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("resultCode", str);
            jSONObject.put("desc", str2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public static JSONObject b(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("resultCode", str);
            jSONObject.put("desc", str2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public static JSONObject a(String str, a aVar, JSONObject jSONObject) {
        String[] strArr = {FileUtils.UNKNOW, "移动", "联通", "电信"};
        try {
            String b = aVar.b("operatortype", "0");
            if (!"0".equals(b)) {
                if (!TextUtils.isEmpty(b)) {
                    jSONObject.put("operatorType", strArr[Integer.parseInt(b)]);
                    return jSONObject;
                }
            }
            if ("103000".equals(str)) {
                jSONObject.put("operatorType", strArr[1]);
            } else {
                jSONObject.put("operatorType", strArr[0]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public static JSONObject a(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("resultCode", "103000");
            jSONObject.put("desc", "true");
            jSONObject.put("securityphone", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public static JSONObject a(String str, String str2, a aVar, JSONObject jSONObject) {
        String str3;
        String str4;
        String str5;
        String str6 = "0";
        JSONObject jSONObject2 = new JSONObject();
        try {
            int parseInt = Integer.parseInt(aVar.b("authType", str6));
            int c = aVar.c("networktype");
            if (parseInt == 3) {
                if (c == 3) {
                    str5 = "WIFI下网关鉴权";
                    str4 = "1";
                } else {
                    str5 = "网关鉴权";
                    str4 = "2";
                }
                String str7 = str4;
                str3 = str5;
                str6 = str7;
            } else {
                str3 = "其他";
            }
            jSONObject2.put("resultCode", str);
            jSONObject2.put("authType", str6);
            jSONObject2.put("authTypeDes", str3);
            if ("103000".equals(str)) {
                if (1 == aVar.c("logintype")) {
                    jSONObject2.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_OPEN_ID, aVar.b(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_OPEN_ID));
                    jSONObject2.put("securityphone", aVar.b("securityphone"));
                }
                jSONObject2.put("token", jSONObject.optString("token"));
                jSONObject2.put("tokenExpiresIn", jSONObject.optString("tokenExpiresIn"));
            } else {
                jSONObject2.put("desc", str2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        com.cmic.sso.sdk.e.c.b("AuthnResult", "返回参数:" + jSONObject2.toString());
        return jSONObject2;
    }
}
