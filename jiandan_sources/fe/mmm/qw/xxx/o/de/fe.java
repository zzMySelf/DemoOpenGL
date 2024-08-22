package fe.mmm.qw.xxx.o.de;

import android.app.Application;
import com.baidu.android.common.util.DeviceId;
import com.google.common.net.MediaType;
import fe.mmm.qw.c.th;
import fe.mmm.qw.de.ad.qw.qw;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class fe extends th {
    @NotNull

    /* renamed from: yj  reason: collision with root package name */
    public final Application f8621yj;

    public fe(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, MediaType.APPLICATION_TYPE);
        this.f8621yj = application;
    }

    public int i() {
        return 1;
    }

    @Nullable
    public String o() {
        return "CUID3StartupTask";
    }

    public int uk() {
        return 0;
    }

    public void xxx() {
        qw.f7750o = DeviceId.getCUID(this.f8621yj);
    }

    @Nullable
    public List<Class<? extends th>> yj() {
        return null;
    }
}
