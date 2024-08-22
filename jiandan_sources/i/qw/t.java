package i.qw;

import java.util.concurrent.Executor;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.CoroutineDispatcher;
import org.jetbrains.annotations.NotNull;

public final class t implements Executor {
    @NotNull
    @JvmField

    /* renamed from: ad  reason: collision with root package name */
    public final CoroutineDispatcher f6170ad;

    public void execute(@NotNull Runnable runnable) {
        this.f6170ad.dispatch(EmptyCoroutineContext.INSTANCE, runnable);
    }

    @NotNull
    public String toString() {
        return this.f6170ad.toString();
    }
}
