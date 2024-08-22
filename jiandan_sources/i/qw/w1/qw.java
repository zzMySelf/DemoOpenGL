package i.qw.w1;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.channels.ProducerScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class qw<T> extends ad<T> {
    @Nullable
    public abstract Object i(@NotNull ProducerScope<? super T> producerScope, @NotNull Continuation<? super Unit> continuation);
}
