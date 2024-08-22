package fe.vvv.ad.ad;

import com.otaliastudios.opengl.core.GlBindable;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class rg {
    public static final void qw(@NotNull GlBindable glBindable, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(glBindable, "$this$use");
        Intrinsics.checkNotNullParameter(function0, "block");
        glBindable.ad();
        function0.invoke();
        glBindable.qw();
    }
}
