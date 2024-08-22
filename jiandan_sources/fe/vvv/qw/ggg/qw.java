package fe.vvv.qw.ggg;

import android.hardware.Camera;
import androidx.annotation.NonNull;
import androidx.exifinterface.media.ExifInterface;
import com.otaliastudios.cameraview.engine.offset.Reference;
import com.otaliastudios.cameraview.engine.orchestrator.CameraState;
import fe.vvv.qw.fe;
import fe.vvv.qw.p037if.de;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class qw extends de {

    /* renamed from: i  reason: collision with root package name */
    public final Camera f8981i;

    /* renamed from: o  reason: collision with root package name */
    public final fe.vvv.qw.yj.qw f8982o;

    public class ad implements Camera.PictureCallback {
        public ad() {
        }

        public void onPictureTaken(byte[] bArr, Camera camera) {
            int i2;
            de.f8971uk.de("take(): got picture callback.");
            try {
                i2 = de.ad(new ExifInterface((InputStream) new ByteArrayInputStream(bArr)).getAttributeInt(ExifInterface.TAG_ORIENTATION, 1));
            } catch (IOException unused) {
                i2 = 0;
            }
            fe.qw qwVar = qw.this.f6767ad;
            qwVar.f8965th = bArr;
            qwVar.f8962de = i2;
            de.f8971uk.de("take(): starting preview again. ", Thread.currentThread());
            if (qw.this.f8982o.B().isAtLeast(CameraState.PREVIEW)) {
                camera.setPreviewCallbackWithBuffer(qw.this.f8982o);
                fe.vvv.qw.xxx.ad y = qw.this.f8982o.y(Reference.SENSOR);
                if (y != null) {
                    qw.this.f8982o.j1().i(qw.this.f8982o.g(), y, qw.this.f8982o.qqq());
                    camera.startPreview();
                } else {
                    throw new IllegalStateException("Preview stream size should never be null here.");
                }
            }
            qw.this.ad();
        }
    }

    /* renamed from: fe.vvv.qw.ggg.qw$qw  reason: collision with other inner class name */
    public class C0311qw implements Camera.ShutterCallback {
        public C0311qw() {
        }

        public void onShutter() {
            de.f8971uk.de("take(): got onShutter callback.");
            qw.this.qw(true);
        }
    }

    public qw(@NonNull fe.qw qwVar, @NonNull fe.vvv.qw.yj.qw qwVar2, @NonNull Camera camera) {
        super(qwVar, qwVar2);
        this.f8982o = qwVar2;
        this.f8981i = camera;
        Camera.Parameters parameters = camera.getParameters();
        parameters.setRotation(this.f6767ad.f8962de);
        this.f8981i.setParameters(parameters);
    }

    public void ad() {
        de.f8971uk.de("dispatching result. Thread:", Thread.currentThread());
        super.ad();
    }

    public void de() {
        de.f8971uk.de("take() called.");
        try {
            this.f8981i.setPreviewCallbackWithBuffer((Camera.PreviewCallback) null);
            this.f8982o.j1().uk();
            this.f8981i.takePicture(new C0311qw(), (Camera.PictureCallback) null, (Camera.PictureCallback) null, new ad());
        } catch (Exception e) {
            e.printStackTrace();
        }
        de.f8971uk.de("take() returned.");
    }
}
