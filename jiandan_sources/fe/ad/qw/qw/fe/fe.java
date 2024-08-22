package fe.ad.qw.qw.fe;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.alibaba.android.arouter.facade.template.ILogger;
import fe.ad.qw.qw.ad.qw;

public class fe {

    /* renamed from: ad  reason: collision with root package name */
    public static int f1198ad;
    public static String qw;

    public static boolean ad(Context context) {
        PackageInfo qw2 = qw(context);
        if (qw2 != null) {
            String str = qw2.versionName;
            int i2 = qw2.versionCode;
            SharedPreferences sharedPreferences = context.getSharedPreferences("SP_AROUTER_CACHE", 0);
            if (str.equals(sharedPreferences.getString("LAST_VERSION_NAME", (String) null)) && i2 == sharedPreferences.getInt("LAST_VERSION_CODE", -1)) {
                return false;
            }
            qw = str;
            f1198ad = i2;
        }
        return true;
    }

    public static void de(Context context) {
        if (!TextUtils.isEmpty(qw) && f1198ad != 0) {
            context.getSharedPreferences("SP_AROUTER_CACHE", 0).edit().putString("LAST_VERSION_NAME", qw).putInt("LAST_VERSION_CODE", f1198ad).apply();
        }
    }

    public static PackageInfo qw(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 16384);
        } catch (Exception unused) {
            qw.f1186de.error(ILogger.defaultTag, "Get package info error.");
            return null;
        }
    }
}
