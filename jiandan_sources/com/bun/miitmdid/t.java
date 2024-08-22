package com.bun.miitmdid;

import android.content.Context;
import androidx.annotation.Keep;
import com.heytap.openid.bean.OpenIDInfo;
import com.heytap.openid.sdk.OpenIDSDK;

@Keep
public class t extends n {
    @Keep
    public Context l;
    @Keep
    public OpenIDInfo m;

    public t(Context context) {
        this.l = context;
        Context a = a(context);
        this.l = a;
        OpenIDSDK.init(a);
        if (f0.a) {
            OpenIDSDK.setLoggable(true);
        }
    }

    @Keep
    public native g d();

    @Keep
    public native void doStart();

    @Keep
    public final native void e();
}
