package com.yy.transvod.player.opengles;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.baidu.webkit.internal.monitor.MonitorType;
import com.yy.transvod.player.log.TLog;
import java.util.concurrent.atomic.AtomicBoolean;

public final class EglCore implements IEglCore {
    private static final int[] CONFIG_ARRTIBS = {MonitorType.MONITOR_TYPE_DOWNLOAD_WEBKIT, 8, MonitorType.MONITOR_TYPE_INIT_WEBKIT, 8, 12322, 8, 12321, 8, 12352, 4, 12344};
    private static final int[] CONTEXT_ATTRIBS = {12440, 2, 12344};
    private static final int[] PBUFFER_SURFACE_ARRTIBS = {12375, 1, 12374, 1, 12417, 12380, 12416, 12380, 12344};
    private static final String TAG = "EglCore";
    private static final int[] WINDOW_SURFACE_ARRTIBS = {12344};
    private final AtomicBoolean mAvailable = new AtomicBoolean(false);
    private EGLConfig mEglConfig = null;
    private EGLContext mEglContext = EGL14.EGL_NO_CONTEXT;
    private EGLDisplay mEglDisplay = EGL14.EGL_NO_DISPLAY;
    private EGLSurface mEglSurface = EGL14.EGL_NO_SURFACE;
    private EGLSurface mOffscreenSurface = EGL14.EGL_NO_SURFACE;
    private boolean mUseWindowSurface = true;

    public void setup() {
        if (this.mEglDisplay == EGL14.EGL_NO_DISPLAY || this.mEglContext == EGL14.EGL_NO_CONTEXT) {
            EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
            this.mEglDisplay = eglGetDisplay;
            if (eglGetDisplay != EGL14.EGL_NO_DISPLAY) {
                TLog.warn(TAG, this, "EGL14.eglGetDisplay() = " + this.mEglDisplay);
                int[] version = new int[2];
                if (EGL14.eglInitialize(this.mEglDisplay, version, 0, version, 1)) {
                    TLog.warn(TAG, this, "EGLDisplay.majoy:" + version[0] + ", EGLDisplay.minor:" + version[1]);
                    EGLConfig[] configs = new EGLConfig[1];
                    EGL14.eglChooseConfig(this.mEglDisplay, CONFIG_ARRTIBS, 0, configs, 0, configs.length, new int[1], 0);
                    EGLConfig eGLConfig = configs[0];
                    this.mEglConfig = eGLConfig;
                    EGLContext eglCreateContext = EGL14.eglCreateContext(this.mEglDisplay, eGLConfig, EGL14.eglGetCurrentContext(), CONTEXT_ATTRIBS, 0);
                    this.mEglContext = eglCreateContext;
                    if (eglCreateContext != EGL14.EGL_NO_CONTEXT) {
                        EGL14.eglQueryContext(this.mEglDisplay, this.mEglContext, 12440, version, 0);
                        TLog.info(TAG, this, "setup EGL14.eglCreateContext() = " + this.mEglContext + " version:", Integer.valueOf(version[0]));
                        return;
                    }
                    throw new RuntimeException(String.format("EGL14.eglCreateContext() failed. eglGetError() = 0x%04x", new Object[]{Integer.valueOf(EGL14.eglGetError())}));
                }
                this.mEglDisplay = EGL14.EGL_NO_DISPLAY;
                throw new RuntimeException(String.format("EGL14.eglInitialize() failed. eglGetError() = 0x%04x", new Object[]{Integer.valueOf(EGL14.eglGetError())}));
            }
            throw new RuntimeException(String.format("EGL14.eglGetDisplay() failed. eglGetError() = 0x%04x", new Object[]{Integer.valueOf(EGL14.eglGetError())}));
        }
        TLog.warn(TAG, this, "already created.");
    }

