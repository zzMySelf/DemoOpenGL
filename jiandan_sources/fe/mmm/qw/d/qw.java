package fe.mmm.qw.d;

import android.content.Context;
import fe.mmm.qw.d.fe.th;

public class qw {

    /* renamed from: ad  reason: collision with root package name */
    public static boolean f7702ad = false;

    /* renamed from: de  reason: collision with root package name */
    public static boolean f7703de = false;
    public static boolean qw = false;

    public static String ad(Context context) {
        return th.de(context, "skin_custom_path", "skin_default");
    }

    public static boolean de() {
        return f7702ad;
    }

    public static boolean fe() {
        return qw;
    }

    public static void i(boolean z) {
        f7702ad = z;
    }

    public static void o(boolean z) {
        qw = z;
    }

    public static void qw() {
        f7703de = true;
    }

    public static boolean rg(Context context) {
        return "skin_default".equals(ad(context));
    }

    public static boolean th() {
        return f7703de;
    }

    public static void uk(Context context, String str) {
        th.fe(context, "skin_custom_path", str);
    }

    public static boolean yj(Context context) {
        return th.qw(context, "dark_skin_download_enabled", false);
    }
}
