package th.de.when;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import th.de.o.qw;

public final class de<T> implements Observer<T>, Disposable {

    /* renamed from: ad  reason: collision with root package name */
    public final Observer<? super T> f11035ad;

    /* renamed from: th  reason: collision with root package name */
    public Disposable f11036th;

    /* renamed from: yj  reason: collision with root package name */
    public boolean f11037yj;

    public de(Observer<? super T> observer) {
        this.f11035ad = observer;
    }

    public void ad() {
        this.f11037yj = true;
        NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
        try {
            this.f11035ad.onSubscribe(EmptyDisposable.INSTANCE);
            try {
                this.f11035ad.onError(nullPointerException);
            } catch (Throwable th2) {
                qw.ad(th2);
                th.de.ppp.qw.ddd(new CompositeException(nullPointerException, th2));
            }
        } catch (Throwable th3) {
            qw.ad(th3);
            th.de.ppp.qw.ddd(new CompositeException(nullPointerException, th3));
        }
    }

    public void dispose() {
        this.f11036th.dispose();
    }

    public boolean isDisposed() {
        return this.f11036th.isDisposed();
    }

    public void onComplete() {
        if (!this.f11037yj) {
            this.f11037yj = true;
            if (this.f11036th == null) {
                qw();
                return;
            }
            try {
                this.f11035ad.onComplete();
            } catch (Throwable th2) {
                qw.ad(th2);
                th.de.ppp.qw.ddd(th2);
            }
        }
    }

    public void onError(Throwable th2) {
        if (this.f11037yj) {
            th.de.ppp.qw.ddd(th2);
            return;
        }
        this.f11037yj = true;
        if (this.f11036th == null) {
            NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
            try {
                this.f11035ad.onSubscribe(EmptyDisposable.INSTANCE);
                try {
                    this.f11035ad.onError(new CompositeException(th2, nullPointerException));
                } catch (Throwable th3) {
                    qw.ad(th3);
                    th.de.ppp.qw.ddd(new CompositeException(th2, nullPointerException, th3));
                }
            } catch (Throwable th4) {
                qw.ad(th4);
                th.de.ppp.qw.ddd(new CompositeException(th2, nullPointerException, th4));
            }
        } else {
            if (th2 == null) {
                th2 = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            try {
                this.f11035ad.onError(th2);
            } catch (Throwable th5) {
                qw.ad(th5);
                th.de.ppp.qw.ddd(new CompositeException(th2, th5));
            }
        }
    }

    public void onNext(T t) {
        if (!this.f11037yj) {
            if (this.f11036th == null) {
                ad();
            } else if (t == null) {
                NullPointerException nullPointerException = new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
                try {
                    this.f11036th.dispose();
                    onError(nullPointerException);
                } catch (Throwable th2) {
                    qw.ad(th2);
                    onError(new CompositeException(nullPointerException, th2));
                }
            } else {
                try {
                    this.f11035ad.onNext(t);
                } catch (Throwable th3) {
                    qw.ad(th3);
                    onError(new CompositeException(th, th3));
                }
            }
        }
    }

    public void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.f11036th, disposable)) {
            this.f11036th = disposable;
            try {
                this.f11035ad.onSubscribe(this);
            } catch (Throwable th2) {
                qw.ad(th2);
                th.de.ppp.qw.ddd(new CompositeException(th, th2));
            }
        }
    }

    public void qw() {
        NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
        try {
            this.f11035ad.onSubscribe(EmptyDisposable.INSTANCE);
            try {
                this.f11035ad.onError(nullPointerException);
            } catch (Throwable th2) {
                qw.ad(th2);
                th.de.ppp.qw.ddd(new CompositeException(nullPointerException, th2));
            }
        } catch (Throwable th3) {
            qw.ad(th3);
            th.de.ppp.qw.ddd(new CompositeException(nullPointerException, th3));
        }
    }
}
