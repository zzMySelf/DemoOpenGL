package th.de.p039if.fe.rg;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.queue.MpscLinkedQueue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import th.de.p039if.de.i;
import th.de.p039if.yj.uk;
import th.de.th;
import th.de.when.fe;

/* renamed from: th.de.if.fe.rg.if  reason: invalid class name and invalid package */
public final class Cif<T, U extends Collection<? super T>> extends qw<T, U> {

    /* renamed from: i  reason: collision with root package name */
    public final th f10643i;

    /* renamed from: if  reason: not valid java name */
    public final boolean f496if;

    /* renamed from: o  reason: collision with root package name */
    public final Callable<U> f10644o;

    /* renamed from: pf  reason: collision with root package name */
    public final int f10645pf;

    /* renamed from: th  reason: collision with root package name */
    public final long f10646th;

    /* renamed from: uk  reason: collision with root package name */
    public final TimeUnit f10647uk;

    /* renamed from: yj  reason: collision with root package name */
    public final long f10648yj;

    /* renamed from: th.de.if.fe.rg.if$ad */
    public static final class ad<T, U extends Collection<? super T>> extends i<T, U, U> implements Runnable, Disposable {
        public U ggg;

        /* renamed from: if  reason: not valid java name */
        public final long f497if;

        /* renamed from: pf  reason: collision with root package name */
        public final Callable<U> f10649pf;
        public Disposable ppp;

        /* renamed from: switch  reason: not valid java name */
        public final TimeUnit f498switch;
        public final AtomicReference<Disposable> vvv = new AtomicReference<>();
        public final th when;

        public ad(Observer<? super U> observer, Callable<U> callable, long j, TimeUnit timeUnit, th thVar) {
            super(observer, new MpscLinkedQueue());
            this.f10649pf = callable;
            this.f497if = j;
            this.f498switch = timeUnit;
            this.when = thVar;
        }

        public void dispose() {
            DisposableHelper.dispose(this.vvv);
            this.ppp.dispose();
        }

        public boolean isDisposed() {
            return this.vvv.get() == DisposableHelper.DISPOSED;
        }

        /* renamed from: o */
        public void qw(Observer<? super U> observer, U u) {
            this.f10471th.onNext(u);
        }

        public void onComplete() {
            U u;
            synchronized (this) {
                u = this.ggg;
                this.ggg = null;
            }
            if (u != null) {
                this.f10473yj.offer(u);
                this.f10469i = true;
                if (th()) {
                    uk.de(this.f10473yj, this.f10471th, false, (Disposable) null, this);
                }
            }
            DisposableHelper.dispose(this.vvv);
        }

        public void onError(Throwable th2) {
            synchronized (this) {
                this.ggg = null;
            }
            this.f10471th.onError(th2);
            DisposableHelper.dispose(this.vvv);
        }

        public void onNext(T t) {
            synchronized (this) {
                U u = this.ggg;
                if (u != null) {
                    u.add(t);
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.ppp, disposable)) {
                this.ppp = disposable;
                try {
                    U call = this.f10649pf.call();
                    th.de.p039if.ad.qw.rg(call, "The buffer supplied is null");
                    this.ggg = (Collection) call;
                    this.f10471th.onSubscribe(this);
                    if (!this.f10472uk) {
                        th thVar = this.when;
                        long j = this.f497if;
                        Disposable rg2 = thVar.rg(this, j, j, this.f498switch);
                        if (!this.vvv.compareAndSet((Object) null, rg2)) {
                            rg2.dispose();
                        }
                    }
                } catch (Throwable th2) {
                    th.de.o.qw.ad(th2);
                    dispose();
                    EmptyDisposable.error(th2, (Observer<?>) this.f10471th);
                }
            }
        }

        public void run() {
            U u;
            try {
                U call = this.f10649pf.call();
                th.de.p039if.ad.qw.rg(call, "The bufferSupplier returned a null buffer");
                U u2 = (Collection) call;
                synchronized (this) {
                    u = this.ggg;
                    if (u != null) {
                        this.ggg = u2;
                    }
                }
                if (u == null) {
                    DisposableHelper.dispose(this.vvv);
                } else {
                    uk(u, false, this);
                }
            } catch (Throwable th2) {
                th.de.o.qw.ad(th2);
                this.f10471th.onError(th2);
                dispose();
            }
        }
    }

