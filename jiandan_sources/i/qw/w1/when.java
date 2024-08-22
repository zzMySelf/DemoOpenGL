package i.qw.w1;

import kotlin.BuilderInference;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final /* synthetic */ class when {

    public static final class qw implements Flow<T> {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ Object f6245ad;

        public qw(Object obj) {
            this.f6245ad = obj;
        }

        @Nullable
        public Object fe(@NotNull FlowCollector<? super T> flowCollector, @NotNull Continuation<? super Unit> continuation) {
            Object emit = flowCollector.emit(this.f6245ad, continuation);
            if (emit == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return emit;
            }
            return Unit.INSTANCE;
        }
    }

    @NotNull
    public static final <T> Flow<T> ad(T t) {
        return new qw(t);
    }

    @NotNull
    public static final <T> Flow<T> qw(@NotNull @BuilderInference Function2<? super FlowCollector<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        return new a0(function2);
    }
}
