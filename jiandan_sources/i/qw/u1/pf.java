package i.qw.u1;

import i.qw.f;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.SendChannel;
import org.jetbrains.annotations.NotNull;

public class pf<E> extends fe<E> implements ProducerScope<E> {
    public pf(@NotNull CoroutineContext coroutineContext, @NotNull Channel<E> channel) {
        super(coroutineContext, channel, true, true);
    }

    public boolean isActive() {
        return super.isActive();
    }

    public void r0(@NotNull Throwable th2, boolean z) {
        if (!v0().c(th2) && !z) {
            f.qw(getContext(), th2);
        }
    }

    public /* bridge */ /* synthetic */ SendChannel uk() {
        u0();
        return this;
    }

    /* renamed from: w0 */
    public void s0(@NotNull Unit unit) {
        SendChannel.qw.qw(v0(), (Throwable) null, 1, (Object) null);
    }
}
