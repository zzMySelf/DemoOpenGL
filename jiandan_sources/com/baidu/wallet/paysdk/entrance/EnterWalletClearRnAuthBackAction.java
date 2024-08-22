package com.baidu.wallet.paysdk.entrance;

import android.content.Context;
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.wallet.paysdk.api.BaiduPay;
import com.baidu.wallet.router.RouterAction;
import com.baidu.wallet.router.RouterCallback;
import com.dxmpay.wallet.paysdk.entrance.EnterDxmPayServiceAction;
import com.dxmpay.wallet.utils.BdWalletUtils;
import java.util.HashMap;

public class EnterWalletClearRnAuthBackAction implements RouterAction {
    public EnterWalletClearRnAuthBackAction() {
        BdWalletUtils.putFunctionNameList(EnterDxmPayServiceAction.DXM_CLEAR_RN_AUTH);
    }

    public void invoke(Context context, HashMap hashMap, RouterCallback routerCallback) {
        BaiduPay.getInstance().clearRNAuthBack();
        if (routerCallback != null) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put("desc", SmsLoginView.f.k);
            routerCallback.onResult(0, hashMap2);
        }
    }
}
