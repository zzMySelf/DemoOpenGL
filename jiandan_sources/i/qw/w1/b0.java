package i.qw.w1;

import i.qw.w1.i0.th;
import i.qw.x1.c;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowImpl;
import org.jetbrains.annotations.NotNull;

public final class b0 {
    @NotNull
    @JvmField
    public static final c qw = new c("NO_VALUE");

    public static /* synthetic */ MutableSharedFlow ad(int i2, int i3, BufferOverflow bufferOverflow, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = 0;
        }
        if ((i4 & 4) != 0) {
            bufferOverflow = BufferOverflow.SUSPEND;
        }
        return qw(i2, i3, bufferOverflow);
    }

    @NotNull
    public static final <T> MutableSharedFlow<T> qw(int i2, int i3, @NotNull BufferOverflow bufferOverflow) {
        boolean z = true;
        if (i2 >= 0) {
            if (i3 >= 0) {
                if (i2 <= 0 && i3 <= 0 && bufferOverflow != BufferOverflow.SUSPEND) {
                    z = false;
                }
                if (z) {
                    int i4 = i3 + i2;
                    if (i4 < 0) {
                        i4 = Integer.MAX_VALUE;
                    }
                    return new SharedFlowImpl(i2, i4, bufferOverflow);
                }
                throw new IllegalArgumentException(Intrinsics.stringPlus("replay or extraBufferCapacity must be positive with non-default onBufferOverflow strategy ", bufferOverflow).toString());
            }
            throw new IllegalArgumentException(Intrinsics.stringPlus("extraBufferCapacity cannot be negative, but was ", Integer.valueOf(i3)).toString());
        }
        throw new IllegalArgumentException(Intrinsics.stringPlus("replay cannot be negative, but was ", Integer.valueOf(i2)).toString());
    }

    @NotNull
    public static final <T> Flow<T> rg(@NotNull SharedFlow<? extends T> sharedFlow, @NotNull CoroutineContext coroutineContext, int i2, @NotNull BufferOverflow bufferOverflow) {
        if ((i2 == 0 || i2 == -3) && bufferOverflow == BufferOverflow.SUSPEND) {
            return sharedFlow;
        }
        return new th(sharedFlow, coroutineContext, i2, bufferOverflow);
    }

    public static final Object th(Object[] objArr, long j) {
        return objArr[(objArr.length - 1) & ((int) j)];
    }

    public static final void yj(Object[] objArr, long j, Object obj) {
        objArr[(objArr.length - 1) & ((int) j)] = obj;
    }
}
