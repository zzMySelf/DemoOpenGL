package i.qw.y1;

import i.qw.x1.o;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class qw {
    public static final <T> void ad(@NotNull Function1<? super Continuation<? super T>, ? extends Object> function1, @NotNull Continuation<? super T> continuation) {
        try {
            Continuation<Unit> intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted(function1, continuation));
            Result.Companion companion = Result.Companion;
            o.de(intercepted, Result.m1155constructorimpl(Unit.INSTANCE), (Function1) null, 2, (Object) null);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            continuation.resumeWith(Result.m1155constructorimpl(ResultKt.createFailure(th2)));
        }
    }

    public static final <R, T> void de(@NotNull Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, R r, @NotNull Continuation<? super T> continuation, @Nullable Function1<? super Throwable, Unit> function1) {
        try {
            Continuation<Unit> intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted(function2, r, continuation));
            Result.Companion companion = Result.Companion;
            o.ad(intercepted, Result.m1155constructorimpl(Unit.INSTANCE), function1);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            continuation.resumeWith(Result.m1155constructorimpl(ResultKt.createFailure(th2)));
        }
    }

    public static /* synthetic */ void fe(Function2 function2, Object obj, Continuation continuation, Function1 function1, int i2, Object obj2) {
        if ((i2 & 4) != 0) {
            function1 = null;
        }
        de(function2, obj, continuation, function1);
    }

    public static final void qw(@NotNull Continuation<? super Unit> continuation, @NotNull Continuation<?> continuation2) {
        try {
            Continuation<? super Unit> intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
            Result.Companion companion = Result.Companion;
            o.de(intercepted, Result.m1155constructorimpl(Unit.INSTANCE), (Function1) null, 2, (Object) null);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            continuation2.resumeWith(Result.m1155constructorimpl(ResultKt.createFailure(th2)));
        }
    }
}
