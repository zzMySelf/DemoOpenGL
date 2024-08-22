package i.qw.t1;

import i.qw.z0;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.DisposableHandle;
import org.jetbrains.annotations.NotNull;

public abstract class qw extends z0 implements Delay {
    public qw() {
    }

    public /* synthetic */ qw(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @NotNull
    public DisposableHandle uk(long j, @NotNull Runnable runnable, @NotNull CoroutineContext coroutineContext) {
        return Delay.qw.qw(this, j, runnable, coroutineContext);
    }
}
