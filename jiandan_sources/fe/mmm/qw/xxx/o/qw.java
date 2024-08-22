package fe.mmm.qw.xxx.o;

import android.app.Application;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public abstract class qw {
    @NotNull
    public final Application qw;

    public qw(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, "context");
        this.qw = application;
    }

    @NotNull
    public final Application qw() {
        return this.qw;
    }
}
