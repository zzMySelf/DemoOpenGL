package com.yy.mediaframework.gles;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.yy.mediaframework.utils.YMFLog;

public final class EglCore implements IEglCore {
    private static final int EGL_RECORDABLE_ANDROID = 12610;
    public static final int FLAG_RECORDABLE = 1;
    public static final int FLAG_TRY_GLES3 = 2;
    private static final String TAG = "GlUtil";
    private boolean isShared;
    private EGLConfig mEGLConfig;
    private EGLContext mEGLContext;
    private EGLDisplay mEGLDisplay;
    private int mGlVersion;

    protected EglCore() {
        this((Object) null, 0);
    }

    protected EglCore(Object sharedContext, int flags) {
        EGLContext shareEGLContext;
        EGLConfig config;
        this.mEGLDisplay = EGL14.EGL_NO_DISPLAY;
        this.mEGLContext = EGL14.EGL_NO_CONTEXT;
        this.mEGLConfig = null;
        this.mGlVersion = -1;
        this.isShared = false;
        if (!(sharedContext instanceof EGLContext) && sharedContext != null) {
            throw new RuntimeException("EGL already set up");
        } else if (this.mEGLDisplay == EGL14.EGL_NO_DISPLAY) {
            if (sharedContext == null) {
                shareEGLContext = EGL14.EGL_NO_CONTEXT;
                this.isShared = false;
            } else {
                shareEGLContext = (EGLContext) sharedContext;
                this.isShared = true;
            }
            EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
            this.mEGLDisplay = eglGetDisplay;
            if (eglGetDisplay != EGL14.EGL_NO_DISPLAY) {
                int[] version = new int[2];
                if (EGL14.eglInitialize(this.mEGLDisplay, version, 0, version, 1)) {
                    if (!((flags & 2) == 0 || (config = getConfig(flags, 3)) == null)) {
                        EGLContext context = EGL14.eglCreateContext(this.mEGLDisplay, config, shareEGLContext, new int[]{12440, 3, 12344}, 0);
                        if (EGL14.eglGetError() == 12288) {
                            this.mEGLConfig = config;
                            this.mEGLContext = context;
                            this.mGlVersion = 3;
                        }
                    }
                    if (this.mEGLContext == EGL14.EGL_NO_CONTEXT) {
                        EGLConfig config2 = getConfig(flags, 2);
                        if (config2 != null) {
                            EGLContext context2 = EGL14.eglCreateContext(this.mEGLDisplay, config2, shareEGLContext, new int[]{12440, 2, 12344}, 0);
                            checkEglError("eglCreateContext");
                            this.mEGLConfig = config2;
                            this.mEGLContext = context2;
                            this.mGlVersion = 2;
                        } else {
                            throw new RuntimeException("Unable to find a suitable EGLConfig");
                        }
                    }
                    int[] values = new int[1];
                    EGL14.eglQueryContext(this.mEGLDisplay, this.mEGLContext, 12440, values, 0);
                    YMFLog.info(this, "[Util    ]", "EGLContext created, client version:" + values[0]);
                    return;
                }
                this.mEGLDisplay = null;
                throw new RuntimeException("unable to initialize EGL14");
            }
            throw new RuntimeException("unable to get EGL14 display");
        } else {
            throw new RuntimeException("EGL already set up");
        }
    }

    private EGLConfig getConfig(int flags, int version) {
        int i2 = version;
        int renderableType = 4;
        if (i2 >= 3) {
            renderableType = 4 | 64;
        }
        int[] attribList = {12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, renderableType, 12344, 0, 12344};
        if ((flags & 1) != 0) {
            attribList[attribList.length - 3] = EGL_RECORDABLE_ANDROID;
            attribList[attribList.length - 2] = 1;
        }
        EGLConfig[] configs = new EGLConfig[1];
        if (EGL14.eglChooseConfig(this.mEGLDisplay, attribList, 0, configs, 0, configs.length, new int[1], 0)) {
            return configs[0];
        }
        YMFLog.warn(this, "[Util    ]", "unable to find EGLConfig:RGB8888/" + i2 + " ");
        return null;
    }

    public void release() {
        if (this.mEGLDisplay != EGL14.EGL_NO_DISPLAY) {
            EGL14.eglMakeCurrent(this.mEGLDisplay, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT);
            EGL14.eglDestroyContext(this.mEGLDisplay, this.mEGLContext);
            EGL14.eglReleaseThread();
            EGL14.eglTerminate(this.mEGLDisplay);
        }
        this.mEGLDisplay = EGL14.EGL_NO_DISPLAY;
        this.mEGLContext = EGL14.EGL_NO_CONTEXT;
        this.mEGLConfig = null;
    }

