package com.alipay.mobilesecuritysdk.face;

import android.content.Context;
import com.alipay.apmobilesecuritysdk.face.APSecuritySdk;
import com.alipay.sdk.m.l.b;
import com.alipay.sdk.m.z.a;
import com.baidu.sapi2.activity.BaseActivity;
import java.util.HashMap;
import java.util.Map;

public class SecurityClientMobile {
    public static synchronized String GetApdid(Context context, Map<String, String> map) {
        String a;
        synchronized (SecurityClientMobile.class) {
            HashMap hashMap = new HashMap();
            hashMap.put(b.g, a.a(map, b.g, ""));
            hashMap.put("tid", a.a(map, "tid", ""));
            hashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_USER_ID, a.a(map, BaseActivity.EXTRA_PARAM_THIRD_VERIFY_USER_ID, ""));
            APSecuritySdk.getInstance(context).initToken(0, hashMap, (APSecuritySdk.InitResultListener) null);
            a = com.alipay.apmobilesecuritysdk.a.a.a(context);
        }
        return a;
    }
}
