package leakcanary;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.lang.reflect.Proxy;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import leakcanary.internal.ObjectsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J-\u0010\u0002\u001a\u00020\u00032\u0010\b\u0001\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00052\u0010\b\u0001\u0010\u0007\u001a\n \u0006*\u0004\u0018\u00010\b0\bH\u0001J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0005H\u0016J\u001b\u0010\u000b\u001a\u00020\u00032\u0010\b\u0001\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\u0001J\u001b\u0010\f\u001a\u00020\u00032\u0010\b\u0001\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\u0001J-\u0010\r\u001a\u00020\u00032\u0010\b\u0001\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00052\u0010\b\u0001\u0010\u0007\u001a\n \u0006*\u0004\u0018\u00010\b0\bH\u0001J\u001b\u0010\u000e\u001a\u00020\u00032\u0010\b\u0001\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\u0001J\u001b\u0010\u000f\u001a\u00020\u00032\u0010\b\u0001\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\u0001¨\u0006\u0010"}, d2 = {"leakcanary/ActivityWatcher$lifecycleCallbacks$1", "Landroid/app/Application$ActivityLifecycleCallbacks;", "onActivityCreated", "", "p0", "Landroid/app/Activity;", "kotlin.jvm.PlatformType", "p1", "Landroid/os/Bundle;", "onActivityDestroyed", "activity", "onActivityPaused", "onActivityResumed", "onActivitySaveInstanceState", "onActivityStarted", "onActivityStopped", "leakcanary-object-watcher-android_release"}, k = 1, mv = {1, 4, 1})
/* compiled from: ActivityWatcher.kt */
public final class ActivityWatcher$lifecycleCallbacks$1 implements Application.ActivityLifecycleCallbacks {
    private final /* synthetic */ Application.ActivityLifecycleCallbacks $$delegate_0;
    final /* synthetic */ ActivityWatcher this$0;

    public void onActivityCreated(Activity activity, Bundle bundle) {
        this.$$delegate_0.onActivityCreated(activity, bundle);
    }

    public void onActivityPaused(Activity activity) {
        this.$$delegate_0.onActivityPaused(activity);
    }

    public void onActivityResumed(Activity activity) {
        this.$$delegate_0.onActivityResumed(activity);
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        this.$$delegate_0.onActivitySaveInstanceState(activity, bundle);
    }

    public void onActivityStarted(Activity activity) {
        this.$$delegate_0.onActivityStarted(activity);
    }

    public void onActivityStopped(Activity activity) {
        this.$$delegate_0.onActivityStopped(activity);
    }

    ActivityWatcher$lifecycleCallbacks$1(ActivityWatcher this$02) {
        this.this$0 = this$02;
        Class javaClass$iv$iv = Application.ActivityLifecycleCallbacks.class;
        Object newProxyInstance = Proxy.newProxyInstance(javaClass$iv$iv.getClassLoader(), new Class[]{javaClass$iv$iv}, ObjectsKt.NO_OP_HANDLER);
        if (newProxyInstance != null) {
            this.$$delegate_0 = (Application.ActivityLifecycleCallbacks) newProxyInstance;
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.app.Application.ActivityLifecycleCallbacks");
    }

    public void onActivityDestroyed(Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        this.this$0.reachabilityWatcher.expectWeaklyReachable(activity, activity.getClass().getName() + " received Activity#onDestroy() callback");
    }
}
