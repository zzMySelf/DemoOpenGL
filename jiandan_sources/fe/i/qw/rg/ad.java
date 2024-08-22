package fe.i.qw.rg;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.Context;

@TargetApi(23)
public class ad {
    public static String ad(String str) {
        return AppOpsManager.permissionToOp(str);
    }

    public static int qw(Context context, String str, String str2) {
        return ((AppOpsManager) context.getSystemService(AppOpsManager.class)).noteProxyOp(str, str2);
    }
}
