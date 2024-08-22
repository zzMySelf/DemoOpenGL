package com.baidu.searchbox.widget;

import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.openwidget.model.OpenWidgetInstance;
import com.baidu.searchbox.openwidget.model.OpenWidgetSize;
import com.baidu.searchbox.openwidget.preset.PresetOpenWidgetOwner;
import com.baidu.searchbox.openwidget.preset.PresetOpenWidgetProvider4x2Constellation;
import com.baidu.searchbox.widget.base.BaseWidgetProvider;
import com.baidu.searchbox.widget.cache.WidgetSharePreferenceUtils;
import com.baidu.searchbox.widget.constelwidget.ConstelDataManager;
import com.baidu.searchbox.widget.utils.WidgetPushUtilsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 !2\u00020\u00012\u00020\u0002:\u0001!B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0002J.\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u001c\u0010\u0016\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010\u0019\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u001a\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u001c\u0010\u001b\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J&\u0010\u001e\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u001c\u0010\u001f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010 \u001a\u00020\rH\u0002R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/baidu/searchbox/widget/ConstelWidgetProvider;", "Lcom/baidu/searchbox/widget/base/BaseWidgetProvider;", "Lcom/baidu/searchbox/openwidget/preset/PresetOpenWidgetOwner;", "()V", "localTemplate", "Lcom/baidu/searchbox/openwidget/model/OpenWidgetInstance;", "getLocalTemplate", "()Lcom/baidu/searchbox/openwidget/model/OpenWidgetInstance;", "presetConstellation", "Lcom/baidu/searchbox/openwidget/preset/PresetOpenWidgetProvider4x2Constellation;", "isLastUpdateOw", "", "onAppWidgetOptionsChanged", "", "context", "Landroid/content/Context;", "appWidgetManager", "Landroid/appwidget/AppWidgetManager;", "appWidgetId", "", "newOptions", "Landroid/os/Bundle;", "onDeleted", "appWidgetIds", "", "onDisabled", "onEnabled", "onReceive", "intent", "Landroid/content/Intent;", "onUpdate", "startPushServiceByWidgetAction", "syncNaAndUpdate", "Companion", "lib-widget_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConstelWidgetProvider.kt */
public final class ConstelWidgetProvider extends BaseWidgetProvider implements PresetOpenWidgetOwner {
    private static final String ACTION_REFRESH_CONSTEL = "com.baidu.searchbox.action.REFRESH_CONSTEL";
    public static final String CONSTEL_WIDGET_ID_PREFIX = "constel_widget_id";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final boolean DEBUG = AppConfig.isDebug();
    private static final String SP_KEY_LAST_UPDATE_OW = "constel_widget_last_update_ow";
    private static final String TAG = "ConstelWidgetProvider";
    private final PresetOpenWidgetProvider4x2Constellation presetConstellation = new PresetOpenWidgetProvider4x2Constellation();

    public ConstelWidgetProvider() {
        if (!isLastUpdateOw()) {
            syncNaAndUpdate();
            WidgetSharePreferenceUtils.Companion.getInstance().putBoolean(SP_KEY_LAST_UPDATE_OW, true);
        }
    }

    public OpenWidgetSize getPresetSize() {
        return PresetOpenWidgetOwner.DefaultImpls.getPresetSize(this);
    }

