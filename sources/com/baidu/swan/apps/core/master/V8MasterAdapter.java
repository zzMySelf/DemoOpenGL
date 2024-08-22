package com.baidu.swan.apps.core.master;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.v8engine.JsCodeCacheCallback;
import com.baidu.searchbox.v8engine.JsCodeCacheResult;
import com.baidu.swan.apps.SwanAppLibConfig;
import com.baidu.swan.apps.core.SwanAppWebPageCallback;
import com.baidu.swan.apps.core.cache.CodeCacheConstants;
import com.baidu.swan.apps.core.cache.V8CodeCacheHelper;
import com.baidu.swan.apps.core.container.JSContainer;
import com.baidu.swan.apps.core.turbo.AppReadyEvent;
import com.baidu.swan.apps.core.turbo.SwanAppCoreRuntime;
import com.baidu.swan.apps.engine.AiBaseV8Engine;
import com.baidu.swan.apps.engine.V8LoadingCallback;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;

public class V8MasterAdapter implements SwanAppMasterContainer {
    /* access modifiers changed from: private */
    public static final boolean DEBUG = SwanAppLibConfig.DEBUG;
    private static final String TAG = "V8MasterAdapter";
    /* access modifiers changed from: private */
    public boolean mAppCached;
    private String mAppJsPath;
    /* access modifiers changed from: private */
    public boolean mFrameCached;
    /* access modifiers changed from: private */
    public String mJSUrl;
    private SwanCoreVersion mSwanCoreVersion;
    private SwanAppV8Master mV8Master;

    public V8MasterAdapter(Context context) {
    }

    public String getWebViewId() {
        SwanAppV8Master swanAppV8Master = this.mV8Master;
        if (swanAppV8Master != null) {
            return swanAppV8Master.getEngineID();
        }
        if (!DEBUG) {
            return "";
        }
        Log.d(TAG, Log.getStackTraceString(new Exception("illegal state")));
        return "";
    }

    public void loadUrl(String url) {
        if (this.mV8Master == null) {
            String baseUrl = SwanAppCoreRuntime.getInstance().getSwanCoreBasePath();
            this.mSwanCoreVersion = SwanAppCoreRuntime.getInstance().getSwanCoreVersion();
            SwanAppV8Master createMaster = createMaster(baseUrl);
            this.mV8Master = createMaster;
            this.mJSUrl = url;
            createMaster.setJSCodeCacheCallback(new JsCodeCacheCallback() {
                public void onJsCodeCacheFinished(JsCodeCacheResult jsCodeCacheResult) {
                    if (V8MasterAdapter.DEBUG) {
                        Log.d(V8MasterAdapter.TAG, jsCodeCacheResult != null ? jsCodeCacheResult.toString() : "null");
                    }
                    if (jsCodeCacheResult != null && jsCodeCacheResult.isCacheUsed) {
                        if (TextUtils.equals(jsCodeCacheResult.businessId, "appframe")) {
                            boolean unused = V8MasterAdapter.this.mFrameCached = true;
                        } else if (TextUtils.equals(jsCodeCacheResult.businessId, "appjs")) {
                            boolean unused2 = V8MasterAdapter.this.mAppCached = true;
                        }
                    }
                }
            });
        } else if (DEBUG) {
            Log.e(TAG, Log.getStackTraceString(new Exception("same instance loadUrl should not be call twice.")));
        }
    }

    public void setWebPageCallback(final SwanAppWebPageCallback callback) {
        SwanAppV8Master swanAppV8Master = this.mV8Master;
        if (swanAppV8Master != null) {
            swanAppV8Master.setV8LoadingCallback(new V8LoadingCallback() {
                public void onReady(AiBaseV8Engine engine) {
                    SwanAppWebPageCallback swanAppWebPageCallback = callback;
                    if (swanAppWebPageCallback != null) {
                        swanAppWebPageCallback.onPageFinished(V8MasterAdapter.this.mJSUrl);
                    }
                }
            });
        }
    }

    public void destroy() {
        SwanAppV8Master swanAppV8Master = this.mV8Master;
        if (swanAppV8Master != null) {
            swanAppV8Master.finish();
        }
    }

    public void attachActivity(Activity activity) {
        SwanAppV8Master swanAppV8Master = this.mV8Master;
        if (swanAppV8Master != null) {
            swanAppV8Master.attachContextToBridge(activity);
        }
    }

    public JSContainer getJSContainer() {
        return this.mV8Master.getV8Engine();
    }

    public SwanCoreVersion getSwanCoreVersion() {
        return this.mSwanCoreVersion;
    }

    public void onPreAppReadyEventDispatch(AppReadyEvent event) {
        if (event != null) {
            if (DEBUG) {
                Log.d(TAG, "pathList item: " + event.appPath);
            }
            this.mAppJsPath = event.appPath;
            this.mV8Master.setCodeCacheSetting(V8CodeCacheHelper.buildCacheSetting("appjs", event.appPath));
        }
    }

    public void recoverGc() {
        this.mV8Master.recoverGc();
    }

    public void closeGc() {
        this.mV8Master.closeGc();
    }

    @CodeCacheConstants.CacheStatus
    public int getCodeCacheStatus() {
        return V8CodeCacheHelper.getCodeCacheStatus(this.mFrameCached, this.mAppCached);
    }

    /* access modifiers changed from: protected */
    public SwanAppV8Master createMaster(String baseUrl) {
        return new SwanAppV8Master(baseUrl, SwanAppCoreRuntime.MASTER_JS_PATH);
    }
}
