package fe.vvv.qw.yj.fe;

import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.otaliastudios.cameraview.engine.action.Action;
import com.otaliastudios.cameraview.engine.action.ActionCallback;
import com.otaliastudios.cameraview.engine.action.ActionHolder;
import java.util.ArrayList;
import java.util.List;

@RequiresApi(21)
public class uk extends de {

    /* renamed from: rg  reason: collision with root package name */
    public final List<de> f9207rg;

    /* renamed from: th  reason: collision with root package name */
    public final List<de> f9208th;

    public class qw implements ActionCallback {
        public qw() {
        }

        public void qw(@NonNull Action action, int i2) {
            if (i2 == Integer.MAX_VALUE) {
                uk.this.f9208th.remove(action);
            }
            if (uk.this.f9208th.isEmpty()) {
                uk.this.ppp(Integer.MAX_VALUE);
            }
        }
    }

    public uk(@NonNull List<de> list) {
        this.f9207rg = new ArrayList(list);
        this.f9208th = new ArrayList(list);
        for (de fe2 : list) {
            fe2.fe(new qw());
        }
    }

    public void ad(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
        super.ad(actionHolder, captureRequest, totalCaptureResult);
        for (de next : this.f9207rg) {
            if (!next.o()) {
                next.ad(actionHolder, captureRequest, totalCaptureResult);
            }
        }
    }

    public void de(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest) {
        super.de(actionHolder, captureRequest);
        for (de next : this.f9207rg) {
            if (!next.o()) {
                next.de(actionHolder, captureRequest);
            }
        }
    }

    public void pf(@NonNull ActionHolder actionHolder) {
        super.pf(actionHolder);
        for (de next : this.f9207rg) {
            if (!next.o()) {
                next.pf(actionHolder);
            }
        }
    }

    /* renamed from: switch  reason: not valid java name */
    public void m1051switch(@NonNull ActionHolder actionHolder) {
        super.m1047switch(actionHolder);
        for (de next : this.f9207rg) {
            if (!next.o()) {
                next.m1047switch(actionHolder);
            }
        }
    }

    public void th(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest, @NonNull CaptureResult captureResult) {
        super.th(actionHolder, captureRequest, captureResult);
        for (de next : this.f9207rg) {
            if (!next.o()) {
                next.th(actionHolder, captureRequest, captureResult);
            }
        }
    }
}
