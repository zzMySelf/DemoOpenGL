package fe.mmm.qw.tt.ad.ggg;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class de {
    public static final boolean qw(@NotNull View view, float f, float f2) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i2 = iArr[0];
        int i3 = iArr[1];
        boolean z = f2 >= ((float) i3) && f2 <= ((float) (view.getHeight() + i3));
        boolean z2 = f >= ((float) i2) && f <= ((float) (i2 + view.getWidth()));
        if (!z || !z2) {
            return false;
        }
        return true;
    }
}
