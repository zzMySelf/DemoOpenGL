package fe.mmm.qw.xxx.o.de;

import android.app.Application;
import com.tera.scan.framework.kernel.BaseApplication;
import com.tera.scan.main.service.NetdiskService;
import fe.mmm.qw.c.th;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class pf extends th {
    @NotNull

    /* renamed from: yj  reason: collision with root package name */
    public final Application f8624yj;

    public pf(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, "context");
        this.f8624yj = application;
    }

    public int i() {
        return 1;
    }

    @Nullable
    public String o() {
        return "SchedulerManagerInitStartupTask";
    }

    public void xxx() {
        Application application = this.f8624yj;
        BaseApplication baseApplication = application instanceof BaseApplication ? (BaseApplication) application : null;
        if (baseApplication != null) {
            baseApplication.initSchedulerManager(NetdiskService.class);
        }
    }

    @Nullable
    public List<Class<? extends th>> yj() {
        return null;
    }
}
