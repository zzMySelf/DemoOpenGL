package com.baidu.swan.apps.extcore.cores;

import android.util.Log;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.SwanAppLibConfig;
import com.baidu.swan.apps.console.SwanAppLog;
import com.baidu.swan.apps.extcore.SwanExtensionCoreManager;
import com.baidu.swan.apps.swancore.SwanAppSwanCoreManager;
import com.baidu.swan.apps.swancore.preset.PresetSwanCoreUpdater;
import com.baidu.swan.apps.util.typedbox.TypedCallback;

public class SwanAppCoresManager {
    private static final boolean DEBUG = SwanAppLibConfig.DEBUG;
    private static final String TAG = "SwanAppCoresManager";
    private static volatile SwanAppCoresManager sInstance;

    public static SwanAppCoresManager getInstance() {
        if (sInstance == null) {
            synchronized (SwanAppCoresManager.class) {
                if (sInstance == null) {
                    sInstance = new SwanAppCoresManager();
                }
            }
        }
        return sInstance;
    }

    public void ensureSwanCore(final TypedCallback<Exception> callback, final int frameType) {
        SwanAppLog.logToFile(TAG, "ensureSwanCore: invoke frameType = " + frameType);
        tryUpdatePresetCoresAsync(new TypedCallback<Exception>() {
            public void onCallback(Exception msg) {
                if (msg == null) {
                    SwanAppLog.logToFile(SwanAppCoresManager.TAG, "ensureSwanCore: done by update preset ");
                    TypedCallback typedCallback = callback;
                    if (typedCallback != null) {
                        typedCallback.onCallback(null);
                        return;
                    }
                    return;
                }
                SwanAppLog.logToFile(SwanAppCoresManager.TAG, "ensureSwanCore: update preset failed ");
                SwanAppSwanCoreManager.requestUpdateSwanCore(frameType, new TypedCallback<Exception>() {
                    public void onCallback(Exception msg) {
                        SwanAppLog.logToFile(SwanAppCoresManager.TAG, "ensureSwanCore: update swan-js finish. ", msg);
                        if (callback != null) {
                            callback.onCallback(msg);
                        }
                    }
                });
            }
        }, frameType);
    }

    private void tryUpdatePresetCoresAsync(final TypedCallback<Exception> callback, final int frameType) {
        PresetSwanCoreUpdater.getInstance().updateSwanCoreAsync(new TypedCallback<Exception>() {
            public void onCallback(Exception msg) {
                if (msg != null) {
                    TypedCallback typedCallback = callback;
                    if (typedCallback != null) {
                        typedCallback.onCallback(msg);
                        return;
                    }
                    return;
                }
                SwanExtensionCoreManager.tryUpdatePresetAsync(frameType, new TypedCallback<Exception>() {
                    public void onCallback(Exception msg) {
                        if (callback != null) {
                            callback.onCallback(msg);
                        }
                    }
                });
            }
        }, frameType);
    }

    public void tryUpdateAllPresetCoresAsync() {
        ExecutorUtilsExt.postOnElastic(new Runnable() {
            public void run() {
                SwanAppCoresManager.this.doTryUpdateAllPresetCoresAsync();
            }
        }, "tryUpdateAllPresetCoresAsync", 2);
    }

    /* access modifiers changed from: private */
    public void doTryUpdateAllPresetCoresAsync() {
        PresetSwanCoreUpdater.getInstance().updateSwanCoreAsync((TypedCallback<Exception>) null, 0);
        PresetSwanCoreUpdater.getInstance().updateSwanCoreAsync((TypedCallback<Exception>) null, 1);
        SwanExtensionCoreManager.tryUpdatePresetAsync(0, (TypedCallback<Exception>) null);
        SwanExtensionCoreManager.tryUpdatePresetAsync(1, (TypedCallback<Exception>) null);
    }

    public void onAppUpgrade(int oldVersion, int newVersion) {
        if (DEBUG) {
            Log.d(TAG, "onAppUpgrade oldVersion: " + oldVersion + " ,newVersion: " + newVersion);
        }
        SwanAppSwanCoreManager.onAppUpgrade(oldVersion, newVersion);
        SwanExtensionCoreManager.onAppUpgrade(oldVersion, newVersion);
    }
}
