package th.de.p039if.fe.rg;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.queue.MpscLinkedQueue;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;
import th.de.p039if.de.i;
import th.de.when.fe;

/* renamed from: th.de.if.fe.rg.o  reason: invalid package */
public final class o<T, U extends Collection<? super T>, B> extends qw<T, U> {

    /* renamed from: th  reason: collision with root package name */
    public final Callable<? extends ObservableSource<B>> f10714th;

    /* renamed from: yj  reason: collision with root package name */
    public final Callable<U> f10715yj;

    /* renamed from: th.de.if.fe.rg.o$ad */
    public static final class ad<T, U extends Collection<? super T>, B> extends i<T, U, U> implements Observer<T>, Disposable {

        /* renamed from: if  reason: not valid java name */
        public final Callable<? extends ObservableSource<B>> f503if;

        /* renamed from: pf  reason: collision with root package name */
        public final Callable<U> f10716pf;
        public U ppp;

        /* renamed from: switch  reason: not valid java name */
        public Disposable f504switch;
        public final AtomicReference<Disposable> when = new AtomicReference<>();

        public ad(Observer<? super U> observer, Callable<U> callable, Callable<? extends ObservableSource<B>> callable2) {
            super(observer, new MpscLinkedQueue());
            this.f10716pf = callable;
            this.f503if = callable2;
        }

        public void dispose() {
            if (!this.f10472uk) {
                this.f10472uk = true;
                this.f504switch.dispose();
                pf();
                if (th()) {
                    this.f10473yj.clear();
                }
            }
        }

        /* renamed from: if  reason: not valid java name */
        public void m2349if() {
            try {
                U call = this.f10716pf.call();
                th.de.p039if.ad.qw.rg(call, "The buffer supplied is null");
                U u = (Collection) call;
                try {
                    Object call2 = this.f503if.call();
                    th.de.p039if.ad.qw.rg(call2, "The boundary ObservableSource supplied is null");
                    ObservableSource observableSource = (ObservableSource) call2;
                    qw qwVar = new qw(this);
                    if (DisposableHelper.replace(this.when, qwVar)) {
                        synchronized (this) {
                            U u2 = this.ppp;
                            if (u2 != null) {
                                this.ppp = u;
                                observableSource.subscribe(qwVar);
                                uk(u2, false, this);
                            }
                        }
                    }
                } catch (Throwable th2) {
                    th.de.o.qw.ad(th2);
                    this.f10472uk = true;
                    this.f504switch.dispose();
                    this.f10471th.onError(th2);
                }
            } catch (Throwable th3) {
                th.de.o.qw.ad(th3);
                dispose();
                this.f10471th.onError(th3);
            }
        }

        public boolean isDisposed() {
            return this.f10472uk;
        }

        /* renamed from: o */
        public void qw(Observer<? super U> observer, U u) {
            this.f10471th.onNext(u);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0019, code lost:
            th.de.p039if.yj.uk.de(r3.f10473yj, r3.f10471th, false, r3, r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x000b, code lost:
            r3.f10473yj.offer(r0);
            r3.f10469i = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0017, code lost:
            if (th() == false) goto L_?;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onComplete() {
            /*
                r3 = this;
                monitor-enter(r3)
                U r0 = r3.ppp     // Catch:{ all -> 0x0022 }
                if (r0 != 0) goto L_0x0007
                monitor-exit(r3)     // Catch:{ all -> 0x0022 }
                return
            L_0x0007:
                r1 = 0
                r3.ppp = r1     // Catch:{ all -> 0x0022 }
                monitor-exit(r3)     // Catch:{ all -> 0x0022 }
                io.reactivex.internal.fuseable.SimplePlainQueue<U> r1 = r3.f10473yj
                r1.offer(r0)
                r0 = 1
                r3.f10469i = r0
                boolean r0 = r3.th()
                if (r0 == 0) goto L_0x0021
                io.reactivex.internal.fuseable.SimplePlainQueue<U> r0 = r3.f10473yj
                io.reactivex.Observer<? super V> r1 = r3.f10471th
                r2 = 0
                th.de.p039if.yj.uk.de(r0, r1, r2, r3, r3)
            L_0x0021:
                return
            L_0x0022:
                r0 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x0022 }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: th.de.p039if.fe.rg.o.ad.onComplete():void");
        }

        public void onError(Throwable th2) {
            dispose();
            this.f10471th.onError(th2);
        }

        public void onNext(T t) {
            synchronized (this) {
                U u = this.ppp;
                if (u != null) {
                    u.add(t);
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f504switch, disposable)) {
                this.f504switch = disposable;
                Observer<? super V> observer = this.f10471th;
                try {
                    U call = this.f10716pf.call();
                    th.de.p039if.ad.qw.rg(call, "The buffer supplied is null");
                    this.ppp = (Collection) call;
                    try {
                        Object call2 = this.f503if.call();
                        th.de.p039if.ad.qw.rg(call2, "The boundary ObservableSource supplied is null");
                        ObservableSource observableSource = (ObservableSource) call2;
                        qw qwVar = new qw(this);
                        this.when.set(qwVar);
                        observer.onSubscribe(this);
                        if (!this.f10472uk) {
                            observableSource.subscribe(qwVar);
                        }
                    } catch (Throwable th2) {
                        th.de.o.qw.ad(th2);
                        this.f10472uk = true;
                        disposable.dispose();
                        EmptyDisposable.error(th2, (Observer<?>) observer);
                    }
                } catch (Throwable th3) {
                    th.de.o.qw.ad(th3);
                    this.f10472uk = true;
                    disposable.dispose();
                    EmptyDisposable.error(th3, (Observer<?>) observer);
                }
            }
        }

        public void pf() {
            DisposableHelper.dispose(this.when);
        }
    }

    /* renamed from: th.de.if.fe.rg.o$qw */
    public static final class qw<T, U extends Collection<? super T>, B> extends th.de.when.ad<B> {

        /* renamed from: th  reason: collision with root package name */
        public final ad<T, U, B> f10717th;

        /* renamed from: yj  reason: collision with root package name */
        public boolean f10718yj;

        public qw(ad<T, U, B> adVar) {
            this.f10717th = adVar;
        }

        public void onComplete() {
            if (!this.f10718yj) {
                this.f10718yj = true;
                this.f10717th.m2349if();
            }
        }

        public void onError(Throwable th2) {
            if (this.f10718yj) {
                th.de.ppp.qw.ddd(th2);
                return;
            }
            this.f10718yj = true;
            this.f10717th.onError(th2);
        }

        public void onNext(B b) {
            if (!this.f10718yj) {
                this.f10718yj = true;
                dispose();
                this.f10717th.m2349if();
            }
        }
    }

    public o(ObservableSource<T> observableSource, Callable<? extends ObservableSource<B>> callable, Callable<U> callable2) {
        super(observableSource);
        this.f10714th = callable;
        this.f10715yj = callable2;
    }

    public void subscribeActual(Observer<? super U> observer) {
        this.f10756ad.subscribe(new ad(new fe(observer), this.f10715yj, this.f10714th));
    }
}
