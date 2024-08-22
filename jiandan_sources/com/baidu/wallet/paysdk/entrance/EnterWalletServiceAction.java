package com.baidu.wallet.paysdk.entrance;

import android.content.Context;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.wallet.BaiduPayServiceController;
import com.baidu.wallet.lightapp.base.LightappConstants;
import com.baidu.wallet.router.RouterAction;
import com.baidu.wallet.router.RouterCallback;
import com.dxmpay.wallet.paysdk.entrance.EnterDxmPayServiceAction;
import com.dxmpay.wallet.utils.BdWalletUtils;
import com.dxmpay.wallet.utils.NaMethodStatUtils;
import java.util.HashMap;

public class EnterWalletServiceAction implements RouterAction {
    public EnterWalletServiceAction() {
        BdWalletUtils.putFunctionNameList(EnterDxmPayServiceAction.DXM_BANK_CARD, EnterDxmPayServiceAction.DXM_TRANS_RECORDS, EnterDxmPayServiceAction.DXM_SECURITY_CENTER, EnterDxmPayServiceAction.DXM_PAY_SET, EnterDxmPayServiceAction.DXM_PWD_SET, EnterDxmPayServiceAction.DXM_CHECK_PWD, EnterDxmPayServiceAction.DXM_DO_SCAN_CODE, EnterDxmPayServiceAction.DXM_BALANCE);
    }

    private void a(Context context, String str, String str2, boolean z) {
        BaiduPayServiceController.getInstance().gotoWalletService(context, str, str2, z);
    }

    public void invoke(Context context, HashMap hashMap, RouterCallback routerCallback) {
        if (context != null && hashMap != null && hashMap.containsKey("withAnim") && (hashMap.get("withAnim") instanceof String)) {
            String str = (String) hashMap.get(LightappConstants.ACCESS_WALLET_SERVICE_PARAM_SERVICE);
            a(context, str, (String) hashMap.get(SapiAccount.SAPI_ACCOUNT_EXTRA), Boolean.parseBoolean((String) hashMap.get("withAnim")));
            if (routerCallback != null) {
                HashMap hashMap2 = new HashMap();
                hashMap2.put("desc", SmsLoginView.f.k);
                routerCallback.onResult(0, hashMap2);
            }
            NaMethodStatUtils.statEnter("gotoWalletService", str);
            NaMethodStatUtils.statResult("gotoWalletService", 0, "");
        } else if (routerCallback != null) {
            HashMap hashMap3 = new HashMap();
            hashMap3.put("errorMsg", "params-error");
            routerCallback.onResult(3, hashMap3);
        }
    }
}
