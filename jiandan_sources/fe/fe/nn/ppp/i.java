package fe.fe.nn.ppp;

import android.content.Context;

public class i {
    public static boolean qw(Context context, String str) {
        return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
    }
}
