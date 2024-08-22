package th.de.p039if.fe.rg;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.queue.MpscLinkedQueue;
import java.util.Collection;
import java.util.concurrent.Callable;
import th.de.p039if.de.i;
import th.de.when.fe;

/* renamed from: th.de.if.fe.rg.pf  reason: invalid package */
public final class pf<T, U extends Collection<? super T>, B> extends qw<T, U> {

    /* renamed from: th  reason: collision with root package name */
    public final ObservableSource<B> f10730th;

    /* renamed from: yj  reason: collision with root package name */
    public final Callable<U> f10731yj;

    /* renamed from: th.de.if.fe.rg.pf$ad */
    public static final class ad<T, U extends Collection<? super T>, B> extends i<T, U, U> implements Observer<T>, Disposable {

        /* renamed from: if  reason: not valid java name */
        public final ObservableSource<B> f505if;

        /* renamed from: pf  reason: collision with root package name */
        public final Callable<U> f10732pf;
        public U ppp;

        /* renamed from: switch  reason: not valid java name */
        public Disposable f506switch;
        public Disposable when;

        public ad(Observer<? super U> observer, Callable<U> callable, ObservableSource<B> observableSource) {
            super(observer, new MpscLinkedQueue());
            this.f10732pf = callable;
            this.f505if = observableSource;
        }

        public void dispose() {
            if (!this.f10472uk) {
                this.f10472uk = true;
                this.when.dispose();
                this.f506switch.dispose();
                if (th()) {
                    this.f10473yj.clear();
                }
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
            throw new UnsupportedOperationException("Method not decompiled: th.de.p039if.fe.rg.pf.ad.onComplete():void");
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
            if (DisposableHelper.validate(this.f506switch, disposable)) {
                this.f506switch = disposable;
                try {
                    U call = this.f10732pf.call();
                    th.de.p039if.ad.qw.rg(call, "The buffer supplied is null");
                    this.ppp = (Collection) call;
                    qw qwVar = new qw(this);
                    this.when = qwVar;
                    this.f10471th.onSubscribe(this);
                    if (!this.f10472uk) {
                        this.f505if.subscribe(qwVar);
                    }
                } catch (Throwable th2) {
                    th.de.o.qw.ad(th2);
                    this.f10472uk = true;
                    disposable.dispose();
                    EmptyDisposable.error(th2, (Observer<?>) this.f10471th);
                }
            }
        }

        public void pf() {
            try {
                U call = this.f10732pf.call();
                th.de.p039if.ad.qw.rg(call, "The buffer supplied is null");
                U u = (Collection) call;
                synchronized (this) {
                    U u2 = this.ppp;
                    if (u2 != null) {
                        this.ppp = u;
                        uk(u2, false, this);
                    }
                }
            } catch (Throwable th2) {
                th.de.o.qw.ad(th2);
                dispose();
                this.f10471th.onError(th2);
            }
        }
    }

    /* renamed from: th.de.if.fe.rg.pf$qw */
    public static final class qw<T, U extends Collection<? super T>, B> extends th.de.when.ad<B> {

        /* renamed from: th  reason: collision with root package name */
        public final ad<T, U, B> f10733th;

        public qw(ad<T, U, B> adVar) {
            this.f10733th = adVar;
        }

        public void onComplete() {
            this.f10733th.onComplete();
        }

        public void onError(Throwable th2) {
            this.f10733th.onError(th2);
        }

        public void onNext(B b) {
            this.f10733th.pf();
        }
    }

    public pf(ObservableSource<T> observableSource, ObservableSource<B> observableSource2, Callable<U> callable) {
        super(observableSource);
        this.f10730th = observableSource2;
        this.f10731yj = callable;
    }

    public void subscribeActual(Observer<? super U> observer) {
        this.f10756ad.subscribe(new ad(new fe(observer), this.f10731yj, this.f10730th));
    }
}
