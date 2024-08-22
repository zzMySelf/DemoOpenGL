package i.qw.w1;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.CancellableFlow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.internal.FusibleFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class z<T> implements StateFlow<T>, CancellableFlow<T>, FusibleFlow<T> {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ StateFlow<T> f6246ad;

    public z(@NotNull StateFlow<? extends T> stateFlow, @Nullable Job job) {
        this.f6246ad = stateFlow;
    }

    @NotNull
    public Flow<T> ad(@NotNull CoroutineContext coroutineContext, int i2, @NotNull BufferOverflow bufferOverflow) {
        return f0.fe(this, coroutineContext, i2, bufferOverflow);
    }

    @Nullable
    public Object fe(@NotNull FlowCollector<? super T> flowCollector, @NotNull Continuation<? super Unit> continuation) {
        return this.f6246ad.fe(flowCollector, continuation);
    }
}
