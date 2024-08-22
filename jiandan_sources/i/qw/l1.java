package i.qw;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class l1 {
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public static final ThreadLocal<z> f6141ad = new ThreadLocal<>();
    @NotNull
    public static final l1 qw = new l1();

    @NotNull
    public final z ad() {
        z zVar = f6141ad.get();
        if (zVar != null) {
            return zVar;
        }
        z qw2 = c0.qw();
        f6141ad.set(qw2);
        return qw2;
    }

    public final void de() {
        f6141ad.set((Object) null);
    }

    public final void fe(@NotNull z zVar) {
        f6141ad.set(zVar);
    }

    @Nullable
    public final z qw() {
        return f6141ad.get();
    }
}
