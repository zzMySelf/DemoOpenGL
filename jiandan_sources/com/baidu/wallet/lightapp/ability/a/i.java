package com.baidu.wallet.lightapp.ability.a;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.apollon.utils.DxmApplicationContextImpl;
import com.baidu.wallet.api.ILightappInvokerCallback;
import com.baidu.wallet.lightapp.ability.b;
import com.baidu.wallet.router.LocalRouter;
import com.baidu.wallet.router.RouterCallback;
import com.baidu.wallet.router.RouterRequest;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class i extends b {
    public String a() {
        return "getPayMethod";
    }

    public void a(Activity activity, String str, final ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        if (iLightappInvokerCallback != null) {
            LocalRouter.getInstance(DxmApplicationContextImpl.getApplicationContext(activity)).route(activity, new RouterRequest().provider("dxmPay").action("enterGetPayMethod").data("options", str), new RouterCallback() {
                public void onResult(int i2, HashMap hashMap) {
                    if (i2 == 0 && hashMap != null && hashMap.size() > 0) {
                        String str = (String) hashMap.get("result");
                        if (!TextUtils.isEmpty(str)) {
                            try {
                                if (((Integer) new JSONObject(str).get("result")).intValue() == 0) {
                                    iLightappInvokerCallback.onResult(0, str);
                                } else {
                                    iLightappInvokerCallback.onResult(1, str);
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            });
        }
    }
}
