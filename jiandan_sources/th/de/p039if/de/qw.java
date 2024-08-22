package th.de.p039if.de;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.QueueDisposable;

/* renamed from: th.de.if.de.qw  reason: invalid package */
public abstract class qw<T, R> implements Observer<T>, QueueDisposable<R> {

    /* renamed from: ad  reason: collision with root package name */
    public final Observer<? super R> f10475ad;

    /* renamed from: i  reason: collision with root package name */
    public int f10476i;

    /* renamed from: th  reason: collision with root package name */
    public Disposable f10477th;

    /* renamed from: uk  reason: collision with root package name */
    public boolean f10478uk;

    /* renamed from: yj  reason: collision with root package name */
    public QueueDisposable<T> f10479yj;

    public qw(Observer<? super R> observer) {
        this.f10475ad = observer;
    }

    public boolean ad() {
        return true;
    }

    public void clear() {
        this.f10479yj.clear();
    }

    public final void de(Throwable th2) {
        th.de.o.qw.ad(th2);
        this.f10477th.dispose();
        onError(th2);
    }

    public void dispose() {
        this.f10477th.dispose();
    }

    public final int fe(int i2) {
        QueueDisposable<T> queueDisposable = this.f10479yj;
        if (queueDisposable == null || (i2 & 4) != 0) {
            return 0;
        }
        int requestFusion = queueDisposable.requestFusion(i2);
        if (requestFusion != 0) {
            this.f10476i = requestFusion;
        }
        return requestFusion;
    }

    public boolean isDisposed() {
        return this.f10477th.isDisposed();
    }

    public boolean isEmpty() {
        return this.f10479yj.isEmpty();
    }

    public final boolean offer(R r) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public void onComplete() {
        if (!this.f10478uk) {
            this.f10478uk = true;
            this.f10475ad.onComplete();
        }
    }

    public void onError(Throwable th2) {
        if (this.f10478uk) {
            th.de.ppp.qw.ddd(th2);
            return;
        }
        this.f10478uk = true;
        this.f10475ad.onError(th2);
    }

    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.f10477th, disposable)) {
            this.f10477th = disposable;
            if (disposable instanceof QueueDisposable) {
                this.f10479yj = (QueueDisposable) disposable;
            }
            if (ad()) {
                this.f10475ad.onSubscribe(this);
                qw();
            }
        }
    }

    public void qw() {
    }
}
