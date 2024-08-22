package com.dxmpay.wallet.router;

import com.baidu.android.common.others.lang.StringUtil;
import com.dxmpay.wallet.core.NoProguard;
import com.dxmpay.wallet.core.utils.LogUtil;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class RouterRequest implements NoProguard {
    public static final String TAG = "RouterRequest";
    public String action = "";
    public HashMap data = new HashMap();
    public String provider = "";

    public RouterRequest action(String str) {
        this.action = str;
        return this;
    }

    public RouterRequest data(HashMap hashMap) {
        this.data = hashMap;
        return this;
    }

    public String getAction() {
        return this.action;
    }

    public HashMap getData() {
        return this.data;
    }

    public String getProvider() {
        return this.provider;
    }

    public RouterRequest provider(String str) {
        this.provider = str;
        return this;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("provider", this.provider);
            jSONObject.put("action", this.action);
            try {
                JSONObject jSONObject2 = new JSONObject();
                for (Object next : this.data.keySet()) {
                    jSONObject2.put(next.toString(), this.data.get(next));
                }
                jSONObject.put("data", jSONObject2);
            } catch (Exception e) {
                LogUtil.e("RouterRequest", e.getMessage(), e);
                jSONObject.put("data", StringUtil.EMPTY_ARRAY);
            }
        } catch (JSONException e2) {
            LogUtil.e("RouterRequest", e2.getMessage(), e2);
        }
        return jSONObject.toString();
    }

    public RouterRequest data(String str, Object obj) {
        this.data.put(str, obj);
        return this;
    }
}
