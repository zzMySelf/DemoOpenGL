package fe.vvv.qw.yj.yj;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.MeteringRectangle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.otaliastudios.cameraview.CameraLogger;
import com.otaliastudios.cameraview.engine.action.ActionHolder;

@RequiresApi(21)
public class o extends ad {

    /* renamed from: th  reason: collision with root package name */
    public static final CameraLogger f9284th = CameraLogger.qw(o.class.getSimpleName());

    public o() {
        super(true);
    }

    public void ggg(@NonNull ActionHolder actionHolder, @Nullable MeteringRectangle meteringRectangle) {
        f9284th.i("onStarted:", "with area:", meteringRectangle);
        int intValue = ((Integer) when(CameraCharacteristics.CONTROL_MAX_REGIONS_AWB, 0)).intValue();
        if (meteringRectangle != null && intValue > 0) {
            actionHolder.rg(this).set(CaptureRequest.CONTROL_AWB_REGIONS, new MeteringRectangle[]{meteringRectangle});
            actionHolder.pf(this);
        }
        ppp(Integer.MAX_VALUE);
    }
}
