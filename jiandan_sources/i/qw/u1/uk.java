package i.qw.u1;

import i.qw.k;
import i.qw.l;
import i.qw.vvv;
import i.qw.x1.c;
import i.qw.x1.ggg;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.channels.ClosedReceiveChannelException;
import kotlinx.coroutines.channels.ClosedSendChannelException;
import kotlinx.coroutines.channels.ReceiveOrClosed;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class uk<E> extends when implements ReceiveOrClosed<E> {
    @Nullable
    @JvmField

    /* renamed from: uk  reason: collision with root package name */
    public final Throwable f6198uk;

    public uk(@Nullable Throwable th2) {
        this.f6198uk = th2;
    }

    @NotNull
    public final Throwable A() {
        Throwable th2 = this.f6198uk;
        return th2 == null ? new ClosedSendChannelException("Channel was closed") : th2;
    }

    public /* bridge */ /* synthetic */ Object de() {
        x();
        return this;
    }

    public void s() {
    }

    public /* bridge */ /* synthetic */ Object t() {
        y();
        return this;
    }

    @NotNull
    public String toString() {
        return "Closed@" + l.ad(this) + '[' + this.f6198uk + ']';
    }

    public void u(@NotNull uk<?> ukVar) {
        if (k.qw()) {
            throw new AssertionError();
        }
    }

    @NotNull
    public c v(@Nullable ggg.de deVar) {
        c cVar = vvv.qw;
        if (deVar != null) {
            deVar.fe();
        }
        return cVar;
    }

    @NotNull
    public uk<E> x() {
        return this;
    }

    @NotNull
    public c xxx(E e, @Nullable ggg.de deVar) {
        c cVar = vvv.qw;
        if (deVar != null) {
            deVar.fe();
        }
        return cVar;
    }

    @NotNull
    public uk<E> y() {
        return this;
    }

    public void yj(E e) {
    }

    @NotNull
    public final Throwable z() {
        Throwable th2 = this.f6198uk;
        return th2 == null ? new ClosedReceiveChannelException("Channel was closed") : th2;
    }
}
