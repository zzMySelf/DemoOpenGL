package com.baidu.wallet.paysdk.presenter;

import com.baidu.wallet.newbindcard.b.b;
import com.baidu.wallet.paysdk.ui.PayBaseBeanActivity;

public final class g {
    public static k a(int i2, PayBaseBeanActivity payBaseBeanActivity) {
        if (i2 == 1) {
            return new i(payBaseBeanActivity);
        }
        if (i2 == 3) {
            return new j(payBaseBeanActivity);
        }
        if (i2 != 5) {
            return null;
        }
        return new b(payBaseBeanActivity);
    }
}
