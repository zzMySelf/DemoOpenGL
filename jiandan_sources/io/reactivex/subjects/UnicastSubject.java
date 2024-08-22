package io.reactivex.subjects;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import th.de.p039if.rg.qw;
import th.de.rg;
import th.de.xxx.ad;

public final class UnicastSubject<T> extends ad<T> {

    /* renamed from: ad  reason: collision with root package name */
    public final qw<T> f10360ad;

    /* renamed from: i  reason: collision with root package name */
    public volatile boolean f10361i;

    /* renamed from: if  reason: not valid java name */
    public final AtomicBoolean f487if;

    /* renamed from: o  reason: collision with root package name */
    public volatile boolean f10362o;

    /* renamed from: pf  reason: collision with root package name */
    public Throwable f10363pf;

    /* renamed from: switch  reason: not valid java name */
    public final BasicIntQueueDisposable<T> f488switch;

    /* renamed from: th  reason: collision with root package name */
    public final AtomicReference<Observer<? super T>> f10364th;

    /* renamed from: uk  reason: collision with root package name */
    public final boolean f10365uk;
    public boolean when;

    /* renamed from: yj  reason: collision with root package name */
    public final AtomicReference<Runnable> f10366yj;

    public final class UnicastQueueDisposable extends BasicIntQueueDisposable<T> {
        public static final long serialVersionUID = 7926949470189395511L;

        public UnicastQueueDisposable() {
        }

        public void clear() {
            UnicastSubject.this.f10360ad.clear();
        }

        public void dispose() {
            if (!UnicastSubject.this.f10361i) {
                UnicastSubject.this.f10361i = true;
                UnicastSubject.this.uk();
                UnicastSubject.this.f10364th.lazySet((Object) null);
                if (UnicastSubject.this.f488switch.getAndIncrement() == 0) {
                    UnicastSubject.this.f10364th.lazySet((Object) null);
                    UnicastSubject.this.f10360ad.clear();
                }
            }
        }

        public boolean isDisposed() {
            return UnicastSubject.this.f10361i;
        }

        public boolean isEmpty() {
            return UnicastSubject.this.f10360ad.isEmpty();
        }

        public T poll() throws Exception {
            return UnicastSubject.this.f10360ad.poll();
        }

        public int requestFusion(int i2) {
            if ((i2 & 2) == 0) {
                return 0;
            }
            UnicastSubject.this.when = true;
            return 2;
        }
    }

    public UnicastSubject(int i2, boolean z) {
        th.de.p039if.ad.qw.th(i2, "capacityHint");
        this.f10360ad = new qw<>(i2);
        this.f10366yj = new AtomicReference<>();
        this.f10365uk = z;
        this.f10364th = new AtomicReference<>();
        this.f487if = new AtomicBoolean();
        this.f488switch = new UnicastQueueDisposable();
    }

    public static <T> UnicastSubject<T> fe() {
        return new UnicastSubject<>(rg.bufferSize(), true);
    }

    public static <T> UnicastSubject<T> rg(int i2) {
        return new UnicastSubject<>(i2, true);
    }

    public static <T> UnicastSubject<T> th(int i2, Runnable runnable) {
        return new UnicastSubject<>(i2, runnable, true);
    }

    public void i() {
        if (this.f488switch.getAndIncrement() == 0) {
            Observer observer = this.f10364th.get();
            int i2 = 1;
            while (observer == null) {
                i2 = this.f488switch.addAndGet(-i2);
                if (i2 != 0) {
                    observer = this.f10364th.get();
                } else {
                    return;
                }
            }
            if (this.when) {
                o(observer);
            } else {
                pf(observer);
            }
        }
    }

    /* renamed from: if  reason: not valid java name */
    public void m1145if(Observer<? super T> observer) {
        this.f10364th.lazySet((Object) null);
        Throwable th2 = this.f10363pf;
        if (th2 != null) {
            observer.onError(th2);
        } else {
            observer.onComplete();
        }
    }

