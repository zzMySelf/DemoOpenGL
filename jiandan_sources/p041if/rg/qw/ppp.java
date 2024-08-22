package p041if.rg.qw;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import p041if.de;
import p041if.qw;
import p041if.rg.fe.i.e;
import p041if.rg.fe.i.vvv;
import p041if.rg.fe.th;
import rx.Observable;
import rx.Producer;
import rx.exceptions.MissingBackpressureException;
import rx.functions.Action0;
import rx.internal.operators.NotificationLite;

/* renamed from: if.rg.qw.ppp  reason: invalid package */
public final class ppp<T> implements Observable.Operator<T, T> {

    /* renamed from: ad  reason: collision with root package name */
    public final p041if.qw f11315ad;

    /* renamed from: th  reason: collision with root package name */
    public final boolean f11316th;

    /* renamed from: yj  reason: collision with root package name */
    public final int f11317yj;

    /* renamed from: if.rg.qw.ppp$qw */
    public static final class qw<T> extends de<T> implements Action0 {

        /* renamed from: ad  reason: collision with root package name */
        public final de<? super T> f11318ad;

        /* renamed from: i  reason: collision with root package name */
        public final int f11319i;

        /* renamed from: if  reason: not valid java name */
        public final AtomicLong f537if = new AtomicLong();

        /* renamed from: o  reason: collision with root package name */
        public volatile boolean f11320o;

        /* renamed from: pf  reason: collision with root package name */
        public final AtomicLong f11321pf = new AtomicLong();

        /* renamed from: switch  reason: not valid java name */
        public Throwable f538switch;

        /* renamed from: th  reason: collision with root package name */
        public final qw.C0349qw f11322th;

        /* renamed from: uk  reason: collision with root package name */
        public final Queue<Object> f11323uk;
        public long when;

        /* renamed from: yj  reason: collision with root package name */
        public final boolean f11324yj;

        /* renamed from: if.rg.qw.ppp$qw$qw  reason: collision with other inner class name */
        public class C0359qw implements Producer {
            public C0359qw() {
            }

            public void request(long j) {
                if (j > 0) {
                    qw.ad(qw.this.f11321pf, j);
                    qw.this.rg();
                }
            }
        }

        public qw(p041if.qw qwVar, de<? super T> deVar, boolean z, int i2) {
            this.f11318ad = deVar;
            this.f11322th = qwVar.qw();
            this.f11324yj = z;
            i2 = i2 <= 0 ? th.f11231yj : i2;
            this.f11319i = i2 - (i2 >> 2);
            if (e.ad()) {
                this.f11323uk = new vvv(i2);
            } else {
                this.f11323uk = new p041if.rg.fe.uk.de(i2);
            }
            request((long) i2);
        }

        public void call() {
            int i2;
            long j = this.when;
            Queue<Object> queue = this.f11323uk;
            de<? super T> deVar = this.f11318ad;
            long j2 = 1;
            do {
                long j3 = this.f11321pf.get();
                while (true) {
                    i2 = (j3 > j ? 1 : (j3 == j ? 0 : -1));
                    if (i2 == 0) {
                        break;
                    }
                    boolean z = this.f11320o;
                    Object poll = queue.poll();
                    boolean z2 = poll == null;
                    if (!de(z, z2, deVar, queue)) {
                        if (z2) {
                            break;
                        }
                        deVar.onNext(NotificationLite.rg(poll));
                        j++;
                        if (j == ((long) this.f11319i)) {
                            j3 = qw.yj(this.f11321pf, j);
                            request(j);
                            j = 0;
                        }
                    } else {
                        return;
                    }
                }
                if (i2 != 0 || !de(this.f11320o, queue.isEmpty(), deVar, queue)) {
                    this.when = j;
                    j2 = this.f537if.addAndGet(-j2);
                } else {
                    return;
                }
            } while (j2 != 0);
        }

        public boolean de(boolean z, boolean z2, de<? super T> deVar, Queue<Object> queue) {
            if (deVar.isUnsubscribed()) {
                queue.clear();
                return true;
            } else if (!z) {
                return false;
            } else {
                if (!this.f11324yj) {
                    Throwable th2 = this.f538switch;
                    if (th2 != null) {
                        queue.clear();
                        try {
                            deVar.onError(th2);
                            return true;
                        } finally {
                            this.f11322th.unsubscribe();
                        }
                    } else if (!z2) {
                        return false;
                    } else {
                        try {
                            deVar.onCompleted();
                            return true;
                        } finally {
                            this.f11322th.unsubscribe();
                        }
                    }
                } else if (!z2) {
                    return false;
                } else {
                    Throwable th3 = this.f538switch;
                    if (th3 != null) {
                        try {
                            deVar.onError(th3);
                        } catch (Throwable th4) {
                            this.f11322th.unsubscribe();
                            throw th4;
                        }
                    } else {
                        deVar.onCompleted();
                    }
                    this.f11322th.unsubscribe();
                    return false;
                }
            }
        }

        public void fe() {
            de<? super T> deVar = this.f11318ad;
            deVar.setProducer(new C0359qw());
            deVar.add(this.f11322th);
            deVar.add(this);
        }

        public void onCompleted() {
            if (!isUnsubscribed() && !this.f11320o) {
                this.f11320o = true;
                rg();
            }
        }

        public void onError(Throwable th2) {
            if (isUnsubscribed() || this.f11320o) {
                p041if.uk.de.i(th2);
                return;
            }
            this.f538switch = th2;
            this.f11320o = true;
            rg();
        }

        public void onNext(T t) {
            if (!isUnsubscribed() && !this.f11320o) {
                if (!this.f11323uk.offer(NotificationLite.uk(t))) {
                    onError(new MissingBackpressureException());
                } else {
                    rg();
                }
            }
        }

        public void rg() {
            if (this.f537if.getAndIncrement() == 0) {
                this.f11322th.de(this);
            }
        }
    }

    public ppp(p041if.qw qwVar, boolean z, int i2) {
        this.f11315ad = qwVar;
        this.f11316th = z;
        this.f11317yj = i2 <= 0 ? th.f11231yj : i2;
    }

    /* renamed from: ad */
    public de<? super T> call(de<? super T> deVar) {
        p041if.qw qwVar = this.f11315ad;
        if (qwVar instanceof p041if.rg.de.th) {
            return deVar;
        }
        qw qwVar2 = new qw(qwVar, deVar, this.f11316th, this.f11317yj);
        qwVar2.fe();
        return qwVar2;
    }
}
