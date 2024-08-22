package i.qw;

import i.qw.x1.b;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CancellableContinuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class c {
    @Nullable
    public static final <T> Object ad(@NotNull Object obj, @Nullable Function1<? super Throwable, Unit> function1) {
        Throwable r0 = Result.m1158exceptionOrNullimpl(obj);
        if (r0 != null) {
            return new tt(r0, false, 2, (DefaultConstructorMarker) null);
        }
        if (function1 != null) {
            return new a(obj, function1);
        }
        return obj;
    }

    @Nullable
    public static final <T> Object de(@NotNull Object obj, @NotNull CancellableContinuation<?> cancellableContinuation) {
        Throwable r0 = Result.m1158exceptionOrNullimpl(obj);
        if (r0 != null) {
            if (k.fe() && (cancellableContinuation instanceof CoroutineStackFrame)) {
                r0 = b.o(r0, (CoroutineStackFrame) cancellableContinuation);
            }
            obj = new tt(r0, false, 2, (DefaultConstructorMarker) null);
        }
        return obj;
    }

    public static /* synthetic */ Object fe(Object obj, Function1 function1, int i2, Object obj2) {
        if ((i2 & 1) != 0) {
            function1 = null;
        }
        return ad(obj, function1);
    }

    @NotNull
    public static final <T> Object qw(@Nullable Object obj, @NotNull Continuation<? super T> continuation) {
        if (obj instanceof tt) {
            Result.Companion companion = Result.Companion;
            Throwable th2 = ((tt) obj).qw;
            if (k.fe() && (continuation instanceof CoroutineStackFrame)) {
                th2 = b.o(th2, (CoroutineStackFrame) continuation);
            }
            return Result.m1155constructorimpl(ResultKt.createFailure(th2));
        }
        Result.Companion companion2 = Result.Companion;
        return Result.m1155constructorimpl(obj);
    }
}
