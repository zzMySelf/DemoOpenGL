package com.temp.searchbox.v8engine;

import android.content.Context;
import android.os.Build;
import android.os.Debug;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import com.baidu.talos.core.Debug;
import com.temp.searchbox.v8engine.V8EngineConfiguration;
import com.temp.searchbox.v8engine.bean.PerformanceJsonBean;
import com.temp.searchbox.v8engine.filesystem.V8FileSystemDelegatePolicy;
import com.temp.searchbox.v8engine.net.NetRequest;
import com.temp.searchbox.v8engine.thread.V8ExecuteCallback;
import com.temp.searchbox.v8engine.thread.V8ThreadDelegatePolicy;
import com.temp.smallgame.sdk.MarioLog;
import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;

public class V8Engine implements JSRuntime {
    public static final String ACTION_CONSTRUCTOR_DONE = "v8_constructor_done";
    public static final String ACTION_NATIVE_INIT = "v8_native_init";
    public static final String ACTION_READY = "v8_ready";
    public static final String ACTION_START_ENGINE_BEGIN = "v8_start_engine_begin";
    public static final String ACTION_START_ENGINE_END = "v8_start_engine_end";
    public static final String ACTION_V8_CREATE_MAIN_CONTEXT_START = "v8_create_main_context";
    public static final String ACTION_V8_REQUIRE_BASE_JS_START = "v8_require_base_js";
    public static final String ACTION_WORKER_INIT = "v8_worker_init";
    private static final String ALTERNATIVE_ADD_ASSET_PATH_METHOD = "addAssetPath";
    private static final String ALTERNATIVE_CACHE_PATH = "webview_baidu";
    private static final String ALTERNATIVE_SO = "libcom.baidu.zeus.so";
    private static final long CLOCKS_PER_SEC = 1000;
    /* access modifiers changed from: private */
    public static final boolean DEBUG = Debug.isDebug();
    public static final float DEFAULT_FRAMES = 16.666666f;
    private static final long ENGINE_DESTROYED = 0;
    public static final int INVOKE_NATIVE_METHOD_ERROR_ENGINE_IS_NULL = 1;
    public static final int INVOKE_NATIVE_METHOD_ERROR_HAS_NULL_PARAM = 4;
    public static final int INVOKE_NATIVE_METHOD_ERROR_MUST_CALL_ON_V8_THREAD = 2;
    public static final int INVOKE_NATIVE_METHOD_ERROR_PARAM_IS_NULL = 3;
    public static final int INVOKE_NATIVE_METHOD_ERROR_USE_DESTROYED_ENGINE = 5;
    public static final int INVOKE_NATIVE_METHOD_NO_ERROR = 0;
    public static final int SET_NET_REQUEST_ERROR_ENGINE_PTR_IS_NULLPTR = 1;
    public static final int SET_NET_REQUEST_ERROR_JAVA_NET_REQUEST_HAS_BEEN_SET_BEFORE = 196608;
    public static final int SET_NET_REQUEST_ERROR_MUST_CALL_ON_V8_THREAD = 256;
    public static final int SET_NET_REQUEST_ERROR_NET_REQUEST_OBJECT_IS_NULL = 2;
    public static final int SET_NET_REQUEST_ERROR_NOT_SUPPORT_DIFFERENT_JAVA_NET_REQUEST_OBJ = 65536;
    public static final int SET_NET_REQUEST_ERROR_REGISTER_NA_REQUEST_FAILED_CAN_NOT_FIND_SWAN_NATIVE = 262145;
    public static final int SET_NET_REQUEST_ERROR_REGISTER_NA_REQUEST_FAILED_HAS_KEY_BUT_NOT_ALLOWED_OVERWRITING = 262144;
    public static final int SET_NET_REQUEST_ERROR_UNKNOWN = 3;
    public static final int SET_NET_REQUEST_ERROR_USE_DESTROYED_ENGINE = 512;
    public static final int SET_NET_REQUEST_ERROR_V8NET_FUNCTION_TABLE_DELEGATE_NOT_READY = 131072;
    public static final int SET_NET_REQUEST_NO_ERROR = 0;
    private static final String TAG = "TLS_V8Engine";
    public static final String TYPE_V8 = "v8";
    private static boolean appDebug = false;
    /* access modifiers changed from: private */
    public static int mSurfaceViewHeight = 0;
    /* access modifiers changed from: private */
    public static int mSurfaceViewWidth = 0;
    private static Context sAppContext;
    private static Method sClearCrashKeyMethod = null;
    /* access modifiers changed from: private */
    public static HashMap<Long, V8Engine> sEngines = new HashMap<>();
    private static Method sSetCrashKeyValueMethod = null;
    private static int sWorkerID = 0;
    private String mBuildInV8BinPath = null;
    private V8EngineConfiguration.CodeCacheSetting mCodeCacheSetting;
    private ArrayList<V8EngineConsole> mConsoles = null;
    private CustomJsCodeCacheHandler mCustomJsCodeCacheHandler;
    private String mDecodeBdfile = "";
    private File mDiskCodeCachePathFile;
    private JavaScriptExceptionDelegate mExceptionDelegate;
    private String mExternalV8BinPath = null;
    /* access modifiers changed from: private */
    public V8FileSystemDelegatePolicy mFileSystemDelegatePolicy;
    private float mFramesInterval = 16.666666f;
    private ArrayList<V8StatusListener> mHandlers = null;
    private String mInitBasePath;
    private String mInitJsPath;
    private InspectorNativeChannel mInspectorChannel;
    /* access modifiers changed from: private */
    public InspectorNativeClient mInspectorNativeClient;
    /* access modifiers changed from: private */
    public AtomicBoolean mIsDestroyed = new AtomicBoolean(true);
    private boolean mIsWorker = false;
    private V8EngineConfiguration.JSCacheCallback mJSCacheCallback;
    private V8EngineConfiguration.JSThreadDelegate mJSThreadDelegate;
    /* access modifiers changed from: private */
    public JavaBoundObjectManager mJavaBoundObjectManager;
    private JsCodeCacheCallback mJsCodeCacheCallback;
    private Object mMainGlobalObject;
    private String mMainPackageBasePath = "";
    /* access modifiers changed from: private */
    public long mNativeV8Engine;
    private NetRequest mNetRequest;
    private Object mOpenGlobalObject;
    private volatile boolean mPaused = false;
    private PerformanceJsonBean mPerformanceJsonBean;
    private volatile boolean mReady;
    private volatile boolean mSetMemSetMemMemoryEnable = false;
    private Vector<Runnable> mSuspendableTasks = null;
    /* access modifiers changed from: private */
    public V8ThreadDelegatePolicy mThreadDelegatePolicy;
    private String mThreadName = "V8JavaScriptContext";
    private String mUserAgent;
    /* access modifiers changed from: private */
    public long mV8ContextInstance;
    private V8ExceptionInfo mV8ExceptionInfo;
    /* access modifiers changed from: private */
    public long mV8IsolateInstance;
    /* access modifiers changed from: private */
    public long mV8ThreadId = 0;
    private WorkerFactory mWorkerFactoryDelegate = null;

