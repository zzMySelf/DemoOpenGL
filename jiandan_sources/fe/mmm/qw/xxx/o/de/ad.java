package fe.mmm.qw.xxx.o.de;

import android.app.Application;
import android.os.SystemClock;
import com.google.common.net.MediaType;
import fe.mmm.qw.a.rg;
import fe.mmm.qw.c.th;
import fe.mmm.qw.i.qw;
import fe.mmm.qw.nn.qw.qw.i;
import fe.mmm.qw.yj.de;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ad extends th {
    @NotNull

    /* renamed from: yj  reason: collision with root package name */
    public final Application f8619yj;

    public ad(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, MediaType.APPLICATION_TYPE);
        this.f8619yj = application;
    }

    public final void eee() {
    }

    public int i() {
        return 2;
    }

    @Nullable
    public String o() {
        return "AsyncInitStartupTask";
    }

    public final void rrr() {
        i.yj(this.f8619yj);
        de.ppp().m1013switch("key_start_seesion_id", String.valueOf(System.currentTimeMillis()));
        de.ppp().ad();
        new rg().qw();
    }

    public void xxx() {
        rrr();
        SystemClock.sleep(500);
        try {
            eee();
        } catch (Exception e) {
            qw.th("AsyncInitStartupTask", "delete Webview GPUCache exception", e);
        }
    }

    @Nullable
    public List<Class<? extends th>> yj() {
        return null;
    }
}
