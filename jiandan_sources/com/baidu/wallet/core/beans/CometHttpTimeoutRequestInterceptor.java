package com.baidu.wallet.core.beans;

import android.content.Context;
import com.baidu.apollon.restnet.rest.d;
import com.baidu.wallet.core.NoProguard;
import com.baidu.wallet.core.utils.LogUtil;

public class CometHttpTimeoutRequestInterceptor extends EbpayHttpRequestInterceptor implements NoProguard {
    public static final int COMET_HTTP_TIMEOUT = 2000;
    public static final int COMET_MIX_TIMEOUT = 200;
    public static final String TAG = "CometHttpRequestInterceptor";
    public int mTimeout;

    public CometHttpTimeoutRequestInterceptor(int i2) {
        this.mTimeout = i2;
    }

    public void intercept(Context context, d dVar) {
        int i2;
        super.intercept(context, dVar);
        int i3 = this.mTimeout;
        if (i3 <= 0) {
            i2 = 2000;
        } else {
            i2 = Math.max(i3, 200);
        }
        LogUtil.d("CometHttpRequestInterceptor", "CustomInterceptors,timeout：" + i2);
        dVar.a(i2);
    }
}
