package com.alipay.sdk.m.c;

import android.content.Context;
import com.alipay.sdk.m.b.b;
import com.alipay.sdk.m.h0.a;

public class f implements b {
    public boolean a = false;

    public String a(Context context) {
        if (context == null) {
            return null;
        }
        if (!this.a) {
            a.e(context);
            this.a = true;
        }
        boolean a2 = a.a();
        com.alipay.sdk.m.d.a.b("getOAID", "isSupported", Boolean.valueOf(a2));
        if (!a2) {
            return null;
        }
        return a.b(context);
    }
}
