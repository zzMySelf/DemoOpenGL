package th.de.p039if.fe.rg;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.subjects.UnicastSubject;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import th.de.p039if.de.i;
import th.de.rg;

/* renamed from: th.de.if.fe.rg.x0  reason: invalid package */
public final class x0<T, B, V> extends qw<T, rg<T>> {

    /* renamed from: th  reason: collision with root package name */
    public final ObservableSource<B> f10862th;

    /* renamed from: uk  reason: collision with root package name */
    public final int f10863uk;

    /* renamed from: yj  reason: collision with root package name */
    public final Function<? super B, ? extends ObservableSource<V>> f10864yj;

    /* renamed from: th.de.if.fe.rg.x0$ad */
    public static final class ad<T, B> extends th.de.when.ad<B> {

        /* renamed from: th  reason: collision with root package name */
        public final de<T, B, ?> f10865th;

        public ad(de<T, B, ?> deVar) {
            this.f10865th = deVar;
        }

        public void onComplete() {
            this.f10865th.onComplete();
        }

        public void onError(Throwable th2) {
            this.f10865th.m2351switch(th2);
        }

        public void onNext(B b) {
            this.f10865th.when(b);
        }
    }

    /* renamed from: th.de.if.fe.rg.x0$de */
    public static final class de<T, B, V> extends i<T, Object, rg<T>> implements Disposable {
        public final AtomicBoolean ddd = new AtomicBoolean();
        public final AtomicReference<Disposable> ggg = new AtomicReference<>();

        /* renamed from: if  reason: not valid java name */
        public final Function<? super B, ? extends ObservableSource<V>> f507if;

        /* renamed from: pf  reason: collision with root package name */
        public final ObservableSource<B> f10866pf;
        public Disposable ppp;

        /* renamed from: switch  reason: not valid java name */
        public final int f508switch;
        public final List<UnicastSubject<T>> vvv;
        public final th.de.i.qw when;
        public final AtomicLong xxx = new AtomicLong();

        public de(Observer<? super rg<T>> observer, ObservableSource<B> observableSource, Function<? super B, ? extends ObservableSource<V>> function, int i2) {
            super(observer, new MpscLinkedQueue());
            this.f10866pf = observableSource;
            this.f507if = function;
            this.f508switch = i2;
            this.when = new th.de.i.qw();
            this.vvv = new ArrayList();
            this.xxx.lazySet(1);
        }

        public void dispose() {
            if (this.ddd.compareAndSet(false, true)) {
                DisposableHelper.dispose(this.ggg);
                if (this.xxx.decrementAndGet() == 0) {
                    this.ppp.dispose();
                }
            }
        }

        /* renamed from: if  reason: not valid java name */
        public void m2350if() {
            MpscLinkedQueue mpscLinkedQueue = (MpscLinkedQueue) this.f10473yj;
            Observer<? super V> observer = this.f10471th;
            List<UnicastSubject<T>> list = this.vvv;
            int i2 = 1;
            while (true) {
                boolean z = this.f10469i;
                Object poll = mpscLinkedQueue.poll();
                boolean z2 = poll == null;
                if (z && z2) {
                    pf();
                    Throwable th2 = this.f10470o;
                    if (th2 != null) {
                        for (UnicastSubject<T> onError : list) {
                            onError.onError(th2);
                        }
                    } else {
                        for (UnicastSubject<T> onComplete : list) {
                            onComplete.onComplete();
                        }
                    }
                    list.clear();
                    return;
                } else if (z2) {
                    i2 = de(-i2);
                    if (i2 == 0) {
                        return;
                    }
                } else if (poll instanceof fe) {
                    fe feVar = (fe) poll;
                    UnicastSubject<T> unicastSubject = feVar.qw;
                    if (unicastSubject != null) {
                        if (list.remove(unicastSubject)) {
                            feVar.qw.onComplete();
                            if (this.xxx.decrementAndGet() == 0) {
                                pf();
                                return;
                            }
                        } else {
                            continue;
                        }
                    } else if (!this.ddd.get()) {
                        UnicastSubject rg2 = UnicastSubject.rg(this.f508switch);
                        list.add(rg2);
                        observer.onNext(rg2);
                        try {
                            Object apply = this.f507if.apply(feVar.f10867ad);
                            th.de.p039if.ad.qw.rg(apply, "The ObservableSource supplied is null");
                            ObservableSource observableSource = (ObservableSource) apply;
                            qw qwVar = new qw(this, rg2);
                            if (this.when.ad(qwVar)) {
                                this.xxx.getAndIncrement();
                                observableSource.subscribe(qwVar);
                            }
                        } catch (Throwable th3) {
                            th.de.o.qw.ad(th3);
                            this.ddd.set(true);
                            observer.onError(th3);
                        }
                    }
                } else {
                    for (UnicastSubject<T> onNext : list) {
                        onNext.onNext(NotificationLite.getValue(poll));
                    }
                }
            }
        }

