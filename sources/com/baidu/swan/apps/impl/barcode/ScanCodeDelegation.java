package com.baidu.swan.apps.impl.barcode;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import com.baidu.searchbox.plugin.api.PluginInvoker;
import com.baidu.swan.api.deprecations.interfaces.IImageSearchCallback;
import com.baidu.swan.apps.SwanAppLibConfig;
import com.baidu.swan.apps.impl.ioc.SwanAppAchieve;
import com.baidu.swan.apps.ipc.delegate.SwanPluginBaseDelegation;
import com.baidu.swan.apps.util.typedbox.TypedCallback;

public class ScanCodeDelegation extends SwanPluginBaseDelegation {
    /* access modifiers changed from: private */
    public static final boolean DEBUG = SwanAppLibConfig.DEBUG;
    private static final String PLUGIN_PACKAGE_NAME = "com.baidu.searchbox.godeye";
    public static final String RESULT_CODE = "status_code";
    public static final String RESULT_DATA = "data";
    private static final String TAG = "ScanCodeDelegation";

    public String getPluginPackageName() {
        return "com.baidu.searchbox.godeye";
    }

    /* access modifiers changed from: protected */
    public boolean onExec() {
        if (!isLegal()) {
            return true;
        }
        if (DEBUG) {
            Log.d(TAG, "ScanCodeDelegation onExec()");
        }
        scanCodeDirectly(getAgent(), this.mParams, new TypedCallback<Bundle>() {
            public void onCallback(Bundle msg) {
                ScanCodeDelegation.this.mResult.putAll(msg);
                ScanCodeDelegation.this.finish();
            }
        });
        return false;
    }

    public void onAgentDestroy() {
        PluginInvoker.removeStartContext(getPluginPackageName());
        super.onAgentDestroy();
    }

    private static IImageSearchCallback getScanCodeCallback(final TypedCallback<Bundle> callback) {
        return new IImageSearchCallback() {
            public void onResult(int resultCode, String result) {
                if (ScanCodeDelegation.DEBUG) {
                    Log.d(ScanCodeDelegation.TAG, "InvokeCallback: status=" + resultCode + ", result=" + result);
                }
                Bundle resultBundle = new Bundle();
                resultBundle.putInt("status_code", resultCode);
                resultBundle.putString("data", result);
                TypedCallback.this.onCallback(resultBundle);
            }
        };
    }

    public static void scanCodeDirectly(Activity activity, Bundle params, TypedCallback<Bundle> callback) {
        if (callback != null) {
            SwanAppAchieve.getAchieve().invokeImageRecognitionPlugin(activity, params, getScanCodeCallback(callback));
        }
    }
}
