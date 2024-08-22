package fe.vvv.qw.yj.yj;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.MeteringRectangle;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.otaliastudios.cameraview.CameraLogger;
import com.otaliastudios.cameraview.engine.action.ActionHolder;
import java.util.List;

@RequiresApi(21)
public class de extends qw {

    /* renamed from: pf  reason: collision with root package name */
    public static final CameraLogger f9279pf = CameraLogger.qw(de.class.getSimpleName());

    /* renamed from: i  reason: collision with root package name */
    public boolean f9280i = false;

    /* renamed from: o  reason: collision with root package name */
    public boolean f9281o = false;

    public de(@NonNull List<MeteringRectangle> list, boolean z) {
        super(list, z);
    }

    public void ad(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
        super.ad(actionHolder, captureRequest, totalCaptureResult);
        Integer num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AE_STATE);
        Integer num2 = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AE_PRECAPTURE_TRIGGER);
        f9279pf.de("onCaptureCompleted:", "aeState:", num, "aeTriggerState:", num2);
        if (num != null) {
            if (i() == 0) {
                int intValue = num.intValue();
                if (intValue != 2) {
                    if (intValue == 3) {
                        nn(false);
                        ppp(Integer.MAX_VALUE);
                    } else if (intValue != 4) {
                        if (intValue == 5) {
                            ppp(1);
                        }
                    }
                }
                if (num2 != null && num2.intValue() == 1) {
                    nn(true);
                    ppp(Integer.MAX_VALUE);
                }
            }
            if (i() == 1) {
                int intValue2 = num.intValue();
                if (intValue2 != 2) {
                    if (intValue2 == 3) {
                        nn(false);
                        ppp(Integer.MAX_VALUE);
                        return;
                    } else if (intValue2 != 4) {
                        return;
                    }
                }
                nn(true);
                ppp(Integer.MAX_VALUE);
            }
        }
    }

    public void ddd(@NonNull ActionHolder actionHolder, @NonNull List<MeteringRectangle> list) {
        f9279pf.de("onStarted:", "with areas:", list);
        if (this.f9280i && !list.isEmpty()) {
            actionHolder.rg(this).set(CaptureRequest.CONTROL_AE_REGIONS, (MeteringRectangle[]) list.subList(0, Math.min(((Integer) when(CameraCharacteristics.CONTROL_MAX_REGIONS_AE, 0)).intValue(), list.size())).toArray(new MeteringRectangle[0]));
        }
        if (this.f9281o) {
            actionHolder.rg(this).set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, 1);
        }
        actionHolder.pf(this);
        if (this.f9281o) {
            ppp(0);
        } else {
            ppp(1);
        }
    }

    public boolean ggg(@NonNull ActionHolder actionHolder) {
        boolean z = ((Integer) when(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL, -1)).intValue() == 2;
        Integer num = (Integer) actionHolder.rg(this).get(CaptureRequest.CONTROL_AE_MODE);
        boolean z2 = num != null && (num.intValue() == 1 || num.intValue() == 3 || num.intValue() == 2 || num.intValue() == 4 || num.intValue() == 5);
        this.f9281o = !z;
        boolean z3 = ((Integer) when(CameraCharacteristics.CONTROL_MAX_REGIONS_AE, 0)).intValue() > 0;
        this.f9280i = z3;
        boolean z4 = z2 && (this.f9281o || z3);
        f9279pf.de("checkIsSupported:", Boolean.valueOf(z4), "trigger:", Boolean.valueOf(this.f9281o), "areas:", Boolean.valueOf(this.f9280i));
        return z4;
    }

    /* renamed from: if  reason: not valid java name */
    public void m1057if(@NonNull ActionHolder actionHolder) {
        super.m1046if(actionHolder);
        actionHolder.rg(this).set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, (Object) null);
    }

    public boolean vvv(@NonNull ActionHolder actionHolder) {
        TotalCaptureResult totalCaptureResult = actionHolder.m714if(this);
        if (totalCaptureResult != null) {
            Integer num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AE_STATE);
            boolean z = num != null && num.intValue() == 2;
            f9279pf.de("checkShouldSkip:", Boolean.valueOf(z));
            return z;
        }
        f9279pf.de("checkShouldSkip: false - lastResult is null.");
        return false;
    }
}
