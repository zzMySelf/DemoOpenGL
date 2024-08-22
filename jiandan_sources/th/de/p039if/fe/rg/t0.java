package th.de.p039if.fe.rg;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.disposables.DisposableHelper;

/* renamed from: th.de.if.fe.rg.t0  reason: invalid package */
public final class t0<T> extends qw<T, T> {

    /* renamed from: th  reason: collision with root package name */
    public final Predicate<? super T> f10786th;

    /* renamed from: th.de.if.fe.rg.t0$qw */
    public static final class qw<T> implements Observer<T>, Disposable {

        /* renamed from: ad  reason: collision with root package name */
        public final Observer<? super T> f10787ad;

        /* renamed from: th  reason: collision with root package name */
        public final Predicate<? super T> f10788th;

        /* renamed from: uk  reason: collision with root package name */
        public boolean f10789uk;

        /* renamed from: yj  reason: collision with root package name */
        public Disposable f10790yj;

        public qw(Observer<? super T> observer, Predicate<? super T> predicate) {
            this.f10787ad = observer;
            this.f10788th = predicate;
        }

        public void dispose() {
            this.f10790yj.dispose();
        }

        public boolean isDisposed() {
            return this.f10790yj.isDisposed();
        }

        public void onComplete() {
            if (!this.f10789uk) {
                this.f10789uk = true;
                this.f10787ad.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (this.f10789uk) {
                th.de.ppp.qw.ddd(th2);
                return;
            }
            this.f10789uk = true;
            this.f10787ad.onError(th2);
        }

        public void onNext(T t) {
            if (!this.f10789uk) {
                try {
                    if (!this.f10788th.test(t)) {
                        this.f10789uk = true;
                        this.f10790yj.dispose();
                        this.f10787ad.onComplete();
                        return;
                    }
                    this.f10787ad.onNext(t);
                } catch (Throwable th2) {
                    th.de.o.qw.ad(th2);
                    this.f10790yj.dispose();
                    onError(th2);
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f10790yj, disposable)) {
                this.f10790yj = disposable;
                this.f10787ad.onSubscribe(this);
            }
        }
    }

    public t0(ObservableSource<T> observableSource, Predicate<? super T> predicate) {
        super(observableSource);
        this.f10786th = predicate;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f10756ad.subscribe(new qw(observer, this.f10786th));
    }
}
