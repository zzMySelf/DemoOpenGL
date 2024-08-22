package fe.vvv.qw.yj.yj;

import android.graphics.Rect;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.MeteringRectangle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.otaliastudios.cameraview.engine.action.ActionHolder;
import fe.vvv.qw.yj.fe.de;

@RequiresApi(21)
public abstract class ad extends de {

    /* renamed from: rg  reason: collision with root package name */
    public boolean f9278rg;

    public ad(boolean z) {
        this.f9278rg = z;
    }

    public abstract void ggg(@NonNull ActionHolder actionHolder, @Nullable MeteringRectangle meteringRectangle);

    /* renamed from: switch  reason: not valid java name */
    public final void m1056switch(@NonNull ActionHolder actionHolder) {
        super.m1047switch(actionHolder);
        ggg(actionHolder, this.f9278rg ? new MeteringRectangle((Rect) when(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE, new Rect()), 0) : null);
    }
}
