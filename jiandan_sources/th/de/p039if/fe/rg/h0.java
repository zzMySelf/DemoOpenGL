package th.de.p039if.fe.rg;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.disposables.DisposableHelper;

/* renamed from: th.de.if.fe.rg.h0  reason: invalid package */
public final class h0<T> extends qw<T, T> {

    /* renamed from: th  reason: collision with root package name */
    public final BiFunction<T, T, T> f10630th;

    /* renamed from: th.de.if.fe.rg.h0$qw */
    public static final class qw<T> implements Observer<T>, Disposable {

        /* renamed from: ad  reason: collision with root package name */
        public final Observer<? super T> f10631ad;

        /* renamed from: i  reason: collision with root package name */
        public boolean f10632i;

        /* renamed from: th  reason: collision with root package name */
        public final BiFunction<T, T, T> f10633th;

        /* renamed from: uk  reason: collision with root package name */
        public T f10634uk;

        /* renamed from: yj  reason: collision with root package name */
        public Disposable f10635yj;

        public qw(Observer<? super T> observer, BiFunction<T, T, T> biFunction) {
            this.f10631ad = observer;
            this.f10633th = biFunction;
        }

        public void dispose() {
            this.f10635yj.dispose();
        }

        public boolean isDisposed() {
            return this.f10635yj.isDisposed();
        }

        public void onComplete() {
            if (!this.f10632i) {
                this.f10632i = true;
                this.f10631ad.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (this.f10632i) {
                th.de.ppp.qw.ddd(th2);
                return;
            }
            this.f10632i = true;
            this.f10631ad.onError(th2);
        }

        public void onNext(T t) {
            if (!this.f10632i) {
                Observer<? super T> observer = this.f10631ad;
                T t2 = this.f10634uk;
                if (t2 == null) {
                    this.f10634uk = t;
                    observer.onNext(t);
                    return;
                }
                try {
                    T apply = this.f10633th.apply(t2, t);
                    th.de.p039if.ad.qw.rg(apply, "The value returned by the accumulator is null");
                    this.f10634uk = apply;
                    observer.onNext(apply);
                } catch (Throwable th2) {
                    th.de.o.qw.ad(th2);
                    this.f10635yj.dispose();
                    onError(th2);
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f10635yj, disposable)) {
                this.f10635yj = disposable;
                this.f10631ad.onSubscribe(this);
            }
        }
    }

    public h0(ObservableSource<T> observableSource, BiFunction<T, T, T> biFunction) {
        super(observableSource);
        this.f10630th = biFunction;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f10756ad.subscribe(new qw(observer, this.f10630th));
    }
}
