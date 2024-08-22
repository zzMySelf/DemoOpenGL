package com.baidu.nadcore.utils.permission;

import android.content.Context;
import android.os.Process;

public class ContextCompat {
    private static final String TAG = "ContextCompat";

    public static int checkSelfPermission(Context context, String permission) {
        if (permission != null) {
            return context.checkPermission(permission, Process.myPid(), Process.myUid());
        }
        throw new IllegalArgumentException("permission is null");
    }

    public static boolean checkPermissionGranted(Context context, String permission) {
        return checkSelfPermission(context, permission) == 0;
    }

    public static boolean checkPermissionDenied(Context context, String permission) {
        return checkSelfPermission(context, permission) == -1;
    }
}
