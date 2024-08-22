package fe.mmm.qw.xxx.o.de;

import android.app.Application;
import fe.fe.pf.th.qw.ad;
import fe.mmm.qw.c.th;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class de extends th {
    @NotNull

    /* renamed from: yj  reason: collision with root package name */
    public final Application f8620yj;

    public de(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, "context");
        this.f8620yj = application;
    }

    public final void eee() {
        ad.C0140ad.de(this.f8620yj.getApplicationContext()).ad().nn();
    }

    public int i() {
        return 1;
    }

    @Nullable
    public String o() {
        return "AxeCUIDCreateStartupTask";
    }

    public int uk() {
        return 0;
    }

    public void xxx() {
        eee();
    }

    @Nullable
    public List<Class<? extends th>> yj() {
        return null;
    }
}
