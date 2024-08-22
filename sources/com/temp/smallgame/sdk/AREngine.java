package com.temp.smallgame.sdk;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLSurfaceView;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.baidu.searchbox.fluency.utils.FpsConstants;
import com.baidu.talos.core.Debug;
import com.baidu.talos.core.util.RNABTestUtil;
import com.baidu.webkit.internal.Statistics;
import com.heytap.mcssdk.constant.MessageConstant;
import com.temp.glsurface.DuMixGameSurfaceView;
import com.temp.mario.recorder.AudioEngineProxy;
import com.temp.mario.recorder.GameRecorderCallback;
import com.temp.searchbox.v8engine.V8Engine;
import com.temp.searchbox.v8engine.bean.PerformanceJsonBean;
import com.temp.searchbox.v8engine.console.DebugConsole;
import com.temp.smallgame.sdk.ArBridge;
import com.temp.smallgame.sdk.MarioSDK;
import com.temp.smallgame.sdk.delegate.AREngineDelegate;
import com.temp.smallgame.sdk.exception.OnStuckScreenListener;
import com.temp.smallgame.sdk.exception.StuckScreenHandler;
import com.temp.smallgame.sdk.permission.PermissionProxy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.TreeSet;
import javax.microedition.khronos.opengles.GL10;
import org.json.JSONArray;

public final class AREngine implements AREngineDelegate {
    public static final String ACTION_ENGINE_INIT = "ar_engine_init";
    public static final String ACTION_ENGINE_START = "ar_engine_start";
    public static final String ACTION_FIRST_EVENT = "first_event";
    public static final String ACTION_FIRST_FRAME = "first_frame";
    public static final String ACTION_FIRST_PAINT = "first_paint";
    public static final String ACTION_FIRST_RENDER_INVOKE = "first_render_invoke";
    /* access modifiers changed from: private */
    public static final boolean DEBUG;
    public static final int DEBUG_CONSOLE_TYPE_QUEUE_EVENT = 0;
    public static final int DEBUG_CONSOLE_TYPE_RUN_EVENT_AFTER = 2;
    public static final int DEBUG_CONSOLE_TYPE_RUN_EVENT_BEFORE = 1;
    /* access modifiers changed from: private */
    public static final boolean LOG_PAUSE_RESUME;
    /* access modifiers changed from: private */
    public static final boolean LOG_RENDERER;
    private static final boolean LOG_RENDERER_DRAW_FRAME = false;
    /* access modifiers changed from: private */
    public static final boolean LOG_SURFACE;
    private static final boolean LOG_THREADS = false;
    public static final int RENDERMODE_CONTINUOUSLY = 1;
    public static final int RENDERMODE_WHEN_DIRTY = 0;
    private static final String TAG = "TLS_ArEngine";
    public int gDisplayRoataion = 0;
    public PermissionProxy gPermissionProxy = null;
    /* access modifiers changed from: private */
    public ArBridge mArBridge;
    private ArrayList<DebugConsole> mConsoles = null;
    private Context mContext;
    /* access modifiers changed from: private */
    public long mCurrentGLThreadID = -1;
    private boolean mDetached;
    private double mEGLErrorRate = 0.0d;
    private int mFPS = 0;
    private ARGLThread mGLThread;
    /* access modifiers changed from: private */
    public MarioSDK.AREngineConfiguration.GLThreadDelegate mGLThreadDelegate;
    /* access modifiers changed from: private */
    public boolean mHasInitialled = false;
    private double mJankRate = 0.0d;
    /* access modifiers changed from: private */
    public GLSurfaceView.Renderer mRenderer;
    /* access modifiers changed from: private */
    public Object mSurface;
    /* access modifiers changed from: private */
    public SurfaceTexture mSurfaceHolder;
    private float mSurfaceViewHeight = 0.0f;
    private float mSurfaceViewWidth = 0.0f;
    private DuMixGameSurfaceView.TalosEventDispatcher mTalosEventDispatcher = null;

    static {
        boolean isDebug = Debug.isDebug();
        DEBUG = isDebug;
        LOG_PAUSE_RESUME = isDebug;
        LOG_SURFACE = isDebug;
        LOG_RENDERER = isDebug;
    }

    public Context getContext() {
        return this.mContext;
    }

    public void setContext(Context context) {
        this.mContext = context;
    }

    public double getEGLErrorRate() {
        return this.mEGLErrorRate;
    }

    public void updateEGLErrorRate(int err, int total) {
        this.mEGLErrorRate = ((double) err) / ((double) total);
    }

    public double getJankRate() {
        return this.mJankRate;
    }

    public void updateJankRate(long jankTime, long totalTime) {
        this.mJankRate = ((double) jankTime) / ((double) totalTime);
    }

    public void setTalosEventDispatcher(DuMixGameSurfaceView.TalosEventDispatcher dispatcher) {
        this.mTalosEventDispatcher = dispatcher;
    }

    public void emitCanvasInitEvent() {
        DuMixGameSurfaceView.TalosEventDispatcher talosEventDispatcher = this.mTalosEventDispatcher;
        if (talosEventDispatcher != null) {
            talosEventDispatcher.emitCanvasInitEvent();
        }
    }

    public void emitCanvasChangedEvent(int w, int h2) {
        DuMixGameSurfaceView.TalosEventDispatcher talosEventDispatcher = this.mTalosEventDispatcher;
        if (talosEventDispatcher != null) {
            talosEventDispatcher.emitCanvasChangedEvent(w, h2);
        }
    }

    AREngine() {
        MarioLog.setMinLogLevel(6, false);
        this.mArBridge = new ArBridge();
    }

    public void startEngine() {
        if (this.mRenderer != null) {
            this.mGLThread = new ARGLThread(this);
            return;
        }
        throw new NullPointerException("start render engine failed. because renderer is not set");
    }

    public synchronized void addDebugConsole(DebugConsole aConsole) {
        if (this.mConsoles == null) {
            this.mConsoles = new ArrayList<>(1);
        }
        this.mConsoles.add(aConsole);
    }

