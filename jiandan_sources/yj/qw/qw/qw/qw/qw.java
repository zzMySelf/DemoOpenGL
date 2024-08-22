package yj.qw.qw.qw.qw;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.LinkedList;
import java.util.Queue;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import jp.co.cyberagent.android.gpuimage.GLTextureView;
import jp.co.cyberagent.android.gpuimage.GPUImage;
import jp.co.cyberagent.android.gpuimage.GPUImageNativeLibrary;
import jp.co.cyberagent.android.gpuimage.util.Rotation;

public class qw implements GLSurfaceView.Renderer, GLTextureView.Renderer, Camera.PreviewCallback {
    public static final float[] tt = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
    public GPUImage.ScaleType aaa = GPUImage.ScaleType.CENTER_CROP;

    /* renamed from: ad  reason: collision with root package name */
    public yj.qw.qw.qw.qw.de.qw f11108ad;
    public Rotation ddd;
    public float eee = 0.0f;
    public int ggg;

    /* renamed from: i  reason: collision with root package name */
    public final FloatBuffer f11109i;

    /* renamed from: if  reason: not valid java name */
    public int f525if;
    public boolean mmm;
    public boolean nn;

    /* renamed from: o  reason: collision with root package name */
    public final FloatBuffer f11110o;

    /* renamed from: pf  reason: collision with root package name */
    public IntBuffer f11111pf;
    public int ppp;
    public float qqq = 0.0f;
    public float rrr = 0.0f;

    /* renamed from: switch  reason: not valid java name */
    public int f526switch;

    /* renamed from: th  reason: collision with root package name */
    public final Object f11112th = new Object();

    /* renamed from: uk  reason: collision with root package name */
    public SurfaceTexture f11113uk = null;
    public final Queue<Runnable> vvv;
    public int when;
    public final Queue<Runnable> xxx;

    /* renamed from: yj  reason: collision with root package name */
    public int f11114yj = -1;

    public class ad implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ Camera f11115ad;

        public ad(Camera camera) {
            this.f11115ad = camera;
        }

        public void run() {
            int[] iArr = new int[1];
            GLES20.glGenTextures(1, iArr, 0);
            SurfaceTexture unused = qw.this.f11113uk = new SurfaceTexture(iArr[0]);
            try {
                this.f11115ad.setPreviewTexture(qw.this.f11113uk);
                this.f11115ad.setPreviewCallback(qw.this);
                this.f11115ad.startPreview();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public class de implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ yj.qw.qw.qw.qw.de.qw f11117ad;

        public de(yj.qw.qw.qw.qw.de.qw qwVar) {
            this.f11117ad = qwVar;
        }

        public void run() {
            yj.qw.qw.qw.qw.de.qw o2 = qw.this.f11108ad;
            yj.qw.qw.qw.qw.de.qw unused = qw.this.f11108ad = this.f11117ad;
            if (o2 != null) {
                o2.qw();
            }
            qw.this.f11108ad.de();
            GLES20.glUseProgram(qw.this.f11108ad.ad());
            qw.this.f11108ad.pf(qw.this.f525if, qw.this.f526switch);
        }
    }

    public class fe implements Runnable {
        public fe() {
        }

        public void run() {
            GLES20.glDeleteTextures(1, new int[]{qw.this.f11114yj}, 0);
            int unused = qw.this.f11114yj = -1;
        }
    }

    /* renamed from: yj.qw.qw.qw.qw.qw$qw  reason: collision with other inner class name */
    public class C0346qw implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ byte[] f11120ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ int f11121th;

        /* renamed from: yj  reason: collision with root package name */
        public final /* synthetic */ int f11123yj;

        public C0346qw(byte[] bArr, int i2, int i3) {
            this.f11120ad = bArr;
            this.f11121th = i2;
            this.f11123yj = i3;
        }

        public void run() {
            GPUImageNativeLibrary.YUVtoRBGA(this.f11120ad, this.f11121th, this.f11123yj, qw.this.f11111pf.array());
            qw qwVar = qw.this;
            int unused = qwVar.f11114yj = yj.qw.qw.qw.qw.fe.qw.fe(qwVar.f11111pf, this.f11121th, this.f11123yj, qw.this.f11114yj);
            int fe2 = qw.this.when;
            int i2 = this.f11121th;
            if (fe2 != i2) {
                int unused2 = qw.this.when = i2;
                int unused3 = qw.this.ppp = this.f11123yj;
                qw.this.ggg();
            }
        }
    }

    public class rg implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ Bitmap f11124ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ boolean f11125th;

        public rg(Bitmap bitmap, boolean z) {
            this.f11124ad = bitmap;
            this.f11125th = z;
        }

        public void run() {
            Bitmap bitmap;
            Bitmap bitmap2 = null;
            if (this.f11124ad.getWidth() % 2 == 1) {
                Bitmap createBitmap = Bitmap.createBitmap(this.f11124ad.getWidth() + 1, this.f11124ad.getHeight(), Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(createBitmap);
                canvas.drawARGB(0, 0, 0, 0);
                canvas.drawBitmap(this.f11124ad, 0.0f, 0.0f, (Paint) null);
                int unused = qw.this.ggg = 1;
                bitmap2 = createBitmap;
            } else {
                int unused2 = qw.this.ggg = 0;
            }
            qw qwVar = qw.this;
            if (bitmap2 != null) {
                bitmap = bitmap2;
            } else {
                bitmap = this.f11124ad;
            }
            int unused3 = qwVar.f11114yj = yj.qw.qw.qw.qw.fe.qw.de(bitmap, qw.this.f11114yj, this.f11125th);
            if (bitmap2 != null) {
                bitmap2.recycle();
            }
            int unused4 = qw.this.when = this.f11124ad.getWidth();
            int unused5 = qw.this.ppp = this.f11124ad.getHeight();
            qw.this.ggg();
        }
    }

