package fe.fe.nn.ppp;

import android.content.Context;
import android.text.TextUtils;
import fe.fe.nn.qw.qw;

public final class fe {

    /* renamed from: ad  reason: collision with root package name */
    public static String f2304ad = null;
    public static String qw = "";

    public static String ad(Context context) {
        try {
            if (!TextUtils.isEmpty(f2304ad)) {
                return f2304ad;
            }
            String de2 = de(context);
            f2304ad = de2;
            if (!TextUtils.isEmpty(de2)) {
                return f2304ad;
            }
            String qw2 = new fe.fe.nn.qw.fe(context).qw();
            f2304ad = qw2;
            if (!TextUtils.isEmpty(qw2)) {
                return f2304ad;
            }
            return "";
        } catch (Throwable th2) {
            de.fe(th2);
            return "";
        }
    }

    public static String de(Context context) {
        try {
            Class<?> cls = Class.forName("com.baidu.sofire.ac.F");
            Object invoke = cls.getDeclaredMethod("getInstance", new Class[0]).invoke(cls, new Object[0]);
            if (invoke == null) {
                return "";
            }
            return (String) cls.getDeclaredMethod("gzd", new Class[]{Context.class}).invoke(invoke, new Object[]{context});
        } catch (Throwable th2) {
            de.fe(th2);
            return "";
        }
    }

    public static String qw(Context context) {
        try {
            if (!TextUtils.isEmpty(qw)) {
                return qw;
            }
            qw = qw.uk(context).f();
            return qw;
        } catch (Throwable th2) {
            de.fe(th2);
        }
    }
}
