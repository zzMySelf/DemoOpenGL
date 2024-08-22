package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u00020\u0004H@"}, d2 = {"<anonymous>", "", "R", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2", f = "Combine.kt", i = {0, 0, 0, 0}, l = {57, 79, 82}, m = "invokeSuspend", n = {"latestValues", "resultChannel", "lastReceivedEpoch", "remainingAbsentValues"}, s = {"L$0", "L$1", "L$2", "I$0"})
public final class CombineKt$combineInternal$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ Function0<T[]> $arrayFactory;
    public final /* synthetic */ Flow<T>[] $flows;
    public final /* synthetic */ FlowCollector<R> $this_combineInternal;
    public final /* synthetic */ Function3<FlowCollector<? super R>, T[], Continuation<? super Unit>, Object> $transform;
    public int I$0;
    public int I$1;
    public /* synthetic */ Object L$0;
    public Object L$1;
    public Object L$2;
    public int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CombineKt$combineInternal$2(Flow<? extends T>[] flowArr, Function0<T[]> function0, Function3<? super FlowCollector<? super R>, ? super T[], ? super Continuation<? super Unit>, ? extends Object> function3, FlowCollector<? super R> flowCollector, Continuation<? super CombineKt$combineInternal$2> continuation) {
        super(2, continuation);
        this.$flows = flowArr;
        this.$arrayFactory = function0;
        this.$transform = function3;
        this.$this_combineInternal = flowCollector;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        CombineKt$combineInternal$2 combineKt$combineInternal$2 = new CombineKt$combineInternal$2(this.$flows, this.$arrayFactory, this.$transform, this.$this_combineInternal, continuation);
        combineKt$combineInternal$2.L$0 = obj;
        return combineKt$combineInternal$2;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((CombineKt$combineInternal$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v14, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v15, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v17, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00f1 A[LOOP:1: B:29:0x00f1->B:35:0x0115, LOOP_START, PHI: r3 r10 
      PHI: (r3v2 int) = (r3v1 int), (r3v3 int) binds: [B:26:0x00ec, B:35:0x0115] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r10v3 kotlin.collections.IndexedValue) = (r10v2 kotlin.collections.IndexedValue), (r10v16 kotlin.collections.IndexedValue) binds: [B:26:0x00ec, B:35:0x0115] A[DONT_GENERATE, DONT_INLINE]] */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r24) {
        /*
            r23 = this;
            r0 = r23
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r4 = 3
            r5 = 2
            r6 = 1
            if (r2 == 0) goto L_0x0075
            if (r2 == r6) goto L_0x0051
            if (r2 == r5) goto L_0x0036
            if (r2 != r4) goto L_0x002e
            int r2 = r0.I$1
            int r3 = r0.I$0
            java.lang.Object r7 = r0.L$2
            byte[] r7 = (byte[]) r7
            java.lang.Object r8 = r0.L$1
            kotlinx.coroutines.channels.Channel r8 = (kotlinx.coroutines.channels.Channel) r8
            java.lang.Object r9 = r0.L$0
            java.lang.Object[] r9 = (java.lang.Object[]) r9
            kotlin.ResultKt.throwOnFailure(r24)
            r13 = r3
            r14 = r9
            r3 = r2
            r2 = r7
            r7 = r8
            r8 = r0
            goto L_0x016b
        L_0x002e:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0036:
            int r2 = r0.I$1
            int r3 = r0.I$0
            java.lang.Object r7 = r0.L$2
            byte[] r7 = (byte[]) r7
            java.lang.Object r8 = r0.L$1
            kotlinx.coroutines.channels.Channel r8 = (kotlinx.coroutines.channels.Channel) r8
            java.lang.Object r9 = r0.L$0
            java.lang.Object[] r9 = (java.lang.Object[]) r9
            kotlin.ResultKt.throwOnFailure(r24)
            r13 = r3
            r14 = r9
            r3 = r2
            r2 = r7
            r7 = r8
            r8 = r0
            goto L_0x00cc
        L_0x0051:
            int r2 = r0.I$1
            int r3 = r0.I$0
            java.lang.Object r7 = r0.L$2
            byte[] r7 = (byte[]) r7
            java.lang.Object r8 = r0.L$1
            kotlinx.coroutines.channels.Channel r8 = (kotlinx.coroutines.channels.Channel) r8
            java.lang.Object r9 = r0.L$0
            java.lang.Object[] r9 = (java.lang.Object[]) r9
            kotlin.ResultKt.throwOnFailure(r24)
            r10 = r24
            i.qw.u1.th r10 = (i.qw.u1.th) r10
            java.lang.Object r10 = r10.m403if()
            r15 = r9
            r9 = r0
            r22 = r7
            r7 = r2
            r2 = r22
            goto L_0x00e6
        L_0x0075:
            kotlin.ResultKt.throwOnFailure(r24)
            java.lang.Object r2 = r0.L$0
            kotlinx.coroutines.CoroutineScope r2 = (kotlinx.coroutines.CoroutineScope) r2
            kotlinx.coroutines.flow.Flow<T>[] r7 = r0.$flows
            int r13 = r7.length
            if (r13 != 0) goto L_0x0084
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        L_0x0084:
            java.lang.Object[] r14 = new java.lang.Object[r13]
            i.qw.x1.c r8 = i.qw.w1.i0.Cswitch.f6240ad
            r9 = 0
            r10 = 0
            r11 = 6
            r12 = 0
            r7 = r14
            kotlin.collections.ArraysKt___ArraysJvmKt.fill$default((java.lang.Object[]) r7, (java.lang.Object) r8, (int) r9, (int) r10, (int) r11, (java.lang.Object) r12)
            r7 = 6
            r8 = 0
            kotlinx.coroutines.channels.Channel r21 = i.qw.u1.rg.de(r13, r8, r8, r7, r8)
            java.util.concurrent.atomic.AtomicInteger r12 = new java.util.concurrent.atomic.AtomicInteger
            r12.<init>(r13)
            if (r13 <= 0) goto L_0x00c6
            r17 = 0
        L_0x009f:
            int r11 = r17 + 1
            r8 = 0
            r9 = 0
            kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1 r10 = new kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1
            kotlinx.coroutines.flow.Flow<T>[] r7 = r0.$flows
            r20 = 0
            r15 = r10
            r16 = r7
            r18 = r12
            r19 = r21
            r15.<init>(r16, r17, r18, r19, r20)
            r15 = 3
            r16 = 0
            r7 = r2
            r3 = r11
            r11 = r15
            r15 = r12
            r12 = r16
            kotlinx.coroutines.Job unused = i.qw.Cif.fe(r7, r8, r9, r10, r11, r12)
            if (r3 < r13) goto L_0x00c2
            goto L_0x00c6
        L_0x00c2:
            r17 = r3
            r12 = r15
            goto L_0x009f
        L_0x00c6:
            byte[] r2 = new byte[r13]
            r8 = r0
            r7 = r21
            r3 = 0
        L_0x00cc:
            int r3 = r3 + r6
            byte r3 = (byte) r3
            r8.L$0 = r14
            r8.L$1 = r7
            r8.L$2 = r2
            r8.I$0 = r13
            r8.I$1 = r3
            r8.label = r6
            java.lang.Object r10 = r7.tt(r8)
            if (r10 != r1) goto L_0x00e1
            return r1
        L_0x00e1:
            r9 = r8
            r15 = r14
            r8 = r7
            r7 = r3
            r3 = r13
        L_0x00e6:
            java.lang.Object r10 = i.qw.u1.th.th(r10)
            kotlin.collections.IndexedValue r10 = (kotlin.collections.IndexedValue) r10
            if (r10 != 0) goto L_0x00f1
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        L_0x00f1:
            int r11 = r10.getIndex()
            r12 = r15[r11]
            java.lang.Object r10 = r10.getValue()
            r15[r11] = r10
            i.qw.x1.c r10 = i.qw.w1.i0.Cswitch.f6240ad
            if (r12 != r10) goto L_0x0103
            int r3 = r3 + -1
        L_0x0103:
            byte r10 = r2[r11]
            if (r10 != r7) goto L_0x0108
            goto L_0x0117
        L_0x0108:
            byte r10 = (byte) r7
            r2[r11] = r10
            java.lang.Object r10 = r8.rrr()
            java.lang.Object r10 = i.qw.u1.th.th(r10)
            kotlin.collections.IndexedValue r10 = (kotlin.collections.IndexedValue) r10
            if (r10 != 0) goto L_0x00f1
        L_0x0117:
            if (r3 != 0) goto L_0x016e
            kotlin.jvm.functions.Function0<T[]> r10 = r9.$arrayFactory
            java.lang.Object r10 = r10.invoke()
            java.lang.Object[] r10 = (java.lang.Object[]) r10
            if (r10 != 0) goto L_0x0140
            kotlin.jvm.functions.Function3<kotlinx.coroutines.flow.FlowCollector<? super R>, T[], kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> r10 = r9.$transform
            kotlinx.coroutines.flow.FlowCollector<R> r11 = r9.$this_combineInternal
            r9.L$0 = r15
            r9.L$1 = r8
            r9.L$2 = r2
            r9.I$0 = r3
            r9.I$1 = r7
            r9.label = r5
            java.lang.Object r10 = r10.invoke(r11, r15, r9)
            if (r10 != r1) goto L_0x013a
            return r1
        L_0x013a:
            r13 = r3
            r3 = r7
            r7 = r8
            r8 = r9
            r14 = r15
            goto L_0x00cc
        L_0x0140:
            r13 = 0
            r14 = 0
            r16 = 0
            r17 = 14
            r18 = 0
            r11 = r15
            r12 = r10
            r5 = r15
            r15 = r16
            r16 = r17
            r17 = r18
            kotlin.collections.ArraysKt___ArraysJvmKt.copyInto$default((java.lang.Object[]) r11, (java.lang.Object[]) r12, (int) r13, (int) r14, (int) r15, (int) r16, (java.lang.Object) r17)
            kotlin.jvm.functions.Function3<kotlinx.coroutines.flow.FlowCollector<? super R>, T[], kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> r11 = r9.$transform
            kotlinx.coroutines.flow.FlowCollector<R> r12 = r9.$this_combineInternal
            r9.L$0 = r5
            r9.L$1 = r8
            r9.L$2 = r2
            r9.I$0 = r3
            r9.I$1 = r7
            r9.label = r4
            java.lang.Object r10 = r11.invoke(r12, r10, r9)
            if (r10 != r1) goto L_0x016f
            return r1
        L_0x016b:
            r5 = 2
            goto L_0x00cc
        L_0x016e:
            r5 = r15
        L_0x016f:
            r13 = r3
            r14 = r5
            r3 = r7
            r7 = r8
            r8 = r9
            goto L_0x016b
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
