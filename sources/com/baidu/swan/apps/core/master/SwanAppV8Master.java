package com.baidu.swan.apps.core.master;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.v8engine.JsCodeCacheCallback;
import com.baidu.searchbox.v8engine.V8EngineConfiguration;
import com.baidu.swan.apps.SwanAppLibConfig;
import com.baidu.swan.apps.binding.SwanAppBindingImpl;
import com.baidu.swan.apps.core.cache.V8CodeCacheHelper;
import com.baidu.swan.apps.core.master.isolation.MasterIdGenerator;
import com.baidu.swan.apps.engine.AiBaseV8Engine;
import com.baidu.swan.apps.engine.JsRuntimeGcOptABSwitcher;
import com.baidu.swan.apps.engine.V8EngineFactory;
import com.baidu.swan.apps.engine.V8EngineModel;
import com.baidu.swan.apps.engine.V8LoadingCallback;
import com.baidu.swan.apps.engine.context.SwanV8ThreadPolicyOpt;
import com.baidu.swan.apps.engine.load.DefaultLoadingPolicy;
import com.baidu.swan.apps.ioc.SwanAppRuntime;
import com.baidu.swan.apps.util.SwanAppUtils;

public class SwanAppV8Master {
    /* access modifiers changed from: private */
    public static final boolean DEBUG = SwanAppLibConfig.DEBUG;
    private static final String TAG = "SwanAppV8Master";
    private static final int V8_THREAD_PRIORITY = -19;
    /* access modifiers changed from: private */
    public SwanAppBindingImpl mBindingImpl;
    private AiBaseV8Engine mEngine;
    /* access modifiers changed from: private */
    public V8LoadingCallback mLoadingCallback;

    public SwanAppV8Master(String basePath, String jsFile) {
        this(basePath, jsFile, (String) null);
    }

    public SwanAppV8Master(String basePath, String jsFile, String engineId) {
        this.mBindingImpl = new SwanAppBindingImpl();
        if (DEBUG) {
            Log.d(TAG, "createV8Master: " + basePath + jsFile);
        }
        V8EngineModel model = createEngineModel();
        if (!TextUtils.isEmpty(engineId)) {
            model.mID = engineId;
        }
        this.mEngine = V8EngineFactory.prepareEngine(model, createV8LoadingPolicy(basePath, jsFile), new SwanV8ThreadPolicyOpt(-19));
    }

    public void setCodeCacheSetting(V8EngineConfiguration.CodeCacheSetting codeCacheSetting) {
        this.mEngine.setCodeCacheSetting(codeCacheSetting);
    }

    @Deprecated
    public void setCodeCacheCallback(V8EngineConfiguration.JSCacheCallback callback) {
        this.mEngine.setCodeCacheCallback(callback);
    }

    public void setJSCodeCacheCallback(JsCodeCacheCallback callback) {
        this.mEngine.setJSCodeCacheCallback(callback);
    }

    public AiBaseV8Engine getV8Engine() {
        return this.mEngine;
    }

    public String getEngineID() {
        return this.mEngine.engineID;
    }

    public void finish() {
        this.mEngine.finish();
    }

    /* access modifiers changed from: protected */
    public V8EngineModel createEngineModel() {
        return new V8EngineModel.Builder().type(1).id(MasterIdGenerator.next()).build();
    }

    /* access modifiers changed from: protected */
    public DefaultLoadingPolicy createV8LoadingPolicy(String basePath, String jsFile) {
        return new SwanAppV8LoadingPolicy(basePath, jsFile);
    }

    private Context getAppContext() {
        return SwanAppRuntime.getAppContext();
    }

    public void attachContextToBridge(Activity activity) {
        this.mBindingImpl.attachActivityContext(activity);
    }

    public void setV8LoadingCallback(V8LoadingCallback callback) {
        this.mLoadingCallback = callback;
    }

    public void recoverGc() {
        this.mEngine.recoverGc();
    }

    public void closeGc() {
        this.mEngine.closeGc();
    }

    protected class SwanAppV8LoadingPolicy extends DefaultLoadingPolicy {
        private String mBasePath;
        private String mFileName;

        public SwanAppV8LoadingPolicy(String basePath, String jsFile) {
            this.mBasePath = basePath;
            this.mFileName = jsFile;
            if (SwanAppV8Master.DEBUG) {
                Log.d(SwanAppV8Master.TAG, "basePath: " + basePath + ", jsFile: " + jsFile);
            }
        }

        public V8EngineConfiguration.CodeCacheSetting getCodeCacheSetting() {
            if (SwanAppV8Master.DEBUG) {
                Log.d(SwanAppV8Master.TAG, "pathList item: " + this.mBasePath);
            }
            return V8CodeCacheHelper.buildCacheSetting("appframe", this.mBasePath);
        }

        public String getInitBasePath() {
            return this.mBasePath;
        }

        public String getInitJSFile() {
            return this.mFileName;
        }

        public void onV8Init(AiBaseV8Engine engine) {
            if (JsRuntimeGcOptABSwitcher.canCloseGc()) {
                engine.closeGc();
            }
            SwanAppV8Master.this.mBindingImpl.doBinding(engine, SwanAppRuntime.getAppContext());
        }

        public void onV8Ready(AiBaseV8Engine engine) {
            if (SwanAppV8Master.DEBUG) {
                Log.d(SwanAppV8Master.TAG, "onV8Ready is main thread: " + SwanAppUtils.isOnUiThread() + " name:" + Thread.currentThread().getName() + " v8-threadName: " + engine.getEngine().threadName());
            }
            SwanAppRuntime.getMasterNaJsLoader().requireNaJsFile(engine);
            if (SwanAppV8Master.this.mLoadingCallback != null) {
                if (SwanAppV8Master.DEBUG) {
                    Log.d(SwanAppV8Master.TAG, "onV8Ready callback ");
                }
                SwanAppV8Master.this.mLoadingCallback.onReady(engine);
            }
            engine.onLoad();
        }
    }
}
