package com.baidu.searchbox.track.ui;

import android.app.Activity;
import android.os.Bundle;
import com.baidu.searchbox.appframework.SimpleActivityLifeCycle;
import com.baidu.searchbox.track.Constant;

public class TraceActivityCallbacks extends SimpleActivityLifeCycle {
    private TraceFragmentCallbackWrapper mTraceFragmentCallbackWrapper = new TraceFragmentCallbackWrapper();
    private TraceManager mTraceManager = TraceManager.getInstance();

    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        if (this.mTraceManager.isRegistered()) {
            this.mTraceFragmentCallbackWrapper.register(activity);
            String name = null;
            if (TraceManager.checkAPSActivity(activity) && savedInstanceState != null) {
                name = savedInstanceState.getString("ActivityName");
            }
            this.mTraceManager.saveTraceInfo(activity, name, (Object) null, "onCreated");
        }
    }

    public void onActivityResumed(Activity activity) {
        if (this.mTraceManager.isRegistered()) {
            this.mTraceManager.saveTraceInfo(activity, (String) null, (Object) null, Constant.EVENT_ON_RESUMED);
        }
    }

    public void onActivityPaused(Activity activity) {
        if (this.mTraceManager.isRegistered()) {
            this.mTraceManager.saveTraceInfo(activity, (String) null, (Object) null, "onPaused");
        }
    }

    public void onActivityDestroyed(Activity activity) {
        if (this.mTraceManager.isRegistered()) {
            this.mTraceFragmentCallbackWrapper.unregister(activity);
            this.mTraceManager.saveTraceInfo(activity, (String) null, (Object) null, Constant.EVENT_ON_DESTROYED);
        }
    }

    public void registerTraceFragment(Activity activity) {
        this.mTraceFragmentCallbackWrapper.register(activity);
    }

    public void onBackgroundToForeground(Activity activity) {
        super.onBackgroundToForeground(activity);
        if (this.mTraceManager.isRegistered()) {
            this.mTraceManager.saveTraceInfo(activity, true);
        }
    }

    public void onForegroundToBackground(Activity activity) {
        super.onForegroundToBackground(activity);
        if (this.mTraceManager.isRegistered()) {
            this.mTraceManager.saveTraceInfo(activity, false);
        }
    }
}
