package fe.vvv.qw.yj.uk;

import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.MeteringRectangle;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.otaliastudios.cameraview.CameraLogger;
import com.otaliastudios.cameraview.engine.offset.Axis;
import com.otaliastudios.cameraview.engine.offset.Reference;
import com.otaliastudios.cameraview.metering.MeteringTransform;
import fe.vvv.qw.yj.i.qw;

@RequiresApi(21)
public class ad implements MeteringTransform<MeteringRectangle> {

    /* renamed from: yj  reason: collision with root package name */
    public static final CameraLogger f9270yj = CameraLogger.qw(ad.class.getSimpleName());

    /* renamed from: ad  reason: collision with root package name */
    public final fe.vvv.qw.xxx.ad f9271ad;

    /* renamed from: de  reason: collision with root package name */
    public final fe.vvv.qw.xxx.ad f9272de;

    /* renamed from: fe  reason: collision with root package name */
    public final boolean f9273fe;
    public final qw qw;

    /* renamed from: rg  reason: collision with root package name */
    public final CameraCharacteristics f9274rg;

    /* renamed from: th  reason: collision with root package name */
    public final CaptureRequest.Builder f9275th;

    public ad(@NonNull qw qwVar, @NonNull fe.vvv.qw.xxx.ad adVar, @NonNull fe.vvv.qw.xxx.ad adVar2, boolean z, @NonNull CameraCharacteristics cameraCharacteristics, @NonNull CaptureRequest.Builder builder) {
        this.qw = qwVar;
        this.f9271ad = adVar;
        this.f9272de = adVar2;
        this.f9273fe = z;
        this.f9274rg = cameraCharacteristics;
        this.f9275th = builder;
    }

    @NonNull
    public PointF ad(@NonNull PointF pointF) {
        PointF pointF2 = new PointF(pointF.x, pointF.y);
        fe.vvv.qw.xxx.ad de2 = de(fe(yj(th(rg(this.f9271ad, pointF2), pointF2), pointF2), pointF2), pointF2);
        f9270yj.de("input:", pointF, "output (before clipping):", pointF2);
        if (pointF2.x < 0.0f) {
            pointF2.x = 0.0f;
        }
        if (pointF2.y < 0.0f) {
            pointF2.y = 0.0f;
        }
        if (pointF2.x > ((float) de2.rg())) {
            pointF2.x = (float) de2.rg();
        }
        if (pointF2.y > ((float) de2.fe())) {
            pointF2.y = (float) de2.fe();
        }
        f9270yj.de("input:", pointF, "output (after clipping):", pointF2);
        return pointF2;
    }

    @NonNull
    public final fe.vvv.qw.xxx.ad de(@NonNull fe.vvv.qw.xxx.ad adVar, @NonNull PointF pointF) {
        Rect rect = (Rect) this.f9275th.get(CaptureRequest.SCALER_CROP_REGION);
        float f = 0.0f;
        pointF.x += rect == null ? 0.0f : (float) rect.left;
        float f2 = pointF.y;
        if (rect != null) {
            f = (float) rect.top;
        }
        pointF.y = f2 + f;
        Rect rect2 = (Rect) this.f9274rg.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
        if (rect2 == null) {
            rect2 = new Rect(0, 0, adVar.rg(), adVar.fe());
        }
        return new fe.vvv.qw.xxx.ad(rect2.width(), rect2.height());
    }

    @NonNull
    public final fe.vvv.qw.xxx.ad fe(@NonNull fe.vvv.qw.xxx.ad adVar, @NonNull PointF pointF) {
        Rect rect = (Rect) this.f9275th.get(CaptureRequest.SCALER_CROP_REGION);
        int rg2 = rect == null ? adVar.rg() : rect.width();
        int fe2 = rect == null ? adVar.fe() : rect.height();
        pointF.x += ((float) (rg2 - adVar.rg())) / 2.0f;
        pointF.y += ((float) (fe2 - adVar.fe())) / 2.0f;
        return new fe.vvv.qw.xxx.ad(rg2, fe2);
    }

    @NonNull
    public final fe.vvv.qw.xxx.ad rg(@NonNull fe.vvv.qw.xxx.ad adVar, @NonNull PointF pointF) {
        fe.vvv.qw.xxx.ad adVar2 = this.f9272de;
        int rg2 = adVar.rg();
        int fe2 = adVar.fe();
        fe.vvv.qw.xxx.qw uk2 = fe.vvv.qw.xxx.qw.uk(adVar2);
        fe.vvv.qw.xxx.qw uk3 = fe.vvv.qw.xxx.qw.uk(adVar);
        if (this.f9273fe) {
            if (uk2.o() > uk3.o()) {
                float o2 = uk2.o() / uk3.o();
                pointF.x += (((float) adVar.rg()) * (o2 - 1.0f)) / 2.0f;
                rg2 = Math.round(((float) adVar.rg()) * o2);
            } else {
                float o3 = uk3.o() / uk2.o();
                pointF.y += (((float) adVar.fe()) * (o3 - 1.0f)) / 2.0f;
                fe2 = Math.round(((float) adVar.fe()) * o3);
            }
        }
        return new fe.vvv.qw.xxx.ad(rg2, fe2);
    }

    @NonNull
    public final fe.vvv.qw.xxx.ad th(@NonNull fe.vvv.qw.xxx.ad adVar, @NonNull PointF pointF) {
        fe.vvv.qw.xxx.ad adVar2 = this.f9272de;
        pointF.x *= ((float) adVar2.rg()) / ((float) adVar.rg());
        pointF.y *= ((float) adVar2.fe()) / ((float) adVar.fe());
        return adVar2;
    }

    @NonNull
    /* renamed from: uk */
    public MeteringRectangle qw(@NonNull RectF rectF, int i2) {
        Rect rect = new Rect();
        rectF.round(rect);
        return new MeteringRectangle(rect, i2);
    }

    @NonNull
    public final fe.vvv.qw.xxx.ad yj(@NonNull fe.vvv.qw.xxx.ad adVar, @NonNull PointF pointF) {
        int de2 = this.qw.de(Reference.SENSOR, Reference.VIEW, Axis.ABSOLUTE);
        boolean z = de2 % 180 != 0;
        float f = pointF.x;
        float f2 = pointF.y;
        if (de2 == 0) {
            pointF.x = f;
            pointF.y = f2;
        } else if (de2 == 90) {
            pointF.x = f2;
            pointF.y = ((float) adVar.rg()) - f;
        } else if (de2 == 180) {
            pointF.x = ((float) adVar.rg()) - f;
            pointF.y = ((float) adVar.fe()) - f2;
        } else if (de2 == 270) {
            pointF.x = ((float) adVar.fe()) - f2;
            pointF.y = f;
        } else {
            throw new IllegalStateException("Unexpected angle " + de2);
        }
        return z ? adVar.ad() : adVar;
    }
}
