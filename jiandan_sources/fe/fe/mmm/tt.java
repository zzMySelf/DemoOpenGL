package fe.fe.mmm;

import android.content.Context;
import android.os.IBinder;
import android.text.TextUtils;
import com.baidu.ubc.IUBCABTest;
import com.baidu.ubc.IUBCContext;
import com.baidu.ubc.IUBCUploader;
import com.baidu.ubc.inter.IAppConfigService;
import com.baidu.ubc.inter.IExternalService;
import com.baidu.ubc.inter.IIPCService;
import com.baidu.ubc.inter.IUBCLogIdSpService;
import fe.fe.mmm.s.rg;

public class tt {
    public static Context ad() {
        IAppConfigService qw = rg.qw();
        if (qw != null) {
            return qw.th();
        }
        return null;
    }

    public static void ddd(String str, long j) {
        IAppConfigService qw = rg.qw();
        if (qw != null) {
            qw.putLong(str, j);
        }
    }

    public static String de(String str) {
        IAppConfigService qw = rg.qw();
        return qw != null ? qw.ad(str) : str;
    }

    public static int fe() {
        IAppConfigService qw = rg.qw();
        if (qw != null) {
            return qw.rg();
        }
        return 0;
    }

    public static boolean ggg() {
        IExternalService ad2 = rg.ad();
        if (ad2 != null) {
            return ad2.qw();
        }
        return false;
    }

    public static String i() {
        IAppConfigService qw = rg.qw();
        if (qw == null) {
            return "";
        }
        String yj2 = qw.yj();
        return !TextUtils.isEmpty(yj2) ? yj2 : "";
    }

    /* renamed from: if  reason: not valid java name */
    public static IUBCContext m142if() {
        return rg.th();
    }

    public static void mmm(int i2) {
        IAppConfigService qw = rg.qw();
        if (qw != null) {
            qw.qw(i2);
        }
    }

    public static void nn(String str, String str2) {
        IAppConfigService qw = rg.qw();
        if (qw != null) {
            qw.putString(str, str2);
        }
    }

    public static String o(String str, String str2) {
        IAppConfigService qw = rg.qw();
        return qw != null ? qw.getString(str, str2) : str2;
    }

    public static IUBCABTest pf() {
        return rg.rg();
    }

    public static String ppp(boolean z) {
        IAppConfigService qw = rg.qw();
        return qw != null ? qw.fe(z) : "";
    }

    public static void qw() {
        IIPCService de2 = rg.de();
        if (de2 != null) {
            de2.qw();
        }
    }

    public static IBinder rg(String str) {
        IIPCService de2 = rg.de();
        if (de2 != null) {
            return de2.ad(str);
        }
        return null;
    }

    /* renamed from: switch  reason: not valid java name */
    public static IUBCLogIdSpService m143switch() {
        return rg.yj();
    }

    public static int th(String str, int i2) {
        IAppConfigService qw = rg.qw();
        return qw != null ? qw.getInt(str, i2) : i2;
    }

    public static String uk(String str) {
        IAppConfigService qw = rg.qw();
        return qw != null ? qw.uk(str) : str;
    }

    public static boolean vvv() {
        IAppConfigService qw = rg.qw();
        if (qw != null) {
            return qw.de();
        }
        return false;
    }

    public static IUBCUploader when() {
        return rg.uk();
    }

    public static void xxx(String str, int i2) {
        IAppConfigService qw = rg.qw();
        if (qw != null) {
            qw.putInt(str, i2);
        }
    }

    public static long yj(String str, long j) {
        IAppConfigService qw = rg.qw();
        return qw != null ? qw.getLong(str, j) : j;
    }
}
