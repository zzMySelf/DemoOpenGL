package com.baidu.wallet.paysdk.ui.a;

import android.content.Context;
import com.baidu.wallet.paysdk.contract.a;

public class b {

    public static class a {
        public static b a = new b();
    }

    public static b a() {
        return a.a;
    }

    public b() {
    }

    public a.b a(int i2, Context context) {
        if (i2 == 1) {
            return new d(context);
        }
        if (i2 == 2) {
            return new a(context);
        }
        if (i2 != 3) {
            return null;
        }
        return new c(context);
    }
}
