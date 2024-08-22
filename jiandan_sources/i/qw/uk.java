package i.qw;

import java.util.concurrent.locks.LockSupport;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class uk<T> extends de<T> {
    @Nullable

    /* renamed from: uk  reason: collision with root package name */
    public final z f6199uk;
    @NotNull

    /* renamed from: yj  reason: collision with root package name */
    public final Thread f6200yj;

    public uk(@NotNull CoroutineContext coroutineContext, @NotNull Thread thread, @Nullable z zVar) {
        super(coroutineContext, true, true);
        this.f6200yj = thread;
        this.f6199uk = zVar;
    }

    public boolean M() {
        return true;
    }

    public void m(@Nullable Object obj) {
        if (!Intrinsics.areEqual((Object) Thread.currentThread(), (Object) this.f6200yj)) {
            Thread thread = this.f6200yj;
            fe qw = rg.qw();
            if (qw == null) {
                LockSupport.unpark(thread);
            } else {
                qw.th(thread);
            }
        }
    }

    public final T u0() {
        fe qw = rg.qw();
        if (qw != null) {
            qw.de();
        }
        try {
            z zVar = this.f6199uk;
            tt ttVar = null;
            if (zVar != null) {
                z.a(zVar, false, 1, (Object) null);
            }
            while (!Thread.interrupted()) {
                z zVar2 = this.f6199uk;
                long d = zVar2 == null ? Long.MAX_VALUE : zVar2.d();
                if (nn()) {
                    z zVar3 = this.f6199uk;
                    if (zVar3 != null) {
                        z.mmm(zVar3, false, 1, (Object) null);
                    }
                    fe qw2 = rg.qw();
                    if (qw2 != null) {
                        qw2.yj();
                    }
                    T uk2 = w0.uk(I());
                    if (uk2 instanceof tt) {
                        ttVar = (tt) uk2;
                    }
                    if (ttVar == null) {
                        return uk2;
                    }
                    throw ttVar.qw;
                }
                fe qw3 = rg.qw();
                if (qw3 == null) {
                    LockSupport.parkNanos(this, d);
                } else {
                    qw3.ad(this, d);
                }
            }
            InterruptedException interruptedException = new InterruptedException();
            q(interruptedException);
            throw interruptedException;
        } catch (Throwable th2) {
            fe qw4 = rg.qw();
            if (qw4 != null) {
                qw4.yj();
            }
            throw th2;
        }
    }
}
