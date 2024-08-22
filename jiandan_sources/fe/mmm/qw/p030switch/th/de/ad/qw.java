package fe.mmm.qw.p030switch.th.de.ad;

import android.content.Context;
import android.content.res.Configuration;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import fe.mmm.qw.p030switch.rg.ad;

/* renamed from: fe.mmm.qw.switch.th.de.ad.qw  reason: invalid package */
public class qw {

    /* renamed from: ad  reason: collision with root package name */
    public static volatile DisplayMetrics f8322ad = null;
    public static float qw = 1.0f;

    public static float ad() {
        return qw;
    }

    public static int de(int i2) {
        return (int) (((float) i2) * qw);
    }

    public static int fe() {
        int i2 = f8322ad != null ? f8322ad.heightPixels : 0;
        return i2 == 0 ? ad.qw().qw("display_screen_height", 0) : i2;
    }

    public static int qw(Context context, float f) {
        return context == null ? (int) f : (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int rg() {
        int i2 = f8322ad != null ? f8322ad.widthPixels : 0;
        return i2 == 0 ? ad.qw().qw("display_screen_width", 0) : i2;
    }

    public static void th(Context context) {
        yj(context, (Configuration) null);
    }

    public static void yj(Context context, Configuration configuration) {
        if (context != null) {
            synchronized (qw.class) {
                if (f8322ad == null) {
                    f8322ad = new DisplayMetrics();
                }
            }
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(f8322ad);
            qw = f8322ad.density;
            if (configuration != null) {
                f8322ad.heightPixels = de(configuration.screenHeightDp);
                f8322ad.widthPixels = de(configuration.screenWidthDp);
            }
            ad.qw().ad("display_screen_height", f8322ad.heightPixels);
            ad.qw().ad("display_screen_width", f8322ad.widthPixels);
        }
    }
}
