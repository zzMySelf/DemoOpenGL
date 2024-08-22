package fe.mmm.qw.xxx.o.de;

import android.app.Application;
import com.mars.kotlin.extension.LoggerKt;
import fe.mmm.qw.c.th;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class qw extends th {
    @NotNull

    /* renamed from: yj  reason: collision with root package name */
    public final Application f8626yj;

    public qw(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, "context");
        this.f8626yj = application;
    }

    public int i() {
        return 1;
    }

    @Nullable
    public String o() {
        return "ARouterStartupTask";
    }

    public void xxx() {
        if (fe.mmm.qw.i.qw.o()) {
            fe.ad.qw.qw.ad.qw.i();
            fe.ad.qw.qw.ad.qw.uk();
        }
        try {
            fe.ad.qw.qw.ad.qw.fe(this.f8626yj);
        } catch (RuntimeException unused) {
            LoggerKt.d$default("class not found,scan and generate class again", (Object) null, 1, (Object) null);
            fe.ad.qw.qw.ad.qw.uk();
            fe.ad.qw.qw.ad.qw.fe(this.f8626yj);
        }
    }

    @Nullable
    public List<Class<? extends th>> yj() {
        return null;
    }
}
