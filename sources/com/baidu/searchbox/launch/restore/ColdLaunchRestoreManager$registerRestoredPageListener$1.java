package com.baidu.searchbox.launch.restore;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.searchbox.appframework.BaseActivity;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.launch.restore.ColdLaunchRestoreManager;
import com.baidu.searchbox.launch.restore.interfaces.IRestorablePage;
import com.baidu.searchbox.launch.restore.utils.ConstKt;
import java.lang.ref.WeakReference;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t"}, d2 = {"com/baidu/searchbox/launch/restore/ColdLaunchRestoreManager$registerRestoredPageListener$1", "Lcom/baidu/searchbox/launch/restore/ActivityLifecycleAdapter;", "onActivityCreated", "", "activity", "Landroid/app/Activity;", "bundle", "Landroid/os/Bundle;", "onActivityStarted", "lib-app-launch-restore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ColdLaunchRestoreManager.kt */
public final class ColdLaunchRestoreManager$registerRestoredPageListener$1 extends ActivityLifecycleAdapter {
    final /* synthetic */ ColdLaunchRestoreManager.RestoreResultCallback $callback;
    final /* synthetic */ Runnable $workaround;

    ColdLaunchRestoreManager$registerRestoredPageListener$1(Runnable $workaround2, ColdLaunchRestoreManager.RestoreResultCallback $callback2) {
        this.$workaround = $workaround2;
        this.$callback = $callback2;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        if (activity instanceof IRestorablePage) {
            UiThreadUtils.getMainHandler().removeCallbacks(this.$workaround);
            ColdLaunchRestoreManager.INSTANCE.callbackResult(this.$callback, true);
            if (AppConfig.isDebug()) {
                Log.d(ConstKt.LOG_TAG, "registerRestoredPageListener: restored activity oncreated.");
            }
        }
    }

    public void onActivityStarted(Activity activity) {
        if (activity instanceof IRestorablePage) {
            ColdLaunchRestoreManager.INSTANCE.unregisterRestoredPageListener();
            if (activity instanceof BaseActivity) {
                ((BaseActivity) activity).setEnterPendingTransition(0, 0);
            }
            View rootView = ((ViewGroup) activity.getWindow().findViewById(16908290)).getChildAt(0);
            if (rootView != null) {
                rootView.getViewTreeObserver().addOnPreDrawListener(new ColdLaunchRestoreManager$registerRestoredPageListener$1$onActivityStarted$1(new WeakReference(rootView), activity));
            }
        }
    }
}
