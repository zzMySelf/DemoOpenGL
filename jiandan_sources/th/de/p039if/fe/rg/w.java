package th.de.p039if.fe.rg;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.NoSuchElementException;
import th.de.yj;

/* renamed from: th.de.if.fe.rg.w  reason: invalid package */
public final class w<T> extends yj<T> {

    /* renamed from: ad  reason: collision with root package name */
    public final ObservableSource<T> f10842ad;

    /* renamed from: th  reason: collision with root package name */
    public final T f10843th;

    /* renamed from: th.de.if.fe.rg.w$qw */
    public static final class qw<T> implements Observer<T>, Disposable {

        /* renamed from: ad  reason: collision with root package name */
        public final SingleObserver<? super T> f10844ad;

        /* renamed from: th  reason: collision with root package name */
        public final T f10845th;

        /* renamed from: uk  reason: collision with root package name */
        public T f10846uk;

        /* renamed from: yj  reason: collision with root package name */
        public Disposable f10847yj;

        public qw(SingleObserver<? super T> singleObserver, T t) {
            this.f10844ad = singleObserver;
            this.f10845th = t;
        }

        public void dispose() {
            this.f10847yj.dispose();
            this.f10847yj = DisposableHelper.DISPOSED;
        }

        public boolean isDisposed() {
            return this.f10847yj == DisposableHelper.DISPOSED;
        }

        public void onComplete() {
            this.f10847yj = DisposableHelper.DISPOSED;
            T t = this.f10846uk;
            if (t != null) {
                this.f10846uk = null;
                this.f10844ad.onSuccess(t);
                return;
            }
            T t2 = this.f10845th;
            if (t2 != null) {
                this.f10844ad.onSuccess(t2);
            } else {
                this.f10844ad.onError(new NoSuchElementException());
            }
        }

        public void onError(Throwable th2) {
            this.f10847yj = DisposableHelper.DISPOSED;
            this.f10846uk = null;
            this.f10844ad.onError(th2);
        }

        public void onNext(T t) {
            this.f10846uk = t;
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f10847yj, disposable)) {
                this.f10847yj = disposable;
                this.f10844ad.onSubscribe(this);
            }
        }
    }

    public w(ObservableSource<T> observableSource, T t) {
        this.f10842ad = observableSource;
        this.f10843th = t;
    }

    public void rg(SingleObserver<? super T> singleObserver) {
        this.f10842ad.subscribe(new qw(singleObserver, this.f10843th));
    }
}
