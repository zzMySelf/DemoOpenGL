package com.baidu.wallet.paysdk.entrance;

import android.content.Context;
import com.baidu.android.pay.PayCallBack;
import com.baidu.wallet.api.BaiduPayDelegate;
import com.baidu.wallet.router.RouterAction;
import com.baidu.wallet.router.RouterCallback;
import com.dxmpay.apollon.utils.LogUtil;
import com.dxmpay.wallet.paysdk.entrance.EnterDxmPayServiceAction;
import com.dxmpay.wallet.utils.BdWalletUtils;
import com.dxmpay.wallet.utils.NaMethodStatUtils;
import java.util.HashMap;

public class EnterWalletDoPayWithParamsAction implements RouterAction {
    public long a;

    public EnterWalletDoPayWithParamsAction() {
        BdWalletUtils.putFunctionNameList("dopay");
    }

    private void a(Context context, HashMap<String, String> hashMap, final boolean z, String str, final RouterCallback routerCallback) {
        BaiduPayDelegate.getInstance().doPay(context, str, new PayCallBack() {
            public boolean isHideLoadingDialog() {
                return z;
            }

            public void onPayResult(int i2, String str) {
                if (routerCallback != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(EnterDxmPayServiceAction.SERVICE_STATUS_CODE, Integer.valueOf(i2));
                    hashMap.put("payDesc", str);
                    routerCallback.onResult(0, hashMap);
                }
                NaMethodStatUtils.statResult("dopay", i2, "");
            }
        }, hashMap);
    }

    public void invoke(Context context, HashMap hashMap, RouterCallback routerCallback) {
        HashMap hashMap2;
        if (context != null && hashMap != null && hashMap.containsKey("showDialog") && (hashMap.get("showDialog") instanceof Boolean) && hashMap.containsKey("orderInfo") && (hashMap.get("orderInfo") instanceof String)) {
            boolean booleanValue = ((Boolean) hashMap.get("showDialog")).booleanValue();
            String str = (String) hashMap.get("orderInfo");
            if (!hashMap.containsKey("params") || !(hashMap.get("params") instanceof HashMap)) {
                hashMap2 = new HashMap();
            } else {
                hashMap2 = (HashMap) hashMap.get("params");
            }
            HashMap hashMap3 = hashMap2;
            if (!a()) {
                NaMethodStatUtils.statEnter("dopay", "");
            }
            a(context, hashMap3, booleanValue, str, routerCallback);
        } else if (routerCallback != null) {
            HashMap hashMap4 = new HashMap();
            hashMap4.put("errorMsg", "params-error");
            routerCallback.onResult(3, hashMap4);
        }
    }

    private boolean a() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - this.a;
        LogUtil.logd("timeD=" + j);
        if (0 < j && j < 800) {
            return true;
        }
        this.a = currentTimeMillis;
        return false;
    }
}
