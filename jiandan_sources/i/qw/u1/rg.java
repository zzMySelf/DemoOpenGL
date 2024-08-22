package i.qw.u1;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class rg {
    @NotNull
    public static final <E> Channel<E> ad(int i2, @NotNull BufferOverflow bufferOverflow, @Nullable Function1<? super E, Unit> function1) {
        int i3 = 1;
        if (i2 == -2) {
            if (bufferOverflow == BufferOverflow.SUSPEND) {
                i3 = Channel.f6350rg.qw();
            }
            return new de(i3, bufferOverflow, function1);
        } else if (i2 == -1) {
            if (bufferOverflow != BufferOverflow.SUSPEND) {
                i3 = 0;
            }
            if (i3 != 0) {
                return new i(function1);
            }
            throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow".toString());
        } else if (i2 != 0) {
            if (i2 == Integer.MAX_VALUE) {
                return new o(function1);
            }
            if (i2 == 1 && bufferOverflow == BufferOverflow.DROP_OLDEST) {
                return new i(function1);
            }
            return new de(i2, bufferOverflow, function1);
        } else if (bufferOverflow == BufferOverflow.SUSPEND) {
            return new Cswitch(function1);
        } else {
            return new de(1, bufferOverflow, function1);
        }
    }

    public static /* synthetic */ Channel de(int i2, BufferOverflow bufferOverflow, Function1 function1, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 0;
        }
        if ((i3 & 2) != 0) {
            bufferOverflow = BufferOverflow.SUSPEND;
        }
        if ((i3 & 4) != 0) {
            function1 = null;
        }
        return ad(i2, bufferOverflow, function1);
    }
}
