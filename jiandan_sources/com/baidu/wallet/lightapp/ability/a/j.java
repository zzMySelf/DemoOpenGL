package com.baidu.wallet.lightapp.ability.a;

import android.app.Activity;
import android.util.Base64;
import com.baidu.apollon.utils.BussinessUtils;
import com.baidu.wallet.api.ILightappInvokerCallback;
import com.baidu.wallet.lightapp.ability.b;
import com.baidu.wallet.lightapp.ability.datamodle.NativeAbilityUserAgentModel;
import com.baidu.wallet.lightapp.business.LightappBusinessClient;

public class j extends b {
    public static int a = 1;

    public String a() {
        return LightappBusinessClient.METHOD_GET_USER_AGENT;
    }

    public void a(Activity activity, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        String ua = BussinessUtils.getUA(activity);
        if (a(str, "base64") == a) {
            ua = Base64.encodeToString(ua.getBytes(), 2);
        }
        NativeAbilityUserAgentModel nativeAbilityUserAgentModel = new NativeAbilityUserAgentModel(0);
        nativeAbilityUserAgentModel.cnt.data = ua;
        iLightappInvokerCallback.onResult(0, nativeAbilityUserAgentModel.toJson());
    }
}