    /* renamed from: th.de.if.fe.rg.if$de */
    public static final class de<T, U extends Collection<? super T>> extends i<T, U, U> implements Runnable, Disposable {
        public final List<U> ggg = new LinkedList();

        /* renamed from: if  reason: not valid java name */
        public final long f499if;

        /* renamed from: pf  reason: collision with root package name */
        public final Callable<U> f10650pf;
        public final th.de ppp;

        /* renamed from: switch  reason: not valid java name */
        public final long f500switch;
        public Disposable vvv;
        public final TimeUnit when;

        /* renamed from: th.de.if.fe.rg.if$de$ad */
        public final class ad implements Runnable {

            /* renamed from: ad  reason: collision with root package name */
            public final U f10651ad;

            public ad(U u) {
                this.f10651ad = u;
            }

            public void run() {
                synchronized (de.this) {
                    de.this.ggg.remove(this.f10651ad);
                }
                de deVar = de.this;
                deVar.i(this.f10651ad, false, deVar.ppp);
            }
        }

        /* renamed from: th.de.if.fe.rg.if$de$qw */
        public final class qw implements Runnable {

            /* renamed from: ad  reason: collision with root package name */
            public final U f10653ad;

            public qw(U u) {
                this.f10653ad = u;
            }

            public void run() {
                synchronized (de.this) {
                    de.this.ggg.remove(this.f10653ad);
                }
                de deVar = de.this;
                deVar.i(this.f10653ad, false, deVar.ppp);
            }
        }

        public de(Observer<? super U> observer, Callable<U> callable, long j, long j2, TimeUnit timeUnit, th.de deVar) {
            super(observer, new MpscLinkedQueue());
            this.f10650pf = callable;
            this.f499if = j;
            this.f500switch = j2;
            this.when = timeUnit;
            this.ppp = deVar;
        }

        public void dispose() {
            if (!this.f10472uk) {
                this.f10472uk = true;
                m2348switch();
                this.vvv.dispose();
                this.ppp.dispose();
            }
        }

        public boolean isDisposed() {
            return this.f10472uk;
        }

        /* renamed from: o */
        public void qw(Observer<? super U> observer, U u) {
            observer.onNext(u);
        }

        public void onComplete() {
            ArrayList<Collection> arrayList;
            synchronized (this) {
                arrayList = new ArrayList<>(this.ggg);
                this.ggg.clear();
            }
            for (Collection offer : arrayList) {
                this.f10473yj.offer(offer);
            }
            this.f10469i = true;
            if (th()) {
                uk.de(this.f10473yj, this.f10471th, false, this.ppp, this);
            }
        }

        public void onError(Throwable th2) {
            this.f10469i = true;
            m2348switch();
            this.f10471th.onError(th2);
            this.ppp.dispose();
        }

        public void onNext(T t) {
            synchronized (this) {
                for (U add : this.ggg) {
                    add.add(t);
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.vvv, disposable)) {
                this.vvv = disposable;
                try {
                    U call = this.f10650pf.call();
                    th.de.p039if.ad.qw.rg(call, "The buffer supplied is null");
                    Collection collection = (Collection) call;
                    this.ggg.add(collection);
                    this.f10471th.onSubscribe(this);
                    th.de deVar = this.ppp;
                    long j = this.f500switch;
                    deVar.fe(this, j, j, this.when);
                    this.ppp.de(new ad(collection), this.f499if, this.when);
                } catch (Throwable th2) {
                    th.de.o.qw.ad(th2);
                    disposable.dispose();
                    EmptyDisposable.error(th2, (Observer<?>) this.f10471th);
                    this.ppp.dispose();
                }
            }
        }

        public void run() {
            if (!this.f10472uk) {
                try {
                    U call = this.f10650pf.call();
                    th.de.p039if.ad.qw.rg(call, "The bufferSupplier returned a null buffer");
                    Collection collection = (Collection) call;
                    synchronized (this) {
                        if (!this.f10472uk) {
                            this.ggg.add(collection);
                            this.ppp.de(new qw(collection), this.f499if, this.when);
                        }
                    }
                } catch (Throwable th2) {
                    th.de.o.qw.ad(th2);
                    this.f10471th.onError(th2);
                    dispose();
                }
            }
        }

