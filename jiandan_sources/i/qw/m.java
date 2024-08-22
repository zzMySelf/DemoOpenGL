package i.qw;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import kotlin.coroutines.CoroutineContext;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.DisposableHandle;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class m extends a0 implements Runnable {
    @Nullable
    public static volatile Thread _thread;
    public static volatile int debugStatus;
    @NotNull

    /* renamed from: o  reason: collision with root package name */
    public static final m f6142o;

    /* renamed from: pf  reason: collision with root package name */
    public static final long f6143pf;

    static {
        Long l;
        m mVar = new m();
        f6142o = mVar;
        z.a(mVar, false, 1, (Object) null);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000);
        } catch (SecurityException unused) {
            l = 1000L;
        }
        f6143pf = timeUnit.toNanos(l.longValue());
    }

    public final synchronized void A() {
        if (C()) {
            debugStatus = 3;
            u();
            notifyAll();
        }
    }

    public final synchronized Thread B() {
        Thread thread;
        thread = _thread;
        if (thread == null) {
            thread = new Thread(this, "kotlinx.coroutines.DefaultExecutor");
            _thread = thread;
            thread.setDaemon(true);
            thread.start();
        }
        return thread;
    }

    public final boolean C() {
        int i2 = debugStatus;
        return i2 == 2 || i2 == 3;
    }

    public final synchronized boolean D() {
        if (C()) {
            return false;
        }
        debugStatus = 1;
        notifyAll();
        return true;
    }

    @NotNull
    public Thread j() {
        Thread thread = _thread;
        return thread == null ? B() : thread;
    }

    public void run() {
        l1.qw.fe(this);
        fe qw = rg.qw();
        if (qw != null) {
            qw.de();
        }
        try {
            if (D()) {
                long j = Long.MAX_VALUE;
                while (true) {
                    Thread.interrupted();
                    long d = d();
                    if (d == Long.MAX_VALUE) {
                        fe qw2 = rg.qw();
                        long nanoTime = qw2 == null ? System.nanoTime() : qw2.qw();
                        if (j == Long.MAX_VALUE) {
                            j = f6143pf + nanoTime;
                        }
                        long j2 = j - nanoTime;
                        if (j2 <= 0) {
                            _thread = null;
                            A();
                            fe qw3 = rg.qw();
                            if (qw3 != null) {
                                qw3.yj();
                            }
                            if (!s()) {
                                j();
                                return;
                            }
                            return;
                        }
                        d = RangesKt___RangesKt.coerceAtMost(d, j2);
                    } else {
                        j = Long.MAX_VALUE;
                    }
                    if (d > 0) {
                        if (C()) {
                            _thread = null;
                            A();
                            fe qw4 = rg.qw();
                            if (qw4 != null) {
                                qw4.yj();
                            }
                            if (!s()) {
                                j();
                                return;
                            }
                            return;
                        }
                        fe qw5 = rg.qw();
                        if (qw5 == null) {
                            LockSupport.parkNanos(this, d);
                        } else {
                            qw5.ad(this, d);
                        }
                    }
                }
            }
        } finally {
            _thread = null;
            A();
            fe qw6 = rg.qw();
            if (qw6 != null) {
                qw6.yj();
            }
            if (!s()) {
                j();
            }
        }
    }

    @NotNull
    public DisposableHandle uk(long j, @NotNull Runnable runnable, @NotNull CoroutineContext coroutineContext) {
        return x(j, runnable);
    }
}
