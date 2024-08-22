package fe.mmm.qw.tt.ad;

import android.content.Context;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* renamed from: fe.mmm.qw.tt.ad.if  reason: invalid class name */
public final class Cif {
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public final Vibrator f8405ad;
    @NotNull
    public final Context qw;

    public Cif(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.qw = context;
        Object systemService = context.getSystemService("vibrator");
        if (systemService != null) {
            this.f8405ad = (Vibrator) systemService;
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.os.Vibrator");
    }

    public final void ad() {
        if (this.f8405ad.hasVibrator()) {
            if (Build.VERSION.SDK_INT >= 26) {
                this.f8405ad.vibrate(VibrationEffect.createOneShot(20, 70));
            } else {
                this.f8405ad.vibrate(20);
            }
        }
    }

    public final void qw() {
        this.f8405ad.cancel();
    }
}