    public OpenWidgetInstance getLocalTemplate() {
        return this.presetConstellation.getLocalTemplate();
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x006b A[Catch:{ all -> 0x0085 }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0072 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void syncNaAndUpdate() {
        /*
            r16 = this;
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x0085 }
            r0 = r16
            com.baidu.searchbox.widget.ConstelWidgetProvider r0 = (com.baidu.searchbox.widget.ConstelWidgetProvider) r0     // Catch:{ all -> 0x0085 }
            r1 = 0
            android.content.Context r2 = com.baidu.searchbox.common.runtime.AppRuntime.getAppContext()     // Catch:{ all -> 0x0085 }
            android.appwidget.AppWidgetManager r3 = android.appwidget.AppWidgetManager.getInstance(r2)     // Catch:{ all -> 0x0085 }
            if (r3 == 0) goto L_0x001d
            android.content.ComponentName r4 = new android.content.ComponentName     // Catch:{ all -> 0x0085 }
            java.lang.Class<com.baidu.searchbox.widget.ConstelWidgetProvider> r5 = com.baidu.searchbox.widget.ConstelWidgetProvider.class
            r4.<init>(r2, r5)     // Catch:{ all -> 0x0085 }
            int[] r4 = r3.getAppWidgetIds(r4)     // Catch:{ all -> 0x0085 }
            goto L_0x001e
        L_0x001d:
            r4 = 0
        L_0x001e:
            if (r4 == 0) goto L_0x0084
            int r5 = r4.length     // Catch:{ all -> 0x0085 }
            if (r5 != 0) goto L_0x0025
            r5 = 1
            goto L_0x0026
        L_0x0025:
            r5 = 0
        L_0x0026:
            if (r5 == 0) goto L_0x0029
            goto L_0x0084
        L_0x0029:
            java.util.LinkedHashMap r5 = new java.util.LinkedHashMap     // Catch:{ all -> 0x0085 }
            r5.<init>()     // Catch:{ all -> 0x0085 }
            java.util.Map r5 = (java.util.Map) r5     // Catch:{ all -> 0x0085 }
            r8 = r4
            r9 = 0
            int r10 = r8.length     // Catch:{ all -> 0x0085 }
            r11 = 0
        L_0x0034:
            if (r11 >= r10) goto L_0x0076
            r12 = r8[r11]     // Catch:{ all -> 0x0085 }
            r13 = r12
            r14 = 0
            com.baidu.searchbox.widget.cache.WidgetSharePreferenceUtils$Companion r15 = com.baidu.searchbox.widget.cache.WidgetSharePreferenceUtils.Companion     // Catch:{ all -> 0x0085 }
            com.baidu.searchbox.widget.cache.WidgetSharePreferenceUtils r15 = r15.getInstance()     // Catch:{ all -> 0x0085 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0085 }
            r6.<init>()     // Catch:{ all -> 0x0085 }
            java.lang.String r7 = "constel_widget_id"
            java.lang.StringBuilder r6 = r6.append(r7)     // Catch:{ all -> 0x0085 }
            java.lang.StringBuilder r6 = r6.append(r13)     // Catch:{ all -> 0x0085 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0085 }
            java.lang.String r7 = ""
            java.lang.String r6 = r15.getString(r6, r7)     // Catch:{ all -> 0x0085 }
            r7 = r6
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7     // Catch:{ all -> 0x0085 }
            if (r7 == 0) goto L_0x0068
            int r7 = r7.length()     // Catch:{ all -> 0x0085 }
            if (r7 != 0) goto L_0x0066
            goto L_0x0068
        L_0x0066:
            r7 = 0
            goto L_0x0069
        L_0x0068:
            r7 = 1
        L_0x0069:
            if (r7 != 0) goto L_0x0072
            java.lang.Integer r7 = java.lang.Integer.valueOf(r13)     // Catch:{ all -> 0x0085 }
            r5.put(r7, r6)     // Catch:{ all -> 0x0085 }
        L_0x0072:
            int r11 = r11 + 1
            goto L_0x0034
        L_0x0076:
            com.baidu.searchbox.openwidget.preset.PresetOpenWidgetProvider4x2Constellation r6 = r0.presetConstellation     // Catch:{ all -> 0x0085 }
            r6.setNaConstellationData(r5)     // Catch:{ all -> 0x0085 }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0085 }
            java.lang.Object r0 = kotlin.Result.m8971constructorimpl(r0)     // Catch:{ all -> 0x0085 }
            goto L_0x0090
        L_0x0084:
            return
        L_0x0085:
            r0 = move-exception
            kotlin.Result$Companion r1 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            java.lang.Object r0 = kotlin.Result.m8971constructorimpl(r0)
        L_0x0090:
            java.lang.Throwable r0 = kotlin.Result.m8974exceptionOrNullimpl(r0)
            if (r0 == 0) goto L_0x00a5
            r1 = 0
            boolean r2 = DEBUG
            if (r2 == 0) goto L_0x00a3
            java.lang.String r2 = "ConstelWidgetProvider"
            java.lang.String r3 = "na星座widget数据传入OpenWidget异常"
            android.util.Log.e(r2, r3, r0)
        L_0x00a3:
        L_0x00a5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.widget.ConstelWidgetProvider.syncNaAndUpdate():void");
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/baidu/searchbox/widget/ConstelWidgetProvider$Companion;", "", "()V", "ACTION_REFRESH_CONSTEL", "", "CONSTEL_WIDGET_ID_PREFIX", "DEBUG", "", "SP_KEY_LAST_UPDATE_OW", "TAG", "lib-widget_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ConstelWidgetProvider.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private final boolean isLastUpdateOw() {
        return WidgetSharePreferenceUtils.Companion.getInstance().getBoolean(SP_KEY_LAST_UPDATE_OW, false);
    }

    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        if (DEBUG) {
            Log.d(TAG, "onUpdate");
        }
        this.presetConstellation.onUpdate(context, appWidgetManager, appWidgetIds);
    }

    public void onAppWidgetOptionsChanged(Context context, AppWidgetManager appWidgetManager, int appWidgetId, Bundle newOptions) {
        this.presetConstellation.onAppWidgetOptionsChanged(context, appWidgetManager, appWidgetId, newOptions);
    }

    public void onDisabled(Context context) {
        this.presetConstellation.onDisabled(context);
        super.onDisabled(context);
        ConstelDataManager.Companion.getInstance().deleteAllData();
    }

    public void onDeleted(Context context, int[] appWidgetIds) {
        this.presetConstellation.onDeleted(context, appWidgetIds);
        super.onDeleted(context, appWidgetIds);
        if (context != null && appWidgetIds != null) {
            if (!(appWidgetIds.length == 0)) {
                ConstelDataManager.Companion.getInstance().checkAndDelete(appWidgetIds, context);
            }
        }
    }

    public void onEnabled(Context context) {
        this.presetConstellation.onEnabled(context);
    }

    public void onReceive(Context context, Intent intent) {
        if (DEBUG) {
            Log.d(TAG, "onReceive, action = " + (intent != null ? intent.getAction() : null));
        }
        this.presetConstellation.onReceive(context, intent);
    }

    public void startPushServiceByWidgetAction(Context context, Intent intent) {
        String action;
        super.startPushServiceByWidgetAction(context, intent);
        if (intent != null && (action = intent.getAction()) != null) {
            switch (action.hashCode()) {
                case 96018329:
                    if (!action.equals(ACTION_REFRESH_CONSTEL)) {
                        return;
                    }
                    break;
                case 261081396:
                    if (!action.equals(WidgetActionUtils.ACTION_CONSTEL_WIDGET_ADD)) {
                        return;
                    }
                    break;
                case 1793210715:
                    if (!action.equals(WidgetActionUtils.ACTION_CONSTEL_WIDGET_CLICK)) {
                        return;
                    }
                    break;
                default:
                    return;
            }
            WidgetPushUtilsKt.startPushServiceByWidget(getClass(), action);
        }
    }
}
