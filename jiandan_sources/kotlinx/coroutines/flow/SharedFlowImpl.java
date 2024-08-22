package kotlinx.coroutines.flow;

import i.qw.ggg;
import i.qw.k;
import i.qw.w1.b0;
import i.qw.w1.c0;
import i.qw.w1.i0.de;
import i.qw.xxx;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.FusibleFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00042\b\u0012\u0004\u0012\u0002H\u00010\u00052\b\u0012\u0004\u0012\u0002H\u00010\u0006:\u0001bB\u001d\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0019\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0002\u0010)J\u0010\u0010*\u001a\u00020'2\u0006\u0010+\u001a\u00020,H\u0002J\b\u0010-\u001a\u00020'H\u0002J\u001f\u0010.\u001a\u00020'2\f\u0010/\u001a\b\u0012\u0004\u0012\u00028\u000000H@ø\u0001\u0000¢\u0006\u0002\u00101J\u0010\u00102\u001a\u00020'2\u0006\u00103\u001a\u00020\u0012H\u0002J\b\u00104\u001a\u00020\u0003H\u0014J\u001d\u00105\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000e2\u0006\u00106\u001a\u00020\bH\u0014¢\u0006\u0002\u00107J\b\u00108\u001a\u00020'H\u0002J\u0019\u00109\u001a\u00020'2\u0006\u0010:\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0002\u0010;J\u0019\u0010<\u001a\u00020'2\u0006\u0010:\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0002\u0010;J\u0012\u0010=\u001a\u00020'2\b\u0010>\u001a\u0004\u0018\u00010\u000fH\u0002J1\u0010?\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020'\u0018\u00010@0\u000e2\u0014\u0010A\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020'\u0018\u00010@0\u000eH\u0002¢\u0006\u0002\u0010BJ&\u0010C\u001a\b\u0012\u0004\u0012\u00028\u00000D2\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0012\u0010H\u001a\u0004\u0018\u00010\u000f2\u0006\u0010I\u001a\u00020\u0012H\u0002J7\u0010J\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000e2\u0010\u0010K\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u000e2\u0006\u0010L\u001a\u00020\b2\u0006\u0010M\u001a\u00020\bH\u0002¢\u0006\u0002\u0010NJ\b\u0010O\u001a\u00020'H\u0016J\u0015\u0010P\u001a\u00020Q2\u0006\u0010:\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010RJ\u0015\u0010S\u001a\u00020Q2\u0006\u0010:\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010RJ\u0015\u0010T\u001a\u00020Q2\u0006\u0010:\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010RJ\u0010\u0010U\u001a\u00020\u00122\u0006\u0010(\u001a\u00020\u0003H\u0002J\u0012\u0010V\u001a\u0004\u0018\u00010\u000f2\u0006\u0010(\u001a\u00020\u0003H\u0002J(\u0010W\u001a\u00020'2\u0006\u0010X\u001a\u00020\u00122\u0006\u0010Y\u001a\u00020\u00122\u0006\u0010Z\u001a\u00020\u00122\u0006\u0010[\u001a\u00020\u0012H\u0002J%\u0010\\\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020'\u0018\u00010@0\u000e2\u0006\u0010]\u001a\u00020\u0012H\u0000¢\u0006\u0004\b^\u0010_J\r\u0010`\u001a\u00020\u0012H\u0000¢\u0006\u0002\baR\u001a\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u000eX\u000e¢\u0006\u0004\n\u0002\u0010\u0010R\u000e\u0010\t\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u00128BX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u00128BX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0014R\u000e\u0010\u0018\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\u00020\u00128BX\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0014R\u000e\u0010\u001b\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001d8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\u00020\b8BX\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020\b8BX\u0004¢\u0006\u0006\u001a\u0004\b%\u0010#\u0002\u0004\n\u0002\b\u0019¨\u0006c"}, d2 = {"Lkotlinx/coroutines/flow/SharedFlowImpl;", "T", "Lkotlinx/coroutines/flow/internal/AbstractSharedFlow;", "Lkotlinx/coroutines/flow/SharedFlowSlot;", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lkotlinx/coroutines/flow/CancellableFlow;", "Lkotlinx/coroutines/flow/internal/FusibleFlow;", "replay", "", "bufferCapacity", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "(IILkotlinx/coroutines/channels/BufferOverflow;)V", "buffer", "", "", "[Ljava/lang/Object;", "bufferEndIndex", "", "getBufferEndIndex", "()J", "bufferSize", "head", "getHead", "minCollectorIndex", "queueEndIndex", "getQueueEndIndex", "queueSize", "replayCache", "", "getReplayCache", "()Ljava/util/List;", "replayIndex", "replaySize", "getReplaySize", "()I", "totalSize", "getTotalSize", "awaitValue", "", "slot", "(Lkotlinx/coroutines/flow/SharedFlowSlot;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancelEmitter", "emitter", "Lkotlinx/coroutines/flow/SharedFlowImpl$Emitter;", "cleanupTailLocked", "collect", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "correctCollectorIndexesOnDropOldest", "newHead", "createSlot", "createSlotArray", "size", "(I)[Lkotlinx/coroutines/flow/SharedFlowSlot;", "dropOldestLocked", "emit", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "emitSuspend", "enqueueLocked", "item", "findSlotsToResumeLocked", "Lkotlin/coroutines/Continuation;", "resumesIn", "([Lkotlin/coroutines/Continuation;)[Lkotlin/coroutines/Continuation;", "fuse", "Lkotlinx/coroutines/flow/Flow;", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "getPeekedValueLockedAt", "index", "growBuffer", "curBuffer", "curSize", "newSize", "([Ljava/lang/Object;II)[Ljava/lang/Object;", "resetReplayCache", "tryEmit", "", "(Ljava/lang/Object;)Z", "tryEmitLocked", "tryEmitNoCollectorsLocked", "tryPeekLocked", "tryTakeValue", "updateBufferLocked", "newReplayIndex", "newMinCollectorIndex", "newBufferEndIndex", "newQueueEndIndex", "updateCollectorIndexLocked", "oldIndex", "updateCollectorIndexLocked$kotlinx_coroutines_core", "(J)[Lkotlin/coroutines/Continuation;", "updateNewCollectorIndexLocked", "updateNewCollectorIndexLocked$kotlinx_coroutines_core", "Emitter", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class SharedFlowImpl<T> extends i.qw.w1.i0.qw<c0> implements MutableSharedFlow<T>, CancellableFlow<T>, FusibleFlow<T> {
    public int ggg;

    /* renamed from: i  reason: collision with root package name */
    public final int f6407i;
    @Nullable

    /* renamed from: if  reason: not valid java name */
    public Object[] f253if;

    /* renamed from: o  reason: collision with root package name */
    public final int f6408o;
    @NotNull

    /* renamed from: pf  reason: collision with root package name */
    public final BufferOverflow f6409pf;
    public int ppp;

    /* renamed from: switch  reason: not valid java name */
    public long f254switch;
    public long when;

    public /* synthetic */ class ad {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BufferOverflow.values().length];
            iArr[BufferOverflow.SUSPEND.ordinal()] = 1;
            iArr[BufferOverflow.DROP_LATEST.ordinal()] = 2;
            iArr[BufferOverflow.DROP_OLDEST.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final class qw implements DisposableHandle {
        @NotNull
        @JvmField

        /* renamed from: ad  reason: collision with root package name */
        public final SharedFlowImpl<?> f6410ad;
        @JvmField

        /* renamed from: th  reason: collision with root package name */
        public long f6411th;
        @NotNull
        @JvmField

        /* renamed from: uk  reason: collision with root package name */
        public final Continuation<Unit> f6412uk;
        @Nullable
        @JvmField

        /* renamed from: yj  reason: collision with root package name */
        public final Object f6413yj;

        public qw(@NotNull SharedFlowImpl<?> sharedFlowImpl, long j, @Nullable Object obj, @NotNull Continuation<? super Unit> continuation) {
            this.f6410ad = sharedFlowImpl;
            this.f6411th = j;
            this.f6413yj = obj;
            this.f6412uk = continuation;
        }

        public void dispose() {
            this.f6410ad.tt(this);
        }
    }

    public SharedFlowImpl(int i2, int i3, @NotNull BufferOverflow bufferOverflow) {
        this.f6407i = i2;
        this.f6408o = i3;
        this.f6409pf = bufferOverflow;
    }

    public final void a() {
        if (this.f6408o != 0 || this.ggg > 1) {
            Object[] objArr = this.f253if;
            Intrinsics.checkNotNull(objArr);
            while (this.ggg > 0 && b0.th(objArr, (k() + ((long) p())) - 1) == b0.qw) {
                this.ggg--;
                b0.yj(objArr, k() + ((long) p()), (Object) null);
            }
        }
    }

    @NotNull
    public Flow<T> ad(@NotNull CoroutineContext coroutineContext, int i2, @NotNull BufferOverflow bufferOverflow) {
        return b0.rg(this, coroutineContext, i2, bufferOverflow);
    }

    public final void b(long j) {
        de[] uk2;
        if (!(this.f6237th == 0 || (uk2 = this.f6236ad) == null)) {
            for (de deVar : uk2) {
                if (deVar != null) {
                    c0 c0Var = (c0) deVar;
                    long j2 = c0Var.qw;
                    if (j2 >= 0 && j2 < j) {
                        c0Var.qw = j;
                    }
                }
            }
        }
        this.when = j;
    }

    @NotNull
    /* renamed from: c */
    public c0 o() {
        return new c0();
    }

    @NotNull
    /* renamed from: d */
    public c0[] pf(int i2) {
        return new c0[i2];
    }

    public final void e() {
        Object[] objArr = this.f253if;
        Intrinsics.checkNotNull(objArr);
        b0.yj(objArr, k(), (Object) null);
        this.ppp--;
        long k = k() + 1;
        if (this.f254switch < k) {
            this.f254switch = k;
        }
        if (this.when < k) {
            b(k);
        }
        if (k.qw()) {
            if (!(k() == k)) {
                throw new AssertionError();
            }
        }
    }

    @Nullable
    public Object emit(T t, @NotNull Continuation<? super Unit> continuation) {
        if (qw(t)) {
            return Unit.INSTANCE;
        }
        Object f = f(t, continuation);
        return f == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? f : Unit.INSTANCE;
    }

    public final Object f(T t, Continuation<? super Unit> continuation) {
        Continuation<Unit>[] continuationArr;
        qw qwVar;
        ggg ggg2 = new ggg(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), 1);
        ggg2.eee();
        Continuation<Unit>[] continuationArr2 = i.qw.w1.i0.ad.qw;
        synchronized (this) {
            if (r(t)) {
                Unit unit = Unit.INSTANCE;
                Result.Companion companion = Result.Companion;
                ggg2.resumeWith(Result.m1155constructorimpl(unit));
                continuationArr = h(continuationArr2);
                qwVar = null;
            } else {
                qw qwVar2 = new qw(this, ((long) p()) + k(), t, ggg2);
                g(qwVar2);
                this.ggg = this.ggg + 1;
                if (this.f6408o == 0) {
                    continuationArr2 = h(continuationArr2);
                }
                continuationArr = continuationArr2;
                qwVar = qwVar2;
            }
        }
        if (qwVar != null) {
            xxx.qw(ggg2, qwVar);
        }
        int i2 = 0;
        int length = continuationArr.length;
        while (i2 < length) {
            Continuation<Unit> continuation2 = continuationArr[i2];
            i2++;
            if (continuation2 != null) {
                Unit unit2 = Unit.INSTANCE;
                Result.Companion companion2 = Result.Companion;
                continuation2.resumeWith(Result.m1155constructorimpl(unit2));
            }
        }
        Object mmm = ggg2.mmm();
        if (mmm == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return mmm == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? mmm : Unit.INSTANCE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: i.qw.w1.c0} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v8, resolved type: kotlinx.coroutines.flow.SharedFlowImpl} */
    /* JADX WARNING: type inference failed for: r10v9, types: [i.qw.w1.i0.de] */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00bf A[Catch:{ all -> 0x006f }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00a8 A[EDGE_INSN: B:50:0x00a8->B:37:0x00a8 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00cf A[SYNTHETIC] */
    @org.jetbrains.annotations.Nullable
    public java.lang.Object fe(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.FlowCollector<? super T> r9, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof kotlinx.coroutines.flow.SharedFlowImpl$collect$1
            if (r0 == 0) goto L_0x0013
            r0 = r10
            kotlinx.coroutines.flow.SharedFlowImpl$collect$1 r0 = (kotlinx.coroutines.flow.SharedFlowImpl$collect$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.flow.SharedFlowImpl$collect$1 r0 = new kotlinx.coroutines.flow.SharedFlowImpl$collect$1
            r0.<init>(r8, r10)
        L_0x0018:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0071
            if (r2 == r5) goto L_0x005d
            if (r2 == r4) goto L_0x0049
            if (r2 != r3) goto L_0x0041
            java.lang.Object r9 = r0.L$3
            kotlinx.coroutines.Job r9 = (kotlinx.coroutines.Job) r9
            java.lang.Object r2 = r0.L$2
            i.qw.w1.c0 r2 = (i.qw.w1.c0) r2
            java.lang.Object r5 = r0.L$1
            kotlinx.coroutines.flow.FlowCollector r5 = (kotlinx.coroutines.flow.FlowCollector) r5
            java.lang.Object r6 = r0.L$0
            kotlinx.coroutines.flow.SharedFlowImpl r6 = (kotlinx.coroutines.flow.SharedFlowImpl) r6
            kotlin.ResultKt.throwOnFailure(r10)     // Catch:{ all -> 0x006f }
        L_0x003e:
            r10 = r9
            r9 = r5
            goto L_0x009e
        L_0x0041:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x0049:
            java.lang.Object r9 = r0.L$3
            kotlinx.coroutines.Job r9 = (kotlinx.coroutines.Job) r9
            java.lang.Object r2 = r0.L$2
            i.qw.w1.c0 r2 = (i.qw.w1.c0) r2
            java.lang.Object r5 = r0.L$1
            kotlinx.coroutines.flow.FlowCollector r5 = (kotlinx.coroutines.flow.FlowCollector) r5
            java.lang.Object r6 = r0.L$0
            kotlinx.coroutines.flow.SharedFlowImpl r6 = (kotlinx.coroutines.flow.SharedFlowImpl) r6
            kotlin.ResultKt.throwOnFailure(r10)     // Catch:{ all -> 0x006f }
            goto L_0x00a0
        L_0x005d:
            java.lang.Object r9 = r0.L$2
            r2 = r9
            i.qw.w1.c0 r2 = (i.qw.w1.c0) r2
            java.lang.Object r9 = r0.L$1
            kotlinx.coroutines.flow.FlowCollector r9 = (kotlinx.coroutines.flow.FlowCollector) r9
            java.lang.Object r5 = r0.L$0
            r6 = r5
            kotlinx.coroutines.flow.SharedFlowImpl r6 = (kotlinx.coroutines.flow.SharedFlowImpl) r6
            kotlin.ResultKt.throwOnFailure(r10)     // Catch:{ all -> 0x006f }
            goto L_0x0092
        L_0x006f:
            r9 = move-exception
            goto L_0x00d2
        L_0x0071:
            kotlin.ResultKt.throwOnFailure(r10)
            i.qw.w1.i0.de r10 = r8.i()
            r2 = r10
            i.qw.w1.c0 r2 = (i.qw.w1.c0) r2
            boolean r10 = r9 instanceof kotlinx.coroutines.flow.SubscribedFlowCollector     // Catch:{ all -> 0x00d0 }
            if (r10 == 0) goto L_0x0091
            r10 = r9
            kotlinx.coroutines.flow.SubscribedFlowCollector r10 = (kotlinx.coroutines.flow.SubscribedFlowCollector) r10     // Catch:{ all -> 0x00d0 }
            r0.L$0 = r8     // Catch:{ all -> 0x00d0 }
            r0.L$1 = r9     // Catch:{ all -> 0x00d0 }
            r0.L$2 = r2     // Catch:{ all -> 0x00d0 }
            r0.label = r5     // Catch:{ all -> 0x00d0 }
            java.lang.Object r10 = r10.ad(r0)     // Catch:{ all -> 0x00d0 }
            if (r10 != r1) goto L_0x0091
            return r1
        L_0x0091:
            r6 = r8
        L_0x0092:
            kotlin.coroutines.CoroutineContext r10 = r0.getContext()     // Catch:{ all -> 0x006f }
            kotlinx.coroutines.Job$ad r5 = kotlinx.coroutines.Job.f6325fe     // Catch:{ all -> 0x006f }
            kotlin.coroutines.CoroutineContext$Element r10 = r10.get(r5)     // Catch:{ all -> 0x006f }
            kotlinx.coroutines.Job r10 = (kotlinx.coroutines.Job) r10     // Catch:{ all -> 0x006f }
        L_0x009e:
            r5 = r9
            r9 = r10
        L_0x00a0:
            java.lang.Object r10 = r6.u(r2)     // Catch:{ all -> 0x006f }
            i.qw.x1.c r7 = i.qw.w1.b0.qw     // Catch:{ all -> 0x006f }
            if (r10 == r7) goto L_0x00bf
            if (r9 != 0) goto L_0x00ab
            goto L_0x00ae
        L_0x00ab:
            i.qw.r0.uk(r9)     // Catch:{ all -> 0x006f }
        L_0x00ae:
            r0.L$0 = r6     // Catch:{ all -> 0x006f }
            r0.L$1 = r5     // Catch:{ all -> 0x006f }
            r0.L$2 = r2     // Catch:{ all -> 0x006f }
            r0.L$3 = r9     // Catch:{ all -> 0x006f }
            r0.label = r3     // Catch:{ all -> 0x006f }
            java.lang.Object r10 = r5.emit(r10, r0)     // Catch:{ all -> 0x006f }
            if (r10 != r1) goto L_0x003e
            return r1
        L_0x00bf:
            r0.L$0 = r6     // Catch:{ all -> 0x006f }
            r0.L$1 = r5     // Catch:{ all -> 0x006f }
            r0.L$2 = r2     // Catch:{ all -> 0x006f }
            r0.L$3 = r9     // Catch:{ all -> 0x006f }
            r0.label = r4     // Catch:{ all -> 0x006f }
            java.lang.Object r10 = r6.rrr(r2, r0)     // Catch:{ all -> 0x006f }
            if (r10 != r1) goto L_0x00a0
            return r1
        L_0x00d0:
            r9 = move-exception
            r6 = r8
        L_0x00d2:
            r6.m409if(r2)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.SharedFlowImpl.fe(kotlinx.coroutines.flow.FlowCollector, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void g(Object obj) {
        int p = p();
        Object[] objArr = this.f253if;
        if (objArr == null) {
            objArr = q((Object[]) null, 0, 2);
        } else if (p >= objArr.length) {
            objArr = q(objArr, p, objArr.length * 2);
        }
        b0.yj(objArr, k() + ((long) p), obj);
    }

    /* JADX WARNING: type inference failed for: r12v6, types: [java.lang.Object[], java.lang.Object] */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0048, code lost:
        r12 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0048, code lost:
        r12 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0017, code lost:
        r4 = (i.qw.w1.c0) r4;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kotlin.coroutines.Continuation<kotlin.Unit>[] h(kotlin.coroutines.Continuation<kotlin.Unit>[] r12) {
        /*
            r11 = this;
            int r0 = r12.length
            int r1 = r11.f6237th
            if (r1 != 0) goto L_0x0008
            goto L_0x004b
        L_0x0008:
            i.qw.w1.i0.de[] r1 = r11.f6236ad
            if (r1 != 0) goto L_0x000f
            goto L_0x004b
        L_0x000f:
            int r2 = r1.length
            r3 = 0
        L_0x0011:
            if (r3 >= r2) goto L_0x004b
            r4 = r1[r3]
            if (r4 == 0) goto L_0x0048
            i.qw.w1.c0 r4 = (i.qw.w1.c0) r4
            kotlin.coroutines.Continuation<? super kotlin.Unit> r5 = r4.f6225ad
            if (r5 != 0) goto L_0x001e
            goto L_0x0048
        L_0x001e:
            long r6 = r11.t(r4)
            r8 = 0
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r10 >= 0) goto L_0x0029
            goto L_0x0048
        L_0x0029:
            int r6 = r12.length
            if (r0 < r6) goto L_0x003d
            int r6 = r12.length
            r7 = 2
            int r6 = r6 * 2
            int r6 = java.lang.Math.max(r7, r6)
            java.lang.Object[] r12 = java.util.Arrays.copyOf(r12, r6)
            java.lang.String r6 = "java.util.Arrays.copyOf(this, newSize)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r6)
        L_0x003d:
            r6 = r12
            kotlin.coroutines.Continuation[] r6 = (kotlin.coroutines.Continuation[]) r6
            int r7 = r0 + 1
            r6[r0] = r5
            r0 = 0
            r4.f6225ad = r0
            r0 = r7
        L_0x0048:
            int r3 = r3 + 1
            goto L_0x0011
        L_0x004b:
            kotlin.coroutines.Continuation[] r12 = (kotlin.coroutines.Continuation[]) r12
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.SharedFlowImpl.h(kotlin.coroutines.Continuation[]):kotlin.coroutines.Continuation[]");
    }

    public final long j() {
        return k() + ((long) this.ppp);
    }

    public final long k() {
        return Math.min(this.when, this.f254switch);
    }

    public final Object l(long j) {
        Object[] objArr = this.f253if;
        Intrinsics.checkNotNull(objArr);
        Object de2 = b0.th(objArr, j);
        return de2 instanceof qw ? ((qw) de2).f6413yj : de2;
    }

    public final long m() {
        return k() + ((long) this.ppp) + ((long) this.ggg);
    }

    public final int n() {
        return (int) ((k() + ((long) this.ppp)) - this.f254switch);
    }

    public final int p() {
        return this.ppp + this.ggg;
    }

    public final Object[] q(Object[] objArr, int i2, int i3) {
        int i4 = 0;
        if (i3 > 0) {
            Object[] objArr2 = new Object[i3];
            this.f253if = objArr2;
            if (objArr == null) {
                return objArr2;
            }
            long k = k();
            if (i2 > 0) {
                while (true) {
                    int i5 = i4 + 1;
                    long j = ((long) i4) + k;
                    b0.yj(objArr2, j, b0.th(objArr, j));
                    if (i5 >= i2) {
                        break;
                    }
                    i4 = i5;
                }
            }
            return objArr2;
        }
        throw new IllegalStateException("Buffer size overflow".toString());
    }

    public boolean qw(T t) {
        int i2;
        boolean z;
        Continuation<Unit>[] continuationArr = i.qw.w1.i0.ad.qw;
        synchronized (this) {
            i2 = 0;
            if (r(t)) {
                continuationArr = h(continuationArr);
                z = true;
            } else {
                z = false;
            }
        }
        int length = continuationArr.length;
        while (i2 < length) {
            Continuation<Unit> continuation = continuationArr[i2];
            i2++;
            if (continuation != null) {
                Unit unit = Unit.INSTANCE;
                Result.Companion companion = Result.Companion;
                continuation.resumeWith(Result.m1155constructorimpl(unit));
            }
        }
        return z;
    }

    public final boolean r(T t) {
        if (m410switch() == 0) {
            return s(t);
        }
        if (this.ppp >= this.f6408o && this.when <= this.f254switch) {
            int i2 = ad.$EnumSwitchMapping$0[this.f6409pf.ordinal()];
            if (i2 == 1) {
                return false;
            }
            if (i2 == 2) {
                return true;
            }
        }
        g(t);
        int i3 = this.ppp + 1;
        this.ppp = i3;
        if (i3 > this.f6408o) {
            e();
        }
        if (n() > this.f6407i) {
            v(this.f254switch + 1, this.when, j(), m());
        }
        return true;
    }

    public final Object rrr(c0 c0Var, Continuation<? super Unit> continuation) {
        ggg ggg2 = new ggg(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), 1);
        ggg2.eee();
        synchronized (this) {
            if (t(c0Var) < 0) {
                c0Var.f6225ad = ggg2;
                c0Var.f6225ad = ggg2;
            } else {
                Unit unit = Unit.INSTANCE;
                Result.Companion companion = Result.Companion;
                ggg2.resumeWith(Result.m1155constructorimpl(unit));
            }
            Unit unit2 = Unit.INSTANCE;
        }
        Object mmm = ggg2.mmm();
        if (mmm == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return mmm == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? mmm : Unit.INSTANCE;
    }

    public final boolean s(T t) {
        if (k.qw()) {
            if (!(m410switch() == 0)) {
                throw new AssertionError();
            }
        }
        if (this.f6407i == 0) {
            return true;
        }
        g(t);
        int i2 = this.ppp + 1;
        this.ppp = i2;
        if (i2 > this.f6407i) {
            e();
        }
        this.when = k() + ((long) this.ppp);
        return true;
    }

    public final long t(c0 c0Var) {
        long j = c0Var.qw;
        if (j < j()) {
            return j;
        }
        if (this.f6408o <= 0 && j <= k() && this.ggg != 0) {
            return j;
        }
        return -1;
    }

    public void th() {
        synchronized (this) {
            v(j(), this.when, j(), m());
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void tt(qw qwVar) {
        synchronized (this) {
            if (qwVar.f6411th >= k()) {
                Object[] objArr = this.f253if;
                Intrinsics.checkNotNull(objArr);
                if (b0.th(objArr, qwVar.f6411th) == qwVar) {
                    b0.yj(objArr, qwVar.f6411th, b0.qw);
                    a();
                    Unit unit = Unit.INSTANCE;
                }
            }
        }
    }

    public final Object u(c0 c0Var) {
        Object obj;
        Continuation<Unit>[] continuationArr = i.qw.w1.i0.ad.qw;
        synchronized (this) {
            long t = t(c0Var);
            if (t < 0) {
                obj = b0.qw;
            } else {
                long j = c0Var.qw;
                Object l = l(t);
                c0Var.qw = t + 1;
                Object obj2 = l;
                continuationArr = w(j);
                obj = obj2;
            }
        }
        int i2 = 0;
        int length = continuationArr.length;
        while (i2 < length) {
            Continuation<Unit> continuation = continuationArr[i2];
            i2++;
            if (continuation != null) {
                Unit unit = Unit.INSTANCE;
                Result.Companion companion = Result.Companion;
                continuation.resumeWith(Result.m1155constructorimpl(unit));
            }
        }
        return obj;
    }

    public final void v(long j, long j2, long j3, long j4) {
        long j5 = j;
        long j6 = j2;
        long min = Math.min(j6, j5);
        boolean z = true;
        if (k.qw()) {
            if (!(min >= k())) {
                throw new AssertionError();
            }
        }
        long k = k();
        if (k < min) {
            while (true) {
                long j7 = 1 + k;
                Object[] objArr = this.f253if;
                Intrinsics.checkNotNull(objArr);
                b0.yj(objArr, k, (Object) null);
                if (j7 >= min) {
                    break;
                }
                k = j7;
            }
        }
        this.f254switch = j5;
        this.when = j6;
        this.ppp = (int) (j3 - min);
        this.ggg = (int) (j4 - j3);
        if (k.qw()) {
            if (!(this.ppp >= 0)) {
                throw new AssertionError();
            }
        }
        if (k.qw()) {
            if (!(this.ggg >= 0)) {
                throw new AssertionError();
            }
        }
        if (k.qw()) {
            if (this.f254switch > k() + ((long) this.ppp)) {
                z = false;
            }
            if (!z) {
                throw new AssertionError();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:70:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0125  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0137  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0139  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x013e  */
    /* JADX WARNING: Removed duplicated region for block: B:95:? A[RETURN, SYNTHETIC] */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kotlin.coroutines.Continuation<kotlin.Unit>[] w(long r23) {
        /*
            r22 = this;
            r9 = r22
            boolean r0 = i.qw.k.qw()
            if (r0 == 0) goto L_0x001a
            long r0 = r9.when
            int r2 = (r23 > r0 ? 1 : (r23 == r0 ? 0 : -1))
            if (r2 < 0) goto L_0x0010
            r0 = 1
            goto L_0x0011
        L_0x0010:
            r0 = 0
        L_0x0011:
            if (r0 == 0) goto L_0x0014
            goto L_0x001a
        L_0x0014:
            java.lang.AssertionError r0 = new java.lang.AssertionError
            r0.<init>()
            throw r0
        L_0x001a:
            long r0 = r9.when
            int r2 = (r23 > r0 ? 1 : (r23 == r0 ? 0 : -1))
            if (r2 <= 0) goto L_0x0023
            kotlin.coroutines.Continuation<kotlin.Unit>[] r0 = i.qw.w1.i0.ad.qw
            return r0
        L_0x0023:
            long r0 = r22.k()
            int r2 = r9.ppp
            long r2 = (long) r2
            long r2 = r2 + r0
            int r4 = r9.f6408o
            r5 = 1
            if (r4 != 0) goto L_0x0036
            int r4 = r9.ggg
            if (r4 <= 0) goto L_0x0036
            long r2 = r2 + r5
        L_0x0036:
            int r4 = r22.f6237th
            if (r4 != 0) goto L_0x003d
            goto L_0x005e
        L_0x003d:
            i.qw.w1.i0.de[] r4 = r22.f6236ad
            if (r4 != 0) goto L_0x0044
            goto L_0x005e
        L_0x0044:
            int r7 = r4.length
            r8 = 0
        L_0x0046:
            if (r8 >= r7) goto L_0x005e
            r12 = r4[r8]
            if (r12 == 0) goto L_0x005b
            i.qw.w1.c0 r12 = (i.qw.w1.c0) r12
            long r12 = r12.qw
            r14 = 0
            int r16 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r16 < 0) goto L_0x005b
            int r14 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r14 >= 0) goto L_0x005b
            r2 = r12
        L_0x005b:
            int r8 = r8 + 1
            goto L_0x0046
        L_0x005e:
            boolean r4 = i.qw.k.qw()
            if (r4 == 0) goto L_0x0076
            long r7 = r9.when
            int r4 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r4 < 0) goto L_0x006c
            r4 = 1
            goto L_0x006d
        L_0x006c:
            r4 = 0
        L_0x006d:
            if (r4 == 0) goto L_0x0070
            goto L_0x0076
        L_0x0070:
            java.lang.AssertionError r0 = new java.lang.AssertionError
            r0.<init>()
            throw r0
        L_0x0076:
            long r7 = r9.when
            int r4 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r4 > 0) goto L_0x007f
            kotlin.coroutines.Continuation<kotlin.Unit>[] r0 = i.qw.w1.i0.ad.qw
            return r0
        L_0x007f:
            long r7 = r22.j()
            int r4 = r22.m410switch()
            if (r4 <= 0) goto L_0x0096
            long r12 = r7 - r2
            int r4 = (int) r12
            int r12 = r9.ggg
            int r13 = r9.f6408o
            int r13 = r13 - r4
            int r4 = java.lang.Math.min(r12, r13)
            goto L_0x0098
        L_0x0096:
            int r4 = r9.ggg
        L_0x0098:
            kotlin.coroutines.Continuation<kotlin.Unit>[] r12 = i.qw.w1.i0.ad.qw
            int r13 = r9.ggg
            long r13 = (long) r13
            long r13 = r13 + r7
            if (r4 <= 0) goto L_0x00ee
            kotlin.coroutines.Continuation[] r12 = new kotlin.coroutines.Continuation[r4]
            java.lang.Object[] r15 = r9.f253if
            kotlin.jvm.internal.Intrinsics.checkNotNull(r15)
            int r16 = (r7 > r13 ? 1 : (r7 == r13 ? 0 : -1))
            if (r16 >= 0) goto L_0x00ee
            r10 = r7
            r17 = 0
        L_0x00ae:
            long r18 = r7 + r5
            java.lang.Object r5 = i.qw.w1.b0.th(r15, r7)
            i.qw.x1.c r6 = i.qw.w1.b0.qw
            if (r5 == r6) goto L_0x00df
            if (r5 == 0) goto L_0x00d7
            kotlinx.coroutines.flow.SharedFlowImpl$qw r5 = (kotlinx.coroutines.flow.SharedFlowImpl.qw) r5
            r20 = r2
            int r2 = r17 + 1
            kotlin.coroutines.Continuation<kotlin.Unit> r3 = r5.f6412uk
            r12[r17] = r3
            i.qw.w1.b0.yj(r15, r7, r6)
            java.lang.Object r3 = r5.f6413yj
            i.qw.w1.b0.yj(r15, r10, r3)
            r5 = 1
            long r7 = r10 + r5
            if (r2 < r4) goto L_0x00d3
            goto L_0x00f0
        L_0x00d3:
            r17 = r2
            r10 = r7
            goto L_0x00e1
        L_0x00d7:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "null cannot be cast to non-null type kotlinx.coroutines.flow.SharedFlowImpl.Emitter"
            r0.<init>(r1)
            throw r0
        L_0x00df:
            r20 = r2
        L_0x00e1:
            int r2 = (r18 > r13 ? 1 : (r18 == r13 ? 0 : -1))
            if (r2 < 0) goto L_0x00e7
            r7 = r10
            goto L_0x00f0
        L_0x00e7:
            r7 = r18
            r2 = r20
            r5 = 1
            goto L_0x00ae
        L_0x00ee:
            r20 = r2
        L_0x00f0:
            long r0 = r7 - r0
            int r1 = (int) r0
            int r0 = r22.m410switch()
            if (r0 != 0) goto L_0x00fb
            r3 = r7
            goto L_0x00fd
        L_0x00fb:
            r3 = r20
        L_0x00fd:
            long r5 = r9.f254switch
            int r0 = r9.f6407i
            int r0 = java.lang.Math.min(r0, r1)
            long r0 = (long) r0
            long r0 = r7 - r0
            long r0 = java.lang.Math.max(r5, r0)
            int r2 = r9.f6408o
            if (r2 != 0) goto L_0x0129
            int r2 = (r0 > r13 ? 1 : (r0 == r13 ? 0 : -1))
            if (r2 >= 0) goto L_0x0129
            java.lang.Object[] r2 = r9.f253if
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            java.lang.Object r2 = i.qw.w1.b0.th(r2, r0)
            i.qw.x1.c r5 = i.qw.w1.b0.qw
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r5)
            if (r2 == 0) goto L_0x0129
            r5 = 1
            long r7 = r7 + r5
            long r0 = r0 + r5
        L_0x0129:
            r1 = r0
            r5 = r7
            r0 = r22
            r7 = r13
            r0.v(r1, r3, r5, r7)
            r22.a()
            int r0 = r12.length
            if (r0 != 0) goto L_0x0139
            r10 = 1
            goto L_0x013a
        L_0x0139:
            r10 = 0
        L_0x013a:
            r0 = 1
            r0 = r0 ^ r10
            if (r0 == 0) goto L_0x0142
            kotlin.coroutines.Continuation[] r12 = r9.h(r12)
        L_0x0142:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.SharedFlowImpl.w(long):kotlin.coroutines.Continuation[]");
    }

    public final long x() {
        long j = this.f254switch;
        if (j < this.when) {
            this.when = j;
        }
        return j;
    }
}
