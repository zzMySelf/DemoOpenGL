package com.baidu.swan.card.render.engine;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.ValueCallback;
import com.baidu.chatsearch.aisearch.resultpage.toolbar.discovery.span.RhetoricalTagUtilKt;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.fileviewer.activity.FileViewerActivity;
import com.baidu.searchbox.v8engine.CustomJsCodeCacheHandler;
import com.baidu.searchbox.v8engine.InspectorNativeChannel;
import com.baidu.searchbox.v8engine.InspectorNativeClient;
import com.baidu.searchbox.v8engine.JSExceptionType;
import com.baidu.searchbox.v8engine.JsCodeCacheCallback;
import com.baidu.searchbox.v8engine.JsSerializeValue;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.searchbox.v8engine.V8EngineConfiguration;
import com.baidu.searchbox.v8engine.event.EventTarget;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.searchbox.v8engine.filesystem.V8FileSystemDelegatePolicy;
import com.baidu.searchbox.v8engine.net.NetRequest;
import com.baidu.searchbox.v8engine.thread.V8ExecuteCallback;
import com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy;
import com.baidu.swan.card.ioc.SwanCardRuntime;
import com.baidu.swan.card.render.engine.console.V8Console;
import com.baidu.swan.card.render.engine.console.V8ConsoleLogcatImpl;
import com.baidu.swan.card.render.engine.console.V8JSExceptionLogcatImpl;
import com.baidu.swan.card.render.engine.context.V8MainContext;
import com.baidu.swan.card.render.engine.context.V8OpenContext;
import com.baidu.swan.card.render.engine.load.V8EngineLoadingPolicy;
import com.baidu.swan.card.render.engine.v8inspector.V8Inspector;
import com.baidu.swan.card.utils.SwanAppLibConfig;
import com.baidu.swan.card.utils.SwanCardLog;
import com.baidu.swan.card.utils.SwanCardUtil;
import com.baidu.swan.card.utils.typedbox.TypedCallback;
import com.baidu.swan.webcompat.ioc.WebCompat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class SwanCardBaseV8Engine implements IV8Engine {
    /* access modifiers changed from: private */
    public static final boolean DEBUG = SwanAppLibConfig.DEBUG;
    private static final String TAG = "SwanCardBaseV8Engine";
    public final String engineID;
    private V8Console mConsole;
    private Context mContext;
    private int mCurState = 0;
    private List<TypedCallback<Boolean>> mDestroyedCallback = new CopyOnWriteArrayList();
    /* access modifiers changed from: private */
    public EventTarget mGlobalObject;
    private boolean mHasDestroyed = false;
    private boolean mHasFinished;
    private boolean mHasLoaded = false;
    private V8Inspector mInspector;
    private boolean mInspectorStarted = false;
    protected V8EngineLoadingPolicy mLoadingPolicy;
    private V8MainContext mMainContext;
    private V8OpenContext mOpenContext;
    private EventTarget mOpenObject;
    /* access modifiers changed from: private */
    public List<JSEvent> mPendingEvents;
    private final String mPreloadId = UUID.randomUUID().toString();
    protected V8Engine mV8Engine;

    public abstract EventTarget createGlobalObject();

    static {
        SwanCardRuntime.getSwanCardContext().loadV8So();
    }

    protected SwanCardBaseV8Engine(String id, V8EngineLoadingPolicy loadingPolicy, V8ThreadDelegatePolicy delegatePolicy) {
        this.engineID = id;
        this.mLoadingPolicy = loadingPolicy;
        String basePath = getInitBasePath();
        if (!TextUtils.isEmpty(basePath)) {
            this.mGlobalObject = createGlobalObject();
            this.mOpenObject = createOpenObject();
            V8Engine v8Engine = new V8Engine(AppRuntime.getAppContext(), basePath, this.mLoadingPolicy.getInitJSFile(), delegatePolicy, this.mGlobalObject, this.mOpenObject, V8AbTestDelegate.newInstance());
            this.mV8Engine = v8Engine;
            v8Engine.setExternalV8BinFilesPath(SwanCardRuntime.getSwanCardContext().getV8SoDependentFile());
            if (loadingPolicy.getCodeCacheSetting() != null) {
                this.mV8Engine.setCodeCacheSetting(loadingPolicy.getCodeCacheSetting());
            }
            this.mMainContext = new V8MainContext(this.mV8Engine);
            this.mConsole = new V8Console(this.mV8Engine);
            this.mPendingEvents = new ArrayList();
            onCreate();
        }
    }

    public EventTarget createOpenObject() {
        return new EventTargetImpl(this);
    }

    public void suspendTimer() {
        synchronized (SwanCardV8Manager.class) {
            if (!isDestroyed()) {
                SwanCardLog.i(TAG, "suspendTimer: for=" + this);
                onPause();
            }
        }
    }

    public void continueTimer() {
        synchronized (SwanCardV8Manager.class) {
            if (!isDestroyed()) {
                SwanCardLog.i(TAG, "continueTimer: for=" + this);
                onResume();
            }
        }
    }

    public void setFileSystemBasePath() {
    }

    public void setMainPackageBasePath() {
    }

    public Context getAppContext() {
        return AppRuntime.getAppContext();
    }

    public void setFileSystemDelegatePolicy(V8FileSystemDelegatePolicy policy) {
        this.mV8Engine.setFileSystemDelegatePolicy(policy);
    }

    /* access modifiers changed from: protected */
    public void onStartInitEngine() {
        addConsoleListener(new V8ConsoleLogcatImpl(this));
        setJSExceptionDelegate(new V8JSExceptionLogcatImpl(this));
    }

    /* access modifiers changed from: package-private */
    public void initV8Inspector() {
        if (this.mInspector == null) {
            V8Inspector v8Inspector = new V8Inspector();
            this.mInspector = v8Inspector;
            v8Inspector.setV8Engine(this);
        }
    }

    public void startV8Inspector() {
        V8Inspector v8Inspector = this.mInspector;
        if (v8Inspector != null && !this.mInspectorStarted) {
            this.mInspectorStarted = true;
            v8Inspector.start();
            Log.d(TAG, "[Inspector] start.");
        }
    }

    /* access modifiers changed from: package-private */
    public void initCodeCache() {
        this.mV8Engine.setCustomJsCodeCacheHandler(new CustomJsCodeCacheHandler() {
            public String getJsCodeCacheFilePath(String jsPath) {
                if (TextUtils.isEmpty(jsPath)) {
                    return null;
                }
                return jsPath + "_cache";
            }
        });
        if (DEBUG) {
            Log.i(TAG, "customCodeCache:true");
        }
    }

    /* access modifiers changed from: package-private */
    public void initEngine() {
        this.mV8Engine.setMemSetMemoryEnable(true);
        onStartInitEngine();
        boolean z = DEBUG;
        if (z) {
            Log.d(TAG, "initEngine start.");
        }
        this.mLoadingPolicy.onV8Init(this);
        initCodeCache();
        if (z) {
            initV8Inspector();
        }
        this.mV8Engine.startEngine();
        this.mV8Engine.addStatusHandler(new V8Engine.V8StatusListener() {
            public void onReady() {
                SwanCardBaseV8Engine.this.onReady();
            }

            public void onPause() {
            }

            public void onResume() {
            }
        });
        if (z) {
            Log.d(TAG, "initEngine end.");
        }
    }

    public void setCodeCacheSetting(V8EngineConfiguration.CodeCacheSetting codeCacheSetting) {
        this.mV8Engine.setCodeCacheSetting(codeCacheSetting);
    }

    @Deprecated
    public void setCodeCacheCallback(V8EngineConfiguration.JSCacheCallback callback) {
        this.mV8Engine.setJSCacheCallback(callback);
    }

    public void setJSCodeCacheCallback(JsCodeCacheCallback callback) {
        this.mV8Engine.setJsCodeCacheCallback(callback);
    }

    public void finish() {
        finish((TypedCallback<Boolean>) null);
    }

    public void finish(TypedCallback<Boolean> callback) {
        if (!isFinishing()) {
            SwanCardLog.logToFile(TAG, getLogTag() + " finish called.");
            onFinish();
            this.mDestroyedCallback.add(callback);
            this.mV8Engine.destroyEngine(new V8ExecuteCallback() {
                public void onExecuted() {
                    SwanCardLog.logToFile(SwanCardBaseV8Engine.TAG, SwanCardBaseV8Engine.this.getLogTag() + "finish onExecuted.");
                    SwanCardUtil.runOnUiThread(new Runnable() {
                        public void run() {
                            SwanCardBaseV8Engine.this.onDestroy();
                        }
                    });
                }
            });
        } else if (this.mHasDestroyed && callback != null) {
            callback.onCallback(true);
        } else if (callback != null) {
            this.mDestroyedCallback.add(callback);
        }
    }

    public boolean isFinishing() {
        return this.mHasFinished;
    }

    public V8OpenContext getOpenContext() {
        if (this.mOpenContext == null) {
            this.mOpenContext = new V8OpenContext(this.mV8Engine);
        }
        return this.mOpenContext;
    }

    public V8Engine getEngine() {
        return this.mV8Engine;
    }

    public EventTarget getGlobalObject() {
        return this.mGlobalObject;
    }

    public EventTarget getOpenObject() {
        return this.mOpenObject;
    }

    public V8Console console() {
        return this.mConsole;
    }

    public boolean dispatchEvent(final JSEvent event) {
        boolean z = DEBUG;
        if (z) {
            Log.d(TAG, "dispatchEvent event: " + (event != null ? event.type : ""));
        }
        if (this.mGlobalObject != null && JSEvent.isValid(event)) {
            runOnJSThread(new Runnable() {
                public void run() {
                    if (!SwanCardBaseV8Engine.this.isLoaded()) {
                        if (SwanCardBaseV8Engine.DEBUG) {
                            Log.d(SwanCardBaseV8Engine.TAG, "dispatchEvent add to pending list.");
                        }
                        SwanCardBaseV8Engine.this.mPendingEvents.add(event);
                        return;
                    }
                    SwanCardBaseV8Engine.this.mGlobalObject.dispatchEvent(event);
                }
            });
            return true;
        } else if (!z) {
            return false;
        } else {
            Log.e(TAG, "dispatchEvent globalObject or event is invalid.");
            return false;
        }
    }

    private void doPendingDispatch() {
        if (DEBUG) {
            Log.d(TAG, "doPendingDispatch start.");
        }
        runOnJSThread(new Runnable() {
            public void run() {
                for (JSEvent event : SwanCardBaseV8Engine.this.mPendingEvents) {
                    if (SwanCardBaseV8Engine.DEBUG) {
                        Log.d(SwanCardBaseV8Engine.TAG, "doPendingDispatch event type: " + event.type);
                    }
                    SwanCardBaseV8Engine.this.dispatchEvent(event);
                }
                SwanCardBaseV8Engine.this.mPendingEvents.clear();
            }
        });
    }

    public void requireJsFile(String basePath, String jsFile) {
        this.mMainContext.requireJsFile(basePath, jsFile);
    }

    public void evaluateJavascript(String js) {
        evaluateJavascript(js, (ValueCallback<String>) null);
    }

    public void evaluateJavascript(String js, ValueCallback<String> resultCallback) {
        this.mMainContext.evaluateJavascript(js, resultCallback);
    }

    public boolean isDestroyed() {
        return this.mHasFinished;
    }

    public void addJavascriptInterface(Object object, String name) {
        if (DEBUG) {
            Log.d(TAG, "addJavascriptInterface object: " + object + " ,name: " + name);
        }
        this.mMainContext.addJavascriptInterface(object, name);
    }

    public void throwJSException(JSExceptionType type, String msg) {
        this.mMainContext.throwJSException(type, msg);
    }

    public void runOnJSThreadDirectly(Runnable runnable) {
        if (runnable != null) {
            this.mV8Engine.runOnJSThreadDirectly(runnable);
        }
    }

    public void runOnJSThread(Runnable runnable) {
        if (runnable != null) {
            this.mV8Engine.runOnJSThread(runnable);
        }
    }

    public void postOnJSThread(Runnable runnable) {
        if (runnable != null) {
            this.mV8Engine.postOnJSThread(runnable);
        }
    }

    public void postOnJSThread(Runnable runnable, long delayMillis) {
        if (runnable != null) {
            this.mV8Engine.postOnJSThread(runnable, delayMillis);
        }
    }

    public void setUserAgent(String userAgent) {
        if (!TextUtils.isEmpty(userAgent)) {
            if (DEBUG) {
                Log.d(TAG, "setUserAgent: " + userAgent);
            }
            this.mV8Engine.setUserAgent(userAgent);
        }
    }

    public void setContext(Context context) {
        this.mContext = context;
    }

    public Context getContext() {
        return this.mContext;
    }

    public String getUrl() {
        return "";
    }

    public boolean post(Runnable runnable) {
        runOnJSThread(runnable);
        return true;
    }

    public String getUserAgent() {
        return this.mV8Engine.userAgent();
    }

    public void addConsoleListener(V8Engine.V8EngineConsole console) {
        this.mV8Engine.addV8EngineConsole(console);
    }

    public void removeConsoleListener(V8Engine.V8EngineConsole console) {
        this.mV8Engine.removeV8EngineConsole(console);
    }

    public void setJSExceptionDelegate(V8Engine.JavaScriptExceptionDelegate delegate) {
        this.mV8Engine.setJavaScriptExceptionDelegate(delegate);
    }

    public String getLogTag() {
        return RhetoricalTagUtilKt.TAG_START_SYMBOL + this.engineID + "] : ";
    }

    private SwanCardV8Manager getV8Manager() {
        return SwanCardV8Manager.getInstance();
    }

    private void onCreate() {
        getV8Manager().dispatchOnCreate(this);
        this.mCurState = 1;
    }

    /* access modifiers changed from: private */
    public void onReady() {
        getV8Manager().dispatchOnReady(this);
        this.mCurState = 2;
        this.mLoadingPolicy.onV8Ready(this);
    }

    public void onPause() {
        V8Engine v8Engine = this.mV8Engine;
        if (v8Engine != null) {
            v8Engine.onPause();
        }
        getV8Manager().dispatchOnPause(this);
        this.mCurState = 4;
    }

    public void onResume() {
        V8Engine v8Engine = this.mV8Engine;
        if (v8Engine != null) {
            v8Engine.onResume();
        }
        getV8Manager().dispatchOnResume(this);
        this.mCurState = 5;
    }

    public void onLoad() {
        getV8Manager().dispatchOnLoad(this);
        this.mCurState = 3;
        this.mHasLoaded = true;
        doPendingDispatch();
    }

    private void onFinish() {
        this.mHasFinished = true;
        getV8Manager().dispatchOnFinish(this);
        this.mCurState = 6;
        if (this.mInspector != null) {
            Log.d(TAG, "[Inspector] stop");
            if (this.mInspectorStarted) {
                this.mInspector.stop();
            }
            this.mInspector = null;
        }
    }

    /* access modifiers changed from: private */
    public void onDestroy() {
        this.mHasDestroyed = true;
        for (TypedCallback<Boolean> callback : this.mDestroyedCallback) {
            callback.onCallback(true);
        }
        this.mDestroyedCallback.clear();
        getV8Manager().dispatchOnDestroy(this);
        this.mCurState = 7;
    }

    public boolean isLoaded() {
        return this.mHasLoaded;
    }

    public boolean isWebView() {
        return false;
    }

    public boolean isDestroy() {
        return this.mCurState == 7;
    }

    public void handleSchemeDispatchCallback(String callback, String params) {
        String result;
        if (!isFinishing()) {
            if (TextUtils.isEmpty(params)) {
                result = "";
            } else {
                result = JSONObject.quote(params);
            }
            StringBuilder js = new StringBuilder(callback);
            js.append(FileViewerActivity.LEFT_BRACKET).append(result).append(");");
            evaluateJavascript(js.toString(), (ValueCallback<String>) null);
            if (DEBUG) {
                Log.d(TAG, "handleSchemeDispatchCallback callback " + callback + " ,params: " + params);
            }
        } else if (DEBUG) {
            Log.e(TAG, Log.getStackTraceString(new Exception("engine isFinishing.")));
        }
    }

    public String getCurrentPageUrl() {
        return WebCompat.INSTANCE.getBaseUriString();
    }

    public String getInitBasePath() {
        return this.mLoadingPolicy.getInitBasePath();
    }

    public String getSwanCoreBasePath() {
        return this.mLoadingPolicy.getInitBasePath();
    }

    public String getPreloadId() {
        return this.mPreloadId;
    }

    public InspectorNativeClient initInspector(InspectorNativeChannel inspectorNativeChannel) {
        return this.mV8Engine.initInspector(inspectorNativeChannel);
    }

    public byte[] serializeJsValue(JsSerializeValue value, boolean mainContext) {
        return this.mV8Engine.serialize(value, mainContext);
    }

    public JsSerializeValue deserializeJsValue(byte[] data, boolean mainContext) {
        return this.mV8Engine.deserialize(data, mainContext);
    }

    public void setPreferredFramesPerSecond(short rate) {
        this.mV8Engine.setPreferredFramesPerSecond(rate);
    }

    public void onJSLoaded() {
    }

    public JSONArray getPerformanceJson() {
        V8Engine v8Engine = this.mV8Engine;
        if (v8Engine == null) {
            return null;
        }
        return v8Engine.getPerformanceJson();
    }

    public String getContainerId() {
        return this.engineID;
    }

    public NetRequest getNaRequest() {
        return this.mV8Engine.getNetRequest();
    }

    public static void setCrashKeyValue(String key, String value) {
        if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(value)) {
            V8Engine.setCrashKeyValue(key, value);
        }
    }

    public static String toColorRGBA(String colorStr) {
        if (TextUtils.isEmpty(colorStr)) {
            return colorStr;
        }
        return V8Engine.toColorRGBA(colorStr);
    }
}
