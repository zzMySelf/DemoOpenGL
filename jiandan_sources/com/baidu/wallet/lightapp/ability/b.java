package com.baidu.wallet.lightapp.ability;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.apollon.utils.PhoneUtils;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.wallet.api.ILightappInvokerCallback;
import com.baidu.wallet.core.utils.LogUtil;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class b implements a {
    public String a(int i2, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("result", i2);
            jSONObject2.put("cnt", jSONObject);
        } catch (JSONException e) {
            LogUtil.e("NativeAbilityBase", SapiUtils.KEY_QR_LOGIN_ERROR, e);
        }
        return jSONObject2.toString();
    }

    public String a(Map<String, Object> map, boolean z) {
        if (map == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("result", z ? 0 : 1);
            jSONObject.put("cnt", new JSONObject(map));
        } catch (JSONException e) {
            LogUtil.e("NativeAbilityBase", SapiUtils.KEY_QR_LOGIN_ERROR, e);
        }
        return jSONObject.toString();
    }

    public int a(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Integer.parseInt(new JSONObject(str).getString(str2));
            } catch (JSONException e) {
                com.baidu.apollon.utils.LogUtil.d("NativeAbilityBase", e.getMessage());
            } catch (Throwable th2) {
                com.baidu.apollon.utils.LogUtil.d("NativeAbilityBase", th2.getMessage());
            }
        }
        return -1;
    }

    public void a(ILightappInvokerCallback iLightappInvokerCallback, String str, String str2, String str3, String str4) {
        if (iLightappInvokerCallback != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("errCode", str2);
            hashMap.put("des", str3);
            iLightappInvokerCallback.onResult(1, a((Map<String, Object>) hashMap, false));
        }
    }

    public String a(Context context, String str) {
        return PhoneUtils.getApplicationName(context) + "没有" + str;
    }
}
