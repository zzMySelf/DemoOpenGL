package i.qw.w1;

import i.qw.w1.i0.th;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.internal.FusibleFlow;
import org.jetbrains.annotations.NotNull;

public final /* synthetic */ class xxx {
    public static /* synthetic */ Flow ad(Flow flow, int i2, BufferOverflow bufferOverflow, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = -2;
        }
        if ((i3 & 2) != 0) {
            bufferOverflow = BufferOverflow.SUSPEND;
        }
        return de.qw(flow, i2, bufferOverflow);
    }

    @NotNull
    public static final <T> Flow<T> qw(@NotNull Flow<? extends T> flow, int i2, @NotNull BufferOverflow bufferOverflow) {
        BufferOverflow bufferOverflow2;
        int i3;
        boolean z = true;
        if (i2 >= 0 || i2 == -2 || i2 == -1) {
            if (i2 == -1 && bufferOverflow != BufferOverflow.SUSPEND) {
                z = false;
            }
            if (z) {
                if (i2 == -1) {
                    bufferOverflow2 = BufferOverflow.DROP_OLDEST;
                    i3 = 0;
                } else {
                    i3 = i2;
                    bufferOverflow2 = bufferOverflow;
                }
                if (flow instanceof FusibleFlow) {
                    return FusibleFlow.qw.qw((FusibleFlow) flow, (CoroutineContext) null, i3, bufferOverflow2, 1, (Object) null);
                }
                return new th(flow, (CoroutineContext) null, i3, bufferOverflow2, 2, (DefaultConstructorMarker) null);
            }
            throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow".toString());
        }
        throw new IllegalArgumentException(Intrinsics.stringPlus("Buffer size should be non-negative, BUFFERED, or CONFLATED, but was ", Integer.valueOf(i2)).toString());
    }
}
