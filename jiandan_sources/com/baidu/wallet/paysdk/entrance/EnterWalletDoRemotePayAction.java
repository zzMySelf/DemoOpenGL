package com.baidu.wallet.paysdk.entrance;

import android.content.Context;
import com.baidu.android.pay.PayCallBack;
import com.baidu.wallet.api.BaiduPayDelegate;
import com.baidu.wallet.router.RouterAction;
import com.baidu.wallet.router.RouterCallback;
import com.dxmpay.wallet.paysdk.entrance.EnterDxmPayServiceAction;
import com.dxmpay.wallet.utils.BdWalletUtils;
import com.dxmpay.wallet.utils.NaMethodStatUtils;
import java.util.HashMap;

public class EnterWalletDoRemotePayAction implements RouterAction {
    public EnterWalletDoRemotePayAction() {
        BdWalletUtils.putFunctionNameList("doRemotePay");
    }

    private void a(Context context, String str, final boolean z, HashMap<String, String> hashMap, final RouterCallback routerCallback) {
        BaiduPayDelegate.getInstance().doRemotePay(context, str, new PayCallBack() {
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
                NaMethodStatUtils.statResult("doRemotePay", i2, "");
            }
        }, hashMap);
    }

    public void invoke(Context context, HashMap hashMap, RouterCallback routerCallback) {
        HashMap hashMap2;
        if (context != null && hashMap != null && hashMap.containsKey("showDialog") && (hashMap.get("showDialog") instanceof Boolean) && hashMap.containsKey("orderInfo") && (hashMap.get("orderInfo") instanceof String)) {
            NaMethodStatUtils.statEnter("doRemotePay", "");
            boolean booleanValue = ((Boolean) hashMap.get("showDialog")).booleanValue();
            String str = (String) hashMap.get("orderInfo");
            if (!hashMap.containsKey("params") || !(hashMap.get("params") instanceof HashMap)) {
                hashMap2 = new HashMap();
            } else {
                hashMap2 = (HashMap) hashMap.get("params");
            }
            a(context, str, booleanValue, hashMap2, routerCallback);
        } else if (routerCallback != null) {
            HashMap hashMap3 = new HashMap();
            hashMap3.put("errorMsg", "params-error");
            routerCallback.onResult(3, hashMap3);
        }
    }
}
