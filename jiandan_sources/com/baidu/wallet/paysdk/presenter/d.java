package com.baidu.wallet.paysdk.presenter;

import com.baidu.wallet.paysdk.ui.AuthorizeSignActivity;

public class d {

    public static class a {
        public static d a = new d();
    }

    public static d a() {
        return a.a;
    }

    public d() {
    }

    public e a(int i2, AuthorizeSignActivity authorizeSignActivity) {
        if (i2 == 1) {
            return new b(authorizeSignActivity);
        }
        if (i2 != 2) {
            return null;
        }
        return new c(authorizeSignActivity);
    }
}
