package i.qw.w1;

import java.util.Collection;
import kotlin.BuilderInference;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt__ChannelsKt;
import kotlinx.coroutines.flow.FlowKt__CollectionKt;
import kotlinx.coroutines.flow.FlowKt__CountKt;
import kotlinx.coroutines.flow.FlowKt__DelayKt;
import kotlinx.coroutines.flow.FlowKt__DistinctKt;
import kotlinx.coroutines.flow.FlowKt__EmittersKt;
import kotlinx.coroutines.flow.FlowKt__ErrorsKt;
import kotlinx.coroutines.flow.FlowKt__MergeKt;
import kotlinx.coroutines.flow.FlowKt__ReduceKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class de {
    @NotNull
    public static final <T, R> Flow<R> a(@NotNull Flow<? extends T> flow, @NotNull @BuilderInference Function3<? super FlowCollector<? super R>, ? super T, ? super Continuation<? super Unit>, ? extends Object> function3) {
        return FlowKt__MergeKt.ad(flow, function3);
    }

    @NotNull
    public static final <T, R> Flow<R> aaa(@NotNull Flow<? extends T> flow, @NotNull @BuilderInference Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2) {
        return FlowKt__MergeKt.qw(flow, function2);
    }

    @NotNull
    public static final <T> Flow<T> ddd(T t) {
        return when.ad(t);
    }

    @Nullable
    public static final <T> Object de(@NotNull Flow<? extends T> flow, @NotNull FlowCollector<? super T> flowCollector, @NotNull Continuation<? super Throwable> continuation) {
        return FlowKt__ErrorsKt.qw(flow, flowCollector, continuation);
    }

    @Nullable
    public static final <T> Object eee(@NotNull Flow<? extends T> flow, @NotNull Continuation<? super T> continuation) {
        return FlowKt__ReduceKt.i(flow, continuation);
    }

    @Nullable
    public static final Object fe(@NotNull Flow<?> flow, @NotNull Continuation<? super Unit> continuation) {
        return vvv.qw(flow, continuation);
    }

    @NotNull
    public static final ReceiveChannel<Unit> ggg(@NotNull CoroutineScope coroutineScope, long j, long j2) {
        return FlowKt__DelayKt.qw(coroutineScope, j, j2);
    }

    @Nullable
    public static final <T> Object i(@NotNull FlowCollector<? super T> flowCollector, @NotNull ReceiveChannel<? extends T> receiveChannel, @NotNull Continuation<? super Unit> continuation) {
        return FlowKt__ChannelsKt.ad(flowCollector, receiveChannel, continuation);
    }

    @Nullable
    /* renamed from: if  reason: not valid java name */
    public static final <T> Object m407if(@NotNull Flow<? extends T> flow, @NotNull Continuation<? super T> continuation) {
        return FlowKt__ReduceKt.qw(flow, continuation);
    }

    @Nullable
    public static final <T> Object mmm(@NotNull Flow<? extends T> flow, @NotNull Continuation<? super T> continuation) {
        return FlowKt__ReduceKt.yj(flow, continuation);
    }

    @Nullable
    public static final <T> Object nn(@NotNull Flow<? extends T> flow, @NotNull Continuation<? super T> continuation) {
        return FlowKt__ReduceKt.th(flow, continuation);
    }

    @Nullable
    public static final <T> Object o(@NotNull FlowCollector<? super T> flowCollector, @NotNull Flow<? extends T> flow, @NotNull Continuation<? super Unit> continuation) {
        return vvv.de(flowCollector, flow, continuation);
    }

    public static final void pf(@NotNull FlowCollector<?> flowCollector) {
        FlowKt__EmittersKt.ad(flowCollector);
    }

    @Nullable
    public static final <T> Object ppp(@NotNull Flow<? extends T> flow, @NotNull Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2, @NotNull Continuation<? super T> continuation) {
        return FlowKt__ReduceKt.fe(flow, function2, continuation);
    }

    @Nullable
    public static final <S, T extends S> Object qqq(@NotNull Flow<? extends T> flow, @NotNull Function3<? super S, ? super T, ? super Continuation<? super S>, ? extends Object> function3, @NotNull Continuation<? super S> continuation) {
        return FlowKt__ReduceKt.uk(flow, function3, continuation);
    }

    @NotNull
    public static final <T> Flow<T> qw(@NotNull Flow<? extends T> flow, int i2, @NotNull BufferOverflow bufferOverflow) {
        return xxx.qw(flow, i2, bufferOverflow);
    }

    @Nullable
    public static final <T> Object rg(@NotNull Flow<? extends T> flow, @NotNull Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> function2, @NotNull Continuation<? super Unit> continuation) {
        return vvv.ad(flow, function2, continuation);
    }

    @Nullable
    public static final <T> Object rrr(@NotNull Flow<? extends T> flow, @NotNull Continuation<? super T> continuation) {
        return FlowKt__ReduceKt.o(flow, continuation);
    }

    @Nullable
    /* renamed from: switch  reason: not valid java name */
    public static final <T> Object m408switch(@NotNull Flow<? extends T> flow, @NotNull Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2, @NotNull Continuation<? super T> continuation) {
        return FlowKt__ReduceKt.ad(flow, function2, continuation);
    }

    @Nullable
    public static final <T> Object th(@NotNull Flow<? extends T> flow, @NotNull Continuation<? super Integer> continuation) {
        return FlowKt__CountKt.qw(flow, continuation);
    }

    @Nullable
    public static final <T, C extends Collection<? super T>> Object tt(@NotNull Flow<? extends T> flow, @NotNull C c, @NotNull Continuation<? super C> continuation) {
        return FlowKt__CollectionKt.qw(flow, c, continuation);
    }

    @NotNull
    public static final <T> Flow<T> uk(@NotNull Flow<? extends T> flow) {
        return FlowKt__DistinctKt.qw(flow);
    }

    @Nullable
    public static final <T> Object when(@NotNull Flow<? extends T> flow, @NotNull Continuation<? super T> continuation) {
        return FlowKt__ReduceKt.de(flow, continuation);
    }

    @NotNull
    public static final <T> Flow<T> xxx(@NotNull @BuilderInference Function2<? super FlowCollector<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        return when.qw(function2);
    }

    @Nullable
    public static final <T> Object yj(@NotNull Flow<? extends T> flow, @NotNull Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2, @NotNull Continuation<? super Integer> continuation) {
        return FlowKt__CountKt.ad(flow, function2, continuation);
    }
}
