package th.de.p039if.fe.th;

import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: th.de.if.fe.th.qw  reason: invalid package */
public final class qw<R> implements MaybeObserver<R> {

    /* renamed from: ad  reason: collision with root package name */
    public final AtomicReference<Disposable> f10913ad;

    /* renamed from: th  reason: collision with root package name */
    public final MaybeObserver<? super R> f10914th;

    public qw(AtomicReference<Disposable> atomicReference, MaybeObserver<? super R> maybeObserver) {
        this.f10913ad = atomicReference;
        this.f10914th = maybeObserver;
    }

    public void onComplete() {
        this.f10914th.onComplete();
    }

    public void onError(Throwable th2) {
        this.f10914th.onError(th2);
    }

    public void onSubscribe(Disposable disposable) {
        DisposableHelper.replace(this.f10913ad, disposable);
    }

    public void onSuccess(R r) {
        this.f10914th.onSuccess(r);
    }
}
