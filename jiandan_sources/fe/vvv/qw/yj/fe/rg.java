package fe.vvv.qw.yj.fe;

import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.otaliastudios.cameraview.CameraLogger;
import com.otaliastudios.cameraview.engine.CameraEngine;
import com.otaliastudios.cameraview.engine.action.ActionHolder;

@RequiresApi(21)
public class rg extends de {

    /* renamed from: th  reason: collision with root package name */
    public static final CameraLogger f9203th = CameraLogger.qw(CameraEngine.class.getSimpleName());

    /* renamed from: rg  reason: collision with root package name */
    public String f9204rg;

    public void ad(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
        super.ad(actionHolder, captureRequest, totalCaptureResult);
        String str = "aeMode: " + ((Integer) totalCaptureResult.get(CaptureResult.CONTROL_AE_MODE)) + " aeLock: " + ((Boolean) totalCaptureResult.get(CaptureResult.CONTROL_AE_LOCK)) + " aeState: " + ((Integer) totalCaptureResult.get(CaptureResult.CONTROL_AE_STATE)) + " aeTriggerState: " + ((Integer) totalCaptureResult.get(CaptureResult.CONTROL_AE_PRECAPTURE_TRIGGER)) + " afState: " + ((Integer) totalCaptureResult.get(CaptureResult.CONTROL_AF_STATE)) + " afTriggerState: " + ((Integer) totalCaptureResult.get(CaptureResult.CONTROL_AF_TRIGGER));
        if (!str.equals(this.f9204rg)) {
            this.f9204rg = str;
            f9203th.de(str);
        }
    }

    /* renamed from: if  reason: not valid java name */
    public void m1049if(@NonNull ActionHolder actionHolder) {
        super.m1046if(actionHolder);
        ppp(0);
        yj(actionHolder);
    }
}
