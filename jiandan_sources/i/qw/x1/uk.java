package i.qw.x1;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;

public final class uk implements CoroutineScope {
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public final CoroutineContext f6290ad;

    public uk(@NotNull CoroutineContext coroutineContext) {
        this.f6290ad = coroutineContext;
    }

    @NotNull
    public CoroutineContext getCoroutineContext() {
        return this.f6290ad;
    }

    @NotNull
    public String toString() {
        return "CoroutineScope(coroutineContext=" + getCoroutineContext() + ')';
    }
}
