package fe.mmm.qw.xxx.o.de;

import android.app.Application;
import fe.mmm.qw.c.th;
import fe.mmm.qw.d.de.de;
import fe.mmm.qw.d.qw;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ppp extends th {
    @NotNull

    /* renamed from: yj  reason: collision with root package name */
    public final Application f8625yj;

    public ppp(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, "context");
        this.f8625yj = application;
    }

    public final void eee() {
        de.when().vvv(this.f8625yj);
        qw.o(true);
        qw.i(false);
        qw.qw();
    }

    public int i() {
        return 1;
    }

    @Nullable
    public String o() {
        return "SkinStartupTask";
    }

    public void xxx() {
        eee();
    }

    @Nullable
    public List<Class<? extends th>> yj() {
        return null;
    }
}
