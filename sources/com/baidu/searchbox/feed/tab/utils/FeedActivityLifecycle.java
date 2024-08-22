package com.baidu.searchbox.feed.tab.utils;

import android.app.Activity;
import android.os.Bundle;
import com.baidu.searchbox.appframework.BdBoxActivityLifecycle;
import com.baidu.searchbox.feed.controller.OtherSceneBackToHomeManager;

public class FeedActivityLifecycle implements BdBoxActivityLifecycle.IActivityLifecycle {
    private static final String TAG = "FeedActivityLifecycle";

    public void onActivityResumed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
        OtherSceneBackToHomeManager.getInstance().setPreActivityName(activity.getClass().getSimpleName());
    }

    public void onBackgroundToForeground(Activity activity) {
    }

    public void onForegroundToBackground(Activity activity) {
        OtherSceneBackToHomeManager.getInstance().onForegroundToBackground(activity);
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }
}
