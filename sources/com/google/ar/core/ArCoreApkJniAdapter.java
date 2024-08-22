package com.google.ar.core;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import com.google.ar.core.ArCoreApk;
import com.google.ar.core.Session;
import com.google.ar.core.exceptions.ResourceExhaustedException;
import com.google.ar.core.exceptions.UnavailableApkTooOldException;
import com.google.ar.core.exceptions.UnavailableArcoreNotInstalledException;
import com.google.ar.core.exceptions.UnavailableDeviceNotCompatibleException;
import com.google.ar.core.exceptions.UnavailableSdkTooOldException;
import com.google.ar.core.exceptions.UnavailableUserDeclinedInstallationException;
import java.util.HashMap;
import java.util.Map;

class ArCoreApkJniAdapter {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<Class<? extends Throwable>, Integer> f4533a;

    static {
        HashMap hashMap = new HashMap();
        f4533a = hashMap;
        hashMap.put(IllegalArgumentException.class, Integer.valueOf(Session.b.ERROR_INVALID_ARGUMENT.f4553j));
        hashMap.put(ResourceExhaustedException.class, Integer.valueOf(Session.b.ERROR_RESOURCE_EXHAUSTED.f4553j));
        hashMap.put(UnavailableArcoreNotInstalledException.class, Integer.valueOf(Session.b.UNAVAILABLE_ARCORE_NOT_INSTALLED.f4553j));
        hashMap.put(UnavailableDeviceNotCompatibleException.class, Integer.valueOf(Session.b.UNAVAILABLE_DEVICE_NOT_COMPATIBLE.f4553j));
        hashMap.put(UnavailableApkTooOldException.class, Integer.valueOf(Session.b.UNAVAILABLE_APK_TOO_OLD.f4553j));
        hashMap.put(UnavailableSdkTooOldException.class, Integer.valueOf(Session.b.UNAVAILABLE_SDK_TOO_OLD.f4553j));
        hashMap.put(UnavailableUserDeclinedInstallationException.class, Integer.valueOf(Session.b.UNAVAILABLE_USER_DECLINED_INSTALLATION.f4553j));
    }

    ArCoreApkJniAdapter() {
    }

    private static int a(Throwable th2) {
        Log.e("ARCore-ArCoreApkJniAdapter", "Exception details:", th2);
        Class<?> cls = th2.getClass();
        Map<Class<? extends Throwable>, Integer> map = f4533a;
        if (map.containsKey(cls)) {
            return map.get(cls).intValue();
        }
        return Session.b.ERROR_FATAL.f4553j;
    }

    static int checkAvailability(Context context) {
        try {
            return ArCoreApk.getInstance().checkAvailability(context).nativeCode;
        } catch (Throwable th2) {
            a(th2);
            return ArCoreApk.Availability.UNKNOWN_ERROR.nativeCode;
        }
    }

    static int requestInstall(Activity activity, boolean z, int[] iArr) {
        try {
            iArr[0] = ArCoreApk.getInstance().requestInstall(activity, z).nativeCode;
            return Session.b.f4544a.f4553j;
        } catch (Throwable th2) {
            return a(th2);
        }
    }

    static int requestInstallCustom(Activity activity, boolean z, int i2, int i3, int[] iArr) {
        try {
            iArr[0] = ArCoreApk.getInstance().requestInstall(activity, z, ArCoreApk.InstallBehavior.forNumber(i2), ArCoreApk.UserMessageType.forNumber(i3)).nativeCode;
            return Session.b.f4544a.f4553j;
        } catch (Throwable th2) {
            return a(th2);
        }
    }
}
