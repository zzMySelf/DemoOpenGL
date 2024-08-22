package fe.i.qw.rg;

import android.content.Context;
import android.os.Build;
import androidx.annotation.NonNull;

public final class qw {
    public static final de qw;

    public static class ad extends de {
        public ad() {
            super();
        }

        public String ad(String str) {
            return ad.ad(str);
        }

        public int qw(Context context, String str, String str2) {
            return ad.qw(context, str, str2);
        }
    }

    public static class de {
        public de() {
        }

        public String ad(String str) {
            return null;
        }

        public int qw(Context context, String str, String str2) {
            return 1;
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 23) {
            qw = new ad();
        } else {
            qw = new de();
        }
    }

    public static String ad(@NonNull String str) {
        return qw.ad(str);
    }

    public static int qw(@NonNull Context context, @NonNull String str, @NonNull String str2) {
        return qw.qw(context, str, str2);
    }
}
