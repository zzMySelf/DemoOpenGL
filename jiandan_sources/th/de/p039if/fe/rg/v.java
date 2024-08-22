package th.de.p039if.fe.rg;

import io.reactivex.MaybeObserver;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import th.de.de;

/* renamed from: th.de.if.fe.rg.v  reason: invalid package */
public final class v<T> extends de<T> {

    /* renamed from: ad  reason: collision with root package name */
    public final ObservableSource<T> f10822ad;

    /* renamed from: th.de.if.fe.rg.v$qw */
    public static final class qw<T> implements Observer<T>, Disposable {

        /* renamed from: ad  reason: collision with root package name */
        public final MaybeObserver<? super T> f10823ad;

        /* renamed from: th  reason: collision with root package name */
        public Disposable f10824th;

        /* renamed from: yj  reason: collision with root package name */
        public T f10825yj;

        public qw(MaybeObserver<? super T> maybeObserver) {
            this.f10823ad = maybeObserver;
        }

        public void dispose() {
            this.f10824th.dispose();
            this.f10824th = DisposableHelper.DISPOSED;
        }

        public boolean isDisposed() {
            return this.f10824th == DisposableHelper.DISPOSED;
        }

        public void onComplete() {
            this.f10824th = DisposableHelper.DISPOSED;
            T t = this.f10825yj;
            if (t != null) {
                this.f10825yj = null;
                this.f10823ad.onSuccess(t);
                return;
            }
            this.f10823ad.onComplete();
        }

        public void onError(Throwable th2) {
            this.f10824th = DisposableHelper.DISPOSED;
            this.f10825yj = null;
            this.f10823ad.onError(th2);
        }

        public void onNext(T t) {
            this.f10825yj = t;
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f10824th, disposable)) {
                this.f10824th = disposable;
                this.f10823ad.onSubscribe(this);
            }
        }
    }

    public v(ObservableSource<T> observableSource) {
        this.f10822ad = observableSource;
    }

    public void fe(MaybeObserver<? super T> maybeObserver) {
        this.f10822ad.subscribe(new qw(maybeObserver));
    }
}
