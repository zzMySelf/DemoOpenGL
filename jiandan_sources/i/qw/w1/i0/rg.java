package i.qw.w1.i0;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class rg implements FlowCollector<Flow<? extends T>> {
    @Nullable
    public abstract Object emit(Flow<? extends T> flow, @NotNull Continuation<? super Unit> continuation);
}
