package th.de.p039if.fe.rg;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.SequentialDisposable;

/* renamed from: th.de.if.fe.rg.p0  reason: invalid package */
public final class p0<T> extends qw<T, T> {

    /* renamed from: th  reason: collision with root package name */
    public final ObservableSource<? extends T> f10725th;

    /* renamed from: th.de.if.fe.rg.p0$qw */
    public static final class qw<T> implements Observer<T> {

        /* renamed from: ad  reason: collision with root package name */
        public final Observer<? super T> f10726ad;

        /* renamed from: th  reason: collision with root package name */
        public final ObservableSource<? extends T> f10727th;

        /* renamed from: uk  reason: collision with root package name */
        public boolean f10728uk = true;

        /* renamed from: yj  reason: collision with root package name */
        public final SequentialDisposable f10729yj = new SequentialDisposable();

        public qw(Observer<? super T> observer, ObservableSource<? extends T> observableSource) {
            this.f10726ad = observer;
            this.f10727th = observableSource;
        }

        public void onComplete() {
            if (this.f10728uk) {
                this.f10728uk = false;
                this.f10727th.subscribe(this);
                return;
            }
            this.f10726ad.onComplete();
        }

        public void onError(Throwable th2) {
            this.f10726ad.onError(th2);
        }

        public void onNext(T t) {
            if (this.f10728uk) {
                this.f10728uk = false;
            }
            this.f10726ad.onNext(t);
        }

        public void onSubscribe(Disposable disposable) {
            this.f10729yj.update(disposable);
        }
    }

    public p0(ObservableSource<T> observableSource, ObservableSource<? extends T> observableSource2) {
        super(observableSource);
        this.f10725th = observableSource2;
    }

    public void subscribeActual(Observer<? super T> observer) {
        qw qwVar = new qw(observer, this.f10725th);
        observer.onSubscribe(qwVar.f10729yj);
        this.f10756ad.subscribe(qwVar);
    }
}
