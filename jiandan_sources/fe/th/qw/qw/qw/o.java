package fe.th.qw.qw.qw;

import android.content.Context;
import android.util.DisplayMetrics;

public final class o {
    public static DisplayMetrics qw;

    public static int ad(Context context) {
        de(context);
        return qw.widthPixels;
    }

    public static void de(Context context) {
        if (qw == null) {
            qw = context.getResources().getDisplayMetrics();
        }
    }

    public static int qw(Context context) {
        de(context);
        return qw.heightPixels;
    }
}