    public void release() {
        TLog.info(TAG, (Object) this, "release enter");
        try {
            makeCurrent(0, false);
            if (this.mEglDisplay != EGL14.EGL_NO_DISPLAY) {
                if (this.mEglContext != EGL14.EGL_NO_CONTEXT) {
                    EGL14.eglDestroyContext(this.mEglDisplay, this.mEglContext);
                }
                if (this.mEglSurface != EGL14.EGL_NO_SURFACE) {
                    EGL14.eglDestroySurface(this.mEglDisplay, this.mEglSurface);
                }
                if (this.mOffscreenSurface != EGL14.EGL_NO_SURFACE) {
                    EGL14.eglDestroySurface(this.mEglDisplay, this.mOffscreenSurface);
                    TLog.warn(TAG, this, "release offscreen surface.");
                }
                if (shouldReleaseThread()) {
                    EGL14.eglReleaseThread();
                }
                EGL14.eglTerminate(this.mEglDisplay);
            }
            this.mEglConfig = null;
            this.mEglDisplay = EGL14.EGL_NO_DISPLAY;
            this.mEglContext = EGL14.EGL_NO_CONTEXT;
            this.mEglSurface = EGL14.EGL_NO_SURFACE;
            this.mOffscreenSurface = EGL14.EGL_NO_SURFACE;
            this.mAvailable.set(false);
        } catch (Exception e2) {
            TLog.error(TAG, this, "EglCore release error: " + e2.getMessage());
        }
        TLog.warn(TAG, this, "release leave.");
    }

    public boolean isSurfaceValid(Object surface) {
        if (surface instanceof SurfaceHolder) {
            return ((SurfaceHolder) surface).getSurface().isValid();
        }
        if (surface instanceof SurfaceView) {
            return ((SurfaceView) surface).getHolder().getSurface().isValid();
        }
        if (surface instanceof Surface) {
            return ((Surface) surface).isValid();
        }
        TLog.error(TAG, this, "param surface is invalid.");
        return false;
    }

    public boolean createSurface(Object surface) {
        boolean z = false;
        TLog.warn(TAG, this, "createSurface enter: " + (surface != null ? surface.hashCode() : 0));
        boolean ret = false;
        if (!(this.mEglDisplay == EGL14.EGL_NO_DISPLAY || this.mEglConfig == null)) {
            if (surface != null) {
                try {
                    if (isSurfaceValid(surface)) {
                        EGLSurface eglCreateWindowSurface = EGL14.eglCreateWindowSurface(this.mEglDisplay, this.mEglConfig, surface, WINDOW_SURFACE_ARRTIBS, 0);
                        this.mEglSurface = eglCreateWindowSurface;
                        if (eglCreateWindowSurface == EGL14.EGL_NO_SURFACE) {
                            TLog.error(TAG, this, String.format("EGL14.eglCreateWindowSurface() failed. eglGetError() = 0x%04x", new Object[]{Integer.valueOf(EGL14.eglGetError())}));
                        }
                        this.mUseWindowSurface = true;
                        TLog.info(TAG, (Object) this, "EGL14.eglCreateWindowSurface() = " + this.mEglSurface);
                        this.mAvailable.set(makeCurrent(1, true));
                        if (this.mEglSurface != EGL14.EGL_NO_SURFACE) {
                            z = true;
                        }
                        ret = z;
                    }
                } catch (Exception ex) {
                    TLog.error(TAG, this, "EGL14.eglCreateWindowSurface() = " + ex.toString());
                }
            }
            EGLSurface eglCreatePbufferSurface = EGL14.eglCreatePbufferSurface(this.mEglDisplay, this.mEglConfig, PBUFFER_SURFACE_ARRTIBS, 0);
            this.mOffscreenSurface = eglCreatePbufferSurface;
            if (eglCreatePbufferSurface == EGL14.EGL_NO_SURFACE) {
                TLog.error(TAG, this, String.format("EGL14.eglCreatePbufferSurface() failed. eglGetError() = 0x%04x", new Object[]{Integer.valueOf(EGL14.eglGetError())}));
            }
            this.mUseWindowSurface = false;
            makeCurrent(2, true);
            TLog.info(TAG, (Object) this, "EGL14.eglCreatePbufferSurface() = " + this.mOffscreenSurface);
            if (this.mOffscreenSurface != EGL14.EGL_NO_SURFACE) {
                z = true;
            }
            ret = z;
        }
        TLog.warn(TAG, this, "createSurface leave.");
        return ret;
    }

