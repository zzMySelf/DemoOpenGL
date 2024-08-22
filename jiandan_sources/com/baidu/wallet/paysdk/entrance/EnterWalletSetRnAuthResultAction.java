package com.baidu.wallet.paysdk.entrance;

import android.content.Context;
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.wallet.paysdk.api.BaiduPay;
import com.baidu.wallet.rnauth.RNAuthCallBack;
import com.baidu.wallet.router.RouterAction;
import com.baidu.wallet.router.RouterCallback;
import com.dxmpay.wallet.paysdk.entrance.EnterDxmPayServiceAction;
import com.dxmpay.wallet.utils.BdWalletUtils;
import com.dxmpay.wallet.utils.NaMethodStatUtils;
import java.util.HashMap;

public class EnterWalletSetRnAuthResultAction implements RouterAction {
    public EnterWalletSetRnAuthResultAction() {
        BdWalletUtils.putFunctionNameList("setRnAuthResult");
    }

    private void a(int i2, String str) {
        RNAuthCallBack rNAuthBack = BaiduPay.getInstance().getRNAuthBack();
        if (rNAuthBack != null) {
            rNAuthBack.onRNAuthResult(i2, str);
            BaiduPay.getInstance().clearRNAuthBack();
        }
    }

    public void invoke(Context context, HashMap hashMap, RouterCallback routerCallback) {
        HashMap hashMap2 = new HashMap();
        if (hashMap != null && hashMap.containsKey(EnterDxmPayServiceAction.SERVICE_STATUS_CODE) && (hashMap.get(EnterDxmPayServiceAction.SERVICE_STATUS_CODE) instanceof Integer) && hashMap.containsKey("desc")) {
            a(((Integer) hashMap.get(EnterDxmPayServiceAction.SERVICE_STATUS_CODE)).intValue(), (String) hashMap.get("desc"));
            if (routerCallback != null) {
                hashMap2.put("desc", SmsLoginView.f.k);
                routerCallback.onResult(0, hashMap2);
            }
            NaMethodStatUtils.statEnter("setRnAuthResult", "");
            NaMethodStatUtils.statResult("setRnAuthResult", 0, "");
        } else if (routerCallback != null) {
            hashMap2.put("errorMsg", "params-error");
            routerCallback.onResult(3, hashMap2);
        }
    }
}
