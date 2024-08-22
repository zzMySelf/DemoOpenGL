package fe.fe.ppp.ad;

import android.util.Log;
import com.baidu.pass.a;

public class qw implements a {

    /* renamed from: ad  reason: collision with root package name */
    public static boolean f2991ad = false;

    public static void ad(String str, Throwable th2) {
        de(str, th2);
    }

    public static void de(String str, Object... objArr) {
        if (f2991ad) {
            qw(str, objArr);
        }
    }

    public static void fe(Throwable th2) {
        ad("PASSPORT", th2);
    }

    public static String qw(String str, Object[] objArr) {
        if (objArr == null) {
            return "";
        }
        try {
            if (objArr.length == 0) {
                return "";
            }
            StringBuffer stringBuffer = new StringBuffer();
            int length = objArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                Throwable th2 = objArr[i2];
                if (th2 != null) {
                    if (i2 != 0) {
                        stringBuffer.append("|");
                    }
                    try {
                        if (th2 instanceof Throwable) {
                            stringBuffer.append(Log.getStackTraceString(th2));
                        } else {
                            stringBuffer.append(th2.toString());
                        }
                    } catch (Exception unused) {
                    }
                }
            }
            return stringBuffer.toString();
        } catch (Throwable th3) {
            "converArrayToString t: " + th3.toString();
            return "converArrayToString null";
        }
    }

    public static void rg(String str, Object... objArr) {
        if (f2991ad) {
            qw(str, objArr);
        }
    }
}
