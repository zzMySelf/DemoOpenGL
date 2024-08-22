package fe.vvv.qw.ggg;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.Matrix;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.otaliastudios.cameraview.filter.Filter;
import com.otaliastudios.cameraview.overlay.Overlay;
import com.otaliastudios.cameraview.picture.PictureRecorder;
import com.otaliastudios.cameraview.preview.RendererCameraPreview;
import com.otaliastudios.cameraview.preview.RendererFrameCallback;
import fe.vvv.qw.fe;
import fe.vvv.qw.p037if.fe;
import fe.vvv.qw.p037if.yj;

public class th extends yj {

    /* renamed from: i  reason: collision with root package name */
    public RendererCameraPreview f8984i;

    /* renamed from: if  reason: not valid java name */
    public boolean f374if;

    /* renamed from: o  reason: collision with root package name */
    public fe.vvv.qw.xxx.qw f8985o;

    /* renamed from: pf  reason: collision with root package name */
    public Overlay f8986pf;

    /* renamed from: switch  reason: not valid java name */
    public fe.vvv.qw.ppp.qw f375switch;
    public fe when;

    public class ad implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ SurfaceTexture f8987ad;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ EGLContext f8988i;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ int f8990th;

        /* renamed from: uk  reason: collision with root package name */
        public final /* synthetic */ float f8991uk;

        /* renamed from: yj  reason: collision with root package name */
        public final /* synthetic */ float f8992yj;

        public ad(SurfaceTexture surfaceTexture, int i2, float f, float f2, EGLContext eGLContext) {
            this.f8987ad = surfaceTexture;
            this.f8990th = i2;
            this.f8992yj = f;
            this.f8991uk = f2;
            this.f8988i = eGLContext;
        }

        public void run() {
            th.this.uk(this.f8987ad, this.f8990th, this.f8992yj, this.f8991uk, this.f8988i);
        }
    }

    public class qw implements RendererFrameCallback {
        public qw() {
        }

        public void fe(int i2) {
            th.this.yj(i2);
        }

        public void qw(@NonNull SurfaceTexture surfaceTexture, int i2, float f, float f2) {
            th.this.f8984i.fe(this);
            th.this.th(surfaceTexture, i2, f, f2);
        }

        public void th(@NonNull Filter filter) {
            th.this.rg(filter);
        }
    }

    public th(@NonNull fe.qw qwVar, @Nullable PictureRecorder.PictureResultListener pictureResultListener, @NonNull RendererCameraPreview rendererCameraPreview, @NonNull fe.vvv.qw.xxx.qw qwVar2, @Nullable Overlay overlay) {
        super(qwVar, pictureResultListener);
        this.f8984i = rendererCameraPreview;
        this.f8985o = qwVar2;
        this.f8986pf = overlay;
        this.f374if = overlay != null && overlay.drawsOn(Overlay.Target.PICTURE_SNAPSHOT);
    }

    public void ad() {
        this.f8985o = null;
        super.ad();
    }

    @TargetApi(19)
    public void de() {
        this.f8984i.qw(new qw());
    }

    @TargetApi(19)
    public void rg(@NonNull Filter filter) {
        this.when.rg(filter.qw());
    }

    @TargetApi(19)
    public void th(@NonNull SurfaceTexture surfaceTexture, int i2, float f, float f2) {
        yj.ad(new ad(surfaceTexture, i2, f, f2, EGL14.eglGetCurrentContext()));
    }

    @WorkerThread
    @TargetApi(19)
    public void uk(@NonNull SurfaceTexture surfaceTexture, int i2, float f, float f2, @NonNull EGLContext eGLContext) {
        float f3 = f;
        float f4 = f2;
        SurfaceTexture surfaceTexture2 = new SurfaceTexture(9999);
        surfaceTexture2.setDefaultBufferSize(this.f6767ad.f8963fe.rg(), this.f6767ad.f8963fe.fe());
        fe.vvv.ad.ad.qw qwVar = new fe.vvv.ad.ad.qw(eGLContext, 1);
        fe.vvv.ad.uk.fe feVar = new fe.vvv.ad.uk.fe(qwVar, surfaceTexture2);
        feVar.th();
        float[] de2 = this.when.de();
        surfaceTexture.getTransformMatrix(de2);
        Matrix.translateM(de2, 0, (1.0f - f3) / 2.0f, (1.0f - f4) / 2.0f, 0.0f);
        Matrix.scaleM(de2, 0, f3, f4, 1.0f);
        Matrix.translateM(de2, 0, 0.5f, 0.5f, 0.0f);
        Matrix.rotateM(de2, 0, (float) (i2 + this.f6767ad.f8962de), 0.0f, 0.0f, 1.0f);
        Matrix.scaleM(de2, 0, 1.0f, -1.0f, 1.0f);
        Matrix.translateM(de2, 0, -0.5f, -0.5f, 0.0f);
        if (this.f374if) {
            this.f375switch.qw(Overlay.Target.PICTURE_SNAPSHOT);
            Matrix.translateM(this.f375switch.ad(), 0, 0.5f, 0.5f, 0.0f);
            Matrix.rotateM(this.f375switch.ad(), 0, (float) this.f6767ad.f8962de, 0.0f, 0.0f, 1.0f);
            Matrix.scaleM(this.f375switch.ad(), 0, 1.0f, -1.0f, 1.0f);
            Matrix.translateM(this.f375switch.ad(), 0, -0.5f, -0.5f, 0.0f);
        }
        this.f6767ad.f8962de = 0;
        long timestamp = surfaceTexture.getTimestamp() / 1000;
        yj.f8993uk.de("takeFrame:", "timestampUs:", Long.valueOf(timestamp));
        this.when.qw(timestamp);
        if (this.f374if) {
            this.f375switch.fe(timestamp);
        }
        this.f6767ad.f8965th = feVar.i(Bitmap.CompressFormat.JPEG);
        feVar.yj();
        this.when.fe();
        surfaceTexture2.release();
        if (this.f374if) {
            this.f375switch.de();
        }
        qwVar.i();
        ad();
    }

    @TargetApi(19)
    public void yj(int i2) {
        this.when = new fe.vvv.qw.p037if.fe(i2);
        Rect qw2 = fe.vvv.qw.p037if.ad.qw(this.f6767ad.f8963fe, this.f8985o);
        this.f6767ad.f8963fe = new fe.vvv.qw.xxx.ad(qw2.width(), qw2.height());
        if (this.f374if) {
            this.f375switch = new fe.vvv.qw.ppp.qw(this.f8986pf, this.f6767ad.f8963fe);
        }
    }
}
