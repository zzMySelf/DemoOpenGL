package com.yy.videoplayer.view;

import android.opengl.GLDebugHelper;
import android.util.Log;
import android.view.Surface;
import com.baidu.webkit.internal.monitor.MonitorType;
import com.heytap.mcssdk.constant.MessageConstant;
import com.yy.videoplayer.Constant;
import com.yy.videoplayer.utils.YMFLog;
import java.io.Writer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;
import javax.microedition.khronos.opengles.GL10;

public class GlSurfaceRender {
    public static final int DEBUG_CHECK_GL_ERROR = 1;
    public static final int DEBUG_LOG_GL_CALLS = 2;
    private static final boolean LOG_ATTACH_DETACH = false;
    private static final boolean LOG_EGL = true;
    private static final boolean LOG_PAUSE_RESUME = false;
    private static final boolean LOG_RENDERER = true;
    private static final boolean LOG_RENDERER_DRAW_FRAME = false;
    private static final boolean LOG_SURFACE = true;
    private static final boolean LOG_THREADS = false;
    public static final int RENDERMODE_CONTINUOUSLY = 1;
    public static final int RENDERMODE_WHEN_DIRTY = 0;
    private static final String TAG = "GlSurfaceRender";
    /* access modifiers changed from: private */
    public static final GLThreadManager sGLThreadManager = new GLThreadManager();
    /* access modifiers changed from: private */
    public int mDebugFlags;
    private boolean mDetached;
    /* access modifiers changed from: private */
    public EGLConfigChooser mEGLConfigChooser;
    /* access modifiers changed from: private */
    public int mEGLContextClientVersion;
    /* access modifiers changed from: private */
    public EGLContextFactory mEGLContextFactory;
    /* access modifiers changed from: private */
    public EGLWindowSurfaceFactory mEGLWindowSurfaceFactory;
    private GLThread mGLThread;
    /* access modifiers changed from: private */
    public GLWrapper mGLWrapper;
    /* access modifiers changed from: private */
    public boolean mPreserveEGLContextOnPause;
    /* access modifiers changed from: private */
    public Renderer mRenderer;
    private Surface mSurface;
    private final WeakReference<GlSurfaceRender> mThisWeakRef = new WeakReference<>(this);

