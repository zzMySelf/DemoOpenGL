package th.de.p039if.fe.rg;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.EmptyComponent;

/* renamed from: th.de.if.fe.rg.aaa  reason: invalid package */
public final class aaa<T> extends qw<T, T> {

    /* renamed from: th.de.if.fe.rg.aaa$qw */
    public static final class qw<T> implements Observer<T>, Disposable {

        /* renamed from: ad  reason: collision with root package name */
        public Observer<? super T> f10522ad;

        /* renamed from: th  reason: collision with root package name */
        public Disposable f10523th;

        public qw(Observer<? super T> observer) {
            this.f10522ad = observer;
        }

        public void dispose() {
            Disposable disposable = this.f10523th;
            this.f10523th = EmptyComponent.INSTANCE;
            this.f10522ad = EmptyComponent.asObserver();
            disposable.dispose();
        }

        public boolean isDisposed() {
            return this.f10523th.isDisposed();
        }

        public void onComplete() {
            Observer<? super T> observer = this.f10522ad;
            this.f10523th = EmptyComponent.INSTANCE;
            this.f10522ad = EmptyComponent.asObserver();
            observer.onComplete();
        }

        public void onError(Throwable th2) {
            Observer<? super T> observer = this.f10522ad;
            this.f10523th = EmptyComponent.INSTANCE;
            this.f10522ad = EmptyComponent.asObserver();
            observer.onError(th2);
        }

        public void onNext(T t) {
            this.f10522ad.onNext(t);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f10523th, disposable)) {
                this.f10523th = disposable;
                this.f10522ad.onSubscribe(this);
            }
        }
    }

    public aaa(ObservableSource<T> observableSource) {
        super(observableSource);
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f10756ad.subscribe(new qw(observer));
    }
}
