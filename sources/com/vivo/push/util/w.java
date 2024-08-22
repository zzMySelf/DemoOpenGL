package com.vivo.push.util;

import android.os.Build;
import android.os.UserHandle;
import java.lang.reflect.Method;

/* compiled from: MultiUserManager */
public final class w {

    /* renamed from: a  reason: collision with root package name */
    private static int f6592a = -1;

    public static int a() {
        if (Build.VERSION.SDK_INT < 17) {
            return 0;
        }
        int i2 = f6592a;
        if (i2 != -1) {
            return i2;
        }
        try {
            Method declaredMethod = UserHandle.class.getDeclaredMethod("myUserId", new Class[0]);
            declaredMethod.setAccessible(true);
            f6592a = ((Integer) declaredMethod.invoke((Object) null, (Object[]) null)).intValue();
            u.d("MultiUserManager", "getMyUserId = " + f6592a);
            return f6592a;
        } catch (Exception e2) {
            u.a("MultiUserManager", "getMyUserId error " + e2.getMessage());
            return 0;
        }
    }
}
