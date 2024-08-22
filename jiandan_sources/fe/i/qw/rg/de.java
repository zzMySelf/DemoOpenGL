package fe.i.qw.rg;

import android.content.Context;
import android.os.Process;
import androidx.annotation.NonNull;

public final class de {
    public static int ad(@NonNull Context context, @NonNull String str, int i2, int i3, String str2) {
        if (context.checkPermission(str, i2, i3) == -1) {
            return -1;
        }
        String ad2 = qw.ad(str);
        if (ad2 == null) {
            return 0;
        }
        if (str2 == null) {
            String[] packagesForUid = context.getPackageManager().getPackagesForUid(i3);
            if (packagesForUid == null || packagesForUid.length <= 0) {
                return -1;
            }
            str2 = packagesForUid[0];
        }
        if (qw.qw(context, ad2, str2) != 0) {
            return -2;
        }
        return 0;
    }

    public static int qw(@NonNull Context context, @NonNull String str) {
        return ad(context, str, Process.myPid(), Process.myUid(), context.getPackageName());
    }
}
