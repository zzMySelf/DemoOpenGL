package i.qw;

import java.util.concurrent.CancellationException;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;

public final class l0 {
    public static final <T> T ad(CoroutineContext coroutineContext, Function0<? extends T> function0) {
        m1 m1Var;
        try {
            m1Var = new m1(r0.i(coroutineContext));
            m1Var.fe();
            T invoke = function0.invoke();
            m1Var.qw();
            return invoke;
        } catch (InterruptedException e) {
            throw new CancellationException("Blocking call was interrupted due to parent cancellation").initCause(e);
        } catch (Throwable th2) {
            m1Var.qw();
            throw th2;
        }
    }
}
