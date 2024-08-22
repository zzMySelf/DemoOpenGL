package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/flow/FlowCollector;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
@DebugMetadata(c = "androidx.lifecycle.FlowLiveDataConversions$asFlow$1", f = "FlowLiveData.kt", i = {0, 0, 0, 1, 1, 1, 2, 2, 2, 2}, l = {91, 95, 96}, m = "invokeSuspend", n = {"$this$flow", "channel", "observer", "$this$flow", "channel", "observer", "$this$flow", "channel", "observer", "value"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3"})
public final class FlowLiveDataConversions$asFlow$1 extends SuspendLambda implements Function2<FlowCollector<? super T>, Continuation<? super Unit>, Object> {
    public final /* synthetic */ LiveData $this_asFlow;
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public Object L$3;
    public Object L$4;
    public int label;
    public FlowCollector p$;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlowLiveDataConversions$asFlow$1(LiveData liveData, Continuation continuation) {
        super(2, continuation);
        this.$this_asFlow = liveData;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        FlowLiveDataConversions$asFlow$1 flowLiveDataConversions$asFlow$1 = new FlowLiveDataConversions$asFlow$1(this.$this_asFlow, continuation);
        flowLiveDataConversions$asFlow$1.p$ = (FlowCollector) obj;
        return flowLiveDataConversions$asFlow$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((FlowLiveDataConversions$asFlow$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a5 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00b5 A[Catch:{ all -> 0x00e4 }] */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r18) {
        /*
            r17 = this;
            r1 = r17
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r1.label
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L_0x0063
            if (r2 == r5) goto L_0x0053
            if (r2 == r4) goto L_0x0038
            if (r2 != r3) goto L_0x0030
            java.lang.Object r2 = r1.L$4
            kotlinx.coroutines.channels.ChannelIterator r2 = (kotlinx.coroutines.channels.ChannelIterator) r2
            java.lang.Object r5 = r1.L$2
            androidx.lifecycle.Observer r5 = (androidx.lifecycle.Observer) r5
            java.lang.Object r7 = r1.L$1
            kotlinx.coroutines.channels.Channel r7 = (kotlinx.coroutines.channels.Channel) r7
            java.lang.Object r8 = r1.L$0
            kotlinx.coroutines.flow.FlowCollector r8 = (kotlinx.coroutines.flow.FlowCollector) r8
            kotlin.ResultKt.throwOnFailure(r18)     // Catch:{ all -> 0x004f }
            r9 = r1
        L_0x0028:
            r16 = r8
            r8 = r2
            r2 = r5
            r5 = r7
            r7 = r16
            goto L_0x0095
        L_0x0030:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0038:
            java.lang.Object r2 = r1.L$3
            kotlinx.coroutines.channels.ChannelIterator r2 = (kotlinx.coroutines.channels.ChannelIterator) r2
            java.lang.Object r5 = r1.L$2
            androidx.lifecycle.Observer r5 = (androidx.lifecycle.Observer) r5
            java.lang.Object r7 = r1.L$1
            kotlinx.coroutines.channels.Channel r7 = (kotlinx.coroutines.channels.Channel) r7
            java.lang.Object r8 = r1.L$0
            kotlinx.coroutines.flow.FlowCollector r8 = (kotlinx.coroutines.flow.FlowCollector) r8
            kotlin.ResultKt.throwOnFailure(r18)     // Catch:{ all -> 0x004f }
            r10 = r18
            r9 = r1
            goto L_0x00ad
        L_0x004f:
            r0 = move-exception
            r9 = r1
            goto L_0x00eb
        L_0x0053:
            java.lang.Object r2 = r1.L$2
            androidx.lifecycle.Observer r2 = (androidx.lifecycle.Observer) r2
            java.lang.Object r5 = r1.L$1
            kotlinx.coroutines.channels.Channel r5 = (kotlinx.coroutines.channels.Channel) r5
            java.lang.Object r7 = r1.L$0
            kotlinx.coroutines.flow.FlowCollector r7 = (kotlinx.coroutines.flow.FlowCollector) r7
            kotlin.ResultKt.throwOnFailure(r18)
            goto L_0x0090
        L_0x0063:
            kotlin.ResultKt.throwOnFailure(r18)
            kotlinx.coroutines.flow.FlowCollector r7 = r1.p$
            r2 = -1
            kotlinx.coroutines.channels.Channel r2 = i.qw.u1.rg.de(r2, (kotlinx.coroutines.channels.BufferOverflow) null, (kotlin.jvm.functions.Function1) null, 6, (java.lang.Object) null)
            androidx.lifecycle.FlowLiveDataConversions$asFlow$1$observer$1 r8 = new androidx.lifecycle.FlowLiveDataConversions$asFlow$1$observer$1
            r8.<init>(r2)
            i.qw.z0 r9 = i.qw.u.de()
            i.qw.z0 r9 = r9.xxx()
            androidx.lifecycle.FlowLiveDataConversions$asFlow$1$1 r10 = new androidx.lifecycle.FlowLiveDataConversions$asFlow$1$1
            r10.<init>(r1, r8, r6)
            r1.L$0 = r7
            r1.L$1 = r2
            r1.L$2 = r8
            r1.label = r5
            java.lang.Object r5 = i.qw.o.yj(r9, r10, r1)
            if (r5 != r0) goto L_0x008e
            return r0
        L_0x008e:
            r5 = r2
            r2 = r8
        L_0x0090:
            kotlinx.coroutines.channels.ChannelIterator r8 = r5.iterator()     // Catch:{ all -> 0x00e8 }
            r9 = r1
        L_0x0095:
            r9.L$0 = r7     // Catch:{ all -> 0x00e6 }
            r9.L$1 = r5     // Catch:{ all -> 0x00e6 }
            r9.L$2 = r2     // Catch:{ all -> 0x00e6 }
            r9.L$3 = r8     // Catch:{ all -> 0x00e6 }
            r9.label = r4     // Catch:{ all -> 0x00e6 }
            java.lang.Object r10 = r8.qw(r9)     // Catch:{ all -> 0x00e6 }
            if (r10 != r0) goto L_0x00a6
            return r0
        L_0x00a6:
            r16 = r5
            r5 = r2
            r2 = r8
            r8 = r7
            r7 = r16
        L_0x00ad:
            java.lang.Boolean r10 = (java.lang.Boolean) r10     // Catch:{ all -> 0x00e4 }
            boolean r10 = r10.booleanValue()     // Catch:{ all -> 0x00e4 }
            if (r10 == 0) goto L_0x00cc
            java.lang.Object r10 = r2.next()     // Catch:{ all -> 0x00e4 }
            r9.L$0 = r8     // Catch:{ all -> 0x00e4 }
            r9.L$1 = r7     // Catch:{ all -> 0x00e4 }
            r9.L$2 = r5     // Catch:{ all -> 0x00e4 }
            r9.L$3 = r10     // Catch:{ all -> 0x00e4 }
            r9.L$4 = r2     // Catch:{ all -> 0x00e4 }
            r9.label = r3     // Catch:{ all -> 0x00e4 }
            java.lang.Object r10 = r8.emit(r10, r9)     // Catch:{ all -> 0x00e4 }
            if (r10 != r0) goto L_0x0028
            return r0
        L_0x00cc:
            i.qw.i0 r10 = i.qw.i0.f6136ad
            i.qw.z0 r0 = i.qw.u.de()
            i.qw.z0 r11 = r0.xxx()
            r12 = 0
            androidx.lifecycle.FlowLiveDataConversions$asFlow$1$2 r13 = new androidx.lifecycle.FlowLiveDataConversions$asFlow$1$2
            r13.<init>(r9, r5, r6)
            r14 = 2
            r15 = 0
            kotlinx.coroutines.Job unused = i.qw.Cif.fe(r10, r11, r12, r13, r14, r15)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x00e4:
            r0 = move-exception
            goto L_0x00eb
        L_0x00e6:
            r0 = move-exception
            goto L_0x00ea
        L_0x00e8:
            r0 = move-exception
            r9 = r1
        L_0x00ea:
            r5 = r2
        L_0x00eb:
            i.qw.i0 r10 = i.qw.i0.f6136ad
            i.qw.z0 r2 = i.qw.u.de()
            i.qw.z0 r11 = r2.xxx()
            r12 = 0
            androidx.lifecycle.FlowLiveDataConversions$asFlow$1$2 r13 = new androidx.lifecycle.FlowLiveDataConversions$asFlow$1$2
            r13.<init>(r9, r5, r6)
            r14 = 2
            r15 = 0
            kotlinx.coroutines.Job unused = i.qw.Cif.fe(r10, r11, r12, r13, r14, r15)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.FlowLiveDataConversions$asFlow$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
