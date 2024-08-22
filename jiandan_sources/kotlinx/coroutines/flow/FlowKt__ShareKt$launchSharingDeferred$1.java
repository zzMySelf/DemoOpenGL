package kotlinx.coroutines.flow;

import i.qw.r0;
import i.qw.w1.f0;
import i.qw.w1.z;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H@"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharingDeferred$1", f = "Share.kt", i = {}, l = {418}, m = "invokeSuspend", n = {}, s = {})
public final class FlowKt__ShareKt$launchSharingDeferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ CompletableDeferred<StateFlow<T>> $result;
    public final /* synthetic */ Flow<T> $upstream;
    public /* synthetic */ Object L$0;
    public int label;

    public static final class qw implements FlowCollector<T> {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef f6404ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ CoroutineScope f6405th;

        /* renamed from: yj  reason: collision with root package name */
        public final /* synthetic */ CompletableDeferred f6406yj;

        public qw(Ref.ObjectRef objectRef, CoroutineScope coroutineScope, CompletableDeferred completableDeferred) {
            this.f6404ad = objectRef;
            this.f6405th = coroutineScope;
            this.f6406yj = completableDeferred;
        }

        @Nullable
        public Object emit(T t, @NotNull Continuation<? super Unit> continuation) {
            Unit unit;
            MutableStateFlow mutableStateFlow = (MutableStateFlow) this.f6404ad.element;
            if (mutableStateFlow == null) {
                unit = null;
            } else {
                mutableStateFlow.setValue(t);
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                CoroutineScope coroutineScope = this.f6405th;
                Ref.ObjectRef objectRef = this.f6404ad;
                T qw = f0.qw(t);
                this.f6406yj.ggg(new z(qw, r0.i(coroutineScope.getCoroutineContext())));
                Unit unit2 = Unit.INSTANCE;
                objectRef.element = qw;
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlowKt__ShareKt$launchSharingDeferred$1(Flow<? extends T> flow, CompletableDeferred<StateFlow<T>> completableDeferred, Continuation<? super FlowKt__ShareKt$launchSharingDeferred$1> continuation) {
        super(2, continuation);
        this.$upstream = flow;
        this.$result = completableDeferred;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        FlowKt__ShareKt$launchSharingDeferred$1 flowKt__ShareKt$launchSharingDeferred$1 = new FlowKt__ShareKt$launchSharingDeferred$1(this.$upstream, this.$result, continuation);
        flowKt__ShareKt$launchSharingDeferred$1.L$0 = obj;
        return flowKt__ShareKt$launchSharingDeferred$1;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FlowKt__ShareKt$launchSharingDeferred$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            Flow<T> flow = this.$upstream;
            qw qwVar = new qw(objectRef, coroutineScope, this.$result);
            this.label = 1;
            if (flow.fe(qwVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i2 == 1) {
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th2) {
                this.$result.when(th2);
                throw th2;
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
