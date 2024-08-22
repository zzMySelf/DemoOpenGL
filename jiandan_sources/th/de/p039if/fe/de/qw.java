package th.de.p039if.fe.de;

import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: th.de.if.fe.de.qw  reason: invalid package */
public final class qw<T> implements MaybeObserver<T> {

    /* renamed from: ad  reason: collision with root package name */
    public final AtomicReference<Disposable> f10514ad;

    /* renamed from: th  reason: collision with root package name */
    public final MaybeObserver<? super T> f10515th;

    public qw(AtomicReference<Disposable> atomicReference, MaybeObserver<? super T> maybeObserver) {
        this.f10514ad = atomicReference;
        this.f10515th = maybeObserver;
    }

    public void onComplete() {
        this.f10515th.onComplete();
    }

    public void onError(Throwable th2) {
        this.f10515th.onError(th2);
    }

    public void onSubscribe(Disposable disposable) {
        DisposableHelper.replace(this.f10514ad, disposable);
    }

    public void onSuccess(T t) {
        this.f10515th.onSuccess(t);
    }
}
