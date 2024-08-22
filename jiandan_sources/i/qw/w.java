package i.qw;

import kotlin.Unit;
import kotlinx.coroutines.DisposableHandle;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class w extends when {
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public final DisposableHandle f6217ad;

    public w(@NotNull DisposableHandle disposableHandle) {
        this.f6217ad = disposableHandle;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        qw((Throwable) obj);
        return Unit.INSTANCE;
    }

    public void qw(@Nullable Throwable th2) {
        this.f6217ad.dispose();
    }

    @NotNull
    public String toString() {
        return "DisposeOnCancel[" + this.f6217ad + ']';
    }
}
