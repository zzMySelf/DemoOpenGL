package fe.fe.ddd.p000if;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import fe.fe.ddd.p000if.yj.de;

/* renamed from: fe.fe.ddd.if.fe  reason: invalid package */
public class fe {
    public static String ad(@NonNull String str, @NonNull String str2) {
        if (TextUtils.isEmpty(str)) {
            str = "default";
        }
        String str3 = str2 + str;
        return str3.length() > 256 ? str3.substring(0, 255) : str3;
    }

    public static void de(@NonNull Runnable runnable, @NonNull String str, int i2) {
        qw(runnable, str, i2, 0);
    }

    public static void qw(@NonNull Runnable runnable, @NonNull String str, int i2, long j) {
        int i3;
        if (runnable != null) {
            if (i2 == 0 || i2 == 1 || i2 == 2 || i2 == 3) {
                i3 = i2;
            } else {
                "illegal priority " + i2;
                i3 = 3;
            }
            de.yj();
            if (de.de()) {
                ad.qw().de(runnable, j);
                return;
            }
            de.m70switch().nn(runnable, ad(str, "elastic_"), i3, j);
        }
    }
}
