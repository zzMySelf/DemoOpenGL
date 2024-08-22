package fe.mmm.qw.p030switch.rg;

import com.tera.scan.framework.framework.FrameworkLifecycle;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* renamed from: fe.mmm.qw.switch.rg.de  reason: invalid package */
public final class de {
    @Nullable
    public static Function0<? extends FrameworkLifecycle> qw;

    public static final void ad(@NotNull Function0<? extends FrameworkLifecycle> function0) {
        Intrinsics.checkNotNullParameter(function0, "life");
        qw = function0;
    }

    @NotNull
    public static final FrameworkLifecycle qw() {
        FrameworkLifecycle frameworkLifecycle;
        Function0<? extends FrameworkLifecycle> function0 = qw;
        if (function0 != null && (frameworkLifecycle = (FrameworkLifecycle) function0.invoke()) != null) {
            return frameworkLifecycle;
        }
        throw new RuntimeException("call initFrameworkLifecycle first!");
    }
}
