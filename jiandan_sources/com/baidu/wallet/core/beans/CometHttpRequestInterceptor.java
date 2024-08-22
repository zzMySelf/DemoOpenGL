package com.baidu.wallet.core.beans;

import android.content.Context;
import com.baidu.apollon.restnet.rest.d;

public class CometHttpRequestInterceptor extends EbpayHttpRequestInterceptor {
    public static final int a = 60000;
    public static final String b = "CometHttpRequestInterceptor";

    public void intercept(Context context, d dVar) {
        super.intercept(context, dVar);
        dVar.a((int) a);
    }
}
