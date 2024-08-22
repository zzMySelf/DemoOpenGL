package com.baidu.searchbox.push;

import android.util.Log;
import com.baidu.searchbox.abtest.AbTestManager;
import com.baidu.searchbox.bridge.MessageRuntime;
import com.baidu.searchbox.config.QuickPersistConfig;

public class PushABTestManager {
    public static final int ABTEST_DEFAULT = 0;
    public static final int ABTEST_TEST = 1;
    public static final String BASIC_NOTICE_SHIELD = "basic_Notice_shield";
    private static final boolean DEBUG = MessageRuntime.GLOBAL_DEBUG;
    public static final String NEW_USER_NOTICE_FREQUENCY = "user_notice_new_frequency";
    public static final String PUSH_HOME_OPT_KEY = "enable_push_home_opt";
    private static final String PUSH_WEBKIT_OPT_KEY = "enable_push_webkit_opt";
    private static final String TAG = PushABTestManager.class.getSimpleName();
    private static volatile PushABTestManager sInstance = null;
    private boolean mEnablePushHomeOpt = QuickPersistConfig.getInstance().getBoolean(PUSH_HOME_OPT_KEY, true);
    private boolean mEnablePushWebkitOpt = QuickPersistConfig.getInstance().getBoolean(PUSH_WEBKIT_OPT_KEY, true);

    public static PushABTestManager getInstance() {
        if (sInstance == null) {
            synchronized (PushABTestManager.class) {
                if (sInstance == null) {
                    sInstance = new PushABTestManager();
                }
            }
        }
        return sInstance;
    }

    private PushABTestManager() {
        if (DEBUG) {
            Log.d(TAG, "PushABTestManager mEnablePushWebkitOpt = " + this.mEnablePushWebkitOpt + "mEnablePushHomeOpt = " + this.mEnablePushHomeOpt);
        }
    }

    public boolean enablePushHomeOpt() {
        return this.mEnablePushHomeOpt;
    }

    public boolean enablePushWebkitOpt() {
        return this.mEnablePushWebkitOpt;
    }

    public void updatePushAB() {
        boolean enablePushWebkitOpt = AbTestManager.getInstance().getSwitch(PUSH_WEBKIT_OPT_KEY, true);
        boolean enablePushHomeOpt = AbTestManager.getInstance().getSwitch(PUSH_HOME_OPT_KEY, true);
        if (DEBUG) {
            Log.d(TAG, "updateFlyingAB enablePushWebkitOpt:" + enablePushWebkitOpt + " enablePushHomeOpt:" + enablePushHomeOpt);
        }
        QuickPersistConfig.getInstance().putBoolean(PUSH_WEBKIT_OPT_KEY, enablePushWebkitOpt);
        QuickPersistConfig.getInstance().putBoolean(PUSH_HOME_OPT_KEY, enablePushHomeOpt);
    }
}
