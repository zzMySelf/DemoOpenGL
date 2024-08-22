package fe.mmm.qw.xxx.o.de;

import android.app.Application;
import fe.mmm.qw.c.th;
import fe.mmm.qw.de.ad.qw.qw;
import fe.mmm.qw.th.qw.de.de;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class uk extends th {
    @NotNull

    /* renamed from: yj  reason: collision with root package name */
    public final Application f8630yj;

    public uk(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, "context");
        this.f8630yj = application;
    }

    public int i() {
        return 0;
    }

    @Nullable
    public String o() {
        return "NetdiskCommonConfigStartupTask";
    }

    public int uk() {
        return 0;
    }

    public void xxx() {
        de.qw(this.f8630yj, true, qw.when, "58296630", "203");
        System.setProperty("java.net.preferIPv6Addresses", "true");
    }

    @Nullable
    public List<Class<? extends th>> yj() {
        return null;
    }
}
