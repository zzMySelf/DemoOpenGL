package com.baidu.searchbox.shake;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.shake.update.model.OperaShakeItemModel;
import com.baidu.searchbox.shake.update.tool.DebugShakeUtils;
import com.baidu.searchbox.shake.update.tool.GlobalShakeModelUtils;
import com.baidu.searchbox.shake.update.tool.ShakeModeUtils;
import java.util.List;

public class GlobalAppStatusUtils {
    private static final boolean DEBUG = AppConfig.isDebug();
    private static final String TAG = "GlobalAppStatusUtils";
    private static GlobalAppStatusUtils mInstance = null;
    private boolean mIsTargetSwanApp;
    private long mLastSwanAppStatusChangeTime = -1;
    private boolean mainAppIsForeground;
    private int swanAppForeground = 0;
    private boolean swapAppIsForeground;
    private int targetSwanAppForeground = 0;

    private GlobalAppStatusUtils() {
    }

    public static GlobalAppStatusUtils getInstance() {
        if (mInstance == null) {
            synchronized (GlobalAppStatusUtils.class) {
                if (mInstance == null) {
                    mInstance = new GlobalAppStatusUtils();
                }
            }
        }
        return mInstance;
    }

    public long getLastSwanAppStatusChangeTime() {
        return this.mLastSwanAppStatusChangeTime;
    }

    public boolean getMainAppIsForeground() {
        return this.mainAppIsForeground;
    }

    public void setMainAppIsForeground(boolean isForeground) {
        if (DEBUG) {
            Log.i(TAG, "set mainAppIsForeground = " + isForeground);
        }
        this.mainAppIsForeground = isForeground;
    }

    public boolean getSwapAppIsForeground() {
        return this.swanAppForeground > 0;
    }

    public void setSwapAppIsForeground(boolean isForeground) {
        if (DEBUG) {
            Log.i(TAG, "set swapAppIsForeground = " + isForeground);
        }
        this.swapAppIsForeground = isForeground;
    }

    public boolean getAppIsForeground() {
        DebugShakeUtils.log("getAppIsForeground()");
        DebugShakeUtils.log("swapAppIsForeground = " + this.swapAppIsForeground + " mainAppIsForeground = " + this.mainAppIsForeground);
        return getSwapAppIsForeground() || this.mainAppIsForeground;
    }

    public void notifySwanAppStatus(String appKey, boolean isForeground) {
        boolean z = DEBUG;
        if (z) {
            Log.i(TAG, "appKey : " + appKey);
        }
        this.mLastSwanAppStatusChangeTime = System.currentTimeMillis();
        this.mIsTargetSwanApp = isHitAvoidSwanAppKey(appKey);
        this.swapAppIsForeground = isForeground;
        if (z) {
            Log.i(TAG, "notifySwanAppStatus------isTargetSwanApp :" + this.mIsTargetSwanApp + " isForeground :" + isForeground);
        }
        if (isForeground) {
            this.swanAppForeground++;
        } else {
            this.swanAppForeground--;
        }
        if (this.mIsTargetSwanApp) {
            if (isForeground) {
                this.targetSwanAppForeground++;
            } else {
                this.targetSwanAppForeground--;
            }
        }
        if (z) {
            Log.i(TAG, "targetSwanAppForeground :" + this.targetSwanAppForeground + " swanAppForeground :" + this.swanAppForeground);
        }
        if (!getMainAppIsForeground()) {
            int i2 = this.targetSwanAppForeground;
            if (i2 > 0 && this.swanAppForeground > 0) {
                BDShakePowerManager.globalShakeOff(ShakeModeUtils.BAIDU_FUNCTION);
                DebugShakeUtils.log("小程序通知：解注册全局摇一摇");
            } else if (i2 <= 0 && this.swanAppForeground > 0) {
                BDShakePowerManager.globalShakeOn(ShakeModeUtils.BAIDU_FUNCTION);
                DebugShakeUtils.log("小程序通知：注册全局摇一摇");
            } else if (i2 <= 0) {
                BDShakePowerManager.globalShakeOff(ShakeModeUtils.BAIDU_FUNCTION);
                DebugShakeUtils.log("小程序通知：解注册全局摇一摇");
            }
        }
    }

    public boolean isHitAvoidSwanAppKey(String appKey) {
        List<String> mAvoidSwanAppKey;
        OperaShakeItemModel model = GlobalShakeModelUtils.getCurrentGlobalShakeModel();
        if (!(TextUtils.isEmpty(appKey) || model == null || (mAvoidSwanAppKey = model.getAppKeyList()) == null)) {
            for (String ak : mAvoidSwanAppKey) {
                if (!TextUtils.isEmpty(ak) && appKey.startsWith(ak)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isTargetSwanApp() {
        return this.mIsTargetSwanApp;
    }
}
