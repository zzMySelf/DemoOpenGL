package fe.vvv.ad.fe;

import fe.vvv.ad.th.yj;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class qw {
    @NotNull
    public static final float[] ad(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "$this$makeIdentity");
        qw(fArr);
        yj.fe(fArr);
        return fArr;
    }

    public static final void qw(float[] fArr) {
        if (fArr.length != 16) {
            throw new RuntimeException("Need a 16 values matrix.");
        }
    }
}
