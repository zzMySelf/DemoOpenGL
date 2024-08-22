package com.baidu.wallet.utils.compress;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.view.Surface;
import androidx.lifecycle.CoroutineLiveDataKt;
import java.nio.ByteBuffer;

public class a implements SurfaceTexture.OnFrameAvailableListener {
    public static final int a = 12610;
    public EGLDisplay b = EGL14.EGL_NO_DISPLAY;
    public EGLContext c = EGL14.EGL_NO_CONTEXT;
    public EGLSurface d = EGL14.EGL_NO_SURFACE;
    public SurfaceTexture e;
    public Surface f;
    public Surface g;
    public final Object h = new Object();

    /* renamed from: i  reason: collision with root package name */
    public boolean f3652i;
    public ByteBuffer j;
    public c k;

    public a(Surface surface) {
        if (surface != null) {
            this.f = surface;
            i();
            return;
        }
        throw null;
    }

    private void i() {
        EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
        this.b = eglGetDisplay;
        if (eglGetDisplay != EGL14.EGL_NO_DISPLAY) {
            int[] iArr = new int[2];
            if (EGL14.eglInitialize(eglGetDisplay, iArr, 0, iArr, 1)) {
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                EGL14.eglChooseConfig(this.b, new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, a, 1, 12344}, 0, eGLConfigArr, 0, 1, new int[1], 0);
                b("eglCreateContext RGB888+recordable ES2");
                this.c = EGL14.eglCreateContext(this.b, eGLConfigArr[0], EGL14.EGL_NO_CONTEXT, new int[]{12440, 2, 12344}, 0);
                b("eglCreateContext");
                this.d = EGL14.eglCreateWindowSurface(this.b, eGLConfigArr[0], this.f, new int[]{12344}, 0);
                b("eglCreateWindowSurface");
                return;
            }
            throw new RuntimeException("unable to initialize EGL14");
        }
        throw new RuntimeException("unable to get EGL14 display");
    }

    public void a() {
        c cVar = new c();
        this.k = cVar;
        cVar.b();
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.k.a());
        this.e = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(this);
        this.g = new Surface(this.e);
    }

    public SurfaceTexture b() {
        return this.e;
    }

    public void c() {
        synchronized (this.h) {
            while (!this.f3652i) {
                try {
                    this.h.wait(CoroutineLiveDataKt.DEFAULT_TIMEOUT);
                    if (!this.f3652i) {
                        throw new RuntimeException("Surface frame wait timed out");
                    }
                } catch (InterruptedException e2) {
                    throw new RuntimeException(e2);
                }
            }
            this.f3652i = false;
        }
        this.k.b("before updateTexImage");
        this.e.updateTexImage();
    }

    public void d() {
        this.k.a(this.e);
    }

    public Surface e() {
        return this.g;
    }

    public void f() {
        EGLDisplay eGLDisplay = this.b;
        if (eGLDisplay != EGL14.EGL_NO_DISPLAY) {
            EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
            EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
            EGL14.eglDestroySurface(this.b, this.d);
            EGL14.eglDestroyContext(this.b, this.c);
            EGL14.eglReleaseThread();
            EGL14.eglTerminate(this.b);
        }
        this.f.release();
        this.b = EGL14.EGL_NO_DISPLAY;
        this.c = EGL14.EGL_NO_CONTEXT;
        this.d = EGL14.EGL_NO_SURFACE;
        this.f = null;
    }

    public void g() {
        EGLDisplay eGLDisplay = this.b;
        EGLSurface eGLSurface = this.d;
        EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.c);
        b("eglMakeCurrent");
    }

    public boolean h() {
        boolean eglSwapBuffers = EGL14.eglSwapBuffers(this.b, this.d);
        b("eglSwapBuffers");
        return eglSwapBuffers;
    }

    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        synchronized (this.h) {
            if (!this.f3652i) {
                this.f3652i = true;
                this.h.notifyAll();
            } else {
                throw new RuntimeException("mFrameAvailable already set, frame could be dropped");
            }
        }
    }

    private void b(String str) {
        int eglGetError = EGL14.eglGetError();
        if (eglGetError != 12288) {
            throw new RuntimeException(str + ": EGL error: 0x" + Integer.toHexString(eglGetError));
        }
    }

    public void a(String str) {
        this.k.a(str);
    }

    public void a(long j2) {
        EGLExt.eglPresentationTimeANDROID(this.b, this.d, j2);
        b("eglPresentationTimeANDROID");
    }
}
