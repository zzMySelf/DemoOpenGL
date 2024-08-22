package th.de.p039if.fe.rg;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.Iterator;
import th.de.rg;

/* renamed from: th.de.if.fe.rg.z0  reason: invalid package */
public final class z0<T, U, V> extends rg<V> {

    /* renamed from: ad  reason: collision with root package name */
    public final rg<? extends T> f10901ad;

    /* renamed from: th  reason: collision with root package name */
    public final Iterable<U> f10902th;

    /* renamed from: yj  reason: collision with root package name */
    public final BiFunction<? super T, ? super U, ? extends V> f10903yj;

    /* renamed from: th.de.if.fe.rg.z0$qw */
    public static final class qw<T, U, V> implements Observer<T>, Disposable {

        /* renamed from: ad  reason: collision with root package name */
        public final Observer<? super V> f10904ad;

        /* renamed from: i  reason: collision with root package name */
        public boolean f10905i;

        /* renamed from: th  reason: collision with root package name */
        public final Iterator<U> f10906th;

        /* renamed from: uk  reason: collision with root package name */
        public Disposable f10907uk;

        /* renamed from: yj  reason: collision with root package name */
        public final BiFunction<? super T, ? super U, ? extends V> f10908yj;

        public qw(Observer<? super V> observer, Iterator<U> it, BiFunction<? super T, ? super U, ? extends V> biFunction) {
            this.f10904ad = observer;
            this.f10906th = it;
            this.f10908yj = biFunction;
        }

        public void dispose() {
            this.f10907uk.dispose();
        }

        public boolean isDisposed() {
            return this.f10907uk.isDisposed();
        }

        public void onComplete() {
            if (!this.f10905i) {
                this.f10905i = true;
                this.f10904ad.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (this.f10905i) {
                th.de.ppp.qw.ddd(th2);
                return;
            }
            this.f10905i = true;
            this.f10904ad.onError(th2);
        }

        public void onNext(T t) {
            if (!this.f10905i) {
                try {
                    U next = this.f10906th.next();
                    th.de.p039if.ad.qw.rg(next, "The iterator returned a null value");
                    try {
                        Object apply = this.f10908yj.apply(t, next);
                        th.de.p039if.ad.qw.rg(apply, "The zipper function returned a null value");
                        this.f10904ad.onNext(apply);
                        try {
                            if (!this.f10906th.hasNext()) {
                                this.f10905i = true;
                                this.f10907uk.dispose();
                                this.f10904ad.onComplete();
                            }
                        } catch (Throwable th2) {
                            th.de.o.qw.ad(th2);
                            qw(th2);
                        }
                    } catch (Throwable th3) {
                        th.de.o.qw.ad(th3);
                        qw(th3);
                    }
                } catch (Throwable th4) {
                    th.de.o.qw.ad(th4);
                    qw(th4);
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f10907uk, disposable)) {
                this.f10907uk = disposable;
                this.f10904ad.onSubscribe(this);
            }
        }

        public void qw(Throwable th2) {
            this.f10905i = true;
            this.f10907uk.dispose();
            this.f10904ad.onError(th2);
        }
    }

    public z0(rg<? extends T> rgVar, Iterable<U> iterable, BiFunction<? super T, ? super U, ? extends V> biFunction) {
        this.f10901ad = rgVar;
        this.f10902th = iterable;
        this.f10903yj = biFunction;
    }

    public void subscribeActual(Observer<? super V> observer) {
        try {
            Iterator<U> it = this.f10902th.iterator();
            th.de.p039if.ad.qw.rg(it, "The iterator returned by other is null");
            Iterator it2 = it;
            try {
                if (!it2.hasNext()) {
                    EmptyDisposable.complete((Observer<?>) observer);
                } else {
                    this.f10901ad.subscribe(new qw(observer, it2, this.f10903yj));
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
