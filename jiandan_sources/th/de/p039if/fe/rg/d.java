package th.de.p039if.fe.rg;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.FuseToObservable;
import java.util.NoSuchElementException;
import th.de.rg;
import th.de.yj;

/* renamed from: th.de.if.fe.rg.d  reason: invalid package */
public final class d<T> extends yj<T> implements FuseToObservable<T> {

    /* renamed from: ad  reason: collision with root package name */
    public final ObservableSource<T> f10554ad;

    /* renamed from: th  reason: collision with root package name */
    public final long f10555th;

    /* renamed from: yj  reason: collision with root package name */
    public final T f10556yj;

    /* renamed from: th.de.if.fe.rg.d$qw */
    public static final class qw<T> implements Observer<T>, Disposable {

        /* renamed from: ad  reason: collision with root package name */
        public final SingleObserver<? super T> f10557ad;

        /* renamed from: i  reason: collision with root package name */
        public long f10558i;

        /* renamed from: o  reason: collision with root package name */
        public boolean f10559o;

        /* renamed from: th  reason: collision with root package name */
        public final long f10560th;

        /* renamed from: uk  reason: collision with root package name */
        public Disposable f10561uk;

        /* renamed from: yj  reason: collision with root package name */
        public final T f10562yj;

        public qw(SingleObserver<? super T> singleObserver, long j, T t) {
            this.f10557ad = singleObserver;
            this.f10560th = j;
            this.f10562yj = t;
        }

        public void dispose() {
            this.f10561uk.dispose();
        }

        public boolean isDisposed() {
            return this.f10561uk.isDisposed();
        }

        public void onComplete() {
            if (!this.f10559o) {
                this.f10559o = true;
                T t = this.f10562yj;
                if (t != null) {
                    this.f10557ad.onSuccess(t);
                } else {
                    this.f10557ad.onError(new NoSuchElementException());
                }
            }
        }

        public void onError(Throwable th2) {
            if (this.f10559o) {
                th.de.ppp.qw.ddd(th2);
                return;
            }
            this.f10559o = true;
            this.f10557ad.onError(th2);
        }

        public void onNext(T t) {
            if (!this.f10559o) {
                long j = this.f10558i;
                if (j == this.f10560th) {
                    this.f10559o = true;
                    this.f10561uk.dispose();
                    this.f10557ad.onSuccess(t);
                    return;
                }
                this.f10558i = j + 1;
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f10561uk, disposable)) {
                this.f10561uk = disposable;
                this.f10557ad.onSubscribe(this);
            }
        }
    }

    public d(ObservableSource<T> observableSource, long j, T t) {
        this.f10554ad = observableSource;
        this.f10555th = j;
        this.f10556yj = t;
    }

    public rg<T> ad() {
        return th.de.ppp.qw.when(new b(this.f10554ad, this.f10555th, this.f10556yj, true));
    }

    public void rg(SingleObserver<? super T> singleObserver) {
        this.f10554ad.subscribe(new qw(singleObserver, this.f10555th, this.f10556yj));
    }
}
