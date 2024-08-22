package th.de.p039if.fe.rg;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;

/* renamed from: th.de.if.fe.rg.d0  reason: invalid package */
public final class d0<T> extends qw<T, T> {

    /* renamed from: th  reason: collision with root package name */
    public final Function<? super Throwable, ? extends T> f10563th;

    /* renamed from: th.de.if.fe.rg.d0$qw */
    public static final class qw<T> implements Observer<T>, Disposable {

        /* renamed from: ad  reason: collision with root package name */
        public final Observer<? super T> f10564ad;

        /* renamed from: th  reason: collision with root package name */
        public final Function<? super Throwable, ? extends T> f10565th;

        /* renamed from: yj  reason: collision with root package name */
        public Disposable f10566yj;

        public qw(Observer<? super T> observer, Function<? super Throwable, ? extends T> function) {
            this.f10564ad = observer;
            this.f10565th = function;
        }

        public void dispose() {
            this.f10566yj.dispose();
        }

        public boolean isDisposed() {
            return this.f10566yj.isDisposed();
        }

        public void onComplete() {
            this.f10564ad.onComplete();
        }

        public void onError(Throwable th2) {
            try {
                Object apply = this.f10565th.apply(th2);
                if (apply == null) {
                    NullPointerException nullPointerException = new NullPointerException("The supplied value is null");
                    nullPointerException.initCause(th2);
                    this.f10564ad.onError(nullPointerException);
                    return;
                }
                this.f10564ad.onNext(apply);
                this.f10564ad.onComplete();
            } catch (Throwable th3) {
                th.de.o.qw.ad(th3);
                this.f10564ad.onError(new CompositeException(th2, th3));
            }
        }

        public void onNext(T t) {
            this.f10564ad.onNext(t);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f10566yj, disposable)) {
                this.f10566yj = disposable;
                this.f10564ad.onSubscribe(this);
            }
        }
    }

    public d0(ObservableSource<T> observableSource, Function<? super Throwable, ? extends T> function) {
        super(observableSource);
        this.f10563th = function;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f10756ad.subscribe(new qw(observer, this.f10563th));
    }
}
