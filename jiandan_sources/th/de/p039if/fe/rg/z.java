package th.de.p039if.fe.rg;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.Callable;

/* renamed from: th.de.if.fe.rg.z  reason: invalid package */
public final class z<T, R> extends qw<T, ObservableSource<? extends R>> {

    /* renamed from: th  reason: collision with root package name */
    public final Function<? super T, ? extends ObservableSource<? extends R>> f10893th;

    /* renamed from: uk  reason: collision with root package name */
    public final Callable<? extends ObservableSource<? extends R>> f10894uk;

    /* renamed from: yj  reason: collision with root package name */
    public final Function<? super Throwable, ? extends ObservableSource<? extends R>> f10895yj;

    /* renamed from: th.de.if.fe.rg.z$qw */
    public static final class qw<T, R> implements Observer<T>, Disposable {

        /* renamed from: ad  reason: collision with root package name */
        public final Observer<? super ObservableSource<? extends R>> f10896ad;

        /* renamed from: i  reason: collision with root package name */
        public Disposable f10897i;

        /* renamed from: th  reason: collision with root package name */
        public final Function<? super T, ? extends ObservableSource<? extends R>> f10898th;

        /* renamed from: uk  reason: collision with root package name */
        public final Callable<? extends ObservableSource<? extends R>> f10899uk;

        /* renamed from: yj  reason: collision with root package name */
        public final Function<? super Throwable, ? extends ObservableSource<? extends R>> f10900yj;

        public qw(Observer<? super ObservableSource<? extends R>> observer, Function<? super T, ? extends ObservableSource<? extends R>> function, Function<? super Throwable, ? extends ObservableSource<? extends R>> function2, Callable<? extends ObservableSource<? extends R>> callable) {
            this.f10896ad = observer;
            this.f10898th = function;
            this.f10900yj = function2;
            this.f10899uk = callable;
        }

        public void dispose() {
            this.f10897i.dispose();
        }

        public boolean isDisposed() {
            return this.f10897i.isDisposed();
        }

        public void onComplete() {
            try {
                Object call = this.f10899uk.call();
                th.de.p039if.ad.qw.rg(call, "The onComplete ObservableSource returned is null");
                this.f10896ad.onNext((ObservableSource) call);
                this.f10896ad.onComplete();
            } catch (Throwable th2) {
                th.de.o.qw.ad(th2);
                this.f10896ad.onError(th2);
            }
        }

        public void onError(Throwable th2) {
            try {
                Object apply = this.f10900yj.apply(th2);
                th.de.p039if.ad.qw.rg(apply, "The onError ObservableSource returned is null");
                this.f10896ad.onNext((ObservableSource) apply);
                this.f10896ad.onComplete();
            } catch (Throwable th3) {
                th.de.o.qw.ad(th3);
                this.f10896ad.onError(new CompositeException(th2, th3));
            }
        }

        public void onNext(T t) {
            try {
                Object apply = this.f10898th.apply(t);
                th.de.p039if.ad.qw.rg(apply, "The onNext ObservableSource returned is null");
                this.f10896ad.onNext((ObservableSource) apply);
            } catch (Throwable th2) {
                th.de.o.qw.ad(th2);
                this.f10896ad.onError(th2);
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f10897i, disposable)) {
                this.f10897i = disposable;
                this.f10896ad.onSubscribe(this);
            }
        }
    }

    public z(ObservableSource<T> observableSource, Function<? super T, ? extends ObservableSource<? extends R>> function, Function<? super Throwable, ? extends ObservableSource<? extends R>> function2, Callable<? extends ObservableSource<? extends R>> callable) {
        super(observableSource);
        this.f10893th = function;
        this.f10895yj = function2;
        this.f10894uk = callable;
    }

    public void subscribeActual(Observer<? super ObservableSource<? extends R>> observer) {
        this.f10756ad.subscribe(new qw(observer, this.f10893th, this.f10895yj, this.f10894uk));
    }
}