    public void makeCurrent(IEglSurfaceBase eglSfBase) {
        if (eglSfBase != null) {
            eglSfBase.makeCurrent();
        }
    }

    public void makeCurrent(IEglSurfaceBase drawSurface, IEglSurfaceBase readSurface) {
        EGLSurface dSf = null;
        EGLSurface rSf = null;
        if (drawSurface != null && (drawSurface instanceof EglSurfaceBase)) {
            dSf = ((EglSurfaceBase) drawSurface).getEGLSurface();
        } else if (drawSurface != null) {
            throw new RuntimeException("EGL version error,  drawSurface is not getInstance of  EglSurfaceBase");
        }
        if (readSurface != null && (readSurface instanceof EglSurfaceBase)) {
            rSf = ((EglSurfaceBase) readSurface).getEGLSurface();
        } else if (readSurface != null) {
            throw new RuntimeException("EGL version error,  readSurface is not getInstance of  EglSurfaceBase");
        }
        _makeCurrent(dSf, rSf);
    }

    public boolean swapBuffers(IEglSurfaceBase eglSfBase) {
        if (eglSfBase != null && (eglSfBase instanceof EglSurfaceBase)) {
            return swapBuffers(((EglSurfaceBase) eglSfBase).getEGLSurface());
        }
        throw new RuntimeException("EGL version error,  drawSurface is not getInstance of  EglSurfaceBase");
    }

    public void setPresentationTime(IEglSurfaceBase eglSfBase, long nsecs) {
        if (eglSfBase != null && (eglSfBase instanceof EglSurfaceBase)) {
            _setPresentationTime(((EglSurfaceBase) eglSfBase).getEGLSurface(), nsecs);
        } else if (eglSfBase != null) {
            throw new RuntimeException("EGL version error,  drawSurface is not getInstance of  EglSurfaceBase");
        }
    }

    public boolean isCurrent(IEglSurfaceBase eglSfBase) {
        if (eglSfBase != null && (eglSfBase instanceof EglSurfaceBase)) {
            return _isCurrent(((EglSurfaceBase) eglSfBase).getEGLSurface());
        }
        if (eglSfBase == null) {
            return false;
        }
        throw new RuntimeException("EGL version error,  surface is not opengl.EGLSurface ");
    }

    public int querySurface(IEglSurfaceBase eglSfBase, int what) {
        if (eglSfBase != null && (eglSfBase instanceof EglSurfaceBase)) {
            return _querySurface(((EglSurfaceBase) eglSfBase).getEGLSurface(), what);
        }
        if (eglSfBase == null) {
            return -1;
        }
        throw new RuntimeException("EGL version error,  surface is not opengl.EGLSurface ");
    }

    public IEglSurfaceBase createSurfaceBase() {
        return new EglSurfaceBase(this);
    }

    public IWindowSurface createWindowSurface(Surface surface, boolean releaseSurface) {
        return new WindowSurface(this, surface, releaseSurface);
    }

    public IWindowSurface createWindowSurface(SurfaceHolder holder, boolean releaseSurace) {
        throw new RuntimeException("EGL version error,  android.opengl.egl don't need SurfaceHolder to create window surface");
    }

    public IWindowSurface createWindowSurface(SurfaceTexture surfaceTexture) {
        return new WindowSurface(this, surfaceTexture);
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        try {
            if (this.mEGLDisplay != EGL14.EGL_NO_DISPLAY && !this.isShared) {
                YMFLog.warn(this, "[Util    ]", "WARNING: EglCore was not explicitly released -- state may be leaked");
                release();
            }
        } finally {
            super.finalize();
        }
    }

    /* access modifiers changed from: protected */
    public void releaseSurface(EGLSurface eglSurface) {
        YMFLog.info(this, "[Util    ]", "releaseSurface success?:" + EGL14.eglDestroySurface(this.mEGLDisplay, eglSurface) + " eglSurface:" + eglSurface);
    }

    /* access modifiers changed from: protected */
    public EGLSurface createWindowSurface(Object surface) {
        if ((surface instanceof Surface) || (surface instanceof SurfaceTexture)) {
            EGLSurface eglSurface = EGL14.eglCreateWindowSurface(this.mEGLDisplay, this.mEGLConfig, surface, new int[]{12344}, 0);
            checkEglError("eglCreateWindowSurface");
            if (eglSurface != null) {
                return eglSurface;
            }
            throw new RuntimeException("surface was null");
        }
        throw new RuntimeException("invalid surface: " + surface);
    }

