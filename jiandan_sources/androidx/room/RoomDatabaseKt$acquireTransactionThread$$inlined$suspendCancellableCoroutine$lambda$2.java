package androidx.room;

import i.qw.pf;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "run", "androidx/room/RoomDatabaseKt$acquireTransactionThread$2$2"}, k = 3, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
public final class RoomDatabaseKt$acquireTransactionThread$$inlined$suspendCancellableCoroutine$lambda$2 implements Runnable {
    public final /* synthetic */ CancellableContinuation $continuation;
    public final /* synthetic */ Job $controlJob$inlined;
    public final /* synthetic */ Executor $this_acquireTransactionThread$inlined;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "androidx/room/RoomDatabaseKt$acquireTransactionThread$2$2$1"}, k = 3, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* renamed from: androidx.room.RoomDatabaseKt$acquireTransactionThread$$inlined$suspendCancellableCoroutine$lambda$2$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public Object L$0;
        public int label;
        public CoroutineScope p$;
        public final /* synthetic */ RoomDatabaseKt$acquireTransactionThread$$inlined$suspendCancellableCoroutine$lambda$2 this$0;

        {
            this.this$0 = r1;
        }

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, continuation);
            r0.p$ = (CoroutineScope) obj;
            return r0;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = this.p$;
                CancellableContinuation cancellableContinuation = this.this$0.$continuation;
                CoroutineContext.Element element = coroutineScope.getCoroutineContext().get(ContinuationInterceptor.Key);
                if (element == null) {
                    Intrinsics.throwNpe();
                }
                Result.Companion companion = Result.Companion;
                cancellableContinuation.resumeWith(Result.m1155constructorimpl(element));
                Job job = this.this$0.$controlJob$inlined;
                this.L$0 = coroutineScope;
                this.label = 1;
                if (job.aaa(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i2 == 1) {
                CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    public RoomDatabaseKt$acquireTransactionThread$$inlined$suspendCancellableCoroutine$lambda$2(CancellableContinuation cancellableContinuation, Executor executor, Job job) {
        this.$continuation = cancellableContinuation;
        this.$this_acquireTransactionThread$inlined = executor;
        this.$controlJob$inlined = job;
    }

    public final void run() {
        Object unused = pf.ad((CoroutineContext) null, new AnonymousClass1(this, (Continuation) null), 1, (Object) null);
    }
}
