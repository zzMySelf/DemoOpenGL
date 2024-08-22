package com.baidu.searchbox.download.center.utils;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.PowerManager;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u001a\u0010\u0010\u0004\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¨\u0006\u0005"}, d2 = {"isScreenLock", "", "context", "Landroid/content/Context;", "isScreenOn", "lib-download-center_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: LockScreenUtils.kt */
public final class LockScreenUtilsKt {
    public static final boolean isScreenOn(Context context) {
        PowerManager powerManager = null;
        Object systemService = context != null ? context.getSystemService("power") : null;
        if (systemService instanceof PowerManager) {
            powerManager = (PowerManager) systemService;
        }
        return powerManager != null && powerManager.isInteractive();
    }

    public static final boolean isScreenLock(Context context) {
        KeyguardManager keyguard = null;
        Object systemService = context != null ? context.getSystemService("keyguard") : null;
        if (systemService instanceof KeyguardManager) {
            keyguard = (KeyguardManager) systemService;
        }
        return keyguard != null && keyguard.isKeyguardLocked();
    }
}
