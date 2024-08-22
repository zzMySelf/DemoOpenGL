package i.qw;

import java.util.concurrent.Future;
import kotlinx.coroutines.DisposableHandle;
import org.jetbrains.annotations.NotNull;

public final class v implements DisposableHandle {
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public final Future<?> f6201ad;

    public v(@NotNull Future<?> future) {
        this.f6201ad = future;
    }

    public void dispose() {
        this.f6201ad.cancel(false);
    }

    @NotNull
    public String toString() {
        return "DisposableFutureHandle[" + this.f6201ad + ']';
    }
}
