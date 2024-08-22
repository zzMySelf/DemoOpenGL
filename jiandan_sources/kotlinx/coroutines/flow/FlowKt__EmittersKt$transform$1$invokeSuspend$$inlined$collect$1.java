package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class FlowKt__EmittersKt$transform$1$invokeSuspend$$inlined$collect$1 implements FlowCollector<T> {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ Function3 f6383ad;

    /* renamed from: th  reason: collision with root package name */
    public final /* synthetic */ FlowCollector f6384th;

    public FlowKt__EmittersKt$transform$1$invokeSuspend$$inlined$collect$1(Function3 function3, FlowCollector flowCollector) {
        this.f6383ad = function3;
        this.f6384th = flowCollector;
    }

    @Nullable
    public Object emit(T t, @NotNull Continuation<? super Unit> continuation) {
        Object invoke = this.f6383ad.invoke(this.f6384th, t, continuation);
        return invoke == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? invoke : Unit.INSTANCE;
    }
}
