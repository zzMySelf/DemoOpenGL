package kotlinx.coroutines.reactive;

import kotlin.Metadata;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: Collect.kt */
public final class FlowSubscription$consumeFlow$$inlined$collect$1 implements FlowCollector<T> {
    final /* synthetic */ FlowSubscription this$0;

    public FlowSubscription$consumeFlow$$inlined$collect$1(FlowSubscription flowSubscription) {
        this.this$0 = flowSubscription;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object emit(T r11, kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
        /*
            r10 = this;
            boolean r0 = r12 instanceof kotlinx.coroutines.reactive.FlowSubscription$consumeFlow$$inlined$collect$1.AnonymousClass1
            if (r0 == 0) goto L_0x0014
            r0 = r12
            kotlinx.coroutines.reactive.FlowSubscription$consumeFlow$$inlined$collect$1$1 r0 = (kotlinx.coroutines.reactive.FlowSubscription$consumeFlow$$inlined$collect$1.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L_0x0019
        L_0x0014:
            kotlinx.coroutines.reactive.FlowSubscription$consumeFlow$$inlined$collect$1$1 r0 = new kotlinx.coroutines.reactive.FlowSubscription$consumeFlow$$inlined$collect$1$1
            r0.<init>(r10, r12)
        L_0x0019:
            r12 = r0
            java.lang.Object r0 = r12.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r12.label
            switch(r2) {
                case 0: goto L_0x003b;
                case 1: goto L_0x002d;
                default: goto L_0x0025;
            }
        L_0x0025:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x002d:
            r11 = 0
            r1 = 0
            java.lang.Object r2 = r12.L$1
            kotlinx.coroutines.reactive.FlowSubscription$consumeFlow$$inlined$collect$1$1 r2 = (kotlinx.coroutines.reactive.FlowSubscription$consumeFlow$$inlined$collect$1.AnonymousClass1) r2
            java.lang.Object r2 = r12.L$0
            kotlinx.coroutines.reactive.FlowSubscription$consumeFlow$$inlined$collect$1 r2 = (kotlinx.coroutines.reactive.FlowSubscription$consumeFlow$$inlined$collect$1) r2
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x008b
        L_0x003b:
            kotlin.ResultKt.throwOnFailure(r0)
            r2 = r10
            r3 = r12
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r3 = 0
            kotlinx.coroutines.reactive.FlowSubscription r4 = r2.this$0
            org.reactivestreams.Subscriber<? super T> r4 = r4.subscriber
            r4.onNext(r11)
            kotlinx.coroutines.reactive.FlowSubscription r11 = r2.this$0
            java.util.concurrent.atomic.AtomicLongFieldUpdater r4 = kotlinx.coroutines.reactive.FlowSubscription.requested$FU
            long r4 = r4.decrementAndGet(r11)
            r6 = 0
            int r11 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r11 > 0) goto L_0x008d
            r11 = r12
            r4 = 0
            r12.L$0 = r2
            r12.L$1 = r11
            r5 = 1
            r12.label = r5
            r6 = r11
            r7 = 0
            kotlinx.coroutines.CancellableContinuationImpl r8 = new kotlinx.coroutines.CancellableContinuationImpl
            kotlin.coroutines.Continuation r9 = kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(r6)
            r8.<init>(r9, r5)
            r5 = r8
            r5.initCancellability()
            r6 = r5
            kotlinx.coroutines.CancellableContinuation r6 = (kotlinx.coroutines.CancellableContinuation) r6
            r8 = 0
            kotlinx.coroutines.reactive.FlowSubscription r9 = r2.this$0
            r9.producer = r6
            java.lang.Object r2 = r5.getResult()
            java.lang.Object r5 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r2 != r5) goto L_0x0086
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r11)
        L_0x0086:
            if (r2 != r1) goto L_0x0089
            return r1
        L_0x0089:
            r11 = r3
            r1 = r4
        L_0x008b:
            goto L_0x0097
        L_0x008d:
            kotlinx.coroutines.reactive.FlowSubscription r11 = r2.this$0
            kotlin.coroutines.CoroutineContext r11 = r11.getCoroutineContext()
            kotlinx.coroutines.JobKt.ensureActive((kotlin.coroutines.CoroutineContext) r11)
        L_0x0097:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.reactive.FlowSubscription$consumeFlow$$inlined$collect$1.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
