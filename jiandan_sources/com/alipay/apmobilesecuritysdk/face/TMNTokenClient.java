package com.alipay.apmobilesecuritysdk.face;

import android.content.Context;
import com.alipay.apmobilesecuritysdk.otherid.UtdidWrapper;
import com.alipay.sdk.m.l.b;
import com.alipay.sdk.m.z.a;
import com.baidu.sapi2.activity.BaseActivity;
import java.util.HashMap;
import java.util.Map;

public class TMNTokenClient {
    public static TMNTokenClient a;
    public Context b = null;

    public interface InitResultListener {
        void onResult(String str, int i2);
    }

    public TMNTokenClient(Context context) {
        if (context != null) {
            this.b = context;
            return;
        }
        throw new IllegalArgumentException("TMNTokenClient initialization error: context is null.");
    }

    public static TMNTokenClient getInstance(Context context) {
        if (a == null) {
            synchronized (TMNTokenClient.class) {
                if (a == null) {
                    a = new TMNTokenClient(context);
                }
            }
        }
        return a;
    }

    public void intiToken(final String str, String str2, String str3, final InitResultListener initResultListener) {
        if (a.a(str) && initResultListener != null) {
            initResultListener.onResult("", 2);
        }
        if (a.a(str2) && initResultListener != null) {
            initResultListener.onResult("", 3);
        }
        final HashMap hashMap = new HashMap();
        hashMap.put(b.g, UtdidWrapper.getUtdid(this.b));
        hashMap.put("tid", "");
        hashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_USER_ID, "");
        hashMap.put("appName", str);
        hashMap.put("appKeyClient", str2);
        hashMap.put("appchannel", "openapi");
        hashMap.put("sessionId", str3);
        hashMap.put("rpcVersion", "8");
        com.alipay.apmobilesecuritysdk.f.b.a().a((Runnable) new Runnable() {
            public void run() {
                int a2 = new com.alipay.apmobilesecuritysdk.a.a(TMNTokenClient.this.b).a((Map<String, String>) hashMap);
                InitResultListener initResultListener = initResultListener;
                if (initResultListener != null) {
                    if (a2 == 0) {
                        initResultListener.onResult(com.alipay.apmobilesecuritysdk.a.a.a(TMNTokenClient.this.b, str), 0);
                        return;
                    }
                    initResultListener.onResult("", a2);
                }
            }
        });
    }
}
