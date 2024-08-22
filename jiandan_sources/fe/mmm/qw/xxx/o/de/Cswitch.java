package fe.mmm.qw.xxx.o.de;

import android.app.Application;
import com.tera.scan.framework.kernel.BaseApplication;
import com.tera.scan.main.service.NetdiskService;
import fe.mmm.qw.c.th;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* renamed from: fe.mmm.qw.xxx.o.de.switch  reason: invalid class name */
public final class Cswitch extends th {
    public Cswitch(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, "context");
    }

    public int i() {
        return 1;
    }

    @Nullable
    public String o() {
        return "SetSchedulerServiceStartupTask";
    }

    public void xxx() {
        BaseApplication.setSchedulerService(NetdiskService.class);
    }

    @Nullable
    public List<Class<? extends th>> yj() {
        return CollectionsKt__CollectionsKt.mutableListOf(de.class);
    }
}
