package com.baidu.wallet.paysdk.entrance;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.pay.PayCallBack;
import com.baidu.wallet.api.BaiduPayDelegate;
import com.baidu.wallet.router.RouterCallback;
import com.dxmpay.apollon.utils.JsonUtils;
import com.dxmpay.apollon.utils.LogUtil;
import com.dxmpay.wallet.core.lollipop.json.JSONObject;
import com.dxmpay.wallet.paysdk.entrance.EnterDxmPayServiceAction;
import com.dxmpay.wallet.utils.NaMethodStatUtils;
import java.util.HashMap;

public class a {

    /* renamed from: com.baidu.wallet.paysdk.entrance.a$a  reason: collision with other inner class name */
    public static class C0165a {
        public static final a a = new a();
    }

    public a() {
    }

    public static a a() {
        return C0165a.a;
    }

    public void a(Context context, String str, final RouterCallback routerCallback) {
        HashMap hashMap;
        if (routerCallback != null) {
            if (TextUtils.isEmpty(str)) {
                a(1, 2, EnterDxmPayServiceAction.ERR_MSG, routerCallback);
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("orderInfo", "");
                if (TextUtils.isEmpty(optString)) {
                    a(1, 2, EnterDxmPayServiceAction.ERR_MSG, routerCallback);
                    return;
                }
                final boolean optBoolean = jSONObject.optBoolean("hideLoadingDialog", false);
                String optString2 = jSONObject.optString("orderInfoExtra", "");
                if (!TextUtils.isEmpty(optString2)) {
                    hashMap = (HashMap) JsonUtils.fromJson(optString2, HashMap.class);
                } else {
                    hashMap = new HashMap();
                }
                BaiduPayDelegate.getInstance().doPay(context, optString, new PayCallBack() {
                    public boolean isHideLoadingDialog() {
                        return optBoolean;
                    }

                    public void onPayResult(int i2, String str) {
                        a.this.a(0, i2, str, routerCallback);
                    }
                }, hashMap);
            } catch (Exception e) {
                LogUtil.errord(e.getMessage());
                a(1, 2, e.getMessage(), routerCallback);
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(int i2, int i3, String str, RouterCallback routerCallback) {
        if (i3 == 0) {
            NaMethodStatUtils.statResult(EnterDxmPayServiceAction.DXM_DO_PAY, i3, "");
        } else {
            NaMethodStatUtils.statResult(EnterDxmPayServiceAction.DXM_DO_PAY, i3, str);
        }
        if (routerCallback != null) {
            HashMap hashMap = new HashMap();
            hashMap.put(EnterDxmPayServiceAction.SERVICE_STATUS_CODE, Integer.valueOf(i3));
            hashMap.put("payDesc", str);
            String assembleResult = BaiduPayDelegate.getInstance().assembleResult(hashMap, true);
            HashMap hashMap2 = new HashMap();
            hashMap2.put("result", assembleResult);
            routerCallback.onResult(i2, hashMap2);
        }
    }
}
