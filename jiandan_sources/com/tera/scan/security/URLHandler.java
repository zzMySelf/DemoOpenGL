package com.tera.scan.security;

import android.content.Context;
import com.getkeepsafe.relinker.ReLinker;
import com.tera.scan.framework.kernel.BaseApplication;
import com.tera.scan.utils.NoProguard;
import fe.mmm.qw.de.ad.qw.qw;
import fe.mmm.qw.yj.th;

public class URLHandler implements NoProguard {
    static {
        ReLinker.qw(BaseApplication.getInstance(), "scan-security");
        getSK();
        getDeviceID();
    }

    public static String getDeviceID() {
        return qw.f7750o;
    }

    public static String getSK() {
        return th.ppp().yj("net_param_sk");
    }

    public native String handlerURL(Context context, String str, String str2, String str3);
}
