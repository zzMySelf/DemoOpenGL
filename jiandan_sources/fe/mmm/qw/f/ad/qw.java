package fe.mmm.qw.f.ad;

import android.content.Context;
import android.util.TypedValue;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class qw {
    public static final int qw(float f, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return (int) TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }
}
