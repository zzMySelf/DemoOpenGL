package fe.mmm.qw.xxx.o.de;

import android.app.Application;
import fe.mmm.qw.c.th;
import fe.mmm.qw.p030switch.th.de.ad.qw;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class rg extends th {
    @NotNull

    /* renamed from: yj  reason: collision with root package name */
    public final Application f8627yj;

    public rg(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, "context");
        this.f8627yj = application;
    }

    public int i() {
        return 1;
    }

    @Nullable
    public String o() {
        return "DensityStartupTask";
    }

    public void xxx() {
        qw.th(this.f8627yj);
    }

    @Nullable
    public List<Class<? extends th>> yj() {
        return null;
    }
}
