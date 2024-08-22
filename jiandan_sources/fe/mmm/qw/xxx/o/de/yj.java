package fe.mmm.qw.xxx.o.de;

import android.app.Application;
import fe.mmm.qw.c.th;
import fe.mmm.qw.xxx.fe;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class yj extends th {
    @NotNull

    /* renamed from: yj  reason: collision with root package name */
    public final Application f8631yj;

    public yj(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, "context");
        this.f8631yj = application;
    }

    public int i() {
        return 0;
    }

    @Nullable
    public String o() {
        return "LifecycleStartupTask";
    }

    public void xxx() {
        this.f8631yj.registerActivityLifecycleCallbacks(new fe());
    }

    @Nullable
    public List<Class<? extends th>> yj() {
        return null;
    }
}
