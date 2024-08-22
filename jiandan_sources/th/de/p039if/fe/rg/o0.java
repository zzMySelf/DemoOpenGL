package th.de.p039if.fe.rg;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.disposables.DisposableHelper;

/* renamed from: th.de.if.fe.rg.o0  reason: invalid package */
public final class o0<T> extends qw<T, T> {

    /* renamed from: th  reason: collision with root package name */
    public final Predicate<? super T> f10719th;

    /* renamed from: th.de.if.fe.rg.o0$qw */
    public static final class qw<T> implements Observer<T>, Disposable {

        /* renamed from: ad  reason: collision with root package name */
        public final Observer<? super T> f10720ad;

        /* renamed from: th  reason: collision with root package name */
        public final Predicate<? super T> f10721th;

        /* renamed from: uk  reason: collision with root package name */
        public boolean f10722uk;

        /* renamed from: yj  reason: collision with root package name */
        public Disposable f10723yj;

        public qw(Observer<? super T> observer, Predicate<? super T> predicate) {
            this.f10720ad = observer;
            this.f10721th = predicate;
        }

        public void dispose() {
            this.f10723yj.dispose();
        }

        public boolean isDisposed() {
            return this.f10723yj.isDisposed();
        }

        public void onComplete() {
            this.f10720ad.onComplete();
        }

        public void onError(Throwable th2) {
            this.f10720ad.onError(th2);
        }

        public void onNext(T t) {
            if (this.f10722uk) {
                this.f10720ad.onNext(t);
                return;
            }
            try {
                if (!this.f10721th.test(t)) {
                    this.f10722uk = true;
                    this.f10720ad.onNext(t);
                }
            } catch (Throwable th2) {
                th.de.o.qw.ad(th2);
                this.f10723yj.dispose();
                this.f10720ad.onError(th2);
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f10723yj, disposable)) {
                this.f10723yj = disposable;
                this.f10720ad.onSubscribe(this);
            }
        }
    }

    public o0(ObservableSource<T> observableSource, Predicate<? super T> predicate) {
        super(observableSource);
        this.f10719th = predicate;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f10756ad.subscribe(new qw(observer, this.f10719th));
    }
}
