package fe.mmm.qw.g.de;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import fe.mmm.qw.yj.de;
import java.util.Date;

public class qw {
    public static int ad(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            fe.mmm.qw.i.qw.th("VersionUpdateUtils", "", e);
            return 0;
        }
    }

    public static boolean de() {
        long th2 = de.ppp().th("has_check_updated", -1);
        long time = new Date().getTime();
        if (-1 == th2) {
            return false;
        }
        long j = time - th2;
        if (86400000 < j) {
            return false;
        }
        fe.mmm.qw.i.qw.ad("VersionUpdateUtils", "has updated today. updateTime:" + th2 + ",currentTime - updateTime:" + j);
        return true;
    }

    public static boolean fe(Context context, String str, int i2) {
        fe.mmm.qw.i.qw.ad("VersionUpdateUtils", "version=" + fe.mmm.qw.de.ad.qw.qw.f7746ad);
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        boolean qw = qw(str);
        if (qw || i2 <= ad(context)) {
            return qw;
        }
        return true;
    }

    public static boolean qw(@NonNull String str) {
        String[] split = str.split("\\.");
        String[] split2 = fe.mmm.qw.de.ad.qw.qw.f7746ad.split("\\.");
        fe.mmm.qw.i.qw.ad("VersionUpdateUtils", str);
        fe.mmm.qw.i.qw.ad("VersionUpdateUtils", fe.mmm.qw.de.ad.qw.qw.f7746ad);
        if (split.length != split2.length) {
            return false;
        }
        int i2 = 0;
        while (i2 < split.length) {
            try {
                int parseInt = Integer.parseInt(split[i2]);
                int parseInt2 = Integer.parseInt(split2[i2]);
                if (parseInt > parseInt2) {
                    return true;
                }
                if (parseInt < parseInt2) {
                    return false;
                }
                i2++;
            } catch (NumberFormatException e) {
                fe.mmm.qw.i.qw.ggg("VersionUpdateUtils", "解析版本号出错", e);
                return false;
            }
        }
        return false;
    }

    public static void rg() {
        de.ppp().m1012if("has_check_updated", -1);
        de.ppp().ad();
    }

    public static void th(boolean z) {
        fe.mmm.qw.i.qw.ad("VersionUpdateUtils", "setUpdateSuccess.result = " + z);
        if (z) {
            de.ppp().m1012if("has_check_updated", new Date().getTime());
            de.ppp().ad();
            return;
        }
        rg();
    }
}
