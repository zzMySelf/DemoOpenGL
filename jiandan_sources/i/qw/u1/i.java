package i.qw.u1;

import i.qw.a2.ad;
import i.qw.k;
import i.qw.vvv;
import i.qw.x1.c;
import i.qw.x1.ggg;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.channels.AbstractChannel;
import kotlinx.coroutines.channels.ReceiveOrClosed;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.coroutines.selects.SelectInstance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class i<E> extends AbstractChannel<E> {
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    public Object f6187i = qw.qw;
    @NotNull

    /* renamed from: uk  reason: collision with root package name */
    public final ReentrantLock f6188uk = new ReentrantLock();

    public i(@Nullable Function1<? super E, Unit> function1) {
        super(function1);
    }

    @Nullable
    public Object A(@NotNull SelectInstance<?> selectInstance) {
        ReentrantLock reentrantLock = this.f6188uk;
        reentrantLock.lock();
        try {
            if (this.f6187i == qw.qw) {
                Object i2 = i();
                if (i2 == null) {
                    i2 = qw.f6193fe;
                }
                return i2;
            } else if (!selectInstance.m668if()) {
                Object fe2 = ad.fe();
                reentrantLock.unlock();
                return fe2;
            } else {
                Object obj = this.f6187i;
                this.f6187i = qw.qw;
                Unit unit = Unit.INSTANCE;
                reentrantLock.unlock();
                return obj;
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    public final UndeliveredElementException F(Object obj) {
        Function1<E, Unit> function1;
        Object obj2 = this.f6187i;
        UndeliveredElementException undeliveredElementException = null;
        if (!(obj2 == qw.qw || (function1 = this.f6177ad) == null)) {
            undeliveredElementException = OnUndeliveredElementKt.fe(function1, obj2, (UndeliveredElementException) null, 2, (Object) null);
        }
        this.f6187i = obj;
        return undeliveredElementException;
    }

    /* JADX INFO: finally extract failed */
    @NotNull
    public Object aaa(E e) {
        ReceiveOrClosed f;
        c xxx;
        ReentrantLock reentrantLock = this.f6188uk;
        reentrantLock.lock();
        try {
            uk<?> i2 = i();
            if (i2 == null) {
                if (this.f6187i == qw.qw) {
                    do {
                        f = f();
                        if (f != null) {
                            if (f instanceof uk) {
                                reentrantLock.unlock();
                                return f;
                            }
                            xxx = f.xxx(e, (ggg.de) null);
                        }
                    } while (xxx == null);
                    if (k.qw()) {
                        if (!(xxx == vvv.qw)) {
                            throw new AssertionError();
                        }
                    }
                    Unit unit = Unit.INSTANCE;
                    reentrantLock.unlock();
                    f.yj(e);
                    return f.de();
                }
                UndeliveredElementException F = F(e);
                if (F == null) {
                    c cVar = qw.f6191ad;
                    reentrantLock.unlock();
                    return cVar;
                }
                throw F;
            }
            reentrantLock.unlock();
            return i2;
        } catch (Throwable th2) {
            reentrantLock.unlock();
            throw th2;
        }
    }

    public final boolean ddd() {
        return false;
    }

    public boolean p(@NotNull Cif<? super E> ifVar) {
        ReentrantLock reentrantLock = this.f6188uk;
        reentrantLock.lock();
        try {
            return super.p(ifVar);
        } finally {
            reentrantLock.unlock();
        }
    }

    public final boolean r() {
        return false;
    }

    public final boolean s() {
        return this.f6187i == qw.qw;
    }

    @NotNull
    public String th() {
        return "(value=" + this.f6187i + ')';
    }

    /* JADX INFO: finally extract failed */
    public void v(boolean z) {
        ReentrantLock reentrantLock = this.f6188uk;
        reentrantLock.lock();
        try {
            UndeliveredElementException F = F(qw.qw);
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
            super.v(z);
            if (F != null) {
                throw F;
            }
        } catch (Throwable th2) {
            reentrantLock.unlock();
            throw th2;
        }
    }

    public final boolean vvv() {
        return false;
    }

    @Nullable
    public Object z() {
        ReentrantLock reentrantLock = this.f6188uk;
        reentrantLock.lock();
        try {
            if (this.f6187i == qw.qw) {
                Object i2 = i();
                if (i2 == null) {
                    i2 = qw.f6193fe;
                }
                return i2;
            }
            Object obj = this.f6187i;
            this.f6187i = qw.qw;
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
            return obj;
        } finally {
            reentrantLock.unlock();
        }
    }
}
