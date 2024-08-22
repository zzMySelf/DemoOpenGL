package com.baidu.wallet.paysdk.entrance;

import android.content.Context;
import com.baidu.wallet.api.BaiduPayDelegate;
import com.baidu.wallet.rnauth.RNAuthCallBack;
import com.baidu.wallet.router.RouterAction;
import com.baidu.wallet.router.RouterCallback;
import com.dxmpay.wallet.paysdk.entrance.EnterDxmPayServiceAction;
import com.dxmpay.wallet.utils.BdWalletUtils;
import com.dxmpay.wallet.utils.NaMethodStatUtils;
import java.util.HashMap;

public class EnterWalletDoRnAuthAction implements RouterAction {
    public EnterWalletDoRnAuthAction() {
        BdWalletUtils.putFunctionNameList("doRnAuth");
    }

    private void a(Context context, HashMap<String, String> hashMap, final RouterCallback routerCallback) {
        BaiduPayDelegate.getInstance().doRNAuth(context, hashMap, new RNAuthCallBack() {
            public void onRNAuthResult(int i2, String str) {
                if (routerCallback != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(EnterDxmPayServiceAction.SERVICE_STATUS_CODE, Integer.valueOf(i2));
                    hashMap.put("authDesc", str);
                    routerCallback.onResult(0, hashMap);
                }
                NaMethodStatUtils.statResult("doRnAuth", i2, "");
            }
        });
    }

    public void invoke(Context context, HashMap hashMap, RouterCallback routerCallback) {
        if (context != null && hashMap != null) {
            a(context, hashMap, routerCallback);
            NaMethodStatUtils.statEnter("doRnAuth", "");
        } else if (routerCallback != null) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put("errorMsg", "params-error");
            routerCallback.onResult(3, hashMap2);
        }
    }
}
