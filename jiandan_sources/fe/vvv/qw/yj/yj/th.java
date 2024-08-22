package fe.vvv.qw.yj.yj;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.MeteringRectangle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.otaliastudios.cameraview.CameraLogger;
import com.otaliastudios.cameraview.engine.action.ActionHolder;

@RequiresApi(21)
public class th extends ad {

    /* renamed from: th  reason: collision with root package name */
    public static final CameraLogger f9290th = CameraLogger.qw(th.class.getSimpleName());

    public th() {
        super(true);
    }

    public void ggg(@NonNull ActionHolder actionHolder, @Nullable MeteringRectangle meteringRectangle) {
        boolean z;
        Integer num;
        int intValue = ((Integer) when(CameraCharacteristics.CONTROL_MAX_REGIONS_AF, 0)).intValue();
        boolean z2 = true;
        if (meteringRectangle == null || intValue <= 0) {
            z = false;
        } else {
            actionHolder.rg(this).set(CaptureRequest.CONTROL_AF_REGIONS, new MeteringRectangle[]{meteringRectangle});
            z = true;
        }
        TotalCaptureResult totalCaptureResult = actionHolder.m714if(this);
        if (totalCaptureResult == null) {
            num = null;
        } else {
            num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AF_TRIGGER);
        }
        f9290th.i("onStarted:", "last focus trigger is", num);
        if (num == null || num.intValue() != 1) {
            z2 = z;
        } else {
            actionHolder.rg(this).set(CaptureRequest.CONTROL_AF_TRIGGER, 2);
        }
        if (z2) {
            actionHolder.pf(this);
        }
        ppp(Integer.MAX_VALUE);
    }
}
