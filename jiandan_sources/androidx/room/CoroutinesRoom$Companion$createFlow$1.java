package androidx.room;

import i.qw.o;
import i.qw.u1.rg;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u0010\u0012\f\u0012\n \u0004*\u0004\u0018\u0001H\u0002H\u00020\u0003H@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "R", "Lkotlinx/coroutines/flow/FlowCollector;", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
@DebugMetadata(c = "androidx.room.CoroutinesRoom$Companion$createFlow$1", f = "CoroutinesRoom.kt", i = {0, 0, 0, 0, 0}, l = {75}, m = "invokeSuspend", n = {"$this$flow", "observerChannel", "observer", "flowContext", "queryContext"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4"})
public final class CoroutinesRoom$Companion$createFlow$1 extends SuspendLambda implements Function2<FlowCollector<? super R>, Continuation<? super Unit>, Object> {
    public final /* synthetic */ Callable $callable;
    public final /* synthetic */ RoomDatabase $db;
    public final /* synthetic */ boolean $inTransaction;
    public final /* synthetic */ String[] $tableNames;
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public Object L$3;
    public Object L$4;
    public int label;
    public FlowCollector p$;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "R", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    @DebugMetadata(c = "androidx.room.CoroutinesRoom$Companion$createFlow$1$1", f = "CoroutinesRoom.kt", i = {0, 1, 1, 1}, l = {80, 82}, m = "invokeSuspend", n = {"$this$withContext", "$this$withContext", "signal", "result"}, s = {"L$0", "L$0", "L$1", "L$3"})
    /* renamed from: androidx.room.CoroutinesRoom$Companion$createFlow$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public Object L$0;
        public Object L$1;
        public Object L$2;
        public Object L$3;
        public int label;
        public CoroutineScope p$;
        public final /* synthetic */ CoroutinesRoom$Companion$createFlow$1 this$0;

        {
            this.this$0 = r1;
        }

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, flowCollector2, coroutinesRoom$Companion$createFlow$1$observer$12, channel, coroutineContext, continuation);
            r0.p$ = (CoroutineScope) obj;
            return r0;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARNING: Removed duplicated region for block: B:22:0x005b A[Catch:{ all -> 0x009f }] */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x0066 A[Catch:{ all -> 0x009f }] */
        @org.jetbrains.annotations.Nullable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r12) {
            /*
                r11 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r11.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L_0x0035
                if (r1 == r3) goto L_0x0027
                if (r1 != r2) goto L_0x001f
                java.lang.Object r1 = r11.L$2
                kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
                java.lang.Object r4 = r11.L$1
                kotlin.Unit r4 = (kotlin.Unit) r4
                java.lang.Object r4 = r11.L$0
                kotlinx.coroutines.CoroutineScope r4 = (kotlinx.coroutines.CoroutineScope) r4
                kotlin.ResultKt.throwOnFailure(r12)     // Catch:{ all -> 0x00a1 }
                r12 = r4
                goto L_0x004d
            L_0x001f:
                java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r12.<init>(r0)
                throw r12
            L_0x0027:
                java.lang.Object r1 = r11.L$1
                kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
                java.lang.Object r4 = r11.L$0
                kotlinx.coroutines.CoroutineScope r4 = (kotlinx.coroutines.CoroutineScope) r4
                kotlin.ResultKt.throwOnFailure(r12)     // Catch:{ all -> 0x00a1 }
                r5 = r4
                r4 = r11
                goto L_0x005e
            L_0x0035:
                kotlin.ResultKt.throwOnFailure(r12)
                kotlinx.coroutines.CoroutineScope r12 = r11.p$
                androidx.room.CoroutinesRoom$Companion$createFlow$1 r1 = r11.this$0
                androidx.room.RoomDatabase r1 = r1.$db
                androidx.room.InvalidationTracker r1 = r1.getInvalidationTracker()
                androidx.room.CoroutinesRoom$Companion$createFlow$1$observer$1 r4 = r6
                r1.addObserver(r4)
                kotlinx.coroutines.channels.Channel r1 = r7     // Catch:{ all -> 0x00a1 }
                kotlinx.coroutines.channels.ChannelIterator r1 = r1.iterator()     // Catch:{ all -> 0x00a1 }
            L_0x004d:
                r4 = r11
            L_0x004e:
                r4.L$0 = r12     // Catch:{ all -> 0x009f }
                r4.L$1 = r1     // Catch:{ all -> 0x009f }
                r4.label = r3     // Catch:{ all -> 0x009f }
                java.lang.Object r5 = r1.qw(r4)     // Catch:{ all -> 0x009f }
                if (r5 != r0) goto L_0x005b
                return r0
            L_0x005b:
                r10 = r5
                r5 = r12
                r12 = r10
            L_0x005e:
                java.lang.Boolean r12 = (java.lang.Boolean) r12     // Catch:{ all -> 0x009f }
                boolean r12 = r12.booleanValue()     // Catch:{ all -> 0x009f }
                if (r12 == 0) goto L_0x008f
                java.lang.Object r12 = r1.next()     // Catch:{ all -> 0x009f }
                kotlin.Unit r12 = (kotlin.Unit) r12     // Catch:{ all -> 0x009f }
                androidx.room.CoroutinesRoom$Companion$createFlow$1 r6 = r4.this$0     // Catch:{ all -> 0x009f }
                java.util.concurrent.Callable r6 = r6.$callable     // Catch:{ all -> 0x009f }
                java.lang.Object r6 = r6.call()     // Catch:{ all -> 0x009f }
                kotlin.coroutines.CoroutineContext r7 = r8     // Catch:{ all -> 0x009f }
                androidx.room.CoroutinesRoom$Companion$createFlow$1$1$1 r8 = new androidx.room.CoroutinesRoom$Companion$createFlow$1$1$1     // Catch:{ all -> 0x009f }
                r9 = 0
                r8.<init>(r4, r6, r9)     // Catch:{ all -> 0x009f }
                r4.L$0 = r5     // Catch:{ all -> 0x009f }
                r4.L$1 = r12     // Catch:{ all -> 0x009f }
                r4.L$2 = r1     // Catch:{ all -> 0x009f }
                r4.L$3 = r6     // Catch:{ all -> 0x009f }
                r4.label = r2     // Catch:{ all -> 0x009f }
                java.lang.Object r12 = i.qw.o.yj(r7, r8, r4)     // Catch:{ all -> 0x009f }
                if (r12 != r0) goto L_0x008d
                return r0
            L_0x008d:
                r12 = r5
                goto L_0x004e
            L_0x008f:
                androidx.room.CoroutinesRoom$Companion$createFlow$1 r12 = r4.this$0
                androidx.room.RoomDatabase r12 = r12.$db
                androidx.room.InvalidationTracker r12 = r12.getInvalidationTracker()
                androidx.room.CoroutinesRoom$Companion$createFlow$1$observer$1 r0 = r6
                r12.removeObserver(r0)
                kotlin.Unit r12 = kotlin.Unit.INSTANCE
                return r12
            L_0x009f:
                r12 = move-exception
                goto L_0x00a3
            L_0x00a1:
                r12 = move-exception
                r4 = r11
            L_0x00a3:
                androidx.room.CoroutinesRoom$Companion$createFlow$1 r0 = r4.this$0
                androidx.room.RoomDatabase r0 = r0.$db
                androidx.room.InvalidationTracker r0 = r0.getInvalidationTracker()
                androidx.room.CoroutinesRoom$Companion$createFlow$1$observer$1 r1 = r6
                r0.removeObserver(r1)
                throw r12
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.room.CoroutinesRoom$Companion$createFlow$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CoroutinesRoom$Companion$createFlow$1(String[] strArr, boolean z, RoomDatabase roomDatabase, Callable callable, Continuation continuation) {
        super(2, continuation);
        this.$tableNames = strArr;
        this.$inTransaction = z;
        this.$db = roomDatabase;
        this.$callable = callable;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        CoroutinesRoom$Companion$createFlow$1 coroutinesRoom$Companion$createFlow$1 = new CoroutinesRoom$Companion$createFlow$1(this.$tableNames, this.$inTransaction, this.$db, this.$callable, continuation);
        coroutinesRoom$Companion$createFlow$1.p$ = (FlowCollector) obj;
        return coroutinesRoom$Companion$createFlow$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((CoroutinesRoom$Companion$createFlow$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector = this.p$;
            Channel qw = rg.de(-1, (BufferOverflow) null, (Function1) null, 6, (Object) null);
            CoroutinesRoom$Companion$createFlow$1$observer$1 coroutinesRoom$Companion$createFlow$1$observer$1 = new CoroutinesRoom$Companion$createFlow$1$observer$1(this, qw, this.$tableNames);
            qw.offer(Unit.INSTANCE);
            CoroutineContext context = getContext();
            CoroutineDispatcher transactionDispatcher = this.$inTransaction ? CoroutinesRoomKt.getTransactionDispatcher(this.$db) : CoroutinesRoomKt.getQueryDispatcher(this.$db);
            final FlowCollector flowCollector2 = flowCollector;
            final CoroutinesRoom$Companion$createFlow$1$observer$1 coroutinesRoom$Companion$createFlow$1$observer$12 = coroutinesRoom$Companion$createFlow$1$observer$1;
            final Channel channel = qw;
            final CoroutineContext coroutineContext = context;
            AnonymousClass1 r3 = new AnonymousClass1(this, (Continuation) null);
            this.L$0 = flowCollector;
            this.L$1 = qw;
            this.L$2 = coroutinesRoom$Companion$createFlow$1$observer$1;
            this.L$3 = context;
            this.L$4 = transactionDispatcher;
            this.label = 1;
            if (o.yj(transactionDispatcher, r3, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i2 == 1) {
            CoroutineDispatcher coroutineDispatcher = (CoroutineDispatcher) this.L$4;
            CoroutineContext coroutineContext2 = (CoroutineContext) this.L$3;
            CoroutinesRoom$Companion$createFlow$1$observer$1 coroutinesRoom$Companion$createFlow$1$observer$13 = (CoroutinesRoom$Companion$createFlow$1$observer$1) this.L$2;
            Channel channel2 = (Channel) this.L$1;
            FlowCollector flowCollector3 = (FlowCollector) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
