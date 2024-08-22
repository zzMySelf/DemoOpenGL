package yj.qw.qw.qw.qw;

import android.graphics.Bitmap;
import android.opengl.GLSurfaceView;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL10;
import jp.co.cyberagent.android.gpuimage.GPUImageNativeLibrary;

public class ad {

    /* renamed from: ad  reason: collision with root package name */
    public int f11085ad;

    /* renamed from: de  reason: collision with root package name */
    public int f11086de;

    /* renamed from: fe  reason: collision with root package name */
    public Bitmap f11087fe;

    /* renamed from: i  reason: collision with root package name */
    public EGLContext f11088i;

    /* renamed from: if  reason: not valid java name */
    public String f522if = Thread.currentThread().getName();

    /* renamed from: o  reason: collision with root package name */
    public EGLSurface f11089o;

    /* renamed from: pf  reason: collision with root package name */
    public GL10 f11090pf = ((GL10) this.f11088i.getGL());
    public GLSurfaceView.Renderer qw;

    /* renamed from: rg  reason: collision with root package name */
    public EGL10 f11091rg;

    /* renamed from: th  reason: collision with root package name */
    public EGLDisplay f11092th;

    /* renamed from: uk  reason: collision with root package name */
    public EGLConfig f11093uk;

    /* renamed from: yj  reason: collision with root package name */
    public EGLConfig[] f11094yj;

    public ad(int i2, int i3) {
        this.f11085ad = i2;
        this.f11086de = i3;
        int[] iArr = {12375, i2, 12374, i3, 12344};
        EGL10 egl10 = (EGL10) EGLContext.getEGL();
        this.f11091rg = egl10;
        EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        this.f11092th = eglGetDisplay;
        this.f11091rg.eglInitialize(eglGetDisplay, new int[2]);
        EGLConfig qw2 = qw();
        this.f11093uk = qw2;
        this.f11088i = this.f11091rg.eglCreateContext(this.f11092th, qw2, EGL10.EGL_NO_CONTEXT, new int[]{12440, 2, 12344});
        EGLSurface eglCreatePbufferSurface = this.f11091rg.eglCreatePbufferSurface(this.f11092th, this.f11093uk, iArr);
        this.f11089o = eglCreatePbufferSurface;
        this.f11091rg.eglMakeCurrent(this.f11092th, eglCreatePbufferSurface, eglCreatePbufferSurface, this.f11088i);
    }

    public final void ad() {
        Bitmap createBitmap = Bitmap.createBitmap(this.f11085ad, this.f11086de, Bitmap.Config.ARGB_8888);
        this.f11087fe = createBitmap;
        GPUImageNativeLibrary.adjustBitmap(createBitmap);
    }

    public void de() {
        this.qw.onDrawFrame(this.f11090pf);
        this.qw.onDrawFrame(this.f11090pf);
        EGL10 egl10 = this.f11091rg;
        EGLDisplay eGLDisplay = this.f11092th;
        EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
        egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
        this.f11091rg.eglDestroySurface(this.f11092th, this.f11089o);
        this.f11091rg.eglDestroyContext(this.f11092th, this.f11088i);
        this.f11091rg.eglTerminate(this.f11092th);
    }

    public Bitmap fe() {
        if (this.qw == null || !Thread.currentThread().getName().equals(this.f522if)) {
            return null;
        }
        this.qw.onDrawFrame(this.f11090pf);
        this.qw.onDrawFrame(this.f11090pf);
        ad();
        return this.f11087fe;
    }

    public final EGLConfig qw() {
        int[] iArr = new int[1];
        int[] iArr2 = {12325, 0, 12326, 0, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12344};
        int[] iArr3 = iArr;
        this.f11091rg.eglChooseConfig(this.f11092th, iArr2, (EGLConfig[]) null, 0, iArr3);
        int i2 = iArr[0];
        EGLConfig[] eGLConfigArr = new EGLConfig[i2];
        this.f11094yj = eGLConfigArr;
        this.f11091rg.eglChooseConfig(this.f11092th, iArr2, eGLConfigArr, i2, iArr3);
        return this.f11094yj[0];
    }

    public void rg(GLSurfaceView.Renderer renderer) {
        this.qw = renderer;
        if (Thread.currentThread().getName().equals(this.f522if)) {
            this.qw.onSurfaceCreated(this.f11090pf, this.f11093uk);
            this.qw.onSurfaceChanged(this.f11090pf, this.f11085ad, this.f11086de);
        }
    }
}
