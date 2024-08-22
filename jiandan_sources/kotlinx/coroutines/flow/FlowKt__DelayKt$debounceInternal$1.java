package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H@"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;", "downstream", "Lkotlinx/coroutines/flow/FlowCollector;"}, k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1", f = "Delay.kt", i = {}, l = {224, 358}, m = "invokeSuspend", n = {}, s = {})
public final class FlowKt__DelayKt$debounceInternal$1 extends SuspendLambda implements Function3<CoroutineScope, FlowCollector<? super T>, Continuation<? super Unit>, Object> {
    public final /* synthetic */ Flow<T> $this_debounceInternal;
    public final /* synthetic */ Function1<T, Long> $timeoutMillisSelector;
    public /* synthetic */ Object L$0;
    public /* synthetic */ Object L$1;
    public Object L$2;
    public Object L$3;
    public int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlowKt__DelayKt$debounceInternal$1(Function1<? super T, Long> function1, Flow<? extends T> flow, Continuation<? super FlowKt__DelayKt$debounceInternal$1> continuation) {
        super(3, continuation);
        this.$timeoutMillisSelector = function1;
        this.$this_debounceInternal = flow;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @NotNull FlowCollector<? super T> flowCollector, @Nullable Continuation<? super Unit> continuation) {
        FlowKt__DelayKt$debounceInternal$1 flowKt__DelayKt$debounceInternal$1 = new FlowKt__DelayKt$debounceInternal$1(this.$timeoutMillisSelector, this.$this_debounceInternal, continuation);
        flowKt__DelayKt$debounceInternal$1.L$0 = coroutineScope;
        flowKt__DelayKt$debounceInternal$1.L$1 = flowCollector;
        return flowKt__DelayKt$debounceInternal$1.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(14:7|29|30|33|(4:35|(1:40)(1:39)|41|(2:43|44))|45|46|47|(1:49)|50|53|(1:55)|(1:57)(1:58)|57) */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0121, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0122, code lost:
        r13.x(r0);
     */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x010a A[Catch:{ all -> 0x0121 }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x012f  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0135  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r18) {
        /*
            r17 = this;
            r1 = r17
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r1.label
            r3 = 0
            r4 = 2
            r5 = 0
            r7 = 1
            r8 = 0
            if (r2 == 0) goto L_0x004b
            if (r2 == r7) goto L_0x0034
            if (r2 != r4) goto L_0x002c
            java.lang.Object r2 = r1.L$3
            kotlin.jvm.internal.Ref$LongRef r2 = (kotlin.jvm.internal.Ref.LongRef) r2
            java.lang.Object r2 = r1.L$2
            kotlin.jvm.internal.Ref$ObjectRef r2 = (kotlin.jvm.internal.Ref.ObjectRef) r2
            java.lang.Object r9 = r1.L$1
            kotlinx.coroutines.channels.ReceiveChannel r9 = (kotlinx.coroutines.channels.ReceiveChannel) r9
            java.lang.Object r10 = r1.L$0
            kotlinx.coroutines.flow.FlowCollector r10 = (kotlinx.coroutines.flow.FlowCollector) r10
            kotlin.ResultKt.throwOnFailure(r18)
            r11 = r10
            r10 = r9
            r9 = r2
            r2 = r1
            goto L_0x0072
        L_0x002c:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0034:
            java.lang.Object r2 = r1.L$3
            kotlin.jvm.internal.Ref$LongRef r2 = (kotlin.jvm.internal.Ref.LongRef) r2
            java.lang.Object r9 = r1.L$2
            kotlin.jvm.internal.Ref$ObjectRef r9 = (kotlin.jvm.internal.Ref.ObjectRef) r9
            java.lang.Object r10 = r1.L$1
            kotlinx.coroutines.channels.ReceiveChannel r10 = (kotlinx.coroutines.channels.ReceiveChannel) r10
            java.lang.Object r11 = r1.L$0
            kotlinx.coroutines.flow.FlowCollector r11 = (kotlinx.coroutines.flow.FlowCollector) r11
            kotlin.ResultKt.throwOnFailure(r18)
            r12 = r2
            r2 = r1
            goto L_0x00bb
        L_0x004b:
            kotlin.ResultKt.throwOnFailure(r18)
            java.lang.Object r2 = r1.L$0
            r9 = r2
            kotlinx.coroutines.CoroutineScope r9 = (kotlinx.coroutines.CoroutineScope) r9
            java.lang.Object r2 = r1.L$1
            kotlinx.coroutines.flow.FlowCollector r2 = (kotlinx.coroutines.flow.FlowCollector) r2
            r10 = 0
            r11 = 0
            kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$values$1 r12 = new kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$values$1
            kotlinx.coroutines.flow.Flow<T> r13 = r1.$this_debounceInternal
            r12.<init>(r13, r8)
            r13 = 3
            r14 = 0
            kotlinx.coroutines.channels.ReceiveChannel r9 = kotlinx.coroutines.channels.ProduceKt.rg(r9, r10, r11, r12, r13, r14)
            kotlin.jvm.internal.Ref$ObjectRef r10 = new kotlin.jvm.internal.Ref$ObjectRef
            r10.<init>()
            r11 = r2
            r2 = r1
            r16 = r10
            r10 = r9
            r9 = r16
        L_0x0072:
            T r12 = r9.element
            i.qw.x1.c r13 = i.qw.w1.i0.Cswitch.f6241de
            if (r12 == r13) goto L_0x013b
            kotlin.jvm.internal.Ref$LongRef r12 = new kotlin.jvm.internal.Ref$LongRef
            r12.<init>()
            T r13 = r9.element
            if (r13 == 0) goto L_0x00bd
            kotlin.jvm.functions.Function1<T, java.lang.Long> r14 = r2.$timeoutMillisSelector
            i.qw.x1.c r15 = i.qw.w1.i0.Cswitch.qw
            if (r13 != r15) goto L_0x0088
            r13 = r8
        L_0x0088:
            java.lang.Object r13 = r14.invoke(r13)
            java.lang.Number r13 = (java.lang.Number) r13
            long r13 = r13.longValue()
            r12.element = r13
            int r15 = (r13 > r5 ? 1 : (r13 == r5 ? 0 : -1))
            if (r15 < 0) goto L_0x009a
            r13 = 1
            goto L_0x009b
        L_0x009a:
            r13 = 0
        L_0x009b:
            if (r13 == 0) goto L_0x00c6
            long r13 = r12.element
            int r15 = (r13 > r5 ? 1 : (r13 == r5 ? 0 : -1))
            if (r15 != 0) goto L_0x00bd
            i.qw.x1.c r13 = i.qw.w1.i0.Cswitch.qw
            T r14 = r9.element
            if (r14 != r13) goto L_0x00aa
            r14 = r8
        L_0x00aa:
            r2.L$0 = r11
            r2.L$1 = r10
            r2.L$2 = r9
            r2.L$3 = r12
            r2.label = r7
            java.lang.Object r13 = r11.emit(r14, r2)
            if (r13 != r0) goto L_0x00bb
            return r0
        L_0x00bb:
            r9.element = r8
        L_0x00bd:
            r16 = r2
            r2 = r0
            r0 = r12
            r12 = r11
            r11 = r10
            r10 = r16
            goto L_0x00d2
        L_0x00c6:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "Debounce timeout should not be negative"
            java.lang.String r2 = r2.toString()
            r0.<init>(r2)
            throw r0
        L_0x00d2:
            boolean r13 = i.qw.k.qw()
            if (r13 == 0) goto L_0x00f7
            T r13 = r9.element
            if (r13 == 0) goto L_0x00e5
            long r13 = r0.element
            int r15 = (r13 > r5 ? 1 : (r13 == r5 ? 0 : -1))
            if (r15 <= 0) goto L_0x00e3
            goto L_0x00e5
        L_0x00e3:
            r13 = 0
            goto L_0x00e6
        L_0x00e5:
            r13 = 1
        L_0x00e6:
            java.lang.Boolean r13 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r13)
            boolean r13 = r13.booleanValue()
            if (r13 == 0) goto L_0x00f1
            goto L_0x00f7
        L_0x00f1:
            java.lang.AssertionError r0 = new java.lang.AssertionError
            r0.<init>()
            throw r0
        L_0x00f7:
            r10.L$0 = r12
            r10.L$1 = r11
            r10.L$2 = r9
            r10.L$3 = r0
            r10.label = r4
            i.qw.a2.qw r13 = new i.qw.a2.qw
            r13.<init>(r10)
            T r14 = r9.element     // Catch:{ all -> 0x0121 }
            if (r14 == 0) goto L_0x0114
            long r14 = r0.element     // Catch:{ all -> 0x0121 }
            kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$3$1 r0 = new kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$3$1     // Catch:{ all -> 0x0121 }
            r0.<init>(r12, r9, r8)     // Catch:{ all -> 0x0121 }
            r13.th(r14, r0)     // Catch:{ all -> 0x0121 }
        L_0x0114:
            kotlinx.coroutines.selects.SelectClause1 r0 = r11.eee()     // Catch:{ all -> 0x0121 }
            kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$3$2 r14 = new kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$3$2     // Catch:{ all -> 0x0121 }
            r14.<init>(r9, r12, r8)     // Catch:{ all -> 0x0121 }
            r13.ddd(r0, r14)     // Catch:{ all -> 0x0121 }
            goto L_0x0125
        L_0x0121:
            r0 = move-exception
            r13.x(r0)
        L_0x0125:
            java.lang.Object r0 = r13.w()
            java.lang.Object r13 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r0 != r13) goto L_0x0132
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r10)
        L_0x0132:
            if (r0 != r2) goto L_0x0135
            return r2
        L_0x0135:
            r0 = r2
            r2 = r10
            r10 = r11
            r11 = r12
            goto L_0x0072
        L_0x013b:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
