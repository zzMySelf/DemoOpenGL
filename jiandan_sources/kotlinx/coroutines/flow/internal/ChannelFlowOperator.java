package kotlinx.coroutines.flow.internal;

import i.qw.w1.i0.fe;
import i.qw.w1.i0.ppp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\b \u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\b\u0012\u0004\u0012\u0002H\u00020\u0003B+\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u001f\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u0010H@ø\u0001\u0000¢\u0006\u0002\u0010\u0011J\u001f\u0010\u0012\u001a\u00020\u000e2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u0014H@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J'\u0010\u0016\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u00102\u0006\u0010\u0017\u001a\u00020\u0007H@ø\u0001\u0000¢\u0006\u0002\u0010\u0018J\u001f\u0010\u0019\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u0010H¤@ø\u0001\u0000¢\u0006\u0002\u0010\u0011J\b\u0010\u001a\u001a\u00020\u001bH\u0016R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058\u0004X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u001c"}, d2 = {"Lkotlinx/coroutines/flow/internal/ChannelFlowOperator;", "S", "T", "Lkotlinx/coroutines/flow/internal/ChannelFlow;", "flow", "Lkotlinx/coroutines/flow/Flow;", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)V", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "collectTo", "scope", "Lkotlinx/coroutines/channels/ProducerScope;", "(Lkotlinx/coroutines/channels/ProducerScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "collectWithContextUndispatched", "newContext", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "flowCollect", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class ChannelFlowOperator<S, T> extends ChannelFlow<T> {
    @NotNull
    @JvmField

    /* renamed from: uk  reason: collision with root package name */
    public final Flow<S> f6424uk;

    public ChannelFlowOperator(@NotNull Flow<? extends S> flow, @NotNull CoroutineContext coroutineContext, int i2, @NotNull BufferOverflow bufferOverflow) {
        super(coroutineContext, i2, bufferOverflow);
        this.f6424uk = flow;
    }

    public static /* synthetic */ Object ppp(ChannelFlowOperator channelFlowOperator, ProducerScope producerScope, Continuation continuation) {
        Object vvv = channelFlowOperator.vvv(new ppp(producerScope), continuation);
        return vvv == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? vvv : Unit.INSTANCE;
    }

    public static /* synthetic */ Object when(ChannelFlowOperator channelFlowOperator, FlowCollector flowCollector, Continuation continuation) {
        if (channelFlowOperator.f6422th == -3) {
            CoroutineContext context = continuation.getContext();
            CoroutineContext plus = context.plus(channelFlowOperator.f6421ad);
            if (Intrinsics.areEqual((Object) plus, (Object) context)) {
                Object vvv = channelFlowOperator.vvv(flowCollector, continuation);
                return vvv == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? vvv : Unit.INSTANCE;
            } else if (Intrinsics.areEqual((Object) plus.get(ContinuationInterceptor.Key), (Object) context.get(ContinuationInterceptor.Key))) {
                Object ggg = channelFlowOperator.ggg(flowCollector, plus, continuation);
                return ggg == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? ggg : Unit.INSTANCE;
            }
        }
        Object fe2 = super.fe(flowCollector, continuation);
        return fe2 == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? fe2 : Unit.INSTANCE;
    }

    @Nullable
    public Object fe(@NotNull FlowCollector<? super T> flowCollector, @NotNull Continuation<? super Unit> continuation) {
        return when(this, flowCollector, continuation);
    }

    public final Object ggg(FlowCollector<? super T> flowCollector, CoroutineContext coroutineContext, Continuation<? super Unit> continuation) {
        Object de2 = fe.de(coroutineContext, fe.fe(flowCollector, continuation.getContext()), (Object) null, new ChannelFlowOperator$collectWithContextUndispatched$2(this, (Continuation<? super ChannelFlowOperator$collectWithContextUndispatched$2>) null), continuation, 4, (Object) null);
        return de2 == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? de2 : Unit.INSTANCE;
    }

    @Nullable
    public Object i(@NotNull ProducerScope<? super T> producerScope, @NotNull Continuation<? super Unit> continuation) {
        return ppp(this, producerScope, continuation);
    }

    @NotNull
    public String toString() {
        return this.f6424uk + " -> " + super.toString();
    }

    @Nullable
    public abstract Object vvv(@NotNull FlowCollector<? super T> flowCollector, @NotNull Continuation<? super Unit> continuation);
}
