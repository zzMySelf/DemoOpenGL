package i.qw.w1;

import i.qw.w1.i0.Cif;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final /* synthetic */ class vvv {
    @Nullable
    public static final <T> Object ad(@NotNull Flow<? extends T> flow, @NotNull Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> function2, @NotNull Continuation<? super Unit> continuation) {
        Object fe2 = de.fe(xxx.ad(de.aaa(flow, function2), 0, (BufferOverflow) null, 2, (Object) null), continuation);
        return fe2 == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? fe2 : Unit.INSTANCE;
    }

    @Nullable
    public static final <T> Object de(@NotNull FlowCollector<? super T> flowCollector, @NotNull Flow<? extends T> flow, @NotNull Continuation<? super Unit> continuation) {
        de.pf(flowCollector);
        Object fe2 = flow.fe(flowCollector, continuation);
        return fe2 == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? fe2 : Unit.INSTANCE;
    }

    @Nullable
    public static final Object qw(@NotNull Flow<?> flow, @NotNull Continuation<? super Unit> continuation) {
        Object fe2 = flow.fe(Cif.f6232ad, continuation);
        return fe2 == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? fe2 : Unit.INSTANCE;
    }
}