    public synchronized void removeDebugConsole(DebugConsole aConsole) {
        ArrayList<DebugConsole> arrayList = this.mConsoles;
        if (arrayList != null) {
            arrayList.remove(aConsole);
        }
    }

    private void onConsole(int type, String consoleInfo) {
        if (this.mConsoles != null) {
            for (DebugConsole c2 : new ArrayList<>(this.mConsoles)) {
                c2.onReceiveInfo(type, consoleInfo);
            }
        }
    }

    public ArBridge getArBridge() {
        return this.mArBridge;
    }

    public long getCurrentGLThreadID() {
        return this.mCurrentGLThreadID;
    }

    public Thread getGLThread() {
        return null;
    }

    /* access modifiers changed from: package-private */
    public void updateFPS(int fps) {
        if (fps < 0) {
            fps = 0;
        }
        if (fps > 60) {
            fps = 60;
        }
        this.mFPS = fps;
        this.mArBridge.nativeUpdateFps((float) fps);
    }

    public int getFPS() {
        return this.mFPS;
    }

    public void updateSurfaceViewSize(float width, float height) {
        if (DEBUG) {
            MarioLog.d(TAG, "[ARDispose] updateSurfaceViewSize, width=" + width + ", height=" + height);
        }
        this.mSurfaceViewWidth = width;
        this.mSurfaceViewHeight = height;
        this.mArBridge.setSize(width, height);
    }

    public void initDisplayMetrics() {
        Context context = getContext();
        if (context != null) {
            DisplayMetrics metrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(metrics);
            float width = (float) metrics.widthPixels;
            float height = (float) metrics.heightPixels;
            boolean z = DEBUG;
            if (z) {
                MarioLog.d(TAG, "initDisplayMetrics " + width + " x " + height + " " + metrics.density);
            }
            if (this.mSurfaceViewWidth != 0.0f) {
                width = this.mSurfaceViewWidth;
            }
            if (this.mSurfaceViewHeight != 0.0f) {
                height = this.mSurfaceViewHeight;
            }
            ArBridge arBridge = this.mArBridge;
            if (arBridge != null) {
                arBridge.setDisplayMetrics(width, height, metrics.xdpi, metrics.ydpi, metrics.density);
            } else if (z) {
                MarioLog.e(TAG, "[RenderError] error init render display, because arbridge is null");
            }
        } else {
            throw new NullPointerException("[RenderError] initDisplayMetrics Error. because AppContext is null");
        }
    }

    public void setSurfaceHolder(SurfaceTexture surfaceHolder) {
        this.mSurfaceHolder = (SurfaceTexture) new WeakReference(surfaceHolder).get();
    }

    public void setRenderer(GLSurfaceView.Renderer renderer) {
        this.mRenderer = renderer;
    }

    public void setRenderMode(int renderMode) {
        ARGLThread aRGLThread = this.mGLThread;
        if (aRGLThread != null) {
            aRGLThread.setRenderMode(renderMode);
        }
    }

    public int getRenderMode() {
        ARGLThread aRGLThread = this.mGLThread;
        if (aRGLThread != null) {
            return aRGLThread.getRenderMode();
        }
        return 1;
    }

    public void requestRender() {
        ARGLThread aRGLThread = this.mGLThread;
        if (aRGLThread != null) {
            aRGLThread.requestRender();
        }
    }

    public void surfaceCreated() {
        if (LOG_SURFACE) {
            MarioLog.d(TAG, "noticed surfaceView surface surfaceCreated ");
        }
        if (this.mGLThread != null) {
            if (DEBUG) {
                MarioLog.d(TAG, "[V8Dispose][AREngine] surfaceCreated.");
            }
            this.mGLThread.surfaceCreated();
            Context ctx = V8Engine.getAppContext();
            if (ctx != null) {
                this.gDisplayRoataion = ((WindowManager) ctx.getSystemService("window")).getDefaultDisplay().getRotation();
                return;
            }
            return;
        }
        ARGLThread aRGLThread = new ARGLThread(this);
        this.mGLThread = aRGLThread;
        aRGLThread.surfaceCreated();
        Context ctx2 = V8Engine.getAppContext();
        if (ctx2 != null) {
            this.gDisplayRoataion = ((WindowManager) ctx2.getSystemService("window")).getDefaultDisplay().getRotation();
        }
    }

    public void surfaceDestroyed() {
        if (this.mGLThread != null) {
            if (DEBUG) {
                MarioLog.d(TAG, "[V8Dispose][AREngine] surfaceDestroyed.");
            }
            this.mGLThread.surfaceDestroyed();
        }
    }

    public void surfaceChanged(int w, int h2) {
        if (this.mGLThread != null) {
            if (DEBUG) {
                MarioLog.d(TAG, "[V8Dispose][AREngine] surfaceChanged. width=" + w + ", height=" + h2);
            }
            this.mGLThread.onWindowResize(w, h2);
        }
    }

    public void requestRenderAndWait() {
        ARGLThread aRGLThread = this.mGLThread;
        if (aRGLThread != null) {
            aRGLThread.requestRenderAndWait();
        }
    }

    public void smallGameOnPause() {
        this.mArBridge.smallGameOnPause();
    }

    public void runOnGLThread(Runnable r) {
        if (this.mGLThread != null) {
            if (DEBUG) {
                MarioLog.d(TAG, "runOnGLThread");
            }
            this.mGLThread.runOnGLThread(r);
        }
    }

    public void queueEvent(Runnable r) {
        ARGLThread aRGLThread = this.mGLThread;
        if (aRGLThread != null) {
            aRGLThread.queueEvent(r);
        }
    }

    public void queueEvent(Runnable r, long delayMillis) {
        ARGLThread aRGLThread = this.mGLThread;
        if (aRGLThread != null) {
            aRGLThread.queueDelayedEvent(r, delayMillis);
        }
    }

    public void onAttachedToWindow() {
        this.mDetached = false;
        if (DEBUG) {
            MarioLog.d(TAG, "[V8Dispose][AREngine] onAttachedToWindow");
        }
    }

