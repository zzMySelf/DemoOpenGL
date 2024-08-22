package th.de.p039if.de;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import th.de.o.qw;

/* renamed from: th.de.if.de.yj  reason: invalid package */
public final class yj<T> implements Observer<T>, Disposable {

    /* renamed from: ad  reason: collision with root package name */
    public final Observer<? super T> f10489ad;

    /* renamed from: th  reason: collision with root package name */
    public final Consumer<? super Disposable> f10490th;

    /* renamed from: uk  reason: collision with root package name */
    public Disposable f10491uk;

    /* renamed from: yj  reason: collision with root package name */
    public final Action f10492yj;

    public yj(Observer<? super T> observer, Consumer<? super Disposable> consumer, Action action) {
        this.f10489ad = observer;
        this.f10490th = consumer;
        this.f10492yj = action;
    }

    public void dispose() {
        Disposable disposable = this.f10491uk;
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (disposable != disposableHelper) {
            this.f10491uk = disposableHelper;
            try {
                this.f10492yj.run();
            } catch (Throwable th2) {
                qw.ad(th2);
                th.de.ppp.qw.ddd(th2);
            }
            disposable.dispose();
        }
    }

    public boolean isDisposed() {
        return this.f10491uk.isDisposed();
    }

    public void onComplete() {
        Disposable disposable = this.f10491uk;
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (disposable != disposableHelper) {
            this.f10491uk = disposableHelper;
            this.f10489ad.onComplete();
        }
    }

    public void onError(Throwable th2) {
        Disposable disposable = this.f10491uk;
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (disposable != disposableHelper) {
            this.f10491uk = disposableHelper;
            this.f10489ad.onError(th2);
            return;
        }
        th.de.ppp.qw.ddd(th2);
    }

    public void onNext(T t) {
        this.f10489ad.onNext(t);
    }

    public void onSubscribe(Disposable disposable) {
        try {
            this.f10490th.accept(disposable);
            if (DisposableHelper.validate(this.f10491uk, disposable)) {
                this.f10491uk = disposable;
                this.f10489ad.onSubscribe(this);
            }
        } catch (Throwable th2) {
            qw.ad(th2);
            disposable.dispose();
            this.f10491uk = DisposableHelper.DISPOSED;
            EmptyDisposable.error(th2, (Observer<?>) this.f10489ad);
        }
    }
}
