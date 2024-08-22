package i.qw.w1;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ggg implements FlowCollector<T> {
    @Nullable
    public abstract Object emit(T t, @NotNull Continuation<? super Unit> continuation);
}