    public interface EGLConfigChooser {
        EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay);
    }

    public interface EGLContextFactory {
        EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig);

        void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext);
    }

    public interface EGLWindowSurfaceFactory {
        EGLSurface createWindowSurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj);

        void destroySurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface);
    }

    public interface GLWrapper {
        GL wrap(GL gl);
    }

    public interface Renderer {
        void onDrawFrame(GL10 gl10);

        void onSurfaceChanged(GL10 gl10, int i2, int i3);

        void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig);
    }

    public GlSurfaceRender() {
        init();
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        try {
            GLThread gLThread = this.mGLThread;
            if (gLThread != null) {
                gLThread.requestExitAndWait();
            }
        } finally {
            super.finalize();
        }
    }

    private void init() {
    }

    public void setGLWrapper(GLWrapper glWrapper) {
        this.mGLWrapper = glWrapper;
    }

    public void setDebugFlags(int debugFlags) {
        this.mDebugFlags = debugFlags;
    }

    public int getDebugFlags() {
        return this.mDebugFlags;
    }

    public void setPreserveEGLContextOnPause(boolean preserveOnPause) {
        this.mPreserveEGLContextOnPause = preserveOnPause;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.mPreserveEGLContextOnPause;
    }

    public void setRenderer(Renderer renderer) {
        checkRenderThreadState();
        if (this.mEGLConfigChooser == null) {
            this.mEGLConfigChooser = new SimpleEGLConfigChooser(true);
        }
        if (this.mEGLContextFactory == null) {
            this.mEGLContextFactory = new DefaultContextFactory();
        }
        if (this.mEGLWindowSurfaceFactory == null) {
            this.mEGLWindowSurfaceFactory = new DefaultWindowSurfaceFactory();
        }
        this.mRenderer = renderer;
        GLThread gLThread = new GLThread(this.mThisWeakRef);
        this.mGLThread = gLThread;
        gLThread.start();
    }

    public void setEGLContextFactory(EGLContextFactory factory) {
        checkRenderThreadState();
        this.mEGLContextFactory = factory;
    }

    public void setEGLWindowSurfaceFactory(EGLWindowSurfaceFactory factory) {
        checkRenderThreadState();
        this.mEGLWindowSurfaceFactory = factory;
    }

    public void setEGLConfigChooser(EGLConfigChooser configChooser) {
        checkRenderThreadState();
        this.mEGLConfigChooser = configChooser;
    }

    public void setEGLConfigChooser(boolean needDepth) {
        setEGLConfigChooser((EGLConfigChooser) new SimpleEGLConfigChooser(needDepth));
    }

    public void setEGLConfigChooser(int redSize, int greenSize, int blueSize, int alphaSize, int depthSize, int stencilSize) {
        setEGLConfigChooser((EGLConfigChooser) new ComponentSizeChooser(redSize, greenSize, blueSize, alphaSize, depthSize, stencilSize));
    }

    public void setEGLContextClientVersion(int version) {
        checkRenderThreadState();
        this.mEGLContextClientVersion = version;
    }

    public void setRenderMode(int renderMode) {
        this.mGLThread.setRenderMode(renderMode);
    }

    public int getRenderMode() {
        return this.mGLThread.getRenderMode();
    }

    public void requestRender() {
        this.mGLThread.requestRender();
    }

    public void requestExitAndWait() {
        GLThread gLThread = this.mGLThread;
        if (gLThread != null) {
            gLThread.requestExitAndWait();
        }
    }

    public void surfaceCreated(Surface surface) {
        YMFLog.info(TAG, Constant.MEDIACODE_PLAYVIEW, "surfaceCreated:" + surface);
        this.mSurface = surface;
        this.mGLThread.surfaceCreated();
    }

    public void surfaceDestroyed(Surface surface) {
        this.mGLThread.surfaceDestroyed();
        this.mSurface = null;
    }

    public void surfaceChanged(Surface surface, int format, int w, int h2) {
        this.mSurface = surface;
        this.mGLThread.onWindowResize(w, h2);
    }

    public Surface getSurface() {
        return this.mSurface;
    }

    public void surfaceRedrawNeeded(Surface surface) {
        GLThread gLThread = this.mGLThread;
        if (gLThread != null) {
            gLThread.requestRenderAndWait();
        }
    }

    public void queueEvent(Runnable r) {
        this.mGLThread.queueEvent(r);
    }

    private class DefaultContextFactory implements EGLContextFactory {
        private int EGL_CONTEXT_CLIENT_VERSION;

        private DefaultContextFactory() {
            this.EGL_CONTEXT_CLIENT_VERSION = 12440;
        }

        public EGLContext createContext(EGL10 egl, EGLDisplay display, EGLConfig config) {
            return egl.eglCreateContext(display, config, EGL10.EGL_NO_CONTEXT, GlSurfaceRender.this.mEGLContextClientVersion != 0 ? new int[]{this.EGL_CONTEXT_CLIENT_VERSION, GlSurfaceRender.this.mEGLContextClientVersion, 12344} : null);
        }

        public void destroyContext(EGL10 egl, EGLDisplay display, EGLContext context) {
            if (!egl.eglDestroyContext(display, context)) {
                YMFLog.info(this, "DefaultContextFactory", "display:" + display + " context: " + context);
                EglHelper.throwEglException("eglDestroyContex", egl.eglGetError());
            }
        }
    }

    private static class DefaultWindowSurfaceFactory implements EGLWindowSurfaceFactory {
        private DefaultWindowSurfaceFactory() {
        }

        public EGLSurface createWindowSurface(EGL10 egl, EGLDisplay display, EGLConfig config, Object nativeWindow) {
            try {
                return egl.eglCreateWindowSurface(display, config, nativeWindow, (int[]) null);
            } catch (IllegalArgumentException e2) {
                YMFLog.info(this, GlSurfaceRender.TAG, "eglCreateWindowSurface", e2);
                return null;
            }
        }

        public void destroySurface(EGL10 egl, EGLDisplay display, EGLSurface surface) {
            egl.eglDestroySurface(display, surface);
        }
    }

    private abstract class BaseConfigChooser implements EGLConfigChooser {
        protected int[] mConfigSpec;

        /* access modifiers changed from: package-private */
        public abstract EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        public BaseConfigChooser(int[] configSpec) {
            this.mConfigSpec = filterConfigSpec(configSpec);
        }

        public EGLConfig chooseConfig(EGL10 egl, EGLDisplay display) {
            int[] num_config = new int[1];
            if (egl.eglChooseConfig(display, this.mConfigSpec, (EGLConfig[]) null, 0, num_config)) {
                int numConfigs = num_config[0];
                if (numConfigs > 0) {
                    EGLConfig[] configs = new EGLConfig[numConfigs];
                    if (egl.eglChooseConfig(display, this.mConfigSpec, configs, numConfigs, num_config)) {
                        EGLConfig config = chooseConfig(egl, display, configs);
                        if (config != null) {
                            return config;
                        }
                        throw new IllegalArgumentException("No config chosen");
                    }
                    throw new IllegalArgumentException("eglChooseConfig#2 failed");
                }
                throw new IllegalArgumentException("No configs match configSpec");
            }
            throw new IllegalArgumentException("eglChooseConfig failed");
        }

        private int[] filterConfigSpec(int[] configSpec) {
            if (GlSurfaceRender.this.mEGLContextClientVersion != 2 && GlSurfaceRender.this.mEGLContextClientVersion != 3) {
                return configSpec;
            }
            int len = configSpec.length;
            int[] newConfigSpec = new int[(len + 2)];
            System.arraycopy(configSpec, 0, newConfigSpec, 0, len - 1);
            newConfigSpec[len - 1] = 12352;
            if (GlSurfaceRender.this.mEGLContextClientVersion == 2) {
                newConfigSpec[len] = 4;
            } else {
                newConfigSpec[len] = 64;
            }
            newConfigSpec[len + 1] = 12344;
            return newConfigSpec;
        }
    }

    private class ComponentSizeChooser extends BaseConfigChooser {
        protected int mAlphaSize;
        protected int mBlueSize;
        protected int mDepthSize;
        protected int mGreenSize;
        protected int mRedSize;
        protected int mStencilSize;
        private int[] mValue = new int[1];

        public ComponentSizeChooser(int redSize, int greenSize, int blueSize, int alphaSize, int depthSize, int stencilSize) {
            super(new int[]{12324, redSize, 12323, greenSize, 12322, blueSize, 12321, alphaSize, 12325, depthSize, 12326, stencilSize, 12344});
            this.mRedSize = redSize;
            this.mGreenSize = greenSize;
            this.mBlueSize = blueSize;
            this.mAlphaSize = alphaSize;
            this.mDepthSize = depthSize;
            this.mStencilSize = stencilSize;
        }

        public EGLConfig chooseConfig(EGL10 egl, EGLDisplay display, EGLConfig[] configs) {
            for (EGLConfig config : configs) {
                EGL10 egl10 = egl;
                EGLDisplay eGLDisplay = display;
                EGLConfig eGLConfig = config;
                int d2 = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12325, 0);
                int s = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12326, 0);
                if (d2 >= this.mDepthSize && s >= this.mStencilSize) {
                    EGL10 egl102 = egl;
                    EGLDisplay eGLDisplay2 = display;
                    EGLConfig eGLConfig2 = config;
                    int r = findConfigAttrib(egl102, eGLDisplay2, eGLConfig2, MonitorType.MONITOR_TYPE_DOWNLOAD_WEBKIT, 0);
                    int g2 = findConfigAttrib(egl102, eGLDisplay2, eGLConfig2, MonitorType.MONITOR_TYPE_INIT_WEBKIT, 0);
                    int b2 = findConfigAttrib(egl102, eGLDisplay2, eGLConfig2, 12322, 0);
                    int a2 = findConfigAttrib(egl102, eGLDisplay2, eGLConfig2, 12321, 0);
                    if (r == this.mRedSize && g2 == this.mGreenSize && b2 == this.mBlueSize && a2 == this.mAlphaSize) {
                        return config;
                    }
                }
            }
            return null;
        }

        private int findConfigAttrib(EGL10 egl, EGLDisplay display, EGLConfig config, int attribute, int defaultValue) {
            if (egl.eglGetConfigAttrib(display, config, attribute, this.mValue)) {
                return this.mValue[0];
            }
            return defaultValue;
        }
    }

    private class SimpleEGLConfigChooser extends ComponentSizeChooser {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SimpleEGLConfigChooser(boolean withDepthBuffer) {
            super(8, 8, 8, 0, withDepthBuffer ? 16 : 0, 0);
        }
    }

    private static class EglHelper {
        EGL10 mEgl;
        EGLConfig mEglConfig;
        EGLContext mEglContext;
        EGLDisplay mEglDisplay;
        EGLSurface mEglSurface;
        private WeakReference<GlSurfaceRender> mGlSurfaceRenderWeakRef;

        public EglHelper(WeakReference<GlSurfaceRender> GlSurfaceRenderWeakRef) {
            this.mGlSurfaceRenderWeakRef = GlSurfaceRenderWeakRef;
        }

        public void start() {
            YMFLog.info(this, "EglHelper", "start() tid=" + Thread.currentThread().getId());
            EGL10 egl10 = (EGL10) EGLContext.getEGL();
            this.mEgl = egl10;
            EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            this.mEglDisplay = eglGetDisplay;
            if (eglGetDisplay != EGL10.EGL_NO_DISPLAY) {
                if (this.mEgl.eglInitialize(this.mEglDisplay, new int[2])) {
                    GlSurfaceRender render = (GlSurfaceRender) this.mGlSurfaceRenderWeakRef.get();
                    if (render == null) {
                        this.mEglConfig = null;
                        this.mEglContext = null;
                    } else {
                        this.mEglConfig = render.mEGLConfigChooser.chooseConfig(this.mEgl, this.mEglDisplay);
                        this.mEglContext = render.mEGLContextFactory.createContext(this.mEgl, this.mEglDisplay, this.mEglConfig);
                    }
                    EGLContext eGLContext = this.mEglContext;
                    if (eGLContext == null || eGLContext == EGL10.EGL_NO_CONTEXT) {
                        this.mEglContext = null;
                        throwEglException("createContext");
                    }
                    YMFLog.info(this, "EglHelper", "createContext " + this.mEglContext + " tid=" + Thread.currentThread().getId());
                    this.mEglSurface = null;
                    return;
                }
                throw new RuntimeException("eglInitialize failed");
            }
            throw new RuntimeException("eglGetDisplay failed");
        }

        public boolean createSurface() {
            YMFLog.info(this, "EglHelper", "createSurface()  tid=" + Thread.currentThread().getId());
            if (this.mEgl == null) {
                throw new RuntimeException("egl not initialized");
            } else if (this.mEglDisplay == null) {
                throw new RuntimeException("eglDisplay not initialized");
            } else if (this.mEglConfig != null) {
                destroySurfaceImp();
                GlSurfaceRender render = (GlSurfaceRender) this.mGlSurfaceRenderWeakRef.get();
                if (render != null) {
                    this.mEglSurface = render.mEGLWindowSurfaceFactory.createWindowSurface(this.mEgl, this.mEglDisplay, this.mEglConfig, render.getSurface());
                } else {
                    this.mEglSurface = null;
                }
                EGLSurface eGLSurface = this.mEglSurface;
                if (eGLSurface == null || eGLSurface == EGL10.EGL_NO_SURFACE) {
                    if (this.mEgl.eglGetError() == 12299) {
                        YMFLog.info(this, "EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                    }
                    return false;
                }
                EGL10 egl10 = this.mEgl;
                EGLDisplay eGLDisplay = this.mEglDisplay;
                EGLSurface eGLSurface2 = this.mEglSurface;
                if (egl10.eglMakeCurrent(eGLDisplay, eGLSurface2, eGLSurface2, this.mEglContext)) {
                    return true;
                }
                logEglErrorAsWarning("EGLHelper", "eglMakeCurrent", this.mEgl.eglGetError());
                return false;
            } else {
                throw new RuntimeException("mEglConfig not initialized");
            }
        }

        /* access modifiers changed from: package-private */
        public GL createGL() {
            GL gl = this.mEglContext.getGL();
            GlSurfaceRender render = (GlSurfaceRender) this.mGlSurfaceRenderWeakRef.get();
            if (render == null) {
                return gl;
            }
            if (render.mGLWrapper != null) {
                gl = render.mGLWrapper.wrap(gl);
            }
            if ((render.mDebugFlags & 3) == 0) {
                return gl;
            }
            int configFlags = 0;
            Writer log = null;
            if ((render.mDebugFlags & 1) != 0) {
                configFlags = 0 | 1;
            }
            if ((render.mDebugFlags & 2) != 0) {
                log = new LogWriter();
            }
            return GLDebugHelper.wrap(gl, configFlags, log);
        }

        public int swap() {
            if (!this.mEgl.eglSwapBuffers(this.mEglDisplay, this.mEglSurface)) {
                return this.mEgl.eglGetError();
            }
            return MessageConstant.CommandId.COMMAND_BASE;
        }

        public void destroySurface() {
            YMFLog.info(this, "EglHelper", "destroySurface()  tid=" + Thread.currentThread().getId());
            destroySurfaceImp();
        }

        private void destroySurfaceImp() {
            EGLSurface eGLSurface = this.mEglSurface;
            if (eGLSurface != null && eGLSurface != EGL10.EGL_NO_SURFACE) {
                this.mEgl.eglMakeCurrent(this.mEglDisplay, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
                GlSurfaceRender render = (GlSurfaceRender) this.mGlSurfaceRenderWeakRef.get();
                if (render != null) {
                    render.mEGLWindowSurfaceFactory.destroySurface(this.mEgl, this.mEglDisplay, this.mEglSurface);
                }
                this.mEglSurface = null;
            }
        }

        public void finish() {
            YMFLog.info(this, "EglHelper", "finish() tid=" + Thread.currentThread().getId());
            if (this.mEglContext != null) {
                GlSurfaceRender render = (GlSurfaceRender) this.mGlSurfaceRenderWeakRef.get();
                if (render != null) {
                    render.mEGLContextFactory.destroyContext(this.mEgl, this.mEglDisplay, this.mEglContext);
                }
                this.mEglContext = null;
            }
            EGLDisplay eGLDisplay = this.mEglDisplay;
            if (eGLDisplay != null) {
                this.mEgl.eglTerminate(eGLDisplay);
                this.mEglDisplay = null;
            }
        }

        private void throwEglException(String function) {
            throwEglException(function, this.mEgl.eglGetError());
        }

        public static void throwEglException(String function, int error) {
            throw new RuntimeException(formatEglError(function, error));
        }

        public static void logEglErrorAsWarning(String tag, String function, int error) {
            YMFLog.info(GlSurfaceRender.TAG, tag, formatEglError(function, error));
        }

        public static String formatEglError(String function, int error) {
            return function + " failed: ";
        }
    }

    static class GLThread extends Thread {
        private EglHelper mEglHelper;
        private ArrayList<Runnable> mEventQueue = new ArrayList<>();
        /* access modifiers changed from: private */
        public boolean mExited;
        private boolean mFinishedCreatingEglSurface;
        private WeakReference<GlSurfaceRender> mGlSurfaceRenderWeakRef;
        private boolean mHasSurface;
        private boolean mHaveEglContext;
        private boolean mHaveEglSurface;
        private int mHeight = 0;
        private boolean mPaused;
        private boolean mRenderComplete;
        private int mRenderMode = 1;
        private boolean mRequestPaused;
        private boolean mRequestRender = true;
        private boolean mShouldExit;
        private boolean mShouldReleaseEglContext;
        private boolean mSizeChanged = true;
        private boolean mSurfaceIsBad;
        private boolean mWaitingForSurface;
        private boolean mWantRenderNotification = false;
        private int mWidth = 0;

        GLThread(WeakReference<GlSurfaceRender> GlSurfaceRenderWeakRef) {
            this.mGlSurfaceRenderWeakRef = GlSurfaceRenderWeakRef;
        }

        public void run() {
            setName("yrtcVGlS " + getId());
            try {
                guardedRun();
            } catch (InterruptedException e2) {
            } catch (Throwable th2) {
                GlSurfaceRender.sGLThreadManager.threadExiting(this);
                throw th2;
            }
            GlSurfaceRender.sGLThreadManager.threadExiting(this);
        }

        private void stopEglSurfaceLocked() {
            if (this.mHaveEglSurface) {
                this.mHaveEglSurface = false;
                this.mEglHelper.destroySurface();
            }
        }

        private void stopEglContextLocked() {
            if (this.mHaveEglContext) {
                this.mEglHelper.finish();
                this.mHaveEglContext = false;
                GlSurfaceRender.sGLThreadManager.releaseEglContextLocked(this);
            }
        }

        /* Debug info: failed to restart local var, previous not found, register: 21 */
        /* JADX WARNING: Code restructure failed: missing block: B:143:0x0270, code lost:
            if (r13 == null) goto L_0x027a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:145:?, code lost:
            r13.run();
            r13 = null;
            r2 = r16;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:146:0x027a, code lost:
            if (r4 == false) goto L_0x02ba;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:147:0x027c, code lost:
            com.yy.videoplayer.utils.YMFLog.info(r1, "GLThread", "egl createSurface");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:148:0x0289, code lost:
            if (r1.mEglHelper.createSurface() == false) goto L_0x02a1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:149:0x028b, code lost:
            r2 = com.yy.videoplayer.view.GlSurfaceRender.access$800();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:150:0x028f, code lost:
            monitor-enter(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:153:?, code lost:
            r1.mFinishedCreatingEglSurface = true;
            com.yy.videoplayer.view.GlSurfaceRender.access$800().notifyAll();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:154:0x029a, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:155:0x029b, code lost:
            r4 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:160:0x02a1, code lost:
            r2 = com.yy.videoplayer.view.GlSurfaceRender.access$800();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:161:0x02a5, code lost:
            monitor-enter(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:164:?, code lost:
            r1.mFinishedCreatingEglSurface = true;
            r1.mSurfaceIsBad = true;
            com.yy.videoplayer.view.GlSurfaceRender.access$800().notifyAll();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:165:0x02b2, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:166:0x02b3, code lost:
            r2 = r16;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:171:0x02ba, code lost:
            if (r5 == false) goto L_0x02c6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:172:0x02bc, code lost:
            r2 = (javax.microedition.khronos.opengles.GL10) r1.mEglHelper.createGL();
            r5 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:173:0x02c6, code lost:
            r2 = r16;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:174:0x02c8, code lost:
            if (r3 == false) goto L_0x02e9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:175:0x02ca, code lost:
            com.yy.videoplayer.utils.YMFLog.info(r1, "GLThread", "onSurfaceCreated");
            r14 = (com.yy.videoplayer.view.GlSurfaceRender) r1.mGlSurfaceRenderWeakRef.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:176:0x02da, code lost:
            if (r14 == null) goto L_0x02e7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:177:0x02dc, code lost:
            com.yy.videoplayer.view.GlSurfaceRender.access$1000(r14).onSurfaceCreated(r2, r1.mEglHelper.mEglConfig);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:178:0x02e7, code lost:
            r3 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:179:0x02e9, code lost:
            if (r7 == false) goto L_0x0326;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:180:0x02eb, code lost:
            com.yy.videoplayer.utils.YMFLog.info(r1, "GLThread", "onSurfaceChanged(" + r11 + ", " + r12 + ")");
            r0 = (com.yy.videoplayer.view.GlSurfaceRender) r1.mGlSurfaceRenderWeakRef.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:181:0x031c, code lost:
            if (r0 == null) goto L_0x0325;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:182:0x031e, code lost:
            com.yy.videoplayer.view.GlSurfaceRender.access$1000(r0).onSurfaceChanged(r2, r11, r12);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:183:0x0325, code lost:
            r7 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:184:0x0326, code lost:
            r0 = (com.yy.videoplayer.view.GlSurfaceRender) r1.mGlSurfaceRenderWeakRef.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:185:0x032e, code lost:
            if (r0 == null) goto L_0x0337;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:186:0x0330, code lost:
            com.yy.videoplayer.view.GlSurfaceRender.access$1000(r0).onDrawFrame(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:187:0x0337, code lost:
            r14 = r1.mEglHelper.swap();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:188:0x033e, code lost:
            switch(r14) {
                case com.heytap.mcssdk.constant.MessageConstant.CommandId.COMMAND_BASE :int: goto L_0x036d;
                case com.baidu.webkit.internal.Statistics.kTypeWhiteScreen :int: goto L_0x0349;
                default: goto L_0x0341;
            };
         */
        /* JADX WARNING: Code restructure failed: missing block: B:189:0x0341, code lost:
            r16 = r2;
            r17 = r3;
            r15 = r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:190:0x0349, code lost:
            r16 = r2;
            r17 = r3;
            r15 = r4;
            com.yy.videoplayer.utils.YMFLog.info(r1, "GLThread", "egl context lost tid=" + getId());
            r6 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:191:0x036d, code lost:
            r16 = r2;
            r17 = r3;
            r15 = r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:192:0x0373, code lost:
            com.yy.videoplayer.view.GlSurfaceRender.EglHelper.logEglErrorAsWarning("GLThread", "eglSwapBuffers", r14);
            r2 = com.yy.videoplayer.view.GlSurfaceRender.access$800();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:193:0x037c, code lost:
            monitor-enter(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:196:?, code lost:
            r1.mSurfaceIsBad = true;
            com.yy.videoplayer.view.GlSurfaceRender.access$800().notifyAll();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:197:0x0387, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:198:0x0388, code lost:
            if (r8 == false) goto L_0x038e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:199:0x038a, code lost:
            r9 = true;
            r8 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:200:0x038e, code lost:
            r4 = r15;
            r2 = r16;
            r3 = r17;
         */
        /* JADX WARNING: Removed duplicated region for block: B:207:0x039d  */
        /* JADX WARNING: Removed duplicated region for block: B:210:0x03aa  */
        /* JADX WARNING: Removed duplicated region for block: B:236:0x0222 A[SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:82:0x0169 A[Catch:{ RuntimeException -> 0x01f8, all -> 0x0135, all -> 0x03bc }] */
        /* JADX WARNING: Removed duplicated region for block: B:90:0x01aa A[Catch:{ RuntimeException -> 0x01f8, all -> 0x0135, all -> 0x03bc }] */
        /* JADX WARNING: Removed duplicated region for block: B:93:0x01db A[Catch:{ RuntimeException -> 0x01f8, all -> 0x0135, all -> 0x03bc }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void guardedRun() throws java.lang.InterruptedException {
            /*
                r21 = this;
                r1 = r21
                com.yy.videoplayer.view.GlSurfaceRender$EglHelper r0 = new com.yy.videoplayer.view.GlSurfaceRender$EglHelper
                java.lang.ref.WeakReference<com.yy.videoplayer.view.GlSurfaceRender> r2 = r1.mGlSurfaceRenderWeakRef
                r0.<init>(r2)
                r1.mEglHelper = r0
                r0 = 0
                r1.mHaveEglContext = r0
                r1.mHaveEglSurface = r0
                r1.mWantRenderNotification = r0
                r2 = 0
                r3 = 0
                r4 = 0
                r5 = 0
                r6 = 0
                r7 = 0
                r8 = 0
                r9 = 0
                r10 = 0
                r11 = 0
                r12 = 0
                r13 = 0
            L_0x001e:
                com.yy.videoplayer.view.GlSurfaceRender$GLThreadManager r14 = com.yy.videoplayer.view.GlSurfaceRender.sGLThreadManager     // Catch:{ all -> 0x03d1 }
                monitor-enter(r14)     // Catch:{ all -> 0x03d1 }
            L_0x0023:
                boolean r15 = r1.mShouldExit     // Catch:{ all -> 0x03c4 }
                if (r15 == 0) goto L_0x003d
                monitor-exit(r14)     // Catch:{ all -> 0x0038 }
                com.yy.videoplayer.view.GlSurfaceRender$GLThreadManager r15 = com.yy.videoplayer.view.GlSurfaceRender.sGLThreadManager
                monitor-enter(r15)
                r21.stopEglSurfaceLocked()     // Catch:{ all -> 0x0035 }
                r21.stopEglContextLocked()     // Catch:{ all -> 0x0035 }
                monitor-exit(r15)     // Catch:{ all -> 0x0035 }
                return
            L_0x0035:
                r0 = move-exception
                monitor-exit(r15)     // Catch:{ all -> 0x0035 }
                throw r0
            L_0x0038:
                r0 = move-exception
                r16 = r2
                goto L_0x03cd
            L_0x003d:
                java.util.ArrayList<java.lang.Runnable> r15 = r1.mEventQueue     // Catch:{ all -> 0x03c4 }
                boolean r15 = r15.isEmpty()     // Catch:{ all -> 0x03c4 }
                if (r15 != 0) goto L_0x0055
                java.util.ArrayList<java.lang.Runnable> r15 = r1.mEventQueue     // Catch:{ all -> 0x0038 }
                r0 = 0
                java.lang.Object r15 = r15.remove(r0)     // Catch:{ all -> 0x0038 }
                java.lang.Runnable r15 = (java.lang.Runnable) r15     // Catch:{ all -> 0x0038 }
                r0 = r15
                r13 = r0
                r16 = r2
                r0 = 0
                goto L_0x026f
            L_0x0055:
                r0 = 0
                boolean r15 = r1.mPaused     // Catch:{ all -> 0x03c4 }
                r16 = r0
                boolean r0 = r1.mRequestPaused     // Catch:{ all -> 0x03c4 }
                if (r15 == r0) goto L_0x0069
                r15 = r0
                r1.mPaused = r0     // Catch:{ all -> 0x0038 }
                com.yy.videoplayer.view.GlSurfaceRender$GLThreadManager r0 = com.yy.videoplayer.view.GlSurfaceRender.sGLThreadManager     // Catch:{ all -> 0x0038 }
                r0.notifyAll()     // Catch:{ all -> 0x0038 }
                goto L_0x006b
            L_0x0069:
                r15 = r16
            L_0x006b:
                boolean r0 = r1.mShouldReleaseEglContext     // Catch:{ all -> 0x03c4 }
                if (r0 == 0) goto L_0x00b4
                java.lang.String r0 = "GLThread"
                r16 = r2
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a4 }
                r2.<init>()     // Catch:{ all -> 0x00a4 }
                r17 = r3
                java.lang.String r3 = "releasing EGL context because asked to tid="
                java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x009d }
                r18 = r4
                long r3 = r21.getId()     // Catch:{ all -> 0x00c5 }
                java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x00c5 }
                java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x00c5 }
                com.yy.videoplayer.utils.YMFLog.info(r1, r0, r2)     // Catch:{ all -> 0x00c5 }
                r21.stopEglSurfaceLocked()     // Catch:{ all -> 0x00c5 }
                r21.stopEglContextLocked()     // Catch:{ all -> 0x00c5 }
                r0 = 0
                r1.mShouldReleaseEglContext = r0     // Catch:{ all -> 0x00c5 }
                r10 = 1
                goto L_0x00ba
            L_0x009d:
                r0 = move-exception
                r18 = r4
                r3 = r17
                goto L_0x03cd
            L_0x00a4:
                r0 = move-exception
                r17 = r3
                r18 = r4
                goto L_0x03cd
            L_0x00ab:
                r0 = move-exception
                r16 = r2
                r17 = r3
                r18 = r4
                goto L_0x03cd
            L_0x00b4:
                r16 = r2
                r17 = r3
                r18 = r4
            L_0x00ba:
                if (r6 == 0) goto L_0x00cc
                r21.stopEglSurfaceLocked()     // Catch:{ all -> 0x00c5 }
                r21.stopEglContextLocked()     // Catch:{ all -> 0x00c5 }
                r0 = 0
                r6 = r0
                goto L_0x00cc
            L_0x00c5:
                r0 = move-exception
                r3 = r17
                r4 = r18
                goto L_0x03cd
            L_0x00cc:
                if (r15 == 0) goto L_0x00f2
                boolean r0 = r1.mHaveEglSurface     // Catch:{ all -> 0x00c5 }
                if (r0 == 0) goto L_0x00f2
                java.lang.String r0 = "GLThread"
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c5 }
                r2.<init>()     // Catch:{ all -> 0x00c5 }
                java.lang.String r3 = "releasing EGL surface because paused tid="
                java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x00c5 }
                long r3 = r21.getId()     // Catch:{ all -> 0x00c5 }
                java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x00c5 }
                java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x00c5 }
                com.yy.videoplayer.utils.YMFLog.info(r1, r0, r2)     // Catch:{ all -> 0x00c5 }
                r21.stopEglSurfaceLocked()     // Catch:{ all -> 0x00c5 }
            L_0x00f2:
                if (r15 == 0) goto L_0x013e
                boolean r0 = r1.mHaveEglContext     // Catch:{ all -> 0x0135 }
                if (r0 == 0) goto L_0x013e
                java.lang.ref.WeakReference<com.yy.videoplayer.view.GlSurfaceRender> r0 = r1.mGlSurfaceRenderWeakRef     // Catch:{ all -> 0x0135 }
                java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x0135 }
                com.yy.videoplayer.view.GlSurfaceRender r0 = (com.yy.videoplayer.view.GlSurfaceRender) r0     // Catch:{ all -> 0x0135 }
                if (r0 != 0) goto L_0x0104
                r2 = 0
                goto L_0x0108
            L_0x0104:
                boolean r2 = r0.mPreserveEGLContextOnPause     // Catch:{ all -> 0x0135 }
            L_0x0108:
                if (r2 != 0) goto L_0x0130
                r21.stopEglContextLocked()     // Catch:{ all -> 0x0135 }
                java.lang.String r3 = "GLThread"
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0135 }
                r4.<init>()     // Catch:{ all -> 0x0135 }
                r19 = r0
                java.lang.String r0 = "releasing EGL context because paused tid="
                java.lang.StringBuilder r0 = r4.append(r0)     // Catch:{ all -> 0x0135 }
                r20 = r5
                long r4 = r21.getId()     // Catch:{ all -> 0x03bc }
                java.lang.StringBuilder r0 = r0.append(r4)     // Catch:{ all -> 0x03bc }
                java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x03bc }
                com.yy.videoplayer.utils.YMFLog.info(r1, r3, r0)     // Catch:{ all -> 0x03bc }
                goto L_0x0140
            L_0x0130:
                r19 = r0
                r20 = r5
                goto L_0x0140
            L_0x0135:
                r0 = move-exception
                r20 = r5
                r3 = r17
                r4 = r18
                goto L_0x03cd
            L_0x013e:
                r20 = r5
            L_0x0140:
                boolean r0 = r1.mHasSurface     // Catch:{ all -> 0x03bc }
                if (r0 != 0) goto L_0x0179
                boolean r0 = r1.mWaitingForSurface     // Catch:{ all -> 0x03bc }
                if (r0 != 0) goto L_0x0179
                java.lang.String r0 = "GLThread"
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x03bc }
                r2.<init>()     // Catch:{ all -> 0x03bc }
                java.lang.String r3 = "noticed surfaceView surface lost tid="
                java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x03bc }
                long r3 = r21.getId()     // Catch:{ all -> 0x03bc }
                java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x03bc }
                java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x03bc }
                com.yy.videoplayer.utils.YMFLog.info(r1, r0, r2)     // Catch:{ all -> 0x03bc }
                boolean r0 = r1.mHaveEglSurface     // Catch:{ all -> 0x03bc }
                if (r0 == 0) goto L_0x016c
                r21.stopEglSurfaceLocked()     // Catch:{ all -> 0x03bc }
            L_0x016c:
                r0 = 1
                r1.mWaitingForSurface = r0     // Catch:{ all -> 0x03bc }
                r0 = 0
                r1.mSurfaceIsBad = r0     // Catch:{ all -> 0x03bc }
                com.yy.videoplayer.view.GlSurfaceRender$GLThreadManager r0 = com.yy.videoplayer.view.GlSurfaceRender.sGLThreadManager     // Catch:{ all -> 0x03bc }
                r0.notifyAll()     // Catch:{ all -> 0x03bc }
            L_0x0179:
                boolean r0 = r1.mHasSurface     // Catch:{ all -> 0x03bc }
                if (r0 == 0) goto L_0x01a8
                boolean r0 = r1.mWaitingForSurface     // Catch:{ all -> 0x03bc }
                if (r0 == 0) goto L_0x01a8
                java.lang.String r0 = "GLThread"
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x03bc }
                r2.<init>()     // Catch:{ all -> 0x03bc }
                java.lang.String r3 = "noticed surfaceView surface acquired tid="
                java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x03bc }
                long r3 = r21.getId()     // Catch:{ all -> 0x03bc }
                java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x03bc }
                java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x03bc }
                com.yy.videoplayer.utils.YMFLog.info(r1, r0, r2)     // Catch:{ all -> 0x03bc }
                r0 = 0
                r1.mWaitingForSurface = r0     // Catch:{ all -> 0x03bc }
                com.yy.videoplayer.view.GlSurfaceRender$GLThreadManager r0 = com.yy.videoplayer.view.GlSurfaceRender.sGLThreadManager     // Catch:{ all -> 0x03bc }
                r0.notifyAll()     // Catch:{ all -> 0x03bc }
            L_0x01a8:
                if (r9 == 0) goto L_0x01d5
                java.lang.String r0 = "GLThread"
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x03bc }
                r2.<init>()     // Catch:{ all -> 0x03bc }
                java.lang.String r3 = "sending render notification tid="
                java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x03bc }
                long r3 = r21.getId()     // Catch:{ all -> 0x03bc }
                java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x03bc }
                java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x03bc }
                com.yy.videoplayer.utils.YMFLog.info(r1, r0, r2)     // Catch:{ all -> 0x03bc }
                r0 = 0
                r1.mWantRenderNotification = r0     // Catch:{ all -> 0x03bc }
                r9 = 0
                r0 = 1
                r1.mRenderComplete = r0     // Catch:{ all -> 0x03bc }
                com.yy.videoplayer.view.GlSurfaceRender$GLThreadManager r0 = com.yy.videoplayer.view.GlSurfaceRender.sGLThreadManager     // Catch:{ all -> 0x03bc }
                r0.notifyAll()     // Catch:{ all -> 0x03bc }
            L_0x01d5:
                boolean r0 = r21.readyToDraw()     // Catch:{ all -> 0x03bc }
                if (r0 == 0) goto L_0x03aa
                boolean r0 = r1.mHaveEglContext     // Catch:{ all -> 0x03bc }
                if (r0 != 0) goto L_0x0202
                if (r10 == 0) goto L_0x01e6
                r0 = 0
                r10 = r0
                r3 = r17
                goto L_0x0204
            L_0x01e6:
                com.yy.videoplayer.view.GlSurfaceRender$EglHelper r0 = r1.mEglHelper     // Catch:{ RuntimeException -> 0x01f8 }
                r0.start()     // Catch:{ RuntimeException -> 0x01f8 }
                r0 = 1
                r1.mHaveEglContext = r0     // Catch:{ all -> 0x03bc }
                r3 = 1
                com.yy.videoplayer.view.GlSurfaceRender$GLThreadManager r0 = com.yy.videoplayer.view.GlSurfaceRender.sGLThreadManager     // Catch:{ all -> 0x0213 }
                r0.notifyAll()     // Catch:{ all -> 0x0213 }
                goto L_0x0204
            L_0x01f8:
                r0 = move-exception
                com.yy.videoplayer.view.GlSurfaceRender$GLThreadManager r2 = com.yy.videoplayer.view.GlSurfaceRender.sGLThreadManager     // Catch:{ all -> 0x03bc }
                r2.releaseEglContextLocked(r1)     // Catch:{ all -> 0x03bc }
                throw r0     // Catch:{ all -> 0x03bc }
            L_0x0202:
                r3 = r17
            L_0x0204:
                boolean r0 = r1.mHaveEglContext     // Catch:{ all -> 0x03a2 }
                if (r0 == 0) goto L_0x021a
                boolean r0 = r1.mHaveEglSurface     // Catch:{ all -> 0x0213 }
                if (r0 != 0) goto L_0x021a
                r0 = 1
                r1.mHaveEglSurface = r0     // Catch:{ all -> 0x0213 }
                r4 = 1
                r5 = 1
                r7 = 1
                goto L_0x021e
            L_0x0213:
                r0 = move-exception
                r4 = r18
                r5 = r20
                goto L_0x03cd
            L_0x021a:
                r4 = r18
                r5 = r20
            L_0x021e:
                boolean r0 = r1.mHaveEglSurface     // Catch:{ all -> 0x00a4 }
                if (r0 == 0) goto L_0x039d
                boolean r0 = r1.mSizeChanged     // Catch:{ all -> 0x00a4 }
                if (r0 == 0) goto L_0x0256
                r7 = 1
                int r0 = r1.mWidth     // Catch:{ all -> 0x00a4 }
                r11 = r0
                int r0 = r1.mHeight     // Catch:{ all -> 0x00a4 }
                r12 = r0
                r0 = 1
                r1.mWantRenderNotification = r0     // Catch:{ all -> 0x00a4 }
                java.lang.String r0 = "GLThread"
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a4 }
                r2.<init>()     // Catch:{ all -> 0x00a4 }
                r17 = r3
                java.lang.String r3 = "noticing that we want render notification tid="
                java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x009d }
                r18 = r4
                long r3 = r21.getId()     // Catch:{ all -> 0x00c5 }
                java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x00c5 }
                java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x00c5 }
                com.yy.videoplayer.utils.YMFLog.info(r1, r0, r2)     // Catch:{ all -> 0x00c5 }
                r4 = 1
                r0 = 0
                r1.mSizeChanged = r0     // Catch:{ all -> 0x0399 }
                goto L_0x025a
            L_0x0256:
                r17 = r3
                r18 = r4
            L_0x025a:
                r0 = 0
                r1.mRequestRender = r0     // Catch:{ all -> 0x0399 }
                com.yy.videoplayer.view.GlSurfaceRender$GLThreadManager r2 = com.yy.videoplayer.view.GlSurfaceRender.sGLThreadManager     // Catch:{ all -> 0x0399 }
                r2.notifyAll()     // Catch:{ all -> 0x0399 }
                boolean r2 = r1.mWantRenderNotification     // Catch:{ all -> 0x0399 }
                if (r2 == 0) goto L_0x026d
                r2 = 1
                r8 = r2
                r3 = r17
                goto L_0x026f
            L_0x026d:
                r3 = r17
            L_0x026f:
                monitor-exit(r14)     // Catch:{ all -> 0x03cf }
                if (r13 == 0) goto L_0x027a
                r13.run()     // Catch:{ all -> 0x03d1 }
                r13 = 0
                r2 = r16
                goto L_0x001e
            L_0x027a:
                if (r4 == 0) goto L_0x02ba
                java.lang.String r2 = "GLThread"
                java.lang.String r14 = "egl createSurface"
                com.yy.videoplayer.utils.YMFLog.info(r1, r2, r14)     // Catch:{ all -> 0x03d1 }
                com.yy.videoplayer.view.GlSurfaceRender$EglHelper r2 = r1.mEglHelper     // Catch:{ all -> 0x03d1 }
                boolean r2 = r2.createSurface()     // Catch:{ all -> 0x03d1 }
                if (r2 == 0) goto L_0x02a1
                com.yy.videoplayer.view.GlSurfaceRender$GLThreadManager r2 = com.yy.videoplayer.view.GlSurfaceRender.sGLThreadManager     // Catch:{ all -> 0x03d1 }
                monitor-enter(r2)     // Catch:{ all -> 0x03d1 }
                r14 = 1
                r1.mFinishedCreatingEglSurface = r14     // Catch:{ all -> 0x029e }
                com.yy.videoplayer.view.GlSurfaceRender$GLThreadManager r14 = com.yy.videoplayer.view.GlSurfaceRender.sGLThreadManager     // Catch:{ all -> 0x029e }
                r14.notifyAll()     // Catch:{ all -> 0x029e }
                monitor-exit(r2)     // Catch:{ all -> 0x029e }
                r2 = 0
                r4 = r2
                goto L_0x02ba
            L_0x029e:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x029e }
                throw r0     // Catch:{ all -> 0x03d1 }
            L_0x02a1:
                com.yy.videoplayer.view.GlSurfaceRender$GLThreadManager r2 = com.yy.videoplayer.view.GlSurfaceRender.sGLThreadManager     // Catch:{ all -> 0x03d1 }
                monitor-enter(r2)     // Catch:{ all -> 0x03d1 }
                r14 = 1
                r1.mFinishedCreatingEglSurface = r14     // Catch:{ all -> 0x02b7 }
                r1.mSurfaceIsBad = r14     // Catch:{ all -> 0x02b7 }
                com.yy.videoplayer.view.GlSurfaceRender$GLThreadManager r14 = com.yy.videoplayer.view.GlSurfaceRender.sGLThreadManager     // Catch:{ all -> 0x02b7 }
                r14.notifyAll()     // Catch:{ all -> 0x02b7 }
                monitor-exit(r2)     // Catch:{ all -> 0x02b7 }
                r2 = r16
                goto L_0x001e
            L_0x02b7:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x02b7 }
                throw r0     // Catch:{ all -> 0x03d1 }
            L_0x02ba:
                if (r5 == 0) goto L_0x02c6
                com.yy.videoplayer.view.GlSurfaceRender$EglHelper r2 = r1.mEglHelper     // Catch:{ all -> 0x03d1 }
                javax.microedition.khronos.opengles.GL r2 = r2.createGL()     // Catch:{ all -> 0x03d1 }
                javax.microedition.khronos.opengles.GL10 r2 = (javax.microedition.khronos.opengles.GL10) r2     // Catch:{ all -> 0x03d1 }
                r5 = 0
                goto L_0x02c8
            L_0x02c6:
                r2 = r16
            L_0x02c8:
                if (r3 == 0) goto L_0x02e9
                java.lang.String r14 = "GLThread"
                java.lang.String r15 = "onSurfaceCreated"
                com.yy.videoplayer.utils.YMFLog.info(r1, r14, r15)     // Catch:{ all -> 0x03d1 }
                java.lang.ref.WeakReference<com.yy.videoplayer.view.GlSurfaceRender> r14 = r1.mGlSurfaceRenderWeakRef     // Catch:{ all -> 0x03d1 }
                java.lang.Object r14 = r14.get()     // Catch:{ all -> 0x03d1 }
                com.yy.videoplayer.view.GlSurfaceRender r14 = (com.yy.videoplayer.view.GlSurfaceRender) r14     // Catch:{ all -> 0x03d1 }
                if (r14 == 0) goto L_0x02e7
                com.yy.videoplayer.view.GlSurfaceRender$Renderer r15 = r14.mRenderer     // Catch:{ all -> 0x03d1 }
                com.yy.videoplayer.view.GlSurfaceRender$EglHelper r0 = r1.mEglHelper     // Catch:{ all -> 0x03d1 }
                javax.microedition.khronos.egl.EGLConfig r0 = r0.mEglConfig     // Catch:{ all -> 0x03d1 }
                r15.onSurfaceCreated(r2, r0)     // Catch:{ all -> 0x03d1 }
            L_0x02e7:
                r0 = 0
                r3 = r0
            L_0x02e9:
                if (r7 == 0) goto L_0x0326
                java.lang.String r0 = "GLThread"
                java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ all -> 0x03d1 }
                r14.<init>()     // Catch:{ all -> 0x03d1 }
                java.lang.String r15 = "onSurfaceChanged("
                java.lang.StringBuilder r14 = r14.append(r15)     // Catch:{ all -> 0x03d1 }
                java.lang.StringBuilder r14 = r14.append(r11)     // Catch:{ all -> 0x03d1 }
                java.lang.String r15 = ", "
                java.lang.StringBuilder r14 = r14.append(r15)     // Catch:{ all -> 0x03d1 }
                java.lang.StringBuilder r14 = r14.append(r12)     // Catch:{ all -> 0x03d1 }
                java.lang.String r15 = ")"
                java.lang.StringBuilder r14 = r14.append(r15)     // Catch:{ all -> 0x03d1 }
                java.lang.String r14 = r14.toString()     // Catch:{ all -> 0x03d1 }
                com.yy.videoplayer.utils.YMFLog.info(r1, r0, r14)     // Catch:{ all -> 0x03d1 }
                java.lang.ref.WeakReference<com.yy.videoplayer.view.GlSurfaceRender> r0 = r1.mGlSurfaceRenderWeakRef     // Catch:{ all -> 0x03d1 }
                java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x03d1 }
                com.yy.videoplayer.view.GlSurfaceRender r0 = (com.yy.videoplayer.view.GlSurfaceRender) r0     // Catch:{ all -> 0x03d1 }
                if (r0 == 0) goto L_0x0325
                com.yy.videoplayer.view.GlSurfaceRender$Renderer r14 = r0.mRenderer     // Catch:{ all -> 0x03d1 }
                r14.onSurfaceChanged(r2, r11, r12)     // Catch:{ all -> 0x03d1 }
            L_0x0325:
                r7 = 0
            L_0x0326:
                java.lang.ref.WeakReference<com.yy.videoplayer.view.GlSurfaceRender> r0 = r1.mGlSurfaceRenderWeakRef     // Catch:{ all -> 0x03d1 }
                java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x03d1 }
                com.yy.videoplayer.view.GlSurfaceRender r0 = (com.yy.videoplayer.view.GlSurfaceRender) r0     // Catch:{ all -> 0x03d1 }
                if (r0 == 0) goto L_0x0337
                com.yy.videoplayer.view.GlSurfaceRender$Renderer r14 = r0.mRenderer     // Catch:{ all -> 0x03d1 }
                r14.onDrawFrame(r2)     // Catch:{ all -> 0x03d1 }
            L_0x0337:
                com.yy.videoplayer.view.GlSurfaceRender$EglHelper r0 = r1.mEglHelper     // Catch:{ all -> 0x03d1 }
                int r0 = r0.swap()     // Catch:{ all -> 0x03d1 }
                r14 = r0
                switch(r14) {
                    case 12288: goto L_0x036d;
                    case 12302: goto L_0x0349;
                    default: goto L_0x0341;
                }     // Catch:{ all -> 0x03d1 }
            L_0x0341:
                r16 = r2
                r17 = r3
                r15 = r4
                java.lang.String r0 = "GLThread"
                goto L_0x0373
            L_0x0349:
                java.lang.String r0 = "GLThread"
                java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ all -> 0x03d1 }
                r15.<init>()     // Catch:{ all -> 0x03d1 }
                r16 = r2
                java.lang.String r2 = "egl context lost tid="
                java.lang.StringBuilder r2 = r15.append(r2)     // Catch:{ all -> 0x03d1 }
                r17 = r3
                r15 = r4
                long r3 = r21.getId()     // Catch:{ all -> 0x03d1 }
                java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x03d1 }
                java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x03d1 }
                com.yy.videoplayer.utils.YMFLog.info(r1, r0, r2)     // Catch:{ all -> 0x03d1 }
                r0 = 1
                r6 = r0
                goto L_0x0388
            L_0x036d:
                r16 = r2
                r17 = r3
                r15 = r4
                goto L_0x0388
            L_0x0373:
                java.lang.String r2 = "eglSwapBuffers"
                com.yy.videoplayer.view.GlSurfaceRender.EglHelper.logEglErrorAsWarning(r0, r2, r14)     // Catch:{ all -> 0x03d1 }
                com.yy.videoplayer.view.GlSurfaceRender$GLThreadManager r2 = com.yy.videoplayer.view.GlSurfaceRender.sGLThreadManager     // Catch:{ all -> 0x03d1 }
                monitor-enter(r2)     // Catch:{ all -> 0x03d1 }
                r0 = 1
                r1.mSurfaceIsBad = r0     // Catch:{ all -> 0x0396 }
                com.yy.videoplayer.view.GlSurfaceRender$GLThreadManager r0 = com.yy.videoplayer.view.GlSurfaceRender.sGLThreadManager     // Catch:{ all -> 0x0396 }
                r0.notifyAll()     // Catch:{ all -> 0x0396 }
                monitor-exit(r2)     // Catch:{ all -> 0x0396 }
            L_0x0388:
                if (r8 == 0) goto L_0x038e
                r0 = 1
                r2 = 0
                r9 = r0
                r8 = r2
            L_0x038e:
                r4 = r15
                r2 = r16
                r3 = r17
                r0 = 0
                goto L_0x001e
            L_0x0396:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x0396 }
                throw r0     // Catch:{ all -> 0x03d1 }
            L_0x0399:
                r0 = move-exception
                r3 = r17
                goto L_0x03cd
            L_0x039d:
                r17 = r3
                r18 = r4
                goto L_0x03b0
            L_0x03a2:
                r0 = move-exception
                r17 = r3
                r4 = r18
                r5 = r20
                goto L_0x03cd
            L_0x03aa:
                r3 = r17
                r4 = r18
                r5 = r20
            L_0x03b0:
                com.yy.videoplayer.view.GlSurfaceRender$GLThreadManager r0 = com.yy.videoplayer.view.GlSurfaceRender.sGLThreadManager     // Catch:{ all -> 0x03cf }
                r0.wait()     // Catch:{ all -> 0x03cf }
                r2 = r16
                r0 = 0
                goto L_0x0023
            L_0x03bc:
                r0 = move-exception
                r3 = r17
                r4 = r18
                r5 = r20
                goto L_0x03cd
            L_0x03c4:
                r0 = move-exception
                r16 = r2
                r17 = r3
                r18 = r4
                r20 = r5
            L_0x03cd:
                monitor-exit(r14)     // Catch:{ all -> 0x03cf }
                throw r0     // Catch:{ all -> 0x03d1 }
            L_0x03cf:
                r0 = move-exception
                goto L_0x03cd
            L_0x03d1:
                r0 = move-exception
                com.yy.videoplayer.view.GlSurfaceRender$GLThreadManager r2 = com.yy.videoplayer.view.GlSurfaceRender.sGLThreadManager
                monitor-enter(r2)
                r21.stopEglSurfaceLocked()     // Catch:{ all -> 0x03df }
                r21.stopEglContextLocked()     // Catch:{ all -> 0x03df }
                monitor-exit(r2)     // Catch:{ all -> 0x03df }
                throw r0
            L_0x03df:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x03df }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.yy.videoplayer.view.GlSurfaceRender.GLThread.guardedRun():void");
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
            synchronized (GlSurfaceRender.sGLThreadManager) {
                this.mRenderMode = renderMode;
                GlSurfaceRender.sGLThreadManager.notifyAll();
            }
        }

        public int getRenderMode() {
            int i2;
            synchronized (GlSurfaceRender.sGLThreadManager) {
                i2 = this.mRenderMode;
            }
            return i2;
        }

        public void requestRender() {
            synchronized (GlSurfaceRender.sGLThreadManager) {
                this.mRequestRender = true;
                GlSurfaceRender.sGLThreadManager.notifyAll();
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0040, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void requestRenderAndWait() {
            /*
                r3 = this;
                com.yy.videoplayer.view.GlSurfaceRender$GLThreadManager r0 = com.yy.videoplayer.view.GlSurfaceRender.sGLThreadManager
                monitor-enter(r0)
                java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0041 }
                if (r1 != r3) goto L_0x000d
                monitor-exit(r0)     // Catch:{ all -> 0x0041 }
                return
            L_0x000d:
                r1 = 1
                r3.mWantRenderNotification = r1     // Catch:{ all -> 0x0041 }
                r3.mRequestRender = r1     // Catch:{ all -> 0x0041 }
                r1 = 0
                r3.mRenderComplete = r1     // Catch:{ all -> 0x0041 }
                com.yy.videoplayer.view.GlSurfaceRender$GLThreadManager r1 = com.yy.videoplayer.view.GlSurfaceRender.sGLThreadManager     // Catch:{ all -> 0x0041 }
                r1.notifyAll()     // Catch:{ all -> 0x0041 }
            L_0x001c:
                boolean r1 = r3.mExited     // Catch:{ all -> 0x0041 }
                if (r1 != 0) goto L_0x003f
                boolean r1 = r3.mPaused     // Catch:{ all -> 0x0041 }
                if (r1 != 0) goto L_0x003f
                boolean r1 = r3.mRenderComplete     // Catch:{ all -> 0x0041 }
                if (r1 != 0) goto L_0x003f
                boolean r1 = r3.ableToDraw()     // Catch:{ all -> 0x0041 }
                if (r1 == 0) goto L_0x003f
                com.yy.videoplayer.view.GlSurfaceRender$GLThreadManager r1 = com.yy.videoplayer.view.GlSurfaceRender.sGLThreadManager     // Catch:{ InterruptedException -> 0x0036 }
                r1.wait()     // Catch:{ InterruptedException -> 0x0036 }
            L_0x0035:
                goto L_0x001c
            L_0x0036:
                r1 = move-exception
                java.lang.Thread r2 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0041 }
                r2.interrupt()     // Catch:{ all -> 0x0041 }
                goto L_0x0035
            L_0x003f:
                monitor-exit(r0)     // Catch:{ all -> 0x0041 }
                return
            L_0x0041:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0041 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.yy.videoplayer.view.GlSurfaceRender.GLThread.requestRenderAndWait():void");
        }

        public void surfaceCreated() {
            synchronized (GlSurfaceRender.sGLThreadManager) {
                this.mHasSurface = true;
                this.mFinishedCreatingEglSurface = false;
                GlSurfaceRender.sGLThreadManager.notifyAll();
                while (this.mWaitingForSurface && !this.mFinishedCreatingEglSurface && !this.mExited) {
                    try {
                        GlSurfaceRender.sGLThreadManager.wait();
                    } catch (InterruptedException e2) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void surfaceDestroyed() {
            synchronized (GlSurfaceRender.sGLThreadManager) {
                this.mHasSurface = false;
                GlSurfaceRender.sGLThreadManager.notifyAll();
                while (!this.mWaitingForSurface && !this.mExited) {
                    try {
                        GlSurfaceRender.sGLThreadManager.wait();
                    } catch (InterruptedException e2) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onPause() {
            synchronized (GlSurfaceRender.sGLThreadManager) {
                this.mRequestPaused = true;
                GlSurfaceRender.sGLThreadManager.notifyAll();
                while (!this.mExited && !this.mPaused) {
                    try {
                        GlSurfaceRender.sGLThreadManager.wait();
                    } catch (InterruptedException e2) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onResume() {
            synchronized (GlSurfaceRender.sGLThreadManager) {
                this.mRequestPaused = false;
                this.mRequestRender = true;
                this.mRenderComplete = false;
                GlSurfaceRender.sGLThreadManager.notifyAll();
                while (!this.mExited && this.mPaused && !this.mRenderComplete) {
                    try {
                        GlSurfaceRender.sGLThreadManager.wait();
                    } catch (InterruptedException e2) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0061, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onWindowResize(int r6, int r7) {
            /*
                r5 = this;
                com.yy.videoplayer.view.GlSurfaceRender$GLThreadManager r0 = com.yy.videoplayer.view.GlSurfaceRender.sGLThreadManager
                monitor-enter(r0)
                r5.mWidth = r6     // Catch:{ all -> 0x0062 }
                r5.mHeight = r7     // Catch:{ all -> 0x0062 }
                r1 = 1
                r5.mSizeChanged = r1     // Catch:{ all -> 0x0062 }
                r5.mRequestRender = r1     // Catch:{ all -> 0x0062 }
                r1 = 0
                r5.mRenderComplete = r1     // Catch:{ all -> 0x0062 }
                java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0062 }
                if (r1 != r5) goto L_0x0019
                monitor-exit(r0)     // Catch:{ all -> 0x0062 }
                return
            L_0x0019:
                com.yy.videoplayer.view.GlSurfaceRender$GLThreadManager r1 = com.yy.videoplayer.view.GlSurfaceRender.sGLThreadManager     // Catch:{ all -> 0x0062 }
                r1.notifyAll()     // Catch:{ all -> 0x0062 }
            L_0x0020:
                boolean r1 = r5.mExited     // Catch:{ all -> 0x0062 }
                if (r1 != 0) goto L_0x0060
                boolean r1 = r5.mPaused     // Catch:{ all -> 0x0062 }
                if (r1 != 0) goto L_0x0060
                boolean r1 = r5.mRenderComplete     // Catch:{ all -> 0x0062 }
                if (r1 != 0) goto L_0x0060
                boolean r1 = r5.ableToDraw()     // Catch:{ all -> 0x0062 }
                if (r1 == 0) goto L_0x0060
                java.lang.String r1 = "Main thread"
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0062 }
                r2.<init>()     // Catch:{ all -> 0x0062 }
                java.lang.String r3 = "onWindowResize waiting for render complete from tid="
                java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x0062 }
                long r3 = r5.getId()     // Catch:{ all -> 0x0062 }
                java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x0062 }
                java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0062 }
                com.yy.videoplayer.utils.YMFLog.info(r5, r1, r2)     // Catch:{ all -> 0x0062 }
                com.yy.videoplayer.view.GlSurfaceRender$GLThreadManager r1 = com.yy.videoplayer.view.GlSurfaceRender.sGLThreadManager     // Catch:{ InterruptedException -> 0x0057 }
                r1.wait()     // Catch:{ InterruptedException -> 0x0057 }
            L_0x0056:
                goto L_0x0020
            L_0x0057:
                r1 = move-exception
                java.lang.Thread r2 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0062 }
                r2.interrupt()     // Catch:{ all -> 0x0062 }
                goto L_0x0056
            L_0x0060:
                monitor-exit(r0)     // Catch:{ all -> 0x0062 }
                return
            L_0x0062:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0062 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.yy.videoplayer.view.GlSurfaceRender.GLThread.onWindowResize(int, int):void");
        }

        public void requestExitAndWait() {
            synchronized (GlSurfaceRender.sGLThreadManager) {
                this.mShouldExit = true;
                GlSurfaceRender.sGLThreadManager.notifyAll();
                while (!this.mExited) {
                    try {
                        GlSurfaceRender.sGLThreadManager.wait();
                    } catch (InterruptedException e2) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void requestReleaseEglContextLocked() {
            this.mShouldReleaseEglContext = true;
            GlSurfaceRender.sGLThreadManager.notifyAll();
        }

        public void queueEvent(Runnable r) {
            if (r != null) {
                synchronized (GlSurfaceRender.sGLThreadManager) {
                    this.mEventQueue.add(r);
                    GlSurfaceRender.sGLThreadManager.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("r must not be null");
        }
    }

    static class LogWriter extends Writer {
        private StringBuilder mBuilder = new StringBuilder();

        LogWriter() {
        }

        public void close() {
            flushBuilder();
        }

        public void flush() {
            flushBuilder();
        }

        public void write(char[] buf, int offset, int count) {
            for (int i2 = 0; i2 < count; i2++) {
                char c2 = buf[offset + i2];
                if (c2 == 10) {
                    flushBuilder();
                } else {
                    this.mBuilder.append(c2);
                }
            }
        }

        private void flushBuilder() {
            if (this.mBuilder.length() > 0) {
                Log.v(GlSurfaceRender.TAG, this.mBuilder.toString());
                StringBuilder sb = this.mBuilder;
                sb.delete(0, sb.length());
            }
        }
    }

    private void checkRenderThreadState() {
        if (this.mGLThread != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    private static class GLThreadManager {
        private static String TAG = "GLThreadManager";

        private GLThreadManager() {
        }

        public synchronized void threadExiting(GLThread thread) {
            boolean unused = thread.mExited = true;
            notifyAll();
        }

        public void releaseEglContextLocked(GLThread thread) {
            notifyAll();
        }
    }
}
