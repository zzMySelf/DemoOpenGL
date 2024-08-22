package androidx.core.os;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Process;
import android.os.UserHandle;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Method;

public final class ProcessCompat {

    @RequiresApi(16)
    public static class Api16Impl {
        public static Method sMethodUserIdIsAppMethod;
        public static boolean sResolved;
        public static final Object sResolvedLock = new Object();

        @SuppressLint({"PrivateApi"})
        public static boolean isApplicationUid(int i2) {
            try {
                synchronized (sResolvedLock) {
                    if (!sResolved) {
                        sResolved = true;
                        sMethodUserIdIsAppMethod = Class.forName("android.os.UserId").getDeclaredMethod("isApp", new Class[]{Integer.TYPE});
                    }
                }
                if (sMethodUserIdIsAppMethod != null) {
                    Boolean bool = (Boolean) sMethodUserIdIsAppMethod.invoke((Object) null, new Object[]{Integer.valueOf(i2)});
                    if (bool != null) {
                        return bool.booleanValue();
                    }
                    throw new NullPointerException();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return true;
        }
    }

    @RequiresApi(17)
    public static class Api17Impl {
        public static Method sMethodUserHandleIsAppMethod;
        public static boolean sResolved;
        public static final Object sResolvedLock = new Object();

        @SuppressLint({"DiscouragedPrivateApi"})
        public static boolean isApplicationUid(int i2) {
            try {
                synchronized (sResolvedLock) {
                    if (!sResolved) {
                        sResolved = true;
                        sMethodUserHandleIsAppMethod = UserHandle.class.getDeclaredMethod("isApp", new Class[]{Integer.TYPE});
                    }
                }
                if (sMethodUserHandleIsAppMethod != null) {
                    if (((Boolean) sMethodUserHandleIsAppMethod.invoke((Object) null, new Object[]{Integer.valueOf(i2)})) == null) {
                        throw new NullPointerException();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return true;
        }
    }

    @RequiresApi(24)
    public static class Api24Impl {
        public static boolean isApplicationUid(int i2) {
            return Process.isApplicationUid(i2);
        }
    }

    public static boolean isApplicationUid(int i2) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 24) {
            return Api24Impl.isApplicationUid(i2);
        }
        if (i3 >= 17) {
            return Api17Impl.isApplicationUid(i2);
        }
        if (i3 == 16) {
            return Api16Impl.isApplicationUid(i2);
        }
        return true;
    }
}
