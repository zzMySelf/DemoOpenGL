package fe.mmm.qw.h;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.LocaleList;
import fe.mmm.qw.i.qw;
import java.util.Locale;

public class ad {
    public static volatile ad qw;

    public static ad qw() {
        if (qw == null) {
            synchronized (ad.class) {
                if (qw == null) {
                    qw = new ad();
                }
            }
        }
        return qw;
    }

    public final Locale ad() {
        if (Build.VERSION.SDK_INT < 24) {
            return Locale.getDefault();
        }
        return LocaleList.getDefault().get(0);
    }

    public void de(Context context) {
        if (context == null) {
            try {
                qw.rg("MultiLanguageUtil", "No context, MultiLanguageUtil will not work!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            Locale ad2 = ad();
            qw.ad("MultiLanguageUtil", "Set to preferred locale: " + ad2);
            Configuration configuration = context.getResources().getConfiguration();
            configuration.locale = ad2;
            Resources resources = context.getResources();
            resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        }
    }
}
