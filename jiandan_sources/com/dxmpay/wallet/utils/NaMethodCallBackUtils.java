package com.dxmpay.wallet.utils;

import android.text.TextUtils;
import com.dxmpay.wallet.core.utils.LogUtil;
import com.dxmpay.wallet.paysdk.entrance.EnterDxmPayServiceAction;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class NaMethodCallBackUtils {
    public static JSONObject ad(int i2, String str) {
        JSONObject jSONObject = new JSONObject();
        if (str == null) {
            str = "";
        }
        try {
            jSONObject.putOpt(EnterDxmPayServiceAction.SERVICE_STATUS_CODE, Integer.valueOf(i2));
            jSONObject.putOpt("des", str);
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    public static HashMap<String, String> formCallbackParam(String str, JSONObject jSONObject, String str2) {
        NaMethodStatUtils.statResult(str, 0, str2);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("result", qw(true, jSONObject));
        return hashMap;
    }

    public static HashMap<String, String> formFailCallbackParam(String str, int i2, String str2) {
        NaMethodStatUtils.statResult(str, i2, str2);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("result", qw(false, ad(i2, str2)));
        return hashMap;
    }

    public static String qw(boolean z, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (jSONObject != null) {
                jSONObject2.put("data", jSONObject);
            }
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("result", z ? 0 : 1);
            jSONObject3.put("cnt", jSONObject2);
            return jSONObject3.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    public static HashMap<String, String> formCallbackParam(String str, String str2, String str3) {
        JSONObject jSONObject;
        if (!TextUtils.isEmpty(str2)) {
            try {
                jSONObject = new JSONObject(str2);
            } catch (JSONException e) {
                LogUtil.e("NaMethodCallBackUtils", e.getMessage(), e);
            }
            return formCallbackParam(str, jSONObject, str3);
        }
        jSONObject = null;
        return formCallbackParam(str, jSONObject, str3);
    }
}
