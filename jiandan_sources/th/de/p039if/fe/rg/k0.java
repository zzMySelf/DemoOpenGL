package th.de.p039if.fe.rg;

import io.reactivex.MaybeObserver;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import th.de.de;

/* renamed from: th.de.if.fe.rg.k0  reason: invalid package */
public final class k0<T> extends de<T> {

    /* renamed from: ad  reason: collision with root package name */
    public final ObservableSource<T> f10663ad;

    /* renamed from: th.de.if.fe.rg.k0$qw */
    public static final class qw<T> implements Observer<T>, Disposable {

        /* renamed from: ad  reason: collision with root package name */
        public final MaybeObserver<? super T> f10664ad;

        /* renamed from: th  reason: collision with root package name */
        public Disposable f10665th;

        /* renamed from: uk  reason: collision with root package name */
        public boolean f10666uk;

        /* renamed from: yj  reason: collision with root package name */
        public T f10667yj;

        public qw(MaybeObserver<? super T> maybeObserver) {
            this.f10664ad = maybeObserver;
        }

        public void dispose() {
            this.f10665th.dispose();
        }

        public boolean isDisposed() {
            return this.f10665th.isDisposed();
        }

        public void onComplete() {
            if (!this.f10666uk) {
                this.f10666uk = true;
                T t = this.f10667yj;
                this.f10667yj = null;
                if (t == null) {
                    this.f10664ad.onComplete();
                } else {
                    this.f10664ad.onSuccess(t);
                }
            }
        }

        public void onError(Throwable th2) {
            if (this.f10666uk) {
                th.de.ppp.qw.ddd(th2);
                return;
            }
            this.f10666uk = true;
            this.f10664ad.onError(th2);
        }

        public void onNext(T t) {
            if (!this.f10666uk) {
                if (this.f10667yj != null) {
                    this.f10666uk = true;
                    this.f10665th.dispose();
                    this.f10664ad.onError(new IllegalArgumentException("Sequence contains more than one element!"));
                    return;
                }
                this.f10667yj = t;
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f10665th, disposable)) {
                this.f10665th = disposable;
                this.f10664ad.onSubscribe(this);
            }
        }
    }

    public k0(ObservableSource<T> observableSource) {
        this.f10663ad = observableSource;
    }

    public void fe(MaybeObserver<? super T> maybeObserver) {
        this.f10663ad.subscribe(new qw(maybeObserver));
    }
}
