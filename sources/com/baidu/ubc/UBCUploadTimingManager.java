package com.baidu.ubc;

import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import com.baidu.searchbox.preload.business.inner.PreloadConstantsKt;
import com.baidu.ubc.constants.EnumConstants;

public class UBCUploadTimingManager {
    /* access modifiers changed from: private */
    public static final boolean DEBUG = UBCHelper.isDebug();
    private static final int NETWORK_FILTER_PERIOD = 60000;
    private static final String TAG = "UBCUploadTimingManager";
    private static volatile UBCUploadTimingManager mInstance;
    /* access modifiers changed from: private */
    public int mActivityCount;
    private Application mApplication;
    private int mCurrentEventCount = 0;
    private int mCurrentFlowCount = 0;
    private int mCurrentUploadTaskCount = 0;
    private UBCDatabaseAdapter mDbAdapter;
    private long mInitialClockTime = 0;
    private long mInitialTime = 0;
    private boolean mIsForeground = false;
    private long mLastNetworkChangeTime = 0;
    private UploadTimingCallback mTimingCallback;
    private int mUploadNumberThreshold = 100;

    public static class LogNumber {
        public int eventCount;
        public int flowCount;
    }

    public interface UploadTimingCallback {
        void onBackgroundToForeground();

        void onForegroundToBackground();

        void onLogTooMany();

        void onNetworkAvailable();
    }

    static /* synthetic */ int access$308(UBCUploadTimingManager x0) {
        int i2 = x0.mActivityCount;
        x0.mActivityCount = i2 + 1;
        return i2;
    }

    static /* synthetic */ int access$310(UBCUploadTimingManager x0) {
        int i2 = x0.mActivityCount;
        x0.mActivityCount = i2 - 1;
        return i2;
    }

    private UBCUploadTimingManager() {
    }

    public static UBCUploadTimingManager getInstance() {
        if (mInstance == null) {
            synchronized (UBCUploadTimingManager.class) {
                if (mInstance == null) {
                    mInstance = new UBCUploadTimingManager();
                }
            }
        }
        return mInstance;
    }

    public void init(Context context, UBCDatabaseAdapter dbAdapter, UploadTimingCallback callback) {
        if (context == null) {
            YalogHelper.saveRuntimeLogWithMsg("context is null", EnumConstants.RunTime.CONTEXT_IS_NULL);
            return;
        }
        if (!(context instanceof Application)) {
            YalogHelper.saveRuntimeLogWithMsg("context is not Application", EnumConstants.RunTime.INIT_MESSAGE);
        }
        Application application = (Application) context;
        this.mApplication = application;
        application.registerActivityLifecycleCallbacks(new LifeCycleListener());
        IntentFilter filter = new IntentFilter();
        filter.addAction(PreloadConstantsKt.CONNECTIVITY_ACTION);
        this.mApplication.registerReceiver(new ConnectReceiver(), filter);
        this.mDbAdapter = dbAdapter;
        this.mTimingCallback = callback;
        LogNumber logNumber = dbAdapter.getLogNumbers();
        this.mCurrentEventCount = Math.max(logNumber.eventCount, 0);
        this.mCurrentFlowCount = Math.max(logNumber.flowCount, 0);
        this.mUploadNumberThreshold = BehaviorRuleManager.getInstance().getUploadTriggerNum();
        try {
            IntentFilter timeFilter = new IntentFilter();
            timeFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
            timeFilter.addAction("android.intent.action.TIME_SET");
            this.mApplication.registerReceiver(new TimeReceiver(), timeFilter);
            this.mInitialTime = System.currentTimeMillis();
            this.mInitialClockTime = SystemClock.elapsedRealtime();
        } catch (Exception e2) {
        }
    }

    public boolean isForeground() {
        return this.mIsForeground;
    }

    public void onStartUpload() {
        this.mCurrentUploadTaskCount++;
    }

    public void onUploadFinish(boolean isSuccess) {
        if (DEBUG) {
            Log.d(TAG, "onUploadFinish isSuccess: " + isSuccess);
        }
        this.mCurrentUploadTaskCount = Math.max(this.mCurrentUploadTaskCount - 1, 0);
        if (isSuccess) {
            onUploadSuccess();
        }
    }

    public void onNewEvent(String eventId, int flowHandle) {
        if (flowHandle == -1 && BehaviorRuleManager.getInstance().checkSend(eventId)) {
            if (DEBUG) {
                Log.d(TAG, "onNewEvent id=" + eventId + ", currentEventCount=" + this.mCurrentEventCount);
            }
            checkNumTrigger(false, 0, 1);
        }
    }

    public void onNewFlow(String flowId, int count) {
        if (count > 0 && BehaviorRuleManager.getInstance().checkSend(flowId)) {
            if (DEBUG) {
                Log.d(TAG, "onNewFlow id=" + flowId + ", currentFlowCount=" + this.mCurrentFlowCount);
            }
            checkNumTrigger(false, count, 0);
        }
    }

    public void onClearData(int eventCount, int flowCount) {
        if (eventCount >= 0 && flowCount >= 0 && eventCount + flowCount != 0) {
            if (DEBUG) {
                Log.d(TAG, "onClearData eventCount=" + eventCount + ", flowCount=" + flowCount);
            }
            this.mCurrentEventCount = Math.max(this.mCurrentEventCount - eventCount, 0);
            this.mCurrentFlowCount = Math.max(this.mCurrentFlowCount - flowCount, 0);
        }
    }

