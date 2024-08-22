package fe.vvv.qw.yj.fe;

import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.otaliastudios.cameraview.engine.action.Action;
import com.otaliastudios.cameraview.engine.action.ActionCallback;
import com.otaliastudios.cameraview.engine.action.ActionHolder;

@RequiresApi(21)
public abstract class qw extends de {

    /* renamed from: fe.vvv.qw.yj.fe.qw$qw  reason: collision with other inner class name */
    public class C0320qw implements ActionCallback {
        public C0320qw() {
        }

        public void qw(@NonNull Action action, int i2) {
            qw.this.ppp(i2);
            if (i2 == Integer.MAX_VALUE) {
                action.rg(this);
            }
        }
    }

    public void ad(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
        super.ad(actionHolder, captureRequest, totalCaptureResult);
        ggg().ad(actionHolder, captureRequest, totalCaptureResult);
    }

    public void de(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest) {
        super.de(actionHolder, captureRequest);
        ggg().de(actionHolder, captureRequest);
    }

    @NonNull
    public abstract de ggg();

    public void pf(@NonNull ActionHolder actionHolder) {
        super.pf(actionHolder);
        ggg().pf(actionHolder);
    }

    /* renamed from: switch  reason: not valid java name */
    public void m1048switch(@NonNull ActionHolder actionHolder) {
        super.m1047switch(actionHolder);
        ggg().fe(new C0320qw());
        ggg().m1047switch(actionHolder);
    }

    public void th(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest, @NonNull CaptureResult captureResult) {
        super.th(actionHolder, captureRequest, captureResult);
        ggg().th(actionHolder, captureRequest, captureResult);
    }
}
