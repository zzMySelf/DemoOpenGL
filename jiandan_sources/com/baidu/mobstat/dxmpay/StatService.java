package com.baidu.mobstat.dxmpay;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import fe.fe.p007switch.qw.ad;
import fe.fe.p007switch.qw.eee;
import fe.fe.p007switch.qw.qqq;
import fe.fe.p007switch.qw.uk;
import java.util.List;

public class StatService {
    public static boolean qw = false;

    public interface OnZidReceiveListener {
    }

    public interface WearListener {
        boolean qw(String str);
    }

    public static boolean ad(Context context) {
        String c = qqq.c(context);
        return !TextUtils.isEmpty(c) && c.contains("helios");
    }

    public static boolean de(Context context, String str) {
        if (context != null) {
            return true;
        }
        h o2 = h.o();
        o2.th("[WARNING] " + str + ", context is null, invalid");
        return false;
    }

    public static void fe(boolean z) {
        ExceptionAnalysis.de().uk(z);
    }

    public static void i(boolean z) {
        h.o().i(z);
    }

    /* renamed from: if  reason: not valid java name */
    public static void m29if(Context context, String str) {
        if (context != null && !ad(context)) {
            CooperService.qqq().a(context, str);
            ad.m207if().pf(context);
        }
    }

    public static void o(List<String> list) {
        if (list != null && list.size() > 0) {
            ExceptionAnalysis.de().i(list);
        }
    }

    public static void pf(Context context, int i2) {
        if (de(context, "setOn(...)") && !qw && !ad(context)) {
            qw = true;
            if ((i2 & 1) != 0) {
                qw(context, false);
            } else if ((i2 & 16) != 0) {
                qw(context, true);
            }
            ad.m207if().pf(context);
        }
    }

    public static void qw(Context context, boolean z) {
        if (de(context, "onError(...)") && !ad(context)) {
            ad.m207if().pf(context);
            ExceptionAnalysis.de().fe(context.getApplicationContext(), z);
        }
    }

    @Deprecated
    public static void rg(String str) {
        uk.ad(str);
    }

    /* renamed from: switch  reason: not valid java name */
    public static void m30switch(Context context) {
        if (de(context, "start(...)")) {
            boolean ad2 = eee.ad(Application.class, "onCreate");
            if (ad2) {
                h.o().uk("[WARNING] start 方法被 Application.onCreate()调用，not a good practice; 可能由于多进程反复重启等原因造成Application.onCreate() 方法多次被执行，导致启动次数高；建议埋点在统计路径触发的第一个页面中，比如APP主页面中");
            }
            if (!ad(context)) {
                ad.m207if().m208switch(context, ad2);
            }
        }
    }

    public static void th(String str) {
        uk.de(str);
    }

    public static void uk(String str) {
        ExceptionAnalysis.de().yj(str);
    }

    public static void yj(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (str.length() > 256) {
                str = str.substring(0, 256);
            }
            CooperService.qqq().rrr(context, str);
        }
    }
}