    public void onDetachedFromWindow() {
        this.mDetached = true;
        if (DEBUG) {
            MarioLog.d(TAG, "[V8Dispose][AREngine] onDetachedFromWindow");
        }
    }

    public void clearOldEvents() {
        if (this.mGLThread != null && DEBUG) {
            MarioLog.d(TAG, "clearOldEvents");
        }
    }

    public void onPause() {
        ARGLThread aRGLThread = this.mGLThread;
        if (aRGLThread != null) {
            aRGLThread.onPause();
        }
        if (this.mArBridge.getGameRecorder() != null) {
            this.mArBridge.getGameRecorder().pauseRecordBySystem();
        }
    }

    public void onResume() {
        ARGLThread aRGLThread = this.mGLThread;
        if (aRGLThread != null) {
            aRGLThread.onResume();
        }
        if (this.mArBridge.getGameRecorder() != null) {
            this.mArBridge.getGameRecorder().resumeRecordBySystme();
        }
    }

    public void pauseRecord() {
        if (this.mArBridge.getGameRecorder() != null) {
            this.mArBridge.getGameRecorder().pauseRecord();
        }
    }

    public void resumeRecord() {
        if (this.mArBridge.getGameRecorder() != null) {
            this.mArBridge.getGameRecorder().resumeRecord();
        }
    }

    public void stopRecord() {
        if (this.mArBridge.getGameRecorder() != null) {
            this.mArBridge.getGameRecorder().stopRecord();
            this.mArBridge.nativeUpdateRecordingStatus(false);
        }
    }

    public void startRecord(boolean enableMic, int recordTime, String savePath, boolean isLandscape) {
        if (this.mArBridge.getGameRecorder() != null) {
            this.mArBridge.nativeUpdateRecordingStatus(true);
            this.mArBridge.getGameRecorder().startRecord(enableMic, recordTime, savePath, isLandscape);
        }
    }

    public void setGameRecordCallback(GameRecorderCallback impl) {
        if (this.mArBridge.getGameRecorder() != null) {
            this.mArBridge.getGameRecorder().setGameRecordCallback(impl);
        }
    }

    public void setAudioEngineProxy(AudioEngineProxy proxy) {
        if (this.mArBridge.getGameRecorder() != null) {
            this.mArBridge.getGameRecorder().setAudioEngineProxy(proxy);
        }
    }

    public long getCurrentRecordProcess() {
        if (this.mArBridge.getGameRecorder() != null) {
            return this.mArBridge.getGameRecorder().getCurrentRecordProgress();
        }
        return 0;
    }

    public void setPermissionProxy(PermissionProxy proxy) {
        this.gPermissionProxy = proxy;
    }

    public void setOnStuckScreenListener(OnStuckScreenListener listener) {
        ArBridge arBridge = this.mArBridge;
        if (arBridge != null) {
            arBridge.setOnStuckScreenListener(listener);
        }
    }

    public void setStuckScreenLimitTime(long stuckScreenLimitTime) {
        ArBridge arBridge = this.mArBridge;
        if (arBridge != null) {
            arBridge.setStuckScreenLimitTime(stuckScreenLimitTime);
        }
    }

    public StuckScreenHandler getStuckScreenHandler() {
        ArBridge arBridge = this.mArBridge;
        if (arBridge == null) {
            return null;
        }
        return arBridge.getStuckScreenHandler();
    }

    public void smallGameDestroy() {
        if (this.mGLThread != null) {
            this.mArBridge.smallGameDestroy();
            V8Engine v8Engine = V8Engine.getInstance();
            if (v8Engine != null && !v8Engine.isDestroyed() && DEBUG) {
                MarioLog.e(TAG, "v8engine is not destroyed. Please check that you have called the destroyEngine method");
            }
            this.mGLThread.stopEglSurfaceLocked();
            this.mGLThread.stopEglContextLocked();
        } else if (DEBUG) {
            MarioLog.e(TAG, "Destroy AREngine fail. Because GLThread is null");
        }
    }

    public boolean ableToDraw() {
        ARGLThread aRGLThread = this.mGLThread;
        return aRGLThread != null && aRGLThread.ableToDraw();
    }

    public void exitGLThread() {
        ARGLThread aRGLThread = this.mGLThread;
        if (aRGLThread != null) {
            aRGLThread.requestExitAndWait();
        }
        if (DEBUG) {
            MarioLog.d(TAG, "[AREngine] exit GL loop.");
        }
    }

    public void smallGameUpdate() {
        this.mArBridge.smallGameUpdate();
    }

    public void setScreenShotStatus(boolean bStart) {
        this.mArBridge.setScreenShotStatus(bStart);
    }

    public JSONArray getPerformanceJson() {
        ArBridge arBridge = this.mArBridge;
        return arBridge == null ? new JSONArray() : arBridge.getPerformanceJson();
    }

    public PerformanceJsonBean getPerformanceJsonBean() {
        ArBridge arBridge = this.mArBridge;
        return arBridge == null ? new PerformanceJsonBean() : arBridge.getPerformanceJsonBean();
    }

    public HashMap<String, String> getPerformanceJsonObjectList() {
        ArBridge arBridge = this.mArBridge;
        return arBridge == null ? new HashMap<>() : arBridge.getPerformanceJsonObjectList();
    }

    public void putPerformanceJsonId(String id) {
        ArBridge arBridge = this.mArBridge;
        if (arBridge != null) {
            arBridge.getPerformanceJsonBean().put(id);
        }
    }

    public void setFirstFrameListener(ArBridge.FirstFrameListener listener) {
        this.mArBridge.setFirstFrameListener(listener);
    }

    public boolean checkEGLContextVaild() {
        ARGLThread aRGLThread = this.mGLThread;
        return aRGLThread != null && aRGLThread.mHaveEglContext;
    }

    public EGLContext getEGLContext() {
        ARGLThread aRGLThread = this.mGLThread;
        if (aRGLThread == null || aRGLThread.mEglHelper == null) {
            return null;
        }
        return this.mGLThread.mEglHelper.mEglContext;
    }

