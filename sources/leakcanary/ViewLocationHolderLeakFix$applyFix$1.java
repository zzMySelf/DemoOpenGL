package leakcanary;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.lang.reflect.Proxy;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import leakcanary.internal.FragmentExtensionsKt;
import leakcanary.internal.ObjectsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001b\u0010\t\u001a\u00020\u00032\u0010\b\u0001\u0010\n\u001a\n \u000b*\u0004\u0018\u00010\u00050\u0005H\u0001J\u001b\u0010\f\u001a\u00020\u00032\u0010\b\u0001\u0010\n\u001a\n \u000b*\u0004\u0018\u00010\u00050\u0005H\u0001J-\u0010\r\u001a\u00020\u00032\u0010\b\u0001\u0010\n\u001a\n \u000b*\u0004\u0018\u00010\u00050\u00052\u0010\b\u0001\u0010\u000e\u001a\n \u000b*\u0004\u0018\u00010\u00070\u0007H\u0001J\u001b\u0010\u000f\u001a\u00020\u00032\u0010\b\u0001\u0010\n\u001a\n \u000b*\u0004\u0018\u00010\u00050\u0005H\u0001J\u001b\u0010\u0010\u001a\u00020\u00032\u0010\b\u0001\u0010\n\u001a\n \u000b*\u0004\u0018\u00010\u00050\u0005H\u0001¨\u0006\u0011"}, d2 = {"leakcanary/ViewLocationHolderLeakFix$applyFix$1", "Landroid/app/Application$ActivityLifecycleCallbacks;", "onActivityCreated", "", "activity", "Landroid/app/Activity;", "savedInstanceState", "Landroid/os/Bundle;", "onActivityDestroyed", "onActivityPaused", "p0", "kotlin.jvm.PlatformType", "onActivityResumed", "onActivitySaveInstanceState", "p1", "onActivityStarted", "onActivityStopped", "plumber-android_release"}, k = 1, mv = {1, 4, 1})
/* compiled from: ViewLocationHolderLeakFix.kt */
public final class ViewLocationHolderLeakFix$applyFix$1 implements Application.ActivityLifecycleCallbacks {
    private final /* synthetic */ Application.ActivityLifecycleCallbacks $$delegate_0;
    final /* synthetic */ Application $application;

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

    ViewLocationHolderLeakFix$applyFix$1(Application $captured_local_variable$0) {
        this.$application = $captured_local_variable$0;
        Class javaClass$iv$iv = Application.ActivityLifecycleCallbacks.class;
        Object newProxyInstance = Proxy.newProxyInstance(javaClass$iv$iv.getClassLoader(), new Class[]{javaClass$iv$iv}, ObjectsKt.NO_OP_HANDLER);
        if (newProxyInstance != null) {
            this.$$delegate_0 = (Application.ActivityLifecycleCallbacks) newProxyInstance;
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.app.Application.ActivityLifecycleCallbacks");
    }

    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        FragmentExtensionsKt.onAndroidXFragmentViewDestroyed(activity, new ViewLocationHolderLeakFix$applyFix$1$onActivityCreated$1(this));
    }

    public void onActivityDestroyed(Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        ViewLocationHolderLeakFix.INSTANCE.uncheckedClearStaticPool(this.$application);
    }
}
