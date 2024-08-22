package com.google.android.gms.common.util;

import android.content.Context;
import android.os.DropBoxManager;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;

@KeepForSdk
public final class CrashUtils {
    public static final String[] zzgv = {"android.", "com.android.", "dalvik.", "java.", "javax."};
    public static DropBoxManager zzgw = null;
    public static boolean zzgx = false;
    public static int zzgy = -1;
    public static int zzgz;
    public static int zzha;

    @KeepForSdk
    public static boolean addDynamiteErrorToDropBox(Context context, Throwable th2) {
        return zza(context, th2, 536870912);
    }

    public static boolean zza(Context context, Throwable th2, int i2) {
        try {
            Preconditions.checkNotNull(context);
            Preconditions.checkNotNull(th2);
        } catch (Exception unused) {
        }
        return false;
    }
}
