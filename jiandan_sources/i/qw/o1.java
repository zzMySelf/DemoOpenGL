package i.qw;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineDispatcher;
import org.jetbrains.annotations.NotNull;

public final class o1 extends CoroutineDispatcher {
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public static final o1 f6155ad = new o1();

    public void dispatch(@NotNull CoroutineContext coroutineContext, @NotNull Runnable runnable) {
        r1 r1Var = (r1) coroutineContext.get(r1.f6163th);
        if (r1Var != null) {
            r1Var.f6164ad = true;
            return;
        }
        throw new UnsupportedOperationException("Dispatchers.Unconfined.dispatch function can only be used by the yield function. If you wrap Unconfined dispatcher in your code, make sure you properly delegate isDispatchNeeded and dispatch calls.");
    }

    public boolean isDispatchNeeded(@NotNull CoroutineContext coroutineContext) {
        return false;
    }

    @NotNull
    public String toString() {
        return "Dispatchers.Unconfined";
    }
}
