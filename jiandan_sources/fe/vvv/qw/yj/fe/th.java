package fe.vvv.qw.yj.fe;

import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.otaliastudios.cameraview.engine.action.Action;
import com.otaliastudios.cameraview.engine.action.ActionCallback;
import com.otaliastudios.cameraview.engine.action.ActionHolder;
import java.util.List;

@RequiresApi(21)
public class th extends de {

    /* renamed from: rg  reason: collision with root package name */
    public final List<de> f9205rg;

    /* renamed from: th  reason: collision with root package name */
    public int f9206th = -1;

    public class qw implements ActionCallback {
        public qw() {
        }

        public void qw(@NonNull Action action, int i2) {
            if (i2 == Integer.MAX_VALUE) {
                action.rg(this);
                th.this.vvv();
            }
        }
    }

    public th(@NonNull List<de> list) {
        this.f9205rg = list;
        vvv();
    }

    public void ad(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
        super.ad(actionHolder, captureRequest, totalCaptureResult);
        int i2 = this.f9206th;
        if (i2 >= 0) {
            this.f9205rg.get(i2).ad(actionHolder, captureRequest, totalCaptureResult);
        }
    }

    public void de(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest) {
        super.de(actionHolder, captureRequest);
        int i2 = this.f9206th;
        if (i2 >= 0) {
            this.f9205rg.get(i2).de(actionHolder, captureRequest);
        }
    }

    public void pf(@NonNull ActionHolder actionHolder) {
        super.pf(actionHolder);
        int i2 = this.f9206th;
        if (i2 >= 0) {
            this.f9205rg.get(i2).pf(actionHolder);
        }
    }

    /* renamed from: switch  reason: not valid java name */
    public void m1050switch(@NonNull ActionHolder actionHolder) {
        super.m1047switch(actionHolder);
        int i2 = this.f9206th;
        if (i2 >= 0) {
            this.f9205rg.get(i2).m1047switch(actionHolder);
        }
    }

    public void th(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest, @NonNull CaptureResult captureResult) {
        super.th(actionHolder, captureRequest, captureResult);
        int i2 = this.f9206th;
        if (i2 >= 0) {
            this.f9205rg.get(i2).th(actionHolder, captureRequest, captureResult);
        }
    }

    public final void vvv() {
        boolean z = false;
        boolean z2 = this.f9206th == -1;
        if (this.f9206th == this.f9205rg.size() - 1) {
            z = true;
        }
        if (z) {
            ppp(Integer.MAX_VALUE);
            return;
        }
        int i2 = this.f9206th + 1;
        this.f9206th = i2;
        this.f9205rg.get(i2).fe(new qw());
        if (!z2) {
            this.f9205rg.get(this.f9206th).m1047switch(uk());
        }
    }
}