    public interface JavaScriptExceptionDelegate {
        void onV8ExceptionCallBack(V8ExceptionInfo v8ExceptionInfo);
    }

    public interface V8EngineConsole {
        void onDebugConsole(String str);

        void onErrorConsole(String str);

        void onInfoConsole(String str);

        void onLogConsole(String str);

        void onTraceConsole(String str);

        void onWarnConsole(String str);
    }

    public interface V8StatusListener {
        void onPause();

        void onReady();

        void onResume();
    }

    public interface WorkerFactory {
        V8Engine onCreateWorker();
    }

    private native void addJavascriptInterfaceImpl(long j2, Object obj, String str, Class cls, boolean z);

    static native void nativeDeleteJsReleaser(long j2, long j3, boolean z);

    private native JsSerializeValue nativeDeserialize(long j2, byte[] bArr, int i2, boolean z);

    /* access modifiers changed from: private */
    public native void nativeDestroyOpenDataContext(long j2);

    private static native long nativeGetChannelFunctionTable();

    private static native int nativeGetVersionCode();

    private static native String nativeGetVersionName();

    private native void nativeInitGlobalV8NetFunctionTable(long j2, long j3);

    private native void nativeOnReady(long j2);

    private native byte[] nativeSerialize(long j2, JsSerializeValue jsSerializeValue, boolean z);

    private native void nativeSetBdFileRealPath(long j2, String str);

    private native boolean nativeSetCodeCacheSetting(long j2, String str, String str2, int i2, String[] strArr, int i3, long j3);

    private native int nativeSetCustomJsCodeCacheHandler(long j2, Object obj);

    private native int nativeSetJavaNetRequest(long j2, Object obj);

    private native void nativeSetMainPackageBasePath(long j2, String str);

    private native void nativeSetMemSetMemoryEnable(long j2, boolean z);

    private native void nativeSetUserAgent(long j2, String str);

    private static native void nativeSetV8GCPressureLevel(long j2, int i2);

    /* access modifiers changed from: private */
    public native void nativeSetV8Isolate(long j2, long j3, long j4);

    /* access modifiers changed from: private */
    public native void nativeThrowJSException(long j2, int i2, String str, boolean z);

    private static native String nativeToColorRGBA(String str);

    /* access modifiers changed from: private */
    public native void pumpNativeMessageLoop(long j2, long j3);

    /* access modifiers changed from: private */
    public native void removeJavascriptInterfaceImpl(long j2, String str, boolean z);

    /* access modifiers changed from: private */
    public native void require(long j2, String str, String str2, boolean z, boolean z2);

    private native String runScript(long j2, String str, String str2, boolean z);

    /* access modifiers changed from: private */
    public native void v8EngineDestroy(long j2);

    private native long v8EngineInit();

    public NetRequest getNetRequest() {
        return this.mNetRequest;
    }

    public boolean setNetRequest(NetRequest netRequest) {
        return setJavaNetRequest(netRequest) == 0;
    }

    public int setJavaNetRequest(NetRequest netRequest) {
        int result;
        if (netRequest == null) {
            result = 2;
        } else if (this.mNativeV8Engine == 0 || this.mIsDestroyed.get()) {
            result = 512;
        } else if (this.mThreadDelegatePolicy.getThread() == null || !(this.mThreadDelegatePolicy.getThread() == null || this.mThreadDelegatePolicy.getThread() == Thread.currentThread())) {
            result = 256;
        } else {
            int nativeSetJavaNetRequest = nativeSetJavaNetRequest(this.mNativeV8Engine, netRequest);
            int result2 = nativeSetJavaNetRequest;
            if (nativeSetJavaNetRequest == 0) {
                this.mNetRequest = netRequest;
                netRequest.bindV8Engine(this);
            }
            result = result2;
        }
        if (result != 0 && DEBUG) {
            MarioLog.w(TAG, "[mario-request] setJavaNetRequest调用失败, 错误码: " + result);
        }
        return result;
    }

    public boolean isWorker() {
        return this.mIsWorker;
    }

    public void setIsWorker(boolean isWorker) {
        this.mIsWorker = isWorker;
    }

    public long nativePtr() {
        return this.mNativeV8Engine;
    }

    public V8FileSystemDelegatePolicy getFileSystemDelegatePolicy() {
        return this.mFileSystemDelegatePolicy;
    }

    public String threadName() {
        return this.mThreadName;
    }

    public void setThreadName(String threadName) {
        this.mThreadName = threadName;
    }

    public void setThreadId(long threadId) {
        this.mV8ThreadId = threadId;
        synchronized (sEngines) {
            sEngines.put(Long.valueOf(this.mNativeV8Engine), this);
        }
    }

    private String getTrimPath(String path) {
        if (TextUtils.isEmpty(path)) {
            return null;
        }
        String result = path.trim();
        if (result.length() == 0) {
            return null;
        }
        return result;
    }

    public void setBdFileRealPath(String path) {
        String path2 = getTrimPath(path);
        if (path2 == null) {
            if (DEBUG) {
                MarioLog.e(TAG, "bdfile path is empy");
            }
        } else if (!this.mDecodeBdfile.equals(path2)) {
            this.mDecodeBdfile = path2;
            nativeSetBdFileRealPath(this.mNativeV8Engine, path2);
        }
    }

    public InspectorNativeClient getInspectorNativeClient() {
        return this.mInspectorNativeClient;
    }

    public void setInspectorChannel(InspectorNativeChannel channel) {
        this.mInspectorChannel = channel;
    }

    private int checkBeforeInvokeNativeMethod(boolean checkNullParam, boolean mustInvokeInV8Thread, Object... objects) {
        if (checkNullParam) {
            if (objects == null) {
                return 3;
            }
            for (Object object : objects) {
                if (object == null) {
                    return 4;
                }
            }
        }
        if (this.mNativeV8Engine == 0 || this.mIsDestroyed.get()) {
            return 5;
        }
        if (mustInvokeInV8Thread) {
            if (this.mThreadDelegatePolicy.getThread() == null) {
                return 2;
            }
            if (this.mThreadDelegatePolicy.getThread() == null || this.mThreadDelegatePolicy.getThread() == Thread.currentThread()) {
                return 0;
            }
            return 2;
        }
        return 0;
    }

