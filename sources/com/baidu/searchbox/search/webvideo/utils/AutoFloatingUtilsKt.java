package com.baidu.searchbox.search.webvideo.utils;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.PowerManager;
import com.baidu.searchbox.util.BaiduIdentityManager;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u001a\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001\u001a\b\u0010\u0006\u001a\u00020\u0001H\u0002\u001a\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00012\u0006\u0010\b\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001\u001a\u0006\u0010\t\u001a\u00020\u0003\u001a\u0010\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u001a\u0010\u0010\r\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u001a\u0006\u0010\u000e\u001a\u00020\u000f\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"SP_KEY_AUTO_FLOATING_APPLY_PERMISSION_FLAG", "", "canAutoFloatingShowPermissionDialog", "", "clearFloatingUBCExtLog", "extLog", "getAutoFloatingPermissionFreqSpKey", "getFloatingUBCExtLog", "auto", "isHitAutoFloatingTest", "isScreenLock", "context", "Landroid/content/Context;", "isScreenOn", "recordAutoFloatingPermissionDialogShowed", "", "lib_search_video_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: AutoFloatingUtils.kt */
public final class AutoFloatingUtilsKt {
    private static final String SP_KEY_AUTO_FLOATING_APPLY_PERMISSION_FLAG = "auto_floating_apply_permission_flag";

    public static final boolean isHitAutoFloatingTest() {
        return WebVideoPlayContinueAbUtilsKt.isHitWebVideoPlayContinueTest();
    }

    public static final boolean canAutoFloatingShowPermissionDialog() {
        if (SearchH5VideoSPUtils.Companion.getInstance().getInt(getAutoFloatingPermissionFreqSpKey(), 0) == 0) {
            return true;
        }
        return false;
    }

    public static final void recordAutoFloatingPermissionDialogShowed() {
        SearchH5VideoSPUtils.Companion.getInstance().putInt(getAutoFloatingPermissionFreqSpKey(), 1);
    }

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

    private static final String getAutoFloatingPermissionFreqSpKey() {
        return SP_KEY_AUTO_FLOATING_APPLY_PERMISSION_FLAG + BaiduIdentityManager.getInstance().getUid();
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x001a A[Catch:{ all -> 0x0032 }] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0025 A[Catch:{ all -> 0x0032 }] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0028 A[Catch:{ all -> 0x0032 }] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0014 A[Catch:{ all -> 0x0032 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String getFloatingUBCExtLog(boolean r4, java.lang.String r5) {
        /*
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x0032 }
            r0 = 0
            r1 = r5
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch:{ all -> 0x0032 }
            if (r1 == 0) goto L_0x0011
            int r1 = r1.length()     // Catch:{ all -> 0x0032 }
            if (r1 != 0) goto L_0x000f
            goto L_0x0011
        L_0x000f:
            r1 = 0
            goto L_0x0012
        L_0x0011:
            r1 = 1
        L_0x0012:
            if (r1 == 0) goto L_0x001a
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ all -> 0x0032 }
            r1.<init>()     // Catch:{ all -> 0x0032 }
            goto L_0x001f
        L_0x001a:
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ all -> 0x0032 }
            r1.<init>(r5)     // Catch:{ all -> 0x0032 }
        L_0x001f:
            java.lang.String r2 = "startSource"
            if (r4 == 0) goto L_0x0028
            java.lang.String r3 = "auto_miniwindow"
            goto L_0x002a
        L_0x0028:
            java.lang.String r3 = ""
        L_0x002a:
            r1.put(r2, r3)     // Catch:{ all -> 0x0032 }
            java.lang.String r2 = r1.toString()     // Catch:{ all -> 0x0032 }
            return r2
        L_0x0032:
            r0 = move-exception
            kotlin.Result$Companion r1 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            kotlin.Result.m8971constructorimpl(r0)
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.search.webvideo.utils.AutoFloatingUtilsKt.getFloatingUBCExtLog(boolean, java.lang.String):java.lang.String");
    }

    public static final String clearFloatingUBCExtLog(String extLog) {
        CharSequence charSequence = extLog;
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        try {
            Result.Companion companion = Result.Companion;
            JSONObject statisticLog = new JSONObject(extLog);
            statisticLog.put("startSource", "");
            return statisticLog.toString();
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m8971constructorimpl(ResultKt.createFailure(th2));
            return null;
        }
    }
}
