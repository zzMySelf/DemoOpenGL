package jp.co.cyberagent.android.gpuimage;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLDebugHelper;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.View;
import java.io.Writer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;
import javax.microedition.khronos.opengles.GL10;

public class GLTextureView extends TextureView implements TextureView.SurfaceTextureListener, View.OnLayoutChangeListener {
    public static final int DEBUG_CHECK_GL_ERROR = 1;
    public static final int DEBUG_LOG_GL_CALLS = 2;
    public static final boolean LOG_ATTACH_DETACH = false;
    public static final boolean LOG_EGL = false;
    public static final boolean LOG_PAUSE_RESUME = false;
    public static final boolean LOG_RENDERER = false;
    public static final boolean LOG_RENDERER_DRAW_FRAME = false;
    public static final boolean LOG_SURFACE = false;
    public static final boolean LOG_THREADS = false;
    public static final int RENDERMODE_CONTINUOUSLY = 1;
    public static final int RENDERMODE_WHEN_DIRTY = 0;
    public static final String TAG = GLTextureView.class.getSimpleName();
    public static final uk glThreadManager = new uk();
    public int debugFlags;
    public boolean detached;
    public EGLConfigChooser eglConfigChooser;
    public int eglContextClientVersion;
    public EGLContextFactory eglContextFactory;
    public EGLWindowSurfaceFactory eglWindowSurfaceFactory;
    public yj glThread;
    public GLWrapper glWrapper;
    public final WeakReference<GLTextureView> mThisWeakRef = new WeakReference<>(this);
    public boolean preserveEGLContextOnPause;
    public Renderer renderer;
    public List<TextureView.SurfaceTextureListener> surfaceTextureListeners = new ArrayList();

    public interface EGLConfigChooser {
        EGLConfig qw(EGL10 egl10, EGLDisplay eGLDisplay);
    }

    public interface EGLContextFactory {
        EGLContext ad(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig);

        void qw(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext);
    }

    public interface EGLWindowSurfaceFactory {
        EGLSurface ad(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj);

        void qw(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface);
    }

    public interface GLWrapper {
        GL qw(GL gl);
    }

    public interface Renderer {
        void onDrawFrame(GL10 gl10);

        void onSurfaceChanged(GL10 gl10, int i2, int i3);

