package th.de.p039if.fe.rg;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;

/* renamed from: th.de.if.fe.rg.h  reason: invalid package */
public final class h<T, R> extends qw<T, R> {

    /* renamed from: th  reason: collision with root package name */
    public final Function<? super T, ? extends Iterable<? extends R>> f10626th;

    /* renamed from: th.de.if.fe.rg.h$qw */
    public static final class qw<T, R> implements Observer<T>, Disposable {

        /* renamed from: ad  reason: collision with root package name */
        public final Observer<? super R> f10627ad;

        /* renamed from: th  reason: collision with root package name */
        public final Function<? super T, ? extends Iterable<? extends R>> f10628th;

        /* renamed from: yj  reason: collision with root package name */
        public Disposable f10629yj;

        public qw(Observer<? super R> observer, Function<? super T, ? extends Iterable<? extends R>> function) {
            this.f10627ad = observer;
            this.f10628th = function;
        }

        public void dispose() {
            this.f10629yj.dispose();
            this.f10629yj = DisposableHelper.DISPOSED;
        }

        public boolean isDisposed() {
            return this.f10629yj.isDisposed();
        }

        public void onComplete() {
            Disposable disposable = this.f10629yj;
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (disposable != disposableHelper) {
                this.f10629yj = disposableHelper;
                this.f10627ad.onComplete();
            }
        }

        public void onError(Throwable th2) {
            Disposable disposable = this.f10629yj;
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (disposable == disposableHelper) {
                th.de.ppp.qw.ddd(th2);
                return;
            }
            this.f10629yj = disposableHelper;
            this.f10627ad.onError(th2);
        }

        public void onNext(T t) {
            if (this.f10629yj != DisposableHelper.DISPOSED) {
                try {
                    Observer<? super R> observer = this.f10627ad;
                    for (Object next : (Iterable) this.f10628th.apply(t)) {
                        try {
                            try {
                                th.de.p039if.ad.qw.rg(next, "The iterator returned a null value");
                                observer.onNext(next);
                            } catch (Throwable th2) {
                                th.de.o.qw.ad(th2);
                                this.f10629yj.dispose();
                                onError(th2);
                                return;
                            }
                        } catch (Throwable th3) {
                            th.de.o.qw.ad(th3);
                            this.f10629yj.dispose();
                            onError(th3);
                            return;
                        }
                    }
                } catch (Throwable th4) {
                    th.de.o.qw.ad(th4);
                    this.f10629yj.dispose();
                    onError(th4);
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f10629yj, disposable)) {
                this.f10629yj = disposable;
                this.f10627ad.onSubscribe(this);
            }
        }
    }

    public h(ObservableSource<T> observableSource, Function<? super T, ? extends Iterable<? extends R>> function) {
        super(observableSource);
        this.f10626th = function;
    }

    public void subscribeActual(Observer<? super R> observer) {
        this.f10756ad.subscribe(new qw(observer, this.f10626th));
    }
}