    public EGLConfig getEGLConfig() {
        ARGLThread aRGLThread = this.mGLThread;
        if (aRGLThread == null || aRGLThread.mEglHelper == null) {
            return null;
        }
        return this.mGLThread.mEglHelper.mEglConfig;
    }

    public void attachToJsThread() {
        startEngine();
        getArBridge().smallGameOnInit();
        initDisplayMetrics();
        this.mGLThread.begin();
    }

    public void setGLThreadDelegate(MarioSDK.AREngineConfiguration.GLThreadDelegate delegate) {
        this.mGLThreadDelegate = delegate;
        delegate.runOnInit(new Runnable() {
            public void run() {
                AREngine.this.attachToJsThread();
            }
        });
        delegate.runOnLoop(new Runnable() {
            public void run() {
                AREngine.this.runLoop();
            }
        });
        delegate.runOnDestroy(new Runnable() {
            public void run() {
                if (AREngine.this.getArBridge() != null) {
                    AREngine.this.getArBridge().nativeSmallGameDestroy(AREngine.this.getArBridgeNativePtr());
                    AREngine.this.getArBridge().cleanNativePtr();
                }
            }
        });
    }

    public void runLoop() {
        ARGLThread aRGLThread = this.mGLThread;
        if (aRGLThread != null) {
            aRGLThread.run();
        }
    }

    public long getArBridgeNativePtr() {
        return this.mArBridge.nativePtr();
    }

    private void clearArBridgeNativePtr() {
        this.mArBridge.cleanNativePtr();
    }

    static class ARGLThread {
        private static final long CLOCKS_PER_SEC = 1000;
        private static final int EVENTS_RUN_TIME_LIMIT = 30;
        private static final int RECORE_FRAME_TIME = 33;
        private int allOnScreenFrameCount = 0;
        private boolean askedToReleaseEglContext = false;
        private int bigJank = 0;
        private boolean createEglContext = false;
        private boolean createEglSurface = false;
        private boolean createGlInterface = false;
        private boolean doRenderNotification = false;
        private int errorFrame = 0;
        private long firstDrawTime = 0;

        /* renamed from: h  reason: collision with root package name */
        private int f5629h = 0;
        private boolean isDrawFirstFrame = false;
        private boolean isFirstDraw = true;
        private boolean isInvokeFirstEvent = false;
        private boolean isResumeFromPaused = false;
        private int lastCalculateFrameCount = 0;
        private long lastCalculateFrameRateTime = 0;
        private long lastDrawFrameTime = 0;
        private long lastFinishDrawFrameTime = 0;
        private long lastUpdateTime = 0;
        private boolean lostEglContext = false;
        private AREngine mAREngine;
        private TreeSet<TimedRunnable> mDelayedEventQueue = new TreeSet<>();
        private LinkedList<Runnable> mDirectRunEventQueue = new LinkedList<>();
        /* access modifiers changed from: private */
        public EglHelper mEglHelper;
        private LinkedList<Runnable> mEventQueue = new LinkedList<>();
        private volatile boolean mExited = false;
        private boolean mFinishedCreatingEglSurface;
        private boolean mHasSurface;
        /* access modifiers changed from: private */
        public boolean mHaveEglContext;
        private boolean mHaveEglSurface;
        private int mHeight = 0;
        private int mPaintSecond = 0;
        private boolean mPaused;
        private boolean mRenderComplete;
        private int mRenderMode = 1;
        private boolean mRequestPaused;
        private boolean mRequestRender = true;
        private volatile boolean mShouldExit = false;
        private boolean mShouldReleaseEglContext;
        private boolean mSizeChanged = true;
        private boolean mSurfaceIsBad;
        private boolean mUpdateFlag = false;
        private V8Engine mV8Engine = null;
        private boolean mWaitingForSurface;
        private boolean mWantRenderNotification = false;
        private int mWidth = 0;
        private double renderSmooth = 0.0d;
        private boolean shouldCheckSetCpu = true;
        private boolean sizeChanged = false;
        private int smallJank = 0;
        private int targetFPS = 60;
        private int totalFrame = 0;
        private long totalJankTime = 0;
        private int w = 0;
        private boolean wantRenderNotification = false;

        ARGLThread(AREngine arEngine) {
            this.mAREngine = arEngine;
        }

        private long getId() {
            return this.mAREngine.mCurrentGLThreadID;
        }

        private V8Engine getV8Engine() {
            if (this.mV8Engine == null) {
                this.mV8Engine = V8Engine.getInstance();
            }
            return this.mV8Engine;
        }

        private float minFramesInterval() {
            V8Engine v8Engine = getV8Engine();
            if (v8Engine != null) {
                return v8Engine.minFramesInterval();
            }
            return 16.666666f;
        }

        public void stopEglSurfaceLocked() {
            if (AREngine.DEBUG) {
                MarioLog.d(AREngine.TAG, "stopEglSurfaceLocked");
            }
            if (this.mHaveEglSurface) {
                this.mHaveEglSurface = false;
                this.mEglHelper.destroySurface();
            }
        }

        public void stopEglContextLocked() {
            if (AREngine.DEBUG) {
                MarioLog.d(AREngine.TAG, "stopEglContextLocked");
            }
            if (this.mHaveEglContext) {
                this.mEglHelper.finish();
                this.mHaveEglContext = false;
            }
        }

        /* access modifiers changed from: private */
        public void begin() {
            this.mEglHelper = new EglHelper(this.mAREngine);
            this.mHaveEglContext = false;
            this.mHaveEglSurface = false;
            this.mWantRenderNotification = false;
        }

        private void end() {
            this.mEglHelper.reset();
            this.mEglHelper = null;
        }

        public boolean shouldForceRender() {
            return this.mAREngine.mArBridge.mFirstFrameFinished && ((float) (System.currentTimeMillis() - this.lastFinishDrawFrameTime)) > minFramesInterval();
        }