        /* renamed from: switch  reason: not valid java name */
        public void m2348switch() {
            synchronized (this) {
                this.ggg.clear();
            }
        }
    }

    /* renamed from: th.de.if.fe.rg.if$qw */
    public static final class qw<T, U extends Collection<? super T>> extends i<T, U, U> implements Runnable, Disposable {
        public Disposable ddd;
        public final th.de ggg;

        /* renamed from: if  reason: not valid java name */
        public final long f501if;
        public long mmm;
        public long nn;

        /* renamed from: pf  reason: collision with root package name */
        public final Callable<U> f10655pf;
        public final boolean ppp;

        /* renamed from: switch  reason: not valid java name */
        public final TimeUnit f502switch;
        public U vvv;
        public final int when;
        public Disposable xxx;

        public qw(Observer<? super U> observer, Callable<U> callable, long j, TimeUnit timeUnit, int i2, boolean z, th.de deVar) {
            super(observer, new MpscLinkedQueue());
            this.f10655pf = callable;
            this.f501if = j;
            this.f502switch = timeUnit;
            this.when = i2;
            this.ppp = z;
            this.ggg = deVar;
        }

        public void dispose() {
            if (!this.f10472uk) {
                this.f10472uk = true;
                this.ddd.dispose();
                this.ggg.dispose();
                synchronized (this) {
                    this.vvv = null;
                }
            }
        }

        public boolean isDisposed() {
            return this.f10472uk;
        }

        /* renamed from: o */
        public void qw(Observer<? super U> observer, U u) {
            observer.onNext(u);
        }

        public void onComplete() {
            U u;
            this.ggg.dispose();
            synchronized (this) {
                u = this.vvv;
                this.vvv = null;
            }
            this.f10473yj.offer(u);
            this.f10469i = true;
            if (th()) {
                uk.de(this.f10473yj, this.f10471th, false, this, this);
            }
        }

