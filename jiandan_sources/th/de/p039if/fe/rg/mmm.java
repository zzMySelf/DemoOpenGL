package th.de.p039if.fe.rg;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import th.de.fe;

/* renamed from: th.de.if.fe.rg.mmm  reason: invalid package */
public final class mmm<T, R> extends qw<T, R> {

    /* renamed from: th  reason: collision with root package name */
    public final Function<? super T, ? extends fe<R>> f10689th;

    /* renamed from: th.de.if.fe.rg.mmm$qw */
    public static final class qw<T, R> implements Observer<T>, Disposable {

        /* renamed from: ad  reason: collision with root package name */
        public final Observer<? super R> f10690ad;

        /* renamed from: th  reason: collision with root package name */
        public final Function<? super T, ? extends fe<R>> f10691th;

        /* renamed from: uk  reason: collision with root package name */
        public Disposable f10692uk;

        /* renamed from: yj  reason: collision with root package name */
        public boolean f10693yj;

        public qw(Observer<? super R> observer, Function<? super T, ? extends fe<R>> function) {
            this.f10690ad = observer;
            this.f10691th = function;
        }

        public void dispose() {
            this.f10692uk.dispose();
        }

        public boolean isDisposed() {
            return this.f10692uk.isDisposed();
        }

        public void onComplete() {
            if (!this.f10693yj) {
                this.f10693yj = true;
                this.f10690ad.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (this.f10693yj) {
                th.de.ppp.qw.ddd(th2);
                return;
            }
            this.f10693yj = true;
            this.f10690ad.onError(th2);
        }

        public void onNext(T t) {
            if (!this.f10693yj) {
                try {
                    Object apply = this.f10691th.apply(t);
                    th.de.p039if.ad.qw.rg(apply, "The selector returned a null Notification");
                    fe feVar = (fe) apply;
                    if (feVar.yj()) {
                        this.f10692uk.dispose();
                        onError(feVar.fe());
                    } else if (feVar.th()) {
                        this.f10692uk.dispose();
                        onComplete();
                    } else {
                        this.f10690ad.onNext(feVar.rg());
                    }
                } catch (Throwable th2) {
                    th.de.o.qw.ad(th2);
                    this.f10692uk.dispose();
                    onError(th2);
                }
            } else if (t instanceof fe) {
                fe feVar2 = (fe) t;
                if (feVar2.yj()) {
                    th.de.ppp.qw.ddd(feVar2.fe());
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f10692uk, disposable)) {
                this.f10692uk = disposable;
                this.f10690ad.onSubscribe(this);
            }
        }
    }

    public mmm(ObservableSource<T> observableSource, Function<? super T, ? extends fe<R>> function) {
        super(observableSource);
        this.f10689th = function;
    }

    public void subscribeActual(Observer<? super R> observer) {
        this.f10756ad.subscribe(new qw(observer, this.f10689th));
    }
}
