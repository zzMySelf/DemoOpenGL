package com.yy.videoplayer.decoder.glesunder43;

import android.graphics.SurfaceTexture;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.baidu.webkit.internal.monitor.MonitorType;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGL11;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;

public class EglCore {
    private static final String TAG = "EglCore";
    private EGLConfig mEGLConfig;
    private EGLContext mEGLContext;
    private EGLDisplay mEGLDisplay;
    private EGL10 mEgl;

    public EglCore() {
        this((EGLConfig) null);
    }

    public EglCore(EGLConfig config) {
        EGL10 egl10 = (EGL10) EGLContext.getEGL();
        this.mEgl = egl10;
        EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        this.mEGLDisplay = eglGetDisplay;
        if (eglGetDisplay != EGL10.EGL_NO_DISPLAY) {
            if (this.mEgl.eglInitialize(this.mEGLDisplay, new int[2])) {
                this.mEGLConfig = chooseConfig(this.mEgl, this.mEGLDisplay);
                return;
            }
            throw new RuntimeException("eglInitialize failed");
        }
        throw new RuntimeException("eglGetDisplay failed");
    }

    private int[] filterConfigSpec(int[] configSpec) {
        int len = configSpec.length;
        int[] newConfigSpec = new int[(len + 2)];
        System.arraycopy(configSpec, 0, newConfigSpec, 0, len - 1);
        newConfigSpec[len - 1] = 12352;
        newConfigSpec[len] = 4;
        newConfigSpec[len + 1] = 12344;
        return newConfigSpec;
    }

