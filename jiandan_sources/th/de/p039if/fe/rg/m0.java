package th.de.p039if.fe.rg;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

/* renamed from: th.de.if.fe.rg.m0  reason: invalid package */
public final class m0<T> extends qw<T, T> {

    /* renamed from: th  reason: collision with root package name */
    public final long f10685th;

    /* renamed from: th.de.if.fe.rg.m0$qw */
    public static final class qw<T> implements Observer<T>, Disposable {

        /* renamed from: ad  reason: collision with root package name */
        public final Observer<? super T> f10686ad;

        /* renamed from: th  reason: collision with root package name */
        public long f10687th;

        /* renamed from: yj  reason: collision with root package name */
        public Disposable f10688yj;

        public qw(Observer<? super T> observer, long j) {
            this.f10686ad = observer;
            this.f10687th = j;
        }

        public void dispose() {
            this.f10688yj.dispose();
        }

        public boolean isDisposed() {
            return this.f10688yj.isDisposed();
        }

        public void onComplete() {
            this.f10686ad.onComplete();
        }

        public void onError(Throwable th2) {
            this.f10686ad.onError(th2);
        }

        public void onNext(T t) {
            long j = this.f10687th;
            if (j != 0) {
                this.f10687th = j - 1;
            } else {
                this.f10686ad.onNext(t);
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f10688yj, disposable)) {
                this.f10688yj = disposable;
                this.f10686ad.onSubscribe(this);
            }
        }
    }

    public m0(ObservableSource<T> observableSource, long j) {
        super(observableSource);
        this.f10685th = j;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f10756ad.subscribe(new qw(observer, this.f10685th));
    }
}
