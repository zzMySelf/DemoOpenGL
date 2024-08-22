package com.baidu.searchbox.widget.ability.pin.check;

import android.app.Activity;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.searchbox.appframework.SimpleActivityLifeCycle;
import com.baidu.searchbox.widget.ability.pin.IWidgetPinCallback;
import com.baidu.searchbox.widget.ability.pin.WidgetPinResponse;
import com.baidu.searchbox.widget.ability.pin.WidgetPinSession;
import com.baidu.searchbox.widget.ability.pin.utils.DebugUtilsKt;
import java.lang.ref.WeakReference;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0019B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u0013\u001a\u00020\u0014H\u0002J\u0012\u0010\u0015\u001a\u00020\u00142\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010\u0016\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010\u0018\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003H\u0016R\u001c\u0010\u000b\u001a\u0010\u0012\f\u0012\n \r*\u0004\u0018\u00010\u00030\u00030\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/baidu/searchbox/widget/ability/pin/check/PinChecker;", "Lcom/baidu/searchbox/appframework/SimpleActivityLifeCycle;", "activity", "Landroid/app/Activity;", "manager", "Landroid/appwidget/AppWidgetManager;", "provider", "Landroid/content/ComponentName;", "session", "Lcom/baidu/searchbox/widget/ability/pin/WidgetPinSession;", "(Landroid/app/Activity;Landroid/appwidget/AppWidgetManager;Landroid/content/ComponentName;Lcom/baidu/searchbox/widget/ability/pin/WidgetPinSession;)V", "activityWeakRef", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "failureOnTimeout", "Lcom/baidu/searchbox/widget/ability/pin/check/PinChecker$FailureOnTimeout;", "preWidgetIds", "", "", "checkWidgetIsAddedToLauncher", "", "onActivityDestroyed", "onActivityPaused", "act", "onActivityResumed", "FailureOnTimeout", "lib-widget-ability-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PinChecker.kt */
public final class PinChecker extends SimpleActivityLifeCycle {
    private final WeakReference<Activity> activityWeakRef;
    private final FailureOnTimeout failureOnTimeout;
    private final AppWidgetManager manager;
    /* access modifiers changed from: private */
    public final Set<Integer> preWidgetIds;
    private final ComponentName provider;
    /* access modifiers changed from: private */
    public final WidgetPinSession session;

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x002d, code lost:
        r0 = kotlin.collections.ArraysKt.toSet(r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public PinChecker(android.app.Activity r5, android.appwidget.AppWidgetManager r6, android.content.ComponentName r7, com.baidu.searchbox.widget.ability.pin.WidgetPinSession r8) {
        /*
            r4 = this;
            java.lang.String r0 = "activity"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "manager"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "provider"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "session"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            r4.<init>()
            r4.manager = r6
            r4.provider = r7
            r4.session = r8
            java.lang.ref.WeakReference r0 = new java.lang.ref.WeakReference
            r0.<init>(r5)
            r4.activityWeakRef = r0
            int[] r0 = r6.getAppWidgetIds(r7)
            if (r0 == 0) goto L_0x0033
            java.util.Set r0 = kotlin.collections.ArraysKt.toSet((int[]) r0)
            if (r0 != 0) goto L_0x0037
        L_0x0033:
            java.util.Set r0 = kotlin.collections.SetsKt.emptySet()
        L_0x0037:
            r4.preWidgetIds = r0
            com.baidu.searchbox.widget.ability.pin.check.PinChecker$FailureOnTimeout r0 = new com.baidu.searchbox.widget.ability.pin.check.PinChecker$FailureOnTimeout
            r0.<init>(r4)
            r4.failureOnTimeout = r0
            android.os.Handler r1 = com.baidu.android.util.concurrent.UiThreadUtils.getMainHandler()
            java.lang.Runnable r0 = (java.lang.Runnable) r0
            r2 = 10000(0x2710, double:4.9407E-320)
            r1.postDelayed(r0, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.widget.ability.pin.check.PinChecker.<init>(android.app.Activity, android.appwidget.AppWidgetManager, android.content.ComponentName, com.baidu.searchbox.widget.ability.pin.WidgetPinSession):void");
    }

    public void onActivityPaused(Activity act) {
        Activity activity = (Activity) this.activityWeakRef.get();
        if (activity != null && Intrinsics.areEqual((Object) activity, (Object) act)) {
            DebugUtilsKt.printLog$default((String) null, PinChecker$onActivityPaused$1.INSTANCE, 1, (Object) null);
            UiThreadUtils.getMainHandler().removeCallbacks(this.failureOnTimeout);
        }
    }

    public void onActivityResumed(Activity act) {
        Activity activity = (Activity) this.activityWeakRef.get();
        if (activity != null && Intrinsics.areEqual((Object) activity, (Object) act)) {
            DebugUtilsKt.printLog$default((String) null, PinChecker$onActivityResumed$1.INSTANCE, 1, (Object) null);
            UiThreadUtils.getMainHandler().postDelayed(new PinChecker$$ExternalSyntheticLambda0(this), 600);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onActivityResumed$lambda-0  reason: not valid java name */
    public static final void m7614onActivityResumed$lambda0(PinChecker this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.checkWidgetIsAddedToLauncher();
    }

    public void onActivityDestroyed(Activity activity) {
        super.onActivityDestroyed(activity);
        Activity currentActivity = (Activity) this.activityWeakRef.get();
        if (currentActivity != null && Intrinsics.areEqual((Object) currentActivity, (Object) activity)) {
            DebugUtilsKt.printLog$default((String) null, PinChecker$onActivityDestroyed$1.INSTANCE, 1, (Object) null);
            UiThreadUtils.getMainHandler().postDelayed(new PinChecker$$ExternalSyntheticLambda1(this), 600);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onActivityDestroyed$lambda-1  reason: not valid java name */
    public static final void m7613onActivityDestroyed$lambda1(PinChecker this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.checkWidgetIsAddedToLauncher();
    }

    private final void checkWidgetIsAddedToLauncher() {
        Set newWidgetIds;
        int[] appWidgetIds = this.manager.getAppWidgetIds(this.provider);
        if (appWidgetIds == null || (newWidgetIds = ArraysKt.toSet(appWidgetIds)) == null) {
            newWidgetIds = SetsKt.emptySet();
        }
        DebugUtilsKt.printLog$default((String) null, new PinChecker$checkWidgetIsAddedToLauncher$1(newWidgetIds, this), 1, (Object) null);
        Integer newAppWidgetId = (Integer) CollectionsKt.maxOrNull(SetsKt.minus(newWidgetIds, this.preWidgetIds));
        DebugUtilsKt.printLog$default((String) null, new PinChecker$checkWidgetIsAddedToLauncher$2(newAppWidgetId), 1, (Object) null);
        WidgetPinResponse pinResponse = this.session.getResponse();
        if (newWidgetIds.isEmpty() || newAppWidgetId == null) {
            IWidgetPinCallback callback = this.session.getCallback();
            pinResponse.setStatusCode(1003);
            callback.onFailure(pinResponse);
            return;
        }
        IWidgetPinCallback callback2 = this.session.getCallback();
        WidgetPinResponse $this$checkWidgetIsAddedToLauncher_u24lambda_u2d3 = pinResponse;
        $this$checkWidgetIsAddedToLauncher_u24lambda_u2d3.setStatusCode(0);
        $this$checkWidgetIsAddedToLauncher_u24lambda_u2d3.setAppWidgetId(newAppWidgetId.intValue());
        callback2.onSuccess(pinResponse);
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\b\u001a\u00020\tH\u0016R\u001c\u0010\u0005\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00030\u00030\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/baidu/searchbox/widget/ability/pin/check/PinChecker$FailureOnTimeout;", "Ljava/lang/Runnable;", "checker", "Lcom/baidu/searchbox/widget/ability/pin/check/PinChecker;", "(Lcom/baidu/searchbox/widget/ability/pin/check/PinChecker;)V", "checkerRef", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "run", "", "lib-widget-ability-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PinChecker.kt */
    private static final class FailureOnTimeout implements Runnable {
        private final WeakReference<PinChecker> checkerRef;

        public FailureOnTimeout(PinChecker checker) {
            Intrinsics.checkNotNullParameter(checker, "checker");
            this.checkerRef = new WeakReference<>(checker);
        }

        public void run() {
            Unit unit;
            WidgetPinSession $this$run_u24lambda_u2d0;
            PinChecker pinChecker = (PinChecker) this.checkerRef.get();
            if (pinChecker == null || ($this$run_u24lambda_u2d0 = pinChecker.session) == null) {
                unit = null;
            } else {
                DebugUtilsKt.printLog$default((String) null, PinChecker$FailureOnTimeout$run$1$1.INSTANCE, 1, (Object) null);
                $this$run_u24lambda_u2d0.getResponse().setStatusCode(1006);
                $this$run_u24lambda_u2d0.getCallback().onFailure($this$run_u24lambda_u2d0.getResponse());
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                FailureOnTimeout failureOnTimeout = this;
                DebugUtilsKt.printLog$default((String) null, PinChecker$FailureOnTimeout$run$2$1.INSTANCE, 1, (Object) null);
            }
        }
    }
}