    public qw(yj.qw.qw.qw.qw.de.qw qwVar) {
        this.f11108ad = qwVar;
        this.vvv = new LinkedList();
        this.xxx = new LinkedList();
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(tt.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.f11109i = asFloatBuffer;
        asFloatBuffer.put(tt).position(0);
        this.f11110o = ByteBuffer.allocateDirect(yj.qw.qw.qw.qw.fe.ad.qw.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        d(Rotation.NORMAL, false, false);
    }

    public void a(yj.qw.qw.qw.qw.de.qw qwVar) {
        eee(new de(qwVar));
    }

    public void aaa(byte[] bArr, int i2, int i3) {
        if (this.f11111pf == null) {
            this.f11111pf = IntBuffer.allocate(i2 * i3);
        }
        if (this.vvv.isEmpty()) {
            eee(new C0346qw(bArr, i2, i3));
        }
    }

    public void b(Bitmap bitmap, boolean z) {
        if (bitmap != null) {
            eee(new rg(bitmap, z));
        }
    }

    public void c(Rotation rotation) {
        this.ddd = rotation;
        ggg();
    }

    public void d(Rotation rotation, boolean z, boolean z2) {
        this.nn = z;
        this.mmm = z2;
        c(rotation);
    }

    public int ddd() {
        return this.f525if;
    }

    public void e(Rotation rotation, boolean z, boolean z2) {
        d(rotation, z2, z);
    }

    public void eee(Runnable runnable) {
        synchronized (this.vvv) {
            this.vvv.add(runnable);
        }
    }

    public void f(GPUImage.ScaleType scaleType) {
        this.aaa = scaleType;
    }

    public void g(Camera camera) {
        eee(new ad(camera));
    }

    public final void ggg() {
        float f = (float) this.f525if;
        float f2 = (float) this.f526switch;
        Rotation rotation = this.ddd;
        if (rotation == Rotation.ROTATION_270 || rotation == Rotation.ROTATION_90) {
            f = (float) this.f526switch;
            f2 = (float) this.f525if;
        }
        float max = Math.max(f / ((float) this.when), f2 / ((float) this.ppp));
        float round = ((float) Math.round(((float) this.when) * max)) / f;
        float round2 = ((float) Math.round(((float) this.ppp) * max)) / f2;
        float[] fArr = tt;
        float[] ad2 = yj.qw.qw.qw.qw.fe.ad.ad(this.ddd, this.nn, this.mmm);
        if (this.aaa == GPUImage.ScaleType.CENTER_CROP) {
            float f3 = (1.0f - (1.0f / round)) / 2.0f;
            float f4 = (1.0f - (1.0f / round2)) / 2.0f;
            ad2 = new float[]{ppp(ad2[0], f3), ppp(ad2[1], f4), ppp(ad2[2], f3), ppp(ad2[3], f4), ppp(ad2[4], f3), ppp(ad2[5], f4), ppp(ad2[6], f3), ppp(ad2[7], f4)};
        } else {
            float[] fArr2 = tt;
            fArr = new float[]{fArr2[0] / round2, fArr2[1] / round, fArr2[2] / round2, fArr2[3] / round, fArr2[4] / round2, fArr2[5] / round, fArr2[6] / round2, fArr2[7] / round};
        }
        this.f11109i.clear();
        this.f11109i.put(fArr).position(0);
        this.f11110o.clear();
        this.f11110o.put(ad2).position(0);
    }

    public boolean mmm() {
        return this.mmm;
    }

    public boolean nn() {
        return this.nn;
    }

    public void onDrawFrame(GL10 gl10) {
        GLES20.glClear(16640);
        qqq(this.vvv);
        this.f11108ad.yj(this.f11114yj, this.f11109i, this.f11110o);
        qqq(this.xxx);
        SurfaceTexture surfaceTexture = this.f11113uk;
        if (surfaceTexture != null) {
            surfaceTexture.updateTexImage();
        }
    }

    public void onPreviewFrame(byte[] bArr, Camera camera) {
        Camera.Size previewSize = camera.getParameters().getPreviewSize();
        aaa(bArr, previewSize.width, previewSize.height);
    }

    public void onSurfaceChanged(GL10 gl10, int i2, int i3) {
        this.f525if = i2;
        this.f526switch = i3;
        GLES20.glViewport(0, 0, i2, i3);
        GLES20.glUseProgram(this.f11108ad.ad());
        this.f11108ad.pf(i2, i3);
        ggg();
        synchronized (this.f11112th) {
            this.f11112th.notifyAll();
        }
    }

    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        GLES20.glClearColor(this.qqq, this.eee, this.rrr, 1.0f);
        GLES20.glDisable(2929);
        this.f11108ad.de();
    }

    public final float ppp(float f, float f2) {
        return f == 0.0f ? f2 : 1.0f - f2;
    }

    public final void qqq(Queue<Runnable> queue) {
        synchronized (queue) {
            while (!queue.isEmpty()) {
                queue.poll().run();
            }
        }
    }

    public void rrr(Runnable runnable) {
        synchronized (this.xxx) {
            this.xxx.add(runnable);
        }
    }

    public void tt(float f, float f2, float f3) {
        this.qqq = f;
        this.eee = f2;
        this.rrr = f3;
    }

    public void vvv() {
        eee(new fe());
    }

    public int xxx() {
        return this.f526switch;
    }
}
