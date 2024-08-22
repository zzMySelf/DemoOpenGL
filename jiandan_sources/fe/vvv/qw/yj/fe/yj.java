package fe.vvv.qw.yj.fe;

import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.otaliastudios.cameraview.engine.action.ActionHolder;

@RequiresApi(21)
public class yj extends qw {

    /* renamed from: rg  reason: collision with root package name */
    public long f9209rg;

    /* renamed from: th  reason: collision with root package name */
    public long f9210th;

    /* renamed from: yj  reason: collision with root package name */
    public de f9211yj;

    public yj(long j, @NonNull de deVar) {
        this.f9210th = j;
        this.f9211yj = deVar;
    }

    public void ad(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
        super.ad(actionHolder, captureRequest, totalCaptureResult);
        if (!o() && System.currentTimeMillis() > this.f9209rg + this.f9210th) {
            ggg().qw(actionHolder);
        }
    }

    @NonNull
    public de ggg() {
        return this.f9211yj;
    }

    /* renamed from: switch  reason: not valid java name */
    public void m1052switch(@NonNull ActionHolder actionHolder) {
        this.f9209rg = System.currentTimeMillis();
        super.m1048switch(actionHolder);
    }
}
