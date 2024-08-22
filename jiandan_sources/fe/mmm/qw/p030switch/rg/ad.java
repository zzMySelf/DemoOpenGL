package fe.mmm.qw.p030switch.rg;

import com.tera.scan.framework.framework.FrameworkDevice;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* renamed from: fe.mmm.qw.switch.rg.ad  reason: invalid package */
public final class ad {
    @Nullable
    public static Function0<? extends FrameworkDevice> qw;

    public static final void ad(@NotNull Function0<? extends FrameworkDevice> function0) {
        Intrinsics.checkNotNullParameter(function0, "life");
        qw = function0;
    }

    @NotNull
    public static final FrameworkDevice qw() {
        FrameworkDevice frameworkDevice;
        Function0<? extends FrameworkDevice> function0 = qw;
        if (function0 != null && (frameworkDevice = (FrameworkDevice) function0.invoke()) != null) {
            return frameworkDevice;
        }
        throw new RuntimeException("call initFrameworkLifecycle first!");
    }
}