        /* access modifiers changed from: private */
        public void run() {
            Runnable event = null;
            while (!this.mShouldExit) {
                synchronized (this) {
                    if (!this.mDirectRunEventQueue.isEmpty()) {
                        event = this.mDirectRunEventQueue.pollFirst();
                    } else {
                        if (ableToDraw()) {
                            if (!shouldForceRender()) {
                                Runnable dequeueEvent = dequeueEvent();
                                event = dequeueEvent;
                                if (dequeueEvent != null) {
                                }
                            }
                        }
                        boolean pausing = false;
                        boolean z = this.mPaused;
                        boolean z2 = this.mRequestPaused;
                        if (z != z2) {
                            pausing = this.mRequestPaused;
                            this.mPaused = z2;
                            if (z2) {
                                this.isResumeFromPaused = false;
                                this.mAREngine.mArBridge.smallGameOnPauseOnGLThrad();
                            } else {
                                this.isResumeFromPaused = true;
                            }
                            if (AREngine.LOG_PAUSE_RESUME) {
                                MarioLog.d(AREngine.TAG, "mPaused is now " + this.mPaused + " tid=" + getId());
                            }
                        }
                        if (this.mShouldReleaseEglContext) {
                            if (AREngine.LOG_SURFACE) {
                                MarioLog.d(AREngine.TAG, "releasing EGL context because asked to tid=" + getId());
                            }
                            stopEglSurfaceLocked();
                            stopEglContextLocked();
                            this.mShouldReleaseEglContext = false;
                            this.askedToReleaseEglContext = true;
                        }
                        if (this.lostEglContext) {
                            stopEglSurfaceLocked();
                            stopEglContextLocked();
                            this.lostEglContext = false;
                        }
                        if (pausing && this.mHaveEglSurface) {
                            if (AREngine.LOG_SURFACE) {
                                MarioLog.d(AREngine.TAG, "releasing EGL surface because paused tid=" + getId());
                            }
                            stopEglSurfaceLocked();
                        }
                        if (pausing && this.mHaveEglContext && 1 == 0) {
                            stopEglContextLocked();
                            if (AREngine.LOG_SURFACE) {
                                MarioLog.d(AREngine.TAG, "releasing EGL context because paused tid=" + getId());
                            }
                        }
                        if (!this.mHasSurface && !this.mWaitingForSurface) {
                            if (AREngine.LOG_SURFACE) {
                                MarioLog.d(AREngine.TAG, "noticed surfaceView surface lost tid=" + getId());
                            }
                            if (this.mHaveEglSurface) {
                                stopEglSurfaceLocked();
                            }
                            this.mWaitingForSurface = true;
                            this.mSurfaceIsBad = false;
                        }
                        if (this.mHasSurface && this.mWaitingForSurface) {
                            if (AREngine.LOG_SURFACE) {
                                MarioLog.d(AREngine.TAG, "noticed surfaceView surface acquired tid=" + getId());
                            }
                            this.mWaitingForSurface = false;
                        }
                        if (this.doRenderNotification) {
                            if (AREngine.LOG_SURFACE) {
                                MarioLog.d(AREngine.TAG, "sending render notification tid=" + getId());
                            }
                            this.mWantRenderNotification = false;
                            this.doRenderNotification = false;
                            this.mRenderComplete = true;
                        }
                        if (readyToDraw()) {
                            if (!this.mHaveEglContext) {
                                if (this.askedToReleaseEglContext) {
                                    this.askedToReleaseEglContext = false;
                                } else {
                                    try {
                                        this.mEglHelper.start();
                                        this.mAREngine.mArBridge.setEglContextToRecorder(this.mAREngine.getEGLContext(), 0, 0);
                                    } catch (RuntimeException e2) {
                                        e2.printStackTrace();
                                    }
                                    this.mHaveEglContext = true;
                                    this.createEglContext = true;
                                }
                            }
                            if (this.mHaveEglContext && !this.mHaveEglSurface) {
                                this.mHaveEglSurface = true;
                                this.createEglSurface = true;
                                this.createGlInterface = true;
                                this.sizeChanged = true;
                            }
                            if (this.mHaveEglSurface) {
                                if (this.mSizeChanged) {
                                    this.sizeChanged = true;
                                    this.w = this.mWidth;
                                    this.f5629h = this.mHeight;
                                    this.mWantRenderNotification = true;
                                    if (AREngine.LOG_SURFACE) {
                                        MarioLog.d(AREngine.TAG, "we want render notification tid=" + getId());
                                    }
                                    this.createEglSurface = true;
                                    this.mSizeChanged = false;
                                }
                                this.mRequestRender = false;
                                if (this.mWantRenderNotification) {
                                    this.wantRenderNotification = true;
                                }
                            }
                        }
                        if (this.mAREngine.mGLThreadDelegate != null) {
                            return;
                        }
                    }
                }
                if (event != null) {
                    try {
                        event.run();
                        return;
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        return;
                    }
                } else {
                    if (this.createEglSurface) {
                        if (AREngine.LOG_SURFACE) {
                            MarioLog.d(AREngine.TAG, "egl createSurface");
                        }
                        if (this.mEglHelper.createSurface()) {
                            this.mFinishedCreatingEglSurface = true;
                            this.createEglSurface = false;
                        } else {
                            if (AREngine.DEBUG) {
                                MarioLog.d(AREngine.TAG, "bad surface");
                            }
                            this.mFinishedCreatingEglSurface = true;
                            this.mSurfaceIsBad = true;
                            return;
                        }
                    }
                    if (this.createGlInterface) {
                        this.createGlInterface = false;
                    }
                    if (this.createEglContext) {
                        if (AREngine.LOG_RENDERER) {
                            MarioLog.d(AREngine.TAG, "onSurfaceCreated");
                        }
                        AREngine arEngine = this.mAREngine;
                        if (arEngine != null) {
                            arEngine.mRenderer.onSurfaceCreated((GL10) null, (javax.microedition.khronos.egl.EGLConfig) null);
                        }
                        this.createEglContext = false;
                    }
                    if (this.sizeChanged) {
                        if (AREngine.LOG_RENDERER) {
                            MarioLog.d(AREngine.TAG, "onSurfaceChanged(" + this.w + ", " + this.f5629h + ")");
                        }
                        AREngine arEngine2 = this.mAREngine;
                        if (arEngine2 != null) {
                            arEngine2.mRenderer.onSurfaceChanged((GL10) null, this.w, this.f5629h);
                            arEngine2.updateSurfaceViewSize((float) this.w, (float) this.f5629h);
                            this.mAREngine.emitCanvasInitEvent();
                            this.mAREngine.emitCanvasChangedEvent(this.w, this.f5629h);
                        }
                        this.sizeChanged = false;
                    }
                    AREngine arEngine3 = this.mAREngine;
                    long currTime = System.currentTimeMillis();
                    long intervalTime = currTime - this.lastDrawFrameTime;
                    if (!arEngine3.mHasInitialled || ((float) intervalTime) < minFramesInterval()) {
                        boolean unused = arEngine3.mHasInitialled = true;
                    } else {
                        this.lastDrawFrameTime = System.currentTimeMillis();
                        if (!this.isFirstDraw && intervalTime > 32) {
                            long j2 = this.totalJankTime + (intervalTime - 32);
                            this.totalJankTime = j2;
                            arEngine3.updateJankRate(j2, System.currentTimeMillis() - this.firstDrawTime);
                            if (intervalTime <= 48) {
                                this.smallJank++;
                            } else {
                                this.bigJank++;
                            }
                        }
                        arEngine3.mRenderer.onDrawFrame((GL10) null);
                        calculateFrameRate();
                        if (currTime - this.lastUpdateTime > 33) {
                            arEngine3.mArBridge.notifyFrameUpdated();
                            this.lastUpdateTime = currTime;
                        }
                        if (this.isResumeFromPaused) {
                            this.mAREngine.mArBridge.smallGameOnResume();
                            this.isResumeFromPaused = false;
                        }
                        boolean shouldSwapBuffer = arEngine3.mArBridge.shouldSwapBuffer();
                        if (shouldSwapBuffer) {
                            int swapError = this.mEglHelper.swap();
                            this.totalFrame++;
                            switch (swapError) {
                                case MessageConstant.CommandId.COMMAND_BASE:
                                    break;
                                case Statistics.kTypeWhiteScreen:
                                    if (AREngine.LOG_SURFACE) {
                                        MarioLog.d(AREngine.TAG, "egl context lost tid=" + getId());
                                    }
                                    int i2 = this.errorFrame + 1;
                                    this.errorFrame = i2;
                                    this.mAREngine.updateEGLErrorRate(i2, this.totalFrame);
                                    this.lostEglContext = true;
                                    break;
                                default:
                                    MarioLog.d(AREngine.TAG, "swap error");
                                    EglHelper.logEglErrorAsWarning(AREngine.TAG, "eglSwapBuffers", swapError);
                                    int i3 = this.errorFrame + 1;
                                    this.errorFrame = i3;
                                    this.mAREngine.updateEGLErrorRate(i3, this.totalFrame);
                                    this.mSurfaceIsBad = true;
                                    break;
                            }
                            if (this.isFirstDraw) {
                                this.isFirstDraw = false;
                                this.firstDrawTime = this.lastDrawFrameTime;
                                this.mAREngine.getPerformanceJsonBean().put("First_paint_time");
                            }
                        }
                        if (this.shouldCheckSetCpu != 0) {
                            boolean hasSetCpu = false;
                            if (RNABTestUtil.enableCpuAffinity()) {
                                hasSetCpu = this.mAREngine.mArBridge.setCpuAffinity();
                            }
                            this.mAREngine.getPerformanceJsonBean().put("Set_cpu_affinity", Boolean.toString(hasSetCpu));
                            this.shouldCheckSetCpu = false;
                        }
                        this.lastFinishDrawFrameTime = System.currentTimeMillis();
                        boolean normalSwapBuffer = !this.mAREngine.mArBridge.isRenderCallbackQueueEmpty() && shouldSwapBuffer;
                        if (arEngine3.mArBridge.getStuckScreenHandler() instanceof RenderStuckScreenHandler) {
                            ((RenderStuckScreenHandler) arEngine3.mArBridge.getStuckScreenHandler()).setHasSwapBuffer(normalSwapBuffer, this.lastFinishDrawFrameTime);
                        }
                    }
                    if (this.wantRenderNotification) {
                        this.doRenderNotification = true;
                        this.wantRenderNotification = false;
                        return;
                    }
                    return;
                }
            }
        }

