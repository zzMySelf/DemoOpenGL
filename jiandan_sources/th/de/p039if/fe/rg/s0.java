package th.de.p039if.fe.rg;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.disposables.DisposableHelper;

/* renamed from: th.de.if.fe.rg.s0  reason: invalid package */
public final class s0<T> extends qw<T, T> {

    /* renamed from: th  reason: collision with root package name */
    public final Predicate<? super T> f10771th;

    /* renamed from: th.de.if.fe.rg.s0$qw */
    public static final class qw<T> implements Observer<T>, Disposable {

        /* renamed from: ad  reason: collision with root package name */
        public final Observer<? super T> f10772ad;

        /* renamed from: th  reason: collision with root package name */
        public final Predicate<? super T> f10773th;

        /* renamed from: uk  reason: collision with root package name */
        public boolean f10774uk;

        /* renamed from: yj  reason: collision with root package name */
        public Disposable f10775yj;

        public qw(Observer<? super T> observer, Predicate<? super T> predicate) {
            this.f10772ad = observer;
            this.f10773th = predicate;
        }

        public void dispose() {
            this.f10775yj.dispose();
        }

        public boolean isDisposed() {
            return this.f10775yj.isDisposed();
        }

        public void onComplete() {
            if (!this.f10774uk) {
                this.f10774uk = true;
                this.f10772ad.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (!this.f10774uk) {
                this.f10774uk = true;
                this.f10772ad.onError(th2);
                return;
            }
            th.de.ppp.qw.ddd(th2);
        }

        public void onNext(T t) {
            if (!this.f10774uk) {
                this.f10772ad.onNext(t);
                try {
                    if (this.f10773th.test(t)) {
                        this.f10774uk = true;
                        this.f10775yj.dispose();
                        this.f10772ad.onComplete();
                    }
                } catch (Throwable th2) {
                    th.de.o.qw.ad(th2);
                    this.f10775yj.dispose();
                    onError(th2);
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f10775yj, disposable)) {
                this.f10775yj = disposable;
                this.f10772ad.onSubscribe(this);
            }
        }
    }

    public s0(ObservableSource<T> observableSource, Predicate<? super T> predicate) {
        super(observableSource);
        this.f10771th = predicate;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f10756ad.subscribe(new qw(observer, this.f10771th));
    }
}
