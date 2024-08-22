package fe.vvv.qw.yj.uk;

import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.Camera;
import androidx.annotation.NonNull;
import com.otaliastudios.cameraview.CameraLogger;
import com.otaliastudios.cameraview.engine.offset.Axis;
import com.otaliastudios.cameraview.engine.offset.Reference;
import com.otaliastudios.cameraview.metering.MeteringTransform;
import fe.vvv.qw.xxx.ad;

public class qw implements MeteringTransform<Camera.Area> {

    /* renamed from: de  reason: collision with root package name */
    public static final CameraLogger f9276de = CameraLogger.qw(qw.class.getSimpleName());

    /* renamed from: ad  reason: collision with root package name */
    public final ad f9277ad;
    public final int qw;

    public qw(@NonNull fe.vvv.qw.yj.i.qw qwVar, @NonNull ad adVar) {
        this.qw = -qwVar.de(Reference.SENSOR, Reference.VIEW, Axis.ABSOLUTE);
        this.f9277ad = adVar;
    }

    @NonNull
    public PointF ad(@NonNull PointF pointF) {
        PointF pointF2 = new PointF();
        pointF2.x = ((pointF.x / ((float) this.f9277ad.rg())) * 2000.0f) - 0.0040893555f;
        pointF2.y = ((pointF.y / ((float) this.f9277ad.fe())) * 2000.0f) - 0.0040893555f;
        PointF pointF3 = new PointF();
        double d = (((double) this.qw) * 3.141592653589793d) / 180.0d;
        pointF3.x = (float) ((((double) pointF2.x) * Math.cos(d)) - (((double) pointF2.y) * Math.sin(d)));
        pointF3.y = (float) ((((double) pointF2.x) * Math.sin(d)) + (((double) pointF2.y) * Math.cos(d)));
        f9276de.de("scaled:", pointF2, "rotated:", pointF3);
        return pointF3;
    }

    @NonNull
    /* renamed from: de */
    public Camera.Area qw(@NonNull RectF rectF, int i2) {
        Rect rect = new Rect();
        rectF.round(rect);
        return new Camera.Area(rect, i2);
    }
}
