package com.baidu.apollon.permission;

import android.content.Context;
import android.os.Binder;
import android.os.Process;
import androidx.annotation.NonNull;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class c {
    public static final int a = 0;
    public static final int b = -1;
    public static final int c = -2;

    @Retention(RetentionPolicy.SOURCE)
    public @interface a {
    }

    public static int a(@NonNull Context context, @NonNull String str, int i2, int i3, String str2) {
        if (context.checkPermission(str, i2, i3) == -1) {
            return -1;
        }
        String a2 = a.a(str);
        if (a2 == null) {
            return 0;
        }
        if (str2 == null) {
            String[] packagesForUid = context.getPackageManager().getPackagesForUid(i3);
            if (packagesForUid == null || packagesForUid.length <= 0) {
                return -1;
            }
            str2 = packagesForUid[0];
        }
        if (a.a(context, a2, str2) != 0) {
            return -2;
        }
        return 0;
    }

    public static int b(@NonNull Context context, @NonNull String str) {
        return a(context, str, Binder.getCallingPid(), Binder.getCallingUid(), Binder.getCallingPid() == Process.myPid() ? context.getPackageName() : null);
    }

    public static int a(@NonNull Context context, @NonNull String str) {
        return a(context, str, Process.myPid(), Process.myUid(), context.getPackageName());
    }

    public static int a(@NonNull Context context, @NonNull String str, String str2) {
        if (Binder.getCallingPid() == Process.myPid()) {
            return -1;
        }
        return a(context, str, Binder.getCallingPid(), Binder.getCallingUid(), str2);
    }
}