        private void calculateFrameRate() {
            this.lastCalculateFrameCount++;
            if (this.lastCalculateFrameRateTime != 0) {
                float renderFrameIntervalTime = ((float) (System.currentTimeMillis() - this.lastCalculateFrameRateTime)) / 1000.0f;
                if (renderFrameIntervalTime > 1.0f) {
                    int i2 = this.mPaintSecond + 1;
                    this.mPaintSecond = i2;
                    int i3 = this.lastCalculateFrameCount;
                    int fps = (int) (((float) i3) / renderFrameIntervalTime);
                    if (i2 > 10) {
                        this.allOnScreenFrameCount += i3;
                    }
                    this.mAREngine.updateFPS(fps);
                    this.lastCalculateFrameCount = 0;
                    this.lastCalculateFrameRateTime = System.currentTimeMillis();
                    if (this.mPaintSecond > 40 && !this.mUpdateFlag) {
                        this.mUpdateFlag = true;
                        this.renderSmooth = (((double) this.allOnScreenFrameCount) / 30.0d) / ((double) this.targetFPS);
                        AREngine aREngine = this.mAREngine;
                        if (aREngine != null && aREngine.getPerformanceJsonBean() != null && this.mAREngine.getArBridge() != null) {
                            this.mAREngine.getPerformanceJsonBean().put("jank_rate", Double.toString(this.mAREngine.getJankRate()));
                            this.mAREngine.getPerformanceJsonBean().put("EGL_error_rate", Double.toString(this.mAREngine.getEGLErrorRate()));
                            this.mAREngine.getPerformanceJsonBean().put(FpsConstants.REPORT_FPS, Integer.toString(this.mAREngine.getFPS()));
                            this.mAREngine.getPerformanceJsonBean().put("small_jank", Integer.toString(this.smallJank));
                            this.mAREngine.getPerformanceJsonBean().put("big_jank", Integer.toString(this.bigJank));
                            this.mAREngine.getPerformanceJsonBean().put("render_smooth", Double.toString(this.renderSmooth));
                            this.mAREngine.getArBridge().doUBCUploadTask();
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            this.lastCalculateFrameRateTime = System.currentTimeMillis();
        }

        public boolean ableToDraw() {
            return this.mHaveEglContext && this.mHaveEglSurface && readyToDraw();
        }

        private boolean readyToDraw() {
            return !this.mPaused && this.mHasSurface && !this.mSurfaceIsBad && this.mWidth > 0 && this.mHeight > 0 && (this.mRequestRender || this.mRenderMode == 1);
        }

        public void setRenderMode(int renderMode) {
            if (renderMode < 0 || renderMode > 1) {
                throw new IllegalArgumentException("renderMode");
            }
            synchronized (this) {
                this.mRenderMode = renderMode;
            }
        }

        public int getRenderMode() {
            int i2;
            synchronized (this) {
                i2 = this.mRenderMode;
            }
            return i2;
        }

        public void requestRender() {
            synchronized (this) {
                this.mRequestRender = true;
            }
        }

        public void requestRenderAndWait() {
            synchronized (this) {
                if (Thread.currentThread().getId() != this.mAREngine.mCurrentGLThreadID) {
                    this.mWantRenderNotification = true;
                    this.mRequestRender = true;
                    this.mRenderComplete = false;
                }
            }
        }

        public void surfaceCreated() {
            synchronized (this) {
                this.mHasSurface = true;
                this.mFinishedCreatingEglSurface = false;
            }
        }

        public void surfaceDestroyed() {
            synchronized (this) {
                this.mHasSurface = false;
            }
        }

        public void onPause() {
            synchronized (this) {
                if (AREngine.LOG_PAUSE_RESUME) {
                    MarioLog.d(AREngine.TAG, "onPause tid=" + getId());
                }
                this.mRequestPaused = true;
                AREngine aREngine = this.mAREngine;
                if (aREngine != null && (aREngine.mArBridge.getStuckScreenHandler() instanceof RenderStuckScreenHandler)) {
                    ((RenderStuckScreenHandler) this.mAREngine.mArBridge.getStuckScreenHandler()).handleStuckScreen();
                }
            }
        }

        public void onResume() {
            synchronized (this) {
                if (AREngine.LOG_PAUSE_RESUME) {
                    MarioLog.d(AREngine.TAG, "onResume tid=" + getId());
                }
                this.mRequestPaused = false;
                this.mRequestRender = true;
                this.mRenderComplete = false;
            }
        }

        public void onWindowResize(int w2, int h2) {
            synchronized (this) {
                this.mWidth = w2;
                this.mHeight = h2;
                this.mSizeChanged = true;
                this.mRequestRender = true;
                this.mRenderComplete = false;
            }
        }

        public void requestExitAndWait() {
            synchronized (this) {
                this.mShouldExit = true;
            }
        }

        public void requestReleaseEglContextLocked() {
            this.mShouldReleaseEglContext = true;
        }

        public void runOnGLThread(Runnable r) {
            queueEvent(r, false);
        }

        public void queueEvent(Runnable r) {
            queueEvent(r, true);
        }

        private void queueEvent(Runnable r, boolean eventQueue) {
            if (r == null) {
                throw new IllegalArgumentException("r must not be null");
            } else if (!this.mShouldExit && !this.mExited) {
                synchronized (this) {
                    if (!eventQueue) {
                        if (!ableToDraw()) {
                            this.mDirectRunEventQueue.add(r);
                        }
                    }
                    this.mEventQueue.add(r);
                }
            }
        }

        public void queueDelayedEvent(Runnable r, long delayMillis) {
            if (r == null) {
                throw new IllegalArgumentException("r must not be null");
            } else if (!this.mShouldExit && !this.mExited) {
                synchronized (this) {
                    TreeSet<TimedRunnable> treeSet = this.mDelayedEventQueue;
                    long j2 = 0;
                    if (delayMillis > 0) {
                        j2 = delayMillis;
                    }
                    treeSet.add(new TimedRunnable(r, j2));
                }
            }
        }

        public void clearOldEvents() {
            synchronized (this) {
                if (AREngine.DEBUG) {
                    MarioLog.d(AREngine.TAG, "[Test] EventQueueSize = " + this.mEventQueue.size() + ",DirectRunEventQueueSize: " + this.mDirectRunEventQueue.size() + ", DelayedEventQueueSize: " + this.mDelayedEventQueue.size());
                }
                this.mEventQueue.clear();
                this.mDirectRunEventQueue.clear();
                this.mDelayedEventQueue.clear();
            }
        }

        private Runnable dequeueEvent() {
            synchronized (this) {
                if (this.mDelayedEventQueue.isEmpty() || !this.mDelayedEventQueue.first().isTimeout()) {
                    Runnable pollFirst = this.mEventQueue.pollFirst();
                    return pollFirst;
                }
                Runnable pollFirst2 = this.mDelayedEventQueue.pollFirst();
                return pollFirst2;
            }
        }
    }

    public static class TimedRunnable implements Runnable, Comparable<TimedRunnable> {
        private final Runnable mRunnale;
        private final long mTimestamp;

        TimedRunnable(Runnable r, long delayMillis) {
            this.mRunnale = r;
            this.mTimestamp = System.currentTimeMillis() + delayMillis;
        }

        public void run() {
            this.mRunnale.run();
        }

        public int compareTo(TimedRunnable tr) {
            return (int) (this.mTimestamp - tr.mTimestamp);
        }

        public boolean isTimeout() {
            return System.currentTimeMillis() >= this.mTimestamp;
        }
    }

    private static class EglHelper {
        private AREngine mAREngine;
        EGLConfig mEglConfig;
        EGLContext mEglContext;
        EGLDisplay mEglDisplay;
        EGLSurface mEglSurface;

        public EglHelper(AREngine arEngine) {
            this.mAREngine = arEngine;
        }

        public void reset() {
            this.mAREngine = null;
        }

        public void start() {
            MarioLog.d(AREngine.TAG, "EglHelper.start");
            this.mAREngine.getPerformanceJsonBean().put("init_EGL_Ctx_start");
            EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
            this.mEglDisplay = eglGetDisplay;
            if (eglGetDisplay != EGL14.EGL_NO_DISPLAY) {
                int[] version = new int[2];
                if (EGL14.eglInitialize(this.mEglDisplay, version, 0, version, 1)) {
                    AREngine aREngine = this.mAREngine;
                    EGLConfig configImpl = getConfigImpl(0, 0, false);
                    this.mEglConfig = configImpl;
                    this.mEglContext = EGL14.eglCreateContext(this.mEglDisplay, configImpl, EGL14.EGL_NO_CONTEXT, new int[]{12440, 2, 12344}, 0);
                    long unused = this.mAREngine.mCurrentGLThreadID = Thread.currentThread().getId();
                    MarioLog.d(AREngine.TAG, "mCurrentGLThreadID " + this.mAREngine.mCurrentGLThreadID);
                    EGLContext eGLContext = this.mEglContext;
                    if (eGLContext == null || eGLContext == EGL14.EGL_NO_CONTEXT) {
                        this.mEglContext = null;
                        throwEglException("createContext");
                    }
                    this.mAREngine.getPerformanceJsonBean().put("init_EGL_Ctx_end");
                    this.mEglSurface = null;
                    return;
                }
                this.mEglDisplay = null;
                throw new RuntimeException("unable to initialize EGL14");
            }
            throw new RuntimeException("unable to get EGL14 display");
        }

        private EGLConfig getConfigImpl(int flags, int version, boolean withDepth) {
            int depthSize = 0;
            if (withDepth) {
                depthSize = 16;
            }
            EGLConfig[] configs = new EGLConfig[1];
            if (!EGL14.eglChooseConfig(this.mEglDisplay, new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, depthSize, 12326, 0, 12352, 4, 12344, 0, 12344}, 0, configs, 0, configs.length, new int[1], 0)) {
                MarioLog.d(AREngine.TAG, "unable to find RGB8888 / " + version + " EGLConfig");
                return null;
            }
            int i2 = version;
            return configs[0];
        }

        public boolean createSurface() {
            MarioLog.d(AREngine.TAG, "EglHelper.createSurface");
            this.mAREngine.getPerformanceJsonBean().put("create_EGL_surface_start");
            if (this.mEglDisplay == null) {
                throw new RuntimeException("eglDisplay not initialized");
            } else if (this.mEglConfig != null) {
                destroySurface();
                Object nativeWindow = this.mAREngine.mSurfaceHolder;
                if (nativeWindow == null) {
                    nativeWindow = this.mAREngine.mSurface;
                }
                if (nativeWindow != null) {
                    this.mEglSurface = EGL14.eglCreateWindowSurface(this.mEglDisplay, this.mEglConfig, nativeWindow, new int[]{12344}, 0);
                } else {
                    this.mEglSurface = null;
                }
                EGLSurface eGLSurface = this.mEglSurface;
                if (eGLSurface == null || eGLSurface == EGL14.EGL_NO_SURFACE) {
                    if (EGL14.eglGetError() == 12299) {
                        MarioLog.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                    }
                    this.mAREngine.getPerformanceJsonBean().put("create_EGL_surface_error_end");
                    return false;
                }
                EGLDisplay eGLDisplay = this.mEglDisplay;
                EGLSurface eGLSurface2 = this.mEglSurface;
                boolean result = EGL14.eglMakeCurrent(eGLDisplay, eGLSurface2, eGLSurface2, this.mEglContext);
                this.mAREngine.getPerformanceJsonBean().put("create_EGL_surface_success_end");
                return result;
            } else {
                throw new RuntimeException("mEglConfig not initialized");
            }
        }

        public int swap() {
            if (EGL14.eglSwapBuffers(this.mEglDisplay, this.mEglSurface)) {
                return MessageConstant.CommandId.COMMAND_BASE;
            }
            MarioLog.d(AREngine.TAG, "eglSwapBuffers error");
            return EGL14.eglGetError();
        }

        public void destroySurface() {
            EGLSurface eGLSurface = this.mEglSurface;
            if (eGLSurface != null && eGLSurface != EGL14.EGL_NO_SURFACE) {
                EGL14.eglMakeCurrent(this.mEglDisplay, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT);
                EGL14.eglDestroySurface(this.mEglDisplay, this.mEglSurface);
                this.mEglSurface = null;
            }
        }

        public void finish() {
            EGLContext eGLContext = this.mEglContext;
            if (eGLContext != null) {
                EGL14.eglDestroyContext(this.mEglDisplay, eGLContext);
                this.mEglContext = null;
            }
            EGLDisplay eGLDisplay = this.mEglDisplay;
            if (eGLDisplay != null) {
                EGL14.eglTerminate(eGLDisplay);
                this.mEglDisplay = null;
            }
            long unused = this.mAREngine.mCurrentGLThreadID = -1;
        }

        private void throwEglException(String function) {
            throwEglException(function, EGL14.eglGetError());
        }

        public static void throwEglException(String function, int error) {
            throw new RuntimeException(formatEglError(function, error));
        }

        public static void logEglErrorAsWarning(String tag, String function, int error) {
            MarioLog.d(AREngine.TAG, formatEglError(function, error));
        }

        public static String formatEglError(String function, int error) {
            return function + " failed: " + error;
        }
    }

    public boolean isDestroyed() {
        return this.mArBridge.isDestroyed();
    }
}
