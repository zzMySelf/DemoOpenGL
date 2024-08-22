package th.de.p039if.fe.rg;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.disposables.DisposableHelper;

/* renamed from: th.de.if.fe.rg.yj  reason: invalid package */
public final class yj<T> extends qw<T, Boolean> {

    /* renamed from: th  reason: collision with root package name */
    public final Predicate<? super T> f10888th;

    /* renamed from: th.de.if.fe.rg.yj$qw */
    public static final class qw<T> implements Observer<T>, Disposable {

        /* renamed from: ad  reason: collision with root package name */
        public final Observer<? super Boolean> f10889ad;

        /* renamed from: th  reason: collision with root package name */
        public final Predicate<? super T> f10890th;

        /* renamed from: uk  reason: collision with root package name */
        public boolean f10891uk;

        /* renamed from: yj  reason: collision with root package name */
        public Disposable f10892yj;

        public qw(Observer<? super Boolean> observer, Predicate<? super T> predicate) {
            this.f10889ad = observer;
            this.f10890th = predicate;
        }

        public void dispose() {
            this.f10892yj.dispose();
        }

        public boolean isDisposed() {
            return this.f10892yj.isDisposed();
        }

        public void onComplete() {
            if (!this.f10891uk) {
                this.f10891uk = true;
                this.f10889ad.onNext(Boolean.FALSE);
                this.f10889ad.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (this.f10891uk) {
                th.de.ppp.qw.ddd(th2);
                return;
            }
            this.f10891uk = true;
            this.f10889ad.onError(th2);
        }

        public void onNext(T t) {
            if (!this.f10891uk) {
                try {
                    if (this.f10890th.test(t)) {
                        this.f10891uk = true;
                        this.f10892yj.dispose();
                        this.f10889ad.onNext(Boolean.TRUE);
                        this.f10889ad.onComplete();
                    }
                } catch (Throwable th2) {
                    th.de.o.qw.ad(th2);
                    this.f10892yj.dispose();
                    onError(th2);
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f10892yj, disposable)) {
                this.f10892yj = disposable;
                this.f10889ad.onSubscribe(this);
            }
        }
    }

    public yj(ObservableSource<T> observableSource, Predicate<? super T> predicate) {
        super(observableSource);
        this.f10888th = predicate;
    }

    public void subscribeActual(Observer<? super Boolean> observer) {
        this.f10756ad.subscribe(new qw(observer, this.f10888th));
    }
}
