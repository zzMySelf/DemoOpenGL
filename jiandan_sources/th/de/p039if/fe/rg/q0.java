package th.de.p039if.fe.rg;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;

/* renamed from: th.de.if.fe.rg.q0  reason: invalid package */
public final class q0<T> extends qw<T, T> {

    /* renamed from: th  reason: collision with root package name */
    public final long f10747th;

    /* renamed from: th.de.if.fe.rg.q0$qw */
    public static final class qw<T> implements Observer<T>, Disposable {

        /* renamed from: ad  reason: collision with root package name */
        public final Observer<? super T> f10748ad;

        /* renamed from: th  reason: collision with root package name */
        public boolean f10749th;

        /* renamed from: uk  reason: collision with root package name */
        public long f10750uk;

        /* renamed from: yj  reason: collision with root package name */
        public Disposable f10751yj;

        public qw(Observer<? super T> observer, long j) {
            this.f10748ad = observer;
            this.f10750uk = j;
        }

        public void dispose() {
            this.f10751yj.dispose();
        }

        public boolean isDisposed() {
            return this.f10751yj.isDisposed();
        }

        public void onComplete() {
            if (!this.f10749th) {
                this.f10749th = true;
                this.f10751yj.dispose();
                this.f10748ad.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (this.f10749th) {
                th.de.ppp.qw.ddd(th2);
                return;
            }
            this.f10749th = true;
            this.f10751yj.dispose();
            this.f10748ad.onError(th2);
        }

        public void onNext(T t) {
            if (!this.f10749th) {
                long j = this.f10750uk;
                long j2 = j - 1;
                this.f10750uk = j2;
                if (j > 0) {
                    boolean z = j2 == 0;
                    this.f10748ad.onNext(t);
                    if (z) {
                        onComplete();
                    }
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f10751yj, disposable)) {
                this.f10751yj = disposable;
                if (this.f10750uk == 0) {
                    this.f10749th = true;
                    disposable.dispose();
                    EmptyDisposable.complete((Observer<?>) this.f10748ad);
                    return;
                }
                this.f10748ad.onSubscribe(this);
            }
        }
    }

    public q0(ObservableSource<T> observableSource, long j) {
        super(observableSource);
        this.f10747th = j;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f10756ad.subscribe(new qw(observer, this.f10747th));
    }
}
