package th.de.p039if.fe.rg;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.SequentialDisposable;

/* renamed from: th.de.if.fe.rg.c0  reason: invalid package */
public final class c0<T> extends qw<T, T> {

    /* renamed from: th  reason: collision with root package name */
    public final Function<? super Throwable, ? extends ObservableSource<? extends T>> f10546th;

    /* renamed from: yj  reason: collision with root package name */
    public final boolean f10547yj;

    /* renamed from: th.de.if.fe.rg.c0$qw */
    public static final class qw<T> implements Observer<T> {

        /* renamed from: ad  reason: collision with root package name */
        public final Observer<? super T> f10548ad;

        /* renamed from: i  reason: collision with root package name */
        public boolean f10549i;

        /* renamed from: o  reason: collision with root package name */
        public boolean f10550o;

        /* renamed from: th  reason: collision with root package name */
        public final Function<? super Throwable, ? extends ObservableSource<? extends T>> f10551th;

        /* renamed from: uk  reason: collision with root package name */
        public final SequentialDisposable f10552uk = new SequentialDisposable();

        /* renamed from: yj  reason: collision with root package name */
        public final boolean f10553yj;

        public qw(Observer<? super T> observer, Function<? super Throwable, ? extends ObservableSource<? extends T>> function, boolean z) {
            this.f10548ad = observer;
            this.f10551th = function;
            this.f10553yj = z;
        }

        public void onComplete() {
            if (!this.f10550o) {
                this.f10550o = true;
                this.f10549i = true;
                this.f10548ad.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (!this.f10549i) {
                this.f10549i = true;
                if (!this.f10553yj || (th2 instanceof Exception)) {
                    try {
                        ObservableSource observableSource = (ObservableSource) this.f10551th.apply(th2);
                        if (observableSource == null) {
                            NullPointerException nullPointerException = new NullPointerException("Observable is null");
                            nullPointerException.initCause(th2);
                            this.f10548ad.onError(nullPointerException);
                            return;
                        }
                        observableSource.subscribe(this);
                    } catch (Throwable th3) {
                        th.de.o.qw.ad(th3);
                        this.f10548ad.onError(new CompositeException(th2, th3));
                    }
                } else {
                    this.f10548ad.onError(th2);
                }
            } else if (this.f10550o) {
                th.de.ppp.qw.ddd(th2);
            } else {
                this.f10548ad.onError(th2);
            }
        }

        public void onNext(T t) {
            if (!this.f10550o) {
                this.f10548ad.onNext(t);
            }
        }

        public void onSubscribe(Disposable disposable) {
            this.f10552uk.replace(disposable);
        }
    }

    public c0(ObservableSource<T> observableSource, Function<? super Throwable, ? extends ObservableSource<? extends T>> function, boolean z) {
        super(observableSource);
        this.f10546th = function;
        this.f10547yj = z;
    }

    public void subscribeActual(Observer<? super T> observer) {
        qw qwVar = new qw(observer, this.f10546th, this.f10547yj);
        observer.onSubscribe(qwVar.f10552uk);
        this.f10756ad.subscribe(qwVar);
    }
}