    public int setCustomJsCodeCacheHandler(CustomJsCodeCacheHandler customJsCodeCacheHandler) {
        int checkBeforeInvokeNativeMethod = checkBeforeInvokeNativeMethod(true, false, customJsCodeCacheHandler);
        int result = checkBeforeInvokeNativeMethod;
        if (checkBeforeInvokeNativeMethod == 0) {
            int nativeSetCustomJsCodeCacheHandler = nativeSetCustomJsCodeCacheHandler(this.mNativeV8Engine, customJsCodeCacheHandler);
            result = nativeSetCustomJsCodeCacheHandler;
            if (nativeSetCustomJsCodeCacheHandler == 0) {
                this.mCustomJsCodeCacheHandler = customJsCodeCacheHandler;
            }
        }
        if (result != 0 && DEBUG) {
            MarioLog.w(TAG, "setCustomJsCodeCacheHandler调用失败, 错误码: " + result);
        }
        return result;
    }

    public boolean useCodeCacheSetting(V8EngineConfiguration.CodeCacheSetting codeCacheSetting) {
        Context context = getAppContext();
        if (context == null) {
            if (DEBUG) {
                MarioLog.w(TAG, "[CodeCache] SetCodeCacheSetting failed. Context is null");
            }
            return false;
        } else if (!DiskCodeCacheManager.isCodeCacheSettingValid(context, codeCacheSetting)) {
            if (DEBUG) {
                MarioLog.w(TAG, "[CodeCache] CodeCacheSetting is invalid.");
            }
            return false;
        } else {
            File createDiskCodeCacheDirectory = DiskCodeCacheManager.createDiskCodeCacheDirectory(context, (String) null);
            this.mDiskCodeCachePathFile = createDiskCodeCacheDirectory;
            if (createDiskCodeCacheDirectory == null) {
                if (DEBUG) {
                    MarioLog.w(TAG, "[CodeCache] Create disk code cache directory failed.");
                }
                return false;
            }
            String[] strings = new String[codeCacheSetting.pathList.size()];
            codeCacheSetting.pathList.toArray(strings);
            boolean nativeResult = nativeSetCodeCacheSetting(this.mNativeV8Engine, codeCacheSetting.id, this.mDiskCodeCachePathFile.getAbsolutePath(), codeCacheSetting.maxCount, strings, codeCacheSetting.sizeLimit, codeCacheSetting.diskCodeCacheSizeThreshold);
            if (!nativeResult && DEBUG) {
                MarioLog.w(TAG, "[CodeCache] NativeSetCodeCacheSetting failed.");
            }
            return nativeResult;
        }
    }

    @Deprecated
    public void setCodeCacheSetting(V8EngineConfiguration.CodeCacheSetting codeCacheSetting) {
        useCodeCacheSetting(codeCacheSetting);
    }

    public boolean clearDiskCodeCache(String id) {
        if (TextUtils.isEmpty(id)) {
            return false;
        }
        File file = this.mDiskCodeCachePathFile;
        if (file == null || !file.exists()) {
            return true;
        }
        return DiskCodeCacheManager.clearDiskCodeCache(this.mDiskCodeCachePathFile.getAbsolutePath(), id);
    }

    public JSONArray getPerformanceJson() {
        PerformanceJsonBean performanceJsonBean = this.mPerformanceJsonBean;
        return performanceJsonBean == null ? new JSONArray() : performanceJsonBean.toJSONArray();
    }

    public PerformanceJsonBean getPerformanceJsonBean() {
        return this.mPerformanceJsonBean;
    }

    public void setJSCacheCallback(V8EngineConfiguration.JSCacheCallback callback) {
        this.mJSCacheCallback = callback;
    }

    public void setJsCodeCacheCallback(JsCodeCacheCallback callback) {
        this.mJsCodeCacheCallback = callback;
    }

    private void onJsCodeCacheFinished(String businessId, String path, boolean isCacheUsed) {
        try {
            JsCodeCacheCallback jsCodeCacheCallback = this.mJsCodeCacheCallback;
            if (jsCodeCacheCallback != null) {
                jsCodeCacheCallback.onJsCodeCacheFinished(new JsCodeCacheResult(businessId, path, isCacheUsed));
                return;
            }
            V8EngineConfiguration.JSCacheCallback jSCacheCallback = this.mJSCacheCallback;
            if (jSCacheCallback != null) {
                jSCacheCallback.onCacheResult(new V8EngineConfiguration.CacheInfo(path, isCacheUsed));
            }
        } catch (Throwable e2) {
            if (DEBUG) {
                MarioLog.w(TAG, "onJsCodeCacheFinished invoke failed. please check the exception message.", e2);
            }
        }
    }

    public void setMainPackageBasePath(String path) {
        String path2 = getTrimPath(path);
        if (path2 == null) {
            if (DEBUG) {
                MarioLog.e(TAG, "mainPacakge path is empty");
            }
        } else if (!this.mMainPackageBasePath.equals(path2)) {
            this.mMainPackageBasePath = path2;
            nativeSetMainPackageBasePath(this.mNativeV8Engine, path2);
        }
    }

    public String getBdFileRealPath() {
        return this.mDecodeBdfile;
    }

    public String getMainPackageBasePath() {
        return this.mMainPackageBasePath;
    }

    public void setFileSystemDelegatePolicy(V8FileSystemDelegatePolicy fileSystemDelegatePolicy) {
        this.mFileSystemDelegatePolicy = fileSystemDelegatePolicy;
    }

    public void setV8InitParams(long isolate, long context) {
        this.mV8IsolateInstance = isolate;
        this.mV8ContextInstance = context;
    }

    public void setJSThreadDelegate(V8EngineConfiguration.JSThreadDelegate delegate, long isolate, long context) {
        this.mJSThreadDelegate = delegate;
        this.mV8IsolateInstance = isolate;
        this.mV8ContextInstance = context;
        delegate.runOnInit(new Runnable() {
            public void run() {
                V8Engine v8Engine = V8Engine.this;
                v8Engine.nativeSetV8Isolate(v8Engine.mNativeV8Engine, V8Engine.this.mV8IsolateInstance, V8Engine.this.mV8ContextInstance);
            }
        });
        this.mJSThreadDelegate.runOnDestroy(new Runnable() {
            public void run() {
                V8Engine v8Engine = V8Engine.this;
                v8Engine.v8EngineDestroy(v8Engine.mNativeV8Engine);
            }
        });
    }

