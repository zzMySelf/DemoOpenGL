package fe.mmm.qw.p024if.pf.de;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.m.s.a;
import com.tera.scan.framework.framework.FrameworkAccount;
import com.tera.scan.network.network.request.RequestCommonParams;
import fe.mmm.qw.de.ad.qw.qw;
import fe.mmm.qw.j.vvv.fe;
import fe.mmm.qw.th.qw.th.o;

/* renamed from: fe.mmm.qw.if.pf.de.ad  reason: invalid package */
public final class ad {
    public static String ad(Context context) {
        return qw.f7750o;
    }

    public static String de() {
        return null;
    }

    public static String fe() {
        return fe.mmm.qw.nn.ad.qw.qw.qw.fe();
    }

    public static boolean i(Context context) {
        return false;
    }

    /* renamed from: if  reason: not valid java name */
    public static boolean m974if(String str, int i2) {
        if (i2 == 1) {
            o.fe((Context) null, str);
        } else {
            o.uk(str);
        }
        return true;
    }

    public static String o(String str, int i2) {
        if (i2 == 0) {
            return fe.mmm.qw.j.vvv.qw.rg(fe.rg(str, "UTF-8"));
        }
        if (i2 == 1) {
            return new String(fe.qw(fe.mmm.qw.j.vvv.qw.de(str)));
        }
        return null;
    }

    public static void pf(String str, String str2) {
    }

    public static String qw(Context context, String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            fe.mmm.qw.nn.de.o.ad adVar = new fe.mmm.qw.nn.de.o.ad();
            FrameworkAccount qw = fe.mmm.qw.p030switch.rg.qw.qw();
            String str3 = null;
            if (qw != null) {
                str3 = qw.getBduss();
            }
            fe.mmm.qw.rg.qw.de.qw.qw.qw.qw(context, str3, str, adVar);
            if (!str.contains("?")) {
                str2 = str + "?";
            } else {
                if (!str.endsWith("?")) {
                    str2 = str + a.n;
                }
                return str + adVar.toString();
            }
            str = str2;
            return str + adVar.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    public static String rg() {
        return qw.f7750o;
    }

    public static String th() {
        return null;
    }

    public static String uk() {
        return RequestCommonParams.o();
    }

    public static String yj() {
        return null;
    }
}
