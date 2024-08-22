package th.de.p039if.fe.rg;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiConsumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.fuseable.FuseToObservable;
import java.util.concurrent.Callable;
import th.de.rg;
import th.de.yj;

/* renamed from: th.de.if.fe.rg.when  reason: invalid package */
public final class when<T, U> extends yj<U> implements FuseToObservable<U> {

    /* renamed from: ad  reason: collision with root package name */
    public final ObservableSource<T> f10853ad;

    /* renamed from: th  reason: collision with root package name */
    public final Callable<? extends U> f10854th;

    /* renamed from: yj  reason: collision with root package name */
    public final BiConsumer<? super U, ? super T> f10855yj;

    /* renamed from: th.de.if.fe.rg.when$qw */
    public static final class qw<T, U> implements Observer<T>, Disposable {

        /* renamed from: ad  reason: collision with root package name */
        public final SingleObserver<? super U> f10856ad;

        /* renamed from: i  reason: collision with root package name */
        public boolean f10857i;

        /* renamed from: th  reason: collision with root package name */
        public final BiConsumer<? super U, ? super T> f10858th;

        /* renamed from: uk  reason: collision with root package name */
        public Disposable f10859uk;

        /* renamed from: yj  reason: collision with root package name */
        public final U f10860yj;

        public qw(SingleObserver<? super U> singleObserver, U u, BiConsumer<? super U, ? super T> biConsumer) {
            this.f10856ad = singleObserver;
            this.f10858th = biConsumer;
            this.f10860yj = u;
        }

        public void dispose() {
            this.f10859uk.dispose();
        }

        public boolean isDisposed() {
            return this.f10859uk.isDisposed();
        }

        public void onComplete() {
            if (!this.f10857i) {
                this.f10857i = true;
                this.f10856ad.onSuccess(this.f10860yj);
            }
        }

        public void onError(Throwable th2) {
            if (this.f10857i) {
                th.de.ppp.qw.ddd(th2);
                return;
            }
            this.f10857i = true;
            this.f10856ad.onError(th2);
        }

        public void onNext(T t) {
            if (!this.f10857i) {
                try {
                    this.f10858th.accept(this.f10860yj, t);
                } catch (Throwable th2) {
                    this.f10859uk.dispose();
                    onError(th2);
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f10859uk, disposable)) {
                this.f10859uk = disposable;
                this.f10856ad.onSubscribe(this);
            }
        }
    }

    public when(ObservableSource<T> observableSource, Callable<? extends U> callable, BiConsumer<? super U, ? super T> biConsumer) {
        this.f10853ad = observableSource;
        this.f10854th = callable;
        this.f10855yj = biConsumer;
    }

    public rg<U> ad() {
        return th.de.ppp.qw.when(new Cswitch(this.f10853ad, this.f10854th, this.f10855yj));
    }

    public void rg(SingleObserver<? super U> singleObserver) {
        try {
            Object call = this.f10854th.call();
            th.de.p039if.ad.qw.rg(call, "The initialSupplier returned a null value");
            this.f10853ad.subscribe(new qw(singleObserver, call, this.f10855yj));
        } catch (Throwable th2) {
            EmptyDisposable.error(th2, (SingleObserver<?>) singleObserver);
        }
    }
}
