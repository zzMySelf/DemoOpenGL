package i.qw.w1;

import i.qw.k;
import i.qw.w1.i0.Cswitch;
import i.qw.x1.c;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowImpl;
import org.jetbrains.annotations.NotNull;

public final class f0 {
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public static final c f6228ad = new c("PENDING");
    @NotNull
    public static final c qw = new c("NONE");

    @NotNull
    public static final <T> Flow<T> fe(@NotNull StateFlow<? extends T> stateFlow, @NotNull CoroutineContext coroutineContext, int i2, @NotNull BufferOverflow bufferOverflow) {
        boolean z = true;
        if (k.qw()) {
            if (!(i2 != -1)) {
                throw new AssertionError();
            }
        }
        if (i2 < 0 || i2 > 1) {
            z = false;
        }
        if ((z || i2 == -2) && bufferOverflow == BufferOverflow.DROP_OLDEST) {
            return stateFlow;
        }
        return b0.rg(stateFlow, coroutineContext, i2, bufferOverflow);
    }

    @NotNull
    public static final <T> MutableStateFlow<T> qw(T t) {
        if (t == null) {
            t = Cswitch.qw;
        }
        return new StateFlowImpl(t);
    }

    public static final void rg(@NotNull MutableStateFlow<Integer> mutableStateFlow, int i2) {
        int intValue;
        do {
            intValue = mutableStateFlow.getValue().intValue();
        } while (!mutableStateFlow.rg(Integer.valueOf(intValue), Integer.valueOf(intValue + i2)));
    }
}
