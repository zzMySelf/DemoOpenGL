package i.qw;

import i.qw.x1.rrr;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.TimeoutKt;
import org.jetbrains.annotations.NotNull;

public final class n1<U, T extends U> extends rrr<T> implements Runnable {
    @JvmField

    /* renamed from: uk  reason: collision with root package name */
    public final long f6152uk;

    public n1(long j, @NotNull Continuation<? super U> continuation) {
        super(continuation.getContext(), continuation);
        this.f6152uk = j;
    }

    @NotNull
    public String T() {
        return super.T() + "(timeMillis=" + this.f6152uk + ')';
    }

    public void run() {
        q(TimeoutKt.qw(this.f6152uk, this));
    }
}
