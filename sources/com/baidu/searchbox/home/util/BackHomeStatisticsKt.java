package com.baidu.searchbox.home.util;

import android.app.Activity;
import android.util.Log;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.ubc.UBCManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u001b\u001a\u00020\u001c2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0002\u001a\u0010\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002\u001a\u000e\u0010 \u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001f\u001a\u000e\u0010!\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020\r\u001a\u0012\u0010#\u001a\u00020$2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0002\u001a\u000e\u0010%\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020'\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000\"\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\"#\u0010\u0014\u001a\n \u0016*\u0004\u0018\u00010\u00150\u00158BX\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018¨\u0006("}, d2 = {"DEFAULT_CHANNEL", "", "DEFAULT_SOURCE", "FROM", "KEY_EXT_CHANNEL", "KEY_EXT_SOURCE", "KEY_LOGARGS_PARAM", "PAGE", "SOURCE", "TAG", "TYPE_SHOW", "UBC_ID", "hasRunOnResume", "", "isSetUserVisibleHintRun", "logArgs", "getLogArgs", "()Ljava/lang/String;", "setLogArgs", "(Ljava/lang/String;)V", "ubcManager", "Lcom/baidu/ubc/UBCManager;", "kotlin.jvm.PlatformType", "getUbcManager", "()Lcom/baidu/ubc/UBCManager;", "ubcManager$delegate", "Lkotlin/Lazy;", "backHomeEvent", "", "isBackToHome", "activity", "Landroid/app/Activity;", "onHomeFragmentResumed", "onHomeFragmentSetUserVisibleHint", "isVisibleToUser", "parseLogArgs", "Lorg/json/JSONObject;", "processLaunchScheme", "entity", "Lcom/baidu/searchbox/unitedscheme/UnitedSchemeEntity;", "lib-homepage_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: BackHomeStatistics.kt */
public final class BackHomeStatisticsKt {
    private static final String DEFAULT_CHANNEL = "other";
    private static final String DEFAULT_SOURCE = "other";
    private static final String FROM = "openbox";
    private static final String KEY_EXT_CHANNEL = "channel";
    private static final String KEY_EXT_SOURCE = "source";
    private static final String KEY_LOGARGS_PARAM = "logargs";
    private static final String PAGE = "feed";
    private static final String SOURCE = "invoke";
    private static final String TAG = "BackHomeStatistics";
    private static final String TYPE_SHOW = "show";
    private static final String UBC_ID = "5677";
    private static boolean hasRunOnResume;
    private static boolean isSetUserVisibleHintRun;
    private static String logArgs;
    private static final Lazy ubcManager$delegate = LazyKt.lazy(BackHomeStatisticsKt$ubcManager$2.INSTANCE);

    private static final UBCManager getUbcManager() {
        return (UBCManager) ubcManager$delegate.getValue();
    }

    public static final String getLogArgs() {
        return logArgs;
    }

    public static final void setLogArgs(String str) {
        logArgs = str;
    }

    public static final void processLaunchScheme(UnitedSchemeEntity entity) {
        Intrinsics.checkNotNullParameter(entity, "entity");
        if (Intrinsics.areEqual((Object) "outside", (Object) entity.getSource())) {
            String logArgsParam = entity.getParam("logargs");
            if (logArgsParam == null) {
                logArgsParam = null;
            }
            CharSequence charSequence = logArgsParam;
            if (charSequence == null || charSequence.length() == 0) {
                logArgs = null;
                if (AppConfig.isDebug()) {
                    Log.d(TAG, "processLaunchScheme: outside launch, logargs is null");
                    return;
                }
                return;
            }
            logArgs = logArgsParam;
            if (AppConfig.isDebug()) {
                Log.d(TAG, "processLaunchScheme: outside launch, logargs is " + logArgsParam);
            }
        }
    }