        public void onError(Throwable th2) {
            synchronized (this) {
                this.vvv = null;
            }
            this.f10471th.onError(th2);
            this.ggg.dispose();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0021, code lost:
            if (r7.ppp == false) goto L_0x0028;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0023, code lost:
            r7.xxx.dispose();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0028, code lost:
            i(r0, false, r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
            r8 = r7.f10655pf.call();
            th.de.p039if.ad.qw.rg(r8, "The buffer supplied is null");
            r8 = (java.util.Collection) r8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0039, code lost:
            monitor-enter(r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
            r7.vvv = r8;
            r7.mmm++;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0041, code lost:
            monitor-exit(r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0044, code lost:
            if (r7.ppp == false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0046, code lost:
            r0 = r7.ggg;
            r4 = r7.f501if;
            r7.xxx = r0.fe(r7, r4, r4, r7.f502switch);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0058, code lost:
            r8 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0059, code lost:
            th.de.o.qw.ad(r8);
            r7.f10471th.onError(r8);
            dispose();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0064, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onNext(T r8) {
            /*
                r7 = this;
                monitor-enter(r7)
                U r0 = r7.vvv     // Catch:{ all -> 0x0065 }
                if (r0 != 0) goto L_0x0007
                monitor-exit(r7)     // Catch:{ all -> 0x0065 }
                return
            L_0x0007:
                r0.add(r8)     // Catch:{ all -> 0x0065 }
                int r8 = r0.size()     // Catch:{ all -> 0x0065 }
                int r1 = r7.when     // Catch:{ all -> 0x0065 }
                if (r8 >= r1) goto L_0x0014
                monitor-exit(r7)     // Catch:{ all -> 0x0065 }
                return
            L_0x0014:
                r8 = 0
                r7.vvv = r8     // Catch:{ all -> 0x0065 }
                long r1 = r7.nn     // Catch:{ all -> 0x0065 }
                r3 = 1
                long r1 = r1 + r3
                r7.nn = r1     // Catch:{ all -> 0x0065 }
                monitor-exit(r7)     // Catch:{ all -> 0x0065 }
                boolean r8 = r7.ppp
                if (r8 == 0) goto L_0x0028
                io.reactivex.disposables.Disposable r8 = r7.xxx
                r8.dispose()
            L_0x0028:
                r8 = 0
                r7.i(r0, r8, r7)
                java.util.concurrent.Callable<U> r8 = r7.f10655pf     // Catch:{ all -> 0x0058 }
                java.lang.Object r8 = r8.call()     // Catch:{ all -> 0x0058 }
                java.lang.String r0 = "The buffer supplied is null"
                th.de.p039if.ad.qw.rg(r8, r0)     // Catch:{ all -> 0x0058 }
                java.util.Collection r8 = (java.util.Collection) r8     // Catch:{ all -> 0x0058 }
                monitor-enter(r7)
                r7.vvv = r8     // Catch:{ all -> 0x0055 }
                long r0 = r7.mmm     // Catch:{ all -> 0x0055 }
                long r0 = r0 + r3
                r7.mmm = r0     // Catch:{ all -> 0x0055 }
                monitor-exit(r7)     // Catch:{ all -> 0x0055 }
                boolean r8 = r7.ppp
                if (r8 == 0) goto L_0x0054
                th.de.th$de r0 = r7.ggg
                long r4 = r7.f501if
                java.util.concurrent.TimeUnit r6 = r7.f502switch
                r1 = r7
                r2 = r4
                io.reactivex.disposables.Disposable r8 = r0.fe(r1, r2, r4, r6)
                r7.xxx = r8
            L_0x0054:
                return
            L_0x0055:
                r8 = move-exception
                monitor-exit(r7)     // Catch:{ all -> 0x0055 }
                throw r8
            L_0x0058:
                r8 = move-exception
                th.de.o.qw.ad(r8)
                io.reactivex.Observer<? super V> r0 = r7.f10471th
                r0.onError(r8)
                r7.dispose()
                return
            L_0x0065:
                r8 = move-exception
                monitor-exit(r7)     // Catch:{ all -> 0x0065 }
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: th.de.p039if.fe.rg.Cif.qw.onNext(java.lang.Object):void");
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.ddd, disposable)) {
                this.ddd = disposable;
                try {
                    U call = this.f10655pf.call();
                    th.de.p039if.ad.qw.rg(call, "The buffer supplied is null");
                    this.vvv = (Collection) call;
                    this.f10471th.onSubscribe(this);
                    th.de deVar = this.ggg;
                    long j = this.f501if;
                    this.xxx = deVar.fe(this, j, j, this.f502switch);
                } catch (Throwable th2) {
                    th.de.o.qw.ad(th2);
                    disposable.dispose();
                    EmptyDisposable.error(th2, (Observer<?>) this.f10471th);
                    this.ggg.dispose();
                }
            }
        }

        public void run() {
            try {
                U call = this.f10655pf.call();
                th.de.p039if.ad.qw.rg(call, "The bufferSupplier returned a null buffer");
                U u = (Collection) call;
                synchronized (this) {
                    U u2 = this.vvv;
                    if (u2 != null) {
                        if (this.nn == this.mmm) {
                            this.vvv = u;
                            i(u2, false, this);
                        }
                    }
                }
            } catch (Throwable th2) {
                th.de.o.qw.ad(th2);
                dispose();
                this.f10471th.onError(th2);
            }
        }
    }

    public Cif(ObservableSource<T> observableSource, long j, long j2, TimeUnit timeUnit, th thVar, Callable<U> callable, int i2, boolean z) {
        super(observableSource);
        this.f10646th = j;
        this.f10648yj = j2;
        this.f10647uk = timeUnit;
        this.f10643i = thVar;
        this.f10644o = callable;
        this.f10645pf = i2;
        this.f496if = z;
    }

    public void subscribeActual(Observer<? super U> observer) {
        if (this.f10646th == this.f10648yj && this.f10645pf == Integer.MAX_VALUE) {
            this.f10756ad.subscribe(new ad(new fe(observer), this.f10644o, this.f10646th, this.f10647uk, this.f10643i));
            return;
        }
        th.de qw2 = this.f10643i.qw();
        if (this.f10646th == this.f10648yj) {
            this.f10756ad.subscribe(new qw(new fe(observer), this.f10644o, this.f10646th, this.f10647uk, this.f10645pf, this.f496if, qw2));
        } else {
            this.f10756ad.subscribe(new de(new fe(observer), this.f10644o, this.f10646th, this.f10648yj, this.f10647uk, qw2));
        }
    }
}
