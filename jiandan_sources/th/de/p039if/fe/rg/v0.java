package th.de.p039if.fe.rg;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.Functions;
import java.util.Collection;
import java.util.concurrent.Callable;

/* renamed from: th.de.if.fe.rg.v0  reason: invalid package */
public final class v0<T, U extends Collection<? super T>> extends qw<T, U> {

    /* renamed from: th  reason: collision with root package name */
    public final Callable<U> f10826th;

    /* renamed from: th.de.if.fe.rg.v0$qw */
    public static final class qw<T, U extends Collection<? super T>> implements Observer<T>, Disposable {

        /* renamed from: ad  reason: collision with root package name */
        public final Observer<? super U> f10827ad;

        /* renamed from: th  reason: collision with root package name */
        public Disposable f10828th;

        /* renamed from: yj  reason: collision with root package name */
        public U f10829yj;

        public qw(Observer<? super U> observer, U u) {
            this.f10827ad = observer;
            this.f10829yj = u;
        }

        public void dispose() {
            this.f10828th.dispose();
        }

        public boolean isDisposed() {
            return this.f10828th.isDisposed();
        }

        public void onComplete() {
            U u = this.f10829yj;
            this.f10829yj = null;
            this.f10827ad.onNext(u);
            this.f10827ad.onComplete();
        }

        public void onError(Throwable th2) {
            this.f10829yj = null;
            this.f10827ad.onError(th2);
        }

        public void onNext(T t) {
            this.f10829yj.add(t);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f10828th, disposable)) {
                this.f10828th = disposable;
                this.f10827ad.onSubscribe(this);
            }
        }
    }

    public v0(ObservableSource<T> observableSource, int i2) {
        super(observableSource);
        this.f10826th = Functions.rg(i2);
    }

    public void subscribeActual(Observer<? super U> observer) {
        try {
            U call = this.f10826th.call();
            th.de.p039if.ad.qw.rg(call, "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.");
            this.f10756ad.subscribe(new qw(observer, (Collection) call));
        } catch (Throwable th2) {
            th.de.o.qw.ad(th2);
            EmptyDisposable.error(th2, (Observer<?>) observer);
        }
    }

    public v0(ObservableSource<T> observableSource, Callable<U> callable) {
        super(observableSource);
        this.f10826th = callable;
    }
}
