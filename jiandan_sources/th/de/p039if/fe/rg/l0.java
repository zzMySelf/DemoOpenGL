package th.de.p039if.fe.rg;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.NoSuchElementException;
import th.de.yj;

/* renamed from: th.de.if.fe.rg.l0  reason: invalid package */
public final class l0<T> extends yj<T> {

    /* renamed from: ad  reason: collision with root package name */
    public final ObservableSource<? extends T> f10671ad;

    /* renamed from: th  reason: collision with root package name */
    public final T f10672th;

    /* renamed from: th.de.if.fe.rg.l0$qw */
    public static final class qw<T> implements Observer<T>, Disposable {

        /* renamed from: ad  reason: collision with root package name */
        public final SingleObserver<? super T> f10673ad;

        /* renamed from: i  reason: collision with root package name */
        public boolean f10674i;

        /* renamed from: th  reason: collision with root package name */
        public final T f10675th;

        /* renamed from: uk  reason: collision with root package name */
        public T f10676uk;

        /* renamed from: yj  reason: collision with root package name */
        public Disposable f10677yj;

        public qw(SingleObserver<? super T> singleObserver, T t) {
            this.f10673ad = singleObserver;
            this.f10675th = t;
        }

        public void dispose() {
            this.f10677yj.dispose();
        }

        public boolean isDisposed() {
            return this.f10677yj.isDisposed();
        }

        public void onComplete() {
            if (!this.f10674i) {
                this.f10674i = true;
                T t = this.f10676uk;
                this.f10676uk = null;
                if (t == null) {
                    t = this.f10675th;
                }
                if (t != null) {
                    this.f10673ad.onSuccess(t);
                } else {
                    this.f10673ad.onError(new NoSuchElementException());
                }
            }
        }

        public void onError(Throwable th2) {
            if (this.f10674i) {
                th.de.ppp.qw.ddd(th2);
                return;
            }
            this.f10674i = true;
            this.f10673ad.onError(th2);
        }

        public void onNext(T t) {
            if (!this.f10674i) {
                if (this.f10676uk != null) {
                    this.f10674i = true;
                    this.f10677yj.dispose();
                    this.f10673ad.onError(new IllegalArgumentException("Sequence contains more than one element!"));
                    return;
                }
                this.f10676uk = t;
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f10677yj, disposable)) {
                this.f10677yj = disposable;
                this.f10673ad.onSubscribe(this);
            }
        }
    }

    public l0(ObservableSource<? extends T> observableSource, T t) {
        this.f10671ad = observableSource;
        this.f10672th = t;
    }

    public void rg(SingleObserver<? super T> singleObserver) {
        this.f10671ad.subscribe(new qw(singleObserver, this.f10672th));
    }
}
