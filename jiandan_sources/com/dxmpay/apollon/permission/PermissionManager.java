package com.dxmpay.apollon.permission;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import com.dxmpay.apollon.NoProguard;
import com.dxmpay.wallet.core.utils.LogUtil;
import fe.i.qw.rg.de;
import java.util.ArrayList;

public class PermissionManager implements NoProguard {
    public static final int REQUEST_CODE_CALL_PHONE = 2;
    public static final int REQUEST_CODE_READ_CONTRACT = 3;
    public static final int REQUEST_CODE_READ_SMS = 1;
    public static final int REQUEST_CODE_WRITE_EXTERNAL_STORAGE = 4;

    /* renamed from: ad  reason: collision with root package name */
    public static int f4004ad;

    @TargetApi(23)
    public static boolean checkCallingOrSelfPermission(Activity activity, String[] strArr, int i2) {
        if (activity == null || strArr == null || Build.VERSION.SDK_INT < 23) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < strArr.length; i3++) {
            if (!checkCallingPermission(activity, strArr[i3])) {
                arrayList.add(strArr[i3]);
            }
        }
        if (arrayList.isEmpty()) {
            return true;
        }
        activity.requestPermissions((String[]) arrayList.toArray(new String[arrayList.size()]), i2);
        return true;
    }

    public static boolean checkCallingPermission(Context context, String str) {
        try {
            if (Build.VERSION.SDK_INT < 23) {
                if (de.qw(context, str) != 0) {
                    return false;
                }
            } else if (getTargetSdkVersion(context) >= 23) {
                if (context.checkSelfPermission(str) != 0) {
                    return false;
                }
            } else if (de.qw(context, str) != 0) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static int getTargetSdkVersion(Context context) {
        if (f4004ad == 0) {
            try {
                f4004ad = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.targetSdkVersion;
            } catch (PackageManager.NameNotFoundException e) {
                LogUtil.e("PermissionManager", e.getMessage(), e);
            }
        }
        return f4004ad;
    }
}
