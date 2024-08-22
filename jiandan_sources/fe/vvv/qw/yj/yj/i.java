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
public class i extends qw {

    /* renamed from: i  reason: collision with root package name */
    public static final CameraLogger f9283i = CameraLogger.qw(i.class.getSimpleName());

    public i(@NonNull List<MeteringRectangle> list, boolean z) {
        super(list, z);
    }

    public void ad(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
        super.ad(actionHolder, captureRequest, totalCaptureResult);
        Integer num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AWB_STATE);
        f9283i.de("onCaptureCompleted:", "awbState:", num);
        if (num != null) {
            int intValue = num.intValue();
            if (intValue == 2) {
                nn(true);
                ppp(Integer.MAX_VALUE);
            } else if (intValue == 3) {
                nn(false);
                ppp(Integer.MAX_VALUE);
            }
        }
    }

    public void ddd(@NonNull ActionHolder actionHolder, @NonNull List<MeteringRectangle> list) {
        f9283i.de("onStarted:", "with areas:", list);
        int intValue = ((Integer) when(CameraCharacteristics.CONTROL_MAX_REGIONS_AWB, 0)).intValue();
        if (!list.isEmpty() && intValue > 0) {
            actionHolder.rg(this).set(CaptureRequest.CONTROL_AWB_REGIONS, (MeteringRectangle[]) list.subList(0, Math.min(intValue, list.size())).toArray(new MeteringRectangle[0]));
            actionHolder.pf(this);
        }
    }

    public boolean ggg(@NonNull ActionHolder actionHolder) {
        boolean z = ((Integer) when(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL, -1)).intValue() != 2;
        Integer num = (Integer) actionHolder.rg(this).get(CaptureRequest.CONTROL_AWB_MODE);
        boolean z2 = z && num != null && num.intValue() == 1;
        f9283i.de("checkIsSupported:", Boolean.valueOf(z2));
        return z2;
    }

    public boolean vvv(@NonNull ActionHolder actionHolder) {
        TotalCaptureResult totalCaptureResult = actionHolder.m714if(this);
        if (totalCaptureResult != null) {
            Integer num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AWB_STATE);
            boolean z = num != null && num.intValue() == 2;
            f9283i.de("checkShouldSkip:", Boolean.valueOf(z));
            return z;
        }
        f9283i.de("checkShouldSkip: false - lastResult is null.");
        return false;
    }
}
