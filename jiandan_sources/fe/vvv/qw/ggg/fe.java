package fe.vvv.qw.ggg;

import android.graphics.Rect;
import android.graphics.YuvImage;
import android.hardware.Camera;
import androidx.annotation.NonNull;
import com.otaliastudios.cameraview.engine.offset.Reference;
import fe.vvv.qw.fe;
import fe.vvv.qw.p037if.th;
import fe.vvv.qw.p037if.yj;
import fe.vvv.qw.xxx.ad;
import java.io.ByteArrayOutputStream;

public class fe extends yj {

    /* renamed from: i  reason: collision with root package name */
    public fe.vvv.qw.yj.qw f8972i;

    /* renamed from: if  reason: not valid java name */
    public int f373if;

    /* renamed from: o  reason: collision with root package name */
    public Camera f8973o;

    /* renamed from: pf  reason: collision with root package name */
    public fe.vvv.qw.xxx.qw f8974pf;

    public class qw implements Camera.PreviewCallback {

        /* renamed from: fe.vvv.qw.ggg.fe$qw$qw  reason: collision with other inner class name */
        public class C0310qw implements Runnable {

            /* renamed from: ad  reason: collision with root package name */
            public final /* synthetic */ byte[] f8976ad;

            /* renamed from: th  reason: collision with root package name */
            public final /* synthetic */ ad f8978th;

            /* renamed from: uk  reason: collision with root package name */
            public final /* synthetic */ ad f8979uk;

            /* renamed from: yj  reason: collision with root package name */
            public final /* synthetic */ int f8980yj;

            public C0310qw(byte[] bArr, ad adVar, int i2, ad adVar2) {
                this.f8976ad = bArr;
                this.f8978th = adVar;
                this.f8980yj = i2;
                this.f8979uk = adVar2;
            }

            public void run() {
                YuvImage yuvImage = new YuvImage(th.qw(this.f8976ad, this.f8978th, this.f8980yj), fe.this.f373if, this.f8979uk.rg(), this.f8979uk.fe(), (int[]) null);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                Rect qw = fe.vvv.qw.p037if.ad.qw(this.f8979uk, fe.this.f8974pf);
                yuvImage.compressToJpeg(qw, 90, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                fe.qw qwVar = fe.this.f6767ad;
                qwVar.f8965th = byteArray;
                qwVar.f8963fe = new ad(qw.width(), qw.height());
                fe feVar = fe.this;
                feVar.f6767ad.f8962de = 0;
                feVar.ad();
            }
        }

        public qw() {
        }

        public void onPreviewFrame(@NonNull byte[] bArr, Camera camera) {
            fe.this.qw(false);
            fe feVar = fe.this;
            fe.qw qwVar = feVar.f6767ad;
            int i2 = qwVar.f8962de;
            ad adVar = qwVar.f8963fe;
            ad y = feVar.f8972i.y(Reference.SENSOR);
            if (y != null) {
                yj.ad(new C0310qw(bArr, y, i2, adVar));
                camera.setPreviewCallbackWithBuffer((Camera.PreviewCallback) null);
                camera.setPreviewCallbackWithBuffer(fe.this.f8972i);
                fe.this.f8972i.j1().i(fe.this.f373if, y, fe.this.f8972i.qqq());
                return;
            }
            throw new IllegalStateException("Preview stream size should never be null here.");
        }
    }

    public fe(@NonNull fe.qw qwVar, @NonNull fe.vvv.qw.yj.qw qwVar2, @NonNull Camera camera, @NonNull fe.vvv.qw.xxx.qw qwVar3) {
        super(qwVar, qwVar2);
        this.f8972i = qwVar2;
        this.f8973o = camera;
        this.f8974pf = qwVar3;
        this.f373if = camera.getParameters().getPreviewFormat();
    }

    public void ad() {
        this.f8972i = null;
        this.f8973o = null;
        this.f8974pf = null;
        this.f373if = 0;
        super.ad();
    }

    public void de() {
        this.f8973o.setOneShotPreviewCallback(new qw());
    }
}
