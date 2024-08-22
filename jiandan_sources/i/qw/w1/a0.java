package i.qw.w1;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.AbstractFlow;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class a0<T> extends AbstractFlow<T> {
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public final Function2<FlowCollector<? super T>, Continuation<? super Unit>, Object> f6224ad;

    public a0(@NotNull Function2<? super FlowCollector<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        this.f6224ad = function2;
    }

    @Nullable
    public Object yj(@NotNull FlowCollector<? super T> flowCollector, @NotNull Continuation<? super Unit> continuation) {
        Object invoke = this.f6224ad.invoke(flowCollector, continuation);
        return invoke == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? invoke : Unit.INSTANCE;
    }
}
