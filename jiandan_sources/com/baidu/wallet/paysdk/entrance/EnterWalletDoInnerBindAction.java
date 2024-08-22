package com.baidu.wallet.paysdk.entrance;

import android.content.Context;
import com.baidu.android.pay.BindBack;
import com.baidu.wallet.api.BaiduPayDelegate;
import com.baidu.wallet.router.RouterAction;
import com.baidu.wallet.router.RouterCallback;
import com.dxmpay.wallet.paysdk.entrance.EnterDxmPayServiceAction;
import com.dxmpay.wallet.utils.BdWalletUtils;
import com.dxmpay.wallet.utils.NaMethodStatUtils;
import java.util.HashMap;

public class EnterWalletDoInnerBindAction implements RouterAction {
    public EnterWalletDoInnerBindAction() {
        BdWalletUtils.putFunctionNameList("doBindCard");
    }

    private void a(Context context, final boolean z, String str, final RouterCallback routerCallback) {
        BaiduPayDelegate.getInstance().doInnerBind(context, new BindBack() {
            public boolean isHideLoadingDialog() {
                return z;
            }

            public void onBindResult(int i2, String str) {
                if (routerCallback != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("ret", Integer.valueOf(i2));
                    hashMap.put("msg", str);
                    String assembleResult = BaiduPayDelegate.getInstance().assembleResult(hashMap, true);
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put(EnterDxmPayServiceAction.SERVICE_STATUS_CODE, Integer.valueOf(i2));
                    hashMap2.put("params", assembleResult);
                    routerCallback.onResult(0, hashMap2);
                }
                NaMethodStatUtils.statResult("doBindCard", i2, "");
            }
        }, new HashMap(), str);
    }

    public void invoke(Context context, HashMap hashMap, RouterCallback routerCallback) {
        if (context != null && hashMap != null && hashMap.containsKey("showDialog") && (hashMap.get("showDialog") instanceof Boolean) && hashMap.containsKey("orderInfo") && (hashMap.get("orderInfo") instanceof String)) {
            boolean booleanValue = ((Boolean) hashMap.get("showDialog")).booleanValue();
            NaMethodStatUtils.statEnter("doBindCard", "");
            a(context, booleanValue, (String) hashMap.get("orderInfo"), routerCallback);
        } else if (routerCallback != null) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put("errorMsg", "params-error");
            routerCallback.onResult(3, hashMap2);
        }
    }
}
