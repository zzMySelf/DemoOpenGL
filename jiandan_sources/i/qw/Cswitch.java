package i.qw;

import java.util.concurrent.Future;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* renamed from: i.qw.switch  reason: invalid class name */
public final class Cswitch extends when {
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public final Future<?> f6169ad;

    public Cswitch(@NotNull Future<?> future) {
        this.f6169ad = future;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        qw((Throwable) obj);
        return Unit.INSTANCE;
    }

    public void qw(@Nullable Throwable th2) {
        this.f6169ad.cancel(false);
    }

    @NotNull
    public String toString() {
        return "CancelFutureOnCancel[" + this.f6169ad + ']';
    }
}