        void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig);
    }

    public abstract class ad implements EGLConfigChooser {
        public int[] qw;

        public ad(int[] iArr) {
            this.qw = de(iArr);
        }

        public abstract EGLConfig ad(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        public final int[] de(int[] iArr) {
            if (GLTextureView.this.eglContextClientVersion != 2) {
                return iArr;
            }
            int length = iArr.length;
            int[] iArr2 = new int[(length + 2)];
            int i2 = length - 1;
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            iArr2[i2] = 12352;
            iArr2[length] = 4;
            iArr2[length + 1] = 12344;
            return iArr2;
        }

        public EGLConfig qw(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (egl10.eglChooseConfig(eGLDisplay, this.qw, (EGLConfig[]) null, 0, iArr)) {
                int i2 = iArr[0];
                if (i2 > 0) {
                    EGLConfig[] eGLConfigArr = new EGLConfig[i2];
                    if (egl10.eglChooseConfig(eGLDisplay, this.qw, eGLConfigArr, i2, iArr)) {
                        EGLConfig ad2 = ad(egl10, eGLDisplay, eGLConfigArr);
                        if (ad2 != null) {
                            return ad2;
                        }
                        throw new IllegalArgumentException("No config chosen");
                    }
                    throw new IllegalArgumentException("eglChooseConfig#2 failed");
                }
                throw new IllegalArgumentException("No configs match configSpec");
            }
            throw new IllegalArgumentException("eglChooseConfig failed");
        }
    }

    public class de extends ad {

        /* renamed from: de  reason: collision with root package name */
        public int[] f10368de = new int[1];

        /* renamed from: fe  reason: collision with root package name */
        public int f10369fe;

        /* renamed from: i  reason: collision with root package name */
        public int f10370i;

        /* renamed from: rg  reason: collision with root package name */
        public int f10372rg;

        /* renamed from: th  reason: collision with root package name */
        public int f10373th;

        /* renamed from: uk  reason: collision with root package name */
        public int f10374uk;

        /* renamed from: yj  reason: collision with root package name */
        public int f10375yj;

        public de(int i2, int i3, int i4, int i5, int i6, int i7) {
            super(new int[]{12324, i2, 12323, i3, 12322, i4, 12321, i5, 12325, i6, 12326, i7, 12344});
            this.f10369fe = i2;
            this.f10372rg = i3;
            this.f10373th = i4;
            this.f10375yj = i5;
            this.f10374uk = i6;
            this.f10370i = i7;
        }

        public EGLConfig ad(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            for (EGLConfig eGLConfig : eGLConfigArr) {
                EGL10 egl102 = egl10;
                EGLDisplay eGLDisplay2 = eGLDisplay;
                EGLConfig eGLConfig2 = eGLConfig;
                int fe2 = fe(egl102, eGLDisplay2, eGLConfig2, 12325, 0);
                int fe3 = fe(egl102, eGLDisplay2, eGLConfig2, 12326, 0);
                if (fe2 >= this.f10374uk && fe3 >= this.f10370i) {
                    EGL10 egl103 = egl10;
                    EGLDisplay eGLDisplay3 = eGLDisplay;
                    EGLConfig eGLConfig3 = eGLConfig;
                    int fe4 = fe(egl103, eGLDisplay3, eGLConfig3, 12324, 0);
                    int fe5 = fe(egl103, eGLDisplay3, eGLConfig3, 12323, 0);
                    int fe6 = fe(egl103, eGLDisplay3, eGLConfig3, 12322, 0);
                    int fe7 = fe(egl103, eGLDisplay3, eGLConfig3, 12321, 0);
                    if (fe4 == this.f10369fe && fe5 == this.f10372rg && fe6 == this.f10373th && fe7 == this.f10375yj) {
                        return eGLConfig;
                    }
                }
            }
            return null;
        }

        public final int fe(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i2, int i3) {
            return egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i2, this.f10368de) ? this.f10368de[0] : i3;
        }
    }

    public class fe implements EGLContextFactory {
        public int qw;

        public fe() {
            this.qw = 12440;
        }

        public EGLContext ad(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            int[] iArr = {this.qw, GLTextureView.this.eglContextClientVersion, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (GLTextureView.this.eglContextClientVersion == 0) {
                iArr = null;
            }
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        }

        public void qw(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            if (!egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                "display:" + eGLDisplay + " context: " + eGLContext;
                th.pf("eglDestroyContex", egl10.eglGetError());
                throw null;
            }
        }
    }

    public static class i extends Writer {

        /* renamed from: ad  reason: collision with root package name */
        public StringBuilder f10377ad = new StringBuilder();

        public void close() {
            qw();
        }

        public void flush() {
            qw();
        }

        public final void qw() {
            if (this.f10377ad.length() > 0) {
                this.f10377ad.toString();
                StringBuilder sb = this.f10377ad;
                sb.delete(0, sb.length());
            }
        }

        public void write(char[] cArr, int i2, int i3) {
            for (int i4 = 0; i4 < i3; i4++) {
                char c = cArr[i2 + i4];
                if (c == 10) {
                    qw();
                } else {
                    this.f10377ad.append(c);
                }
            }
        }
    }

    public class o extends de {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public o(boolean z) {
            super(8, 8, 8, 0, z ? 16 : 0, 0);
        }
    }

    public static class rg implements EGLWindowSurfaceFactory {
        public rg() {
        }

        public EGLSurface ad(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj) {
            try {
                return egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, (int[]) null);
            } catch (IllegalArgumentException unused) {
                String unused2 = GLTextureView.TAG;
                return null;
            }
        }

        public void qw(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
            egl10.eglDestroySurface(eGLDisplay, eGLSurface);
        }
    }

    public static class th {

        /* renamed from: ad  reason: collision with root package name */
        public EGL10 f10379ad;

        /* renamed from: de  reason: collision with root package name */
        public EGLDisplay f10380de;

        /* renamed from: fe  reason: collision with root package name */
        public EGLSurface f10381fe;
        public WeakReference<GLTextureView> qw;

        /* renamed from: rg  reason: collision with root package name */
        public EGLConfig f10382rg;

        /* renamed from: th  reason: collision with root package name */
        public EGLContext f10383th;

        public th(WeakReference<GLTextureView> weakReference) {
            this.qw = weakReference;
        }

        public static void pf(String str, int i2) {
            throw new RuntimeException(th(str, i2));
        }

        public static String th(String str, int i2) {
            return str + " failed: " + i2;
        }

        public static void yj(String str, String str2, int i2) {
            th(str2, i2);
        }

        public boolean ad() {
            if (this.f10379ad == null) {
                throw new RuntimeException("egl not initialized");
            } else if (this.f10380de == null) {
                throw new RuntimeException("eglDisplay not initialized");
            } else if (this.f10382rg != null) {
                fe();
                GLTextureView gLTextureView = (GLTextureView) this.qw.get();
                if (gLTextureView != null) {
                    this.f10381fe = gLTextureView.eglWindowSurfaceFactory.ad(this.f10379ad, this.f10380de, this.f10382rg, gLTextureView.getSurfaceTexture());
                } else {
                    this.f10381fe = null;
                }
                EGLSurface eGLSurface = this.f10381fe;
                if (eGLSurface == null || eGLSurface == EGL10.EGL_NO_SURFACE) {
                    int eglGetError = this.f10379ad.eglGetError();
                    return false;
                } else if (this.f10379ad.eglMakeCurrent(this.f10380de, eGLSurface, eGLSurface, this.f10383th)) {
                    return true;
                } else {
                    yj("EGLHelper", "eglMakeCurrent", this.f10379ad.eglGetError());
                    return false;
                }
            } else {
                throw new RuntimeException("eglConfig not initialized");
            }
        }

        public void de() {
            fe();
        }

        public final void fe() {
            EGLSurface eGLSurface;
            EGLSurface eGLSurface2 = this.f10381fe;
            if (eGLSurface2 != null && eGLSurface2 != (eGLSurface = EGL10.EGL_NO_SURFACE)) {
                this.f10379ad.eglMakeCurrent(this.f10380de, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
                GLTextureView gLTextureView = (GLTextureView) this.qw.get();
                if (gLTextureView != null) {
                    gLTextureView.eglWindowSurfaceFactory.qw(this.f10379ad, this.f10380de, this.f10381fe);
                }
                this.f10381fe = null;
            }
        }

        public int i() {
            if (!this.f10379ad.eglSwapBuffers(this.f10380de, this.f10381fe)) {
                return this.f10379ad.eglGetError();
            }
            return 12288;
        }

        public final void o(String str) {
            pf(str, this.f10379ad.eglGetError());
            throw null;
        }

        public GL qw() {
            GL gl = this.f10383th.getGL();
            GLTextureView gLTextureView = (GLTextureView) this.qw.get();
            if (gLTextureView == null) {
                return gl;
            }
            if (gLTextureView.glWrapper != null) {
                gl = gLTextureView.glWrapper.qw(gl);
            }
            if ((gLTextureView.debugFlags & 3) == 0) {
                return gl;
            }
            int i2 = 0;
            i iVar = null;
            if ((gLTextureView.debugFlags & 1) != 0) {
                i2 = 1;
            }
            if ((gLTextureView.debugFlags & 2) != 0) {
                iVar = new i();
            }
            return GLDebugHelper.wrap(gl, i2, iVar);
        }

        public void rg() {
            if (this.f10383th != null) {
                GLTextureView gLTextureView = (GLTextureView) this.qw.get();
                if (gLTextureView != null) {
                    gLTextureView.eglContextFactory.qw(this.f10379ad, this.f10380de, this.f10383th);
                }
                this.f10383th = null;
            }
            EGLDisplay eGLDisplay = this.f10380de;
            if (eGLDisplay != null) {
                this.f10379ad.eglTerminate(eGLDisplay);
                this.f10380de = null;
            }
        }

        public void uk() {
            EGL10 egl10 = (EGL10) EGLContext.getEGL();
            this.f10379ad = egl10;
            EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            this.f10380de = eglGetDisplay;
            if (eglGetDisplay != EGL10.EGL_NO_DISPLAY) {
                if (this.f10379ad.eglInitialize(eglGetDisplay, new int[2])) {
                    GLTextureView gLTextureView = (GLTextureView) this.qw.get();
                    if (gLTextureView == null) {
                        this.f10382rg = null;
                        this.f10383th = null;
                    } else {
                        this.f10382rg = gLTextureView.eglConfigChooser.qw(this.f10379ad, this.f10380de);
                        this.f10383th = gLTextureView.eglContextFactory.ad(this.f10379ad, this.f10380de, this.f10382rg);
                    }
                    EGLContext eGLContext = this.f10383th;
                    if (eGLContext == null || eGLContext == EGL10.EGL_NO_CONTEXT) {
                        this.f10383th = null;
                        o("createContext");
                        throw null;
                    }
                    this.f10381fe = null;
                    return;
                }
                throw new RuntimeException("eglInitialize failed");
            }
            throw new RuntimeException("eglGetDisplay failed");
        }
    }

    public static class uk {

        /* renamed from: ad  reason: collision with root package name */
        public int f10384ad;

        /* renamed from: de  reason: collision with root package name */
        public boolean f10385de;

        /* renamed from: fe  reason: collision with root package name */
        public boolean f10386fe;
        public boolean qw;

        /* renamed from: rg  reason: collision with root package name */
        public boolean f10387rg;

        /* renamed from: th  reason: collision with root package name */
        public yj f10388th;

        public uk() {
        }

        public final void ad() {
            if (!this.qw) {
                this.qw = true;
            }
        }

        public void de(yj yjVar) {
            if (this.f10388th == yjVar) {
                this.f10388th = null;
            }
            notifyAll();
        }

        public synchronized boolean fe() {
            return this.f10387rg;
        }

        public synchronized void qw(GL10 gl10) {
            if (!this.f10385de) {
                ad();
                String glGetString = gl10.glGetString(7937);
                boolean z = false;
                if (this.f10384ad < 131072) {
                    this.f10386fe = !glGetString.startsWith("Q3Dimension MSM7500 ");
                    notifyAll();
                }
                if (!this.f10386fe) {
                    z = true;
                }
                this.f10387rg = z;
                this.f10385de = true;
            }
        }

        public synchronized boolean rg() {
            ad();
            return !this.f10386fe;
        }

        public synchronized void th(yj yjVar) {
            boolean unused = yjVar.f10393th = true;
            if (this.f10388th == yjVar) {
                this.f10388th = null;
            }
            notifyAll();
        }

        public boolean yj(yj yjVar) {
            yj yjVar2 = this.f10388th;
            if (yjVar2 == yjVar || yjVar2 == null) {
                this.f10388th = yjVar;
                notifyAll();
                return true;
            }
            ad();
            if (this.f10386fe) {
                return true;
            }
            yj yjVar3 = this.f10388th;
            if (yjVar3 == null) {
                return false;
            }
            yjVar3.pf();
            return false;
        }
    }

    public static class yj extends Thread {
        public th aaa;

        /* renamed from: ad  reason: collision with root package name */
        public boolean f10389ad;
        public boolean ddd;
        public int ggg = 0;

        /* renamed from: i  reason: collision with root package name */
        public boolean f10390i;

        /* renamed from: if  reason: not valid java name */
        public boolean f489if;
        public boolean mmm = true;
        public ArrayList<Runnable> nn = new ArrayList<>();

        /* renamed from: o  reason: collision with root package name */
        public boolean f10391o;

        /* renamed from: pf  reason: collision with root package name */
        public boolean f10392pf;
        public int ppp = 0;
        public WeakReference<GLTextureView> qqq;

        /* renamed from: switch  reason: not valid java name */
        public boolean f490switch;

        /* renamed from: th  reason: collision with root package name */
        public boolean f10393th;

        /* renamed from: uk  reason: collision with root package name */
        public boolean f10394uk;
        public int vvv = 1;
        public boolean when;
        public boolean xxx = true;

        /* renamed from: yj  reason: collision with root package name */
        public boolean f10395yj;

        public yj(WeakReference<GLTextureView> weakReference) {
            this.qqq = weakReference;
        }

        public int de() {
            int i2;
            synchronized (GLTextureView.glThreadManager) {
                i2 = this.vvv;
            }
            return i2;
        }

        /* JADX WARNING: type inference failed for: r2v24, types: [javax.microedition.khronos.opengles.GL] */
        /* JADX WARNING: Code restructure failed: missing block: B:100:0x0164, code lost:
            r2 = jp.co.cyberagent.android.gpuimage.GLTextureView.access$900();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:101:0x0168, code lost:
            monitor-enter(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:104:?, code lost:
            r1.f10391o = true;
            jp.co.cyberagent.android.gpuimage.GLTextureView.access$900().notifyAll();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:105:0x0173, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:111:0x0179, code lost:
            r8 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:112:0x017a, code lost:
            if (r9 == false) goto L_0x018d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:113:0x017c, code lost:
            r6 = r1.aaa.qw();
            jp.co.cyberagent.android.gpuimage.GLTextureView.access$900().qw(r6);
            r9 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:114:0x018d, code lost:
            if (r7 == false) goto L_0x01a5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:115:0x018f, code lost:
            r2 = (jp.co.cyberagent.android.gpuimage.GLTextureView) r1.qqq.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:116:0x0197, code lost:
            if (r2 == null) goto L_0x01a4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:117:0x0199, code lost:
            jp.co.cyberagent.android.gpuimage.GLTextureView.access$1100(r2).onSurfaceCreated(r6, r1.aaa.f10382rg);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:118:0x01a4, code lost:
            r7 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:119:0x01a5, code lost:
            if (r10 == false) goto L_0x01b9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:120:0x01a7, code lost:
            r2 = (jp.co.cyberagent.android.gpuimage.GLTextureView) r1.qqq.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:121:0x01af, code lost:
            if (r2 == null) goto L_0x01b8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:122:0x01b1, code lost:
            jp.co.cyberagent.android.gpuimage.GLTextureView.access$1100(r2).onSurfaceChanged(r6, r11, r12);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:123:0x01b8, code lost:
            r10 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:124:0x01b9, code lost:
            r2 = (jp.co.cyberagent.android.gpuimage.GLTextureView) r1.qqq.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:125:0x01c1, code lost:
            if (r2 == null) goto L_0x01ca;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:126:0x01c3, code lost:
            jp.co.cyberagent.android.gpuimage.GLTextureView.access$1100(r2).onDrawFrame(r6);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:127:0x01ca, code lost:
            r2 = r1.aaa.i();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:128:0x01d2, code lost:
            if (r2 == 12288) goto L_0x01f6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:130:0x01d6, code lost:
            if (r2 == 12302) goto L_0x01f3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:131:0x01d8, code lost:
            jp.co.cyberagent.android.gpuimage.GLTextureView.th.yj("GLThread", "eglSwapBuffers", r2);
            r2 = jp.co.cyberagent.android.gpuimage.GLTextureView.access$900();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:132:0x01e3, code lost:
            monitor-enter(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:135:?, code lost:
            r1.f10391o = true;
            jp.co.cyberagent.android.gpuimage.GLTextureView.access$900().notifyAll();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:136:0x01ee, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:142:0x01f3, code lost:
            r3 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:144:0x01f7, code lost:
            if (r13 == false) goto L_0x01fa;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:145:0x01f9, code lost:
            r4 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:94:0x0153, code lost:
            if (r14 == null) goto L_0x015a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:97:0x015a, code lost:
            if (r8 == false) goto L_0x017a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:99:0x0162, code lost:
            if (r1.aaa.ad() != false) goto L_0x0179;
         */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void fe() throws java.lang.InterruptedException {
            /*
                r16 = this;
                r1 = r16
                jp.co.cyberagent.android.gpuimage.GLTextureView$th r0 = new jp.co.cyberagent.android.gpuimage.GLTextureView$th
                java.lang.ref.WeakReference<jp.co.cyberagent.android.gpuimage.GLTextureView> r2 = r1.qqq
                r0.<init>(r2)
                r1.aaa = r0
                r0 = 0
                r1.f489if = r0
                r1.f490switch = r0
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
            L_0x001b:
                r14 = 0
            L_0x001c:
                jp.co.cyberagent.android.gpuimage.GLTextureView$uk r15 = jp.co.cyberagent.android.gpuimage.GLTextureView.glThreadManager     // Catch:{ all -> 0x020a }
                monitor-enter(r15)     // Catch:{ all -> 0x020a }
            L_0x0021:
                boolean r2 = r1.f10389ad     // Catch:{ all -> 0x0207 }
                if (r2 == 0) goto L_0x0036
                monitor-exit(r15)     // Catch:{ all -> 0x0207 }
                jp.co.cyberagent.android.gpuimage.GLTextureView$uk r2 = jp.co.cyberagent.android.gpuimage.GLTextureView.glThreadManager
                monitor-enter(r2)
                r16.ppp()     // Catch:{ all -> 0x0033 }
                r16.when()     // Catch:{ all -> 0x0033 }
                monitor-exit(r2)     // Catch:{ all -> 0x0033 }
                return
            L_0x0033:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x0033 }
                throw r0
            L_0x0036:
                java.util.ArrayList<java.lang.Runnable> r2 = r1.nn     // Catch:{ all -> 0x0207 }
                boolean r2 = r2.isEmpty()     // Catch:{ all -> 0x0207 }
                if (r2 != 0) goto L_0x004b
                java.util.ArrayList<java.lang.Runnable> r2 = r1.nn     // Catch:{ all -> 0x0207 }
                r14 = 0
                java.lang.Object r2 = r2.remove(r14)     // Catch:{ all -> 0x0207 }
                r14 = r2
                java.lang.Runnable r14 = (java.lang.Runnable) r14     // Catch:{ all -> 0x0207 }
                r0 = 0
                goto L_0x0152
            L_0x004b:
                boolean r2 = r1.f10394uk     // Catch:{ all -> 0x0207 }
                boolean r0 = r1.f10395yj     // Catch:{ all -> 0x0207 }
                if (r2 == r0) goto L_0x005f
                boolean r0 = r1.f10395yj     // Catch:{ all -> 0x0207 }
                boolean r2 = r1.f10395yj     // Catch:{ all -> 0x0207 }
                r1.f10394uk = r2     // Catch:{ all -> 0x0207 }
                jp.co.cyberagent.android.gpuimage.GLTextureView$uk r2 = jp.co.cyberagent.android.gpuimage.GLTextureView.glThreadManager     // Catch:{ all -> 0x0207 }
                r2.notifyAll()     // Catch:{ all -> 0x0207 }
                goto L_0x0060
            L_0x005f:
                r0 = 0
            L_0x0060:
                boolean r2 = r1.when     // Catch:{ all -> 0x0207 }
                if (r2 == 0) goto L_0x006e
                r16.ppp()     // Catch:{ all -> 0x0207 }
                r16.when()     // Catch:{ all -> 0x0207 }
                r2 = 0
                r1.when = r2     // Catch:{ all -> 0x0207 }
                r5 = 1
            L_0x006e:
                if (r3 == 0) goto L_0x0077
                r16.ppp()     // Catch:{ all -> 0x0207 }
                r16.when()     // Catch:{ all -> 0x0207 }
                r3 = 0
            L_0x0077:
                if (r0 == 0) goto L_0x0080
                boolean r2 = r1.f490switch     // Catch:{ all -> 0x0207 }
                if (r2 == 0) goto L_0x0080
                r16.ppp()     // Catch:{ all -> 0x0207 }
            L_0x0080:
                if (r0 == 0) goto L_0x00a5
                boolean r2 = r1.f489if     // Catch:{ all -> 0x0207 }
                if (r2 == 0) goto L_0x00a5
                java.lang.ref.WeakReference<jp.co.cyberagent.android.gpuimage.GLTextureView> r2 = r1.qqq     // Catch:{ all -> 0x0207 }
                java.lang.Object r2 = r2.get()     // Catch:{ all -> 0x0207 }
                jp.co.cyberagent.android.gpuimage.GLTextureView r2 = (jp.co.cyberagent.android.gpuimage.GLTextureView) r2     // Catch:{ all -> 0x0207 }
                if (r2 != 0) goto L_0x0092
                r2 = 0
                goto L_0x0096
            L_0x0092:
                boolean r2 = r2.preserveEGLContextOnPause     // Catch:{ all -> 0x0207 }
            L_0x0096:
                if (r2 == 0) goto L_0x00a2
                jp.co.cyberagent.android.gpuimage.GLTextureView$uk r2 = jp.co.cyberagent.android.gpuimage.GLTextureView.glThreadManager     // Catch:{ all -> 0x0207 }
                boolean r2 = r2.fe()     // Catch:{ all -> 0x0207 }
                if (r2 == 0) goto L_0x00a5
            L_0x00a2:
                r16.when()     // Catch:{ all -> 0x0207 }
            L_0x00a5:
                if (r0 == 0) goto L_0x00b6
                jp.co.cyberagent.android.gpuimage.GLTextureView$uk r0 = jp.co.cyberagent.android.gpuimage.GLTextureView.glThreadManager     // Catch:{ all -> 0x0207 }
                boolean r0 = r0.rg()     // Catch:{ all -> 0x0207 }
                if (r0 == 0) goto L_0x00b6
                jp.co.cyberagent.android.gpuimage.GLTextureView$th r0 = r1.aaa     // Catch:{ all -> 0x0207 }
                r0.rg()     // Catch:{ all -> 0x0207 }
            L_0x00b6:
                boolean r0 = r1.f10390i     // Catch:{ all -> 0x0207 }
                if (r0 != 0) goto L_0x00d2
                boolean r0 = r1.f10392pf     // Catch:{ all -> 0x0207 }
                if (r0 != 0) goto L_0x00d2
                boolean r0 = r1.f490switch     // Catch:{ all -> 0x0207 }
                if (r0 == 0) goto L_0x00c5
                r16.ppp()     // Catch:{ all -> 0x0207 }
            L_0x00c5:
                r0 = 1
                r1.f10392pf = r0     // Catch:{ all -> 0x0207 }
                r0 = 0
                r1.f10391o = r0     // Catch:{ all -> 0x0207 }
                jp.co.cyberagent.android.gpuimage.GLTextureView$uk r0 = jp.co.cyberagent.android.gpuimage.GLTextureView.glThreadManager     // Catch:{ all -> 0x0207 }
                r0.notifyAll()     // Catch:{ all -> 0x0207 }
            L_0x00d2:
                boolean r0 = r1.f10390i     // Catch:{ all -> 0x0207 }
                if (r0 == 0) goto L_0x00e4
                boolean r0 = r1.f10392pf     // Catch:{ all -> 0x0207 }
                if (r0 == 0) goto L_0x00e4
                r0 = 0
                r1.f10392pf = r0     // Catch:{ all -> 0x0207 }
                jp.co.cyberagent.android.gpuimage.GLTextureView$uk r0 = jp.co.cyberagent.android.gpuimage.GLTextureView.glThreadManager     // Catch:{ all -> 0x0207 }
                r0.notifyAll()     // Catch:{ all -> 0x0207 }
            L_0x00e4:
                if (r4 == 0) goto L_0x00f2
                r0 = 1
                r1.ddd = r0     // Catch:{ all -> 0x0207 }
                jp.co.cyberagent.android.gpuimage.GLTextureView$uk r0 = jp.co.cyberagent.android.gpuimage.GLTextureView.glThreadManager     // Catch:{ all -> 0x0207 }
                r0.notifyAll()     // Catch:{ all -> 0x0207 }
                r4 = 0
                r13 = 0
            L_0x00f2:
                boolean r0 = r16.i()     // Catch:{ all -> 0x0207 }
                if (r0 == 0) goto L_0x01fd
                boolean r0 = r1.f489if     // Catch:{ all -> 0x0207 }
                if (r0 != 0) goto L_0x0124
                if (r5 == 0) goto L_0x0100
                r5 = 0
                goto L_0x0124
            L_0x0100:
                jp.co.cyberagent.android.gpuimage.GLTextureView$uk r0 = jp.co.cyberagent.android.gpuimage.GLTextureView.glThreadManager     // Catch:{ all -> 0x0207 }
                boolean r0 = r0.yj(r1)     // Catch:{ all -> 0x0207 }
                if (r0 == 0) goto L_0x0124
                jp.co.cyberagent.android.gpuimage.GLTextureView$th r0 = r1.aaa     // Catch:{ RuntimeException -> 0x011b }
                r0.uk()     // Catch:{ RuntimeException -> 0x011b }
                r0 = 1
                r1.f489if = r0     // Catch:{ all -> 0x0207 }
                jp.co.cyberagent.android.gpuimage.GLTextureView$uk r0 = jp.co.cyberagent.android.gpuimage.GLTextureView.glThreadManager     // Catch:{ all -> 0x0207 }
                r0.notifyAll()     // Catch:{ all -> 0x0207 }
                r7 = 1
                goto L_0x0124
            L_0x011b:
                r0 = move-exception
                jp.co.cyberagent.android.gpuimage.GLTextureView$uk r2 = jp.co.cyberagent.android.gpuimage.GLTextureView.glThreadManager     // Catch:{ all -> 0x0207 }
                r2.de(r1)     // Catch:{ all -> 0x0207 }
                throw r0     // Catch:{ all -> 0x0207 }
            L_0x0124:
                boolean r0 = r1.f489if     // Catch:{ all -> 0x0207 }
                if (r0 == 0) goto L_0x0132
                boolean r0 = r1.f490switch     // Catch:{ all -> 0x0207 }
                if (r0 != 0) goto L_0x0132
                r0 = 1
                r1.f490switch = r0     // Catch:{ all -> 0x0207 }
                r8 = 1
                r9 = 1
                r10 = 1
            L_0x0132:
                boolean r0 = r1.f490switch     // Catch:{ all -> 0x0207 }
                if (r0 == 0) goto L_0x01fd
                boolean r0 = r1.mmm     // Catch:{ all -> 0x0207 }
                if (r0 == 0) goto L_0x0148
                int r0 = r1.ppp     // Catch:{ all -> 0x0207 }
                int r2 = r1.ggg     // Catch:{ all -> 0x0207 }
                r8 = 0
                r1.mmm = r8     // Catch:{ all -> 0x0207 }
                r11 = r0
                r12 = r2
                r0 = 0
                r8 = 1
                r10 = 1
                r13 = 1
                goto L_0x0149
            L_0x0148:
                r0 = 0
            L_0x0149:
                r1.xxx = r0     // Catch:{ all -> 0x0207 }
                jp.co.cyberagent.android.gpuimage.GLTextureView$uk r2 = jp.co.cyberagent.android.gpuimage.GLTextureView.glThreadManager     // Catch:{ all -> 0x0207 }
                r2.notifyAll()     // Catch:{ all -> 0x0207 }
            L_0x0152:
                monitor-exit(r15)     // Catch:{ all -> 0x0207 }
                if (r14 == 0) goto L_0x015a
                r14.run()     // Catch:{ all -> 0x020a }
                goto L_0x001b
            L_0x015a:
                if (r8 == 0) goto L_0x017a
                jp.co.cyberagent.android.gpuimage.GLTextureView$th r2 = r1.aaa     // Catch:{ all -> 0x020a }
                boolean r2 = r2.ad()     // Catch:{ all -> 0x020a }
                if (r2 != 0) goto L_0x0179
                jp.co.cyberagent.android.gpuimage.GLTextureView$uk r2 = jp.co.cyberagent.android.gpuimage.GLTextureView.glThreadManager     // Catch:{ all -> 0x020a }
                monitor-enter(r2)     // Catch:{ all -> 0x020a }
                r15 = 1
                r1.f10391o = r15     // Catch:{ all -> 0x0176 }
                jp.co.cyberagent.android.gpuimage.GLTextureView$uk r15 = jp.co.cyberagent.android.gpuimage.GLTextureView.glThreadManager     // Catch:{ all -> 0x0176 }
                r15.notifyAll()     // Catch:{ all -> 0x0176 }
                monitor-exit(r2)     // Catch:{ all -> 0x0176 }
                goto L_0x001c
            L_0x0176:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x0176 }
                throw r0     // Catch:{ all -> 0x020a }
            L_0x0179:
                r8 = 0
            L_0x017a:
                if (r9 == 0) goto L_0x018d
                jp.co.cyberagent.android.gpuimage.GLTextureView$th r2 = r1.aaa     // Catch:{ all -> 0x020a }
                javax.microedition.khronos.opengles.GL r2 = r2.qw()     // Catch:{ all -> 0x020a }
                r6 = r2
                javax.microedition.khronos.opengles.GL10 r6 = (javax.microedition.khronos.opengles.GL10) r6     // Catch:{ all -> 0x020a }
                jp.co.cyberagent.android.gpuimage.GLTextureView$uk r2 = jp.co.cyberagent.android.gpuimage.GLTextureView.glThreadManager     // Catch:{ all -> 0x020a }
                r2.qw(r6)     // Catch:{ all -> 0x020a }
                r9 = 0
            L_0x018d:
                if (r7 == 0) goto L_0x01a5
                java.lang.ref.WeakReference<jp.co.cyberagent.android.gpuimage.GLTextureView> r2 = r1.qqq     // Catch:{ all -> 0x020a }
                java.lang.Object r2 = r2.get()     // Catch:{ all -> 0x020a }
                jp.co.cyberagent.android.gpuimage.GLTextureView r2 = (jp.co.cyberagent.android.gpuimage.GLTextureView) r2     // Catch:{ all -> 0x020a }
                if (r2 == 0) goto L_0x01a4
                jp.co.cyberagent.android.gpuimage.GLTextureView$Renderer r2 = r2.renderer     // Catch:{ all -> 0x020a }
                jp.co.cyberagent.android.gpuimage.GLTextureView$th r7 = r1.aaa     // Catch:{ all -> 0x020a }
                javax.microedition.khronos.egl.EGLConfig r7 = r7.f10382rg     // Catch:{ all -> 0x020a }
                r2.onSurfaceCreated(r6, r7)     // Catch:{ all -> 0x020a }
            L_0x01a4:
                r7 = 0
            L_0x01a5:
                if (r10 == 0) goto L_0x01b9
                java.lang.ref.WeakReference<jp.co.cyberagent.android.gpuimage.GLTextureView> r2 = r1.qqq     // Catch:{ all -> 0x020a }
                java.lang.Object r2 = r2.get()     // Catch:{ all -> 0x020a }
                jp.co.cyberagent.android.gpuimage.GLTextureView r2 = (jp.co.cyberagent.android.gpuimage.GLTextureView) r2     // Catch:{ all -> 0x020a }
                if (r2 == 0) goto L_0x01b8
                jp.co.cyberagent.android.gpuimage.GLTextureView$Renderer r2 = r2.renderer     // Catch:{ all -> 0x020a }
                r2.onSurfaceChanged(r6, r11, r12)     // Catch:{ all -> 0x020a }
            L_0x01b8:
                r10 = 0
            L_0x01b9:
                java.lang.ref.WeakReference<jp.co.cyberagent.android.gpuimage.GLTextureView> r2 = r1.qqq     // Catch:{ all -> 0x020a }
                java.lang.Object r2 = r2.get()     // Catch:{ all -> 0x020a }
                jp.co.cyberagent.android.gpuimage.GLTextureView r2 = (jp.co.cyberagent.android.gpuimage.GLTextureView) r2     // Catch:{ all -> 0x020a }
                if (r2 == 0) goto L_0x01ca
                jp.co.cyberagent.android.gpuimage.GLTextureView$Renderer r2 = r2.renderer     // Catch:{ all -> 0x020a }
                r2.onDrawFrame(r6)     // Catch:{ all -> 0x020a }
            L_0x01ca:
                jp.co.cyberagent.android.gpuimage.GLTextureView$th r2 = r1.aaa     // Catch:{ all -> 0x020a }
                int r2 = r2.i()     // Catch:{ all -> 0x020a }
                r15 = 12288(0x3000, float:1.7219E-41)
                if (r2 == r15) goto L_0x01f6
                r15 = 12302(0x300e, float:1.7239E-41)
                if (r2 == r15) goto L_0x01f3
                java.lang.String r15 = "GLThread"
                java.lang.String r0 = "eglSwapBuffers"
                jp.co.cyberagent.android.gpuimage.GLTextureView.th.yj(r15, r0, r2)     // Catch:{ all -> 0x020a }
                jp.co.cyberagent.android.gpuimage.GLTextureView$uk r2 = jp.co.cyberagent.android.gpuimage.GLTextureView.glThreadManager     // Catch:{ all -> 0x020a }
                monitor-enter(r2)     // Catch:{ all -> 0x020a }
                r0 = 1
                r1.f10391o = r0     // Catch:{ all -> 0x01f0 }
                jp.co.cyberagent.android.gpuimage.GLTextureView$uk r15 = jp.co.cyberagent.android.gpuimage.GLTextureView.glThreadManager     // Catch:{ all -> 0x01f0 }
                r15.notifyAll()     // Catch:{ all -> 0x01f0 }
                monitor-exit(r2)     // Catch:{ all -> 0x01f0 }
                goto L_0x01f7
            L_0x01f0:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x01f0 }
                throw r0     // Catch:{ all -> 0x020a }
            L_0x01f3:
                r0 = 1
                r3 = 1
                goto L_0x01f7
            L_0x01f6:
                r0 = 1
            L_0x01f7:
                if (r13 == 0) goto L_0x01fa
                r4 = 1
            L_0x01fa:
                r0 = 0
                goto L_0x001c
            L_0x01fd:
                jp.co.cyberagent.android.gpuimage.GLTextureView$uk r0 = jp.co.cyberagent.android.gpuimage.GLTextureView.glThreadManager     // Catch:{ all -> 0x0207 }
                r0.wait()     // Catch:{ all -> 0x0207 }
                r0 = 0
                goto L_0x0021
            L_0x0207:
                r0 = move-exception
                monitor-exit(r15)     // Catch:{ all -> 0x0207 }
                throw r0     // Catch:{ all -> 0x020a }
            L_0x020a:
                r0 = move-exception
                jp.co.cyberagent.android.gpuimage.GLTextureView$uk r2 = jp.co.cyberagent.android.gpuimage.GLTextureView.glThreadManager
                monitor-enter(r2)
                r16.ppp()     // Catch:{ all -> 0x0218 }
                r16.when()     // Catch:{ all -> 0x0218 }
                monitor-exit(r2)     // Catch:{ all -> 0x0218 }
                throw r0
            L_0x0218:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x0218 }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: jp.co.cyberagent.android.gpuimage.GLTextureView.yj.fe():void");
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(7:9|10|11|12|22|18|5) */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x000f, code lost:
            continue;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x001f */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void ggg() {
            /*
                r2 = this;
                jp.co.cyberagent.android.gpuimage.GLTextureView$uk r0 = jp.co.cyberagent.android.gpuimage.GLTextureView.glThreadManager
                monitor-enter(r0)
                r1 = 1
                r2.f10390i = r1     // Catch:{ all -> 0x0029 }
                jp.co.cyberagent.android.gpuimage.GLTextureView$uk r1 = jp.co.cyberagent.android.gpuimage.GLTextureView.glThreadManager     // Catch:{ all -> 0x0029 }
                r1.notifyAll()     // Catch:{ all -> 0x0029 }
            L_0x000f:
                boolean r1 = r2.f10392pf     // Catch:{ all -> 0x0029 }
                if (r1 == 0) goto L_0x0027
                boolean r1 = r2.f10393th     // Catch:{ all -> 0x0029 }
                if (r1 != 0) goto L_0x0027
                jp.co.cyberagent.android.gpuimage.GLTextureView$uk r1 = jp.co.cyberagent.android.gpuimage.GLTextureView.glThreadManager     // Catch:{ InterruptedException -> 0x001f }
                r1.wait()     // Catch:{ InterruptedException -> 0x001f }
                goto L_0x000f
            L_0x001f:
                java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0029 }
                r1.interrupt()     // Catch:{ all -> 0x0029 }
                goto L_0x000f
            L_0x0027:
                monitor-exit(r0)     // Catch:{ all -> 0x0029 }
                return
            L_0x0029:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0029 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: jp.co.cyberagent.android.gpuimage.GLTextureView.yj.ggg():void");
        }

        public final boolean i() {
            return !this.f10394uk && this.f10390i && !this.f10391o && this.ppp > 0 && this.ggg > 0 && (this.xxx || this.vvv == 1);
        }

        /* renamed from: if  reason: not valid java name */
        public void m1147if() {
            synchronized (GLTextureView.glThreadManager) {
                this.xxx = true;
                GLTextureView.glThreadManager.notifyAll();
            }
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(7:7|8|9|10|19|16|5) */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x000f, code lost:
            continue;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x001b */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void o() {
            /*
                r2 = this;
                jp.co.cyberagent.android.gpuimage.GLTextureView$uk r0 = jp.co.cyberagent.android.gpuimage.GLTextureView.glThreadManager
                monitor-enter(r0)
                r1 = 1
                r2.f10389ad = r1     // Catch:{ all -> 0x0025 }
                jp.co.cyberagent.android.gpuimage.GLTextureView$uk r1 = jp.co.cyberagent.android.gpuimage.GLTextureView.glThreadManager     // Catch:{ all -> 0x0025 }
                r1.notifyAll()     // Catch:{ all -> 0x0025 }
            L_0x000f:
                boolean r1 = r2.f10393th     // Catch:{ all -> 0x0025 }
                if (r1 != 0) goto L_0x0023
                jp.co.cyberagent.android.gpuimage.GLTextureView$uk r1 = jp.co.cyberagent.android.gpuimage.GLTextureView.glThreadManager     // Catch:{ InterruptedException -> 0x001b }
                r1.wait()     // Catch:{ InterruptedException -> 0x001b }
                goto L_0x000f
            L_0x001b:
                java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0025 }
                r1.interrupt()     // Catch:{ all -> 0x0025 }
                goto L_0x000f
            L_0x0023:
                monitor-exit(r0)     // Catch:{ all -> 0x0025 }
                return
            L_0x0025:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0025 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: jp.co.cyberagent.android.gpuimage.GLTextureView.yj.o():void");
        }

        public void pf() {
            this.when = true;
            GLTextureView.glThreadManager.notifyAll();
        }

        public final void ppp() {
            if (this.f490switch) {
                this.f490switch = false;
                this.aaa.de();
            }
        }

        public boolean qw() {
            return this.f489if && this.f490switch && i();
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(7:9|10|11|12|22|18|5) */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x000f, code lost:
            continue;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x001f */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void rg() {
            /*
                r2 = this;
                jp.co.cyberagent.android.gpuimage.GLTextureView$uk r0 = jp.co.cyberagent.android.gpuimage.GLTextureView.glThreadManager
                monitor-enter(r0)
                r1 = 1
                r2.f10395yj = r1     // Catch:{ all -> 0x0029 }
                jp.co.cyberagent.android.gpuimage.GLTextureView$uk r1 = jp.co.cyberagent.android.gpuimage.GLTextureView.glThreadManager     // Catch:{ all -> 0x0029 }
                r1.notifyAll()     // Catch:{ all -> 0x0029 }
            L_0x000f:
                boolean r1 = r2.f10393th     // Catch:{ all -> 0x0029 }
                if (r1 != 0) goto L_0x0027
                boolean r1 = r2.f10394uk     // Catch:{ all -> 0x0029 }
                if (r1 != 0) goto L_0x0027
                jp.co.cyberagent.android.gpuimage.GLTextureView$uk r1 = jp.co.cyberagent.android.gpuimage.GLTextureView.glThreadManager     // Catch:{ InterruptedException -> 0x001f }
                r1.wait()     // Catch:{ InterruptedException -> 0x001f }
                goto L_0x000f
            L_0x001f:
                java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0029 }
                r1.interrupt()     // Catch:{ all -> 0x0029 }
                goto L_0x000f
            L_0x0027:
                monitor-exit(r0)     // Catch:{ all -> 0x0029 }
                return
            L_0x0029:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0029 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: jp.co.cyberagent.android.gpuimage.GLTextureView.yj.rg():void");
        }

        public void run() {
            setName("GLThread " + getId());
            try {
                fe();
            } catch (InterruptedException unused) {
            } catch (Throwable th2) {
                GLTextureView.glThreadManager.th(this);
                throw th2;
            }
            GLTextureView.glThreadManager.th(this);
        }

        /* renamed from: switch  reason: not valid java name */
        public void m1148switch(int i2) {
            if (i2 < 0 || i2 > 1) {
                throw new IllegalArgumentException("renderMode");
            }
            synchronized (GLTextureView.glThreadManager) {
                this.vvv = i2;
                GLTextureView.glThreadManager.notifyAll();
            }
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(7:11|12|13|14|25|20|5) */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0014, code lost:
            continue;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0028 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void th() {
            /*
                r3 = this;
                jp.co.cyberagent.android.gpuimage.GLTextureView$uk r0 = jp.co.cyberagent.android.gpuimage.GLTextureView.glThreadManager
                monitor-enter(r0)
                r1 = 0
                r3.f10395yj = r1     // Catch:{ all -> 0x0032 }
                r2 = 1
                r3.xxx = r2     // Catch:{ all -> 0x0032 }
                r3.ddd = r1     // Catch:{ all -> 0x0032 }
                jp.co.cyberagent.android.gpuimage.GLTextureView$uk r1 = jp.co.cyberagent.android.gpuimage.GLTextureView.glThreadManager     // Catch:{ all -> 0x0032 }
                r1.notifyAll()     // Catch:{ all -> 0x0032 }
            L_0x0014:
                boolean r1 = r3.f10393th     // Catch:{ all -> 0x0032 }
                if (r1 != 0) goto L_0x0030
                boolean r1 = r3.f10394uk     // Catch:{ all -> 0x0032 }
                if (r1 == 0) goto L_0x0030
                boolean r1 = r3.ddd     // Catch:{ all -> 0x0032 }
                if (r1 != 0) goto L_0x0030
                jp.co.cyberagent.android.gpuimage.GLTextureView$uk r1 = jp.co.cyberagent.android.gpuimage.GLTextureView.glThreadManager     // Catch:{ InterruptedException -> 0x0028 }
                r1.wait()     // Catch:{ InterruptedException -> 0x0028 }
                goto L_0x0014
            L_0x0028:
                java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0032 }
                r1.interrupt()     // Catch:{ all -> 0x0032 }
                goto L_0x0014
            L_0x0030:
                monitor-exit(r0)     // Catch:{ all -> 0x0032 }
                return
            L_0x0032:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0032 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: jp.co.cyberagent.android.gpuimage.GLTextureView.yj.th():void");
        }

        public void uk(Runnable runnable) {
            if (runnable != null) {
                synchronized (GLTextureView.glThreadManager) {
                    this.nn.add(runnable);
                    GLTextureView.glThreadManager.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("r must not be null");
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(7:9|10|11|12|22|18|5) */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x000f, code lost:
            continue;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x001f */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void vvv() {
            /*
                r2 = this;
                jp.co.cyberagent.android.gpuimage.GLTextureView$uk r0 = jp.co.cyberagent.android.gpuimage.GLTextureView.glThreadManager
                monitor-enter(r0)
                r1 = 0
                r2.f10390i = r1     // Catch:{ all -> 0x0029 }
                jp.co.cyberagent.android.gpuimage.GLTextureView$uk r1 = jp.co.cyberagent.android.gpuimage.GLTextureView.glThreadManager     // Catch:{ all -> 0x0029 }
                r1.notifyAll()     // Catch:{ all -> 0x0029 }
            L_0x000f:
                boolean r1 = r2.f10392pf     // Catch:{ all -> 0x0029 }
                if (r1 != 0) goto L_0x0027
                boolean r1 = r2.f10393th     // Catch:{ all -> 0x0029 }
                if (r1 != 0) goto L_0x0027
                jp.co.cyberagent.android.gpuimage.GLTextureView$uk r1 = jp.co.cyberagent.android.gpuimage.GLTextureView.glThreadManager     // Catch:{ InterruptedException -> 0x001f }
                r1.wait()     // Catch:{ InterruptedException -> 0x001f }
                goto L_0x000f
            L_0x001f:
                java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0029 }
                r1.interrupt()     // Catch:{ all -> 0x0029 }
                goto L_0x000f
            L_0x0027:
                monitor-exit(r0)     // Catch:{ all -> 0x0029 }
                return
            L_0x0029:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0029 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: jp.co.cyberagent.android.gpuimage.GLTextureView.yj.vvv():void");
        }

        public final void when() {
            if (this.f489if) {
                this.aaa.rg();
                this.f489if = false;
                GLTextureView.glThreadManager.de(this);
            }
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(7:12|13|14|15|27|21|4) */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0018, code lost:
            continue;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x0032 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void yj(int r2, int r3) {
            /*
                r1 = this;
                jp.co.cyberagent.android.gpuimage.GLTextureView$uk r0 = jp.co.cyberagent.android.gpuimage.GLTextureView.glThreadManager
                monitor-enter(r0)
                r1.ppp = r2     // Catch:{ all -> 0x003c }
                r1.ggg = r3     // Catch:{ all -> 0x003c }
                r2 = 1
                r1.mmm = r2     // Catch:{ all -> 0x003c }
                r1.xxx = r2     // Catch:{ all -> 0x003c }
                r2 = 0
                r1.ddd = r2     // Catch:{ all -> 0x003c }
                jp.co.cyberagent.android.gpuimage.GLTextureView$uk r2 = jp.co.cyberagent.android.gpuimage.GLTextureView.glThreadManager     // Catch:{ all -> 0x003c }
                r2.notifyAll()     // Catch:{ all -> 0x003c }
            L_0x0018:
                boolean r2 = r1.f10393th     // Catch:{ all -> 0x003c }
                if (r2 != 0) goto L_0x003a
                boolean r2 = r1.f10394uk     // Catch:{ all -> 0x003c }
                if (r2 != 0) goto L_0x003a
                boolean r2 = r1.ddd     // Catch:{ all -> 0x003c }
                if (r2 != 0) goto L_0x003a
                boolean r2 = r1.qw()     // Catch:{ all -> 0x003c }
                if (r2 == 0) goto L_0x003a
                jp.co.cyberagent.android.gpuimage.GLTextureView$uk r2 = jp.co.cyberagent.android.gpuimage.GLTextureView.glThreadManager     // Catch:{ InterruptedException -> 0x0032 }
                r2.wait()     // Catch:{ InterruptedException -> 0x0032 }
                goto L_0x0018
            L_0x0032:
                java.lang.Thread r2 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x003c }
                r2.interrupt()     // Catch:{ all -> 0x003c }
                goto L_0x0018
            L_0x003a:
                monitor-exit(r0)     // Catch:{ all -> 0x003c }
                return
            L_0x003c:
                r2 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x003c }
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: jp.co.cyberagent.android.gpuimage.GLTextureView.yj.yj(int, int):void");
        }
    }

    public GLTextureView(Context context) {
        super(context);
        init();
    }

    private void checkRenderThreadState() {
        if (this.glThread != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    private void init() {
        setSurfaceTextureListener(this);
    }

    public void addSurfaceTextureListener(TextureView.SurfaceTextureListener surfaceTextureListener) {
        this.surfaceTextureListeners.add(surfaceTextureListener);
    }

    public void finalize() throws Throwable {
        try {
            if (this.glThread != null) {
                this.glThread.o();
            }
        } finally {
            super.finalize();
        }
    }

    public int getDebugFlags() {
        return this.debugFlags;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.preserveEGLContextOnPause;
    }

    public int getRenderMode() {
        return this.glThread.de();
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.detached && this.renderer != null) {
            yj yjVar = this.glThread;
            int de2 = yjVar != null ? yjVar.de() : 1;
            yj yjVar2 = new yj(this.mThisWeakRef);
            this.glThread = yjVar2;
            if (de2 != 1) {
                yjVar2.m1148switch(de2);
            }
            this.glThread.start();
        }
        this.detached = false;
    }

    public void onDetachedFromWindow() {
        yj yjVar = this.glThread;
        if (yjVar != null) {
            yjVar.o();
        }
        this.detached = true;
        super.onDetachedFromWindow();
    }

    public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        surfaceChanged(getSurfaceTexture(), 0, i4 - i2, i5 - i3);
    }

    public void onPause() {
        this.glThread.rg();
    }

    public void onResume() {
        this.glThread.th();
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        surfaceCreated(surfaceTexture);
        surfaceChanged(surfaceTexture, 0, i2, i3);
        for (TextureView.SurfaceTextureListener onSurfaceTextureAvailable : this.surfaceTextureListeners) {
            onSurfaceTextureAvailable.onSurfaceTextureAvailable(surfaceTexture, i2, i3);
        }
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        surfaceDestroyed(surfaceTexture);
        for (TextureView.SurfaceTextureListener onSurfaceTextureDestroyed : this.surfaceTextureListeners) {
            onSurfaceTextureDestroyed.onSurfaceTextureDestroyed(surfaceTexture);
        }
        return true;
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        surfaceChanged(surfaceTexture, 0, i2, i3);
        for (TextureView.SurfaceTextureListener onSurfaceTextureSizeChanged : this.surfaceTextureListeners) {
            onSurfaceTextureSizeChanged.onSurfaceTextureSizeChanged(surfaceTexture, i2, i3);
        }
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        requestRender();
        for (TextureView.SurfaceTextureListener onSurfaceTextureUpdated : this.surfaceTextureListeners) {
            onSurfaceTextureUpdated.onSurfaceTextureUpdated(surfaceTexture);
        }
    }

    public void queueEvent(Runnable runnable) {
        this.glThread.uk(runnable);
    }

    public void requestRender() {
        this.glThread.m1147if();
    }

    public void setDebugFlags(int i2) {
        this.debugFlags = i2;
    }

    public void setEGLConfigChooser(EGLConfigChooser eGLConfigChooser) {
        checkRenderThreadState();
        this.eglConfigChooser = eGLConfigChooser;
    }

    public void setEGLContextClientVersion(int i2) {
        checkRenderThreadState();
        this.eglContextClientVersion = i2;
    }

    public void setEGLContextFactory(EGLContextFactory eGLContextFactory) {
        checkRenderThreadState();
        this.eglContextFactory = eGLContextFactory;
    }

    public void setEGLWindowSurfaceFactory(EGLWindowSurfaceFactory eGLWindowSurfaceFactory) {
        checkRenderThreadState();
        this.eglWindowSurfaceFactory = eGLWindowSurfaceFactory;
    }

    public void setGLWrapper(GLWrapper gLWrapper) {
        this.glWrapper = gLWrapper;
    }

    public void setPreserveEGLContextOnPause(boolean z) {
        this.preserveEGLContextOnPause = z;
    }

    public void setRenderMode(int i2) {
        this.glThread.m1148switch(i2);
    }

    public void setRenderer(Renderer renderer2) {
        checkRenderThreadState();
        if (this.eglConfigChooser == null) {
            this.eglConfigChooser = new o(true);
        }
        if (this.eglContextFactory == null) {
            this.eglContextFactory = new fe();
        }
        if (this.eglWindowSurfaceFactory == null) {
            this.eglWindowSurfaceFactory = new rg();
        }
        this.renderer = renderer2;
        yj yjVar = new yj(this.mThisWeakRef);
        this.glThread = yjVar;
        yjVar.start();
    }

    public void surfaceChanged(SurfaceTexture surfaceTexture, int i2, int i3, int i4) {
        this.glThread.yj(i3, i4);
    }

    public void surfaceCreated(SurfaceTexture surfaceTexture) {
        this.glThread.ggg();
    }

    public void surfaceDestroyed(SurfaceTexture surfaceTexture) {
        this.glThread.vvv();
    }

    public void setEGLConfigChooser(boolean z) {
        setEGLConfigChooser((EGLConfigChooser) new o(z));
    }

    public void setEGLConfigChooser(int i2, int i3, int i4, int i5, int i6, int i7) {
        setEGLConfigChooser((EGLConfigChooser) new de(i2, i3, i4, i5, i6, i7));
    }

    public GLTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }
}
