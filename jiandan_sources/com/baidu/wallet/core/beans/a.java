package com.baidu.wallet.core.beans;

import android.content.Context;
import com.baidu.apollon.restnet.rest.RestHttpRequestInterceptor;
import com.baidu.apollon.restnet.rest.d;
import com.baidu.wallet.utils.Identifier;

public class a implements RestHttpRequestInterceptor {
    public static final String a = "X-Requested-Session-ID";
    public static final String b = "X-Domain-From-Config";
    public boolean c = false;

    public a(boolean z) {
        this.c = z;
    }

    public void intercept(Context context, d dVar) {
        if (!(dVar == null || dVar.a() == null)) {
            dVar.a().a(a, Identifier.sessionID());
        }
        dVar.a().a(b, this.c ? "1" : "0");
    }
}