    public void o(Observer<? super T> observer) {
        qw<T> qwVar = this.f10360ad;
        int i2 = 1;
        boolean z = !this.f10365uk;
        while (!this.f10361i) {
            boolean z2 = this.f10362o;
            if (!z || !z2 || !m1146switch(qwVar, observer)) {
                observer.onNext(null);
                if (z2) {
                    m1145if(observer);
                    return;
                }
                i2 = this.f488switch.addAndGet(-i2);
                if (i2 == 0) {
                    return;
                }
            } else {
                return;
            }
        }
        this.f10364th.lazySet((Object) null);
        qwVar.clear();
    }

    public void onComplete() {
        if (!this.f10362o && !this.f10361i) {
            this.f10362o = true;
            uk();
            i();
        }
    }

    public void onError(Throwable th2) {
        th.de.p039if.ad.qw.rg(th2, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f10362o || this.f10361i) {
            th.de.ppp.qw.ddd(th2);
            return;
        }
        this.f10363pf = th2;
        this.f10362o = true;
        uk();
        i();
    }

    public void onNext(T t) {
        th.de.p039if.ad.qw.rg(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!this.f10362o && !this.f10361i) {
            this.f10360ad.offer(t);
            i();
        }
    }

    public void onSubscribe(Disposable disposable) {
        if (this.f10362o || this.f10361i) {
            disposable.dispose();
        }
    }

    public void pf(Observer<? super T> observer) {
        qw<T> qwVar = this.f10360ad;
        boolean z = !this.f10365uk;
        boolean z2 = true;
        int i2 = 1;
        while (!this.f10361i) {
            boolean z3 = this.f10362o;
            T poll = this.f10360ad.poll();
            boolean z4 = poll == null;
            if (z3) {
                if (z && z2) {
                    if (!m1146switch(qwVar, observer)) {
                        z2 = false;
                    } else {
                        return;
                    }
                }
                if (z4) {
                    m1145if(observer);
                    return;
                }
            }
            if (z4) {
                i2 = this.f488switch.addAndGet(-i2);
                if (i2 == 0) {
                    return;
                }
            } else {
                observer.onNext(poll);
            }
        }
        this.f10364th.lazySet((Object) null);
        qwVar.clear();
    }

    public void subscribeActual(Observer<? super T> observer) {
        if (this.f487if.get() || !this.f487if.compareAndSet(false, true)) {
            EmptyDisposable.error((Throwable) new IllegalStateException("Only a single observer allowed."), (Observer<?>) observer);
            return;
        }
        observer.onSubscribe(this.f488switch);
        this.f10364th.lazySet(observer);
        if (this.f10361i) {
            this.f10364th.lazySet((Object) null);
        } else {
            i();
        }
    }

    /* renamed from: switch  reason: not valid java name */
    public boolean m1146switch(SimpleQueue<T> simpleQueue, Observer<? super T> observer) {
        Throwable th2 = this.f10363pf;
        if (th2 == null) {
            return false;
        }
        this.f10364th.lazySet((Object) null);
        simpleQueue.clear();
        observer.onError(th2);
        return true;
    }

    public void uk() {
        Runnable runnable = this.f10366yj.get();
        if (runnable != null && this.f10366yj.compareAndSet(runnable, (Object) null)) {
            runnable.run();
        }
    }

    public UnicastSubject(int i2, Runnable runnable, boolean z) {
        th.de.p039if.ad.qw.th(i2, "capacityHint");
        this.f10360ad = new qw<>(i2);
        th.de.p039if.ad.qw.rg(runnable, "onTerminate");
        this.f10366yj = new AtomicReference<>(runnable);
        this.f10365uk = z;
        this.f10364th = new AtomicReference<>();
        this.f487if = new AtomicBoolean();
        this.f488switch = new UnicastQueueDisposable();
    }
}