        public boolean isDisposed() {
            return this.ddd.get();
        }

        public void o(qw<T, V> qwVar) {
            this.when.de(qwVar);
            this.f10473yj.offer(new fe(qwVar.f10870yj, null));
            if (th()) {
                m2350if();
            }
        }

        public void onComplete() {
            if (!this.f10469i) {
                this.f10469i = true;
                if (th()) {
                    m2350if();
                }
                if (this.xxx.decrementAndGet() == 0) {
                    this.when.dispose();
                }
                this.f10471th.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (this.f10469i) {
                th.de.ppp.qw.ddd(th2);
                return;
            }
            this.f10470o = th2;
            this.f10469i = true;
            if (th()) {
                m2350if();
            }
            if (this.xxx.decrementAndGet() == 0) {
                this.when.dispose();
            }
            this.f10471th.onError(th2);
        }

        public void onNext(T t) {
            if (yj()) {
                for (UnicastSubject<T> onNext : this.vvv) {
                    onNext.onNext(t);
                }
                if (de(-1) == 0) {
                    return;
                }
            } else {
                this.f10473yj.offer(NotificationLite.next(t));
                if (!th()) {
                    return;
                }
            }
            m2350if();
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.ppp, disposable)) {
                this.ppp = disposable;
                this.f10471th.onSubscribe(this);
                if (!this.ddd.get()) {
                    ad adVar = new ad(this);
                    if (this.ggg.compareAndSet((Object) null, adVar)) {
                        this.f10866pf.subscribe(adVar);
                    }
                }
            }
        }

        public void pf() {
            this.when.dispose();
            DisposableHelper.dispose(this.ggg);
        }

        public void qw(Observer<? super rg<T>> observer, Object obj) {
        }

        /* renamed from: switch  reason: not valid java name */
        public void m2351switch(Throwable th2) {
            this.ppp.dispose();
            this.when.dispose();
            onError(th2);
        }

        public void when(B b) {
            this.f10473yj.offer(new fe((UnicastSubject) null, b));
            if (th()) {
                m2350if();
            }
        }
    }

    /* renamed from: th.de.if.fe.rg.x0$fe */
    public static final class fe<T, B> {

        /* renamed from: ad  reason: collision with root package name */
        public final B f10867ad;
        public final UnicastSubject<T> qw;

        public fe(UnicastSubject<T> unicastSubject, B b) {
            this.qw = unicastSubject;
            this.f10867ad = b;
        }
    }

    /* renamed from: th.de.if.fe.rg.x0$qw */
    public static final class qw<T, V> extends th.de.when.ad<V> {

        /* renamed from: th  reason: collision with root package name */
        public final de<T, ?, V> f10868th;

        /* renamed from: uk  reason: collision with root package name */
        public boolean f10869uk;

        /* renamed from: yj  reason: collision with root package name */
        public final UnicastSubject<T> f10870yj;

        public qw(de<T, ?, V> deVar, UnicastSubject<T> unicastSubject) {
            this.f10868th = deVar;
            this.f10870yj = unicastSubject;
        }

        public void onComplete() {
            if (!this.f10869uk) {
                this.f10869uk = true;
                this.f10868th.o(this);
            }
        }

        public void onError(Throwable th2) {
            if (this.f10869uk) {
                th.de.ppp.qw.ddd(th2);
                return;
            }
            this.f10869uk = true;
            this.f10868th.m2351switch(th2);
        }

        public void onNext(V v) {
            dispose();
            onComplete();
        }
    }

    public x0(ObservableSource<T> observableSource, ObservableSource<B> observableSource2, Function<? super B, ? extends ObservableSource<V>> function, int i2) {
        super(observableSource);
        this.f10862th = observableSource2;
        this.f10864yj = function;
        this.f10863uk = i2;
    }

    public void subscribeActual(Observer<? super rg<T>> observer) {
        this.f10756ad.subscribe(new de(new th.de.when.fe(observer), this.f10862th, this.f10864yj, this.f10863uk));
    }
}