    public void destroySurface(boolean windowSurface) {
        TLog.warn(TAG, this, "destroySurface enter, windowSurface: " + windowSurface);
        EGLSurface surface = windowSurface ? this.mEglSurface : this.mOffscreenSurface;
        if (windowSurface) {
            this.mAvailable.set(false);
        }
        makeCurrent(0, true);
        if (!(this.mEglDisplay == EGL14.EGL_NO_DISPLAY || surface == EGL14.EGL_NO_SURFACE)) {
            EGL14.eglDestroySurface(this.mEglDisplay, surface);
            if (windowSurface) {
                this.mEglSurface = EGL14.EGL_NO_SURFACE;
            } else {
                this.mOffscreenSurface = EGL14.EGL_NO_SURFACE;
            }
        }
        TLog.warn(TAG, this, "destroySurface leave.");
    }

    public boolean available() {
        return this.mAvailable.get();
    }

    public boolean makeCurrent(int bindSurfaceType, boolean bindContext) {
        int errorCode;
        boolean result = false;
        if (this.mEglDisplay != EGL14.EGL_NO_DISPLAY) {
            EGLSurface surface = getSurfaceByType(bindSurfaceType);
            EGLContext context = bindContext ? this.mEglContext : EGL14.EGL_NO_CONTEXT;
            if (surface == EGL14.EGL_NO_SURFACE && context != EGL14.EGL_NO_CONTEXT) {
                return true;
            }
            boolean eglMakeCurrent = EGL14.eglMakeCurrent(this.mEglDisplay, surface, surface, context);
            result = eglMakeCurrent;
            if (!eglMakeCurrent && (errorCode = EGL14.eglGetError()) != 12288) {
                TLog.error(TAG, this, String.format("EGL14.eglMakeCurrent() failed. eglGetError() = 0x%04x", new Object[]{Integer.valueOf(errorCode)}) + " bindSurfaceType=" + bindSurfaceType);
            }
        }
        return result;
    }

    public boolean swapBuffer() {
        if (this.mEglDisplay == EGL14.EGL_NO_DISPLAY || this.mEglSurface == EGL14.EGL_NO_SURFACE) {
            return false;
        }
        return EGL14.eglSwapBuffers(this.mEglDisplay, this.mEglSurface);
    }

    public int getSurfaceType() {
        return this.mUseWindowSurface ^ true ? 1 : 0;
    }

    public int getDisplayWidth() {
        int[] value = new int[1];
        if (this.mEglDisplay == EGL14.EGL_NO_DISPLAY || this.mEglSurface == EGL14.EGL_NO_SURFACE || !EGL14.eglQuerySurface(this.mEglDisplay, this.mEglSurface, 12375, value, 0)) {
            return 0;
        }
        return value[0];
    }

    public int getDisplayHeight() {
        int[] value = new int[1];
        if (this.mEglDisplay == EGL14.EGL_NO_DISPLAY || this.mEglSurface == EGL14.EGL_NO_SURFACE || !EGL14.eglQuerySurface(this.mEglDisplay, this.mEglSurface, 12374, value, 0)) {
            return 0;
        }
        return value[0];
    }

    private boolean shouldReleaseThread() {
        return false;
    }

    private EGLSurface getSurfaceByType(int bindSufaceType) {
        EGLSurface surface = EGL14.EGL_NO_SURFACE;
        if (bindSufaceType == 1) {
            return this.mEglSurface;
        }
        if (bindSufaceType == 2) {
            return this.mOffscreenSurface;
        }
        return surface;
    }
}
