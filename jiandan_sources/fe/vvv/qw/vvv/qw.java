package fe.vvv.qw.vvv;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.baidu.aiscan.R;
import com.otaliastudios.cameraview.filter.Filter;
import com.otaliastudios.cameraview.preview.CameraPreview;
import com.otaliastudios.cameraview.preview.FilterCameraPreview;
import com.otaliastudios.cameraview.preview.RendererCameraPreview;
import com.otaliastudios.cameraview.preview.RendererFrameCallback;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class qw extends CameraPreview<GLSurfaceView, SurfaceTexture> implements FilterCameraPreview, RendererCameraPreview {
    @VisibleForTesting
    public float ggg = 1.0f;

    /* renamed from: if  reason: not valid java name */
    public SurfaceTexture f395if;

    /* renamed from: pf  reason: collision with root package name */
    public boolean f9114pf;
    @VisibleForTesting
    public float ppp = 1.0f;

    /* renamed from: switch  reason: not valid java name */
    public fe.vvv.qw.p037if.fe f396switch;
    public View vvv;
    public final Set<RendererFrameCallback> when = new CopyOnWriteArraySet();
    public Filter xxx;

    public class ad implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ RendererFrameCallback f9115ad;

        public ad(RendererFrameCallback rendererFrameCallback) {
            this.f9115ad = rendererFrameCallback;
        }

        public void run() {
            qw.this.when.add(this.f9115ad);
            if (qw.this.f396switch != null) {
                this.f9115ad.fe(qw.this.f396switch.ad().rg());
            }
            this.f9115ad.th(qw.this.xxx);
        }
    }

    public class de implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ Filter f9117ad;

        public de(Filter filter) {
            this.f9117ad = filter;
        }

        public void run() {
            if (qw.this.f396switch != null) {
                qw.this.f396switch.rg(this.f9117ad);
            }
            for (RendererFrameCallback th2 : qw.this.when) {
                th2.th(this.f9117ad);
            }
        }
    }

    public class fe implements GLSurfaceView.Renderer {

        public class ad implements SurfaceTexture.OnFrameAvailableListener {
            public ad() {
            }

            public void onFrameAvailable(SurfaceTexture surfaceTexture) {
                ((GLSurfaceView) qw.this.m717switch()).requestRender();
            }
        }

        /* renamed from: fe.vvv.qw.vvv.qw$fe$qw  reason: collision with other inner class name */
        public class C0314qw implements Runnable {

            /* renamed from: ad  reason: collision with root package name */
            public final /* synthetic */ int f9120ad;

            public C0314qw(int i2) {
                this.f9120ad = i2;
            }

            public void run() {
                for (RendererFrameCallback fe2 : qw.this.when) {
                    fe2.fe(this.f9120ad);
                }
            }
        }

        public fe() {
        }

        public void onDrawFrame(GL10 gl10) {
            if (qw.this.f395if != null) {
                qw qwVar = qw.this;
                if (qwVar.f6778yj > 0 && qwVar.f6777uk > 0) {
                    float[] de2 = qwVar.f396switch.de();
                    qw.this.f395if.updateTexImage();
                    qw.this.f395if.getTransformMatrix(de2);
                    if (qw.this.f6774i != 0) {
                        Matrix.translateM(de2, 0, 0.5f, 0.5f, 0.0f);
                        Matrix.rotateM(de2, 0, (float) qw.this.f6774i, 0.0f, 0.0f, 1.0f);
                        Matrix.translateM(de2, 0, -0.5f, -0.5f, 0.0f);
                    }
                    if (qw.this.ppp()) {
                        qw qwVar2 = qw.this;
                        Matrix.translateM(de2, 0, (1.0f - qwVar2.ppp) / 2.0f, (1.0f - qwVar2.ggg) / 2.0f, 0.0f);
                        qw qwVar3 = qw.this;
                        Matrix.scaleM(de2, 0, qwVar3.ppp, qwVar3.ggg, 1.0f);
                    }
                    qw.this.f396switch.qw(qw.this.f395if.getTimestamp() / 1000);
                    for (RendererFrameCallback qw : qw.this.when) {
                        SurfaceTexture e = qw.this.f395if;
                        qw qwVar4 = qw.this;
                        qw.qw(e, qwVar4.f6774i, qwVar4.ppp, qwVar4.ggg);
                    }
                }
            }
        }

        public void onSurfaceChanged(GL10 gl10, int i2, int i3) {
            gl10.glViewport(0, 0, i2, i3);
            qw.this.xxx.yj(i2, i3);
            if (!qw.this.f9114pf) {
                qw.this.th(i2, i3);
                boolean unused = qw.this.f9114pf = true;
                return;
            }
            qw qwVar = qw.this;
            if (i2 != qwVar.f6775rg || i3 != qwVar.f6776th) {
                qw.this.uk(i2, i3);
            }
        }

        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            if (qw.this.xxx == null) {
                Filter unused = qw.this.xxx = new fe.vvv.qw.uk.de();
            }
            fe.vvv.qw.p037if.fe unused2 = qw.this.f396switch = new fe.vvv.qw.p037if.fe();
            qw.this.f396switch.rg(qw.this.xxx);
            int rg2 = qw.this.f396switch.ad().rg();
            SurfaceTexture unused3 = qw.this.f395if = new SurfaceTexture(rg2);
            ((GLSurfaceView) qw.this.m717switch()).queueEvent(new C0314qw(rg2));
            qw.this.f395if.setOnFrameAvailableListener(new ad());
        }

        public void qw() {
            if (qw.this.f395if != null) {
                qw.this.f395if.setOnFrameAvailableListener((SurfaceTexture.OnFrameAvailableListener) null);
                qw.this.f395if.release();
                SurfaceTexture unused = qw.this.f395if = null;
            }
            if (qw.this.f396switch != null) {
                qw.this.f396switch.fe();
                fe.vvv.qw.p037if.fe unused2 = qw.this.f396switch = null;
            }
        }
    }

    /* renamed from: fe.vvv.qw.vvv.qw$qw  reason: collision with other inner class name */
    public class C0315qw implements SurfaceHolder.Callback {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ GLSurfaceView f9122ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ fe f9123th;

        /* renamed from: fe.vvv.qw.vvv.qw$qw$qw  reason: collision with other inner class name */
        public class C0316qw implements Runnable {
            public C0316qw() {
            }

            public void run() {
                C0315qw.this.f9123th.qw();
            }
        }

        public C0315qw(GLSurfaceView gLSurfaceView, fe feVar) {
            this.f9122ad = gLSurfaceView;
            this.f9123th = feVar;
        }

        public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        }

        public void surfaceCreated(SurfaceHolder surfaceHolder) {
        }

        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            qw.this.yj();
            this.f9122ad.queueEvent(new C0316qw());
            boolean unused = qw.this.f9114pf = false;
        }
    }

    public qw(@NonNull Context context, @NonNull ViewGroup viewGroup) {
        super(context, viewGroup);
    }

    public void ad(@NonNull Filter filter) {
        this.xxx = filter;
        if (when()) {
            filter.yj(this.f6775rg, this.f6776th);
        }
        ((GLSurfaceView) m717switch()).queueEvent(new de(filter));
    }

    public void ddd() {
        super.ddd();
        ((GLSurfaceView) m717switch()).onPause();
    }

    @NonNull
    public Filter de() {
        return this.xxx;
    }

    public boolean eee() {
        return true;
    }

    public void fe(@NonNull RendererFrameCallback rendererFrameCallback) {
        this.when.remove(rendererFrameCallback);
    }

    @NonNull
    /* renamed from: h */
    public SurfaceTexture i() {
        return this.f395if;
    }

    @NonNull
    public fe j() {
        return new fe();
    }

    @NonNull
    /* renamed from: k */
    public GLSurfaceView ggg(@NonNull Context context, @NonNull ViewGroup viewGroup) {
        ViewGroup viewGroup2 = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.cameraview_gl_view, viewGroup, false);
        GLSurfaceView gLSurfaceView = (GLSurfaceView) viewGroup2.findViewById(R.id.gl_surface_view);
        fe j = j();
        gLSurfaceView.setEGLContextClientVersion(2);
        gLSurfaceView.setRenderer(j);
        gLSurfaceView.setRenderMode(0);
        gLSurfaceView.getHolder().addCallback(new C0315qw(gLSurfaceView, j));
        viewGroup.addView(viewGroup2, 0);
        this.vvv = viewGroup2;
        return gLSurfaceView;
    }

    public void nn() {
        super.nn();
        ((GLSurfaceView) m717switch()).onResume();
    }

    @NonNull
    public Class<SurfaceTexture> o() {
        return SurfaceTexture.class;
    }

    @NonNull
    public View pf() {
        return this.vvv;
    }

    public void qw(@NonNull RendererFrameCallback rendererFrameCallback) {
        ((GLSurfaceView) m717switch()).queueEvent(new ad(rendererFrameCallback));
    }

    public void rg(@Nullable CameraPreview.CropCallback cropCallback) {
        int i2;
        int i3;
        float f;
        float f2;
        if (this.f6778yj > 0 && this.f6777uk > 0 && (i2 = this.f6775rg) > 0 && (i3 = this.f6776th) > 0) {
            fe.vvv.qw.xxx.qw th2 = fe.vvv.qw.xxx.qw.th(i2, i3);
            fe.vvv.qw.xxx.qw th3 = fe.vvv.qw.xxx.qw.th(this.f6778yj, this.f6777uk);
            if (th2.o() >= th3.o()) {
                f2 = th2.o() / th3.o();
                f = 1.0f;
            } else {
                f = th3.o() / th2.o();
                f2 = 1.0f;
            }
            this.f6773fe = f > 1.02f || f2 > 1.02f;
            this.ppp = 1.0f / f;
            this.ggg = 1.0f / f2;
            ((GLSurfaceView) m717switch()).requestRender();
        }
        if (cropCallback != null) {
            cropCallback.qw();
        }
    }

    public void vvv() {
        super.vvv();
        this.when.clear();
    }
}
