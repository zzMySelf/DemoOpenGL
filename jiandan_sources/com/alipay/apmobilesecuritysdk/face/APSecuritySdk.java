package com.alipay.apmobilesecuritysdk.face;

import android.content.Context;
import com.alipay.apmobilesecuritysdk.a.a;
import com.alipay.apmobilesecuritysdk.e.d;
import com.alipay.apmobilesecuritysdk.e.g;
import com.alipay.apmobilesecuritysdk.e.h;
import com.alipay.apmobilesecuritysdk.e.i;
import com.alipay.apmobilesecuritysdk.otherid.UmidSdkWrapper;
import com.alipay.apmobilesecuritysdk.otherid.UtdidWrapper;
import com.alipay.sdk.m.a0.f;
import com.alipay.sdk.m.l.b;
import com.baidu.sapi2.activity.BaseActivity;
import java.util.HashMap;
import java.util.Map;

public class APSecuritySdk implements f {
    public static APSecuritySdk a;
    public static APSecBgCheckerInterface bgChecker;
    public static IDeviceInfo c;
    public static Object d = new Object();
    public Context b;

    public interface InitResultListener {
        void onResult(TokenResult tokenResult);
    }

    public class TokenResult {
        public String apdid;
        public String apdidToken;
        public String clientKey;
        public String umidToken;

        public TokenResult() {
        }
    }

    public APSecuritySdk(Context context) {
        this.b = context;
    }

    public static IDeviceInfo getDeviceInfo() {
        return c;
    }

    public static APSecuritySdk getInstance(Context context) {
        if (a == null) {
            synchronized (d) {
                if (a == null) {
                    a = new APSecuritySdk(context);
                }
            }
        }
        return a;
    }

    public static String getUtdid(Context context) {
        return UtdidWrapper.getUtdid(context);
    }

    public static void registerBgChecker(APSecBgCheckerInterface aPSecBgCheckerInterface) {
        bgChecker = aPSecBgCheckerInterface;
    }

    public static void registerDeviceInfo(IDeviceInfo iDeviceInfo) {
        c = iDeviceInfo;
    }

    public String getAndroidId() {
        IDeviceInfo iDeviceInfo = c;
        if (iDeviceInfo != null) {
            return iDeviceInfo.getAndroidId();
        }
        return null;
    }

    public String getApdidToken() {
        String a2 = a.a(this.b, "");
        if (com.alipay.sdk.m.z.a.a(a2)) {
            initToken(0, new HashMap(), (InitResultListener) null);
        }
        return a2;
    }

    public String getSdkName() {
        return "APPSecuritySDK-ALIPAYSDK";
    }

    public String getSdkVersion() {
        return "3.4.0.202307050856";
    }

    public String getSubscriberId() {
        IDeviceInfo iDeviceInfo = c;
        if (iDeviceInfo != null) {
            return iDeviceInfo.getSubscriberId();
        }
        return null;
    }

    public synchronized TokenResult getTokenResult() {
        TokenResult tokenResult;
        tokenResult = new TokenResult();
        try {
            tokenResult.apdidToken = a.a(this.b, "");
            tokenResult.clientKey = h.f(this.b);
            tokenResult.apdid = a.a(this.b);
            tokenResult.umidToken = UmidSdkWrapper.getSecurityToken(this.b);
            if (com.alipay.sdk.m.z.a.a(tokenResult.apdid) || com.alipay.sdk.m.z.a.a(tokenResult.apdidToken) || com.alipay.sdk.m.z.a.a(tokenResult.clientKey)) {
                initToken(0, new HashMap(), (InitResultListener) null);
            }
        } catch (Throwable unused) {
        }
        return tokenResult;
    }

    public void initToken(int i2, Map<String, String> map, final InitResultListener initResultListener) {
        com.alipay.apmobilesecuritysdk.b.a.a().a(i2);
        String b2 = h.b(this.b);
        String c2 = com.alipay.apmobilesecuritysdk.b.a.a().c();
        if (com.alipay.sdk.m.z.a.b(b2) && !com.alipay.sdk.m.z.a.a(b2, c2)) {
            com.alipay.apmobilesecuritysdk.e.a.a(this.b);
            d.a(this.b);
            g.a(this.b);
            i.h();
        }
        if (!com.alipay.sdk.m.z.a.a(b2, c2)) {
            h.c(this.b, c2);
        }
        String a2 = com.alipay.sdk.m.z.a.a(map, b.g, "");
        String a3 = com.alipay.sdk.m.z.a.a(map, "tid", "");
        String a4 = com.alipay.sdk.m.z.a.a(map, BaseActivity.EXTRA_PARAM_THIRD_VERIFY_USER_ID, "");
        if (com.alipay.sdk.m.z.a.a(a2)) {
            a2 = UtdidWrapper.getUtdid(this.b);
        }
        final HashMap hashMap = new HashMap();
        hashMap.put(b.g, a2);
        hashMap.put("tid", a3);
        hashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_USER_ID, a4);
        hashMap.put("appName", "");
        hashMap.put("appKeyClient", "");
        hashMap.put("appchannel", "");
        hashMap.put("rpcVersion", "8");
        com.alipay.apmobilesecuritysdk.f.b.a().a((Runnable) new Runnable() {
            public void run() {
                new a(APSecuritySdk.this.b).a((Map<String, String>) hashMap);
                InitResultListener initResultListener = initResultListener;
                if (initResultListener != null) {
                    initResultListener.onResult(APSecuritySdk.this.getTokenResult());
                }
            }
        });
    }

    public boolean isBackgroundRunning() {
        APSecBgCheckerInterface aPSecBgCheckerInterface = bgChecker;
        if (aPSecBgCheckerInterface != null) {
            return aPSecBgCheckerInterface.isBackgroundRunning();
        }
        return false;
    }
}
