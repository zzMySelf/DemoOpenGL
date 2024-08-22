package fe.vvv.qw.yj.rg;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.otaliastudios.cameraview.CameraLogger;
import com.otaliastudios.cameraview.engine.action.ActionHolder;

@RequiresApi(21)
public class ad extends qw {

    /* renamed from: rg  reason: collision with root package name */
    public static final CameraLogger f9259rg = CameraLogger.qw(ad.class.getSimpleName());

    public void ad(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
        super.ad(actionHolder, captureRequest, totalCaptureResult);
        Integer num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AE_STATE);
        f9259rg.de("processCapture:", "aeState:", num);
        if (num != null && num.intValue() == 3) {
            ppp(Integer.MAX_VALUE);
        }
    }

    public boolean ggg(@NonNull ActionHolder actionHolder) {
        boolean z = ((Integer) when(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL, -1)).intValue() != 2;
        Integer num = (Integer) actionHolder.rg(this).get(CaptureRequest.CONTROL_AE_MODE);
        boolean z2 = z && (num != null && (num.intValue() == 1 || num.intValue() == 3 || num.intValue() == 2 || num.intValue() == 4 || num.intValue() == 5));
        f9259rg.de("checkIsSupported:", Boolean.valueOf(z2));
        return z2;
    }

    public boolean vvv(@NonNull ActionHolder actionHolder) {
        TotalCaptureResult totalCaptureResult = actionHolder.m714if(this);
        if (totalCaptureResult != null) {
            Integer num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AE_STATE);
            boolean z = num != null && num.intValue() == 3;
            f9259rg.de("checkShouldSkip:", Boolean.valueOf(z));
            return z;
        }
        f9259rg.de("checkShouldSkip: false - lastResult is null.");
        return false;
    }

    public void xxx(@NonNull ActionHolder actionHolder) {
        actionHolder.rg(this).set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, Integer.valueOf(Build.VERSION.SDK_INT >= 23 ? 2 : 0));
        actionHolder.rg(this).set(CaptureRequest.CONTROL_AE_LOCK, Boolean.TRUE);
        actionHolder.pf(this);
    }
}