    /* access modifiers changed from: protected */
    public EGLSurface createOffscreenSurface(int width, int height) {
        EGLSurface eglSurface = EGL14.eglCreatePbufferSurface(this.mEGLDisplay, this.mEGLConfig, new int[]{12375, width, 12374, height, 12344}, 0);
        checkEglError("eglCreatePbufferSurface");
        if (eglSurface != null) {
            return eglSurface;
        }
        throw new RuntimeException("surface was null");
    }

    /* access modifiers changed from: protected */
    public void _makeCurrent(EGLSurface eglSurface) {
        if (this.mEGLDisplay == EGL14.EGL_NO_DISPLAY) {
            YMFLog.info(this, "[Util    ]", "NOTE: makeCurrent w/o display");
        }
        boolean ret = EGL14.eglMakeCurrent(this.mEGLDisplay, eglSurface, eglSurface, this.mEGLContext);
        checkEglError("_makeCurrent");
        if (!ret) {
            throw new RuntimeException("eglMakeCurrent failed");
        }
    }

    /* access modifiers changed from: protected */
    public void _makeCurrent(EGLSurface drawSurface, EGLSurface readSurface) {
        if (this.mEGLDisplay == EGL14.EGL_NO_DISPLAY) {
            YMFLog.info(this, "[Util    ]", "NOTE: makeCurrent w/o display");
        }
        if (!EGL14.eglMakeCurrent(this.mEGLDisplay, drawSurface, readSurface, this.mEGLContext)) {
            YMFLog.error((Object) this, "[Procedur]", " eglMakeCurrent:" + this.mEGLContext + " eglSurface:" + drawSurface + "/" + readSurface + " mEGLDisplay:" + this.mEGLDisplay);
            throw new RuntimeException("eglMakeCurrent(draw,read) failed");
        }
    }

    public int _querySurface(EGLSurface eglSurface, int what) {
        int[] value = new int[1];
        YMFLog.info(this, "[Util    ]", "query surface result:" + EGL14.eglQuerySurface(this.mEGLDisplay, eglSurface, what, value, 0));
        return value[0];
    }

    public boolean _isCurrent(EGLSurface eglSurface) {
        return this.mEGLContext.equals(EGL14.eglGetCurrentContext()) && eglSurface.equals(EGL14.eglGetCurrentSurface(12377));
    }

    public void makeNothingCurrent() {
        boolean ret = EGL14.eglMakeCurrent(this.mEGLDisplay, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT);
        checkEglError("makeNothingCurrent");
        if (!ret) {
            throw new RuntimeException("eglMakeCurrent failed");
        }
    }

    public boolean swapBuffers(EGLSurface eglSurface) {
        return EGL14.eglSwapBuffers(this.mEGLDisplay, eglSurface);
    }

    public void _setPresentationTime(EGLSurface eglSurface, long nsecs) {
        EGLExt.eglPresentationTimeANDROID(this.mEGLDisplay, eglSurface, nsecs);
    }

    public boolean isCurrent(EGLSurface eglSurface) {
        return this.mEGLContext.equals(EGL14.eglGetCurrentContext()) && eglSurface.equals(EGL14.eglGetCurrentSurface(12377));
    }

    public int querySurface(EGLSurface eglSurface, int what) {
        int[] value = new int[1];
        EGL14.eglQuerySurface(this.mEGLDisplay, eglSurface, what, value, 0);
        return value[0];
    }

    public String queryString(int what) {
        return EGL14.eglQueryString(this.mEGLDisplay, what);
    }

    public int getGlVersion() {
        return this.mGlVersion;
    }

    public static void logCurrent(String msg) {
        EGLDisplay display = EGL14.eglGetCurrentDisplay();
        EGLContext context = EGL14.eglGetCurrentContext();
        YMFLog.info((Object) null, "[Util    ]", "Current EGL (" + msg + ") display:" + display + ", context:" + context + ", surface:" + EGL14.eglGetCurrentSurface(12377));
    }

    private void checkEglError(String msg) {
        int eglGetError = EGL14.eglGetError();
        int error = eglGetError;
        if (eglGetError != 12288) {
            throw new RuntimeException(msg + ": EGL error: 0x" + Integer.toHexString(error));
        }
    }

    public EGLContext getEGLContext() {
        return this.mEGLContext;
    }
}
