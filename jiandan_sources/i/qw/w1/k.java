package i.qw.w1;

import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class k implements FlowCollector<T> {
    @Nullable
    public abstract Object emit(Object obj, @NotNull Continuation continuation);
}
