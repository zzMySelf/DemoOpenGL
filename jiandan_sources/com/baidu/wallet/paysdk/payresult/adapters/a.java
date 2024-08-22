package com.baidu.wallet.paysdk.payresult.adapters;

import com.baidu.wallet.paysdk.api.BaiduPay;
import com.dxmpay.wallet.core.BaseActivity;

public class a {
    public static IPayResultDataAdapter a(BaseActivity baseActivity, int i2) {
        if (i2 == 1) {
            return new PayResultAdapter(baseActivity);
        }
        if (i2 != 4) {
            return null;
        }
        try {
            return new SignContractPayResultAdapter(baseActivity);
        } catch (Throwable th2) {
            th2.getMessage();
            return null;
        }
    }

    public static IPayResultDataAdapter a(BaseActivity baseActivity, String str) {
        try {
            if (BaiduPay.PAY_FROM_BIND_CARD.equalsIgnoreCase(str)) {
                return new ActivieBindCardResultAdapter(baseActivity);
            }
            return null;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }
}
