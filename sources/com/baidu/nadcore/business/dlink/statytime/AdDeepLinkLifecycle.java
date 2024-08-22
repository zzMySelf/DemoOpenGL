package com.baidu.nadcore.business.dlink.statytime;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.nadcore.lifecycle.AdActivityManager;
import com.baidu.nadcore.lifecycle.AdBaseLifecycleCallback;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\u0013\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/baidu/nadcore/business/dlink/statytime/AdDeepLinkLifecycle;", "Lcom/baidu/nadcore/lifecycle/AdBaseLifecycleCallback;", "()V", "firstActivityNotCreated", "", "getFirstActivityNotCreated", "()Z", "setFirstActivityNotCreated", "(Z)V", "onActivityCreated", "", "activity", "Landroid/app/Activity;", "savedInstanceState", "Landroid/os/Bundle;", "onActivityDestroyed", "onActivityPaused", "onActivityResumed", "onBackgroundToForeground", "onForegroundToBackground", "nadcore-lib-business"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AdDeepLinkLifecycle.kt */
public final class AdDeepLinkLifecycle extends AdBaseLifecycleCallback {
    private boolean firstActivityNotCreated = true;

    public final boolean getFirstActivityNotCreated() {
        return this.firstActivityNotCreated;
    }

    public final void setFirstActivityNotCreated(boolean z) {
        this.firstActivityNotCreated = z;
    }

    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (this.firstActivityNotCreated) {
            SplashDeepLinkStayTime.deepLinkOnCreate(activity, savedInstanceState);
            this.firstActivityNotCreated = false;
            if (!AdDeepLinkStayTime.hasADeepLinkOpen()) {
                AdDeepLinkStayTime.resetAll();
                return;
            }
            String ext = AdDeepLinkStayTime.readDeepLinkExt();
            if (!TextUtils.isEmpty(ext) && !AdDeepLinkStayTime.finishedPostThisAd(ext)) {
                long deepLinkOpenTime = AdDeepLinkStayTime.readDeepLinkOpenTime();
                new Handler().postDelayed(new AdDeepLinkLifecycle$$ExternalSyntheticLambda0(System.currentTimeMillis() - deepLinkOpenTime, deepLinkOpenTime, System.currentTimeMillis(), ext), AdDeepLinkLifecycleKt.RUNNABLE_DELAY_MILLIS);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onActivityCreated$lambda-0  reason: not valid java name */
    public static final void m84onActivityCreated$lambda0(long $stayTime, long $deepLinkOpenTime, long $coldBootTime, String $ext) {
        Intrinsics.checkNotNullParameter($ext, "$ext");
        if ($stayTime < AdDeepLinkStayTime.getTransTime()) {
            AdDeepLinkStayTime.saveReturnBeforeThreshold();
        } else if (!AdDeepLinkStayTime.noNeedPostStayTransOnColdBoot()) {
            AdDeepLinkStayTime.postDeepLinkStayTrans($deepLinkOpenTime, $coldBootTime, $ext);
        }
        AdDeepLinkStayTime.postDeepLinkStayTime($deepLinkOpenTime, "boot_from_cold", $coldBootTime, $ext);
    }

    public void onActivityResumed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        SplashDeepLinkStayTime.deepLinkOnResume(activity);
    }

    public void onBackgroundToForeground(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (!AdDeepLinkStayTime.hasADeepLinkOpen()) {
            AdDeepLinkStayTime.resetAll();
        } else if (TextUtils.equals(activity.getLocalClassName(), AdDeepLinkStayTime.readDeepLinkSourceActivity())) {
            String ext = AdDeepLinkStayTime.readDeepLinkExt();
            if (!TextUtils.isEmpty(ext) && !AdDeepLinkStayTime.finishedPostThisAd(ext)) {
                long deepLinkOpenTime = AdDeepLinkStayTime.readDeepLinkOpenTime();
                long toForegroundTime = System.currentTimeMillis();
                if (System.currentTimeMillis() - deepLinkOpenTime < AdDeepLinkStayTime.getTransTime()) {
                    AdDeepLinkStayTime.saveReturnBeforeThreshold();
                    AdDeepLinkStayTime.saveNoNeedPostStayTransOnColdBoot();
                }
                new Handler().postDelayed(new AdDeepLinkLifecycle$$ExternalSyntheticLambda1(deepLinkOpenTime, toForegroundTime, ext), AdDeepLinkLifecycleKt.RUNNABLE_DELAY_MILLIS);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onBackgroundToForeground$lambda-1  reason: not valid java name */
    public static final void m85onBackgroundToForeground$lambda1(long $deepLinkOpenTime, long $toForegroundTime, String $ext) {
        Intrinsics.checkNotNullParameter($ext, "$ext");
        AdDeepLinkStayTime.postDeepLinkStayTime($deepLinkOpenTime, "boot_from_background", $toForegroundTime, $ext);
    }

    public void onForegroundToBackground(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        AdDeepLinkStayTime.saveDeepLinkSourceActivity(activity);
        SplashDeepLinkStayTime.deepLinkForegroundToBackground(activity);
    }

    public void onActivityPaused(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        SplashDeepLinkStayTime.deepLinkOnPause(activity);
    }

    public void onActivityDestroyed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onActivityDestroyed(activity);
        LinkedList it = AdActivityManager.getActivityStack();
        if (it != null && it.size() <= 1) {
            this.firstActivityNotCreated = true;
        }
    }
}
