package i.qw.x1;

import i.qw.z0;
import java.util.List;
import kotlinx.coroutines.internal.MainDispatcherFactory;
import org.jetbrains.annotations.NotNull;

public final class mmm {
    public static final boolean qw = true;

    public static /* synthetic */ aaa ad(Throwable th2, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            th2 = null;
        }
        if ((i2 & 2) != 0) {
            str = null;
        }
        return qw(th2, str);
    }

    @NotNull
    public static final Void de() {
        throw new IllegalStateException("Module with the Main dispatcher is missing. Add dependency providing the Main dispatcher, e.g. 'kotlinx-coroutines-android' and ensure it has the same version as 'kotlinx-coroutines-core'");
    }

    @NotNull
    public static final z0 fe(@NotNull MainDispatcherFactory mainDispatcherFactory, @NotNull List<? extends MainDispatcherFactory> list) {
        try {
            return mainDispatcherFactory.createDispatcher(list);
        } catch (Throwable th2) {
            return qw(th2, mainDispatcherFactory.hintOnError());
        }
    }

    public static final aaa qw(Throwable th2, String str) {
        if (qw) {
            return new aaa(th2, str);
        }
        if (th2 == null) {
            de();
            throw null;
        }
        throw th2;
    }
}