    public V8Engine(Context context, String basePath, String path, V8ThreadDelegatePolicy threadDelegatePolicy, Object mainGlobalObject, Object openGlobalObject) {
        initialize(context, basePath, path, threadDelegatePolicy, mainGlobalObject, openGlobalObject);
    }

    private void initialize(Context context, String basePath, String path, V8ThreadDelegatePolicy threadDelegatePolicy, Object mainGlobalObject, Object openGlobalObject) {
        this.mV8ExceptionInfo = new V8ExceptionInfo();
        this.mJavaBoundObjectManager = new JavaBoundObjectManager();
        this.mPerformanceJsonBean = new PerformanceJsonBean();
        this.mNativeV8Engine = v8EngineInit();
        boolean z = DEBUG;
        if (z) {
            MarioLog.i("CanvasView------>>>>mAREngine.mNativeV8Engine", "mNativeV8Engine " + this.mNativeV8Engine);
        }
        this.mIsDestroyed.set(false);
        synchronized (sEngines) {
            sEngines.put(Long.valueOf(this.mNativeV8Engine), this);
            if (z) {
                for (Map.Entry<Long, V8Engine> entry : sEngines.entrySet()) {
                    MarioLog.i("CanvasView------>>>>mAREngine.mNativeV8Engine", "mNativeV8Engine entry.getKey() " + entry.getKey() + "entry.getValue() :" + entry.getValue() + "\n");
                }
            }
        }
        this.mThreadDelegatePolicy = threadDelegatePolicy;
        this.mMainGlobalObject = mainGlobalObject;
        this.mOpenGlobalObject = openGlobalObject;
    }

    public Object getOpenGlobalObject() {
        return this.mOpenGlobalObject;
    }

    static void checkValid(long engine, long threadId) {
        long currentId = Thread.currentThread().getId();
        if (threadId != 0 && threadId != currentId) {
            throw new IllegalStateException("javascript or v8 methods must run on v8 thread, current thread id = " + currentId + ", expect thread id = " + threadId);
        } else if (engine == 0) {
            throw new IllegalStateException("v8 engine has been destroyed!");
        }
    }

    public void setPreferredFramesPerSecond(short rate) {
        if (rate > 0 && rate <= 60) {
            this.mFramesInterval = (float) (1000 / ((long) rate));
        }
    }

