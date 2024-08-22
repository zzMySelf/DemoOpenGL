package fe.mmm.qw.de.ad.qw;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;

public class qw {

    /* renamed from: ad  reason: collision with root package name */
    public static String f7746ad = null;

    /* renamed from: de  reason: collision with root package name */
    public static int f7747de = 0;

    /* renamed from: fe  reason: collision with root package name */
    public static String f7748fe = null;

    /* renamed from: i  reason: collision with root package name */
    public static String f7749i = null;

    /* renamed from: if  reason: not valid java name */
    public static String f329if = null;

    /* renamed from: o  reason: collision with root package name */
    public static String f7750o = "";

    /* renamed from: pf  reason: collision with root package name */
    public static long f7751pf = 0;
    public static Application qw = null;

    /* renamed from: rg  reason: collision with root package name */
    public static String f7752rg = null;

    /* renamed from: switch  reason: not valid java name */
    public static String f330switch = null;

    /* renamed from: th  reason: collision with root package name */
    public static String f7753th = null;

    /* renamed from: uk  reason: collision with root package name */
    public static String f7754uk = null;
    public static String when = "JSbridge4.4.0";

    /* renamed from: yj  reason: collision with root package name */
    public static String f7755yj;

    public static Application ad() {
        return qw;
    }

    public static void de(Application application) {
        qw = application;
    }

    public static void fe(Application application, String str, String str2, long j, String str3, String str4) {
        qw(application);
        f7755yj = application.getPackageName();
        f7752rg = str;
        f7753th = str2;
        f7751pf = j;
        when = str3;
        f7754uk = str4;
        String str5 = Build.BRAND;
    }

    public static void qw(Application application) {
        try {
            PackageInfo packageInfo = application.getPackageManager().getPackageInfo(application.getPackageName(), 0);
            String str = packageInfo.versionName;
            if (!TextUtils.isEmpty(str)) {
                f7746ad = str;
            }
            int i2 = packageInfo.versionCode;
            if (i2 != -1) {
                f7747de = i2;
            }
        } catch (Exception e) {
            fe.mmm.qw.i.qw.th("VersionInfo", "Exception", e);
        }
    }
}
