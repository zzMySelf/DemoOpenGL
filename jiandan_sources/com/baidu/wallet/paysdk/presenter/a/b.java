package com.baidu.wallet.paysdk.presenter.a;

import com.baidu.wallet.paysdk.contract.a;

public class b {
    public static a.C0164a a(int i2, a.b bVar) {
        if (i2 == 1) {
            return new d(bVar);
        }
        if (i2 == 2) {
            return new a(bVar);
        }
        if (i2 != 3) {
            return null;
        }
        return new c(bVar);
    }
}
