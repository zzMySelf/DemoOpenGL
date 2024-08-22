package i.qw.w1.i0;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ppp<T> implements FlowCollector<T> {
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public final SendChannel<T> f6235ad;

    public ppp(@NotNull SendChannel<? super T> sendChannel) {
        this.f6235ad = sendChannel;
    }

    @Nullable
    public Object emit(T t, @NotNull Continuation<? super Unit> continuation) {
        Object d = this.f6235ad.d(t, continuation);
        return d == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? d : Unit.INSTANCE;
    }
}
