package th.de.p039if.fe.rg;

import io.reactivex.Observer;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.Iterator;
import th.de.p039if.de.ad;
import th.de.rg;

/* renamed from: th.de.if.fe.rg.m  reason: invalid package */
public final class m<T> extends rg<T> {

    /* renamed from: ad  reason: collision with root package name */
    public final Iterable<? extends T> f10678ad;

    /* renamed from: th.de.if.fe.rg.m$qw */
    public static final class qw<T> extends ad<T> {

        /* renamed from: ad  reason: collision with root package name */
        public final Observer<? super T> f10679ad;

        /* renamed from: i  reason: collision with root package name */
        public boolean f10680i;

        /* renamed from: o  reason: collision with root package name */
        public boolean f10681o;

        /* renamed from: th  reason: collision with root package name */
        public final Iterator<? extends T> f10682th;

        /* renamed from: uk  reason: collision with root package name */
        public boolean f10683uk;

        /* renamed from: yj  reason: collision with root package name */
        public volatile boolean f10684yj;

        public qw(Observer<? super T> observer, Iterator<? extends T> it) {
            this.f10679ad = observer;
            this.f10682th = it;
        }

        public void clear() {
            this.f10680i = true;
        }

        public void dispose() {
            this.f10684yj = true;
        }

        public boolean isDisposed() {
            return this.f10684yj;
        }

        public boolean isEmpty() {
            return this.f10680i;
        }

        public T poll() {
            if (this.f10680i) {
                return null;
            }
            if (!this.f10681o) {
                this.f10681o = true;
            } else if (!this.f10682th.hasNext()) {
                this.f10680i = true;
                return null;
            }
            T next = this.f10682th.next();
            th.de.p039if.ad.qw.rg(next, "The iterator returned a null value");
            return next;
        }

        public void qw() {
            while (!isDisposed()) {
                try {
                    Object next = this.f10682th.next();
                    th.de.p039if.ad.qw.rg(next, "The iterator returned a null value");
                    this.f10679ad.onNext(next);
                    if (!isDisposed()) {
                        try {
                            if (!this.f10682th.hasNext()) {
                                if (!isDisposed()) {
                                    this.f10679ad.onComplete();
                                    return;
                                }
                                return;
                            }
                        } catch (Throwable th2) {
                            th.de.o.qw.ad(th2);
                            this.f10679ad.onError(th2);
                            return;
                        }
                    } else {
                        return;
                    }
                } catch (Throwable th3) {
                    th.de.o.qw.ad(th3);
                    this.f10679ad.onError(th3);
                    return;
                }
            }
        }

        public int requestFusion(int i2) {
            if ((i2 & 1) == 0) {
                return 0;
            }
            this.f10683uk = true;
            return 1;
        }
    }

    public m(Iterable<? extends T> iterable) {
        this.f10678ad = iterable;
    }

    public void subscribeActual(Observer<? super T> observer) {
        try {
            Iterator<? extends T> it = this.f10678ad.iterator();
            try {
                if (!it.hasNext()) {
                    EmptyDisposable.complete((Observer<?>) observer);
                    return;
                }
                qw qwVar = new qw(observer, it);
                observer.onSubscribe(qwVar);
                if (!qwVar.f10683uk) {
                    qwVar.qw();
                }
            } catch (Throwable th2) {
                th.de.o.qw.ad(th2);
                EmptyDisposable.error(th2, (Observer<?>) observer);
            }
        } catch (Throwable th3) {
            th.de.o.qw.ad(th3);
            EmptyDisposable.error(th3, (Observer<?>) observer);
        }
    }
}
