package th.de.p039if.fe.rg;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.subjects.UnicastSubject;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import th.de.p039if.de.i;
import th.de.rg;
import th.de.th;
import th.de.when.fe;

/* renamed from: th.de.if.fe.rg.y0  reason: invalid package */
public final class y0<T> extends qw<T, rg<T>> {

    /* renamed from: i  reason: collision with root package name */
    public final th f10874i;

    /* renamed from: if  reason: not valid java name */
    public final boolean f509if;

    /* renamed from: o  reason: collision with root package name */
    public final long f10875o;

    /* renamed from: pf  reason: collision with root package name */
    public final int f10876pf;

    /* renamed from: th  reason: collision with root package name */
    public final long f10877th;

    /* renamed from: uk  reason: collision with root package name */
    public final TimeUnit f10878uk;

    /* renamed from: yj  reason: collision with root package name */
    public final long f10879yj;

    /* renamed from: th.de.if.fe.rg.y0$ad */
    public static final class ad<T> extends i<T, Object, rg<T>> implements Observer<T>, Disposable, Runnable {
        public static final Object ddd = new Object();
        public UnicastSubject<T> ggg;

        /* renamed from: if  reason: not valid java name */
        public final TimeUnit f510if;

        /* renamed from: pf  reason: collision with root package name */
        public final long f10880pf;
        public Disposable ppp;

        /* renamed from: switch  reason: not valid java name */
        public final th f511switch;
        public final AtomicReference<Disposable> vvv = new AtomicReference<>();
        public final int when;
        public volatile boolean xxx;

        public ad(Observer<? super rg<T>> observer, long j, TimeUnit timeUnit, th thVar, int i2) {
            super(observer, new MpscLinkedQueue());
            this.f10880pf = j;
            this.f510if = timeUnit;
            this.f511switch = thVar;
            this.when = i2;
        }

        public void dispose() {
            this.f10472uk = true;
        }

        public boolean isDisposed() {
            return this.f10472uk;
        }

        public void o() {
            DisposableHelper.dispose(this.vvv);
        }

        public void onComplete() {
            this.f10469i = true;
            if (th()) {
                pf();
            }
            o();
            this.f10471th.onComplete();
        }

        public void onError(Throwable th2) {
            this.f10470o = th2;
            this.f10469i = true;
            if (th()) {
                pf();
            }
            o();
            this.f10471th.onError(th2);
        }

        public void onNext(T t) {
            if (!this.xxx) {
                if (yj()) {
                    this.ggg.onNext(t);
                    if (de(-1) == 0) {
                        return;
                    }
                } else {
                    this.f10473yj.offer(NotificationLite.next(t));
                    if (!th()) {
                        return;
                    }
                }
                pf();
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.ppp, disposable)) {
                this.ppp = disposable;
                this.ggg = UnicastSubject.rg(this.when);
                Observer<? super V> observer = this.f10471th;
                observer.onSubscribe(this);
                observer.onNext(this.ggg);
                if (!this.f10472uk) {
                    th thVar = this.f511switch;
                    long j = this.f10880pf;
                    DisposableHelper.replace(this.vvv, thVar.rg(this, j, j, this.f510if));
                }
            }
        }

        public void pf() {
            MpscLinkedQueue mpscLinkedQueue = (MpscLinkedQueue) this.f10473yj;
            Observer<? super V> observer = this.f10471th;
            UnicastSubject<T> unicastSubject = this.ggg;
            int i2 = 1;
            while (true) {
                boolean z = this.xxx;
                boolean z2 = this.f10469i;
                Object poll = mpscLinkedQueue.poll();
                if (!z2 || !(poll == null || poll == ddd)) {
                    if (poll == null) {
                        i2 = de(-i2);
                        if (i2 == 0) {
                            return;
                        }
                    } else if (poll == ddd) {
                        unicastSubject.onComplete();
                        if (!z) {
                            unicastSubject = UnicastSubject.rg(this.when);
                            this.ggg = unicastSubject;
                            observer.onNext(unicastSubject);
                        } else {
                            this.ppp.dispose();
                        }
                    } else {
                        unicastSubject.onNext(NotificationLite.getValue(poll));
                    }
                }
            }
            this.ggg = null;
            mpscLinkedQueue.clear();
            o();
            Throwable th2 = this.f10470o;
            if (th2 != null) {
                unicastSubject.onError(th2);
            } else {
                unicastSubject.onComplete();
            }
        }

