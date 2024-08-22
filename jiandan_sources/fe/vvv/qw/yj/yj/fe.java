package fe.vvv.qw.yj.yj;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.MeteringRectangle;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.otaliastudios.cameraview.CameraLogger;
import com.otaliastudios.cameraview.engine.action.ActionHolder;

@RequiresApi(21)
public class fe extends ad {

    /* renamed from: th  reason: collision with root package name */
    public static final CameraLogger f9282th = CameraLogger.qw(fe.class.getSimpleName());

    public fe() {
        super(true);
    }

    public void ad(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
        super.ad(actionHolder, captureRequest, totalCaptureResult);
        if (i() == 0) {
            actionHolder.rg(this).set(CaptureRequest.CONTROL_AE_LOCK, Boolean.FALSE);
            actionHolder.pf(this);
            ppp(Integer.MAX_VALUE);
        }
    }

    public void ggg(@NonNull ActionHolder actionHolder, @Nullable MeteringRectangle meteringRectangle) {
        Integer num;
        int intValue = ((Integer) when(CameraCharacteristics.CONTROL_MAX_REGIONS_AE, 0)).intValue();
        if (meteringRectangle != null && intValue > 0) {
            actionHolder.rg(this).set(CaptureRequest.CONTROL_AE_REGIONS, new MeteringRectangle[]{meteringRectangle});
        }
        TotalCaptureResult totalCaptureResult = actionHolder.m714if(this);
        if (totalCaptureResult == null) {
            num = null;
        } else {
            num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AE_PRECAPTURE_TRIGGER);
        }
        int i2 = 2;
        f9282th.de("onStarted:", "last precapture trigger is", num);
        if (num != null && num.intValue() == 1) {
            f9282th.de("onStarted:", "canceling precapture.");
            if (Build.VERSION.SDK_INT < 23) {
                i2 = 0;
            }
            actionHolder.rg(this).set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, Integer.valueOf(i2));
        }
        actionHolder.rg(this).set(CaptureRequest.CONTROL_AE_LOCK, Boolean.TRUE);
        actionHolder.pf(this);
        ppp(0);
    }
}
