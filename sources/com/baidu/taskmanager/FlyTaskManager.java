package com.baidu.taskmanager;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.abtest.AbTestManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.config.QuickPersistConfig;
import com.baidu.taskmanager.ioc.ILaunchTaskManagerIOC;
import com.baidu.taskmanager.ioc.LaunchTaskManagerRuntime;
import com.baidu.taskmanager.recognizers.SchemeRecognizers;

public class FlyTaskManager {
    private static final boolean DEBUG = AppConfig.isDebug();
    public static final String SCHEME_PRIORITY_ENABLE_KEY = "scheme_priority_enable";
    private static final String TAG = "FlyTaskManager";
    private static volatile FlyTaskManager sInstance = null;
    private ITaskManager mAsyncLaunchTaskManager;
    private ITaskManager mIdleLaunchTaskManager;
    private String mPriorityBusinessId = null;
    private int mSceneType = 2;
    private ITaskManager mSmartLaunchTaskManager;

    private FlyTaskManager() {
        ILaunchTaskManagerIOC runtime = LaunchTaskManagerRuntime.get();
        this.mAsyncLaunchTaskManager = runtime.getAsyncTaskManager();
        this.mIdleLaunchTaskManager = runtime.getIdleTaskManager();
        this.mSmartLaunchTaskManager = runtime.getSmartTaskManager();
    }

    public static FlyTaskManager getInstance() {
        if (sInstance == null) {
            synchronized (FlyTaskManager.class) {
                if (sInstance == null) {
                    sInstance = new FlyTaskManager();
                }
            }
        }
        return sInstance;
    }

    public void onSceneEntered(int type) {
        if (DEBUG) {
            Log.d(TAG, "onSceneEntered type:" + type + " priority businessId:" + this.mPriorityBusinessId);
        }
        switch (type) {
            case 0:
                if (this.mSceneType == 1 && !TextUtils.isEmpty(this.mPriorityBusinessId)) {
                    this.mIdleLaunchTaskManager.requestStopPriorityScheduling(this.mPriorityBusinessId);
                    break;
                }
        }
        this.mSceneType = type;
    }

    public void requestPrioritySchedulingWithScheme(String scheme) {
        if (DEBUG) {
            Log.d(TAG, "requestPrioritySchedulingWithScheme scheme:" + scheme);
        }
        requestPriorityScheduling(SchemeRecognizers.getInstance().recognize(scheme));
    }

    public void requestPriorityScheduling(String businessId) {
        if (!TextUtils.isEmpty(businessId)) {
            this.mPriorityBusinessId = businessId;
            ITaskManager iTaskManager = this.mIdleLaunchTaskManager;
            if (iTaskManager != null) {
                iTaskManager.registerTasks(AppRuntime.getAppContext());
                this.mIdleLaunchTaskManager.requestPriorityScheduling(businessId);
            }
        } else if (DEBUG) {
            Log.d(TAG, "requestPriorityScheduling businessId is null!");
        }
    }

    public void registerDelayTasks(Context context) {
        ITaskManager iTaskManager = this.mAsyncLaunchTaskManager;
        if (iTaskManager != null && this.mIdleLaunchTaskManager != null) {
            iTaskManager.registerTasks(context);
            this.mIdleLaunchTaskManager.registerTasks(context);
        }
    }

    public void registerSmartTasks(Context context) {
        ITaskManager iTaskManager = this.mSmartLaunchTaskManager;
        if (iTaskManager != null) {
            iTaskManager.registerTasks(context);
        }
    }

    public boolean enableFlyingSchedule() {
        return true;
    }

    public static void updateFlyingAB() {
        QuickPersistConfig.getInstance().putBoolean(SCHEME_PRIORITY_ENABLE_KEY, AbTestManager.getInstance().getSwitch(SCHEME_PRIORITY_ENABLE_KEY, true));
    }
}
