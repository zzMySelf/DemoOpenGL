package i.qw;

import kotlin.Unit;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineDispatcher;
import org.jetbrains.annotations.NotNull;

public final class f1 implements Runnable {
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public final CoroutineDispatcher f6122ad;
    @NotNull

    /* renamed from: th  reason: collision with root package name */
    public final CancellableContinuation<Unit> f6123th;

    public f1(@NotNull CoroutineDispatcher coroutineDispatcher, @NotNull CancellableContinuation<? super Unit> cancellableContinuation) {
        this.f6122ad = coroutineDispatcher;
        this.f6123th = cancellableContinuation;
    }

    public void run() {
        this.f6123th.b(this.f6122ad, Unit.INSTANCE);
    }
}
