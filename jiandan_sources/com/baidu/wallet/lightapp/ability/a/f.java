package com.baidu.wallet.lightapp.ability.a;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.apollon.utils.DxmApplicationContextImpl;
import com.baidu.wallet.api.ILightappInvokerCallback;
import com.baidu.wallet.lightapp.ability.b;
import com.baidu.wallet.lightapp.base.LightappConstants;
import com.baidu.wallet.router.LocalRouter;
import com.baidu.wallet.router.RouterCallback;
import com.baidu.wallet.router.RouterRequest;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class f extends b {
    public String a() {
        return "changePayMethod";
    }

    public void a(Activity activity, String str, final ILightappInvokerCallback iLightappInvokerCallback, final String str2) {
        if (iLightappInvokerCallback != null && activity != null) {
            LocalRouter.getInstance(DxmApplicationContextImpl.getApplicationContext(activity)).route(activity, new RouterRequest().provider("dxmPay").action("enterChangePayMethod").data("options", str), new RouterCallback() {
                public void onResult(int i2, HashMap hashMap) {
                    if (i2 != 0) {
                        String str = (String) hashMap.get("errorMsg");
                        f fVar = f.this;
                        ILightappInvokerCallback iLightappInvokerCallback = iLightappInvokerCallback;
                        String str2 = str2;
                        String num = Integer.toString(i2);
                        if (!TextUtils.isEmpty(str)) {
                            str = LightappConstants.ROUTER_INVOKE_FAIL;
                        }
                        fVar.a(iLightappInvokerCallback, str2, num, str, "##changePayMethodFail");
                    } else if (hashMap != null && hashMap.size() > 0) {
                        String str3 = (String) hashMap.get("result");
                        if (!TextUtils.isEmpty(str3)) {
                            try {
                                if (((Integer) new JSONObject(str3).get("result")).intValue() == 0) {
                                    iLightappInvokerCallback.onResult(0, str3);
                                } else {
                                    iLightappInvokerCallback.onResult(1, str3);
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