        public void run() {
            if (this.f10472uk) {
                this.xxx = true;
                o();
            }
            this.f10473yj.offer(ddd);
            if (th()) {
                pf();
            }
        }
    }

    /* renamed from: th.de.if.fe.rg.y0$de */
    public static final class de<T> extends i<T, Object, rg<T>> implements Disposable, Runnable {
        public final List<UnicastSubject<T>> ggg = new LinkedList();

        /* renamed from: if  reason: not valid java name */
        public final long f512if;

        /* renamed from: pf  reason: collision with root package name */
        public final long f10881pf;
        public final int ppp;

        /* renamed from: switch  reason: not valid java name */
        public final TimeUnit f513switch;
        public Disposable vvv;
        public final th.de when;
        public volatile boolean xxx;

        /* renamed from: th.de.if.fe.rg.y0$de$ad */
        public static final class ad<T> {

            /* renamed from: ad  reason: collision with root package name */
            public final boolean f10882ad;
            public final UnicastSubject<T> qw;

            public ad(UnicastSubject<T> unicastSubject, boolean z) {
                this.qw = unicastSubject;
                this.f10882ad = z;
            }
        }

        /* renamed from: th.de.if.fe.rg.y0$de$qw */
        public final class qw implements Runnable {

            /* renamed from: ad  reason: collision with root package name */
            public final UnicastSubject<T> f10883ad;

            public qw(UnicastSubject<T> unicastSubject) {
                this.f10883ad = unicastSubject;
            }

            public void run() {
                de.this.o(this.f10883ad);
            }
        }

        public de(Observer<? super rg<T>> observer, long j, long j2, TimeUnit timeUnit, th.de deVar, int i2) {
            super(observer, new MpscLinkedQueue());
            this.f10881pf = j;
            this.f512if = j2;
            this.f513switch = timeUnit;
            this.when = deVar;
            this.ppp = i2;
        }

        public void dispose() {
            this.f10472uk = true;
        }

        /* renamed from: if  reason: not valid java name */
        public void m2352if() {
            MpscLinkedQueue mpscLinkedQueue = (MpscLinkedQueue) this.f10473yj;
            Observer<? super V> observer = this.f10471th;
            List<UnicastSubject<T>> list = this.ggg;
            int i2 = 1;
            while (!this.xxx) {
                boolean z = this.f10469i;
                Object poll = mpscLinkedQueue.poll();
                boolean z2 = poll == null;
                boolean z3 = poll instanceof ad;
                if (z && (z2 || z3)) {
                    mpscLinkedQueue.clear();
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
                    pf();
                    list.clear();
                    return;
                } else if (z2) {
                    i2 = de(-i2);
                    if (i2 == 0) {
                        return;
                    }
                } else if (z3) {
                    ad adVar = (ad) poll;
                    if (!adVar.f10882ad) {
                        list.remove(adVar.qw);
                        adVar.qw.onComplete();
                        if (list.isEmpty() && this.f10472uk) {
                            this.xxx = true;
                        }
                    } else if (!this.f10472uk) {
                        UnicastSubject rg2 = UnicastSubject.rg(this.ppp);
                        list.add(rg2);
                        observer.onNext(rg2);
                        this.when.de(new qw(rg2), this.f10881pf, this.f513switch);
                    }
                } else {
                    for (UnicastSubject<T> onNext : list) {
                        onNext.onNext(poll);
                    }
                }
            }
            this.vvv.dispose();
            pf();
            mpscLinkedQueue.clear();
            list.clear();
        }

        public boolean isDisposed() {
            return this.f10472uk;
        }

        public void o(UnicastSubject<T> unicastSubject) {
            this.f10473yj.offer(new ad(unicastSubject, false));
            if (th()) {
                m2352if();
            }
        }

        public void onComplete() {
            this.f10469i = true;
            if (th()) {
                m2352if();
            }
            this.f10471th.onComplete();
            pf();
        }

        public void onError(Throwable th2) {
            this.f10470o = th2;
            this.f10469i = true;
            if (th()) {
                m2352if();
            }
            this.f10471th.onError(th2);
            pf();
        }

        public void onNext(T t) {
            if (yj()) {
                for (UnicastSubject<T> onNext : this.ggg) {
                    onNext.onNext(t);
                }
                if (de(-1) == 0) {
                    return;
                }
            } else {
                this.f10473yj.offer(t);
                if (!th()) {
                    return;
                }
            }
            m2352if();
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.vvv, disposable)) {
                this.vvv = disposable;
                this.f10471th.onSubscribe(this);
                if (!this.f10472uk) {
                    UnicastSubject rg2 = UnicastSubject.rg(this.ppp);
                    this.ggg.add(rg2);
                    this.f10471th.onNext(rg2);
                    this.when.de(new qw(rg2), this.f10881pf, this.f513switch);
                    th.de deVar = this.when;
                    long j = this.f512if;
                    deVar.fe(this, j, j, this.f513switch);
                }
            }
        }

        public void pf() {
            this.when.dispose();
        }

        public void run() {
            ad adVar = new ad(UnicastSubject.rg(this.ppp), true);
            if (!this.f10472uk) {
                this.f10473yj.offer(adVar);
            }
            if (th()) {
                m2352if();
            }
        }
    }

    /* renamed from: th.de.if.fe.rg.y0$qw */
    public static final class qw<T> extends i<T, Object, rg<T>> implements Disposable {
        public volatile boolean aaa;
        public long ddd;
        public final long ggg;

        /* renamed from: if  reason: not valid java name */
        public final TimeUnit f514if;
        public UnicastSubject<T> mmm;
        public Disposable nn;

        /* renamed from: pf  reason: collision with root package name */
        public final long f10885pf;
        public final boolean ppp;
        public final AtomicReference<Disposable> qqq = new AtomicReference<>();

        /* renamed from: switch  reason: not valid java name */
        public final th f515switch;
        public final th.de vvv;
        public final int when;
        public long xxx;

        /* renamed from: th.de.if.fe.rg.y0$qw$qw  reason: collision with other inner class name */
        public static final class C0340qw implements Runnable {

            /* renamed from: ad  reason: collision with root package name */
            public final long f10886ad;

            /* renamed from: th  reason: collision with root package name */
            public final qw<?> f10887th;

            public C0340qw(long j, qw<?> qwVar) {
                this.f10886ad = j;
                this.f10887th = qwVar;
            }

            public void run() {
                qw<?> qwVar = this.f10887th;
                if (!qwVar.f10472uk) {
                    qwVar.f10473yj.offer(this);
                } else {
                    qwVar.aaa = true;
                    qwVar.m2353if();
                }
                if (qwVar.th()) {
                    qwVar.m2354switch();
                }
            }
        }

        public qw(Observer<? super rg<T>> observer, long j, TimeUnit timeUnit, th thVar, int i2, long j2, boolean z) {
            super(observer, new MpscLinkedQueue());
            this.f10885pf = j;
            this.f514if = timeUnit;
            this.f515switch = thVar;
            this.when = i2;
            this.ggg = j2;
            this.ppp = z;
            if (z) {
                this.vvv = thVar.qw();
            } else {
                this.vvv = null;
            }
        }

        public void dispose() {
            this.f10472uk = true;
        }

        /* renamed from: if  reason: not valid java name */
        public void m2353if() {
            DisposableHelper.dispose(this.qqq);
            th.de deVar = this.vvv;
            if (deVar != null) {
                deVar.dispose();
            }
        }

        public boolean isDisposed() {
            return this.f10472uk;
        }

        public void onComplete() {
            this.f10469i = true;
            if (th()) {
                m2354switch();
            }
            this.f10471th.onComplete();
            m2353if();
        }

        public void onError(Throwable th2) {
            this.f10470o = th2;
            this.f10469i = true;
            if (th()) {
                m2354switch();
            }
            this.f10471th.onError(th2);
            m2353if();
        }

        public void onNext(T t) {
            if (!this.aaa) {
                if (yj()) {
                    UnicastSubject<T> unicastSubject = this.mmm;
                    unicastSubject.onNext(t);
                    long j = this.xxx + 1;
                    if (j >= this.ggg) {
                        this.ddd++;
                        this.xxx = 0;
                        unicastSubject.onComplete();
                        UnicastSubject<T> rg2 = UnicastSubject.rg(this.when);
                        this.mmm = rg2;
                        this.f10471th.onNext(rg2);
                        if (this.ppp) {
                            this.qqq.get().dispose();
                            th.de deVar = this.vvv;
                            C0340qw qwVar = new C0340qw(this.ddd, this);
                            long j2 = this.f10885pf;
                            DisposableHelper.replace(this.qqq, deVar.fe(qwVar, j2, j2, this.f514if));
                        }
                    } else {
                        this.xxx = j;
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
                m2354switch();
            }
        }

        public void onSubscribe(Disposable disposable) {
            Disposable disposable2;
            if (DisposableHelper.validate(this.nn, disposable)) {
                this.nn = disposable;
                Observer<? super V> observer = this.f10471th;
                observer.onSubscribe(this);
                if (!this.f10472uk) {
                    UnicastSubject<T> rg2 = UnicastSubject.rg(this.when);
                    this.mmm = rg2;
                    observer.onNext(rg2);
                    C0340qw qwVar = new C0340qw(this.ddd, this);
                    if (this.ppp) {
                        th.de deVar = this.vvv;
                        long j = this.f10885pf;
                        disposable2 = deVar.fe(qwVar, j, j, this.f514if);
                    } else {
                        th thVar = this.f515switch;
                        long j2 = this.f10885pf;
                        disposable2 = thVar.rg(qwVar, j2, j2, this.f514if);
                    }
                    DisposableHelper.replace(this.qqq, disposable2);
                }
            }
        }

        /* renamed from: switch  reason: not valid java name */
        public void m2354switch() {
            MpscLinkedQueue mpscLinkedQueue = (MpscLinkedQueue) this.f10473yj;
            Observer<? super V> observer = this.f10471th;
            UnicastSubject<T> unicastSubject = this.mmm;
            int i2 = 1;
            while (!this.aaa) {
                boolean z = this.f10469i;
                Object poll = mpscLinkedQueue.poll();
                boolean z2 = poll == null;
                boolean z3 = poll instanceof C0340qw;
                if (z && (z2 || z3)) {
                    this.mmm = null;
                    mpscLinkedQueue.clear();
                    m2353if();
                    Throwable th2 = this.f10470o;
                    if (th2 != null) {
                        unicastSubject.onError(th2);
                        return;
                    } else {
                        unicastSubject.onComplete();
                        return;
                    }
                } else if (z2) {
                    i2 = de(-i2);
                    if (i2 == 0) {
                        return;
                    }
                } else if (z3) {
                    C0340qw qwVar = (C0340qw) poll;
                    if (this.ppp || this.ddd == qwVar.f10886ad) {
                        unicastSubject.onComplete();
                        this.xxx = 0;
                        unicastSubject = UnicastSubject.rg(this.when);
                        this.mmm = unicastSubject;
                        observer.onNext(unicastSubject);
                    }
                } else {
                    unicastSubject.onNext(NotificationLite.getValue(poll));
                    long j = this.xxx + 1;
                    if (j >= this.ggg) {
                        this.ddd++;
                        this.xxx = 0;
                        unicastSubject.onComplete();
                        unicastSubject = UnicastSubject.rg(this.when);
                        this.mmm = unicastSubject;
                        this.f10471th.onNext(unicastSubject);
                        if (this.ppp) {
                            Disposable disposable = this.qqq.get();
                            disposable.dispose();
                            th.de deVar = this.vvv;
                            C0340qw qwVar2 = new C0340qw(this.ddd, this);
                            long j2 = this.f10885pf;
                            Disposable fe2 = deVar.fe(qwVar2, j2, j2, this.f514if);
                            if (!this.qqq.compareAndSet(disposable, fe2)) {
                                fe2.dispose();
                            }
                        }
                    } else {
                        this.xxx = j;
                    }
                }
            }
            this.nn.dispose();
            mpscLinkedQueue.clear();
            m2353if();
        }
    }

    public y0(ObservableSource<T> observableSource, long j, long j2, TimeUnit timeUnit, th thVar, long j3, int i2, boolean z) {
        super(observableSource);
        this.f10877th = j;
        this.f10879yj = j2;
        this.f10878uk = timeUnit;
        this.f10874i = thVar;
        this.f10875o = j3;
        this.f10876pf = i2;
        this.f509if = z;
    }

    public void subscribeActual(Observer<? super rg<T>> observer) {
        fe feVar = new fe(observer);
        long j = this.f10877th;
        long j2 = this.f10879yj;
        if (j == j2) {
            long j3 = this.f10875o;
            if (j3 == Long.MAX_VALUE) {
                this.f10756ad.subscribe(new ad(feVar, this.f10877th, this.f10878uk, this.f10874i, this.f10876pf));
            } else {
                this.f10756ad.subscribe(new qw(feVar, j, this.f10878uk, this.f10874i, this.f10876pf, j3, this.f509if));
            }
        } else {
            this.f10756ad.subscribe(new de(feVar, j, j2, this.f10878uk, this.f10874i.qw(), this.f10876pf));
        }
    }
}
