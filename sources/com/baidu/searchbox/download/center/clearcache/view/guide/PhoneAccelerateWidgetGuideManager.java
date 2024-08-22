package com.baidu.searchbox.download.center.clearcache.view.guide;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.android.util.android.ActivityUtils;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.abtest.AbTestManager;
import com.baidu.searchbox.appframework.BdBoxActivityManager;
import com.baidu.searchbox.clearcache.business.R;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.download.center.clearcache.model.DiskManagerSharedPrefsUtils;
import com.baidu.searchbox.download.center.clearcache.view.accelerate.PhoneAccelerateUBCKt;
import com.baidu.searchbox.download.center.clearcache.view.ubc.ClearCacheStatistic;
import com.baidu.searchbox.download.center.clearcache.view.ubc.ClearCacheUbcConstant;
import com.baidu.searchbox.widget.IWidgetService;
import com.baidu.searchbox.widget.pin.InvokeType;
import com.baidu.searchbox.widget.pin.WidgetPinData;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J:\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\f\u001a\u00020\rJ\b\u0010\u000e\u001a\u00020\u0004H\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0002J\u0010\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0010H\u0002J\u0006\u0010\u0016\u001a\u00020\u0012J\u0006\u0010\u0017\u001a\u00020\u0012J\u000e\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\bJ\b\u0010\u001a\u001a\u00020\u0004H\u0002J0\u0010\u001b\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\bJ\u0010\u0010\u001c\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u001d\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0002J.\u0010\u001e\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\bH\u0002¨\u0006\u001f"}, d2 = {"Lcom/baidu/searchbox/download/center/clearcache/view/guide/PhoneAccelerateWidgetGuideManager;", "", "()V", "addPhoneAccelerateWidget", "", "context", "Landroid/content/Context;", "from", "", "scene", "Lcom/baidu/searchbox/download/center/clearcache/view/guide/ShowGuideScene;", "source", "invokeType", "Lcom/baidu/searchbox/widget/pin/InvokeType;", "clearWidgetRecordShowInfo", "getGuideIntervalDaysByUpdate", "", "isCanShowGuideDialog", "", "isCanShowGuideDialogByTimes", "isSameDay", "timeStamp", "judgePhoneTypeIsHuaweiAndOppoAndHonor", "phoneAccelerateWidgetIsExit", "printLog", "message", "recordShowGuideDialogTimeInfo", "showGuide", "showGuideClickAddUbcEvent", "showGuideUbcEvent", "showRealGuideDialog", "lib-clearcache-business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PhoneAccelerateWidgetGuideManager.kt */
public final class PhoneAccelerateWidgetGuideManager {
    public static final PhoneAccelerateWidgetGuideManager INSTANCE = new PhoneAccelerateWidgetGuideManager();

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PhoneAccelerateWidgetGuideManager.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ShowGuideScene.values().length];
            iArr[ShowGuideScene.PHONE_ACCELERATE_PAGE.ordinal()] = 1;
            iArr[ShowGuideScene.CLEAR_CACHE_PAGE.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private PhoneAccelerateWidgetGuideManager() {
    }

    public static /* synthetic */ void showGuide$default(PhoneAccelerateWidgetGuideManager phoneAccelerateWidgetGuideManager, Context context, String str, ShowGuideScene showGuideScene, String str2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = null;
        }
        if ((i2 & 8) != 0) {
            str2 = null;
        }
        phoneAccelerateWidgetGuideManager.showGuide(context, str, showGuideScene, str2);
    }

    public final void showGuide(Context context, String from, ShowGuideScene scene, String source) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        if (context != null) {
            if (phoneAccelerateWidgetIsExit()) {
                printLog("桌面已经存在widget");
            } else if (!isCanShowGuideDialog()) {
                printLog("一天内已经展示一次啦");
            } else if (!isCanShowGuideDialogByTimes()) {
                printLog("60天内弹出超过两次了");
            } else {
                try {
                    if (AbTestManager.getInstance().getSwitch("widget_all_guide", -1) > 1) {
                        if (phoneAccelerateWidgetIsExit()) {
                            Context ctx = AppRuntime.getAppContext();
                            if (ctx != null) {
                                UniversalToast.makeText(ctx, R.string.phone_accelerate_widget_is_exist_des).show();
                                return;
                            }
                            return;
                        }
                        addPhoneAccelerateWidget(context, from, scene, source, InvokeType.GUIDE_TO_ADD);
                    } else if (!judgePhoneTypeIsHuaweiAndOppoAndHonor()) {
                        showRealGuideDialog(context, from, scene, source);
                    } else if (judgePhoneTypeIsHuaweiAndOppoAndHonor()) {
                        addPhoneAccelerateWidget$default(this, context, from, scene, source, (InvokeType) null, 16, (Object) null);
                    }
                } catch (Exception e2) {
                    if (AppConfig.isDebug()) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    private final void showRealGuideDialog(Context context, String from, ShowGuideScene scene, String source) {
        if (context != null && (context instanceof Activity) && !((Activity) context).isFinishing() && !ActivityUtils.isDestroyed((Activity) context)) {
            try {
                PhoneAccelerateWidgetGuideDialog guideDialog = new PhoneAccelerateWidgetGuideDialog(context);
                guideDialog.show();
                showGuideUbcEvent(scene);
                recordShowGuideDialogTimeInfo();
                guideDialog.setOnAddButtonClickCallBack(new PhoneAccelerateWidgetGuideManager$showRealGuideDialog$1(context, from, scene, source));
            } catch (Exception e2) {
                if (AppConfig.isDebug()) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public static /* synthetic */ void addPhoneAccelerateWidget$default(PhoneAccelerateWidgetGuideManager phoneAccelerateWidgetGuideManager, Context context, String str, ShowGuideScene showGuideScene, String str2, InvokeType invokeType, int i2, Object obj) {
        String str3;
        InvokeType invokeType2;
        String str4 = (i2 & 2) != 0 ? null : str;
        if ((i2 & 8) != 0) {
            str3 = null;
        } else {
            str3 = str2;
        }
        if ((i2 & 16) != 0) {
            invokeType2 = InvokeType.DIRECT_ADD;
        } else {
            invokeType2 = invokeType;
        }
        phoneAccelerateWidgetGuideManager.addPhoneAccelerateWidget(context, str4, showGuideScene, str3, invokeType2);
    }

    public final void addPhoneAccelerateWidget(Context context, String from, ShowGuideScene scene, String source, InvokeType invokeType) {
        String str = from;
        ShowGuideScene showGuideScene = scene;
        InvokeType invokeType2 = invokeType;
        Intrinsics.checkNotNullParameter(showGuideScene, "scene");
        Intrinsics.checkNotNullParameter(invokeType2, "invokeType");
        Resources resources = context != null ? context.getResources() : null;
        if (resources != null) {
            if (showGuideScene == ShowGuideScene.CLEAR_CACHE_PAGE) {
                ClearCacheStatistic.doClearCacheUbc$default(ClearCacheStatistic.INSTANCE, (String) null, PhoneAccelerateUBCKt.VALUE_PHONE_ACCELERATE_CLICK_ADD_WIDGET, source, ClearCacheUbcConstant.UBC_VALUE_PAGE_CLEAN_FINISH, (String) null, ClearCacheStatistic.INSTANCE.generateCleanedExtUbc$lib_clearcache_business_release(), (String) null, 81, (Object) null);
            } else {
                PhoneAccelerateUBCKt.phoneAccelerateUBC$default(PhoneAccelerateUBCKt.VALUE_PHONE_ACCELERATE_CLICK_ADD_WIDGET, ClearCacheStatistic.INSTANCE.getUbcFromValue$lib_clearcache_business_release(str == null ? "" : str), (String) null, 4, (Object) null);
            }
            String phoneAccelerateTitle = resources.getString(R.string.phone_accelerate_widget_system_title);
            Intrinsics.checkNotNullExpressionValue(phoneAccelerateTitle, "resources.getString(R.st…rate_widget_system_title)");
            WidgetPinData $this$addPhoneAccelerateWidget_u24lambda_u2d0 = new WidgetPinData(19, phoneAccelerateTitle, (String) null, (Bundle) null, (PendingIntent) null, "home", 16, (DefaultConstructorMarker) null);
            boolean z = true;
            $this$addPhoneAccelerateWidget_u24lambda_u2d0.setCustomAddEnabled(true);
            $this$addPhoneAccelerateWidget_u24lambda_u2d0.setSilentAddEnabled(true);
            if (!AppConfig.isDebug() && AbTestManager.getInstance().getSwitch("widget_jishutupo", -1) != 1) {
                z = false;
            }
            $this$addPhoneAccelerateWidget_u24lambda_u2d0.setNewSilentEnabled(z);
            $this$addPhoneAccelerateWidget_u24lambda_u2d0.setInvokeType(invokeType2);
            Activity activity = BdBoxActivityManager.getRealTopActivity();
            if (activity != null) {
                IWidgetService getOrNull = IWidgetService.Companion.getGetOrNull();
                if (getOrNull != null) {
                    getOrNull.addWidget(activity, "speedClean", $this$addPhoneAccelerateWidget_u24lambda_u2d0, new PhoneAccelerateWidgetGuideManager$addPhoneAccelerateWidget$1(showGuideScene, source, str, resources));
                } else {
                    String str2 = source;
                }
            }
        }
    }

    public final boolean phoneAccelerateWidgetIsExit() {
        IWidgetService widgetService = (IWidgetService) ServiceManager.getService(IWidgetService.Companion.getReference());
        if (widgetService != null) {
            return widgetService.isWidgetExist(19);
        }
        return false;
    }

    public final boolean judgePhoneTypeIsHuaweiAndOppoAndHonor() {
        if (RomUtils.isOppo() || RomUtils.isEmui() || StringsKt.equals("HONOR", Build.MANUFACTURER, true)) {
            return true;
        }
        return false;
    }

    private final void showGuideUbcEvent(ShowGuideScene scene) {
        switch (WhenMappings.$EnumSwitchMapping$0[scene.ordinal()]) {
            case 1:
                ClearCacheStatistic.doClearCacheUbc$default(ClearCacheStatistic.INSTANCE, "speed", "guide_show", "speed_clean", "add", "speed_clean", (JSONObject) null, "6275", 32, (Object) null);
                return;
            case 2:
                ClearCacheStatistic.doClearCacheUbc$default(ClearCacheStatistic.INSTANCE, "clean", "guide_show", "speed_clean", "add", "speed_clean", (JSONObject) null, "6275", 32, (Object) null);
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: private */
    public final void showGuideClickAddUbcEvent(ShowGuideScene scene) {
        switch (WhenMappings.$EnumSwitchMapping$0[scene.ordinal()]) {
            case 1:
                ClearCacheStatistic.doClearCacheUbc$default(ClearCacheStatistic.INSTANCE, "speed", "guide_click", "speed_clean", "add", "speed_clean", (JSONObject) null, "6275", 32, (Object) null);
                return;
            case 2:
                ClearCacheStatistic.doClearCacheUbc$default(ClearCacheStatistic.INSTANCE, "clean", "guide_click", "speed_clean", "add", "speed_clean", (JSONObject) null, "6275", 32, (Object) null);
                return;
            default:
                return;
        }
    }

    private final boolean isCanShowGuideDialog() {
        long lastShowTimeStamp = DiskManagerSharedPrefsUtils.INSTANCE.getLong(PhoneAccelerateWidgetGuideManagerKt.KEY_PHONE_ACCELERATE_WIDGET_SHOW_TIME_STAMP, 0);
        if (lastShowTimeStamp == 0) {
            return true;
        }
        return !isSameDay(lastShowTimeStamp);
    }

    private final boolean isCanShowGuideDialogByTimes() {
        long lastShowStamp = DiskManagerSharedPrefsUtils.INSTANCE.getLong(PhoneAccelerateWidgetGuideManagerKt.KEY_PHONE_ACCELERATE_WIDGET_SHOW_LAST_TIME_STAMP, -1);
        int times = DiskManagerSharedPrefsUtils.INSTANCE.getInt(PhoneAccelerateWidgetGuideManagerKt.KEY_PHONE_ACCELERATE_WIDGET_SHOW_TIMES, 0);
        if (lastShowStamp <= 0) {
            return true;
        }
        long intervalTime = System.currentTimeMillis() - lastShowStamp;
        long j2 = (long) 60;
        long intervalSeconds = getGuideIntervalDaysByUpdate() * ((long) 24) * j2 * j2 * ((long) 1000);
        if (times != 2) {
            return true;
        }
        if (intervalTime < intervalSeconds) {
            return false;
        }
        clearWidgetRecordShowInfo();
        return true;
    }

    private final boolean isSameDay(long timeStamp) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-DD", Locale.getDefault());
            return Intrinsics.areEqual((Object) sdf.format(new Date(timeStamp)), (Object) sdf.format(new Date()));
        } catch (Exception e2) {
            if (!AppConfig.isDebug()) {
                return false;
            }
            e2.printStackTrace();
            return false;
        }
    }

    /* access modifiers changed from: private */
    public final void recordShowGuideDialogTimeInfo() {
        DiskManagerSharedPrefsUtils.INSTANCE.putLong(PhoneAccelerateWidgetGuideManagerKt.KEY_PHONE_ACCELERATE_WIDGET_SHOW_TIME_STAMP, System.currentTimeMillis());
        int lastTimes = DiskManagerSharedPrefsUtils.INSTANCE.getInt(PhoneAccelerateWidgetGuideManagerKt.KEY_PHONE_ACCELERATE_WIDGET_SHOW_TIMES, 0);
        DiskManagerSharedPrefsUtils.INSTANCE.putLong(PhoneAccelerateWidgetGuideManagerKt.KEY_PHONE_ACCELERATE_WIDGET_SHOW_LAST_TIME_STAMP, System.currentTimeMillis());
        DiskManagerSharedPrefsUtils.INSTANCE.putInt(PhoneAccelerateWidgetGuideManagerKt.KEY_PHONE_ACCELERATE_WIDGET_SHOW_TIMES, lastTimes + 1);
    }

    private final long getGuideIntervalDaysByUpdate() {
        String guideConfigStr = DiskManagerSharedPrefsUtils.INSTANCE.getString(PhoneAccelerateWidgetGuideConfigListenerKt.SP_PHONE_ACCELERATE_WIDGET_WIDGET_GUIDE_CONFIG, "");
        CharSequence charSequence = guideConfigStr;
        if (charSequence == null || charSequence.length() == 0) {
            return 60;
        }
        try {
            return new JSONObject(guideConfigStr).optLong(PhoneAccelerateWidgetGuideConfigListenerKt.KEY_INTERVAL_DAYS, 60);
        } catch (Exception e2) {
            if (AppConfig.isDebug()) {
                e2.printStackTrace();
            }
            return 60;
        }
    }

    public final void printLog(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (AppConfig.isDebug()) {
            Log.d(PhoneAccelerateWidgetGuideManagerKt.GUIDE_LOG_TAG, message + ",当前所在线程 = " + Thread.currentThread().getName());
            Log.d(PhoneAccelerateWidgetGuideManagerKt.GUIDE_LOG_TAG, "=======================================");
        }
    }

    /* access modifiers changed from: private */
    public final void clearWidgetRecordShowInfo() {
        DiskManagerSharedPrefsUtils.INSTANCE.remove(PhoneAccelerateWidgetGuideManagerKt.KEY_PHONE_ACCELERATE_WIDGET_SHOW_LAST_TIME_STAMP);
        DiskManagerSharedPrefsUtils.INSTANCE.remove(PhoneAccelerateWidgetGuideManagerKt.KEY_PHONE_ACCELERATE_WIDGET_SHOW_TIMES);
    }
}
