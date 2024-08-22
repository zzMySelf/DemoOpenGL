package th.de.p039if.fe.rg;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;

/* renamed from: th.de.if.fe.rg.i0  reason: invalid package */
public final class i0<T, R> extends qw<T, R> {

    /* renamed from: th  reason: collision with root package name */
    public final BiFunction<R, ? super T, R> f10636th;

    /* renamed from: yj  reason: collision with root package name */
    public final Callable<R> f10637yj;

    /* renamed from: th.de.if.fe.rg.i0$qw */
    public static final class qw<T, R> implements Observer<T>, Disposable {

        /* renamed from: ad  reason: collision with root package name */
        public final Observer<? super R> f10638ad;

        /* renamed from: i  reason: collision with root package name */
        public boolean f10639i;

        /* renamed from: th  reason: collision with root package name */
        public final BiFunction<R, ? super T, R> f10640th;

        /* renamed from: uk  reason: collision with root package name */
        public Disposable f10641uk;

        /* renamed from: yj  reason: collision with root package name */
        public R f10642yj;

        public qw(Observer<? super R> observer, BiFunction<R, ? super T, R> biFunction, R r) {
            this.f10638ad = observer;
            this.f10640th = biFunction;
            this.f10642yj = r;
        }

        public void dispose() {
            this.f10641uk.dispose();
        }

        public boolean isDisposed() {
            return this.f10641uk.isDisposed();
        }

        public void onComplete() {
            if (!this.f10639i) {
                this.f10639i = true;
                this.f10638ad.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (this.f10639i) {
                th.de.ppp.qw.ddd(th2);
                return;
            }
            this.f10639i = true;
            this.f10638ad.onError(th2);
        }

        public void onNext(T t) {
            if (!this.f10639i) {
                try {
                    R apply = this.f10640th.apply(this.f10642yj, t);
                    th.de.p039if.ad.qw.rg(apply, "The accumulator returned a null value");
                    this.f10642yj = apply;
                    this.f10638ad.onNext(apply);
                } catch (Throwable th2) {
                    th.de.o.qw.ad(th2);
                    this.f10641uk.dispose();
                    onError(th2);
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f10641uk, disposable)) {
                this.f10641uk = disposable;
                this.f10638ad.onSubscribe(this);
                this.f10638ad.onNext(this.f10642yj);
            }
        }
    }

    public i0(ObservableSource<T> observableSource, Callable<R> callable, BiFunction<R, ? super T, R> biFunction) {
        super(observableSource);
        this.f10636th = biFunction;
        this.f10637yj = callable;
    }

    public void subscribeActual(Observer<? super R> observer) {
        try {
            R call = this.f10637yj.call();
            th.de.p039if.ad.qw.rg(call, "The seed supplied is null");
            this.f10756ad.subscribe(new qw(observer, this.f10636th, call));
        } catch (Throwable th2) {
            th.de.o.qw.ad(th2);
            EmptyDisposable.error(th2, (Observer<?>) observer);
        }
    }
}
