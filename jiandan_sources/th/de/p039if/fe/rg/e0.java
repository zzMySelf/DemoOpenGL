package th.de.p039if.fe.rg;

import io.reactivex.MaybeObserver;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.disposables.DisposableHelper;
import th.de.de;

/* renamed from: th.de.if.fe.rg.e0  reason: invalid package */
public final class e0<T> extends de<T> {

    /* renamed from: ad  reason: collision with root package name */
    public final ObservableSource<T> f10588ad;

    /* renamed from: th  reason: collision with root package name */
    public final BiFunction<T, T, T> f10589th;

    /* renamed from: th.de.if.fe.rg.e0$qw */
    public static final class qw<T> implements Observer<T>, Disposable {

        /* renamed from: ad  reason: collision with root package name */
        public final MaybeObserver<? super T> f10590ad;

        /* renamed from: i  reason: collision with root package name */
        public Disposable f10591i;

        /* renamed from: th  reason: collision with root package name */
        public final BiFunction<T, T, T> f10592th;

        /* renamed from: uk  reason: collision with root package name */
        public T f10593uk;

        /* renamed from: yj  reason: collision with root package name */
        public boolean f10594yj;

        public qw(MaybeObserver<? super T> maybeObserver, BiFunction<T, T, T> biFunction) {
            this.f10590ad = maybeObserver;
            this.f10592th = biFunction;
        }

        public void dispose() {
            this.f10591i.dispose();
        }

        public boolean isDisposed() {
            return this.f10591i.isDisposed();
        }

        public void onComplete() {
            if (!this.f10594yj) {
                this.f10594yj = true;
                T t = this.f10593uk;
                this.f10593uk = null;
                if (t != null) {
                    this.f10590ad.onSuccess(t);
                } else {
                    this.f10590ad.onComplete();
                }
            }
        }

        public void onError(Throwable th2) {
            if (this.f10594yj) {
                th.de.ppp.qw.ddd(th2);
                return;
            }
            this.f10594yj = true;
            this.f10593uk = null;
            this.f10590ad.onError(th2);
        }

        public void onNext(T t) {
            if (!this.f10594yj) {
                T t2 = this.f10593uk;
                if (t2 == null) {
                    this.f10593uk = t;
                    return;
                }
                try {
                    T apply = this.f10592th.apply(t2, t);
                    th.de.p039if.ad.qw.rg(apply, "The reducer returned a null value");
                    this.f10593uk = apply;
                } catch (Throwable th2) {
                    th.de.o.qw.ad(th2);
                    this.f10591i.dispose();
                    onError(th2);
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f10591i, disposable)) {
                this.f10591i = disposable;
                this.f10590ad.onSubscribe(this);
            }
        }
    }

    public e0(ObservableSource<T> observableSource, BiFunction<T, T, T> biFunction) {
        this.f10588ad = observableSource;
        this.f10589th = biFunction;
    }

    public void fe(MaybeObserver<? super T> maybeObserver) {
        this.f10588ad.subscribe(new qw(maybeObserver, this.f10589th));
    }
}