    public void onClearDataAndReset() {
        if (DEBUG) {
            Log.d(TAG, "onClearDataAndReset");
        }
        LogNumber logNumber = this.mDbAdapter.getLogNumbers();
        this.mCurrentEventCount = Math.max(logNumber.eventCount, 0);
        this.mCurrentFlowCount = Math.max(logNumber.flowCount, 0);
    }

    private void checkNumTrigger(boolean fromUploadFinish, int flowCount, int eventCount) {
        if (!fromUploadFinish) {
            boolean lessThanThresholdBefore = isNumLessThanThreshold();
            this.mCurrentFlowCount += flowCount;
            this.mCurrentEventCount += eventCount;
            if (lessThanThresholdBefore && !isNumLessThanThreshold()) {
                onLogTooMany();
            }
        } else if (!isNumLessThanThreshold()) {
            onLogTooMany();
        }
    }

    private boolean isNumLessThanThreshold() {
        return this.mCurrentEventCount + this.mCurrentFlowCount < this.mUploadNumberThreshold;
    }

    /* access modifiers changed from: private */
    public void onBackgroundToForeground() {
        if (DEBUG) {
            Log.d(TAG, "onBackgroundToForeground");
        }
        this.mIsForeground = true;
        UploadTimingCallback uploadTimingCallback = this.mTimingCallback;
        if (uploadTimingCallback != null) {
            uploadTimingCallback.onBackgroundToForeground();
        }
    }

    /* access modifiers changed from: private */
    public void onForegroundToBackground() {
        if (DEBUG) {
            Log.d(TAG, "onForegroundToBackground");
        }
        this.mIsForeground = false;
        UploadTimingCallback uploadTimingCallback = this.mTimingCallback;
        if (uploadTimingCallback != null) {
            uploadTimingCallback.onForegroundToBackground();
        }
    }

    /* access modifiers changed from: private */
    public void onNetworkAvailable() {
        boolean z = DEBUG;
        if (z) {
            Log.d(TAG, "onNetworkAvailable");
        }
        long current = System.currentTimeMillis();
        if (current - this.mLastNetworkChangeTime > 60000) {
            UploadTimingCallback uploadTimingCallback = this.mTimingCallback;
            if (uploadTimingCallback != null) {
                uploadTimingCallback.onNetworkAvailable();
            }
            if (z) {
                Log.d(TAG, "onNetworkAvailable filter completed!");
            }
        }
        this.mLastNetworkChangeTime = current;
    }

    private void onLogTooMany() {
        if (DEBUG) {
            Log.d(TAG, "onLogTooMany");
        }
        UploadTimingCallback uploadTimingCallback = this.mTimingCallback;
        if (uploadTimingCallback != null) {
            uploadTimingCallback.onLogTooMany();
        }
    }

    private void onUploadSuccess() {
        checkNumTrigger(true, 0, 0);
        if (this.mCurrentUploadTaskCount == 0) {
            if (DEBUG) {
                Log.d(TAG, "onUploadSuccess processOneFailedData");
            }
            BehaviorProcessor.getInstance().processOneFailedData();
        }
    }

    /* access modifiers changed from: private */
    public void onSystemTimeChanged(String action) {
        if (DEBUG) {
            Log.d(TAG, "onTimeChanged");
        }
        long currentClockTime = SystemClock.elapsedRealtime();
        long oldTime = (currentClockTime - this.mInitialClockTime) + this.mInitialTime;
        this.mInitialTime = System.currentTimeMillis();
        this.mInitialClockTime = currentClockTime;
        UBCQualityStatics.getInstance().onSystemTimeChanged(action, oldTime, this.mInitialTime, this.mInitialClockTime);
        YalogHelper.saveRuntimeLogWithMsg("action:" + action + " oldTime:" + oldTime + " newTime:" + this.mInitialTime + " clockTime:" + this.mInitialClockTime, EnumConstants.RunTime.TIMING_SYSTEM_TIME_CHANGED);
    }

    private class LifeCycleListener implements Application.ActivityLifecycleCallbacks {
        private LifeCycleListener() {
        }

        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        }

        public void onActivityStarted(Activity activity) {
            UBCUploadTimingManager.access$308(UBCUploadTimingManager.this);
            if (UBCUploadTimingManager.this.mActivityCount == 1) {
                UBCUploadTimingManager.this.onBackgroundToForeground();
            }
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
            YalogHelper.saveRuntimeLogWithMsg(activity.getLocalClassName(), EnumConstants.RunTime.TIMING_ACTIVITY_PAUSE);
        }

        public void onActivityStopped(Activity activity) {
            UBCUploadTimingManager.access$310(UBCUploadTimingManager.this);
            YalogHelper.saveRuntimeLogWithMsg(activity.getLocalClassName(), EnumConstants.RunTime.TIMING_ACTIVITY_STOP);
            if (UBCUploadTimingManager.this.mActivityCount == 0) {
                UBCUploadTimingManager.this.onForegroundToBackground();
            }
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        }

        public void onActivityDestroyed(Activity activity) {
        }
    }

    private class ConnectReceiver extends BroadcastReceiver {
        private ConnectReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            ConnectivityManager manager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
            if (manager != null) {
                try {
                    NetworkInfo info = manager.getActiveNetworkInfo();
                    if (info != null && info.isConnectedOrConnecting()) {
                        UBCUploadTimingManager.this.onNetworkAvailable();
                    }
                } catch (Exception e2) {
                    if (UBCUploadTimingManager.DEBUG) {
                        Log.d(UBCUploadTimingManager.TAG, "get network info error!");
                    }
                }
            }
        }
    }

    private class TimeReceiver extends BroadcastReceiver {
        private TimeReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            UBCUploadTimingManager.this.onSystemTimeChanged(intent.getAction());
        }
    }
}
