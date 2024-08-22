package fe.vvv.qw.yj.yj;

import android.hardware.camera2.params.MeteringRectangle;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.otaliastudios.cameraview.CameraLogger;
import com.otaliastudios.cameraview.engine.action.ActionHolder;
import fe.vvv.qw.yj.fe.de;
import java.util.List;

@RequiresApi(21)
public abstract class qw extends de {

    /* renamed from: uk  reason: collision with root package name */
    public static final CameraLogger f9285uk = CameraLogger.qw(qw.class.getSimpleName());

    /* renamed from: rg  reason: collision with root package name */
    public final List<MeteringRectangle> f9286rg;

    /* renamed from: th  reason: collision with root package name */
    public boolean f9287th;

    /* renamed from: yj  reason: collision with root package name */
    public boolean f9288yj;

    public qw(@NonNull List<MeteringRectangle> list, boolean z) {
        this.f9286rg = list;
        this.f9288yj = z;
    }

    public abstract void ddd(@NonNull ActionHolder actionHolder, @NonNull List<MeteringRectangle> list);

    public abstract boolean ggg(@NonNull ActionHolder actionHolder);

    public void nn(boolean z) {
        this.f9287th = z;
    }

    /* renamed from: switch  reason: not valid java name */
    public final void m1058switch(@NonNull ActionHolder actionHolder) {
        super.m1047switch(actionHolder);
        boolean z = this.f9288yj && vvv(actionHolder);
        if (!ggg(actionHolder) || z) {
            f9285uk.de("onStart:", "not supported or skipped. Dispatching COMPLETED state.");
            nn(true);
            ppp(Integer.MAX_VALUE);
            return;
        }
        f9285uk.de("onStart:", "supported and not skipped. Dispatching onStarted.");
        ddd(actionHolder, this.f9286rg);
    }

    public abstract boolean vvv(@NonNull ActionHolder actionHolder);

    public boolean xxx() {
        return this.f9287th;
    }
}
