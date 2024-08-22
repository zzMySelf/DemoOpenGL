package fe.mmm.qw.ggg;

import android.content.Context;
import com.tera.scan.libanalytics.ScanAnalyticsBaseEvent;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class qw implements ScanAnalyticsBaseEvent {
    @NotNull
    public static final qw qw = new qw();

    public void ad(@NotNull Context context, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void de() {
    }

    public final void fe(int i2) {
    }

    public void qw(@NotNull String str, @Nullable List<String> list) {
        Intrinsics.checkNotNullParameter(str, "eventName");
    }

    public final void rg(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "ndus");
    }

    public final void th(boolean z) {
    }

    public final void yj(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "uid");
    }
}
