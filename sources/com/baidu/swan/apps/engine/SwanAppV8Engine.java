package com.baidu.swan.apps.engine;

import android.text.TextUtils;
import android.util.Log;
import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.EventTarget;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy;
import com.baidu.swan.apps.SwanAppLibConfig;
import com.baidu.swan.apps.console.SwanAppLog;
import com.baidu.swan.apps.engine.console.V8ConsoleLogcatImpl;
import com.baidu.swan.apps.engine.console.V8JSExceptionLogcatImpl;
import com.baidu.swan.apps.engine.load.V8EngineLoadingPolicy;
import com.baidu.swan.apps.filemanage.FileSystemApi;
import com.baidu.swan.apps.jsbridge.utils.SwanAppNativeSwanUtils;
import com.baidu.swan.apps.nausemap.SwanNaUseMapManager;
import com.baidu.swan.apps.prepose.util.SwanAppDebugUtil;
import com.baidu.swan.apps.swancore.config.SwanCoreConfigHelper;
import com.baidu.swan.apps.util.GetApisStat;
import com.baidu.swan.apps.util.SwanAppCompat;
import org.json.JSONObject;

public class SwanAppV8Engine extends AiBaseV8Engine {
    /* access modifiers changed from: private */
    public static final boolean DEBUG = SwanAppLibConfig.DEBUG;
    public static final Object MASTER_THREAD_LOCK = new Object();
    private static final String TAG = "SwanAppV8Engine";
    public static String sDevToolsResponse = "";

    public SwanAppV8Engine(String id, V8EngineLoadingPolicy loadingPolicy, V8ThreadDelegatePolicy delegatePolicy) {
        super(id, loadingPolicy, delegatePolicy);
        if (this.mV8Engine != null) {
            this.mV8Engine.setWorkerFactoryDelegate(new V8Engine.WorkerFactory() {
                public V8Engine onCreateWorker() {
                    SwanAppWorker worker = new SwanAppWorker(SwanAppV8Engine.this.getInitBasePath());
                    worker.setMainPackageBasePath();
                    worker.addConsoleListener(new V8ConsoleLogcatImpl(worker));
                    worker.setJSExceptionDelegate(new V8JSExceptionLogcatImpl(worker));
                    return worker.getEngine();
                }
            });
        }
    }

    public EventTarget createGlobalObject() {
        SwanAppV8GlobalObject globalObject = new SwanAppV8GlobalObject(this, this.mLoadingPolicy.getInitBasePath());
        globalObject.env.config = SwanCoreConfigHelper.createConfigObject();
        return globalObject;
    }

    public int getInvokeSourceType() {
        return 0;
    }

    public static class SwanAppV8GlobalObject extends EventTargetImpl {
        private static final String JS_NATIVE_ENV_TYPE = "swan/v8";
        @V8JavascriptField
        public Env env;
        private IV8Engine mEngine;
        private FileSystemApi mFileSystemApi;

        public SwanAppV8GlobalObject(IV8Engine jsRuntime, String basePath) {
            super(jsRuntime);
            this.mEngine = jsRuntime;
            Env env2 = new Env();
            this.env = env2;
            env2.basePath = basePath;
        }

        @JavascriptInterface
        public FileSystemApi getFileSystemManager() {
            if (this.mFileSystemApi == null) {
                this.mFileSystemApi = new FileSystemApi((AiBaseV8Engine) this.mEngine);
            }
            return this.mFileSystemApi;
        }

        @JavascriptInterface
        public String getEnvVariables() {
            return SwanAppNativeSwanUtils.getEnvVariables(this.mEngine);
        }

        @JavascriptInterface
        public String getAPIs(int index) {
            if (SwanAppV8Engine.DEBUG) {
                String res = SwanAppDebugUtil.getJsNativeDebug() ? SwanAppCompat.getJsNativeScheme(index, "swan/v8") : "";
                SwanAppLog.d(SwanAppV8Engine.TAG, "getAPIs res:" + res);
                return res;
            }
            String description = SwanAppCompat.getJsNativeScheme(index, "swan/v8");
            SwanAppLog.d(SwanAppV8Engine.TAG, "getAPIs description:" + description);
            if (!TextUtils.isEmpty(description)) {
                GetApisStat.reportSuccessEvent();
            } else if (!SwanAppV8Engine.DEBUG) {
                GetApisStat.reportFailEvent(SwanAppCompat.collectJsNativeErrorInfo(String.format("index: %d, desc: %s, isV8: %b", new Object[]{Integer.valueOf(index), description, true})));
            } else {
                SwanAppCompat.printJsNativeErrorEvent();
                throw new RuntimeException(String.format("getAPIs cannot find index: %d, desc: %s", new Object[]{Integer.valueOf(index), description}));
            }
            return description;
        }

        @JavascriptInterface
        public JSONObject getNACanIUseMap() {
            JSONObject canUseObject = SwanNaUseMapManager.getNACanIUseMap();
            SwanAppLog.logToFile(SwanAppV8Engine.TAG, "getNACanIUseMap - " + canUseObject.toString());
            return canUseObject;
        }

        @JavascriptInterface
        public boolean lockMaster() {
            SwanAppLog.logToFile(SwanAppV8Engine.TAG, "lockMaster");
            synchronized (SwanAppV8Engine.MASTER_THREAD_LOCK) {
                try {
                    SwanAppV8Engine.MASTER_THREAD_LOCK.wait();
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                    return false;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return true;
        }

        @JavascriptInterface
        public void setDevToolsResponse(String params) {
            if (SwanAppV8Engine.DEBUG) {
                Log.d(SwanAppV8Engine.TAG, "setDevToolsResponse = " + params);
            }
            SwanAppV8Engine.sDevToolsResponse = params;
        }

        @JavascriptInterface
        public String getDevToolsResponse() {
            if (SwanAppV8Engine.DEBUG) {
                Log.d(SwanAppV8Engine.TAG, "getDevToolsResponse = " + SwanAppV8Engine.sDevToolsResponse);
            }
            return SwanAppV8Engine.sDevToolsResponse;
        }
    }
}
