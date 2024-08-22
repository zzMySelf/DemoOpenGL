package fe.mmm.qw.p030switch.th;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* renamed from: fe.mmm.qw.switch.th.qw  reason: invalid package */
public class qw implements Application.ActivityLifecycleCallbacks {

    /* renamed from: ad  reason: collision with root package name */
    public static int f8324ad;

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
        f8324ad++;
        fe.mmm.qw.i.qw.ad("ActivityLifecycleManager", "sFrontActivityCount = " + f8324ad);
    }

    public void onActivityStopped(Activity activity) {
        f8324ad--;
        fe.mmm.qw.i.qw.ad("ActivityLifecycleManager", "sFrontActivityCount = " + f8324ad);
    }
}
