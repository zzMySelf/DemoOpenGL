package fe.vvv.ad.de;

import android.graphics.RectF;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public abstract class qw extends ad {

    /* renamed from: de  reason: collision with root package name */
    public final int f8828de = 2;

    public final int ad() {
        return this.f8828de;
    }

    public final void uk(@NotNull RectF rectF) {
        Intrinsics.checkNotNullParameter(rectF, "rect");
        float f = Float.MAX_VALUE;
        float f2 = Float.MAX_VALUE;
        float f3 = -3.4028235E38f;
        float f4 = -3.4028235E38f;
        int i2 = 0;
        while (fe().hasRemaining()) {
            float f5 = fe().get();
            if (i2 % 2 == 0) {
                f = Math.min(f, f5);
                f4 = Math.max(f4, f5);
            } else {
                f3 = Math.max(f3, f5);
                f2 = Math.min(f2, f5);
            }
            i2++;
        }
        fe().rewind();
        rectF.set(f, f3, f4, f2);
    }
}
