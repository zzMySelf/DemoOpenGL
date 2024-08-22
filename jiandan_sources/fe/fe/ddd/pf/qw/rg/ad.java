package fe.fe.ddd.pf.qw.rg;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Base64;
import com.baidu.searchbox.config.AppConfig;

public class ad {
    public static final boolean qw = AppConfig.rg();

    public static String ad(Context context) {
        long j;
        try {
            j = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).lastUpdateTime;
        } catch (PackageManager.NameNotFoundException e) {
            if (qw) {
                e.printStackTrace();
            }
            j = 0;
        }
        return Base64.encodeToString(Long.toString(j).getBytes(), 0);
    }

    public static String qw(Context context) {
        long j;
        try {
            j = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).firstInstallTime;
        } catch (PackageManager.NameNotFoundException e) {
            if (qw) {
                e.printStackTrace();
            }
            j = 0;
        }
        return Base64.encodeToString(Long.toString(j).getBytes(), 0);
    }
}
