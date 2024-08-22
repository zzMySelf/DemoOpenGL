package com.baidu.wallet.paysdk.sms.controller;

import android.content.Context;
import com.baidu.wallet.router.LocalRouter;
import com.baidu.wallet.router.RouterCallback;
import com.baidu.wallet.router.RouterRequest;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import java.util.Collection;
import java.util.HashMap;

public class g {
    public static ISmsController a(int i2) {
        if (i2 != 0) {
            if (i2 == 1) {
                return new d();
            }
            if (i2 == 6) {
                final ISmsController[] iSmsControllerArr = {null};
                LocalRouter.getInstance((Context) null).route((Context) null, new RouterRequest().provider("hce").action("getsmscontroller"), new RouterCallback() {
                    public void onResult(int i2, HashMap hashMap) {
                        if (i2 == 0 || hashMap != null) {
                            Object obj = hashMap.get("value");
                            if (obj != null && (obj instanceof ISmsController)) {
                                iSmsControllerArr[0] = (ISmsController) obj;
                            }
                        } else if (i2 == 5) {
                            HashMap hashMap2 = new HashMap();
                            hashMap2.put("provider", "hce");
                            hashMap2.put("action", "getsmscontroller");
                            StatisticManager.onEventEndWithValues("sdk_router_error", i2, (Collection<String>) hashMap2.values());
                        }
                    }
                });
                return iSmsControllerArr[0];
            } else if (i2 != 7) {
                if (i2 == 8 || i2 == 10) {
                    return new b();
                }
                return null;
            }
        }
        return new c();
    }
}
