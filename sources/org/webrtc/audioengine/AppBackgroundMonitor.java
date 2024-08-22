package org.webrtc.audioengine;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import java.lang.ref.WeakReference;

class AppBackgroundMonitor implements Application.ActivityLifecycleCallbacks {
    private static final String TAG = "[NotifyApplicationBackground]";
    private AppBackgroundMonitorListener mAppBackgroundMonitorListener;
    private Application mApplication = null;
    private Runnable mCheck = null;
    private Context mContext;
    private WeakReference<Activity> mCurrentActivity = null;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private boolean mIsBackground = false;

    public AppBackgroundMonitor(Context context, AppBackgroundMonitorListener listener) {
        this.mContext = context;
        this.mAppBackgroundMonitorListener = listener;
    }

    public void onActivityStarted(Activity activity) {
        AppBackgroundMonitorListener appBackgroundMonitorListener;
        this.mCurrentActivity = new WeakReference<>(activity);
        Runnable runnable = this.mCheck;
        if (runnable != null) {
            this.mHandler.removeCallbacks(runnable);
        }
        if (this.mIsBackground && activity != null && !activity.isChangingConfigurations() && (appBackgroundMonitorListener = this.mAppBackgroundMonitorListener) != null) {
            this.mIsBackground = false;
            appBackgroundMonitorListener.notifyAppBackground(false);
        }
    }

    public void onActivityPaused(Activity activity) {
        if (!activity.isChangingConfigurations()) {
            final WeakReference ref = new WeakReference(activity);
            Handler handler = this.mHandler;
            AnonymousClass1 r2 = new Runnable() {
                public void run() {
                    AppBackgroundMonitor.this.onActivityCeased((Activity) ref.get());
                }
            };
            this.mCheck = r2;
            handler.postDelayed(r2, 2000);
        }
    }

    public void onActivityStopped(Activity activity) {
        Runnable runnable = this.mCheck;
        if (runnable != null) {
            this.mHandler.removeCallbacks(runnable);
        }
        onActivityCeased(activity);
    }

    /* access modifiers changed from: private */
    public void onActivityCeased(Activity activity) {
        AppBackgroundMonitorListener appBackgroundMonitorListener;
        if (!this.mIsBackground) {
            WeakReference<Activity> weakReference = this.mCurrentActivity;
            if ((weakReference == null || activity == weakReference.get()) && activity != null && !activity.isChangingConfigurations() && (appBackgroundMonitorListener = this.mAppBackgroundMonitorListener) != null) {
                this.mIsBackground = true;
                appBackgroundMonitorListener.notifyAppBackground(true);
            }
        }
    }

    public void init() {
        Context context = this.mContext;
        if (context != null && (context instanceof Application)) {
            Application application = (Application) context;
            this.mApplication = application;
            application.registerActivityLifecycleCallbacks(this);
            AudioManagerAndroid.doLog("[NotifyApplicationBackground]registerNotifyApplicationBackgound");
        }
        this.mIsBackground = false;
        this.mCheck = null;
        this.mCurrentActivity = null;
    }

    public void uninit() {
        if (this.mApplication != null) {
            Application application = (Application) this.mContext;
            this.mApplication = application;
            application.unregisterActivityLifecycleCallbacks(this);
            this.mApplication = null;
            AudioManagerAndroid.doLog("[NotifyApplicationBackground]unregisterNotifyApplicationBackgound");
        }
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityResumed(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
    }
}
