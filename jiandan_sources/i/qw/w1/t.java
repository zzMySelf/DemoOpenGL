package i.qw.w1;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class t implements Flow<R> {
    @Nullable
    public abstract Object fe(@NotNull FlowCollector<? super R> flowCollector, @NotNull Continuation<? super Unit> continuation);
}
