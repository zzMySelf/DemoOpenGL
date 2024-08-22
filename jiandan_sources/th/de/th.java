package th.de;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.schedulers.SchedulerRunnableIntrospection;
import java.util.concurrent.TimeUnit;
import th.de.p039if.th.rg;

public abstract class th {

    /* renamed from: ad  reason: collision with root package name */
    public static final long f11006ad = TimeUnit.MINUTES.toNanos(Long.getLong("rx2.scheduler.drift-tolerance", 15).longValue());

    public static final class ad implements Disposable, Runnable, SchedulerRunnableIntrospection {

        /* renamed from: ad  reason: collision with root package name */
        public final Runnable f11007ad;

        /* renamed from: th  reason: collision with root package name */
        public final de f11008th;

        /* renamed from: yj  reason: collision with root package name */
        public volatile boolean f11009yj;

        public ad(Runnable runnable, de deVar) {
            this.f11007ad = runnable;
            this.f11008th = deVar;
        }

        public void dispose() {
            this.f11009yj = true;
            this.f11008th.dispose();
        }

        public boolean isDisposed() {
            return this.f11009yj;
        }

        public void run() {
            if (!this.f11009yj) {
                try {
                    this.f11007ad.run();
                } catch (Throwable th2) {
                    th.de.o.qw.ad(th2);
                    this.f11008th.dispose();
                    throw ExceptionHelper.fe(th2);
                }
            }
        }
    }

    public static abstract class de implements Disposable {

        public final class qw implements Runnable, SchedulerRunnableIntrospection {

            /* renamed from: ad  reason: collision with root package name */
            public final Runnable f11010ad;

            /* renamed from: i  reason: collision with root package name */
            public long f11011i;

            /* renamed from: o  reason: collision with root package name */
            public long f11012o;

            /* renamed from: th  reason: collision with root package name */
            public final SequentialDisposable f11014th;

            /* renamed from: uk  reason: collision with root package name */
            public long f11015uk;

            /* renamed from: yj  reason: collision with root package name */
            public final long f11016yj;

            public qw(long j, Runnable runnable, long j2, SequentialDisposable sequentialDisposable, long j3) {
                this.f11010ad = runnable;
                this.f11014th = sequentialDisposable;
                this.f11016yj = j3;
                this.f11011i = j2;
                this.f11012o = j;
            }

            public void run() {
                long j;
                this.f11010ad.run();
                if (!this.f11014th.isDisposed()) {
                    long qw = de.this.qw(TimeUnit.NANOSECONDS);
                    long j2 = th.f11006ad;
                    long j3 = this.f11011i;
                    if (qw + j2 >= j3) {
                        long j4 = this.f11016yj;
                        if (qw < j3 + j4 + j2) {
                            long j5 = this.f11012o;
                            long j6 = this.f11015uk + 1;
                            this.f11015uk = j6;
                            j = j5 + (j6 * j4);
                            this.f11011i = qw;
                            this.f11014th.replace(de.this.de(this, j - qw, TimeUnit.NANOSECONDS));
                        }
                    }
                    long j7 = this.f11016yj;
                    long j8 = qw + j7;
                    long j9 = this.f11015uk + 1;
                    this.f11015uk = j9;
                    this.f11012o = j8 - (j7 * j9);
                    j = j8;
                    this.f11011i = qw;
                    this.f11014th.replace(de.this.de(this, j - qw, TimeUnit.NANOSECONDS));
                }
            }
        }

        public Disposable ad(Runnable runnable) {
            return de(runnable, 0, TimeUnit.NANOSECONDS);
        }

        public abstract Disposable de(Runnable runnable, long j, TimeUnit timeUnit);

        public Disposable fe(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
            long j3 = j;
            TimeUnit timeUnit2 = timeUnit;
            SequentialDisposable sequentialDisposable = new SequentialDisposable();
            SequentialDisposable sequentialDisposable2 = new SequentialDisposable(sequentialDisposable);
            Runnable mmm = th.de.ppp.qw.mmm(runnable);
            long nanos = timeUnit2.toNanos(j2);
            long qw2 = qw(TimeUnit.NANOSECONDS);
            SequentialDisposable sequentialDisposable3 = sequentialDisposable;
            qw qwVar = r0;
            qw qwVar2 = new qw(qw2 + timeUnit2.toNanos(j3), mmm, qw2, sequentialDisposable2, nanos);
            Disposable de2 = de(qwVar, j3, timeUnit2);
            if (de2 == EmptyDisposable.INSTANCE) {
                return de2;
            }
            sequentialDisposable3.replace(de2);
            return sequentialDisposable2;
        }

        public long qw(TimeUnit timeUnit) {
            return timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }
    }

    public static final class qw implements Disposable, Runnable, SchedulerRunnableIntrospection {

        /* renamed from: ad  reason: collision with root package name */
        public final Runnable f11017ad;

        /* renamed from: th  reason: collision with root package name */
        public final de f11018th;

        /* renamed from: yj  reason: collision with root package name */
        public Thread f11019yj;

        public qw(Runnable runnable, de deVar) {
            this.f11017ad = runnable;
            this.f11018th = deVar;
        }

        public void dispose() {
            if (this.f11019yj == Thread.currentThread()) {
                de deVar = this.f11018th;
                if (deVar instanceof rg) {
                    ((rg) deVar).uk();
                    return;
                }
            }
            this.f11018th.dispose();
        }

        public boolean isDisposed() {
            return this.f11018th.isDisposed();
        }

        public void run() {
            this.f11019yj = Thread.currentThread();
            try {
                this.f11017ad.run();
            } finally {
                dispose();
                this.f11019yj = null;
            }
        }
    }

    public long ad(TimeUnit timeUnit) {
        return timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    public Disposable de(Runnable runnable) {
        return fe(runnable, 0, TimeUnit.NANOSECONDS);
    }

    public Disposable fe(Runnable runnable, long j, TimeUnit timeUnit) {
        de qw2 = qw();
        qw qwVar = new qw(th.de.ppp.qw.mmm(runnable), qw2);
        qw2.de(qwVar, j, timeUnit);
        return qwVar;
    }

    public abstract de qw();

    public Disposable rg(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        de qw2 = qw();
        ad adVar = new ad(th.de.ppp.qw.mmm(runnable), qw2);
        Disposable fe2 = qw2.fe(adVar, j, j2, timeUnit);
        return fe2 == EmptyDisposable.INSTANCE ? fe2 : adVar;
    }
}
