package i.qw;

import kotlin.Unit;
import kotlinx.coroutines.DisposableHandle;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class x extends u0 {
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    public final DisposableHandle f6247i;

    public x(@NotNull DisposableHandle disposableHandle) {
        this.f6247i = disposableHandle;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        s((Throwable) obj);
        return Unit.INSTANCE;
    }

    public void s(@Nullable Throwable th2) {
        this.f6247i.dispose();
    }
}
