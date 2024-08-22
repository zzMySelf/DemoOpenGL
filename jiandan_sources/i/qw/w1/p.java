package i.qw.w1;

import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class p implements Flow<R> {
    @Nullable
    public abstract Object fe(@NotNull FlowCollector flowCollector, @NotNull Continuation continuation);
}
