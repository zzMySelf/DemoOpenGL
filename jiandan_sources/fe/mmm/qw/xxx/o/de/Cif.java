package fe.mmm.qw.xxx.o.de;

import android.app.Application;
import android.os.Build;
import com.tera.scan.framework.kernel.BaseApplication;
import com.tera.scan.main.service.NetdiskJobService;
import fe.mmm.qw.c.th;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* renamed from: fe.mmm.qw.xxx.o.de.if  reason: invalid class name */
public final class Cif extends th {
    public Cif(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, "context");
    }

    public int i() {
        return 1;
    }

    @Nullable
    public String o() {
        return "SetAppBackgroundSchedulerServiceStartupTask";
    }

    public void xxx() {
        if (26 <= Build.VERSION.SDK_INT) {
            BaseApplication.setAppBackgroundSchedulerService(NetdiskJobService.class);
        }
    }

    @Nullable
    public List<Class<? extends th>> yj() {
        return null;
    }
}
