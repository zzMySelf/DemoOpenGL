package com.baidu.wallet.paysdk.fingerprint.a;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.wallet.api.ILoginBackListener;
import com.baidu.wallet.paysdk.fingerprint.WalletFingerprint;
import com.baidu.wallet.paysdk.fingerprint.ui.DxmCheckFingerprintActivity;
import com.baidu.wallet.router.RouterCallback;
import com.dxmpay.apollon.utils.Base64Utils;
import com.dxmpay.wallet.api.WalletLoginHelper;
import com.dxmpay.wallet.core.lollipop.json.JSONException;
import com.dxmpay.wallet.core.lollipop.json.JSONObject;
import com.dxmpay.wallet.core.utils.LogUtil;
import com.dxmpay.wallet.passport.LoginBackListenerProxy;
import com.dxmpay.wallet.paysdk.entrance.EnterDxmPayServiceAction;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import java.util.HashMap;

public class a {
    public RouterCallback a;
    public Context b;

    /* renamed from: com.baidu.wallet.paysdk.fingerprint.a.a$a  reason: collision with other inner class name */
    public static class C0166a {
        public static a a = new a();
    }

    private int b() {
        if (!WalletFingerprint.getInstance(this.b).isDevicesSupport()) {
            return 2112;
        }
        if (!WalletFingerprint.getInstance(this.b).hasEnrollFingerprint()) {
            return 2111;
        }
        if (!WalletFingerprint.getInstance(this.b).hasOTPToken()) {
            return AuthApiStatusCodes.AUTH_API_SERVER_ERROR;
        }
        return 0;
    }

    private void c() {
        this.a = null;
        this.b = null;
    }

    public a() {
    }

    public static a a() {
        return C0166a.a;
    }

    public void a(Context context, final String str, RouterCallback routerCallback) {
        if (context == null || routerCallback == null) {
            throw new IllegalArgumentException(a.class.getSimpleName() + " please check params");
        }
        this.a = routerCallback;
        this.b = context;
        WalletLoginHelper.getInstance().setOpenBdussErrorCodeShowFlag(false);
        WalletLoginHelper.getInstance().verifyPassLogin(new LoginBackListenerProxy(context, new ILoginBackListener() {
            public void onFail(int i2, String str) {
                a.this.a(5003, str);
            }

            public void onSuccess(int i2, String str) {
                a.this.a(str);
            }
        }));
    }

    /* access modifiers changed from: private */
    public void a(String str) {
        int b2 = b();
        String str2 = "";
        if (b2 != 0) {
            if (b2 == 2112) {
                str2 = "设备不支持指纹";
            } else if (b2 == 2111) {
                str2 = "设备系统设置中没有录入指纹";
            } else if (b2 == 3003) {
                str2 = "设备支付设置中没有开启指纹";
            }
            a(b2, str2);
            return;
        }
        int i2 = 3;
        int i3 = 0;
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("showSwitchPwd", 0);
                try {
                    i2 = jSONObject.optInt("checkTimes", 0);
                    str2 = jSONObject.optString("session_id", str2);
                    i3 = optInt;
                } catch (JSONException e) {
                    e = e;
                    i3 = optInt;
                    LogUtil.e("DxmCheckFingerprintManager", e.getMessage(), e);
                    a(i3, i2, str2);
                }
            } catch (JSONException e2) {
                e = e2;
                LogUtil.e("DxmCheckFingerprintManager", e.getMessage(), e);
                a(i3, i2, str2);
            }
        }
        a(i3, i2, str2);
    }

    private void a(int i2, int i3, String str) {
        Intent intent = new Intent(this.b, DxmCheckFingerprintActivity.class);
        intent.putExtra("showSwitchPwd", i2);
        intent.putExtra("checkTimes", i3);
        intent.putExtra("session_id", str);
        this.b.startActivity(intent);
    }

    public void a(int i2, String str) {
        if (this.a != null) {
            HashMap hashMap = new HashMap();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(EnterDxmPayServiceAction.SERVICE_STATUS_CODE, i2);
                jSONObject.put("des", (Object) str);
            } catch (JSONException e) {
                LogUtil.e("DxmCheckFingerprintManager", e.getMessage(), e);
            }
            hashMap.put("data", Base64Utils.encodeToString(jSONObject.toString().getBytes()));
            String assembleResult = EnterDxmPayServiceAction.assembleResult(hashMap, true);
            HashMap hashMap2 = new HashMap();
            hashMap2.put("result", assembleResult);
            this.a.onResult(0, hashMap2);
            c();
        }
    }
}