    public EGLConfig chooseConfig(EGL10 egl, EGLDisplay display) {
        int[] mConfigSpec = filterConfigSpec(new int[]{MonitorType.MONITOR_TYPE_DOWNLOAD_WEBKIT, 8, MonitorType.MONITOR_TYPE_INIT_WEBKIT, 8, 12322, 8, 12321, 8, 12344, 0});
        int[] num_config = new int[1];
        if (egl.eglChooseConfig(display, mConfigSpec, (EGLConfig[]) null, 0, num_config)) {
            int numConfigs = num_config[0];
            if (numConfigs > 0) {
                EGLConfig[] configs = new EGLConfig[numConfigs];
                if (egl.eglChooseConfig(display, mConfigSpec, configs, numConfigs, num_config)) {
                    EGLConfig config = doChooseConfig(egl, display, configs);
                    if (config != null) {
                        this.mEGLContext = egl.eglCreateContext(display, config, EGL10.EGL_NO_CONTEXT, 2 != 0 ? new int[]{12440, 2, 12344} : null);
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

    public EGLConfig doChooseConfig(EGL10 egl, EGLDisplay display, EGLConfig[] configs) {
        for (EGLConfig config : configs) {
            EGL10 egl10 = egl;
            EGLDisplay eGLDisplay = display;
            EGLConfig eGLConfig = config;
            int findConfigAttrib = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12325, 0);
            int findConfigAttrib2 = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12326, 0);
            int r = findConfigAttrib(egl10, eGLDisplay, eGLConfig, MonitorType.MONITOR_TYPE_DOWNLOAD_WEBKIT, 0);
            int g2 = findConfigAttrib(egl10, eGLDisplay, eGLConfig, MonitorType.MONITOR_TYPE_INIT_WEBKIT, 0);
            int b2 = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12322, 0);
            int a2 = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12321, 0);
            if (r == 8 && g2 == 8 && b2 == 8 && a2 == 8) {
                return config;
            }
        }
        return null;
    }

    private int findConfigAttrib(EGL10 egl, EGLDisplay display, EGLConfig config, int attribute, int defaultValue) {
        int[] value = new int[1];
        if (egl.eglGetConfigAttrib(display, config, attribute, value)) {
            return value[0];
        }
        return defaultValue;
    }

    public GL getGL() {
        return this.mEgl.eglGetCurrentContext().getGL();
    }

    public void releaseSurface(EGLSurface eglSurface) {
        EGL10 egl10 = this.mEgl;
        egl10.eglDestroySurface(egl10.eglGetCurrentDisplay(), eglSurface);
    }

    public EGLSurface createWindowSurface(Object surface) {
        if ((surface instanceof Surface) || (surface instanceof SurfaceTexture) || (surface instanceof SurfaceHolder)) {
            new int[1][0] = 12344;
            EGLSurface eglSurface = this.mEgl.eglCreateWindowSurface(this.mEGLDisplay, this.mEGLConfig, surface, (int[]) null);
            checkEglError("eglCreateWindowSurface");
            if (eglSurface != null) {
                return eglSurface;
            }
            throw new RuntimeException("surface was null");
        }
        throw new RuntimeException("invalid surface: " + surface);
    }

    public EGLSurface createOffscreenSurface(int width, int height) {
        EGLSurface eglSurface = this.mEgl.eglCreatePbufferSurface(this.mEGLDisplay, this.mEGLConfig, new int[]{12375, width, 12374, height, 12344});
        checkEglError("eglCreatePbufferSurface");
        if (eglSurface != null) {
            return eglSurface;
        }
        throw new RuntimeException("surface was null");
    }

    public void makeCurrent(EGLSurface eglSurface) {
        if (this.mEGLDisplay == EGL11.EGL_NO_DISPLAY) {
            Log.d(TAG, "NOTE: makeCurrent w/o display");
        }
        if (!this.mEgl.eglMakeCurrent(this.mEGLDisplay, eglSurface, eglSurface, this.mEGLContext)) {
            throw new RuntimeException("eglMakeCurrent failed");
        }
    }

    public void makeCurrent(EGLSurface drawSurface, EGLSurface readSurface) {
        EGLDisplay display = this.mEgl.eglGetCurrentDisplay();
        if (display == EGL11.EGL_NO_DISPLAY) {
            Log.d(TAG, "NOTE: makeCurrent w/o display");
        }
        EGL10 egl10 = this.mEgl;
        if (!egl10.eglMakeCurrent(display, drawSurface, readSurface, egl10.eglGetCurrentContext())) {
            throw new RuntimeException("eglMakeCurrent(draw,read) failed");
        }
    }

    public void makeNothingCurrent() {
        EGL10 egl10 = this.mEgl;
        if (!egl10.eglMakeCurrent(egl10.eglGetCurrentDisplay(), EGL11.EGL_NO_SURFACE, EGL11.EGL_NO_SURFACE, EGL11.EGL_NO_CONTEXT)) {
            throw new RuntimeException("eglMakeCurrent failed");
        }
    }

    public boolean swapBuffers(EGLSurface eglSurface) {
        EGL10 egl10 = this.mEgl;
        return egl10.eglSwapBuffers(egl10.eglGetCurrentDisplay(), eglSurface);
    }

    public void setPresentationTime(EGLSurface eglSurface, long nsecs) {
    }

    public boolean isCurrent(EGLSurface eglSurface) {
        return this.mEGLContext.equals(this.mEgl.eglGetCurrentContext()) && eglSurface.equals(this.mEgl.eglGetCurrentSurface(12377));
    }

    public int querySurface(EGLSurface eglSurface, int what) {
        int[] value = new int[1];
        EGL10 egl10 = this.mEgl;
        egl10.eglQuerySurface(egl10.eglGetCurrentDisplay(), eglSurface, what, value);
        return value[0];
    }

    public String queryString(int what) {
        EGL10 egl10 = this.mEgl;
        return egl10.eglQueryString(egl10.eglGetCurrentDisplay(), what);
    }

    public int getGlVersion() {
        return 2;
    }

    public void logCurrent(String msg) {
        EGLDisplay display = this.mEgl.eglGetCurrentDisplay();
        EGLContext context = this.mEgl.eglGetCurrentContext();
        Log.i(TAG, "Current EGL (" + msg + "): display=" + display + ", context=" + context + ", surface=" + this.mEgl.eglGetCurrentSurface(12377));
    }

    public EGLSurface getCurrentSurface() {
        return this.mEgl.eglGetCurrentSurface(12377);
    }

    private void checkEglError(String msg) {
        int eglGetError = this.mEgl.eglGetError();
        int error = eglGetError;
        if (eglGetError != 12288) {
            throw new RuntimeException(msg + ": EGL error: 0x" + Integer.toHexString(error));
        }
    }

    public void release() {
        if (this.mEGLDisplay != EGL10.EGL_NO_DISPLAY) {
            this.mEgl.eglDestroyContext(this.mEGLDisplay, this.mEGLContext);
            this.mEgl.eglTerminate(this.mEGLDisplay);
        }
        this.mEGLDisplay = EGL10.EGL_NO_DISPLAY;
        this.mEGLContext = EGL10.EGL_NO_CONTEXT;
        this.mEGLConfig = null;
    }
}
