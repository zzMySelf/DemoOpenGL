package fe.vvv.ad.uk;

import fe.vvv.ad.ad.qw;
import fe.vvv.ad.th.rg;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public abstract class ad extends de {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ad(@NotNull qw qwVar, @NotNull rg rgVar) {
        super(qwVar, rgVar);
        Intrinsics.checkNotNullParameter(qwVar, "eglCore");
        Intrinsics.checkNotNullParameter(rgVar, "eglSurface");
    }

    public final boolean pf() {
        return qw().uk(ad());
    }
}
