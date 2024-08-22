package th.de.p039if.fe.rg;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiConsumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;

/* renamed from: th.de.if.fe.rg.switch  reason: invalid class name and invalid package */
public final class Cswitch<T, U> extends qw<T, U> {

    /* renamed from: th  reason: collision with root package name */
    public final Callable<? extends U> f10776th;

    /* renamed from: yj  reason: collision with root package name */
    public final BiConsumer<? super U, ? super T> f10777yj;

    /* renamed from: th.de.if.fe.rg.switch$qw */
    public static final class qw<T, U> implements Observer<T>, Disposable {

        /* renamed from: ad  reason: collision with root package name */
        public final Observer<? super U> f10778ad;

        /* renamed from: i  reason: collision with root package name */
        public boolean f10779i;

        /* renamed from: th  reason: collision with root package name */
        public final BiConsumer<? super U, ? super T> f10780th;

        /* renamed from: uk  reason: collision with root package name */
        public Disposable f10781uk;

        /* renamed from: yj  reason: collision with root package name */
        public final U f10782yj;

        public qw(Observer<? super U> observer, U u, BiConsumer<? super U, ? super T> biConsumer) {
            this.f10778ad = observer;
            this.f10780th = biConsumer;
            this.f10782yj = u;
        }

        public void dispose() {
            this.f10781uk.dispose();
        }

        public boolean isDisposed() {
            return this.f10781uk.isDisposed();
        }

        public void onComplete() {
            if (!this.f10779i) {
                this.f10779i = true;
                this.f10778ad.onNext(this.f10782yj);
                this.f10778ad.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (this.f10779i) {
                th.de.ppp.qw.ddd(th2);
                return;
            }
            this.f10779i = true;
            this.f10778ad.onError(th2);
        }

        public void onNext(T t) {
            if (!this.f10779i) {
                try {
                    this.f10780th.accept(this.f10782yj, t);
                } catch (Throwable th2) {
                    this.f10781uk.dispose();
                    onError(th2);
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f10781uk, disposable)) {
                this.f10781uk = disposable;
                this.f10778ad.onSubscribe(this);
            }
        }
    }

    public Cswitch(ObservableSource<T> observableSource, Callable<? extends U> callable, BiConsumer<? super U, ? super T> biConsumer) {
        super(observableSource);
        this.f10776th = callable;
        this.f10777yj = biConsumer;
    }

    public void subscribeActual(Observer<? super U> observer) {
        try {
            Object call = this.f10776th.call();
            th.de.p039if.ad.qw.rg(call, "The initialSupplier returned a null value");
            this.f10756ad.subscribe(new qw(observer, call, this.f10777yj));
        } catch (Throwable th2) {
            EmptyDisposable.error(th2, (Observer<?>) observer);
        }
    }
}
