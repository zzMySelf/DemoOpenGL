package fe.vvv.ad.i;

import com.otaliastudios.opengl.types.Disposable;
import java.nio.Buffer;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class ad {
    public static final void qw(@NotNull Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "$this$dispose");
        if (buffer instanceof Disposable) {
            ((Disposable) buffer).dispose();
        }
    }
}
