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
public class rg extends qw {

    /* renamed from: i  reason: collision with root package name */
    public static final CameraLogger f9289i = CameraLogger.qw(rg.class.getSimpleName());

    public rg(@NonNull List<MeteringRectangle> list, boolean z) {
        super(list, z);
    }

    public void ad(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
        super.ad(actionHolder, captureRequest, totalCaptureResult);
        Integer num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AF_STATE);
        f9289i.de("onCaptureCompleted:", "afState:", num);
        if (num != null) {
            int intValue = num.intValue();
            if (intValue == 4) {
                nn(true);
                ppp(Integer.MAX_VALUE);
            } else if (intValue == 5) {
                nn(false);
                ppp(Integer.MAX_VALUE);
            }
        }
    }

    public void ddd(@NonNull ActionHolder actionHolder, @NonNull List<MeteringRectangle> list) {
        f9289i.de("onStarted:", "with areas:", list);
        actionHolder.rg(this).set(CaptureRequest.CONTROL_AF_TRIGGER, 1);
        int intValue = ((Integer) when(CameraCharacteristics.CONTROL_MAX_REGIONS_AF, 0)).intValue();
        if (!list.isEmpty() && intValue > 0) {
            actionHolder.rg(this).set(CaptureRequest.CONTROL_AF_REGIONS, (MeteringRectangle[]) list.subList(0, Math.min(intValue, list.size())).toArray(new MeteringRectangle[0]));
        }
        actionHolder.pf(this);
    }

    public boolean ggg(@NonNull ActionHolder actionHolder) {
        Integer num = (Integer) actionHolder.rg(this).get(CaptureRequest.CONTROL_AF_MODE);
        boolean z = num != null && (num.intValue() == 1 || num.intValue() == 4 || num.intValue() == 3 || num.intValue() == 2);
        f9289i.de("checkIsSupported:", Boolean.valueOf(z));
        return z;
    }

    /* renamed from: if  reason: not valid java name */
    public void m1059if(@NonNull ActionHolder actionHolder) {
        super.m1046if(actionHolder);
        actionHolder.rg(this).set(CaptureRequest.CONTROL_AF_TRIGGER, (Object) null);
    }

    public boolean vvv(@NonNull ActionHolder actionHolder) {
        TotalCaptureResult totalCaptureResult = actionHolder.m714if(this);
        if (totalCaptureResult != null) {
            Integer num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AF_STATE);
            boolean z = num != null && (num.intValue() == 4 || num.intValue() == 2);
            f9289i.de("checkShouldSkip:", Boolean.valueOf(z));
            return z;
        }
        f9289i.de("checkShouldSkip: false - lastResult is null.");
        return false;
    }
}
