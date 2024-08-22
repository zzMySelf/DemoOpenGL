package com.baidu.wallet.core.permission;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import androidx.annotation.NonNull;
import com.baidu.apollon.permission.PermissionManager;
import com.baidu.wallet.core.NoProguard;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class PermissionsUtil implements NoProguard {
    public static final String TAG = "PermissionsUtil";
    public static HashMap<String, PermissionListener> listenerMap = new HashMap<>();

    public static PermissionListener fetchListener(String str) {
        return listenerMap.remove(str);
    }

    public static void gotoSetting(@NonNull Context context) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.parse("package:" + context.getPackageName()));
        context.startActivity(intent);
    }

    public static boolean hasPermission(@NonNull Context context, @NonNull String... strArr) {
        if (strArr.length == 0) {
            return false;
        }
        for (String checkCallingPermission : strArr) {
            if (!PermissionManager.checkCallingPermission(context, checkCallingPermission)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isGranted(@NonNull int... iArr) {
        if (iArr.length == 0) {
            return false;
        }
        for (int i2 : iArr) {
            if (i2 != 0) {
                return false;
            }
        }
        return true;
    }

    public static void requestPermission(@NonNull Context context, @NonNull PermissionListener permissionListener, @NonNull String... strArr) {
        if (permissionListener != null && strArr != null && strArr.length != 0) {
            if (Build.VERSION.SDK_INT < 23) {
                permissionListener.permissionGranted(Arrays.asList(strArr));
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < strArr.length; i2++) {
                if (!hasPermission(context, strArr[i2])) {
                    arrayList.add(strArr[i2]);
                }
            }
            if (arrayList.size() == 0) {
                permissionListener.permissionGranted(Arrays.asList(strArr));
                return;
            }
            String valueOf = String.valueOf(System.currentTimeMillis());
            listenerMap.put(valueOf, permissionListener);
            Intent intent = new Intent(context, PermissionActivity.class);
            intent.putExtra("permission", (String[]) arrayList.toArray(new String[arrayList.size()]));
            intent.putExtra("key", valueOf);
            intent.addFlags(268435456);
            context.startActivity(intent);
            if (context instanceof Activity) {
                ((Activity) context).overridePendingTransition(0, 0);
            }
        }
    }
}
