package fe.vvv.qw.yj.rg;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.otaliastudios.cameraview.CameraLogger;
import com.otaliastudios.cameraview.engine.action.ActionHolder;

@RequiresApi(21)
public class de extends qw {

    /* renamed from: rg  reason: collision with root package name */
    public static final CameraLogger f9260rg = CameraLogger.qw(de.class.getSimpleName());

    public void ad(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
        super.ad(actionHolder, captureRequest, totalCaptureResult);
        Integer num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AF_STATE);
        Integer num2 = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AF_MODE);
        f9260rg.de("onCapture:", "afState:", num, "afMode:", num2);
        if (num != null && num2 != null && num2.intValue() == 1) {
            int intValue = num.intValue();
            if (intValue == 0 || intValue == 2 || intValue == 4 || intValue == 5 || intValue == 6) {
                ppp(Integer.MAX_VALUE);
            }
        }
    }

    public boolean ggg(@NonNull ActionHolder actionHolder) {
        for (int i2 : (int[]) when(CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES, new int[0])) {
            if (i2 == 1) {
                return true;
            }
        }
        return false;
    }

    public boolean vvv(@NonNull ActionHolder actionHolder) {
        TotalCaptureResult totalCaptureResult = actionHolder.m714if(this);
        if (totalCaptureResult != null) {
            Integer num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AF_STATE);
            boolean z = num != null && (num.intValue() == 4 || num.intValue() == 5 || num.intValue() == 0 || num.intValue() == 2 || num.intValue() == 6);
            Integer num2 = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AF_MODE);
            boolean z2 = z && (num2 != null && num2.intValue() == 1);
            f9260rg.de("checkShouldSkip:", Boolean.valueOf(z2));
            return z2;
        }
        f9260rg.de("checkShouldSkip: false - lastResult is null.");
        return false;
    }

    public void xxx(@NonNull ActionHolder actionHolder) {
        actionHolder.rg(this).set(CaptureRequest.CONTROL_AF_MODE, 1);
        actionHolder.rg(this).set(CaptureRequest.CONTROL_AF_TRIGGER, 2);
        actionHolder.pf(this);
    }
}
