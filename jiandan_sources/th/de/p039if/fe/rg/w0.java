package th.de.p039if.fe.rg;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.fuseable.FuseToObservable;
import java.util.Collection;
import java.util.concurrent.Callable;
import th.de.rg;
import th.de.yj;

/* renamed from: th.de.if.fe.rg.w0  reason: invalid package */
public final class w0<T, U extends Collection<? super T>> extends yj<U> implements FuseToObservable<U> {

    /* renamed from: ad  reason: collision with root package name */
    public final ObservableSource<T> f10848ad;

    /* renamed from: th  reason: collision with root package name */
    public final Callable<U> f10849th;

    /* renamed from: th.de.if.fe.rg.w0$qw */
    public static final class qw<T, U extends Collection<? super T>> implements Observer<T>, Disposable {

        /* renamed from: ad  reason: collision with root package name */
        public final SingleObserver<? super U> f10850ad;

        /* renamed from: th  reason: collision with root package name */
        public U f10851th;

        /* renamed from: yj  reason: collision with root package name */
        public Disposable f10852yj;

        public qw(SingleObserver<? super U> singleObserver, U u) {
            this.f10850ad = singleObserver;
            this.f10851th = u;
        }

        public void dispose() {
            this.f10852yj.dispose();
        }

        public boolean isDisposed() {
            return this.f10852yj.isDisposed();
        }

        public void onComplete() {
            U u = this.f10851th;
            this.f10851th = null;
            this.f10850ad.onSuccess(u);
        }

        public void onError(Throwable th2) {
            this.f10851th = null;
            this.f10850ad.onError(th2);
        }

        public void onNext(T t) {
            this.f10851th.add(t);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f10852yj, disposable)) {
                this.f10852yj = disposable;
                this.f10850ad.onSubscribe(this);
            }
        }
    }

    public w0(ObservableSource<T> observableSource, int i2) {
        this.f10848ad = observableSource;
        this.f10849th = Functions.rg(i2);
    }

    public rg<U> ad() {
        return th.de.ppp.qw.when(new v0(this.f10848ad, this.f10849th));
    }

    public void rg(SingleObserver<? super U> singleObserver) {
        try {
            U call = this.f10849th.call();
            th.de.p039if.ad.qw.rg(call, "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.");
            this.f10848ad.subscribe(new qw(singleObserver, (Collection) call));
        } catch (Throwable th2) {
            th.de.o.qw.ad(th2);
            EmptyDisposable.error(th2, (SingleObserver<?>) singleObserver);
        }
    }

    public w0(ObservableSource<T> observableSource, Callable<U> callable) {
        this.f10848ad = observableSource;
        this.f10849th = callable;
    }
}