    public static final void onHomeFragmentResumed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        hasRunOnResume = true;
        if (isBackToHome(activity)) {
            backHomeEvent(logArgs);
            logArgs = null;
        }
        isSetUserVisibleHintRun = false;
    }

    public static final void onHomeFragmentSetUserVisibleHint(boolean isVisibleToUser) {
        if (hasRunOnResume && isVisibleToUser) {
            isSetUserVisibleHintRun = true;
            backHomeEvent(logArgs);
            logArgs = null;
        }
    }

    private static final boolean isBackToHome(Activity activity) {
        if (isSetUserVisibleHintRun) {
            if (AppConfig.isDebug()) {
                Log.d(TAG, "isBackToHome: has run setUserVisibleHint. pass");
            }
            return false;
        }
        Activity prevActivity = HomeActivityUtilsKt.getGoHomeActivity(activity);
        if (prevActivity == null) {
            if (AppConfig.isDebug()) {
                Log.d(TAG, "isBackToHome: prevActivity is null. pass");
            }
            return false;
        } else if (HomeActivityUtilsKt.isDialogStyle(prevActivity)) {
            if (AppConfig.isDebug()) {
                Log.d(TAG, "isBackToHome: prevActivity is DialogInterface. pass");
            }
            return false;
        } else if (HomeActivityUtilsKt.hasContent(prevActivity)) {
            return true;
        } else {
            if (AppConfig.isDebug()) {
                Log.d(TAG, "isBackToHome: prevActivity contentView is null. pass");
            }
            return false;
        }
    }

    private static final void backHomeEvent(String logArgs2) {
        try {
            JSONObject data = new JSONObject();
            data.put("from", "openbox");
            data.put("page", "feed");
            data.put("type", "show");
            data.put("source", "invoke");
            data.put("ext", parseLogArgs(logArgs2));
            getUbcManager().onEvent(UBC_ID, data.toString());
        } catch (Exception e2) {
            if (AppConfig.isDebug()) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0049 A[Catch:{ Exception -> 0x006b }] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x004d A[Catch:{ Exception -> 0x006b }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0062 A[Catch:{ Exception -> 0x006b }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0066 A[Catch:{ Exception -> 0x006b }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final org.json.JSONObject parseLogArgs(java.lang.String r13) {
        /*
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            r1 = r13
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x0015
            int r1 = r1.length()
            if (r1 != 0) goto L_0x0013
            goto L_0x0015
        L_0x0013:
            r1 = r2
            goto L_0x0016
        L_0x0015:
            r1 = r3
        L_0x0016:
            java.lang.String r4 = "source"
            java.lang.String r5 = "channel"
            java.lang.String r6 = "other"
            if (r1 == 0) goto L_0x0027
            r0.put(r5, r6)
            r0.put(r4, r6)
            return r0
        L_0x0027:
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ Exception -> 0x006b }
            r1.<init>(r13)     // Catch:{ Exception -> 0x006b }
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch:{ Exception -> 0x006b }
            r7.<init>()     // Catch:{ Exception -> 0x006b }
            r8 = r7
            r9 = 0
            java.lang.String r10 = r1.optString(r5)     // Catch:{ Exception -> 0x006b }
            r11 = r10
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11     // Catch:{ Exception -> 0x006b }
            if (r11 == 0) goto L_0x0046
            int r11 = r11.length()     // Catch:{ Exception -> 0x006b }
            if (r11 != 0) goto L_0x0044
            goto L_0x0046
        L_0x0044:
            r11 = r2
            goto L_0x0047
        L_0x0046:
            r11 = r3
        L_0x0047:
            if (r11 == 0) goto L_0x004d
            r8.put(r5, r6)     // Catch:{ Exception -> 0x006b }
            goto L_0x0050
        L_0x004d:
            r8.put(r5, r10)     // Catch:{ Exception -> 0x006b }
        L_0x0050:
            java.lang.String r11 = r1.optString(r4)     // Catch:{ Exception -> 0x006b }
            r12 = r11
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12     // Catch:{ Exception -> 0x006b }
            if (r12 == 0) goto L_0x005f
            int r12 = r12.length()     // Catch:{ Exception -> 0x006b }
            if (r12 != 0) goto L_0x0060
        L_0x005f:
            r2 = r3
        L_0x0060:
            if (r2 == 0) goto L_0x0066
            r8.put(r4, r6)     // Catch:{ Exception -> 0x006b }
            goto L_0x0069
        L_0x0066:
            r8.put(r4, r11)     // Catch:{ Exception -> 0x006b }
        L_0x0069:
            return r7
        L_0x006b:
            r1 = move-exception
            r0.put(r5, r6)
            r0.put(r4, r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.home.util.BackHomeStatisticsKt.parseLogArgs(java.lang.String):org.json.JSONObject");
    }
}
