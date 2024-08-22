package com.baidu.wallet.paysdk.entrance;

import android.app.Activity;
import android.content.Context;
import com.baidu.wallet.api.BaiduPayDelegate;
import com.baidu.wallet.api.IPrecashierCallback;
import com.baidu.wallet.router.RouterAction;
import com.baidu.wallet.router.RouterCallback;
import com.dxmpay.apollon.utils.Base64Utils;
import com.dxmpay.wallet.core.utils.LogUtil;
import com.dxmpay.wallet.utils.BdWalletUtils;
import com.dxmpay.wallet.utils.NaMethodStatUtils;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class EnterWalletChangePayMethodAction implements RouterAction {
    public static final String TAG = "EnterWalletChangePayMethodAction";
    public long a;

    public EnterWalletChangePayMethodAction() {
        BdWalletUtils.putFunctionNameList("changePayMethod");
    }

    public void invoke(Context context, HashMap hashMap, RouterCallback routerCallback) {
        if (context != null && hashMap != null && hashMap.containsKey("options") && (hashMap.get("options") instanceof String)) {
            if (!a()) {
                NaMethodStatUtils.statEnter("changePayMethod", "");
            }
            a(context, (String) hashMap.get("options"), routerCallback);
        } else if (routerCallback != null) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put("errorMsg", "params-error");
            routerCallback.onResult(3, hashMap2);
        }
    }

    private void a(Context context, String str, final RouterCallback routerCallback) {
        BaiduPayDelegate.getInstance().changePayMethod((Activity) context, str, (IPrecashierCallback) new IPrecashierCallback() {
            public void onResult(String str) {
                if (routerCallback != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("result", str);
                    routerCallback.onResult(0, hashMap);
                }
                EnterWalletChangePayMethodAction.this.a(str);
            }
        });
    }

    /* access modifiers changed from: private */
    public void a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("result");
            if (optInt == 0) {
                NaMethodStatUtils.statResult("changePayMethod", optInt, "");
                return;
            }
            JSONObject jSONObject2 = new JSONObject(new String(Base64Utils.decode(jSONObject.optJSONObject("cnt").optString("data", ""))));
            NaMethodStatUtils.statResult("changePayMethod", jSONObject2.optString("errCode", ""), jSONObject2.optString("des", ""));
        } catch (JSONException e) {
            LogUtil.e(TAG, e.getMessage(), e);
        }
    }

    private boolean a() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - this.a;
        com.dxmpay.apollon.utils.LogUtil.logd("timeD=" + j);
        if (0 < j && j < 800) {
            return true;
        }
        this.a = currentTimeMillis;
        return false;
    }
}
