package fe.fe.o.th;

import android.text.TextUtils;
import java.util.regex.Pattern;

/* renamed from: fe.fe.o.th.switch  reason: invalid class name */
public final class Cswitch {

    /* renamed from: ad  reason: collision with root package name */
    public static String f2693ad;
    public static String qw;

    public static boolean ad(String str) {
        if (TextUtils.isEmpty(qw)) {
            qw = "^http[s]?:\\/\\/(.*(gdown|appdown|app.dcdn)\\.baidu\\.com|.*baijincdn.cn)(:\\d+)?(\\/.*|)$";
        }
        return Pattern.matches(qw, str);
    }

    public static boolean de(String str) {
        if (TextUtils.isEmpty(f2693ad)) {
            f2693ad = "^http[s]?:\\/\\/(.*(gdown|appdown|app.dcdn)\\.baidu\\.com|.*baijincdn.cn)(:\\d+)?(\\/.*|)$";
        }
        return Pattern.matches(f2693ad, str);
    }

    public static void qw(String str, String str2) {
        qw = str;
        f2693ad = str2;
    }
}