    public float minFramesInterval() {
        return this.mFramesInterval;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001c, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.temp.searchbox.v8engine.V8Engine getInstance(long r3) {
        /*
            java.util.HashMap<java.lang.Long, com.temp.searchbox.v8engine.V8Engine> r0 = sEngines
            monitor-enter(r0)
            java.util.HashMap<java.lang.Long, com.temp.searchbox.v8engine.V8Engine> r1 = sEngines     // Catch:{ all -> 0x001e }
            java.lang.Long r2 = java.lang.Long.valueOf(r3)     // Catch:{ all -> 0x001e }
            java.lang.Object r1 = r1.get(r2)     // Catch:{ all -> 0x001e }
            com.temp.searchbox.v8engine.V8Engine r1 = (com.temp.searchbox.v8engine.V8Engine) r1     // Catch:{ all -> 0x001e }
            if (r1 == 0) goto L_0x001b
            java.util.concurrent.atomic.AtomicBoolean r2 = r1.mIsDestroyed     // Catch:{ all -> 0x001e }
            boolean r2 = r2.get()     // Catch:{ all -> 0x001e }
            if (r2 != 0) goto L_0x001b
            monitor-exit(r0)     // Catch:{ all -> 0x001e }
            return r1
        L_0x001b:
            monitor-exit(r0)     // Catch:{ all -> 0x001e }
            r0 = 0
            return r0
        L_0x001e:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x001e }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.temp.searchbox.v8engine.V8Engine.getInstance(long):com.temp.searchbox.v8engine.V8Engine");
    }

    public static V8Engine getInstance() {
        long threadId = Thread.currentThread().getId();
        V8Engine engine = null;
        synchronized (sEngines) {
            Iterator<V8Engine> it = sEngines.values().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                V8Engine v = it.next();
                if (v != null && v.mV8ThreadId == threadId) {
                    if (!v.mIsDestroyed.get()) {
                        engine = v;
                    }
                }
            }
        }
        return engine;
    }

    public static Context getAppContext() {
        return sAppContext;
    }

    public static boolean isDebug() {
        return appDebug;
    }

    public synchronized void startEngine() {
        V8ThreadDelegatePolicy v8ThreadDelegatePolicy = this.mThreadDelegatePolicy;
        if (v8ThreadDelegatePolicy != null) {
            v8ThreadDelegatePolicy.startV8Engine(this);
        } else {
            MarioLog.w(TAG, "startV8Engine failed. please init thread delegate policy before");
        }
    }

    public void setExternalV8BinFilesPath(String filePath) {
        if (filePath == null) {
            this.mExternalV8BinPath = null;
            return;
        }
        String filePath2 = filePath.trim();
        if (TextUtils.isEmpty(filePath2)) {
            filePath2 = null;
        }
        this.mExternalV8BinPath = filePath2;
    }

    public synchronized boolean isPaused() {
        return this.mPaused;
    }

    private void onReady() {
        this.mReady = true;
        if (this.mHandlers != null) {
            for (V8StatusListener h2 : new ArrayList<>(this.mHandlers)) {
                h2.onReady();
            }
        }
    }

    public void onPause() {
        this.mPaused = true;
        if (this.mHandlers != null) {
            for (V8StatusListener h2 : new ArrayList<>(this.mHandlers)) {
                h2.onPause();
            }
        }
    }

    public void onResume() {
        this.mPaused = false;
        if (this.mHandlers != null) {
            for (V8StatusListener h2 : new ArrayList<>(this.mHandlers)) {
                h2.onResume();
            }
        }
        postSuspendableTasks();
    }

    public void setUserAgent(String ua) {
        if (!TextUtils.equals(ua, this.mUserAgent)) {
            this.mUserAgent = ua;
            nativeSetUserAgent(this.mNativeV8Engine, ua);
        }
    }

    public String userAgent() {
        return this.mUserAgent;
    }

    public boolean isReady() {
        return this.mReady;
    }

    public boolean isDestroyed() {
        return this.mIsDestroyed.get();
    }

    public void destroyEngine(final V8ExecuteCallback callback) {
        if (DEBUG) {
            MarioLog.e("V8", "v8engine.java::destroyEngine");
        }
        runOnJSThreadDirectly(new Runnable() {
            public void run() {
                if (V8Engine.DEBUG) {
                    MarioLog.e(V8Engine.TAG, "v8engine.java::destroyEngine run");
                }
                if (!V8Engine.this.mIsDestroyed.getAndSet(true)) {
                    if (V8Engine.this.mJavaBoundObjectManager != null) {
                        V8Engine.this.mJavaBoundObjectManager.clear();
                    }
                    synchronized (V8Engine.sEngines) {
                        V8Engine.sEngines.remove(Long.valueOf(V8Engine.this.mNativeV8Engine));
                    }
                    if (V8Engine.this.mInspectorNativeClient != null) {
                        V8Engine.this.mInspectorNativeClient.destroy();
                    }
                    V8Engine v8Engine = V8Engine.this;
                    v8Engine.v8EngineDestroy(v8Engine.mNativeV8Engine);
                    long unused = V8Engine.this.mNativeV8Engine = 0;
                    if (V8Engine.this.mThreadDelegatePolicy != null) {
                        V8Engine.this.mThreadDelegatePolicy.shutdown();
                    }
                    if (V8Engine.this.mFileSystemDelegatePolicy != null) {
                        V8Engine.this.mFileSystemDelegatePolicy.destroy();
                    }
                    int unused2 = V8Engine.mSurfaceViewWidth = 0;
                    int unused3 = V8Engine.mSurfaceViewHeight = 0;
                    V8ExecuteCallback v8ExecuteCallback = callback;
                    if (v8ExecuteCallback != null) {
                        v8ExecuteCallback.onExecuted();
                    }
                } else if (V8Engine.DEBUG) {
                    MarioLog.w(V8Engine.TAG, "v8engine.java:destroyEngine has been called before");
                }
            }
        });
    }

    private void delegateRunnable(Runnable runnable, boolean directly) {
        V8ThreadDelegatePolicy v8ThreadDelegatePolicy = this.mThreadDelegatePolicy;
        if (v8ThreadDelegatePolicy == null) {
            if (DEBUG) {
                MarioLog.e(TAG, "delegate runnable failed. please init thread delegate policy");
            }
        } else if (v8ThreadDelegatePolicy.getThread() == Thread.currentThread()) {
            checkValid(this.mNativeV8Engine, this.mV8ThreadId);
            try {
                runnable.run();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } else if (directly) {
            this.mThreadDelegatePolicy.doDelegateRunnableDirectly(runnable);
        } else {
            this.mThreadDelegatePolicy.doDelegateRunnable(runnable);
        }
    }

    private void delegateRunnableAsync(Runnable runnable) {
        V8ThreadDelegatePolicy v8ThreadDelegatePolicy = this.mThreadDelegatePolicy;
        if (v8ThreadDelegatePolicy != null) {
            v8ThreadDelegatePolicy.doDelegateRunnable(runnable);
        } else if (DEBUG) {
            MarioLog.w(TAG, "Execute delegateRunnableAsync failed. mThreadDelegatePolicy is null");
        }
    }

    private void delegateRunnableAsync(Runnable runnable, long delayMillis) {
        V8ThreadDelegatePolicy v8ThreadDelegatePolicy = this.mThreadDelegatePolicy;
        if (v8ThreadDelegatePolicy != null) {
            v8ThreadDelegatePolicy.doDelegateRunnable(runnable, delayMillis);
        } else if (DEBUG) {
            MarioLog.w(TAG, "Execute delegateRunnableAsync failed. mThreadDelegatePolicy is null");
        }
    }

    public void pumpMessageLoop() {
        try {
            postOnJSThread(new Runnable() {
                public void run() {
                    if (!V8Engine.this.mIsDestroyed.get()) {
                        V8Engine.checkValid(V8Engine.this.mNativeV8Engine, V8Engine.this.mV8ThreadId);
                        V8Engine v8Engine = V8Engine.this;
                        v8Engine.pumpNativeMessageLoop(v8Engine.mNativeV8Engine, 0);
                    }
                }
            });
        } catch (Throwable t) {
            if (DEBUG) {
                Log.e(TAG, "", t);
            }
        }
    }

    public void pumpMessageLoop(final long id, long delayMillis) {
        if (id > 0) {
            try {
                postOnJSThread(new Runnable() {
                    public void run() {
                        if (!V8Engine.this.mIsDestroyed.get()) {
                            V8Engine.checkValid(V8Engine.this.mNativeV8Engine, V8Engine.this.mV8ThreadId);
                            V8Engine v8Engine = V8Engine.this;
                            v8Engine.pumpNativeMessageLoop(v8Engine.mNativeV8Engine, id);
                        }
                    }
                }, delayMillis);
            } catch (Throwable t) {
                if (DEBUG) {
                    Log.e(TAG, "", t);
                }
            }
        }
    }

    public synchronized void addStatusHandler(V8StatusListener h2) {
        if (this.mReady) {
            h2.onReady();
            return;
        }
        if (this.mHandlers == null) {
            this.mHandlers = new ArrayList<>(1);
        }
        this.mHandlers.add(h2);
    }

    public synchronized void removeStatusHandler(V8StatusListener handler) {
        ArrayList<V8StatusListener> arrayList = this.mHandlers;
        if (arrayList != null) {
            arrayList.remove(handler);
        }
    }

    public void throwJSException(final JSExceptionType type, final String msg) {
        runOnJSThread(new Runnable() {
            public void run() {
                V8Engine.checkValid(V8Engine.this.mNativeV8Engine, V8Engine.this.mV8ThreadId);
                V8Engine v8Engine = V8Engine.this;
                v8Engine.nativeThrowJSException(v8Engine.mNativeV8Engine, type.ordinal(), msg, true);
            }
        });
    }

    public void runOnJSThread(Runnable runnable) {
        if (!this.mIsDestroyed.get()) {
            delegateRunnable(runnable, false);
        } else {
            MarioLog.w(TAG, "runOnJSThread fail. please start engine before execute js task");
        }
    }

    public static void runOnJSThread(long enginePtr, Runnable runnable) {
        V8Engine v8Engine = getInstance(enginePtr);
        if (v8Engine != null) {
            v8Engine.runOnJSThread(runnable);
        }
    }

    public void runOnJSThreadDirectly(Runnable runnable) {
        if (!this.mIsDestroyed.get()) {
            delegateRunnable(runnable, true);
        } else {
            MarioLog.w(TAG, "runOnJSThreadDirectly fail. please start engine before execute js task");
        }
    }

    public void postOnJSThread(Runnable runnable) {
        if (!this.mIsDestroyed.get()) {
            delegateRunnableAsync(runnable);
        } else {
            MarioLog.w(TAG, "postOnJsThread fail. please start engine before execute js task");
        }
    }

    public void postOnJSThread(Runnable runnable, long delayMillis) {
        if (!this.mIsDestroyed.get()) {
            delegateRunnableAsync(runnable, delayMillis);
        } else {
            MarioLog.w(TAG, "postOnJsThread fail. please start engine before execute js task");
        }
    }

    public void postSuspendableTaskOnJSThread(Runnable runnable) {
        if (!this.mIsDestroyed.get()) {
            synchronized (this) {
                if (this.mPaused) {
                    if (this.mSuspendableTasks == null) {
                        this.mSuspendableTasks = new Vector<>(1);
                    }
                    this.mSuspendableTasks.add(runnable);
                    return;
                }
                delegateRunnableAsync(runnable);
            }
        } else if (DEBUG) {
            MarioLog.w(TAG, "postOnJsThread fail. please start engine before execute js task");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0061, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void postSuspendableTasks() {
        /*
            r3 = this;
            monitor-enter(r3)
            java.util.Vector<java.lang.Runnable> r0 = r3.mSuspendableTasks     // Catch:{ all -> 0x0062 }
            if (r0 == 0) goto L_0x0031
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0062 }
            if (r0 != 0) goto L_0x0031
            java.util.concurrent.atomic.AtomicBoolean r0 = r3.mIsDestroyed     // Catch:{ all -> 0x0062 }
            boolean r0 = r0.get()     // Catch:{ all -> 0x0062 }
            if (r0 == 0) goto L_0x0014
            goto L_0x0031
        L_0x0014:
            java.util.Vector<java.lang.Runnable> r0 = r3.mSuspendableTasks     // Catch:{ all -> 0x0062 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0062 }
        L_0x001a:
            boolean r1 = r0.hasNext()     // Catch:{ all -> 0x0062 }
            if (r1 == 0) goto L_0x002a
            java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x0062 }
            java.lang.Runnable r1 = (java.lang.Runnable) r1     // Catch:{ all -> 0x0062 }
            r3.delegateRunnableAsync(r1)     // Catch:{ all -> 0x0062 }
            goto L_0x001a
        L_0x002a:
            java.util.Vector<java.lang.Runnable> r0 = r3.mSuspendableTasks     // Catch:{ all -> 0x0062 }
            r0.clear()     // Catch:{ all -> 0x0062 }
            monitor-exit(r3)
            return
        L_0x0031:
            boolean r0 = DEBUG     // Catch:{ all -> 0x0062 }
            if (r0 == 0) goto L_0x0060
            java.lang.String r0 = "TLS_V8Engine"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0062 }
            r1.<init>()     // Catch:{ all -> 0x0062 }
            java.lang.String r2 = "postSuspendableTasks failed. mSuspendableTasks = "
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ all -> 0x0062 }
            java.util.Vector<java.lang.Runnable> r2 = r3.mSuspendableTasks     // Catch:{ all -> 0x0062 }
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ all -> 0x0062 }
            java.lang.String r2 = ", mIsDestroyed = "
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ all -> 0x0062 }
            java.util.concurrent.atomic.AtomicBoolean r2 = r3.mIsDestroyed     // Catch:{ all -> 0x0062 }
            boolean r2 = r2.get()     // Catch:{ all -> 0x0062 }
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ all -> 0x0062 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0062 }
            com.temp.smallgame.sdk.MarioLog.w((java.lang.String) r0, (java.lang.String) r1)     // Catch:{ all -> 0x0062 }
        L_0x0060:
            monitor-exit(r3)
            return
        L_0x0062:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.temp.searchbox.v8engine.V8Engine.postSuspendableTasks():void");
    }

    public void throwJSExceptionForOpenData(final JSExceptionType type, final String msg) {
        runOnJSThread(new Runnable() {
            public void run() {
                V8Engine.checkValid(V8Engine.this.mNativeV8Engine, V8Engine.this.mV8ThreadId);
                V8Engine v8Engine = V8Engine.this;
                v8Engine.nativeThrowJSException(v8Engine.mNativeV8Engine, type.ordinal(), msg, false);
            }
        });
    }

    public String getInitBasePath() {
        return this.mInitBasePath;
    }

    public synchronized void addV8EngineConsole(V8EngineConsole aConsole) {
        if (this.mConsoles == null) {
            this.mConsoles = new ArrayList<>(1);
        }
        this.mConsoles.add(aConsole);
    }

    public synchronized void removeV8EngineConsole(V8EngineConsole aConsole) {
        ArrayList<V8EngineConsole> arrayList = this.mConsoles;
        if (arrayList != null) {
            arrayList.remove(aConsole);
        }
    }

    /* Debug info: failed to restart local var, previous not found, register: 0 */
    public synchronized void onConsoleCallBack(int consoleLevel, String consoleInfo) {
        switch (consoleLevel) {
            case 1:
                onLogConsole(consoleInfo);
                break;
            case 2:
                onDebugConsole(consoleInfo);
                break;
            case 3:
                onInfoConsole(consoleInfo);
                break;
            case 4:
                onErrorConsole(consoleInfo);
                break;
            case 5:
                onWarnConsole(consoleInfo);
                break;
            case 6:
                onTraceConsole(consoleInfo);
                break;
        }
    }

    private void onLogConsole(String consoleInfo) {
        if (this.mConsoles != null) {
            for (V8EngineConsole c2 : new ArrayList<>(this.mConsoles)) {
                c2.onLogConsole(consoleInfo);
            }
        }
    }

    private void onDebugConsole(String consoleInfo) {
        if (this.mConsoles != null) {
            for (V8EngineConsole c2 : new ArrayList<>(this.mConsoles)) {
                c2.onDebugConsole(consoleInfo);
            }
        }
    }

    private void onInfoConsole(String consoleInfo) {
        if (this.mConsoles != null) {
            for (V8EngineConsole c2 : new ArrayList<>(this.mConsoles)) {
                c2.onInfoConsole(consoleInfo);
            }
        }
    }

    private void onErrorConsole(String consoleInfo) {
        if (this.mConsoles != null) {
            for (V8EngineConsole c2 : new ArrayList<>(this.mConsoles)) {
                c2.onErrorConsole(consoleInfo);
            }
        }
    }

    private void onWarnConsole(String consoleInfo) {
        if (this.mConsoles != null) {
            for (V8EngineConsole c2 : new ArrayList<>(this.mConsoles)) {
                c2.onWarnConsole(consoleInfo);
            }
        }
    }

    private void onTraceConsole(String consoleInfo) {
        if (this.mConsoles != null) {
            for (V8EngineConsole c2 : new ArrayList<>(this.mConsoles)) {
                c2.onTraceConsole(consoleInfo);
            }
        }
    }

    public void setWorkerFactoryDelegate(WorkerFactory delegate) {
        this.mWorkerFactoryDelegate = delegate;
    }

    public long createWorkerV8Engine(long nativeWorkerScope) {
        boolean z = DEBUG;
        if (z) {
            MarioLog.e("V8", "!!!!!createWorkerV8Engine, mWorkerFactoryDelegate =  " + this.mWorkerFactoryDelegate);
        }
        WorkerFactory workerFactory = this.mWorkerFactoryDelegate;
        if (workerFactory != null) {
            V8Engine workerEngine = workerFactory.onCreateWorker();
            workerEngine.setIsWorker(true);
            StringBuilder append = new StringBuilder().append("MarioWT");
            int i2 = sWorkerID;
            sWorkerID = i2 + 1;
            workerEngine.setThreadName(append.append(i2).toString());
            workerEngine.startEngine();
            return workerEngine.nativePtr();
        } else if (!z) {
            return 0;
        } else {
            MarioLog.e("V8", "ERROR!!!!! no mWorkerFactoryDelegate");
            return 0;
        }
    }

    public void destroyWorkerV8Engine() {
        destroyEngine((V8ExecuteCallback) null);
    }

    public void setJavaScriptExceptionDelegate(JavaScriptExceptionDelegate delegate) {
        this.mExceptionDelegate = delegate;
    }

    public void onV8ExceptionCallBack(String exceptionMsg, String exceptionTrace, String fileName, String fileRealPath) {
        if (this.mExceptionDelegate != null) {
            this.mV8ExceptionInfo.reset(System.currentTimeMillis(), exceptionMsg, exceptionTrace, fileName, fileRealPath);
            this.mExceptionDelegate.onV8ExceptionCallBack(this.mV8ExceptionInfo);
        }
    }

    public void addJavascriptInterface(Object object, String name) {
        addPossiblyUnsafeJavascriptInterface(object, name, JavascriptInterface.class, true);
    }

    public void addJavascriptInterfaceForOpenData(Object object, String name) {
        addPossiblyUnsafeJavascriptInterface(object, name, JavascriptInterface.class, false);
    }

    private void addPossiblyUnsafeJavascriptInterface(Object object, String name, Class<? extends Annotation> cls, boolean mainContext) {
        if (object == null || this.mNativeV8Engine == 0) {
            MarioLog.i(TAG, "addPossiblyUnsafeJavascriptInterface object is null or mNativeV8Engine is null");
        } else if (!this.mIsDestroyed.get()) {
            addJavascriptInterfaceImpl(this.mNativeV8Engine, object, name, (Class) null, mainContext);
        } else {
            MarioLog.w(TAG, "addPossiblyUnsafeJavascriptInterface fail. please start engine before execute js task");
        }
    }

    public void removeJavascriptInterface(final String name) {
        runOnJSThread(new Runnable() {
            public void run() {
                if (!V8Engine.this.mIsDestroyed.get()) {
                    V8Engine v8Engine = V8Engine.this;
                    v8Engine.removeJavascriptInterfaceImpl(v8Engine.mNativeV8Engine, name, true);
                    return;
                }
                MarioLog.w(V8Engine.TAG, "removeJavascriptInterface fail. please start engine before execute js task");
            }
        });
    }

    public void removeJavascriptInterfaceForOpenData(final String name) {
        runOnJSThread(new Runnable() {
            public void run() {
                if (!V8Engine.this.mIsDestroyed.get()) {
                    V8Engine v8Engine = V8Engine.this;
                    v8Engine.removeJavascriptInterfaceImpl(v8Engine.mNativeV8Engine, name, false);
                    return;
                }
                MarioLog.w(V8Engine.TAG, "removeJavascriptInterfaceForOpenData fail. please start engine before execute js task");
            }
        });
    }

    public void requireJSFile(final String basePath, final String filePath) {
        runOnJSThread(new Runnable() {
            public void run() {
                if (!TextUtils.isEmpty(basePath) && !TextUtils.isEmpty(filePath) && !V8Engine.this.mIsDestroyed.get()) {
                    V8Engine v8Engine = V8Engine.this;
                    v8Engine.require(v8Engine.mNativeV8Engine, basePath, filePath, true, false);
                } else if (V8Engine.DEBUG) {
                    MarioLog.w(V8Engine.TAG, "basePath is null ? " + TextUtils.isEmpty(basePath) + ", filePath is null ?  " + TextUtils.isEmpty(filePath) + ", mIsDestroyed = " + V8Engine.this.mIsDestroyed.get());
                }
            }
        });
    }

    public void requireJSFileForOpenData(final String basePath, final String filePath) {
        runOnJSThread(new Runnable() {
            public void run() {
                if (!TextUtils.isEmpty(basePath) && !TextUtils.isEmpty(filePath) && !V8Engine.this.mIsDestroyed.get()) {
                    V8Engine v8Engine = V8Engine.this;
                    v8Engine.require(v8Engine.mNativeV8Engine, basePath, filePath, false, false);
                } else if (V8Engine.DEBUG) {
                    MarioLog.w(V8Engine.TAG, "basePath = " + basePath + ", filePath = " + filePath + ", mIsDestroyed = " + V8Engine.this.mIsDestroyed.get());
                }
            }
        });
    }

    public void destroyOpenDataContext() {
        runOnJSThread(new Runnable() {
            public void run() {
                if (!V8Engine.this.mIsDestroyed.get()) {
                    V8Engine v8Engine = V8Engine.this;
                    v8Engine.nativeDestroyOpenDataContext(v8Engine.mNativeV8Engine);
                    return;
                }
                MarioLog.w(V8Engine.TAG, "destroyOpenDataContext fail. please start engine before execute js task");
            }
        });
    }

    public void evaluateJavascript(final String js, final ValueCallback<String> resultCallback, final String tagName) {
        runOnJSThread(new Runnable() {
            public String toString() {
                return "evaluateJavascript-" + tagName;
            }

            public void run() {
                V8Engine.this.evaluateJavascriptImpl(js, resultCallback, tagName, true);
            }
        });
    }

    public void evaluateJavascriptForOpenData(final String js, final ValueCallback<String> resultCallback, final String tagName) {
        runOnJSThread(new Runnable() {
            public String toString() {
                return "evaluateJavascriptForOpenData-" + tagName;
            }

            public void run() {
                V8Engine.this.evaluateJavascriptImpl(js, resultCallback, tagName, false);
            }
        });
    }

    /* access modifiers changed from: private */
    public void evaluateJavascriptImpl(String js, ValueCallback<String> resultCallback, String tagName, boolean mainContext) {
        if (!this.mIsDestroyed.get()) {
            checkValid(this.mNativeV8Engine, this.mV8ThreadId);
            String result = runScript(this.mNativeV8Engine, js, tagName, mainContext);
            if (resultCallback != null) {
                resultCallback.onReceiveValue(result);
            }
        } else if (DEBUG) {
            MarioLog.w(TAG, "v8engine has been destroyed or not init. please init firstly.");
        }
    }

    public static String toColorRGBA(String colorStr) {
        return nativeToColorRGBA(colorStr);
    }

    public InspectorNativeClient initInspector(InspectorNativeChannel inspectorNativeChannel) {
        InspectorNativeClient inspectorNativeClient = new InspectorNativeClient(this.mNativeV8Engine, inspectorNativeChannel);
        this.mInspectorNativeClient = inspectorNativeClient;
        return inspectorNativeClient;
    }

    public byte[] serialize(JsSerializeValue value, boolean mainContext) {
        if (!this.mIsDestroyed.get()) {
            checkValid(this.mNativeV8Engine, this.mV8ThreadId);
            return nativeSerialize(this.mNativeV8Engine, value, mainContext);
        } else if (!DEBUG) {
            return null;
        } else {
            MarioLog.w(TAG, "serialize fail. please start engine before execute js task");
            return null;
        }
    }

    public JsSerializeValue deserialize(byte[] data, boolean mainContext) {
        if (data != null && data.length != 0 && !this.mIsDestroyed.get()) {
            checkValid(this.mNativeV8Engine, this.mV8ThreadId);
            return nativeDeserialize(this.mNativeV8Engine, data, data.length, mainContext);
        } else if (!DEBUG) {
            return null;
        } else {
            MarioLog.w(TAG, "deserialize fail. please start engine before execute js task");
            return null;
        }
    }

    static class MemoryInfo {
        @V8JavascriptField
        public int dalvikPrivateDirty;
        @V8JavascriptField
        public int dalvikPss;
        @V8JavascriptField
        public int nativePrivateDirty;
        @V8JavascriptField
        public int nativePss;
        @V8JavascriptField
        public int otherPrivateDirty;
        @V8JavascriptField
        public int otherPss;
        @V8JavascriptField
        public int summaryGraphics;
        @V8JavascriptField
        public int summaryJavaHeap;
        @V8JavascriptField
        public int summaryNativeHeap;
        @V8JavascriptField
        public int summaryPrivateOther;
        @V8JavascriptField
        public int summaryStack;
        @V8JavascriptField
        public int summaryTotalPss;
        @V8JavascriptField
        public int summaryTotalSwap;
        @V8JavascriptField
        public int totalPrivateDirty;
        @V8JavascriptField
        public int totalPss;

        MemoryInfo() {
        }
    }

    private final MemoryInfo getMemoryInfo() {
        Debug.MemoryInfo info = new Debug.MemoryInfo();
        android.os.Debug.getMemoryInfo(info);
        MemoryInfo mi = new MemoryInfo();
        mi.nativePss = info.nativePss;
        mi.nativePrivateDirty = info.nativePrivateDirty;
        mi.dalvikPss = info.dalvikPss;
        mi.dalvikPrivateDirty = info.dalvikPrivateDirty;
        mi.totalPss = info.getTotalPss();
        mi.totalPrivateDirty = info.getTotalPrivateDirty();
        mi.otherPss = info.otherPss;
        mi.otherPrivateDirty = info.otherPrivateDirty;
        if (Build.VERSION.SDK_INT > 23) {
            try {
                mi.summaryJavaHeap = Integer.parseInt(info.getMemoryStat("summary.java-heap"));
                mi.summaryNativeHeap = Integer.parseInt(info.getMemoryStat("summary.native-heap"));
                mi.summaryStack = Integer.parseInt(info.getMemoryStat("summary.stack"));
                mi.summaryGraphics = Integer.parseInt(info.getMemoryStat("summary.graphics"));
                mi.summaryPrivateOther = Integer.parseInt(info.getMemoryStat("summary.private-other"));
                mi.summaryTotalPss = Integer.parseInt(info.getMemoryStat("summary.total-pss"));
                mi.summaryTotalSwap = Integer.parseInt(info.getMemoryStat("summary.total-swap"));
            } catch (Throwable th2) {
            }
        }
        return mi;
    }

    public static void dumpJavaStackTraceToLogcat(String tag) {
        StackTraceElement[] stackTraceElements = Thread.getAllStackTraces().get(Thread.currentThread());
        MarioLog.w(tag, "================Java StackTrace================");
        if (stackTraceElements != null) {
            for (StackTraceElement stackTraceElement : stackTraceElements) {
                MarioLog.w(tag, stackTraceElement.toString());
            }
        }
        MarioLog.w(tag, "================Java StackTrace================");
    }

    public static void setCrashKeyValue(String key, String value) {
        try {
            if (sSetCrashKeyValueMethod == null) {
                sSetCrashKeyValueMethod = Class.forName("com.temp.webkit.internal.ApisInteractWithMario").getDeclaredMethod("setCrashKeyValue", new Class[]{String.class, String.class});
            }
            sSetCrashKeyValueMethod.invoke((Object) null, new Object[]{key, value});
        } catch (Throwable t) {
            MarioLog.e(TAG, t.getMessage());
        }
    }

    public static void clearCrashKey(String key) {
        try {
            if (sClearCrashKeyMethod == null) {
                sClearCrashKeyMethod = Class.forName("com.temp.webkit.internal.ApisInteractWithMario").getDeclaredMethod("clearCrashKey", new Class[]{String.class});
            }
            sClearCrashKeyMethod.invoke((Object) null, new Object[]{key});
        } catch (Throwable t) {
            MarioLog.e(TAG, t.getMessage());
        }
    }

    private static void regiestMessageChannelForT7() {
        try {
            Class.forName("com.baidu.webkit.internal.ApisInteractWithMario").getDeclaredMethod("setMessageChannalFunctoinTable", new Class[]{Long.TYPE}).invoke((Object) null, new Object[]{Long.valueOf(nativeGetChannelFunctionTable())});
        } catch (Throwable t) {
            MarioLog.e(TAG, t.getMessage());
        }
    }
}
