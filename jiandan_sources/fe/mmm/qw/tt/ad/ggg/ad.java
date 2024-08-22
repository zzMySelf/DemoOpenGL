package fe.mmm.qw.tt.ad.ggg;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class ad {
    public static final boolean qw(int i2, @NotNull Object... objArr) {
        Intrinsics.checkNotNullParameter(objArr, "ints");
        for (Number number : objArr) {
            if ((number instanceof Integer) && i2 == number.intValue()) {
                return true;
            }
        }
        return false;
    }
}
