package fe.mmm.qw.when;

import android.os.Build;
import android.os.LocaleList;
import java.util.Locale;

public final class qw {
    public static final Locale qw() {
        if (Build.VERSION.SDK_INT >= 24) {
            return LocaleList.getDefault().get(0);
        }
        return Locale.getDefault();
    }
}
